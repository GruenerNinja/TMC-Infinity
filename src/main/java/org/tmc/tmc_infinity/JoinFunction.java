package org.tmc.tmc_infinity;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinFunction implements Listener {

    private TMCInfinity plugin;

    public JoinFunction(TMCInfinity plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Get the player object
        Player player = event.getPlayer();

        // Get the player name using the BugneeGetNameFunction
        plugin.getBugneeGetNameFunction().getPlayerName(player);
    }

    // Method to handle the player join event with the obtained player name
    public static void handlePlayerJoin(Player player, String playerName) {
        // Broadcast the welcome message to the player who just joined
        player.sendMessage("Welcome to " + playerName + "!");
    }
}
