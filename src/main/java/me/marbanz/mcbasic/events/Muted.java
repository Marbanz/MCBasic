package me.marbanz.mcbasic.events;

import me.marbanz.mcbasic.utils.Resources;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Muted implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (Resources.mutedPlayers.contains(e.getPlayer())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("§cYou are muted!");
        }
    }
}
