package me.bukkit.babelplugin.events;

import me.bukkit.babelplugin.BabelPlugin;
import me.bukkit.babelplugin.Functions;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    BabelPlugin plugin = BabelPlugin.getPlugin();
    Functions func = new Functions();

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.getPlayer().getWorld().getName().equalsIgnoreCase("babel")) {
            int i;
            Boolean tnt = false;
            Boolean sand = false;
            Boolean torch = false;

            if (e.getPlayer().isOp()) {
                return;
            }

            if (e.getBlock().getTypeId() == 46) {
                for (i = 0; i < plugin.playerblues.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerblues.get(i).getName())) {
                        tnt = true;
                    }
                }
                for (i = 0; i < plugin.playerreds.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerreds.get(i).getName())) {
                        tnt = true;
                    }
                }
                if (tnt == false) {
                    e.setCancelled(true);
                }
            } else if (e.getBlock().getTypeId() == 12) {
                for (i = 0; i < plugin.playerblueb.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerblueb.get(i).getName())) {
                        sand = true;
                    }
                }
                for (i = 0; i < plugin.playerredb.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerredb.get(i).getName())) {
                        sand = true;
                    }
                }
                if (sand == false) {
                    e.setCancelled(true);
                }
            } else if (e.getBlock().getTypeId() == 76) {
                for (i = 0; i < plugin.playerblues.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerblues.get(i).getName())) {
                        torch = true;
                    }
                }
                for (i = 0; i < plugin.playerreds.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerreds.get(i).getName())) {
                        torch = true;
                    }
                }
                if (torch == false) {
                    e.setCancelled(true);
                }
            } else {
                e.setCancelled(true);
            }
        }
    }
}
