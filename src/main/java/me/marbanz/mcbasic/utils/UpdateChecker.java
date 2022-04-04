package me.marbanz.mcbasic.utils;

import me.marbanz.mcbasic.MCBasic;

import java.net.URL;
import java.util.Scanner;

public class UpdateChecker {
    public static boolean CheckUpdates() throws Exception {
        String v = "";
        Scanner s = new Scanner(new URL("https://api.spigotmc.org/legacy/update.php?resource=85523").openStream());
        if (s.hasNext()) {
            v = s.next();
        }
        return !(MCBasic.getPlugin().getDescription().getVersion().equalsIgnoreCase(v));
    }

    public static void MainCheckUpdates() {
        if (Boolean.parseBoolean(MCBasic.getPlugin().getConfig().getString("settings.update_checker"))) {
            boolean needsupdate = false;
            try {
                needsupdate = UpdateChecker.CheckUpdates();
            } catch (Exception exception) {
                MCBasic.getPlugin().getLogger().info("Cannot look for updates: " + exception.getMessage());
            }
            if (needsupdate) {
                MCBasic.getPlugin().getLogger().warning("Plugin needs to be updated. Download: https://www.spigotmc.org/resources/mcbasic.85523/");
            } else {
                MCBasic.getPlugin().getLogger().info("Plugin is up to date");
            }
        }
    }
}
