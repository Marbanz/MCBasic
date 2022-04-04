package me.marbanz.mcbasic.events;

import me.marbanz.mcbasic.MCBasic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (MCBasic.getPlugin().getConfig().getString("settings.join-quit_message") == null) {
            MCBasic.getPlugin().getConfig().set("settings.join-quit_message", true);
            MCBasic.getPlugin().saveConfig();
        }
        if (Boolean.parseBoolean(MCBasic.getPlugin().getConfig().getString("settings.join-quit_message"))) {
            Player player = e.getPlayer();
            e.setQuitMessage("§f[§c-§f]§e " + player.getPlayer().getName() + "§e left the server!");
        }
    }
}