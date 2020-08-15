package me.drison64.inventoryapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class CustomInventory {

    private HashMap<Integer, ItemStack> items;
    protected String title;
    protected String originalTitle;
    protected Integer size;
    protected InventoryType inventoryType;

    public CustomInventory() {
        this.items = new HashMap<>();
    }

    public CustomInventory(InventoryType inventoryType) {
        this.items = new HashMap<>();
        this.inventoryType = inventoryType;
    }

    public void set(Integer slot, ItemStack itemStack) {
        items.put(slot, itemStack);
    }

    public void fill(ItemStack itemStack, Integer maxSize) {
        for (int i = 0; i < maxSize; i++) {
            items.putIfAbsent(i, itemStack);
        }
    }

    public Inventory build() {
        synchronized (this) {
            init(items);
        }
        Inventory inventory;
        if (inventoryType == null) {
            inventory = Bukkit.createInventory(null, size, title);
        } else {
            inventory = Bukkit.createInventory(null, inventoryType, title);
        }
        for (int i = 0; i < size + 1; i++) {
            if (!(items.get(i) == null)) inventory.setItem(i, items.get(i));
        }
        items = null;
        return inventory;
    }

    protected abstract void init(HashMap<Integer, ItemStack> items);
    protected abstract void fire(Event e);
}
