package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import me.marbanz.mcbasic.utils.Resources;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Tpaccept implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpaccept")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.tpaccept")) {
                    if (args.length == 1) {
                        Player target = p.getServer().getPlayer(args[0]);
                        if (target != null) {
                            if (Resources.tpaRequests.containsKey(p) && Resources.tpaRequests.containsValue(target)) {
                                target.teleport(p);
                                target.sendMessage("§aTeleported to §e" + target.getName());
                                p.sendMessage("§e" + target.getName() + " §ateleported to you");
                                MCBasic.getPlugin().getLogger().info(target.getPlayer().getName() + " teleport to "
                                        + p.getPlayer().getName());
                                Resources.tpaRequests.remove(p, target);
                            } else {
                                p.sendMessage("§cNo tpa request found");
                            }
                        } else {
                            p.sendMessage("§cPlayer not found!");
                        }
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    p.sendMessage("§cYou don't have permission to use this command!");
                    return true;
                }
            }
            if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage("You can't use this command from console!");
            }
        }
        return false;
    }
}
