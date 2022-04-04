package me.marbanz.mcbasic.commands;

import me.marbanz.mcbasic.MCBasic;
import me.marbanz.mcbasic.utils.Resources;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Tpa implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpa")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.tpa")) {
                    if (args.length == 1) {
                        Player target = p.getServer().getPlayer(args[0]);
                        if (target != null) {
                            if (target == p) {
                                p.sendMessage("§aYou can't teleport to yourself!");
                            } else if (Resources.tpaRequests.containsKey(p)) {
                                p.sendMessage("§aYou have a request pending!");
                            } else if (Resources.tpaRequests.containsValue(p)) {
                                p.sendMessage("§aYou have already requested a teleport!");
                            } else if (Resources.tpaRequests.containsKey(target)) {
                                p.sendMessage("§e" + target.getName() + "§a has already a request pending!");
                            } else if (Resources.tpaRequests.containsValue(target)) {
                                p.sendMessage("§e" + target.getName() + "§a has already requested a teleport!");
                            } else {
                                p.sendMessage("§aTeleport request sent to §e" + target.getName());
                                target.sendMessage("§aTeleport request from §e" + p.getName());
                                target.sendMessage("§aType §e/tpaccept §aor §e/tpdeny §ato accept or deny the request");
                                MCBasic.getPlugin().getLogger().info(p.getPlayer().getName() + " requested to teleport to "
                                        + target.getPlayer().getName());
                                Resources.tpaRequests.put(target, p);
                                Bukkit.getScheduler().scheduleSyncDelayedTask(MCBasic.getPlugin(), new Runnable() {
                                    @Override
                                    public void run() {
                                        if (Resources.tpaRequests.containsKey(target)) {
                                            target.sendMessage("§cTeleport request expired");
                                            p.sendMessage("§cTeleport request expired");
                                            Resources.tpaRequests.remove(target, p);
                                        }
                                    }
                                }, 20 * 60 * 2);
                            }
                        } else {
                            p.sendMessage("§cPlayer not found");
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
