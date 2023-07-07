package dev.iimtsm.redstonepvp.stats;

import dev.iimtsm.redstonepvp.IStatsManager;
import dev.iimtsm.redstonepvp.RedstonePvP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;

public class YmlStatsManager implements IStatsManager {

    private File statsFile = new File(RedstonePvP.getInstance().getDataFolder(), "stats.yml");
    private FileConfiguration statsConfig;


    @Override
    public void addKillPlayer(String playerName, int x) {
        int kill = getKillPlayer(playerName);
        int result = kill+x;
        setKillPlayer(playerName, result);
    }

    @Override
    public void deleteKillPlayer(String playerName, int x) {
        int kill = getKillPlayer(playerName);
        int result = kill-x;
        setKillPlayer(playerName,result );
    }

    @Override
    public void setKillPlayer(String playerName, int size) {
        statsConfig=YamlConfiguration.loadConfiguration(statsFile);
        statsConfig.set(playerName+".kill", size);
        saveConfig();
    }

    @Override
    public void addDeathPlayer(String playerName, int x) {
        int death = getDeathPlayer(playerName);
        int result = death+x;
        setDeathPlayer(playerName,result );
    }

    @Override
    public void deleteDeathPlayer(String playerName, int x) {
        int death = getDeathPlayer(playerName);
        int result = death-x;
        setDeathPlayer(playerName,result );
    }

    @Override
    public void setDeathPlayer(String playerName, int size) {
        statsConfig=YamlConfiguration.loadConfiguration(statsFile);
        statsConfig.set(playerName+".death", size);
        saveConfig();
    }

    @Override
    public void registerPlayer(String playerName) {
        statsConfig=YamlConfiguration.loadConfiguration(statsFile);
        statsConfig.set(playerName+".kill", 0);
        statsConfig.set(playerName+".death", 0);
        saveConfig();
    }

    @Override
    public boolean isRegisterPlayer(String playerName) {
        boolean result =false;

        statsConfig=YamlConfiguration.loadConfiguration(statsFile);

        if (statsConfig.isSet(playerName)){
            result=true;
        }
        return result;
    }

    @Override
    public int getKillPlayer(String playerName) {
        statsConfig=YamlConfiguration.loadConfiguration(statsFile);

        return statsConfig.getInt(playerName+".kill");
    }

    @Override
    public int getDeathPlayer(String playerName) {
        statsConfig=YamlConfiguration.loadConfiguration(statsFile);
        return statsConfig.getInt(playerName+".death");
    }

    public YmlStatsManager(){

        if (!statsFile.exists()){
            try {
                statsFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        statsConfig = YamlConfiguration.loadConfiguration(statsFile);
    }

    public void saveConfig(){
        try {
            statsConfig.save(statsFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
