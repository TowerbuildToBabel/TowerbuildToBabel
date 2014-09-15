package Config;

import me.bukkit.babelplugin.BabelPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ConfigIO {

    private BabelPlugin babel;

    public ConfigIO(BabelPlugin plugin) {
        this.babel = plugin;
    }
    
    public SimpleConfigManager manager;
    public SimpleConfig config;
    public SimpleConfig messages;

    // Generiert die Variablen für die verschiedenen Orte auf der Map, falls die Daten vorhanden sind
    public void generateLocations(Player player) {
        try {
            BabelPlugin plugin = BabelPlugin.getPlugin();
            FileConfiguration cfg = this.babel.getConfig();
            cfg.options().copyDefaults(true);
            plugin.spawnblue = new Location(player.getWorld(), this.babel.getConfig().getInt("BlueX"), this.babel.getConfig().getInt("BlueY"), this.babel.getConfig().getInt("BlueZ"));
            plugin.spawnred = new Location(player.getWorld(), this.babel.getConfig().getInt("RedX"), this.babel.getConfig().getInt("RedY"), this.babel.getConfig().getInt("RedZ"));
            plugin.lobby = new Location(player.getWorld(), this.babel.getConfig().getInt("LobbyX"), this.babel.getConfig().getInt("LobbyY"), this.babel.getConfig().getInt("LobbyZ"));
            plugin.end = new Location(player.getWorld(), this.babel.getConfig().getInt("EndX"), this.babel.getConfig().getInt("EndY"), this.babel.getConfig().getInt("EndZ"));
            plugin.redareabot = new Location(player.getWorld(), this.babel.getConfig().getInt("AreaRedBotX"), this.babel.getConfig().getInt("AreaRedBotY"), this.babel.getConfig().getInt("AreaRedBotZ"));
            plugin.redareatop = new Location(player.getWorld(), this.babel.getConfig().getInt("AreaRedTopX"), this.babel.getConfig().getInt("AreaRedTopY"), this.babel.getConfig().getInt("AreaRedTopZ"));
            plugin.blueareatop = new Location(player.getWorld(), this.babel.getConfig().getInt("AreaBlueTopX"), this.babel.getConfig().getInt("AreaBlueTopY"), this.babel.getConfig().getInt("AreaBlueTopZ"));
            plugin.blueareabot = new Location(player.getWorld(), this.babel.getConfig().getInt("AreaBlueBotX"), this.babel.getConfig().getInt("AreaBlueBotY"), this.babel.getConfig().getInt("AreaBlueBotZ"));
            plugin.firework = new Location(player.getWorld(), this.babel.getConfig().getInt("FireX"), this.babel.getConfig().getInt("FireY"), this.babel.getConfig().getInt("FireZ"));
            plugin.redbutton = new Location(player.getWorld(), this.babel.getConfig().getInt("RedButtonX"), this.babel.getConfig().getInt("RedButtonY"), this.babel.getConfig().getInt("RedButtonZ"));
            plugin.bluebutton = new Location(player.getWorld(), this.babel.getConfig().getInt("BlueButtonX"), this.babel.getConfig().getInt("BlueButtonY"), this.babel.getConfig().getInt("BlueButtonZ"));

        } catch (Exception e) {
            player.sendMessage(ChatColor.AQUA + "[BabelPlugin] Please check config.yml");
        }
    }
    
    // Erstellt ein neues Konfig-File, falls noch keines vorhanden ist mit Standardwerten
    public void createConfig() {
        manager = new SimpleConfigManager(this.babel);

        String[] header = {"Configuration File of", "BabelPlugin"};
        String[] comment1 = {"----------------------------------------", "Spawn of the blue team"};
        String[] comment2 = {"----------------------------------------", "Spawn of the red team"};
        String[] comment3 = {"----------------------------------------", "Spawn Lobby"};
        String[] comment4 = {"----------------------------------------", "Spawn End Event"};
        String[] comment5 = {"----------------------------------------", "Area of the red team Bot"};
        String[] comment6 = {"----------------------------------------", "Area of the red team Top"};
        String[] comment7 = {"----------------------------------------", "Area of the blue team Bot"};
        String[] comment8 = {"----------------------------------------", "Area of the blue team Top"};
        String[] comment9 = {"----------------------------------------", "Block that gives a redstone signal at the end event"};
        String[] comment10 = {"----------------------------------------", "End Button of the red team"};
        String[] comment11 = {"----------------------------------------", "End Button of the blue team"};

        this.config = manager.getNewConfig("config.yml", header);

        this.config.set("BlueX", -343, comment1);
        this.config.set("BlueY", 70);
        this.config.set("BlueZ", -27);

        this.config.set("RedX", -87, comment2);
        this.config.set("RedY", 45);
        this.config.set("RedZ", -27);

        this.config.set("LobbyX", -185, comment3);
        this.config.set("LobbyY", 49);
        this.config.set("LobbyZ", 130);

        this.config.set("EndX", -179, comment4);
        this.config.set("EndY", 65);
        this.config.set("EndZ", 212);

        this.config.set("AreaRedBotX", -101, comment5);
        this.config.set("AreaRedBotY", 64);
        this.config.set("AreaRedBotZ", -32);

        this.config.set("AreaRedTopX", -111, comment6);
        this.config.set("AreaRedTopY", 105);
        this.config.set("AreaRedTopZ", -22);

        this.config.set("AreaBlueBotX", -298, comment7);
        this.config.set("AreaBlueBotY", 64);
        this.config.set("AreaBlueBotZ", -22);

        this.config.set("AreaBlueTopX", -288, comment8);
        this.config.set("AreaBlueTopY", 105);
        this.config.set("AreaBlueTopZ", -32);

        this.config.set("FireX", -208, comment9);
        this.config.set("FireY", 60);
        this.config.set("FireZ", 175);

        this.config.set("RedButtonX", -119, comment10);
        this.config.set("RedButtonY", 133);
        this.config.set("RedButtonZ", -18);

        this.config.set("BlueButtonX", -279, comment11);
        this.config.set("BlueButtonY", 133);
        this.config.set("BlueButtonZ", -36);

        this.config.saveConfig();
    }
}
