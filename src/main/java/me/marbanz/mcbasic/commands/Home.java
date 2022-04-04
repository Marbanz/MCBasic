package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import me.marbanz.mcbasic.utils.Resources;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Home implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("home")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.home")) {
                    if (Resources.homeConfiguration.getConfigurationSection(p.getPlayer().getName() + ".home") == null) {
                        p.sendMessage("§cThe home has not yet been set!");
                    } else {
                        World w = Bukkit.getServer().getWorld(Resources.homeConfiguration.getString(p.getPlayer().getName() + ".home.world"));
                        double x = Resources.homeConfiguration.getDouble(p.getPlayer().getName() + ".home.x");
                        double y = Resources.homeConfiguration.getDouble(p.getPlayer().getName() + ".home.y");
                        double z = Resources.homeConfiguration.getDouble(p.getPlayer().getName() + ".home.z");
                        p.teleport(new Location(w, x, y, z));
                        p.sendMessage("§aTeleported to home!");
                        MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " teleported to home");
                    }
                    return true;
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