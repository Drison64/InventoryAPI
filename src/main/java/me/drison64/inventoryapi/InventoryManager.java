package me.drison64.inventoryapi;

import me.drison64.inventoryapi.properties.InventoryProperty;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InventoryManager {

    private final HashMap<Player, CustomInventory> registeredPlayers;
    private final HashMap<CustomInventory, List<InventoryProperty>> registeredProperties;

    public InventoryManager() {
        registeredPlayers = new HashMap<>();
        registeredProperties = new HashMap<>();
    }

    public Inventory open(CustomInventory inventory, Player player, InventoryProperty... inventoryProperties) {
        if (registeredPlayers.get(player) != null && inventory.getClass() == registeredPlayers.get(player).getClass()) inventory.setClose(false);
        registeredPlayers.put(player, inventory);
        for (InventoryProperty inventoryProperty : inventoryProperties) {
            registerProperty(inventory, inventoryProperty);
        }
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

    public void registerProperty(CustomInventory customInventory, InventoryProperty property) {
        if (!(registeredProperties.containsKey(customInventory))) {
            registeredProperties.put(customInventory, new ArrayList<>());
        }
        registeredProperties.get(customInventory).add(property);
    }

    public HashMap<Player, CustomInventory> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public HashMap<CustomInventory, List<InventoryProperty>> getRegisteredProperties() {
        return registeredProperties;
    }

}
