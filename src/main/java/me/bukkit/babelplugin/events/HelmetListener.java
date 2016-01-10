package me.bukkit.babelplugin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;

public class HelmetListener implements Listener {

    @EventHandler
    public void Helmet(InventoryClickEvent e) {
        if (e.getWhoClicked().getWorld().getName().equalsIgnoreCase("babel")) {
            if (e.getSlotType() == SlotType.ARMOR) {
                e.setCancelled(true);
            }
        }
    }
}
