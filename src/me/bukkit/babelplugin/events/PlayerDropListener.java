package me.bukkit.babelplugin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropListener implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (e.getPlayer().getWorld().getName().equalsIgnoreCase("babel")) {
            if (e.getItemDrop().getItemStack().getTypeId() != 12) {
                e.setCancelled(true);
            }
            e.getPlayer().updateInventory();
        }
    }
}
