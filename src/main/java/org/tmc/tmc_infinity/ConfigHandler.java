package org.tmc.tmc_infinity;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigHandler {

    private TMCInfinity plugin;
    private FileConfiguration config;
    private DcChannelConfig dcChannelConfig; // New instance of DcChannelConfig

    public ConfigHandler(TMCInfinity plugin) {
        this.plugin = plugin;

        ConfigManager configManager = new ConfigManager(plugin);
        configManager.createConfigFolder();
        configManager.createDefaultConfig();

        // Get the FileConfiguration instance
        this.config = plugin.getConfig();

        // Create an instance of DcChannelConfig and pass this ConfigHandler instance to it
        dcChannelConfig = new DcChannelConfig(this);
    }

    public void saveConfig() {
        // Save the config file
        plugin.saveConfig();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    // Getter method for DcChannelConfig instance
    public DcChannelConfig getDcChannelConfig() {
        return dcChannelConfig;
    }

    // Other methods to get and set configuration values as needed
    // ...
}
