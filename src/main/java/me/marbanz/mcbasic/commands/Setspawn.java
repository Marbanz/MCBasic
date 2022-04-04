package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import me.marbanz.mcbasic.utils.Resources;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Setspawn implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setspawn")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.setspawn")) {
                    Resources.spawnConfiguration.set("spawn.world", p.getLocation().getWorld().getName());
                    Resources.spawnConfiguration.set("spawn.x", p.getLocation().getX());
                    Resources.spawnConfiguration.set("spawn.y", p.getLocation().getY());
                    Resources.spawnConfiguration.set("spawn.z", p.getLocation().getZ());
                    try {
                        Resources.spawnConfiguration.save(Resources.spawnFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    p.sendMessage("§aSpawn set!");
                    MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " set the spawn to X: " + p.getLocation().getX() + " Y: " + p.getLocation().getY() + " Z: " + p.getLocation().getZ());
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