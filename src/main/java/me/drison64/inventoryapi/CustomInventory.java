package me.drison64.inventoryapi;

import me.drison64.inventoryapi.properties.InventoryProperty;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class CustomInventory {

    private HashMap<Integer, ItemStack> items;
    private boolean close;
    protected String title;
    protected String originalTitle;
    protected int size;
    protected InventoryType inventoryType;
    protected Player player;
    protected Inventory inventory;
    protected InventoryProperty[] properties;

    public CustomInventory() {
        this.items = new HashMap<>();
        this.close = true;
    }

    public CustomInventory(InventoryType inventoryType) {
        this.items = new HashMap<>();
        this.close = true;
        this.inventoryType = inventoryType;
    }

    public void set(Integer slot, ItemStack itemStack) {
        items.put(slot, itemStack);
    }

    public void fill(ItemStack itemStack) {
        for (int i = 0; i < size; i++) {
            items.putIfAbsent(i, itemStack);
        }
    }

    public Inventory refresh() {
        Inventory inventory_ = null;
        inventory_ = build();
        player.getOpenInventory().getTopInventory().setContents(inventory.getContents());
        player.updateInventory();
        return inventory_;
    }

    public Inventory build() {
        return doBuild();
    }

    public Inventory build(Player player) {
        this.player = player;
        return doBuild();
    }

    public Inventory doBuild() {
        this.items = new HashMap<>();
        synchronized (this) {
            init(items);
        }
        Inventory inventory;
        if (inventoryType == null) {
            inventory = Bukkit.createInventory(null, size, title);
        } else {
            inventory = Bukkit.createInventory(null, inventoryType, title);
        }
        for (int i = 0; i < size; i++) {
            if (items.get(i) != null) inventory.setItem(i, items.get(i));
        }
        //items = null;
        this.inventory = inventory;
        return inventory;
    }

    public boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        this.close = close;
    }

    protected abstract void init(HashMap<Integer, ItemStack> items);
    protected abstract void fire(Event e);
}
