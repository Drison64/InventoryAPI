package me.drison64.inventoryapi.properties;

import me.drison64.inventoryapi.InventoryAPI;
import org.bukkit.Bukkit;
import java.util.List;

public class RefreshProperty extends Property {

    public RefreshProperty(InventoryAPI inventoryAPI) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(inventoryAPI.getPlugin(), () -> {

            inventoryAPI.getInventoryManager().getRegisteredPlayers().values().forEach(customInventory -> {
                List<InventoryProperty> inventory = inventoryAPI.getInventoryManager().getRegisteredProperties().get(customInventory);

                if (inventory.contains(InventoryProperty.Refresh)) {
                    customInventory.refresh();
                }

            });

        }, 0L, 20L);
    }

}
