package me.bukkit.babelplugin.events;

import me.bukkit.babelplugin.BabelPlugin;
import me.bukkit.babelplugin.Functions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class End implements Listener {

    private boolean powered;
    BabelPlugin data = new BabelPlugin();
    Functions func = new Functions();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent ev) {
        if (ev.getPlayer().getWorld().getName().equalsIgnoreCase("babel")) {
            if (ev.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (ev.getClickedBlock().getTypeId() == 77) {
                    int PosX = ev.getClickedBlock().getX();
                    int PosY = ev.getClickedBlock().getY();
                    int PosZ = ev.getClickedBlock().getZ();
                    int i = 0;
                    BabelPlugin plugin = BabelPlugin.getPlugin();

                    try {
                        Block target = plugin.firework.getBlock();

                        if (PosX == plugin.redbutton.getBlockX() && PosY == plugin.redbutton.getBlockY() && PosZ == plugin.redbutton.getBlockZ()) {
                            Bukkit.getServer().broadcastMessage(ChatColor.RED + "[BabelPlugin] The red team won!!!");
                            plugin.status = "end";

                            target.setData((byte) 15, true);
                            for (Player player : plugin.playerlist) {
                                player.teleport(plugin.end);
                                player.getWorld().setPVP(false);
                            }
                        }
                        if (PosX == plugin.bluebutton.getBlockX() && PosY == plugin.bluebutton.getBlockY() && PosZ == plugin.bluebutton.getBlockZ()) {
                            Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "[BabelPlugin] The blue team won!!!");
                            plugin.status = "end";
                            target.setData((byte) 15, true);
                            for (Player player : plugin.playerlist) {
                                player.teleport(plugin.end);
                                player.getWorld().setPVP(false);
                            }
                        }
                    } catch (Exception e) {
                        Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[BabelPlugin] Location not found!");
                    }
                }
            }
        }
    }
}
