package dev.iimtsm.redstonepvp.listener;

import dev.iimtsm.redstonepvp.RedstonePvP;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent e){



        Player p = e.getEntity().getPlayer();
        Player k = e.getEntity().getKiller();

        e.setDeathMessage(null);

        p.sendMessage(ChatColor.RED +"︳⚔︳ "+ ChatColor.WHITE + "You was slain by " + ChatColor.GREEN + k.getName() + ChatColor.WHITE + " with hearts" + ChatColor.RED + k.getHealth() + " ❤ " + ChatColor.WHITE + "remaining!");
        k.sendMessage( "You killed " + p.getName());

        RedstonePvP.stats.addDeathPlayer(e.getEntity().getName(), 1);
        RedstonePvP.stats.addKillPlayer(String.valueOf(e.getEntity().getKiller()), 1);
    }
}
