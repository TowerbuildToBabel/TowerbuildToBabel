        BabelPlugin plugin = BabelPlugin.getPlugin();
        if (Bukkit.getWorlds().size() == 3 && (ev.getPlayer().getWorld().getName().equalsIgnoreCase("babel"))) {
            int i;
            ev.setJoinMessage(ChatColor.DARK_GRAY + "[BabelPlugin] " + ev.getPlayer().getName() + " has joined the game!");

            io.generateLocations(ev.getPlayer());
            func.Area(ev.getPlayer());

            ev.getPlayer().getInventory().clear();
            ev.getPlayer().getInventory().setLeggings(new ItemStack(Material.AIR));
            ev.getPlayer().getInventory().setChestplate(new ItemStack(Material.AIR));
            ev.getPlayer().getInventory().setBoots(new ItemStack(Material.AIR));
            ev.getPlayer().getInventory().setHelmet(new ItemStack(Material.AIR));


            try {
                if (plugin.status.equalsIgnoreCase("join")) {
                    ev.getPlayer().teleport(plugin.lobby);
                    ev.getPlayer().getWorld().setPVP(false);
                } else if (plugin.status.equalsIgnoreCase("end")) {
                    ev.getPlayer().teleport(plugin.end);
                    ev.getPlayer().getWorld().setPVP(false);
                } else if (plugin.status.equalsIgnoreCase("play")) {
                    Boolean test = Boolean.valueOf(false);
                    for (i = 0; i < plugin.playerblue.size(); i++) {
                        if (ev.getPlayer().getName().equalsIgnoreCase(((Player) plugin.playerblue.get(i)).getName())) {
                            ev.getPlayer().teleport(plugin.spawnblue);
                            ev.getPlayer().getWorld().setPVP(true);
                            test = Boolean.valueOf(true);
                        }
                    }
                    for (i = 0; i < plugin.playerred.size(); i++) {
                        if (ev.getPlayer().getName().equalsIgnoreCase(((Player) plugin.playerred.get(i)).getName())) {
                            ev.getPlayer().teleport(plugin.spawnred);
                            ev.getPlayer().getWorld().setPVP(true);
                            test = Boolean.valueOf(true);
                        }
                    }
                    if (!test.booleanValue()) {
                        ev.getPlayer().teleport(plugin.lobby);
                        ev.getPlayer().getWorld().setPVP(false);
                    } else {
                        func.helmet(ev.getPlayer());
                        func.removeKlasse(ev.getPlayer());
                    }
                }
            } catch (Exception e) {
                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "[BabelPlugin] Location not found!");
            }
        }
    }

    public void onLeave(PlayerQuitEvent ev) {
        ev.setQuitMessage(ChatColor.DARK_GRAY + "[BabelPlugin] " + ev.getPlayer().getName() + " has left the game!");
    }
}
