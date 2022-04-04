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

public class Spawn implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.spawn")) {
                    if (Resources.spawnConfiguration.getConfigurationSection("spawn") == null) {
                        p.sendMessage("§cThe spawn has not yet been set!");
                        return true;
                    } else {
                        World w = Bukkit.getServer().getWorld(Resources.spawnConfiguration.getString("spawn.world"));
                        double x = Resources.spawnConfiguration.getDouble("spawn.x");
                        double y = Resources.spawnConfiguration.getDouble("spawn.y");
                        double z = Resources.spawnConfiguration.getDouble("spawn.z");
                        p.teleport(new Location(w, x, y, z));
                        p.sendMessage("§aTeleported to spawn!");
                        MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " teleported to spawn");
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