package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import me.marbanz.mcbasic.utils.CoordinatesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Coordinates implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("coordinates")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.coordinates")) {
                    if (args.length >= 1) {
                        switch (args[0]) {
                            case "list": {
                                CoordinatesManager.shouldCoordinatesList(p);
                                return true;
                            }
                            case "add": {
                                if (args.length == 2) {
                                    if (CoordinatesManager.exists(args[1])) {
                                        p.sendMessage("§cThis coordinates already exist");
                                    } else {
                                        CoordinatesManager.addCoordinates(args[1], p.getLocation());
                                        p.sendMessage("§aStored coordinates §e" + args[1] + "§a!");
                                        MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " stored coordinates " + args[1]);
                                    }
                                } else {
                                    p.sendMessage("§cYou need to write the name of the coordinates");
                                }
                                return true;
                            }
                            case "remove": {
                                if (args.length == 2) {
                                    if (CoordinatesManager.exists(args[1])) {
                                        CoordinatesManager.removeCoordinates(args[1]);
                                        p.sendMessage("§aCoordinates deleted!");
                                        MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " deleted the coordinates " + args[1]);
                                    } else {
                                        p.sendMessage("§cThe coordinates §e" + args[1] + "§c does not exist!");
                                    }

                                } else {
                                    p.sendMessage("§cYou need to write the name of the coordinates");
                                }
                                return true;
                            }
                            case "location": {
                                if (args.length == 2) {
                                    if (CoordinatesManager.exists(args[1])) {
                                        CoordinatesManager.getCoordinates(p, args[1]);
                                    } else {
                                        p.sendMessage("§cThe coordinates §e" + args[1] + "§c does not exist!");
                                    }
                                } else {
                                    p.sendMessage("§cYou need to write the name of the coordinates");
                                }
                                return true;
                            }
                            default: {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }
            if (sender instanceof ConsoleCommandSender) {
                if (args.length >= 1) {
                    switch (args[0]) {
                        case "list": {
                            CoordinatesManager.shouldCoordinatesListConsole(sender);
                            return true;
                        }
                        case "remove": {
                            if (args.length == 2) {
                                if (CoordinatesManager.exists(args[1])) {
                                    CoordinatesManager.removeCoordinates(args[1]);
                                    sender.sendMessage("Coordinates deleted!");
                                    MCBasic.getPlugin().getLogger().info("Console deleted the coordinates " + args[1]);
                                } else {
                                    sender.sendMessage("The coordinates " + args[1] + " does not exist!");
                                }
                            } else {
                                sender.sendMessage("You need to write the name of the coordinates");
                            }
                            return true;
                        }
                        default: {
                            sender.sendMessage("Use: /coordinates [list|remove]");
                            return true;
                        }
                    }
                } else {
                    sender.sendMessage("Use: /coordinates [list|remove]");
                    return true;
                }
            }
        }
        return false;
    }
}
