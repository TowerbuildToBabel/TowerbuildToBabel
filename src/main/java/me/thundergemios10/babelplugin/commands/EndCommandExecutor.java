package me.thundergemios10.babelplugin.commands;

import java.util.List;
import me.thundergemios10.babelplugin.BabelPlugin;
import me.thundergemios10.babelplugin.Functions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class EndCommandExecutor
  implements CommandExecutor
{
  Functions func = new Functions();
  
  public boolean onCommand(CommandSender sender, Command cmnd, String string, String[] strings)
  {
    BabelPlugin plugin = BabelPlugin.getPlugin();
    if (sender.hasPermission("BabelPlugin.End"))
    {
      plugin.status = "join";
      Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[BabelPlugin] Game ended!!!");
      try
      {
        for (Player player : plugin.playerlist)
        {
          player.getInventory().clear();
          player.getPlayer().getInventory().setLeggings(new ItemStack(Material.AIR));
          player.getPlayer().getInventory().setChestplate(new ItemStack(Material.AIR));
          player.getPlayer().getInventory().setBoots(new ItemStack(Material.AIR));
          player.getPlayer().getInventory().setHelmet(new ItemStack(Material.AIR));
          player.teleport(plugin.lobby);
          player.getWorld().setPVP(false);
        }
        this.func.hideScoreboard();
        plugin.playerblue.clear();
        plugin.playerblues.clear();
        plugin.playerbluem.clear();
        plugin.playerblueb.clear();
        plugin.playerred.clear();
        plugin.playerreds.clear();
        plugin.playerredm.clear();
        plugin.playerredb.clear();
        plugin.playerlist.clear();
      }
      catch (Exception e)
      {
        Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[BabelPlugin] Location not found!");
      }
    }
    return true;
  }
}
