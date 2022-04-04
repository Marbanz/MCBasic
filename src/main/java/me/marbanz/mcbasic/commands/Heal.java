package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.heal")) {
                    if (args.length == 0) {
                        p.setHealth(p.getMaxHealth());
                        p.sendMessage("§aHealed!");
                        MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " has healed himself");
                        return true;
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("@a")) {
                            for (Player target : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                                if (target != null) {
                                    target.setHealth(target.getMaxHealth());
                                    target.sendMessage("§aYou have been healed!");
                                }
                            }
                            p.sendMessage("§aYou healed §eall the players§a!");
                            MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " healed all the players");
                        } else {
                            Player target = Bukkit.getServer().getPlayerExact(args[0]);
                            Player player = (Player) sender;
                            if (target != null) {
                                target.setHealth(target.getMaxHealth());
                                target.sendMessage("§aYou have been healed!");
                                sender.sendMessage("§aYou healed §e" + target.getPlayer().getName() + "§a!");
                                MCBasic.getPlugin().getLogger().info(player.getPlayer().getName() + " healed "
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
                        for (Player target : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                            if (target != null) {
                                target.setHealth(target.getMaxHealth());
                                target.sendMessage("§aYou have been healed!");
                            }
                        }
                        sender.sendMessage("You healed all the players!");
                        MCBasic.getPlugin().getLogger().info("Console healed all the players");
                    } else {
                        Player target = Bukkit.getServer().getPlayerExact(args[0]);
                        if (target != null) {
                            target.setHealth(target.getMaxHealth());
                            target.sendMessage("§aYou have been healed!");
                            sender.sendMessage("You healed " + target.getPlayer().getName() + "!");
                            MCBasic.getPlugin().getLogger().info("Console healed " + target.getPlayer().getName());
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
