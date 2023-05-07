package ken.util;

import java.util.Arrays;

public class Namespace{
    public static final String NAMESPACE_SEPARATOR = ":";
    public static final String PATH_SEPARATOR = "/";

    public static String of(String namespace, String... path){
        if(!namespace.matches("\\w+"))throw new IllegalArgumentException(String.format("Invalid namespace: %s", namespace));
        if(path.length == 0)throw new IllegalArgumentException("Empty path given");

        StringBuilder str = new StringBuilder(namespace);
        str.append(NAMESPACE_SEPARATOR);

        boolean firstItem = true;
        for(String subpath : path){
            if(!subpath.matches("\\w+"))throw new IllegalArgumentException(String.format("Invalid path: %s", subpath));
            if(!firstItem)str.append(PATH_SEPARATOR);
            str.append(subpath);
            firstItem = false;
        }

        return str.toString();
    }
}
