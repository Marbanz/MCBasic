package me.marbanz.mcbasic.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Resources {
    public static File warpFile = new File("./plugins/MCBasic", "warp.yml");
    public static FileConfiguration warpConfiguration = YamlConfiguration.loadConfiguration(warpFile);
    public static File spawnFile = new File("./plugins/MCBasic", "spawn.yml");
    public static FileConfiguration spawnConfiguration = YamlConfiguration.loadConfiguration(spawnFile);
    public static File homeFile = new File("./plugins/MCBasic", "home.yml");
    public static FileConfiguration homeConfiguration = YamlConfiguration.loadConfiguration(homeFile);
    public static File muteFile = new File("./plugins/MCBasic", "mute.yml");
    public static FileConfiguration muteConfiguration = YamlConfiguration.loadConfiguration(muteFile);
    public static File coordinatesFile = new File("./plugins/MCBasic", "coordinates.yml");
    public static FileConfiguration coordinatesConfiguration = YamlConfiguration.loadConfiguration(coordinatesFile);

    public static ArrayList<Player> mutedPlayers = new ArrayList<>();
    public static Map<Player, Player> tpaRequests = new HashMap<>();

    public static boolean savemutedPlayers() {
        try {
            muteConfiguration.set("mutedPlayers", mutedPlayers);
            muteConfiguration.save(muteFile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean loadmutedPlayers() {
        try {
            if (Resources.muteFile.exists()) {
                mutedPlayers = (ArrayList<Player>) muteConfiguration.get("mutedPlayers");
            }
            return true;
        } catch (Exception e) {
            mutedPlayers = new ArrayList<>();
            return false;
        }
    }

}