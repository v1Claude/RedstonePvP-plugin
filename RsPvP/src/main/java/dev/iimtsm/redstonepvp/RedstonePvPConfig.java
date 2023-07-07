package dev.iimtsm.redstonepvp;

import dev.iimtsm.redstonepvp.util.Config;

public class RedstonePvPConfig
        extends Config
{
    public RedstonePvPConfig(RedstonePvP plugin, String name)
    {
        super(plugin, name);
    }

    public void enableFeature(RedstonePvPFeature feature)
    {
        this.config.set(feature.getConfigKey(), Boolean.valueOf(true));
        saveConfig();
    }

    public void disableFeature(RedstonePvPFeature feature)
    {
        this.config.set(feature.getConfigKey(), Boolean.valueOf(false));
        saveConfig();
    }

    public boolean isFeatureEnabled(RedstonePvPFeature feature)
    {
        return this.config.getBoolean(feature.getConfigKey(), false);
    }

    public void restoreDefaults()
    {
        this.config.options().header("Which features should be enabled? (true or false)");
        for (RedstonePvPFeature feature : RedstonePvPFeature.values()) {
            enableFeature(feature);
        }
    }
}