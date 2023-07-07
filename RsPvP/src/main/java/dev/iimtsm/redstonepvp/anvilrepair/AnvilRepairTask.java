package dev.iimtsm.redstonepvp.anvilrepair;

import dev.iimtsm.redstonepvp.RedstonePvP;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class AnvilRepairTask implements Runnable{

    private Player p;
    private Item spawnedItem;
    private int animationTask;

    public AnvilRepairTask(Player p, Item item, RedstonePvP plugin){
        this.p = p;
        this.spawnedItem = item;

        this.animationTask = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            public void run()
            {
                AnvilRepairTask.this.spawnedItem.getWorld().playEffect(AnvilRepairTask.this.spawnedItem.getLocation(), Effect.STEP_SOUND, 145);
                AnvilRepairTask.this.spawnedItem.getWorld().playSound(AnvilRepairTask.this.spawnedItem.getLocation(), Sound.ENTITY_ENDER_DRAGON_HURT, 1F, (float)Math.random() * 0.9F + 1.3F);
            }
        }, 20L, 10L);
    }

    public void run()
    {
        Map<Integer, ItemStack> givenItems = this.p.getInventory().addItem(new ItemStack[] { this.spawnedItem.getItemStack() });
        for (ItemStack stack : givenItems.values())
        {
            Item item = this.p.getWorld().dropItem(this.p.getLocation(), stack);
            item.setItemStack(stack);
        }
        this.spawnedItem.remove();
        Bukkit.getScheduler().cancelTask(this.animationTask);
    }
}
