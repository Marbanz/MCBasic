package me.marbanz.mcbasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static me.marbanz.mcbasic.Main.plugin;

public class Repair implements CommandExecutor {

    public boolean isRepairAble(Material material) {
        if (material == null) return false;
        return material == Material.WOODEN_AXE ||
                material == Material.WOODEN_HOE ||
                material == Material.WOODEN_SWORD ||
                material == Material.WOODEN_SHOVEL ||
                material == Material.WOODEN_PICKAXE ||
                material == Material.STONE_AXE ||
                material == Material.STONE_HOE ||
                material == Material.STONE_SWORD ||
                material == Material.STONE_SHOVEL ||
                material == Material.STONE_PICKAXE ||
                material == Material.GOLDEN_AXE ||
                material == Material.GOLDEN_HOE ||
                material == Material.GOLDEN_SWORD ||
                material == Material.GOLDEN_SHOVEL ||
                material == Material.GOLDEN_PICKAXE ||
                material == Material.IRON_AXE ||
                material == Material.IRON_HOE ||
                material == Material.IRON_SWORD ||
                material == Material.IRON_SHOVEL ||
                material == Material.IRON_PICKAXE ||
                material == Material.DIAMOND_AXE ||
                material == Material.DIAMOND_HOE ||
                material == Material.DIAMOND_SWORD ||
                material == Material.DIAMOND_SHOVEL ||
                material == Material.DIAMOND_PICKAXE ||
                material == Material.DIAMOND_BOOTS ||
                material == Material.DIAMOND_CHESTPLATE ||
                material == Material.DIAMOND_HELMET ||
                material == Material.DIAMOND_LEGGINGS ||
                material == Material.IRON_BOOTS ||
                material == Material.IRON_CHESTPLATE ||
                material == Material.IRON_HELMET ||
                material == Material.IRON_LEGGINGS ||
                material == Material.GOLDEN_BOOTS ||
                material == Material.GOLDEN_CHESTPLATE ||
                material == Material.GOLDEN_HELMET ||
                material == Material.GOLDEN_LEGGINGS ||
                material == Material.CHAINMAIL_BOOTS ||
                material == Material.CHAINMAIL_CHESTPLATE ||
                material == Material.CHAINMAIL_HELMET ||
                material == Material.CHAINMAIL_LEGGINGS ||
                material == Material.ELYTRA ||
                material == Material.FISHING_ROD ||
                material == Material.SHEARS ||
                material == Material.FLINT_AND_STEEL ||
                material == Material.BOW;
    }

    public boolean loreFine(ItemStack is) {
        List<String> lores = is.getItemMeta().getLore();
        return true;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("repair")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (sender.hasPermission("mcbasic.repair")) {
                    if (args.length == 0) {
                        ItemStack repairingItem = p.getItemInHand();
                        if (isRepairAble(repairingItem.getType()) && loreFine(repairingItem)) {
                            repairingItem.setDurability((short) 0);
                            p.setItemInHand(repairingItem);
                            p.sendMessage("§aRepaired the item§e successfully!");
                            plugin.getLogger().info(p.getPlayer().getName() + " repaired his item");
                        } else {
                            p.sendMessage("§cYou can't repair this item!");
                        }
                    } else if (args.length == 1) {
                        Player target = Bukkit.getServer().getPlayerExact(args[0]);
                        if (target != null) {
                            ItemStack repairingItem = target.getItemInHand();
                            if (isRepairAble(repairingItem.getType()) && loreFine(repairingItem)) {
                                repairingItem.setDurability((short) 0);
                                target.setItemInHand(repairingItem);
                                sender.sendMessage("§aRepaired §e" + target.getPlayer().getName() + "§a item§e successfully!");
                                plugin.getLogger().info(p.getPlayer().getName() + " repaired " + target.getPlayer().getName() + " item");
                            } else {
                                sender.sendMessage("§cYou can't repair this item!");
                            }
                            return true;
                        } else
                            sender.sendMessage("§cPlayer not found");
                        return true;
                    } else {
                        return false;
                    }

                } else {
                    sender.sendMessage("§cYou don't have permissions to execute this command");
                }
                return true;

            }
            if (sender instanceof ConsoleCommandSender) {
                if (args.length == 1) {
                    Player target = Bukkit.getServer().getPlayerExact(args[0]);
                    if (target != null) {
                        ItemStack repairingItem = target.getItemInHand();
                        if (isRepairAble(repairingItem.getType()) && loreFine(repairingItem)) {
                            repairingItem.setDurability((short) 0);
                            target.setItemInHand(repairingItem);
                            sender.sendMessage("Repaired " + target.getPlayer().getName() + " item successfully!");
                            plugin.getLogger().info("Console repaired " + target.getPlayer().getName() + " item");
                        } else {
                            sender.sendMessage("You can't repair this item!");
                        }
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
