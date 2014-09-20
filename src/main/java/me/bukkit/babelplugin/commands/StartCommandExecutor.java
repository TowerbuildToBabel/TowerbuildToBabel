package me.bukkit.babelplugin.commands;

import me.bukkit.babelplugin.BabelPlugin;
import me.bukkit.babelplugin.Functions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommandExecutor implements CommandExecutor {
    
    BabelPlugin plugin = BabelPlugin.getPlugin();
    
    Functions func = new Functions();
    
    private BabelPlugin test;
  
    public StartCommandExecutor(BabelPlugin plugin)
    {
        this.test = plugin;
    }

    @Override
    public boolean onCommand(final CommandSender sender, Command cmnd, String string, String[] strings) {
        if (sender.hasPermission("BabelPlugin.Start")) {
            BabelPlugin plugin = BabelPlugin.getPlugin();
            plugin.status = "play";
                
                int i;
                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[BabelPlugin] Game started!!!");
                try {
                    for (i = 0; i < plugin.playerlist.size(); i++) {
                        if (i % 2 == 0) {
                            plugin.playerred.add(plugin.playerlist.get(i));
                            Player player = (Player) plugin.playerlist.get(i);
                            player.sendMessage(ChatColor.RED + "[BabelPlugin] You were assigned to the red team!");
                            player.getWorld().setPVP(true);
                            player.teleport(plugin.spawnred);
                            func.helmet(player);
                        } else {
                            plugin.playerblue.add(plugin.playerlist.get(i));
                            Player player = (Player) plugin.playerlist.get(i);
                            player.sendMessage(ChatColor.BLUE + "[BabelPlugin] You were assigned to the blue team!");
                            player.getWorld().setPVP(true);
                            player.teleport(plugin.spawnblue);
                            func.helmet(player);
                        }
                    }
                 } catch (Exception e) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[BabelPlugin] Location not found!");   
                }
            
            
            
        }
        return true;
    }
}
