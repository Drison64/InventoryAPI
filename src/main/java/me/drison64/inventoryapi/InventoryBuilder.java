package me.drison64.inventoryapi;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class InventoryBuilder {

    public static Inventory build(InventoryHolder owner, InventoryType type) {
        return Bukkit.createInventory(owner, type);
    }

    public static Inventory build(InventoryHolder owner, InventoryType type, String title) {
        return Bukkit.createInventory(owner, type, title);
    }

    public static Inventory build(InventoryHolder owner, Integer size) {
        return Bukkit.createInventory(owner, size);
    }

    public static Inventory build(InventoryHolder owner, Integer size, String title) {
        return Bukkit.createInventory(owner, size, title);
    }

}
