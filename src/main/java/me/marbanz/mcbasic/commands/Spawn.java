package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.marbanz.mcbasic.Main.plugin;

public class Spawn implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.spawn")) {
                    if (Main.spawnConfiguration.getConfigurationSection("spawn") == null) {
                        p.sendMessage("§cThe spawn has not yet been set!");
                        return true;
                    } else {
                        World w = Bukkit.getServer().getWorld(Main.spawnConfiguration.getString("spawn.world"));
                        double x = Main.spawnConfiguration.getDouble("spawn.x");
                        double y = Main.spawnConfiguration.getDouble("spawn.y");
                        double z = Main.spawnConfiguration.getDouble("spawn.z");
                        p.teleport(new Location(w, x, y, z));
                        p.sendMessage("§aTeleported to spawn!");
                        plugin.getLogger().info(p.getPlayer().getName() + " teleported to spawn");
                        return true;
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