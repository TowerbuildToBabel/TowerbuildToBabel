package me.bukkit.babelplugin;

import Config.ConfigIO;
import java.io.File;
import java.io.IOException;
import me.bukkit.babelplugin.events.MercenarySign;
import me.bukkit.babelplugin.events.End;
import me.bukkit.babelplugin.events.BuilderSign;
import me.bukkit.babelplugin.events.RespawnListener;
import me.bukkit.babelplugin.events.PlayerPickUpListener;
import me.bukkit.babelplugin.events.PlayerDropListener;
import me.bukkit.babelplugin.events.BlockBreakListener;
import me.bukkit.babelplugin.events.BlockPlaceListener;
import me.bukkit.babelplugin.events.SaboteurSign;
import me.bukkit.babelplugin.events.HelmetListener;
import me.bukkit.babelplugin.events.JoinSign;
import me.bukkit.babelplugin.events.ExplodeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.bukkit.babelplugin.commands.EndCommandExecutor;
import me.bukkit.babelplugin.commands.StartCommandExecutor;
import me.bukkit.babelplugin.events.ChangeWorld;
import me.bukkit.babelplugin.events.DeathListener;
import me.bukkit.babelplugin.events.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class BabelPlugin extends JavaPlugin {

    public List<Player> playerlist = new ArrayList<Player>();
    public List<Player> playerred = new ArrayList<Player>();
    public List<Player> playerblue = new ArrayList<Player>();
    public List<Player> playerbluem = new ArrayList<Player>();
    public List<Player> playerblueb = new ArrayList<Player>();
    public List<Player> playerblues = new ArrayList<Player>();
    public List<Player> playerredm = new ArrayList<Player>();
    public List<Player> playerredb = new ArrayList<Player>();
    public List<Player> playerreds = new ArrayList<Player>();
    public List<Location> areared = new ArrayList<Location>();
    public List<Location> areablue = new ArrayList<Location>();
    int redtower = 0;
    int bluetower = 0;
    public Location spawnred;
    public Location spawnblue;
    public Location lobby;
    public Location end;
    public Location redareatop;
    public Location redareabot;
    public Location blueareatop;
    public Location blueareabot;
    public Location firework;
    public Location redbutton;
    public Location bluebutton;
    public String status = "join";
    private static BabelPlugin instance = new BabelPlugin();
    ConfigIO io = new ConfigIO(this);

    public BabelPlugin() {
        instance = this;
    }

    public static final BabelPlugin getPlugin() {
        return instance;
    }
    Logger log = Bukkit.getLogger();

    @Override
    public void onDisable() {
        log.info("[BabelPlugin] Plugin Version " + this.getDescription().getVersion() + " by oSLiD3Ro disabled!");
    }

    @Override
    public void onEnable() {
        log.info("[BabelPlugin] Plugin Version " + this.getDescription().getVersion() + " by oSLiD3Ro enabled!");

        String filepath = (System.getProperty("user.dir") + "\\plugins\\BabelPlugin\\config.yml");
        File file = new File(filepath);

        if (file.exists()) {
            log.info("[BabelPlugin] Config.yml exists!");
        } else {
            log.info("[BabelPlugin] Config.yml does not exists!");
            io.createConfig();
        }

        this.getCommand("startgame").setExecutor(new StartCommandExecutor(this));
        this.getCommand("endgame").setExecutor(new EndCommandExecutor());

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new JoinSign(), this);
        pm.registerEvents(new ChangeWorld(), this);
        pm.registerEvents(new MercenarySign(), this);
        pm.registerEvents(new SaboteurSign(), this);
        pm.registerEvents(new BuilderSign(), this);
        pm.registerEvents(new End(), this);
        pm.registerEvents(new RespawnListener(), this);
        pm.registerEvents(new PlayerDropListener(), this);
        pm.registerEvents(new PlayerPickUpListener(), this);
        pm.registerEvents(new BlockPlaceListener(), this);
        pm.registerEvents(new BlockBreakListener(), this);
        pm.registerEvents(new ExplodeListener(), this);
        pm.registerEvents(new HelmetListener(), this);
        pm.registerEvents(new DeathListener(), this);

        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            log.info("[BabelPlugin] Loading Metrics failed!");
        }
    }
}
