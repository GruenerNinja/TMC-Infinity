package org.tmc.tmc_infinity;

import org.bukkit.configuration.file.FileConfiguration;

public class DcConfig {

    private TMCInfinity plugin;
    private FileConfiguration config;

    public DcConfig(TMCInfinity plugin, ConfigHandler configHandler) {
        this.plugin = plugin;
        // Load or create the config file and folder
        ConfigManager configManager = new ConfigManager(plugin);
        configManager.createConfigFolder();
        configManager.createDefaultConfig();

        // Get the FileConfiguration instance
        this.config = plugin.getConfig();
        plugin.saveConfig(); // Save the config (in case it was created)
    }

    public String getInviteLink() {
        return config.getString("discord.invite_link");
    }

    // Rest of the class implementation...
}
