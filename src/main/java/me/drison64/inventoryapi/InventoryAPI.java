package me.drison64.inventoryapi;

import org.bukkit.inventory.Inventory;

public class InventoryAPI {

    public CustomInventory create(Inventory inventory) {
        return new CustomInventory(inventory);
    }

}
