package me.drison64.inventoryapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class InventoryAPI {

    private InventoryManager inventoryManager;

    public InventoryAPI() {

        inventoryManager = new InventoryManager();

    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

}
