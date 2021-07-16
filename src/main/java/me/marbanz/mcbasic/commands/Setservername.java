package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Setservername implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setservername")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.setservername")) {
                    if (args.length > 1) {
                        String str = String.join(" ", args);
                        Main.getInstance().getConfig().set("settings.server_name", str);
                        Main.getInstance().saveConfig();
                        p.sendMessage("§aName set");
                        System.out.println("[MCBasic] " + p.getPlayer().getName() + " set the name of the server to " + str);
                    } else {
                        sender.sendMessage("§fUse: /setservername <server name>");
                    }
                } else {
                    sender.sendMessage("§cYou don't have permissions to execute this command");
                }
                return true;
            }
            if (sender instanceof ConsoleCommandSender) {
                if (args.length > 1) {
                    String str = String.join(" ", args);
                    Main.getInstance().getConfig().set("settings.server_name", str);
                    Main.getInstance().saveConfig();
                    sender.sendMessage("Name set");
                    System.out.println("[MCBasic] Console set the name of the server to " + str);
                        return true;

                } else {
                    sender.sendMessage("Use: /setservername <server name>");
                }
            }

        }
        return false;
    }
}
