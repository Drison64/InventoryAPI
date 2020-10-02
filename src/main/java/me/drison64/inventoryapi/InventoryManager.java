package me.drison64.inventoryapi;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class InventoryManager {

    private HashMap<Player, CustomInventory> registeredPlayers;
    private JavaPlugin plugin;

    public InventoryManager(JavaPlugin plugin) {
        registeredPlayers = new HashMap<>();
        this.plugin = plugin;
    }

    public Inventory open(CustomInventory inventory, Player player) {
        if (registeredPlayers.containsKey(player)) registeredPlayers.remove(player);
        registeredPlayers.put(player, inventory);
        Inventory inventory_ = inventory.build(player);
        player.openInventory(inventory_);
        return inventory_;
    }

    public void close(Player player, Boolean close) {
        registeredPlayers.remove(player);
        if (close) player.closeInventory();
    }

    public void close(Player player) {
        player.closeInventory();
        registeredPlayers.remove(player);
    }

    public void lastFire(Player player, Event event) {
        registeredPlayers.get(player).fire(event);
        registeredPlayers.remove(player);
    }

    public void fire(Player player, Event event) {
        registeredPlayers.get(player).fire(event);
    }

    public HashMap<Player, CustomInventory> getRegisteredPlayers() {
        return registeredPlayers;
    }
}
