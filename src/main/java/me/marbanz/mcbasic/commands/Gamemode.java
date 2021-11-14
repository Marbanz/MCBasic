package me.marbanz.mcbasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.marbanz.mcbasic.Main.plugin;

public class Gamemode implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("gamemode")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.gamemode")) {
                    if (args.length == 0) {
                        return false;
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")
                                || args[0].equalsIgnoreCase("c")) {
                            p.setGameMode(GameMode.CREATIVE);
                            p.sendMessage("§aGamemode set to §eCreative§a!");
                            plugin.getLogger().info(p.getPlayer().getName() + " set his gamemode to Creative");
                        } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")
                                || args[0].equalsIgnoreCase("s")) {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage("§aGamemode set to §eSurvival§a!");
                            plugin.getLogger().info(p.getPlayer().getName() + " set his gamemode to Survival");
                        } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")
                                || args[0].equalsIgnoreCase("a")) {
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage("§aGamemode set to §eAdventure§a!");
                            plugin.getLogger().info(p.getPlayer().getName() + " set his gamemode to Adventure");
                        } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")
                                || args[0].equalsIgnoreCase("sp")) {
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage("§aGamemode set to §eSpectator§a!");
                            plugin.getLogger().info(p.getPlayer().getName() + " set his gamemode to Spectator");
                        } else {
                            return false;
                        }
                        return true;
                    }
                    if (args.length == 2) {
                        Player target = Bukkit.getServer().getPlayerExact(args[1]);
                        Player player = (Player) sender;
                        if (target != null) {
                            if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")
                                    || args[0].equalsIgnoreCase("c")) {
                                target.setGameMode(GameMode.CREATIVE);
                                target.sendMessage("§aGamemode set to §eCreative§a!");
                                sender.sendMessage("§e" + target.getPlayer().getName() + "§a is in §eCreative§a!");
                                plugin.getLogger().info(player.getPlayer().getName() + " set "
                                        + target.getPlayer().getName() + " gamemode to Creative");
                            } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")
                                    || args[0].equalsIgnoreCase("s")) {
                                target.setGameMode(GameMode.SURVIVAL);
                                target.sendMessage("§aGamemode set to §eSurvival§a!");
                                sender.sendMessage("§e" + target.getPlayer().getName() + "§a is in §eSurvival§a!");
                                plugin.getLogger().info(player.getPlayer().getName() + " set "
                                        + target.getPlayer().getName() + " gamemode to Survival");
                            } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")
                                    || args[0].equalsIgnoreCase("a")) {
                                target.setGameMode(GameMode.ADVENTURE);
                                target.sendMessage("§aGamemode set to §eAdventure§a!");
                                sender.sendMessage("§e" + target.getPlayer().getName() + "§a is in §eAdventure§a!");
                                plugin.getLogger().info(player.getPlayer().getName() + " set "
                                        + target.getPlayer().getName() + " gamemode to Adventure");
                            } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")
                                    || args[0].equalsIgnoreCase("sp")) {
                                target.setGameMode(GameMode.SPECTATOR);
                                target.sendMessage("§aGamemode set to §eSpectator§a!");
                                sender.sendMessage("§e" + target.getPlayer().getName() + "§a is in §eSpectator§a!");
                                plugin.getLogger().info(player.getPlayer().getName() + " set "
                                        + target.getPlayer().getName() + " gamemode to Spectator");
                            } else {
                                return false;
                            }
                            return true;
                        } else
                            sender.sendMessage("§cPlayer not found");
                        return true;
                    }

                } else {
                    sender.sendMessage("§cYou don't have permissions to execute this command");
                    return true;
                }
            }
            if (sender instanceof ConsoleCommandSender) {
                if (args.length == 2) {
                    Player target = Bukkit.getServer().getPlayerExact(args[1]);
                    if (target != null) {
                        if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")
                                || args[0].equalsIgnoreCase("c")) {
                            target.setGameMode(GameMode.CREATIVE);
                            target.sendMessage("§aGamemode set to §eCreative§a!");
                            sender.sendMessage("You put " + target.getPlayer().getName() + " in Creative!");
                            plugin.getLogger().info("Console set " + target.getPlayer().getName() + " gamemode to Creative");
                        } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")
                                || args[0].equalsIgnoreCase("s")) {
                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage("§aGamemode set to §eSurvival§a!");
                            sender.sendMessage("You put " + target.getPlayer().getName() + " in Survival!");
                            plugin.getLogger().info("Console set " + target.getPlayer().getName() + " gamemode to Survival");
                        } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")
                                || args[0].equalsIgnoreCase("a")) {
                            target.setGameMode(GameMode.ADVENTURE);
                            target.sendMessage("§aGamemode set to §eAdventure§a!");
                            sender.sendMessage("You put " + target.getPlayer().getName() + " in Adventure!");
                            plugin.getLogger().info("Console set " + target.getPlayer().getName() + " gamemode to Adventure");
                        } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")
                                || args[0].equalsIgnoreCase("sp")) {
                            target.setGameMode(GameMode.SPECTATOR);
                            target.sendMessage("§aGamemode set to §eSpectator§a!");
                            sender.sendMessage("You put " + target.getPlayer().getName() + " in Spectator!");
                            plugin.getLogger().info("Console set " + target.getPlayer().getName() + " gamemode to Spectator");
                        } else {
                            return false;
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
