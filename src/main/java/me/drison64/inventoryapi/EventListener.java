package me.drison64.inventoryapi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {

    private InventoryAPI inventoryAPI;

    public EventListener(InventoryAPI inventoryAPI) {
        this.inventoryAPI = inventoryAPI;
    }

    @EventHandler
    public void onEvent(PlayerQuitEvent e) {
        inventoryAPI.getInventoryManager().close(e.getPlayer(), false);
    }

    @EventHandler
    public void onEvent(InventoryClickEvent e) {
        inventoryAPI.getInventoryManager().fire((Player) e.getWhoClicked(), e);
    }

    @EventHandler
    public void onEvent(InventoryCloseEvent e) {
        inventoryAPI.getInventoryManager().fire((Player) e.getPlayer(), e);
    }

    @EventHandler
    public void onEvent(InventoryOpenEvent e) {
        inventoryAPI.getInventoryManager().fire((Player) e.getPlayer(), e);
    }

}
