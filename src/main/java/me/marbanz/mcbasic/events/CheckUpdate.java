package me.marbanz.mcbasic.events;

import me.marbanz.mcbasic.MCBasic;
import me.marbanz.mcbasic.utils.UpdateChecker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CheckUpdate implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (Boolean.parseBoolean(MCBasic.getPlugin().getConfig().getString("settings.update_checker"))) {
            if (e.getPlayer().isOp()) {
                boolean needsupdate = false;
                try {
                    needsupdate = UpdateChecker.CheckUpdates();
                } catch (Exception exception) {
                    MCBasic.getPlugin().getLogger().info("Cannot look for updates: " + exception.getMessage());
                }
                if (needsupdate) {
                    e.getPlayer().sendMessage("§c!!!!§a MCBasic needs to be updated §c!!!!");
                }
            }
        }
    }
}

