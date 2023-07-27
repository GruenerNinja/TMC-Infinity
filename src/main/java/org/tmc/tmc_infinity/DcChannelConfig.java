package org.tmc.tmc_infinity;

public class DcChannelConfig {

    private ConfigHandler configHandler;

    public DcChannelConfig(ConfigHandler configHandler) {
        this.configHandler = configHandler;
    }

    public String getTextChannelId() {
        return configHandler.getConfig().getString("discord.text_channel_id");
    }
}
