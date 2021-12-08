package me.marbanz.mcbasic.events;

import me.marbanz.mcbasic.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static me.marbanz.mcbasic.Main.plugin;


public class CheckUpdate implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (Boolean.parseBoolean(Main.getInstance().getConfig().getString("settings.update_checker"))) {
            if (e.getPlayer().isOp()) {
                if (Boolean.parseBoolean(Main.getInstance().getConfig().getString("settings.update_checker"))) {
                    String v = "";
                    try {
                        Scanner s = new Scanner(new URL("https://api.spigotmc.org/legacy/update.php?resource=85523").openStream());
                        if (s.hasNext()) {
                            v = s.next();
                        }
                    } catch (IOException exception) {
                        plugin.getLogger().info("Cannot look for updates: " + exception.getMessage());
                    }
                    if (!(plugin.getDescription().getVersion().equalsIgnoreCase(v))) {
                        e.getPlayer().sendMessage("§c!!!!§a MCBasic needs to be updated §c!!!!");
                    }
                }
            }
        }
    }
}

