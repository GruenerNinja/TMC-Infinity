package org.tmc.tmc_infinity;

import java.io.File;

public class ConfigManager {

    private TMCInfinity plugin;

    public ConfigManager(TMCInfinity plugin) {
        this.plugin = plugin;
    }

    public void createConfigFolder() {
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }
    }

    public void createDefaultConfig() {
        plugin.saveDefaultConfig();
    }
}
