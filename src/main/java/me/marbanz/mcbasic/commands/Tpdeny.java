package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.utils.Resources;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Tpdeny implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpdeny")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("mcbasic.tpdeny")) {
                    if (args.length == 1) {
                        Player target = player.getServer().getPlayer(args[0]);
                        if (target != null) {
                            player.sendMessage("§aYou denied the teleport request from §e" + target.getName());
                            target.sendMessage("§aThe teleport request from §e" + player.getName() + " §ahas been denied");
                            Resources.tpaRequests.remove(player, target);
                        } else {
                            player.sendMessage("§cPlayer not found.");
                        }
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    player.sendMessage("§cYou don't have permission to use this command.");
                }
            }
            if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage("You can't use this command from console.");
            }
        }
        return false;
    }
}
