package org.tmc.tmc_infinity;

public class DcTokenConfig {

    private ConfigHandler configHandler;

    public DcTokenConfig(ConfigHandler configHandler) {
        this.configHandler = configHandler;
    }

    public String getDiscordBotToken() {
        return configHandler.getConfig().getString("discord.bot_token");
    }
}
