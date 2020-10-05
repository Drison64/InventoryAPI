package me.drison64.inventoryapi;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class InventoryManager {

    private final HashMap<Player, CustomInventory> registeredPlayers;

    public InventoryManager() {
        registeredPlayers = new HashMap<>();
    }

    public Inventory open(CustomInventory inventory, Player player) {
        if (!(registeredPlayers.get(player) == null))   if (inventory.getClass() == registeredPlayers.get(player).getClass())   inventory.setClose(false);
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
