package me.thundergemios10.babelplugin.events;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathListener implements Listener {

    int i = 0;
    int test = 0;
    List<Integer> remove = new ArrayList<Integer>();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (e.getEntity().getWorld().getName().equalsIgnoreCase("babel")) {
            for (i = 0; i < e.getDrops().size(); i++) {
                if (e.getDrops().get(i).getType() != Material.SAND && e.getDrops().get(i).getType() != Material.REDSTONE_TORCH_ON && e.getDrops().get(i).getType() != Material.TNT && e.getDrops().get(i).getType() != Material.ARROW && e.getDrops().get(i).getType() != Material.RAW_CHICKEN && e.getDrops().get(i).getType() != Material.RAW_BEEF && e.getDrops().get(i).getType() != Material.PORK) {
                    e.getDrops().remove(i);
                    i--;
                }
            }
        }
    }
}
