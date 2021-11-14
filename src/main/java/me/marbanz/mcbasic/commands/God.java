package me.marbanz.mcbasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.marbanz.mcbasic.Main.plugin;

public class God implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("god")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.god")) {
                    if (args.length == 0) {
                        if (p.isInvulnerable()) {
                            p.setInvulnerable(false);
                            p.sendMessage("§aGod mode disabled");
                            plugin.getLogger().info(p.getPlayer().getName() + " disabled god mode for himself");
                        } else {
                            p.setInvulnerable(true);
                            p.sendMessage("§aGod mode enabled");
                            plugin.getLogger().info(p.getPlayer().getName() + " enabled god mode for himself");
                        }
                        return true;
                    } else if (args.length == 1) {
                        Player target = Bukkit.getServer().getPlayerExact(args[0]);
                        if (target != null) {
                            if (target.isInvulnerable()) {
                                target.setInvulnerable(false);
                                p.sendMessage("§aGod mode disabled for §e" + target.getPlayer().getName());
                                target.sendMessage("§aGod mode disabled");
                                plugin.getLogger().info(p.getPlayer().getName() + " disabled god mode for " + target.getPlayer().getName());
                            } else {
                                target.setInvulnerable(true);
                                p.sendMessage("§aGod mode enabled for §e" + target.getPlayer().getName());
                                target.sendMessage("§aGod mode enabled");
                                plugin.getLogger().info(p.getPlayer().getName() + " enabled god mode for " + target.getPlayer().getName());
                            }
                        } else
                            sender.sendMessage("§cPlayer not found");
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            if (sender instanceof ConsoleCommandSender) {
                if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayerExact(args[0]);
                    if (target != null) {
                        if (target.isInvulnerable()) {
                            target.setInvulnerable(false);
                            sender.sendMessage("God mode disabled for " + target.getPlayer().getName());
                            target.sendMessage("§aGod mode disabled");
                            plugin.getLogger().info("Console disabled god mode for " + target.getPlayer().getName());
                        } else {
                            target.setInvulnerable(true);
                            sender.sendMessage("God mode enabled for " + target.getPlayer().getName());
                            target.sendMessage("§aGod mode enabled");
                            plugin.getLogger().info("Console enabled god mode for " + target.getPlayer().getName());
                        }
                    }else
                        sender.sendMessage("Player not found");
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
