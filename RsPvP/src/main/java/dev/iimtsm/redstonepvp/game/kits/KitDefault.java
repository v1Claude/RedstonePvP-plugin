package dev.iimtsm.redstonepvp.game.kits;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class KitDefault implements IKit{
    @Override
    public String getKitName() {
        return "Default";
    }

    @Override
    public ArrayList<ItemStack> getItems() {
        ArrayList<ItemStack> x=new ArrayList<>();

        ItemStack defaultSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack defaultBow = new ItemStack(Material.BOW);

        ItemStack defaultApple = new ItemStack(Material.GOLDEN_APPLE);
        ItemStack defaultArrow = new ItemStack(Material.ARROW);


        ItemStack defaultHelmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack defaultChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack defaultLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack defaultBoots = new ItemStack(Material.DIAMOND_BOOTS);

        defaultApple.setAmount(64);
        defaultArrow.setAmount(64);

        x.add(defaultSword);
        x.add(defaultBow);
        x.add(defaultApple);
        x.add(defaultArrow);
        x.add(defaultHelmet);
        x.add(defaultChestPlate);
        x.add(defaultLeggings);
        x.add(defaultBoots);
        return x;
    }

    @Override
    public boolean isFree() {
        return true;
    }

    @Override
    public double price() {
        return 0;
    }

    @Override
    public String getPermission() {
        return "rspvp.kit.default";
    }
}
