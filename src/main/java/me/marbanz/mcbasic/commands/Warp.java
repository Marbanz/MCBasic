package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.utils.Warpmanager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.marbanz.mcbasic.Main.plugin;

public class Warp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("warp")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.warp")) {
                    if (args.length == 1) {
                        if (Warpmanager.exists(args[0])) {
                            p.teleport(Warpmanager.getWarp(args[0]));
                            p.sendMessage("§aTeleported to warp §e" + args[0] + "§a!");
                            plugin.getLogger().info(p.getPlayer().getName() + " teleported to warp " + args[0]);
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
                sender.sendMessage("You can't do this command from the console!");
                return true;
            }
        }
        return false;
    }
}