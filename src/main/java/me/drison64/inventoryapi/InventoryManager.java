package me.drison64.inventoryapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class InventoryManager {

    private HashMap<Player, CustomInventory> registeredPlayers;
    private JavaPlugin plugin;

    public InventoryManager(JavaPlugin plugin) {
        registeredPlayers = new HashMap<>();
        this.plugin = plugin;
    }

    public void open(CustomInventory inventory, Player player) {
        registeredPlayers.put(player, inventory);
        player.openInventory(inventory.build());
    }

    public void close(Player player, Boolean close) {
        if (close) player.closeInventory();
        registeredPlayers.remove(player);
    }

    public void close(Player player) {
        player.closeInventory();
        registeredPlayers.remove(player);
    }

    public void fire(Player player, Event event) {
        CustomInventory inventory = registeredPlayers.get(player);
        registeredPlayers.remove(player);
        inventory.fire(event);
    }

}
