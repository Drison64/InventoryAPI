package me.drison64.inventoryapi;

import org.bukkit.plugin.java.JavaPlugin;

public class InventoryAPI {

    private InventoryManager inventoryManager;

    public InventoryAPI(JavaPlugin plugin) {

        plugin.getServer().getPluginManager().registerEvents(new EventListener(this), plugin);

        inventoryManager = new InventoryManager();

    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

}
