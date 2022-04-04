package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Tp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("tp")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.tp")) {
                    if (args.length == 1) {
                        Player target = Bukkit.getServer().getPlayerExact(args[0]);
                        Player player = (Player) sender;
                        if (target != null) {
                            p.teleport(target);
                            p.sendMessage("§aYou teleported to §e" + target.getPlayer().getName() + "§a!");
                            MCBasic.getPlugin().getLogger().info(player.getPlayer().getName() + " teleported to "
                                    + target.getPlayer().getName());
                        } else
                            sender.sendMessage("§cPlayer not found");
                        return true;
                    } else if (args.length == 2) {
                        Player target2 = Bukkit.getServer().getPlayerExact(args[1]);
                        if (args[0].equalsIgnoreCase("@a")) {
                            if (target2 != null) {
                                for (Player target : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                                    if (target != null)
                                        target.teleport(target2);
                                }
                                p.sendMessage("§aYou teleported §eall the players §ato §e" + target2.getPlayer().getName() + "§a!");
                                MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " teleported all the players to "
                                        + target2.getPlayer().getName());
                            } else
                                sender.sendMessage("§cPlayer not found");
                            return true;
                        } else {
                            Player target = Bukkit.getServer().getPlayerExact(args[0]);
                            if (target != null && target2 != null) {
                                target.teleport(target2);
                                p.sendMessage("§aYou teleported §e" + target.getPlayer().getName() + "§a to §e" + target2.getPlayer().getName() + "§a!");
                                MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " teleported " + target.getPlayer().getName() + " to "
                                        + target2.getPlayer().getName());
                            } else
                                sender.sendMessage("§cPlayer not found");
                        }
                        return true;
                    } else if (args.length == 3) {
                        try {
                            double x = Double.parseDouble(args[0]);
                            double y = Double.parseDouble(args[1]);
                            double z = Double.parseDouble(args[2]);
                            p.teleport(new Location(p.getWorld(), x, y, z));
                            p.sendMessage("§aYou teleported to the written coordinates!");
                            MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " teleported to X: " + x
                                    + " Y: " + y + " Z: " + z);
                        } catch (NumberFormatException e) {
                            sender.sendMessage("§cError in the coordinates or in the syntax of the command");
                            sender.sendMessage("§fUse: /tp <player> [<player> | <x> <y> <z>]");
                            return true;
                        }
                        return true;
                    } else if (args.length == 4) {
                        Player target = Bukkit.getServer().getPlayerExact(args[0]);
                        if (target != null) {
                            try {
                                double x = Double.parseDouble(args[1]);
                                double y = Double.parseDouble(args[2]);
                                double z = Double.parseDouble(args[3]);
                                target.teleport(new Location(p.getWorld(), x, y, z));
                                p.sendMessage("§aYou teleported §e" + target.getPlayer().getName() + "§a to the written coordinates!");
                                MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " teleported " + target.getPlayer().getName() + " to X: " + x
                                        + " Y: " + y + " Z: " + z);
                            } catch (NumberFormatException e) {
                                sender.sendMessage("§cError in the coordinates or in the syntax of the command");
                                sender.sendMessage("§fUse: /tp <player> [<player> | <x> <y> <z>]");
                                return true;
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
                if (args.length == 2) {
                    Player target2 = Bukkit.getServer().getPlayerExact(args[1]);
                    if (args[0].equalsIgnoreCase("@a")) {
                        if (target2 != null) {
                            for (Player target : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                                if (target != null)
                                    target.teleport(target2);
                            }
                            sender.sendMessage("You teleported all the players to " + target2.getPlayer().getName() + "!");
                            MCBasic.getPlugin().getLogger().info("Console teleported all the players to "
                                    + target2.getPlayer().getName());
                        } else
                            sender.sendMessage("Player not found");
                        return true;
                    } else {
                        Player target = Bukkit.getServer().getPlayerExact(args[0]);
                        if (target != null && target2 != null) {
                            target.teleport(target2);
                            sender.sendMessage("You teleported " + target.getPlayer().getName() + " to " + target2.getPlayer().getName() + "!");
                            MCBasic.getPlugin().getLogger().info("Console teleported " + target.getPlayer().getName() + " to " + target2.getPlayer().getName());
                        } else
                            sender.sendMessage("Player not found");
                    }
                    return true;
                } else if (args.length == 4) {
                    Player target = Bukkit.getServer().getPlayerExact(args[0]);
                    if (target != null) {
                        try {
                            double x = Double.parseDouble(args[1]);
                            double y = Double.parseDouble(args[2]);
                            double z = Double.parseDouble(args[3]);
                            target.teleport(new Location(target.getWorld(), x, y, z));
                            sender.sendMessage("You teleported " + target.getPlayer().getName() + " to the written coordinates!");
                            MCBasic.getPlugin().getLogger().info("Console teleported " + target.getPlayer().getName() + " to X: " + x
                                    + " Y: " + y + " Z: " + z);
                        } catch (NumberFormatException e) {
                            sender.sendMessage("Error in the coordinates or in the syntax of the command");
                            sender.sendMessage("Use: /tp <player> [<player> | <x> <y> <z>]");
                            return true;
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