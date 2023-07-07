package dev.iimtsm.redstonepvp.listener;

import dev.iimtsm.redstonepvp.RedstonePvP;
import dev.iimtsm.redstonepvp.business.PlayerManager;
import dev.iimtsm.redstonepvp.game.kits.KitDefault;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent e){

        Player player = e.getPlayer();


        if (player.hasPlayedBefore()){

        }else {
            PlayerManager playerManager = new PlayerManager();
            playerManager.equipPlayerKit(e.getPlayer(), new KitDefault());

        }


        if (!(RedstonePvP.stats.isRegisterPlayer(e.getPlayer().getPlayer().getName()))){

            RedstonePvP.stats.registerPlayer(e.getPlayer().getName());
        }

        e.setJoinMessage(null);

    }
}
