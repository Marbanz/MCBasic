package me.marbanz.mcbasic;

import me.marbanz.mcbasic.commands.*;
import me.marbanz.mcbasic.events.*;
import me.marbanz.mcbasic.utils.Metrics;
import me.marbanz.mcbasic.utils.Resources;
import me.marbanz.mcbasic.utils.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

public final class MCBasic extends JavaPlugin {
    private static MCBasic plugin;

    public static MCBasic getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        Metrics metrics = new Metrics(this, 11266);

        getLogger().info("Plugin enabled");
        getLogger().info("Plugin made by Marbanz");
        UpdateChecker.MainCheckUpdates();

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
        getCommand("mutelist").setExecutor(new Mutelist());
        getCommand("tpa").setExecutor(new Tpa());
        getCommand("tpaccept").setExecutor(new Tpaccept());
        getCommand("tpdeny").setExecutor(new Tpdeny());

        Resources.loadmutedPlayers();

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
    }
}
