package ken.backend.plugin;

import ken.backend.Vars;
import ken.gui.TabManager;
import ken.gui.tab.KENTab;
import ken.util.UID;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginManager{
    private final static Map<String, Plugin> plugins = new HashMap<>();

    public static void init(){
        plugins.clear();

        // Add builtin
        plugins.put(Vars.defaultNamespace, new Plugin(){
            @Override
            public String namespace(){
                return Vars.defaultNamespace;
            }

            @Override
            public String displayName(){
                return "KEN-Totalitas Builtin";
            }
        });
    }

    public static Plugin get(String namespace){
        return plugins.get(namespace);
    }

    public static Collection<Plugin> getAllPlugins(){
        return plugins.values();
    }

    @SuppressWarnings("unchecked")
    public static void addFromArchive(JarFile jar) throws Exception{
        System.out.printf("Loading plugin from %s%n", jar.getName());

        // Initialize collections of relevant items
        Plugin pluginInstance = null;
        Map<UID, Class<? extends KENTab>> pluginTabs = new HashMap<>();
        List<Method> pluginCalls = new ArrayList<>();
        // List<Method> pluginSettingsCallbacks = new ArrayList<>();

        // Create a classloader instance
        URL[] urls = {new URL("jar:file:" + jar.getName() + "!/")};
        ClassLoader cl = URLClassLoader.newInstance(urls);

        // Look for a plugin class to get namespace definition
        Enumeration<JarEntry> entries = jar.entries();
        while(entries.hasMoreElements()){
            JarEntry entry = entries.nextElement();
            if(entry.getName().endsWith(".class")){
                String className = entry.getName().replace("/", ".").substring(0, entry.getName().length() - 6);
                Class<?> clazz = cl.loadClass(className);

                // Search for plugin class
                if(Plugin.class.isAssignableFrom(clazz)){
                    if(pluginInstance != null){
                        throw new Exception("Invalid plugin JAR: Multiple plugin classes defined");
                    }
                    Class<? extends Plugin> pluginClazz = (Class<? extends Plugin>) clazz;
                    Plugin p = pluginClazz.getConstructor().newInstance();

                    if(plugins.containsKey(p.namespace())){
                        throw new Exception(String.format("Plugin %s (%s) already exists%n", p.namespace(), p.displayName()));
                    }
                    System.out.printf("  Collecting plugin %s (%s)%n", p.namespace(), p.displayName());
                    pluginInstance = p;
                }
            }
        }
        if(pluginInstance == null){
            throw new Exception("Invalid plugin JAR: No plugin class found");
        }

        String namespace = pluginInstance.namespace();

        // Enumerate through classes and collect items
        entries = jar.entries();
        while(entries.hasMoreElements()){
            JarEntry entry = entries.nextElement();
            if(entry.getName().endsWith(".class")){
                String className = entry.getName().replace("/", ".").substring(0, entry.getName().length() - 6);
                Class<?> clazz = cl.loadClass(className);

                // Load annotated content classes
                if(clazz.isAnnotationPresent(AddMenuTab.class)){
                    System.out.printf("  Scanning class %s...%n", clazz.getName());
                    String[] path = clazz.getAnnotation(AddMenuTab.class).path().split("/");
                    UID id = UID.of(namespace, path);

                    if(!KENTab.class.isAssignableFrom(clazz)){
                        System.out.printf("    Reject content %s as it does not implement %s%n", id, KENTab.class.getCanonicalName());
                    }else if(pluginTabs.containsKey(id)){
                        System.out.printf("    Reject content %s as another content with the same ID already exists%n", id);
                    }else{
                        System.out.printf("    Collecting content %s%n", id);
                        pluginTabs.put(id, (Class<? extends KENTab>) clazz);
                    }
                }

                // Collect function calls
                for(Method method : clazz.getMethods()){
                    if(method.isAnnotationPresent(CallOnLoad.class)){
                        System.out.printf("  Scanning method %s...%n", UID.of(namespace, method.getName()));
                        if(method.getParameterCount() != 0){
                            System.out.printf("    Reject method %s as it accepts arguments%n", UID.of(namespace, method.getName()));
                        }else if(!Modifier.isStatic(method.getModifiers())){
                            System.out.printf("    Reject method %s as it is not a static method%n", UID.of(namespace, method.getName()));
                        }else{
                            System.out.printf("    Collecting method %s for post-load call%n", UID.of(namespace, method.getName()));
                            pluginCalls.add(method);
                        }
                    }
                }
            }
        }

        System.out.printf("  Loading plugin %s (%s)...%n", namespace, pluginInstance.displayName());
        plugins.put(namespace, pluginInstance);

        System.out.println("  Adding collected contents:");
        for(Map.Entry<UID, Class<? extends KENTab>> pair : pluginTabs.entrySet()){
            System.out.printf("    Adding tab %s%n", pair.getKey());
            TabManager.add(pair.getKey(), pair.getValue());
        }

        System.out.printf("  Invoking post-load methods of %s...%n", namespace);
        for(Method method : pluginCalls){
            System.out.printf("    Invoking %s%n", UID.of(namespace, method.getName()));
            method.invoke(null);
        }

        System.out.printf("Plugin %s (%s) successfully loaded%n", namespace, pluginInstance.displayName());
    }
}
