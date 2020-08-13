package me.drison64.inventoryapi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerEvent;

public class EventListener implements Listener {

    private InventoryAPI inventoryAPI;

    public EventListener(InventoryAPI inventoryAPI) {
        this.inventoryAPI = inventoryAPI;
    }

    @EventHandler
    public void onEventa(PlayerEvent e) {
        inventoryAPI.getInventoryManager().fire(e.getPlayer(), e);
    }

    @EventHandler
    public void onEvents(InventoryClickEvent e) {
        inventoryAPI.getInventoryManager().fire((Player) e.getWhoClicked(), e);
    }

    @EventHandler
    public void onEventd(InventoryCloseEvent e) {
        inventoryAPI.getInventoryManager().fire((Player) e.getPlayer(), e);
    }

    @EventHandler
    public void onEventf(InventoryOpenEvent e) {
        inventoryAPI.getInventoryManager().fire((Player) e.getPlayer(), e);
    }

}
