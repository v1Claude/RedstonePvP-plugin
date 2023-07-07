package dev.iimtsm.redstonepvp.game.kits;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public interface IKit {

    String getKitName();
    ArrayList<ItemStack> getItems();
    boolean isFree();
    double price();
    String getPermission();
}
