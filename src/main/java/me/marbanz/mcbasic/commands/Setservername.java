package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class Setservername implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setservername")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.setservername")) {
                    if (args.length >= 1) {
                        String str = String.join(" ", args);
                        MCBasic.getPlugin().getConfig().set("settings.server_name", str);
                        MCBasic.getPlugin().saveConfig();
                        p.sendMessage("§aName set!");
                        MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " set the name of the server to " + str);
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
                if (args.length >= 1) {
                    String str = String.join(" ", args);
                    MCBasic.getPlugin().getConfig().set("settings.server_name", str);
                    MCBasic.getPlugin().saveConfig();
                    sender.sendMessage("Name set!");
                    MCBasic.getPlugin().getLogger().info("Console set the name of the server to " + str);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}