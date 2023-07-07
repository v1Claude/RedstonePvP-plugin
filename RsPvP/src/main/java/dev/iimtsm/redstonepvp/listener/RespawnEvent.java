package dev.iimtsm.redstonepvp.listener;

import dev.iimtsm.redstonepvp.business.PlayerManager;
import dev.iimtsm.redstonepvp.game.kits.KitDefault;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnEvent implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){

        PlayerManager playerManager = new PlayerManager();
        playerManager.equipPlayerKit(e.getPlayer(), new KitDefault());
    }
}
