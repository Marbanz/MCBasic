package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import me.marbanz.mcbasic.utils.WarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Setwarp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("setwarp")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.setwarp")) {
                    if (args.length == 1) {
                        if (WarpManager.exists(args[0])) {
                            p.sendMessage("§cThis warp already exist");
                        } else {
                            WarpManager.addWarp(args[0], p.getLocation());
                            p.sendMessage("§aCreated warp §e" + args[0] + "§a!");
                            MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " created warp " + args[0]);
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
                sender.sendMessage("You can't do this command from the console!");
                return true;
            }
        }
        return false;
    }
}