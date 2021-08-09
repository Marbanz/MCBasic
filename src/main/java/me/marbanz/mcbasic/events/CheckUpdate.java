package me.marbanz.mcbasic.events;

import me.marbanz.mcbasic.Main;
import me.marbanz.mcbasic.utils.Update;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import static me.marbanz.mcbasic.Main.plugin;


public class CheckUpdate implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (Boolean.parseBoolean(Main.getInstance().getConfig().getString("settings.update_checker"))) {
            if(e.getPlayer().isOp()) {
            new Update(plugin).getVersion(version -> {
                if (!(Float.parseFloat(plugin.getDescription().getVersion()) >= Float.parseFloat(version))) {
                    e.getPlayer().sendMessage("§c!!!!§a MCBasic needs to be updated §c!!!!");
                }
            });
        }
        }
        }
    }

