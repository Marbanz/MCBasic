package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

import static me.marbanz.mcbasic.Main.plugin;

public class Unmute implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("unmute")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.unmute")) {
                    if (args.length == 1) {
                        Player target = Bukkit.getServer().getPlayerExact(args[0]);
                        if (target != null) {
                            if (Main.muteConfiguration.getBoolean(target.getPlayer().getName())) {
                                p.sendMessage("§aThe player is now unmuted!");
                                plugin.getLogger().info(p.getPlayer().getName() + " unmuted " + target.getPlayer().getName());
                                Main.muteConfiguration.set(target.getPlayer().getName(), null);
                                try {
                                    Main.muteConfiguration.save(Main.muteFile);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                p.sendMessage("§aThe player in not muted!");
                            }
                            return true;
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
                        if (Main.muteConfiguration.getBoolean(target.getPlayer().getName())) {
                            sender.sendMessage("The player is now unmuted!");
                            plugin.getLogger().info("Console unmuted " + target.getPlayer().getName());
                            Main.muteConfiguration.set(target.getPlayer().getName(), null);
                            try {
                                Main.muteConfiguration.save(Main.muteFile);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            sender.sendMessage("The player in not muted!");
                        }
                        return true;
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
