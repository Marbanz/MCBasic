package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.utils.Warpmanager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.marbanz.mcbasic.Main.plugin;

public class Tpwarp implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpwarp")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.tpwarp")) {
                    if (args.length == 2) {
                        if (args[1].equalsIgnoreCase("@a")) {
                            if (Warpmanager.exists(args[0])) {
                                for (Player target : plugin.getServer().getOnlinePlayers()) {
                                    if (target != null) {
                                        target.teleport(Warpmanager.getWarp(args[0]));
                                        target.sendMessage("§aTeleported to warp §e" + args[0] + "§a!");
                                    }
                                }
                                sender.sendMessage("§aTeleported §eall the players §ato warp §e" + args[0] + "§a!");
                                plugin.getLogger().info(p.getPlayer().getName() + " teleported all the players to the warp " + args[0]);
                            } else {
                                sender.sendMessage("§aThe warp §e" + args[0] + "§a does not exist!");
                                return true;
                            }
                        } else {
                            Player target = Bukkit.getServer().getPlayerExact(args[1]);
                            if (target != null) {
                                if (Warpmanager.exists(args[0])) {
                                    target.teleport(Warpmanager.getWarp(args[0]));
                                    target.sendMessage("§aTeleported to warp §e" + args[0] + "§a!");
                                    sender.sendMessage("§aTeleported §e" + target.getPlayer().getName() + "§a to the warp §e" + args[0] + "§a!");
                                    plugin.getLogger().info(p.getPlayer().getName() + " teleported " + target.getPlayer().getName() + " to warp " + args[0]);
                                } else {
                                    sender.sendMessage("§aThe warp §e" + args[0] + "§a does not exist!");
                                    return true;
                                }
                            } else sender.sendMessage("§cPlayer not found");
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
                if (args.length == 2) {
                    if (args[1].equalsIgnoreCase("@a")) {
                        if (Warpmanager.exists(args[0])) {
                            for (Player target : plugin.getServer().getOnlinePlayers()) {
                                if (target != null) {
                                    target.teleport(Warpmanager.getWarp(args[0]));
                                    target.sendMessage("§aTeleported to warp §e" + args[0] + "§a!");
                                }
                            }
                            sender.sendMessage("Teleported all the players to warp " + args[0] + "!");
                            plugin.getLogger().info("Console teleported all the players to the warp " + args[0]);
                        } else {
                            sender.sendMessage("The warp " + args[0] + " does not exist!");
                            return true;
                        }
                    } else {
                        Player target = Bukkit.getServer().getPlayerExact(args[1]);
                        if (target != null) {
                            if (Warpmanager.exists(args[0])) {
                                target.teleport(Warpmanager.getWarp(args[0]));
                                target.sendMessage("§aTeleported to warp §e" + args[0] + "§a!");
                                sender.sendMessage("Teleported " + target.getPlayer().getName() + " to warp " + args[0] + "!");
                                plugin.getLogger().info("Console teleported " + target.getPlayer().getName() + " to warp " + args[0]);
                            } else {
                                sender.sendMessage("The warp " + args[0] + " does not exist!");
                                return true;
                            }
                        } else sender.sendMessage("Player not found");
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
