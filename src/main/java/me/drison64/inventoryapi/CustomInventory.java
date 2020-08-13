package me.drison64.inventoryapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class CustomInventory {

    private HashMap<Integer, ItemStack> items;
    protected List<Player> playerList;
    protected String title;
    protected Integer size;
    protected InventoryType inventoryType;

    public CustomInventory() {
        this.items = new HashMap<>();
        this.playerList = new ArrayList<>();
        init(items);
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
        Inventory inventory;
        if (inventoryType == null) {
            inventory = Bukkit.createInventory(null, size, title);
        } else {
            inventory = Bukkit.createInventory(null, inventoryType, title);
        }
        for (int i = 0; i < size + 1; i++) {
            if (!(items.get(i) == null)) inventory.setItem(i, items.get(i));
        }
        return inventory;
    }

    protected abstract void init(HashMap<Integer, ItemStack> items);
    protected abstract void fire(Event e);
}
