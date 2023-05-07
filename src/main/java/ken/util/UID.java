package ken.util;

import lombok.Getter;

public class UID{
    public static final String NAMESPACE_SEPARATOR = ":";
    public static final String PATH_SEPARATOR = "/";

    @Getter
    private final String namespace;
    @Getter
    private final String path;

    private UID(String namespace, String... path){
        this.namespace = namespace;
        this.path = String.join(PATH_SEPARATOR, path);
    }

    public static UID of(String namespace, String... path){
        if(!namespace.matches("\\w+"))throw new IllegalArgumentException(String.format("Invalid namespace: %s", namespace));
        if(path.length == 0)throw new IllegalArgumentException("Cannot build namespace from an empty path");
        for(String subpath : path)if(!subpath.matches("\\w+"))throw new IllegalArgumentException(String.format("Invalid path: %s", subpath));

        return new UID(namespace, path);
    }

    public boolean namespaceEquals(UID other){
        return namespace.equals(other.namespace);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof UID){
            UID other = (UID)obj;
            return toString().equals(other.toString());
        }else return false;
    }

    @Override
    public int hashCode(){
        return toString().hashCode();
    }

    @Override
    public String toString(){
        return String.format("%s%s%s", namespace, NAMESPACE_SEPARATOR, path);
    }
}
