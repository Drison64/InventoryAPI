package me.drison64.inventoryapi;

import me.drison64.inventoryapi.properties.PropertyManager;
import me.drison64.inventoryapi.properties.RefreshProperty;
import org.bukkit.plugin.java.JavaPlugin;

public class InventoryAPI {

    private final InventoryManager inventoryManager;
    private final PropertyManager propertyManager;
    private final JavaPlugin plugin;

    public InventoryAPI(JavaPlugin plugin) {

        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(new EventListener(this), plugin);

        inventoryManager = new InventoryManager(this);

        propertyManager = new PropertyManager();
        propertyManager.register(new RefreshProperty(this));
        
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public PropertyManager getPropertyManager() {
        return propertyManager;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

}
