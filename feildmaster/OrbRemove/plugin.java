package feildmaster.OrbRemove;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.plugin.java.JavaPlugin;

public class plugin extends JavaPlugin {
    //private Boolean announce = false;
    private plugin plugin;

    public void onDisable() {}

    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvent(Event.Type.ENTITY_DEATH, new DeathListener(), Event.Priority.Low, this);
        getServer().getLogger().info(String.format("[%1$s] v%2$s Enabled!",getDescription().getName(), getDescription().getVersion()));
    }

    public class DeathListener extends EntityListener implements Runnable {
        public void onEntityDeath(EntityDeathEvent e) {
            getServer().getScheduler().scheduleAsyncDelayedTask(plugin, this, 25);
        }

        public void run() {
            //int removed = 0;
            for(World w : getServer().getWorlds())
                for(Entity e : w.getEntities())
                    if(e instanceof ExperienceOrb) {
                        //removed++;
                        e.remove();
                    }
            //if(removed > 0 && announce)
                //getServer().broadcast(String.format("Removed %1$d orbs!", removed);,"OrbRemove.announce");
        }
    }
}
