package me.drison64.inventoryapi;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.util.HashMap;

public class InventoryManager {

    private HashMap<Player, CustomInventory> registeredPlayers;

    public InventoryManager() {
        registeredPlayers = new HashMap<>();
    }

    public void open(CustomInventory inventory, Player player) {
        registeredPlayers.put(player, inventory);
        player.openInventory(inventory.build());
    }

    public void fire(Player player, Event event) {
        registeredPlayers.get(player).fire(event);
    }

}
