package ken.backend.plugin;

import ken.backend.Vars;

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
        plugins.put(Vars.DEFAULT_NAMESPACE, new Plugin(){
            @Override
            public String namespace(){
                return Vars.DEFAULT_NAMESPACE;
            }

            @Override
            public String displayName(){
                return "KEN-Totalitas Base";
            }
        });
    }

    public static Plugin get(String namespace){
        return plugins.get(namespace);
    }

    @SuppressWarnings("unchecked")
    public static void addFromArchive(JarFile jar) throws Exception{
        System.out.printf("Loading plugins from %s%n", jar.getName());

        // Initialize collections of relevant items
        List<Plugin> pluginInstances = new ArrayList<>();
        List<Method> pluginCalls = new ArrayList<>();
        // List<Method> pluginSettingsCallbacks = new ArrayList<>();

        // Create a classloader instance
        URL[] urls = { new URL("jar:file:" + jar.getName() + "!/") };
        ClassLoader cl = URLClassLoader.newInstance(urls);

        // Enumerate through classes and collect items
        Enumeration<JarEntry> entries = jar.entries();
        while(entries.hasMoreElements()){
            JarEntry entry = entries.nextElement();
            if(entry.getName().endsWith(".class")){
                String className = entry.getName().replace("/", ".").substring(0, entry.getName().length() - 6);
                Class<?> clazz = cl.loadClass(className);
                System.out.printf("Scanning class %s...%n", clazz.getName());

                // Load Plugin class
                if(Plugin.class.isAssignableFrom(clazz)){
                    Class<? extends Plugin> pluginClazz = (Class<? extends Plugin>)clazz;
                    Plugin p = pluginClazz.getConstructor().newInstance();

                    if(plugins.containsKey(p.namespace()))System.out.printf("Plugin %s (%s) already exists%n", p.namespace(), p.displayName());
                    System.out.printf("Loading plugin %s (%s)%n", p.namespace(), p.displayName());
                    plugins.put(p.namespace(), p);
                }

                // Collect function calls
                for(Method method : clazz.getMethods()){
                    if(method.isAnnotationPresent(CallOnLoad.class)){
                        System.out.printf("Scanning method %s...%n", method.getName());
                        if(method.getParameterCount() != 0){
                            System.out.printf("Reject method %s as it accepts arguments%n", method.getName());
                        }else if(!Modifier.isStatic(method.getModifiers())){
                            System.out.printf("Reject method %s as it is not a static method%n", method.getName());
                        }else{
                            System.out.printf("Registering method %s for post-load call%n", method.getName());
                            pluginCalls.add(method);
                        }
                    }
                }
            }
        }

        System.out.println("Invoking post-load methods...");
        for(Method method : pluginCalls){
            System.out.printf("Invoking %s%n", method.getName());
            method.invoke(null);
        }

        System.out.printf("Plugins from %s%n successfully loaded", jar.getName());
    }
}
