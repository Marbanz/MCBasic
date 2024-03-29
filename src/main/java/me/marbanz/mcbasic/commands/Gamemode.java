package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

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
                            MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " set his gamemode to Creative");
                        } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")
                                || args[0].equalsIgnoreCase("s")) {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.sendMessage("§aGamemode set to §eSurvival§a!");
                            MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " set his gamemode to Survival");
                        } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")
                                || args[0].equalsIgnoreCase("a")) {
                            p.setGameMode(GameMode.ADVENTURE);
                            p.sendMessage("§aGamemode set to §eAdventure§a!");
                            MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " set his gamemode to Adventure");
                        } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")
                                || args[0].equalsIgnoreCase("sp")) {
                            p.setGameMode(GameMode.SPECTATOR);
                            p.sendMessage("§aGamemode set to §eSpectator§a!");
                            MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " set his gamemode to Spectator");
                        } else {
                            return false;
                        }
                        return true;
                    }
                    if (args.length == 2) {
                        Player target = Bukkit.getServer().getPlayerExact(args[1]);
                        Player player = (Player) sender;
                        if (target != null || args[1].equalsIgnoreCase("@a")) {
                            if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")
                                    || args[0].equalsIgnoreCase("c")) {
                                if (args[1].equalsIgnoreCase("@a")) {
                                    for (Player target2 : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                                        if (target2 != null) {
                                            target2.setGameMode(GameMode.CREATIVE);
                                            target2.sendMessage("§aGamemode set to §eCreative§a!");
                                        }
                                    }
                                    sender.sendMessage("§eAll the players §aare in §eCreative§a!");
                                    MCBasic.getPlugin().getLogger().info(player.getPlayer().getName() + " set all the players gamemode to Creative");
                                } else {
                                    target.setGameMode(GameMode.CREATIVE);
                                    target.sendMessage("§aGamemode set to §eCreative§a!");
                                    sender.sendMessage("§e" + target.getPlayer().getName() + "§a is in §eCreative§a!");
                                    MCBasic.getPlugin().getLogger().info(player.getPlayer().getName() + " set "
                                            + target.getPlayer().getName() + " gamemode to Creative");
                                }
                            } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")
                                    || args[0].equalsIgnoreCase("s")) {
                                if (args[1].equalsIgnoreCase("@a")) {
                                    for (Player target2 : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                                        if (target2 != null) {
                                            target2.setGameMode(GameMode.SURVIVAL);
                                            target2.sendMessage("§aGamemode set to §eSurvival§a!");
                                        }
                                    }
                                    sender.sendMessage("§eAll the players §aare in §eSurvival§a!");
                                    MCBasic.getPlugin().getLogger().info(player.getPlayer().getName() + " set all the players gamemode to Survival");
                                } else {
                                    target.setGameMode(GameMode.SURVIVAL);
                                    target.sendMessage("§aGamemode set to §eSurvival§a!");
                                    sender.sendMessage("§e" + target.getPlayer().getName() + "§a is in §eSurvival§a!");
                                    MCBasic.getPlugin().getLogger().info(player.getPlayer().getName() + " set "
                                            + target.getPlayer().getName() + " gamemode to Survival");
                                }
                            } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")
                                    || args[0].equalsIgnoreCase("a")) {
                                if (args[1].equalsIgnoreCase("@a")) {
                                    for (Player target2 : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                                        if (target2 != null) {
                                            target2.setGameMode(GameMode.ADVENTURE);
                                            target2.sendMessage("§aGamemode set to §eAdventure§a!");
                                        }
                                    }
                                    sender.sendMessage("§eAll the players §aare in §eAdventure§a!");
                                    MCBasic.getPlugin().getLogger().info(player.getPlayer().getName() + " set all the players gamemode to Adventure");
                                } else {
                                    target.setGameMode(GameMode.ADVENTURE);
                                    target.sendMessage("§aGamemode set to §eAdventure§a!");
                                    sender.sendMessage("§e" + target.getPlayer().getName() + "§a is in §eAdventure§a!");
                                    MCBasic.getPlugin().getLogger().info(player.getPlayer().getName() + " set "
                                            + target.getPlayer().getName() + " gamemode to Adventure");
                                }
                            } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")
                                    || args[0].equalsIgnoreCase("sp")) {
                                if (args[1].equalsIgnoreCase("@a")) {
                                    for (Player target2 : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                                        if (target2 != null) {
                                            target2.setGameMode(GameMode.SPECTATOR);
                                            target2.sendMessage("§aGamemode set to §eSpectator§a!");
                                        }
                                    }
                                    sender.sendMessage("§eAll the players §aare in §eSpectator§a!");
                                    MCBasic.getPlugin().getLogger().info(player.getPlayer().getName() + " set all the players gamemode to Spectator");
                                } else {
                                    target.setGameMode(GameMode.SPECTATOR);
                                    target.sendMessage("§aGamemode set to §eSpectator§a!");
                                    sender.sendMessage("§e" + target.getPlayer().getName() + "§a is in §eSpectator§a!");
                                    MCBasic.getPlugin().getLogger().info(player.getPlayer().getName() + " set "
                                            + target.getPlayer().getName() + " gamemode to Spectator");
                                }
                            } else {
                                return false;
                            }
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
                    if (target != null || args[1].equalsIgnoreCase("@a")) {
                        if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")
                                || args[0].equalsIgnoreCase("c")) {
                            if (args[1].equalsIgnoreCase("@a")) {
                                for (Player target2 : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                                    if (target2 != null) {
                                        target2.setGameMode(GameMode.CREATIVE);
                                        target2.sendMessage("§aGamemode set to §eCreative§a!");
                                    }
                                }
                                sender.sendMessage("You put all the players in Creative!");
                                MCBasic.getPlugin().getLogger().info("Console set all the players gamemode to Creative");
                            } else {
                                target.setGameMode(GameMode.CREATIVE);
                                target.sendMessage("§aGamemode set to §eCreative§a!");
                                sender.sendMessage("You put " + target.getPlayer().getName() + " in Creative!");
                                MCBasic.getPlugin().getLogger().info("Console set " + target.getPlayer().getName() + " gamemode to Creative");
                            }
                        } else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")
                                || args[0].equalsIgnoreCase("s")) {
                            if (args[1].equalsIgnoreCase("@a")) {
                                for (Player target2 : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                                    if (target2 != null) {
                                        target2.setGameMode(GameMode.SURVIVAL);
                                        target2.sendMessage("§aGamemode set to Survival§a!");
                                    }
                                }
                                sender.sendMessage("You put all the players in Survival!");
                                MCBasic.getPlugin().getLogger().info("Console set all the players gamemode to Survival");
                            } else {
                                target.setGameMode(GameMode.SURVIVAL);
                                target.sendMessage("§aGamemode set to §eSurvival§a!");
                                sender.sendMessage("You put " + target.getPlayer().getName() + " in Survival!");
                                MCBasic.getPlugin().getLogger().info("Console set " + target.getPlayer().getName() + " gamemode to Survival");
                            }
                        } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")
                                || args[0].equalsIgnoreCase("a")) {
                            if (args[1].equalsIgnoreCase("@a")) {
                                for (Player target2 : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                                    if (target2 != null) {
                                        target2.setGameMode(GameMode.ADVENTURE);
                                        target2.sendMessage("§aGamemode set to §eAdventure§a!");
                                    }
                                }
                                sender.sendMessage("You put all the players in Adventure!");
                                MCBasic.getPlugin().getLogger().info("Console set all the players gamemode to Adventure");
                            } else {
                                target.setGameMode(GameMode.ADVENTURE);
                                target.sendMessage("§aGamemode set to §eAdventure§a!");
                                sender.sendMessage("You put " + target.getPlayer().getName() + " in Adventure!");
                                MCBasic.getPlugin().getLogger().info("Console set " + target.getPlayer().getName() + " gamemode to Adventure");
                            }
                        } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")
                                || args[0].equalsIgnoreCase("sp")) {
                            if (args[1].equalsIgnoreCase("@a")) {
                                for (Player target2 : MCBasic.getPlugin().getServer().getOnlinePlayers()) {
                                    if (target2 != null) {
                                        target2.setGameMode(GameMode.SPECTATOR);
                                        target2.sendMessage("§aGamemode set to §eSpectator§a!");
                                    }
                                }
                                sender.sendMessage("You put all the players in Spectator!");
                                MCBasic.getPlugin().getLogger().info("Console set all the players gamemode to Spectator");
                            } else {
                                target.setGameMode(GameMode.SPECTATOR);
                                target.sendMessage("§aGamemode set to §eSpectator§a!");
                                sender.sendMessage("You put " + target.getPlayer().getName() + " in Spectator!");
                                MCBasic.getPlugin().getLogger().info("Console set " + target.getPlayer().getName() + " gamemode to Spectator");
                            }
                        } else {
                            return false;
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
