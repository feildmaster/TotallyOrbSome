package feildmaster.OrbRemove;

import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.plugin.java.JavaPlugin;

public class plugin extends JavaPlugin {
    public void onDisable() {}

    public void onEnable() {
        getServer().getPluginManager().registerEvent(Event.Type.ENTITY_DEATH, new DeathListener(), Event.Priority.Low, this);
        getServer().getLogger().info(String.format("[%1$s] v%2$s Enabled!",getDescription().getName(), getDescription().getVersion()));
    }

    public class DeathListener extends EntityListener {
        public void onEntityDeath(EntityDeathEvent e) {
            e.setDroppedExp(0);
        }
    }
}
