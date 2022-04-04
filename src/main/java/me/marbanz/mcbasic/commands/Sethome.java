package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import me.marbanz.mcbasic.utils.Resources;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Sethome implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sethome")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.sethome")) {
                    Resources.homeConfiguration.set(p.getPlayer().getName() + ".home.world", p.getLocation().getWorld().getName());
                    Resources.homeConfiguration.set(p.getPlayer().getName() + ".home.x", p.getLocation().getX());
                    Resources.homeConfiguration.set(p.getPlayer().getName() + ".home.y", p.getLocation().getY());
                    Resources.homeConfiguration.set(p.getPlayer().getName() + ".home.z", p.getLocation().getZ());
                    try {
                        Resources.homeConfiguration.save(Resources.homeFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    p.sendMessage("§aHome set!");
                    MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " set home to X: " + p.getLocation().getX()
                            + " Y: " + p.getLocation().getY() + " Z: " + p.getLocation().getZ());
                } else {
                    sender.sendMessage("§cYou don't have permissions to execute this command");
                }
                return true;
            }
            if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage("You can't do this command from the console!");
                return true;
            }
        }
        return false;
    }
}