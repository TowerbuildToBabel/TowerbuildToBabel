package me.thundergemios10.babelplugin.events;

import me.thundergemios10.babelplugin.BabelPlugin;
import me.thundergemios10.babelplugin.Functions;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplodeListener implements Listener {

    Functions func = new Functions();

    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        if (e.getLocation().getWorld().getName().equalsIgnoreCase("babel")) {
            BabelPlugin plugin = BabelPlugin.getPlugin();
            List<Block> blockList = e.blockList();
            for (int i = 0; i < blockList.size(); i++) {
                if (blockList.get(i).getType() != Material.SAND && blockList.get(i).getType() != Material.TNT && blockList.get(i).getType() != Material.REDSTONE_TORCH_ON) {
                    blockList.remove(i);
                    i--;
                }
            }
        }
    }
}
