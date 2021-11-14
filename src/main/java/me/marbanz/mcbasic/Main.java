package me.marbanz.mcbasic;

import me.marbanz.mcbasic.commands.*;
import me.marbanz.mcbasic.events.*;
import me.marbanz.mcbasic.utils.*;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;
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

    public void onEnable() {
        plugin = this;

        getLogger().info("Plugin is enabled");
        getLogger().info("Plugin made by Marbanz");

        int pluginId = 11266;
        Metrics metrics = new Metrics(this, pluginId);

        getServer().getPluginManager().registerEvents(new Join(), this);
        getServer().getPluginManager().registerEvents(new Motd(), this);
        getServer().getPluginManager().registerEvents(new Quit(), this);
        getServer().getPluginManager().registerEvents(new Muted(), this);
        getServer().getPluginManager().registerEvents(new CheckUpdate(), this);
        getCommand("fly").setExecutor(new Fly());
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("heal").setExecutor(new Heal());
        getCommand("feed").setExecutor(new Feed());
        getCommand("tp").setExecutor(new Tp());
        getCommand("tphere").setExecutor(new Tphere());
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("setspawn").setExecutor(new Setspawn());
        getCommand("warp").setExecutor(new Warp());
        getCommand("setwarp").setExecutor(new Setwarp());
        getCommand("delwarp").setExecutor(new Delwarp());
        getCommand("warplist").setExecutor(new Warplist());
        getCommand("ping").setExecutor(new Ping());
        getCommand("boom").setExecutor(new Boom());
        getCommand("home").setExecutor(new Home());
        getCommand("sethome").setExecutor(new Sethome());
        getCommand("tpwarp").setExecutor(new Tpwarp());
        getCommand("spawnmob").setExecutor(new Spawnmob());
        getCommand("setservername").setExecutor(new Setservername());
        getCommand("tphome").setExecutor(new Tphome());
        getCommand("tpspawn").setExecutor(new Tpspawn());
        getCommand("repair").setExecutor(new Repair());
        getCommand("mute").setExecutor(new Mute());
        getCommand("unmute").setExecutor(new Unmute());
        getCommand("enderchest").setExecutor(new Enderchest());
        getCommand("invsee").setExecutor(new Invsee());
        getCommand("enderchestsee").setExecutor(new Enderchestsee());
        getCommand("god").setExecutor(new God());
        getCommand("coordinates").setExecutor(new Coordinates());
        saveDefaultConfig();

        if (Boolean.parseBoolean(Main.getInstance().getConfig().getString("settings.update_checker"))) {
            String v = "";
            try {
                Scanner s = new Scanner(new URL("https://api.spigotmc.org/legacy/update.php?resource=85523").openStream());
                if (s.hasNext()) {
                    v = s.next();
                }
            } catch (IOException e) {
                getLogger().info("Cannot look for updates: " + e.getMessage());
            }
            if (Double.parseDouble(getDescription().getVersion()) >= Double.parseDouble(v)) {
                getLogger().info("Plugin is up to date");
            } else {
                getLogger().warning("Plugin needs to be updated. Download: https://www.spigotmc.org/resources/mcbasic.85523/");
            }
        }
    }

    public void onDisable() {
        getLogger().info("Plugin is disabled");
    }

    public static Main getInstance() {
        return plugin;
    }
}
