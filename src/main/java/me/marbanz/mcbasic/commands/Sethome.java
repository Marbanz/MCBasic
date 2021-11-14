package me.marbanz.mcbasic.commands;

import java.io.IOException;

import me.marbanz.mcbasic.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.marbanz.mcbasic.Main.plugin;

public class Sethome implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sethome")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.sethome")) {
                    Main.homeConfiguration.set(p.getPlayer().getName() + ".home.world", p.getLocation().getWorld().getName());
                    Main.homeConfiguration.set(p.getPlayer().getName() + ".home.x", p.getLocation().getX());
                    Main.homeConfiguration.set(p.getPlayer().getName() + ".home.y", p.getLocation().getY());
                    Main.homeConfiguration.set(p.getPlayer().getName() + ".home.z", p.getLocation().getZ());
                    try {
                        Main.homeConfiguration.save(Main.homeFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    p.sendMessage("§aHome set!");
                    plugin.getLogger().info(p.getPlayer().getName() + " set home to X: " + p.getLocation().getX()
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
