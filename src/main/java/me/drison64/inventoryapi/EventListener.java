package me.drison64.inventoryapi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {

    private final InventoryAPI inventoryAPI;

    public EventListener(InventoryAPI inventoryAPI) {
        this.inventoryAPI = inventoryAPI;
    }

    @EventHandler
    public void onEvent(PlayerQuitEvent e) {
        if (inventoryAPI.getInventoryManager().getRegisteredPlayers().get((Player) e.getPlayer()) == null) return;
        inventoryAPI.getInventoryManager().lastFire((Player) e.getPlayer(), e);
    }

    @EventHandler
    public void onEvent(InventoryClickEvent e) {
        if (inventoryAPI.getInventoryManager().getRegisteredPlayers().get((Player) e.getWhoClicked()) == null) return;
        inventoryAPI.getInventoryManager().fire((Player) e.getWhoClicked(), e);
    }

    @EventHandler
    public void onEvent(InventoryCloseEvent e) {
        if (inventoryAPI.getInventoryManager().getRegisteredPlayers().get((Player) e.getPlayer()) == null) return;
        if (!(inventoryAPI.getInventoryManager().getRegisteredPlayers().get((Player) e.getPlayer()).isClose())) return;
        inventoryAPI.getInventoryManager().lastFire((Player) e.getPlayer(), e);
    }

    @EventHandler
    public void onEvent(InventoryOpenEvent e) {
        if (inventoryAPI.getInventoryManager().getRegisteredPlayers().get((Player) e.getPlayer()) == null) return;
        inventoryAPI.getInventoryManager().fire((Player) e.getPlayer(), e);
    }

}
