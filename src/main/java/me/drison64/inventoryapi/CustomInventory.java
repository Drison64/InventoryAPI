package me.drison64.inventoryapi;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CustomInventory {

    private Inventory inventory;

    public CustomInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void set(Integer slot, ItemStack itemStack) {
        inventory.setItem(slot, itemStack);
    }

    public void add(ItemStack itemStack) {
        inventory.addItem(itemStack);
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }

    public void fill(ItemStack itemStack) {
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i).getType() == Material.AIR) {
                inventory.setItem(i, itemStack);
            }
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
