package me.thundergemios10.babelplugin.events;

import me.thundergemios10.babelplugin.BabelPlugin;
import me.thundergemios10.babelplugin.Functions;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class JoinSign implements Listener {

    Functions test = new Functions();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent ev) {
        if (ev.getPlayer().getWorld().getName().equalsIgnoreCase("babel")) {
            if (ev.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                BabelPlugin plugin = BabelPlugin.getPlugin();
                if (ev.getClickedBlock().getTypeId() == 63 || ev.getClickedBlock().getTypeId() == 68) {

                    Boolean newplayer = true;

                    Sign sign = (Sign) ev.getClickedBlock().getState();
                    if (sign.getLine(0).equalsIgnoreCase("[BabelPlugin]") && sign.getLine(1).equalsIgnoreCase("Join")) {
                        if (plugin.status.equals("join")) {
                            test.addPlayerList(ev.getPlayer());
                        } else {
                            ev.getPlayer().sendMessage(ChatColor.AQUA + "[BabelPlugin] Game is already in process.");
                        }
                    }
                }
            }
        }
    }
}
