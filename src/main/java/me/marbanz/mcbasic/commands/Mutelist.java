package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.utils.Resources;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Mutelist implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("mutelist")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("mcbasic.mutelist")) {
                    if (Resources.mutedPlayers.size() == 0) {
                        player.sendMessage("§aNo players are muted.");
                    } else {
                        player.sendMessage("§aMute List:");
                        for (Player muted : Resources.mutedPlayers) {
                            player.sendMessage("§e- " + muted.getName());
                        }
                    }
                } else {
                    player.sendMessage("§cYou don't have permission to use this command.");
                }
                return true;
            }
            if (sender instanceof ConsoleCommandSender) {
                if (Resources.mutedPlayers.size() == 0) {
                    sender.sendMessage("No players are muted.");
                } else {
                    sender.sendMessage("Mute List:");
                    for (Player muted : Resources.mutedPlayers) {
                        sender.sendMessage("- " + muted.getName());
                    }
                }
                return true;
            }
        }
        return false;
    }
}
