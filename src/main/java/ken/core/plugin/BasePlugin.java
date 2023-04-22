package ken.core.plugin;

/**
 * Base plugin class that acts as the entry-point to every KEN plugin.
 */
public abstract class BasePlugin{
    /**
     * Initialization method to be called when this plugin is loaded.
     */
    public abstract void init();
}
