package ken.backend.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface SettingsItem{
    String name();
}
