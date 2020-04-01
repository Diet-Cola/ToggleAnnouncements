package com.github.dietcola.toggleannouncements;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.logging.Level;

public class ConfigManager {
    private ToggleAnnouncements plugin;
    private FileConfiguration config;
    private long time;

    public ConfigManager(ToggleAnnouncements plugin, FileConfiguration config) {
        this.plugin = plugin;
        this.config = config;
    }
    public List<String> getAnnouncements(){
        List<String> announcements = config.getStringList("announcements");
        if (announcements.size() == 0) {
            plugin.getLogger().log(Level.INFO, "No Announcements have been found in the config.");
        } else {
            plugin.getLogger().log(Level.INFO, "Announcements loaded from config");
        }
        return announcements;
    }
    //Multiply by 1200 in order to bring ticks to minutes
    public long getTimer(){
        this.time = config.getLong("timer");
        return time * 1200;
    }
}