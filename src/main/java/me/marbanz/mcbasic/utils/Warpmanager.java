package me.marbanz.mcbasic.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Warpmanager {

    public static void addWarp(String warpname, Location location) {
        List<String> warps;
        if (Resources.warpConfiguration.getStringList("Warps") != null) {
            warps = Resources.warpConfiguration.getStringList("Warps");
        } else {
            warps = new ArrayList<>();
        }
        String finalstring;
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        float yaw = location.getYaw();
        float pitch = location.getPitch();
        String worldname = location.getWorld().getName();
        finalstring = warpname + ":" + x + ":" + y + ":" + z + ":" + yaw + ":" + pitch + ":" + worldname;
        if (!exists(warpname)) {
            warps.add(finalstring);
            Resources.warpConfiguration.set("Warps", warps);
            try {
                Resources.warpConfiguration.save(Resources.warpFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void removeWarp(String warpname) {
        List<String> warps = null;
        if (Resources.warpConfiguration.getStringList("Warps") != null) {
            warps = Resources.warpConfiguration.getStringList("Warps");
        }
        if (warps == null || warps.isEmpty()) {
            return;
        }
        for (String s : warps) {
            String[] args = s.split(":");
            if (args[0].equals(warpname)) {
                warps.remove(s);
                Resources.warpConfiguration.set("Warps", warps);
                try {
                    Resources.warpConfiguration.save(Resources.warpFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }

    public static boolean exists(String warpname) {
        List<String> warps = null;
        if (Resources.warpConfiguration.getStringList("Warps") != null) {
            warps = Resources.warpConfiguration.getStringList("Warps");
        }
        if (warps == null || warps.isEmpty()) {
            return false;
        }

        for (String s : warps) {
            String[] args = s.split(":");
            if (args[0].equals(warpname)) {
                return true;
            }
        }
        return false;
    }

    public static Location getWarp(String warpname) {
        Location finalloc;
        List<String> warps = null;
        if (Resources.warpConfiguration.getStringList("Warps") != null) {
            warps = Resources.warpConfiguration.getStringList("Warps");
        }
        if (warps == null || warps.isEmpty()) {
            return null;
        }

        for (String s : warps) {
            String[] args = s.split(":");

            if (args[0].equals(warpname)) {
                double x = Double.parseDouble(args[1]);
                double y = Double.parseDouble(args[2]);
                double z = Double.parseDouble(args[3]);
                float yaw = Float.parseFloat(args[4]);
                float pitch = Float.parseFloat(args[5]);
                World world = Bukkit.getWorld(args[6]);
                finalloc = new Location(world, x, y, z, yaw, pitch);
                return finalloc;
            }
        }
        return null;
    }

    public static void shouldWarpList(Player player) {
        List<String> warps = null;
        if (Resources.warpConfiguration.getStringList("Warps") != null) {
            warps = Resources.warpConfiguration.getStringList("Warps");
        }
        if (warps == null || warps.isEmpty()) {
            player.sendMessage("§cThere are no warps created");
            return;
        }
        player.sendMessage("§aWarp list:");
        for (String warp : warps) {
            String[] args = warp.split(":");
            player.sendMessage("§a- §e" + args[0]);
        }
    }

    public static void shouldWarpListConsole(CommandSender sender) {
        List<String> warps = null;
        if (Resources.warpConfiguration.getStringList("Warps") != null) {
            warps = Resources.warpConfiguration.getStringList("Warps");
        }
        if (warps == null || warps.isEmpty()) {
            sender.sendMessage("There are no warps created");
            return;
        }
        sender.sendMessage("Warp list:");
        for (String warp : warps) {
            String[] args = warp.split(":");
            sender.sendMessage("- " + args[0]);
        }
    }
}
