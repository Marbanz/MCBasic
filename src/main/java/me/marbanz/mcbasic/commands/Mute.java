package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import me.marbanz.mcbasic.utils.Resources;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Mute implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("mute")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.mute")) {
                    if (args.length == 1) {
                        Player target = Bukkit.getServer().getPlayerExact(args[0]);
                        if (target != null) {
                            if (Resources.mutedPlayers.contains(target)) {
                                p.sendMessage("§aThe player is already muted!");
                            } else {
                                p.sendMessage("§aPlayer muted!");
                                MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " muted " + target.getPlayer().getName());
                                Resources.mutedPlayers.add(target);
                                Resources.savemutedPlayers();
                            }
                        } else
                            sender.sendMessage("§cPlayer not found");
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
                        if (Resources.mutedPlayers.contains(target)) {
                            sender.sendMessage("The player is already muted!");
                        } else {
                            sender.sendMessage("Player muted!");
                            MCBasic.getPlugin().getLogger().info("Console muted " + target.getPlayer().getName());
                            Resources.mutedPlayers.add(target);
                            Resources.savemutedPlayers();
                        }
                    } else
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
