package me.thundergemios10.babelplugin.events;

import me.thundergemios10.babelplugin.BabelPlugin;
import me.thundergemios10.babelplugin.Functions;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SaboteurSign implements Listener {

    Functions func = new Functions();
    int i = 0;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent ev) {
        if (ev.getPlayer().getWorld().getName().equalsIgnoreCase("babel")) {
            BabelPlugin plugin = BabelPlugin.getPlugin();
            if (ev.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (ev.getClickedBlock().getTypeId() == 63 || ev.getClickedBlock().getTypeId() == 68) {
                    Sign sign = (Sign) ev.getClickedBlock().getState();
                    if (sign.getLine(0).equalsIgnoreCase("[BabelPlugin]") && sign.getLine(1).equalsIgnoreCase("Saboteur")) {
                        for (i = 0; i < plugin.playerblue.size(); i++) {
                            if (ev.getPlayer().getName().equalsIgnoreCase(plugin.playerblue.get(i).getName())) {
                                if (plugin.playerblues.size() < 3) {

                                    ev.getPlayer().getInventory().clear();
                                    ev.getPlayer().getInventory().setLeggings(new ItemStack(Material.AIR));
                                    ev.getPlayer().getInventory().setChestplate(new ItemStack(Material.AIR));
                                    ev.getPlayer().getInventory().setBoots(new ItemStack(Material.AIR));

                                    ev.getPlayer().getInventory().addItem(new ItemStack(268));
                                    ev.getPlayer().getInventory().addItem(new ItemStack(46, 3));
                                    ev.getPlayer().getInventory().addItem(new ItemStack(76, 3));
                                    ev.getPlayer().getInventory().setBoots(new ItemStack(301));
                                    ev.getPlayer().updateInventory();

                                    func.removeKlasse(ev.getPlayer());
                                    func.klassen(ev.getPlayer(), sign);
                                    func.checktower(ev.getPlayer());

                                    ev.getPlayer().sendMessage(ChatColor.AQUA + "[BabelPlugin] You have selected the class Saboteur!");

                                } else {
                                    ev.getPlayer().sendMessage(ChatColor.AQUA + "[BabelPlugin] There are already 3 Saboteurs!");
                                }
                            }
                        }
                        for (i = 0; i < plugin.playerred.size(); i++) {
                            if (ev.getPlayer().getName().equalsIgnoreCase(plugin.playerred.get(i).getName())) {
                                if (plugin.playerreds.size() < 3) {

                                    ev.getPlayer().getInventory().clear();
                                    ev.getPlayer().getInventory().setLeggings(new ItemStack(Material.AIR));
                                    ev.getPlayer().getInventory().setChestplate(new ItemStack(Material.AIR));
                                    ev.getPlayer().getInventory().setBoots(new ItemStack(Material.AIR));

                                    ev.getPlayer().getInventory().addItem(new ItemStack(268));
                                    ev.getPlayer().getInventory().addItem(new ItemStack(46, 3));
                                    ev.getPlayer().getInventory().addItem(new ItemStack(76, 3));
                                    ev.getPlayer().getInventory().setBoots(new ItemStack(301));
                                    ev.getPlayer().updateInventory();

                                    func.removeKlasse(ev.getPlayer());
                                    func.klassen(ev.getPlayer(), sign);
                                    func.checktower(ev.getPlayer());

                                    ev.getPlayer().sendMessage(ChatColor.AQUA + "[BabelPlugin] You have selected the class Saboteur!");

                                } else {
                                    ev.getPlayer().sendMessage(ChatColor.AQUA + "[BabelPlugin] There are already 3 Saboteurs!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
