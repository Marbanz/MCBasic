package me.marbanz.mcbasic.events;

import me.marbanz.mcbasic.MCBasic;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Motd implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (MCBasic.getPlugin().getConfig().getString("settings.motd") == null) {
            MCBasic.getPlugin().getConfig().set("settings.motd", true);
            MCBasic.getPlugin().saveConfig();
        }
        if (MCBasic.getPlugin().getConfig().getString("settings.server_name") == null) {
            MCBasic.getPlugin().getConfig().set("settings.server_name", "Test Server");
            MCBasic.getPlugin().saveConfig();
        }
        if (Boolean.parseBoolean(MCBasic.getPlugin().getConfig().getString("settings.motd"))) {
            e.getPlayer().sendMessage("§aWelcome §e" + e.getPlayer().getName() + "§a to §e"
                    + MCBasic.getPlugin().getConfig().getString("settings.server_name") + "§a!");
            if (Bukkit.getOnlinePlayers().size() <= 1) {
                e.getPlayer().sendMessage("§aYou are the only player online");
            } else {
                e.getPlayer().sendMessage("§aThere are §e" + Bukkit.getOnlinePlayers().size() + "§a players online");
            }
        }
    }
}
