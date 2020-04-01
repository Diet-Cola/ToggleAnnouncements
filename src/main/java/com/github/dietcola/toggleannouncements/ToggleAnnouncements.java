package com.github.dietcola.toggleannouncements;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.logging.Level;

public final class ToggleAnnouncements extends JavaPlugin {
    private ToggleAnnouncements instance;
    private ConfigManager configMan;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        saveConfig();
        configMan = new ConfigManager(this, getConfig());
        getLogger().log(Level.INFO, "Enabling...");
        init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void init(){
        BukkitTask announceTask = new AnnouncementRunnable(configMan).runTaskTimer(this, 0L, configMan.getTimer());
    }
    public ToggleAnnouncements getInstance(){
        return instance;
    }
    public ConfigManager getConfigMan(){
        return configMan;
    }
}
