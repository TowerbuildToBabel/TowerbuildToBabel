package me.thundergemios10.babelplugin.events;

import me.thundergemios10.babelplugin.BabelPlugin;
import me.thundergemios10.babelplugin.Functions;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    BabelPlugin plugin = BabelPlugin.getPlugin();
    Functions func = new Functions();
    int i = 0;

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getPlayer().getWorld().getName().equalsIgnoreCase("babel")) {
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
                    e.getPlayer().updateInventory();
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
                    e.getPlayer().updateInventory();
                }
                func.checktower(e.getPlayer());
            } else if (e.getBlock().getTypeId() == 76) {
                for (i = 0; i < plugin.playerblues.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerblues.get(i).getName())) {
                        for (i = 0; i < plugin.areablue.size(); i++) {
                            if (e.getBlock().getLocation().getBlockX() == plugin.areablue.get(i).getBlockX() && e.getBlock().getLocation().getBlockY() == plugin.areablue.get(i).getBlockY() && e.getBlock().getLocation().getBlockZ() == plugin.areablue.get(i).getBlockZ()) {
                                for (Player test : plugin.playerblue) {
                                    test.sendMessage(ChatColor.BLUE + "[BabelPlugin] " + e.getPlayer().getName() + " tried to sabotage his own team.");
                                }
                                e.setCancelled(true);
                                e.getPlayer().updateInventory();
                            }
                        }
                    }
                }
                for (i = 0; i < plugin.playerreds.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerreds.get(i).getName())) {
                        for (i = 0; i < plugin.areared.size(); i++) {
                            if (e.getBlock().getLocation().getBlockX() == plugin.areared.get(i).getBlockX() && e.getBlock().getLocation().getBlockY() == plugin.areared.get(i).getBlockY() && e.getBlock().getLocation().getBlockZ() == plugin.areared.get(i).getBlockZ()) {
                                for (Player test : plugin.playerred) {
                                    test.sendMessage(ChatColor.RED + "[BabelPlugin] " + e.getPlayer().getName() + " tried to sabotage his own team.");
                                }
                                e.setCancelled(true);
                                e.getPlayer().updateInventory();
                            }
                        }
                    }
                }

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
                    e.getPlayer().updateInventory();
                }
            } else {
                e.setCancelled(true);
            }
        }
    }
}
