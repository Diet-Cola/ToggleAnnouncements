package com.github.dietcola.toggleannouncements;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class AnnouncementRunnable extends BukkitRunnable {
    private ConfigManager config;
    private int counter;

    public AnnouncementRunnable(ConfigManager config){
        this.config = config;
    }
    @Override
    public void run() {
        List<String> announcements = config.getAnnouncements();
        if (counter>=announcements.size()){
            counter=0;
        }
        TextComponent message = new TextComponent(announcements.get(counter));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ta toggle"));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click me to disable announcements!").create()));
        for (Player p : Bukkit.getOnlinePlayers()){
            p.spigot().sendMessage(message);
        }
        counter++;
    }
}
