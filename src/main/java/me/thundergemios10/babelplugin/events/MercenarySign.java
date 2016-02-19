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

public class MercenarySign implements Listener {

    Functions func = new Functions();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent ev) {
        if (ev.getPlayer().getWorld().getName().equalsIgnoreCase("babel")) {
            if (ev.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (ev.getClickedBlock().getTypeId() == 63 || ev.getClickedBlock().getTypeId() == 68) {
                    BabelPlugin plugin = BabelPlugin.getPlugin();
                    Sign sign = (Sign) ev.getClickedBlock().getState();
                    if (sign.getLine(0).equalsIgnoreCase("[BabelPlugin]") && sign.getLine(1).equalsIgnoreCase("Mercenary")) {
                        ev.getPlayer().getInventory().clear();
                        ev.getPlayer().getInventory().setLeggings(new ItemStack(Material.AIR));
                        ev.getPlayer().getInventory().setChestplate(new ItemStack(Material.AIR));
                        ev.getPlayer().getInventory().setBoots(new ItemStack(Material.AIR));

                        ev.getPlayer().getInventory().addItem(new ItemStack(267));
                        ev.getPlayer().getInventory().addItem(new ItemStack(261));
                        ev.getPlayer().getInventory().addItem(new ItemStack(262, 20));
                        ev.getPlayer().getInventory().setBoots(new ItemStack(301));
                        ev.getPlayer().getInventory().setChestplate(new ItemStack(299));
                        ev.getPlayer().getInventory().setLeggings(new ItemStack(300));
                        ev.getPlayer().updateInventory();

                        func.removeKlasse(ev.getPlayer());
                        func.klassen(ev.getPlayer(), sign);
                        func.checktower(ev.getPlayer());

                        ev.getPlayer().sendMessage(ChatColor.AQUA + "[BabelPlugin] You have selected the class Mercenary!");
                    }
                }
            }
        }
    }
}
