package me.bukkit.babelplugin.events;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.bukkit.babelplugin.BabelPlugin;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerPickUpListener implements Listener {

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent e) {
        if (e.getPlayer().getWorld().getName().equalsIgnoreCase("babel")) {
            BabelPlugin plugin = BabelPlugin.getPlugin();
            int i;

            if (e.getPlayer().isOp()) {
                return;
            }

            if (e.getItem().getItemStack().getTypeId() == 319) {
                return;
            }

            if (e.getItem().getItemStack().getTypeId() == 363) {
                return;
            }

            if (e.getItem().getItemStack().getTypeId() == 365) {
                return;
            }

            if (e.getItem().getItemStack().getTypeId() == 46) {
                for (i = 0; i < plugin.playerblues.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerblues.get(i).getName())) {
                        return;
                    }
                }
                for (i = 0; i < plugin.playerreds.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerreds.get(i).getName())) {
                        return;
                    }
                }
            }

            if (e.getItem().getItemStack().getTypeId() == 76) {
                for (i = 0; i < plugin.playerblues.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerblues.get(i).getName())) {
                        return;
                    }
                }
                for (i = 0; i < plugin.playerreds.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerreds.get(i).getName())) {
                        return;
                    }
                }
            }

            if (e.getItem().getItemStack().getTypeId() == 262) {
                for (i = 0; i < plugin.playerbluem.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerbluem.get(i).getName())) {
                        return;
                    }
                }
                for (i = 0; i < plugin.playerredm.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerredm.get(i).getName())) {
                        return;
                    }
                }
            }
            if (e.getItem().getItemStack().getTypeId() == 12) {
                for (i = 0; i < plugin.playerblueb.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerblueb.get(i).getName())) {
                        if (e.getPlayer().getInventory().contains(12, 20)) {
                        } else {
                            do {
                                if (e.getItem().getItemStack().getAmount() >= 2) {
                                    e.getItem().getItemStack().setAmount(e.getItem().getItemStack().getAmount() - 1);
                                    if (e.getPlayer().getInventory().contains(Material.SAND)) {
                                        e.getPlayer().getInventory().getItem(e.getPlayer().getInventory().first(Material.SAND)).setAmount(e.getPlayer().getInventory().getItem(e.getPlayer().getInventory().first(Material.SAND)).getAmount() + 1);
                                    } else {
                                        e.getPlayer().getInventory().addItem(new ItemStack(12, 1));
                                    }
                                } else if (e.getItem().getItemStack().getAmount() == 1) {
                                    if (e.getPlayer().getInventory().contains(Material.SAND)) {
                                        e.getPlayer().getInventory().getItem(e.getPlayer().getInventory().first(Material.SAND)).setAmount(e.getPlayer().getInventory().getItem(e.getPlayer().getInventory().first(Material.SAND)).getAmount() + 1);
                                    } else {
                                        e.getPlayer().getInventory().addItem(new ItemStack(12, 1));
                                    }
                                    e.getItem().remove();
                                    break;
                                }
                            } while (e.getPlayer().getInventory().getItem(e.getPlayer().getInventory().first(Material.SAND)).getAmount() < 20);
                            e.getItem().setItemStack(new ItemStack(12, e.getItem().getItemStack().getAmount()));
                            e.getPlayer().updateInventory();
                        }
                    }
                }
                for (i = 0; i < plugin.playerredb.size(); i++) {
                    if (e.getPlayer().getName().equalsIgnoreCase(plugin.playerredb.get(i).getName())) {
                        if (e.getPlayer().getInventory().contains(12, 20)) {
                        } else {
                            do {
                                if (e.getItem().getItemStack().getAmount() >= 2) {
                                    e.getItem().getItemStack().setAmount(e.getItem().getItemStack().getAmount() - 1);
                                    if (e.getPlayer().getInventory().contains(Material.SAND)) {
                                        e.getPlayer().getInventory().getItem(e.getPlayer().getInventory().first(Material.SAND)).setAmount(e.getPlayer().getInventory().getItem(e.getPlayer().getInventory().first(Material.SAND)).getAmount() + 1);
                                    } else {
                                        e.getPlayer().getInventory().addItem(new ItemStack(12, 1));
                                    }
                                } else if (e.getItem().getItemStack().getAmount() == 1) {
                                    if (e.getPlayer().getInventory().contains(Material.SAND)) {
                                        e.getPlayer().getInventory().getItem(e.getPlayer().getInventory().first(Material.SAND)).setAmount(e.getPlayer().getInventory().getItem(e.getPlayer().getInventory().first(Material.SAND)).getAmount() + 1);
                                    } else {
                                        e.getPlayer().getInventory().addItem(new ItemStack(12, 1));
                                    }
                                    e.getItem().remove();
                                    break;
                                }
                            } while (e.getPlayer().getInventory().getItem(e.getPlayer().getInventory().first(Material.SAND)).getAmount() < 20);
                            e.getItem().setItemStack(new ItemStack(12, e.getItem().getItemStack().getAmount()));
                            e.getPlayer().updateInventory();
                        }
                    }
                }
            }


            e.setCancelled(true);
            e.getPlayer().updateInventory();

        }
    }
}
