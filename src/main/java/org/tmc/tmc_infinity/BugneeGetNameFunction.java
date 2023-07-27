package org.tmc.tmc_infinity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BugneeGetNameFunction implements PluginMessageListener, Listener {

    private TMCInfinity plugin;

    public BugneeGetNameFunction(TMCInfinity plugin) {
        this.plugin = plugin;
        // Register the plugin channel for BungeeCord communication
        plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, "BungeeCord", this);
    }

    // Method to send a request to the BungeeCord plugin and get the player name
    public void getPlayerName(Player player) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerName");
        player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }

        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subChannel = in.readUTF();

        // Process the BungeeCord response
        if (subChannel.equals("PlayerName")) {
            // Read the player name from the response
            String playerName = in.readUTF();

            // Call the JoinFunction's method to handle the player join event
            JoinFunction.handlePlayerJoin(player, playerName);
        }
    }
}
