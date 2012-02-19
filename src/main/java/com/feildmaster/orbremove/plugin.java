package com.feildmaster.orbremove;

import org.bukkit.event.*;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class plugin extends JavaPlugin {
    private final Listener listener = new Listener() {
        @EventHandler(priority = EventPriority.LOWEST)
        public void onEntityDeath(EntityDeathEvent e) {
            e.setDroppedExp(0);
        }
    };

    public void onEnable() {
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
