package me.thundergemios10.babelplugin.events;

import me.thundergemios10.babelplugin.BabelPlugin;
import config.ConfigIO;
import me.thundergemios10.babelplugin.Functions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.ItemStack;

public class ChangeWorld implements Listener {

    BabelPlugin plugin = BabelPlugin.getPlugin();
    Functions func = new Functions();
    ConfigIO io = new ConfigIO(plugin);

    @EventHandler
    public void changeWorld(PlayerChangedWorldEvent ev) {
        BabelPlugin plugin = BabelPlugin.getPlugin();
        if (ev.getPlayer().getWorld().getName().equalsIgnoreCase("babel")) {
            int i;
            io.generateLocations(ev.getPlayer());
            func.Area(ev.getPlayer());

            ev.getPlayer().getInventory().clear();
            ev.getPlayer().getInventory().setLeggings(new ItemStack(Material.AIR));
            ev.getPlayer().getInventory().setChestplate(new ItemStack(Material.AIR));
            ev.getPlayer().getInventory().setBoots(new ItemStack(Material.AIR));
            ev.getPlayer().getInventory().setHelmet(new ItemStack(Material.AIR));


            try {
                if (plugin.status.equalsIgnoreCase("join")) {
                    ev.getPlayer().teleport(plugin.lobby);
                    ev.getPlayer().getWorld().setPVP(false);
                } else if (plugin.status.equalsIgnoreCase("end")) {
                    ev.getPlayer().teleport(plugin.end);
                    ev.getPlayer().getWorld().setPVP(false);
                } else if (plugin.status.equalsIgnoreCase("play")) {
                    Boolean test = Boolean.valueOf(false);
                    for (i = 0; i < plugin.playerblue.size(); i++) {
                        if (ev.getPlayer().getName().equalsIgnoreCase(((Player) plugin.playerblue.get(i)).getName())) {
                            ev.getPlayer().teleport(plugin.spawnblue);
                            ev.getPlayer().getWorld().setPVP(true);
                            test = Boolean.valueOf(true);
                        }
                    }
                    for (i = 0; i < plugin.playerred.size(); i++) {
                        if (ev.getPlayer().getName().equalsIgnoreCase(((Player) plugin.playerred.get(i)).getName())) {
                            ev.getPlayer().teleport(plugin.spawnred);
                            ev.getPlayer().getWorld().setPVP(true);
                            test = Boolean.valueOf(true);
                        }
                    }
                    if (!test.booleanValue()) {
                        ev.getPlayer().teleport(plugin.lobby);
                        ev.getPlayer().getWorld().setPVP(false);
                    } else {
                        func.helmet(ev.getPlayer());
                        func.removeKlasse(ev.getPlayer());
                    }
                }
            } catch (Exception e) {
                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[BabelPlugin] Location not found!");
            }
        }
    }
}
