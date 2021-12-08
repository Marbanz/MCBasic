package me.marbanz.mcbasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.marbanz.mcbasic.Main.plugin;

public class Feed implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("feed")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.feed")) {
                    if (args.length == 0) {
                        p.setFoodLevel(20);
                        p.sendMessage("§aFed!");
                        plugin.getLogger().info(p.getPlayer().getName() + " has fed himself");
                        return true;
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("@a")) {
                            for (Player target : plugin.getServer().getOnlinePlayers()) {
                                if (target != null) {
                                    target.setFoodLevel(20);
                                    target.sendMessage("§aYou have been fed!");
                                }
                            }
                            sender.sendMessage("§aYou fed §eall the players§a!");
                            plugin.getLogger().info(p.getPlayer().getName() + " fed all the players");
                        } else {
                            Player target = Bukkit.getServer().getPlayerExact(args[0]);
                            if (target != null) {
                                target.setFoodLevel(20);
                                target.sendMessage("§aYou have been fed!");
                                sender.sendMessage("§aYou fed §e" + target.getPlayer().getName() + "§a!");
                                plugin.getLogger().info(p.getPlayer().getName() + " fed "
                                        + target.getPlayer().getName());
                            } else
                                sender.sendMessage("§cPlayer not found");
                        }
                        return true;
                    }
                } else {
                    sender.sendMessage("§cYou don't have permissions to execute this command");
                    return true;
                }
            }
            if (sender instanceof ConsoleCommandSender) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("@a")) {
                        for (Player target : plugin.getServer().getOnlinePlayers()) {
                            if (target != null) {
                                target.setFoodLevel(20);
                                target.sendMessage("§aYou have been fed!");
                            }
                        }
                        sender.sendMessage("You fed all the players!");
                        plugin.getLogger().info("Console fed all the players");
                    } else {
                        Player target = Bukkit.getServer().getPlayerExact(args[0]);
                        if (target != null) {
                            target.setFoodLevel(20);
                            target.sendMessage("§aYou have been fed!");
                            sender.sendMessage("You fed " + target.getPlayer().getName() + " !");
                            plugin.getLogger().info("Console fed " + target.getPlayer().getName());
                        } else
                            sender.sendMessage("Player not found");
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
