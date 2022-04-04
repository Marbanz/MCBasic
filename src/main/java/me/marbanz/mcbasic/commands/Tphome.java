package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import me.marbanz.mcbasic.utils.Resources;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Tphome implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tphome")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.tphome")) {
                    if (args.length == 1) {
                        Player target = Bukkit.getServer().getPlayerExact(args[0]);
                        if (target != null) {
                            if (Resources.homeConfiguration.getConfigurationSection(target.getPlayer().getName() + ".home") == null) {
                                p.sendMessage("§cThe home has not yet been set!");
                            } else {
                                World w = Bukkit.getServer().getWorld(Resources.homeConfiguration.getString(target.getPlayer().getName() + ".home.world"));
                                double x = Resources.homeConfiguration.getDouble(target.getPlayer().getName() + ".home.x");
                                double y = Resources.homeConfiguration.getDouble(target.getPlayer().getName() + ".home.y");
                                double z = Resources.homeConfiguration.getDouble(target.getPlayer().getName() + ".home.z");
                                target.teleport(new Location(w, x, y, z));
                                p.sendMessage("§aTeleported §e" + target.getPlayer().getName() + "§a to his home!");
                                MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " teleported " + target.getPlayer().getName() + " to his home");
                            }
                        } else {
                            sender.sendMessage("§cPlayer not found");
                            return true;
                        }
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    sender.sendMessage("§cYou don't have permissions to execute this command");
                    return true;
                }
            }
            if (sender instanceof ConsoleCommandSender) {
                if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayerExact(args[0]);
                    if (target != null) {
                        if (Resources.homeConfiguration.getConfigurationSection(target.getPlayer().getName() + ".home") == null) {
                            sender.sendMessage("The home has not yet been set!");
                        } else {
                            World w = Bukkit.getServer().getWorld(Resources.homeConfiguration.getString(target.getPlayer().getName() + ".home.world"));
                            double x = Resources.homeConfiguration.getDouble(target.getPlayer().getName() + ".home.x");
                            double y = Resources.homeConfiguration.getDouble(target.getPlayer().getName() + ".home.y");
                            double z = Resources.homeConfiguration.getDouble(target.getPlayer().getName() + ".home.z");
                            target.teleport(new Location(w, x, y, z));
                            sender.sendMessage("Teleported " + target.getPlayer().getName() + " to his home!");
                            MCBasic.getPlugin().getLogger().info("Console teleported " + target.getPlayer().getName() + " to his home");
                        }
                    } else {
                        sender.sendMessage("Player not found");
                        return true;
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}