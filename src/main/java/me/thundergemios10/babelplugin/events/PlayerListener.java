package me.thundergemios10.babelplugin.events;

import config.ConfigIO;
import java.util.List;
import me.thundergemios10.babelplugin.BabelPlugin;
import me.thundergemios10.babelplugin.Functions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class PlayerListener
  implements Listener
{
  BabelPlugin plugin = BabelPlugin.getPlugin();
  Functions func = new Functions();
  ConfigIO io = new ConfigIO(this.plugin);
  
  @EventHandler
  public void onJoin(PlayerJoinEvent ev)
  {
    BabelPlugin plugin = BabelPlugin.getPlugin();
    if ((Bukkit.getWorlds().size() == 3) && (ev.getPlayer().getWorld().getName().equalsIgnoreCase("babel")))
    {
      ev.setJoinMessage(ChatColor.DARK_GRAY + "[BabelPlugin] " + ev.getPlayer().getName() + " has joined the game!");
      
      this.io.generateLocations(ev.getPlayer());
      this.func.Area(ev.getPlayer());
      
      ev.getPlayer().getInventory().clear();
      ev.getPlayer().getInventory().setLeggings(new ItemStack(Material.AIR));
      ev.getPlayer().getInventory().setChestplate(new ItemStack(Material.AIR));
      ev.getPlayer().getInventory().setBoots(new ItemStack(Material.AIR));
      ev.getPlayer().getInventory().setHelmet(new ItemStack(Material.AIR));
      try
      {
        if (plugin.status.equalsIgnoreCase("join"))
        {
          ev.getPlayer().teleport(plugin.lobby);
          ev.getPlayer().getWorld().setPVP(false);
        }
        else if (plugin.status.equalsIgnoreCase("end"))
        {
          ev.getPlayer().teleport(plugin.end);
          ev.getPlayer().getWorld().setPVP(false);
        }
        else if (plugin.status.equalsIgnoreCase("play"))
        {
          Boolean test = Boolean.valueOf(false);
          for (int i = 0; i < plugin.playerblue.size(); i++) {
            if (ev.getPlayer().getName().equalsIgnoreCase(((Player)plugin.playerblue.get(i)).getName()))
            {
              ev.getPlayer().teleport(plugin.spawnblue);
              ev.getPlayer().getWorld().setPVP(true);
              test = Boolean.valueOf(true);
            }
          }
          for (i = 0; i < plugin.playerred.size(); i++) {
            if (ev.getPlayer().getName().equalsIgnoreCase(((Player)plugin.playerred.get(i)).getName()))
            {
              ev.getPlayer().teleport(plugin.spawnred);
              ev.getPlayer().getWorld().setPVP(true);
              test = Boolean.valueOf(true);
            }
          }
          if (!test.booleanValue())
          {
            ev.getPlayer().teleport(plugin.lobby);
            ev.getPlayer().getWorld().setPVP(false);
          }
          else
          {
            this.func.helmet(ev.getPlayer());
            this.func.removeKlasse(ev.getPlayer());
          }
        }
      }
      catch (Exception e)
      {
        Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[BabelPlugin] Location not found!");
      }
    }
  }
  
  public void onLeave(PlayerQuitEvent ev)
  {
    ev.setQuitMessage(ChatColor.DARK_GRAY + "[BabelPlugin] " + ev.getPlayer().getName() + " has left the game!");
  }
}
