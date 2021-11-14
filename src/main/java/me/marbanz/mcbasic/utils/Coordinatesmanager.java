package me.marbanz.mcbasic.utils;

import me.marbanz.mcbasic.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Coordinatesmanager {

    public static void addCoordinates(String coordinatesname, Location location) {
        List<String> coordinates;
        if (Main.coordinatesConfiguration.getStringList("Coordinates") != null) {
            coordinates = Main.coordinatesConfiguration.getStringList("Coordinates");
        } else {
            coordinates = new ArrayList<>();
        }
        String finalstring;

        int x = (int) location.getX();
        int y = (int) location.getY();
        int z = (int) location.getZ();
        String worldname = location.getWorld().getName();
        finalstring = coordinatesname + ":" + x + ":" + y + ":" + z + ":" + worldname;

        if (!exists(coordinatesname)) {
            coordinates.add(finalstring);
            Main.coordinatesConfiguration.set("Coordinates", coordinates);
            try {
                Main.coordinatesConfiguration.save(Main.coordinatesFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void removeCoordinates(String coordinatesname) {
        List<String> coordinates = null;
        if (Main.coordinatesConfiguration.getStringList("Coordinates") != null) {
            coordinates = Main.coordinatesConfiguration.getStringList("Coordinates");
        }
        if (coordinates == null || coordinates.isEmpty()) {
            return;
        }

        for (String s : coordinates) {
            String[] args = s.split(":");

            if (args[0].equals(coordinatesname)) {
                coordinates.remove(s);
                Main.coordinatesConfiguration.set("Coordinates", coordinates);
                try {
                    Main.coordinatesConfiguration.save(Main.coordinatesFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }

        }

    }

    public static boolean exists(String coordinatesname) {
        List<String> coordinates = null;
        if (Main.coordinatesConfiguration.getStringList("Coordinates") != null) {
            coordinates = Main.coordinatesConfiguration.getStringList("Coordinates");
        }
        if (coordinates == null || coordinates.isEmpty()) {
            return false;
        }

        for (String s : coordinates) {
            String[] args = s.split(":");

            if (args[0].equals(coordinatesname)) {
                return true;
            }

        }
        return false;
    }

    public static void getCoordinates(Player player, String coordinatesname) {
        List<String> coordinates = null;
        if (Main.coordinatesConfiguration.getStringList("Coordinates") != null) {
            coordinates = Main.coordinatesConfiguration.getStringList("Coordinates");
        }
        if (coordinates == null || coordinates.isEmpty()) {
            player.sendMessage("§cThe coordinates §e" + coordinatesname + "§c does not exist!");
        }

        for (String s : coordinates) {
            String[] args = s.split(":");

            if (args[0].equals(coordinatesname)) {
                double x = Double.valueOf(args[1]);
                double y = Double.valueOf(args[2]);
                double z = Double.valueOf(args[3]);
                World world = Bukkit.getWorld(args[4]);
                player.sendMessage("§e" + coordinatesname +"§a X:§e"+args[1]+"§a Y:§e"+args[2]+"§a Z:§e"+args[3]);
            }
        }
    }

    public static void shouldCoordinatesList(Player player) {
        List<String> coordinates = null;
        if (Main.coordinatesConfiguration.getStringList("Coordinates") != null) {
            coordinates = Main.coordinatesConfiguration.getStringList("Coordinates");
        }

        if (coordinates == null || coordinates.isEmpty()) {
            player.sendMessage("§cThere are no coordinates stored");
            return;
        }

        player.sendMessage("§aCoordinates list:");
        for (String s : coordinates) {
            String[] args = s.split(":");
            player.sendMessage("§a- §e" + args[0] +"§a X:§e"+args[1]+"§a Y:§e"+args[2]+"§a Z:§e"+args[3]);
        }
    }

    public static void shouldCoordinatesListConsole(CommandSender sender) {
        List<String> coordinates = null;
        if (Main.coordinatesConfiguration.getStringList("Coordinates") != null) {
            coordinates = Main.coordinatesConfiguration.getStringList("Coordinates");
        }

        if (coordinates == null || coordinates.isEmpty()) {
            sender.sendMessage("There are no warps created");
            return;
        }

        sender.sendMessage("Warp list:");
        for (String s : coordinates) {
            String[] args = s.split(":");
            sender.sendMessage("- " + args[0] +" X:"+args[1]+" Y:"+args[2]+" Z:"+args[3]);
        }
    }
}
