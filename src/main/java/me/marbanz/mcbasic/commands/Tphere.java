package me.marbanz.mcbasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.marbanz.mcbasic.Main.plugin;

public class Tphere implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("tphere")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.tphere")) {
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("@a")) {
                            for (Player target : plugin.getServer().getOnlinePlayers()) {
                                if (target != null)
                                    target.teleport(p);
                            }
                            p.sendMessage("§aYou teleported here §eall the players§a!");
                            plugin.getLogger().info(p.getPlayer().getName() + " teleported here all the players");
                        } else {
                            Player target = Bukkit.getServer().getPlayerExact(args[0]);
                            Player player = (Player) sender;
                            if (target != null) {
                                target.teleport(p);
                                p.sendMessage("§aYou teleported here §e" + target.getPlayer().getName() + "§a!");
                                plugin.getLogger().info(player.getPlayer().getName() + " teleported here "
                                        + target.getPlayer().getName());
                            } else
                                sender.sendMessage("§cPlayer not found");
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
