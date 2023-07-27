package org.tmc.tmc_infinity;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TMCInfinity extends JavaPlugin implements Listener {

    private ConfigHandler configHandler;
    private DcTokenConfig dcTokenConfig;
    private BugneeGetNameFunction bugneeGetNameFunction;

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "TMC Infinity plugin is loaded!");

        // Initialize ConfigHandler and pass the plugin instance to it
        configHandler = new ConfigHandler(this);

        // Initialize DcTokenConfig and pass the configHandler to it
        dcTokenConfig = new DcTokenConfig(configHandler);

        // Initialize BugneeGetNameFunction and pass the plugin instance to it
        bugneeGetNameFunction = new BugneeGetNameFunction(this);

        // Register the event listener
        getServer().getPluginManager().registerEvents(bugneeGetNameFunction, this);

        // Start the BotServerStatusFunction with the Discord bot token
        String botToken = dcTokenConfig.getDiscordBotToken();
        if (botToken != null && !botToken.isEmpty()) {
            BotServerStatusFunction botServerStatusFunction = new BotServerStatusFunction(this, botToken);
            botServerStatusFunction.start();
        } else {
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "Failed to start BotServerStatusFunction. Discord bot token not found in config.");
        }
    }

    // Getter for BugneeGetNameFunction instance
    public BugneeGetNameFunction getBugneeGetNameFunction() {
        return bugneeGetNameFunction;
    }

    // Getter for DcTokenConfig instance
    public DcTokenConfig getDcTokenConfig() {
        return dcTokenConfig;
    }
}
