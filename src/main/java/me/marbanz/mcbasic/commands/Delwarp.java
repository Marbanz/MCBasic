package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import me.marbanz.mcbasic.utils.Warpmanager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Delwarp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("delwarp")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.delwarp")) {
                    if (args.length == 1) {
                        if (Warpmanager.exists(args[0])) {
                            Warpmanager.removeWarp(args[0]);
                            p.sendMessage("§aWarp deleted!");
                            MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " deleted the warp " + args[0]);
                        } else {
                            p.sendMessage("§cThe warp §e" + args[0] + "§c does not exist!");
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
                if (args.length == 1) {
                    if (Warpmanager.exists(args[0])) {
                        Warpmanager.removeWarp(args[0]);
                        sender.sendMessage("Warp deleted!");
                        MCBasic.getPlugin().getLogger().info("Console deleted the warp " + args[0]);
                    } else {
                        sender.sendMessage("The warp " + args[0] + " does not exist!");
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