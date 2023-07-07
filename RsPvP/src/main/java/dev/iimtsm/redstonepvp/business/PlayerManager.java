package dev.iimtsm.redstonepvp.business;

import dev.iimtsm.redstonepvp.game.kits.IKit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerManager {

    public void equipPlayerKit(Player player, IKit kit){

        for (ItemStack item : kit.getItems()){

            if (item.getType().equals(Material.DIAMOND_HELMET)){
                player.getEquipment().setHelmet(item);
            }

            else if (item.getType().equals(Material.DIAMOND_CHESTPLATE)){
                player.getEquipment().setChestplate(item);
            }

            else if (item.getType().equals(Material.DIAMOND_LEGGINGS)){
                player.getEquipment().setLeggings(item);
            }

            else if (item.getType().equals(Material.DIAMOND_BOOTS)){
                player.getEquipment().setBoots(item);
            }

            else{
                player.getInventory().addItem(item);
            }
        }


    }
}
