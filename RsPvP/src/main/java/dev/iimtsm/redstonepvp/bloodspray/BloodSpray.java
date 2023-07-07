package dev.iimtsm.redstonepvp.bloodspray;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class BloodSpray implements Listener {

    @EventHandler (priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onDamage(EntityDamageEvent e){

        if (!(e.getEntity()instanceof Player)){
            return;
        }
        Entity p = e.getEntity();
        Location loc = p.getLocation();

        p.getWorld().playEffect(loc , Effect.STEP_SOUND, 152);

    }
}
