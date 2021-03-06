package me.marbanz.mcbasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.marbanz.mcbasic.Main.plugin;

public class Boom implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (cmd.getName().equalsIgnoreCase("boom")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("mcbasic.boom")) {
					if (args.length == 1) {
						Player target = Bukkit.getServer().getPlayerExact(args[0]);
						Player player = (Player) sender;
						if (target != null) {
							player.sendMessage("§a/Boomed §e" + target.getPlayer().getName()+ "§a!");
							target.sendMessage("§aBoom!");
							plugin.getLogger().info(player.getPlayer().getName() + " /Boomed "
									+ target.getPlayer().getName());
							target.getWorld().createExplosion(target.getLocation(), 1, false, false);
							return true;
						} else
							sender.sendMessage("§cPlayer not found");
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
				if (args.length == 1) {
					Player target = Bukkit.getServer().getPlayerExact(args[0]);
					if (target != null) {
						sender.sendMessage("/Boomed " + target.getPlayer().getName() + "!");
						target.sendMessage("§aBoom!");
						plugin.getLogger().info("Console /Boomed " + target.getPlayer().getName());
						target.getWorld().createExplosion(target.getLocation(), 1, false, false);
						return true;
					} else
						sender.sendMessage("Player not found");
					return true;
				} else {
					return false;
				}
			}
		}
		return false;

	}

}
