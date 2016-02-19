package config;

import me.thundergemios10.babelplugin.BabelPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;

public class ConfigIO
{
  private BabelPlugin plugin;
  public SimpleConfigManager manager;
  public SimpleConfig config;
  public SimpleConfig messages;
  
  public ConfigIO(BabelPlugin plugin)
  {
    this.plugin = plugin;
  }
  
  public void generateLocations(Player player)
  {
    try
    {
      BabelPlugin plugin = BabelPlugin.getPlugin();
      FileConfiguration cfg = this.plugin.getConfig();
      cfg.options().copyDefaults(true);
      plugin.spawnblue = new Location(player.getWorld(), this.plugin.getConfig().getInt("BlueX"), this.plugin.getConfig().getInt("BlueY"), this.plugin.getConfig().getInt("BlueZ"));
      plugin.spawnred = new Location(player.getWorld(), this.plugin.getConfig().getInt("RedX"), this.plugin.getConfig().getInt("RedY"), this.plugin.getConfig().getInt("RedZ"));
      plugin.lobby = new Location(player.getWorld(), this.plugin.getConfig().getInt("LobbyX"), this.plugin.getConfig().getInt("LobbyY"), this.plugin.getConfig().getInt("LobbyZ"));
      plugin.end = new Location(player.getWorld(), this.plugin.getConfig().getInt("EndX"), this.plugin.getConfig().getInt("EndY"), this.plugin.getConfig().getInt("EndZ"));
      plugin.redareabot = new Location(player.getWorld(), this.plugin.getConfig().getInt("AreaRedBotX"), this.plugin.getConfig().getInt("AreaRedBotY"), this.plugin.getConfig().getInt("AreaRedBotZ"));
      plugin.redareatop = new Location(player.getWorld(), this.plugin.getConfig().getInt("AreaRedTopX"), this.plugin.getConfig().getInt("AreaRedTopY"), this.plugin.getConfig().getInt("AreaRedTopZ"));
      plugin.blueareatop = new Location(player.getWorld(), this.plugin.getConfig().getInt("AreaBlueTopX"), this.plugin.getConfig().getInt("AreaBlueTopY"), this.plugin.getConfig().getInt("AreaBlueTopZ"));
      plugin.blueareabot = new Location(player.getWorld(), this.plugin.getConfig().getInt("AreaBlueBotX"), this.plugin.getConfig().getInt("AreaBlueBotY"), this.plugin.getConfig().getInt("AreaBlueBotZ"));
      plugin.firework = new Location(player.getWorld(), this.plugin.getConfig().getInt("FireX"), this.plugin.getConfig().getInt("FireY"), this.plugin.getConfig().getInt("FireZ"));
      plugin.redbutton = new Location(player.getWorld(), this.plugin.getConfig().getInt("RedButtonX"), this.plugin.getConfig().getInt("RedButtonY"), this.plugin.getConfig().getInt("RedButtonZ"));
      plugin.bluebutton = new Location(player.getWorld(), this.plugin.getConfig().getInt("BlueButtonX"), this.plugin.getConfig().getInt("BlueButtonY"), this.plugin.getConfig().getInt("BlueButtonZ"));
    }
    catch (Exception e)
    {
      player.sendMessage(ChatColor.AQUA + "[BabelPlugin] Please check config.yml");
    }
  }
  
  public void createConfig()
  {
    this.manager = new SimpleConfigManager(this.plugin);
    
    String[] header = { "Configuration File of", "BabelPlugin" };
    String[] comment1 = { "----------------------------------------", "Spawn of the blue team" };
    String[] comment2 = { "----------------------------------------", "Spawn of the red team" };
    String[] comment3 = { "----------------------------------------", "Spawn Lobby" };
    String[] comment4 = { "----------------------------------------", "Spawn End Event" };
    String[] comment5 = { "----------------------------------------", "Area of the red team Bot" };
    String[] comment6 = { "----------------------------------------", "Area of the red team Top" };
    String[] comment7 = { "----------------------------------------", "Area of the blue team Bot" };
    String[] comment8 = { "----------------------------------------", "Area of the blue team Top" };
    String[] comment9 = { "----------------------------------------", "Block that gives a redstone signal at the end event" };
    String[] comment10 = { "----------------------------------------", "End Button of the red team" };
    String[] comment11 = { "----------------------------------------", "End Button of the blue team" };
    String[] comment12 = { "----------------------------------------", "Enable/Disable Auto Updater" };
    
    this.config = this.manager.getNewConfig("config.yml", header);
    
    this.config.set("AutoUpdater", "true", comment12);
    
    this.config.set("BlueX", Integer.valueOf(65193), comment1);
    this.config.set("BlueY", Integer.valueOf(70));
    this.config.set("BlueZ", Integer.valueOf(-27));
    
    this.config.set("RedX", Integer.valueOf(-87), comment2);
    this.config.set("RedY", Integer.valueOf(45));
    this.config.set("RedZ", Integer.valueOf(-27));
    
    this.config.set("LobbyX", Integer.valueOf(65351), comment3);
    this.config.set("LobbyY", Integer.valueOf(49));
    this.config.set("LobbyZ", Integer.valueOf(130));
    
    this.config.set("EndX", Integer.valueOf(65357), comment4);
    this.config.set("EndY", Integer.valueOf(65));
    this.config.set("EndZ", Integer.valueOf(212));
    
    this.config.set("AreaRedBotX", Integer.valueOf(-101), comment5);
    this.config.set("AreaRedBotY", Integer.valueOf(64));
    this.config.set("AreaRedBotZ", Integer.valueOf(-32));
    
    this.config.set("AreaRedTopX", Integer.valueOf(-111), comment6);
    this.config.set("AreaRedTopY", Integer.valueOf(105));
    this.config.set("AreaRedTopZ", Integer.valueOf(-22));
    
    this.config.set("AreaBlueBotX", Integer.valueOf(65238), comment7);
    this.config.set("AreaBlueBotY", Integer.valueOf(64));
    this.config.set("AreaBlueBotZ", Integer.valueOf(-22));
    
    this.config.set("AreaBlueTopX", Integer.valueOf(65248), comment8);
    this.config.set("AreaBlueTopY", Integer.valueOf(105));
    this.config.set("AreaBlueTopZ", Integer.valueOf(-32));
    
    this.config.set("FireX", Integer.valueOf(65328), comment9);
    this.config.set("FireY", Integer.valueOf(60));
    this.config.set("FireZ", Integer.valueOf(175));
    
    this.config.set("RedButtonX", Integer.valueOf(-119), comment10);
    this.config.set("RedButtonY", Integer.valueOf(133));
    this.config.set("RedButtonZ", Integer.valueOf(-18));
    
    this.config.set("BlueButtonX", Integer.valueOf(65257), comment11);
    this.config.set("BlueButtonY", Integer.valueOf(133));
    this.config.set("BlueButtonZ", Integer.valueOf(-36));
    
    this.config.saveConfig();
  }
}
