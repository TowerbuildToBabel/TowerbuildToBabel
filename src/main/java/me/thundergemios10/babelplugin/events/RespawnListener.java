package me.thundergemios10.babelplugin.events;

import me.thundergemios10.babelplugin.BabelPlugin;
import me.thundergemios10.babelplugin.Functions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {

    Functions func = new Functions();

    @EventHandler
    public void onRespawn(PlayerRespawnEvent ev) {
        if (ev.getPlayer().getWorld().getName().equalsIgnoreCase("babel")) {
            BabelPlugin plugin = BabelPlugin.getPlugin();
            int i;
            try {
                if (plugin.status.equalsIgnoreCase("play")) {
                    for (i = 0; i < plugin.playerblue.size(); i++) {
                        if (ev.getPlayer().getName().equalsIgnoreCase(plugin.playerblue.get(i).getName())) {
                            ev.setRespawnLocation(plugin.spawnblue);
                        }
                    }
                    for (i = 0; i < plugin.playerred.size(); i++) {
                        if (ev.getPlayer().getName().equalsIgnoreCase(plugin.playerred.get(i).getName())) {
                            ev.setRespawnLocation(plugin.spawnred);
                        }
                    }
                    func.helmet(ev.getPlayer());
                    func.removeKlasse(ev.getPlayer());
                } else if (plugin.status.equalsIgnoreCase("end")) {
                    ev.setRespawnLocation(plugin.end);
                    ev.getPlayer().getWorld().setPVP(false);
                } else if (plugin.status.equalsIgnoreCase("join")) {
                    ev.setRespawnLocation(plugin.lobby);
                    ev.getPlayer().getWorld().setPVP(false);
                }
            } catch (Exception e) {
                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[BabelPlugin] Location not found!");
            }
        }
    }
}
