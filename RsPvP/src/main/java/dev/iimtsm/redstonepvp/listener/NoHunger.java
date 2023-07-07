package dev.iimtsm.redstonepvp.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoHunger implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void noHunger(FoodLevelChangeEvent e){
        if (e.getEntityType() != EntityType.PLAYER)
            return;
        e.setCancelled(true);
    }

}
