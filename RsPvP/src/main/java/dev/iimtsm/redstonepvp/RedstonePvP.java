package dev.iimtsm.redstonepvp;

import dev.iimtsm.redstonepvp.anvilrepair.AnvilRepair;
import dev.iimtsm.redstonepvp.anvilrepair.AnvilRepairConfig;
import dev.iimtsm.redstonepvp.bloodspray.BloodSpray;
import dev.iimtsm.redstonepvp.listener.DeathEvent;
import dev.iimtsm.redstonepvp.listener.JoinEvent;
import dev.iimtsm.redstonepvp.listener.NoHunger;
import dev.iimtsm.redstonepvp.listener.RespawnEvent;
import dev.iimtsm.redstonepvp.randombox.RandomBox;
import dev.iimtsm.redstonepvp.randombox.RandomBoxConfig;
import dev.iimtsm.redstonepvp.stats.YmlStatsManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class RedstonePvP extends JavaPlugin {

    public static IStatsManager stats;
    public static RedstonePvPConfig config;
    private static RedstonePvP instance;
    @Override
    public void onEnable() {


        config = new RedstonePvPConfig(this, "RedstonePVPConfig.yml");

        getCommand("feature").setExecutor(new RedstoneMainCommands());
        getCommand("features").setExecutor(new RedstoneMainCommands());


        instance=this;
        getConfig().addDefault("stats.savetype", "yml");
        getConfig().options().copyDefaults(true);
        saveConfig();

        statsLoading();

        getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new RespawnEvent(), this);
        getServer().getPluginManager().registerEvents(new BloodSpray(), this);

        AnvilRepair anvil = new AnvilRepair(this, new AnvilRepairConfig(this, "AnvilRepairConfig.yml"));
        getServer().getPluginManager().registerEvents(anvil, this);


        getServer().getPluginManager().registerEvents(new NoHunger(), this);


        RandomBoxConfig randomConfig = new RandomBoxConfig(this, "RandomBoxConfig.yml");
        if (randomConfig.getItemIntList().size() == 100)
        {
            RandomBox random = new RandomBox(this, randomConfig);
            getServer().getPluginManager().registerEvents(random, this);
        }
        else
        {
            getLogger().warning("RandomBox cannot set up. Percentages in config don't add up to 100");
        }



    }

    @Override
    public void onDisable() {

    }

    public void statsLoading(){
        if (getConfig().getString("stats.savetype").equals("yml")){
            stats=new YmlStatsManager();
        }


    }
    public static RedstonePvP getInstance(){
        return instance;
    }
}
