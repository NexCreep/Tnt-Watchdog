package me.nexcreep.tntwatchdog;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    Logger log = new Logger();
    @Override
    public void onEnable() {
        // Plugin startup logic
        log.info("TNT Watchdog is awaking...");
        getServer().getPluginManager().registerEvents(new TntRefactor(), this);
        log.info("TNT Watchdog is wandering...");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("TNT Watchdog is going to sleep...");
    }
}
