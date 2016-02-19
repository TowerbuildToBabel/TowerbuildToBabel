package me.thundergemios10.babelplugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Functions {

    
    public void addPlayerList(Player sender) {
        BabelPlugin plugin = BabelPlugin.getPlugin();
        int i = 0;
        Boolean newplayer = true;

        for (i = 0; i < plugin.playerlist.size(); i++) {
            Player test = (Player) plugin.playerlist.get(i);
            if (sender.getName().equals(test.getName())) {
                sender.sendMessage(BabelPlugin.logPrefix + ChatColor.AQUA + "You already joined the game!");
                newplayer = false;
            }
        }
        if (newplayer != false) {
            plugin.playerlist.add(sender);
            sender.sendMessage(BabelPlugin.logPrefix + ChatColor.AQUA + "You joined the game!");
        }

    }

    public void helmet(Player sender) {
        BabelPlugin plugin = BabelPlugin.getPlugin();
        int i = 0;

        for (i = 0; i < plugin.playerblue.size(); i++) {
            if (sender.getName().equalsIgnoreCase(plugin.playerblue.get(i).getName())) {
                sender.getInventory().setHelmet((new ItemStack(Material.WOOL, 1, (short) 11)));
            }
        }
        for (i = 0; i < plugin.playerred.size(); i++) {
            if (sender.getName().equalsIgnoreCase(plugin.playerred.get(i).getName())) {
                sender.getInventory().setHelmet((new ItemStack(Material.WOOL, 1, (short) 14)));
            }
        }
    }

    public void klassen(Player sender, Sign sign) {
        BabelPlugin plugin = BabelPlugin.getPlugin();
        int i = 0;

        for (i = 0; i < plugin.playerblue.size(); i++) {
            if (sender.getName().equalsIgnoreCase(plugin.playerblue.get(i).getName())) {
                if (sign.getLine(0).equalsIgnoreCase("[BabelPlugin]") && sign.getLine(1).equalsIgnoreCase("Mercenary")) {
                    plugin.playerbluem.add(sender);
                } else if (sign.getLine(0).equalsIgnoreCase("[BabelPlugin]") && sign.getLine(1).equalsIgnoreCase("Builder")) {
                    plugin.playerblueb.add(sender);
                } else if (sign.getLine(0).equalsIgnoreCase("[BabelPlugin]") && sign.getLine(1).equalsIgnoreCase("Saboteur")) {
                    plugin.playerblues.add(sender);
                }
            }
        }
        for (i = 0; i < plugin.playerred.size(); i++) {
            if (sender.getName().equalsIgnoreCase(plugin.playerred.get(i).getName())) {
                if (sign.getLine(0).equalsIgnoreCase("[BabelPlugin]") && sign.getLine(1).equalsIgnoreCase("Mercenary")) {
                    plugin.playerredm.add(sender);
                } else if (sign.getLine(0).equalsIgnoreCase("[BabelPlugin]") && sign.getLine(1).equalsIgnoreCase("Builder")) {
                    plugin.playerredb.add(sender);
                } else if (sign.getLine(0).equalsIgnoreCase("[BabelPlugin]") && sign.getLine(1).equalsIgnoreCase("Saboteur")) {
                    plugin.playerreds.add(sender);
                }
            }
        }
        scoreboard(sender);
    }

    public void removeKlasse(Player sender) {
        BabelPlugin plugin = BabelPlugin.getPlugin();
        int i = 0;
        for (i = 0; i < plugin.playerredm.size(); i++) {
            if (sender.getName().equalsIgnoreCase(plugin.playerredm.get(i).getName())) {
                plugin.playerredm.remove(i);
            }
        }
        for (i = 0; i < plugin.playerreds.size(); i++) {
            if (sender.getName().equalsIgnoreCase(plugin.playerreds.get(i).getName())) {
                plugin.playerreds.remove(i);
            }
        }
        for (i = 0; i < plugin.playerredb.size(); i++) {
            if (sender.getName().equalsIgnoreCase(plugin.playerredb.get(i).getName())) {
                plugin.playerredb.remove(i);
            }
        }
        for (i = 0; i < plugin.playerbluem.size(); i++) {
            if (sender.getName().equalsIgnoreCase(plugin.playerbluem.get(i).getName())) {
                plugin.playerbluem.remove(i);
            }
        }
        for (i = 0; i < plugin.playerblues.size(); i++) {
            if (sender.getName().equalsIgnoreCase(plugin.playerblues.get(i).getName())) {
                plugin.playerblues.remove(i);
            }
        }
        for (i = 0; i < plugin.playerblueb.size(); i++) {
            if (sender.getName().equalsIgnoreCase(plugin.playerblueb.get(i).getName())) {
                plugin.playerblueb.remove(i);
            }
        }
        scoreboard(sender);
    }

    public void scoreboard(Player player) {
        BabelPlugin plugin = BabelPlugin.getPlugin();
        int i = 0;
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective objective = board.registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("Scoreboard");

        Score score1 = objective.getScore(Bukkit.getOfflinePlayer("Mercenaries:"));
        Score score2 = objective.getScore(Bukkit.getOfflinePlayer("Builders:"));
        Score score3 = objective.getScore(Bukkit.getOfflinePlayer("Saboteurs:"));
        Score score4 = objective.getScore(Bukkit.getOfflinePlayer("Tower Blue:"));
        Score score5 = objective.getScore(Bukkit.getOfflinePlayer("Tower Red:"));

        plugin.bluetower = plugin.bluetower - plugin.blueareabot.getBlockY();
        if (plugin.bluetower < 0) {
            plugin.bluetower = 0;
        } else {
            plugin.bluetower = 10 * (plugin.bluetower + 1);
        }

        plugin.redtower = plugin.redtower - plugin.redareabot.getBlockY();
        if (plugin.redtower < 0) {
            plugin.redtower = 0;
        } else {
            plugin.redtower = 10 * (plugin.redtower + 1);
        }

        for (i = 0; i < plugin.playerblue.size(); i++) {
            if (player.getName().equalsIgnoreCase(plugin.playerblue.get(i).getName())) {
                score1.setScore(plugin.playerbluem.size());
                score2.setScore(plugin.playerblueb.size());
                score3.setScore(plugin.playerblues.size());
                score4.setScore(plugin.bluetower);
                score5.setScore(plugin.redtower);
                for (Player Test1 : plugin.playerblue) {
                    player.setScoreboard(board);
                }
            }
        }

        for (i = 0; i < plugin.playerred.size(); i++) {
            if (player.getName().equalsIgnoreCase(plugin.playerred.get(i).getName())) {
                score1.setScore(plugin.playerredm.size());
                score2.setScore(plugin.playerredb.size());
                score3.setScore(plugin.playerreds.size());
                score4.setScore(plugin.bluetower);
                score5.setScore(plugin.redtower);
                for (Player Test2 : plugin.playerred) {
                    player.setScoreboard(board);
                }
            }
        }
    }

    public void Area(Player player) {
        generateArea(player, "red");
        generateArea(player, "blue");
    }

    public void generateArea(Player player, String team) {
        BabelPlugin plugin = BabelPlugin.getPlugin();
        int MinX, MaxX, MinY, MaxY, MinZ, MaxZ, i;

        if (team.equalsIgnoreCase("red")) {
            if (plugin.redareatop.getBlockX() < plugin.redareabot.getBlockX()) {
                MinX = plugin.redareatop.getBlockX();
                MaxX = plugin.redareabot.getBlockX();
            } else {
                MinX = plugin.redareabot.getBlockX();
                MaxX = plugin.redareatop.getBlockX();
            }
            if (plugin.redareatop.getBlockY() < plugin.redareabot.getBlockY()) {
                MinY = plugin.redareatop.getBlockY();
                MaxY = plugin.redareabot.getBlockY();
            } else {
                MinY = plugin.redareabot.getBlockY();
                MaxY = plugin.redareatop.getBlockY();
            }
            if (plugin.redareatop.getBlockZ() < plugin.redareabot.getBlockZ()) {
                MinZ = plugin.redareatop.getBlockZ();
                MaxZ = plugin.redareabot.getBlockZ();
            } else {
                MinZ = plugin.redareabot.getBlockZ();
                MaxZ = plugin.redareatop.getBlockZ();
            }
            for (int x = MinX; x <= MaxX; x++) {
                for (int y = MinY; y <= MaxY; y++) {
                    for (int z = MinZ; z <= MaxZ; z++) {
                        Location loc = new Location(player.getWorld(), x, y, z);
                        plugin.areared.add(loc);
                    }
                }
            }
        } else if (team.equalsIgnoreCase("blue")) {
            if (plugin.blueareatop.getBlockX() < plugin.blueareabot.getBlockX()) {
                MinX = plugin.blueareatop.getBlockX();
                MaxX = plugin.blueareabot.getBlockX();
            } else {
                MinX = plugin.blueareabot.getBlockX();
                MaxX = plugin.blueareatop.getBlockX();
            }
            if (plugin.blueareatop.getBlockY() < plugin.blueareabot.getBlockY()) {
                MinY = plugin.blueareatop.getBlockY();
                MaxY = plugin.blueareabot.getBlockY();
            } else {
                MinY = plugin.blueareabot.getBlockY();
                MaxY = plugin.blueareatop.getBlockY();
            }
            if (plugin.blueareatop.getBlockZ() < plugin.blueareabot.getBlockZ()) {
                MinZ = plugin.blueareatop.getBlockZ();
                MaxZ = plugin.blueareabot.getBlockZ();
            } else {
                MinZ = plugin.blueareabot.getBlockZ();
                MaxZ = plugin.blueareatop.getBlockZ();
            }
            for (int x = MinX; x <= MaxX; x++) {
                for (int y = MinY; y <= MaxY; y++) {
                    for (int z = MinZ; z <= MaxZ; z++) {
                        Location loc = new Location(player.getWorld(), x, y, z);
                        plugin.areablue.add(loc);
                    }
                }
            }
        }
    }

    public void checktower(Player sender) {
        BabelPlugin plugin = BabelPlugin.getPlugin();
        int i;
        plugin.bluetower = 0;
        plugin.redtower = 0;
        for (i = 0; i < plugin.areablue.size(); i++) {
            if (plugin.areablue.get(i).getBlock().getTypeId() == 12) {
                if (plugin.areablue.get(i).getBlockY() > plugin.bluetower) {
                    plugin.bluetower = plugin.areablue.get(i).getBlockY();
                }
            }
        }
        for (i = 0; i < plugin.areared.size(); i++) {
            if (plugin.areared.get(i).getBlock().getTypeId() == 12) {
                if (plugin.areared.get(i).getBlockY() > plugin.redtower) {
                    plugin.redtower = plugin.areared.get(i).getBlockY();
                }
            }
        }
        scoreboard(sender);
    }

    public void hideScoreboard() {
        BabelPlugin plugin = BabelPlugin.getPlugin();
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        board.clearSlot(DisplaySlot.SIDEBAR);
        for (Player Test2 : plugin.playerred) {
            Test2.setScoreboard(board);
        }
        for (Player Test1 : plugin.playerblue) {
            Test1.setScoreboard(board);
        }
    }
}
