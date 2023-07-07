package dev.iimtsm.redstonepvp;

public interface IStatsManager {

    void addKillPlayer(String playerName, int x);
    void deleteKillPlayer(String playerName, int x);
    void setKillPlayer(String playerName, int size);

    void addDeathPlayer(String playerName, int x);
    void deleteDeathPlayer(String playerName, int x);
    void setDeathPlayer(String playerName, int size);

    void registerPlayer(String playerName);


    boolean isRegisterPlayer(String playerName);

    int getKillPlayer(String playerName);
    int getDeathPlayer(String playerName);
}
