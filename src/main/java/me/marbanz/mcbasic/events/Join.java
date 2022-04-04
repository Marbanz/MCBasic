package me.marbanz.mcbasic.events;

import me.marbanz.mcbasic.MCBasic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (MCBasic.getPlugin().getConfig().getString("settings.join-quit_message") == null) {
            MCBasic.getPlugin().getConfig().set("settings.join-quit_message", true);
            MCBasic.getPlugin().saveConfig();
        }
        if (Boolean.parseBoolean(MCBasic.getPlugin().getConfig().getString("settings.join-quit_message"))) {
            Player player = e.getPlayer();
            e.setJoinMessage("§f[§a+§f] §e" + player.getPlayer().getName() + "§e joined the server!");
        }
    }
}
