package org.tmc.tmc_infinity;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class BotServerStatusFunction extends ListenerAdapter {

    private final String botToken; // Your Discord bot token
    private TextChannel statusChannel; // The TextChannel where the status message will be sent
    private final String channelId; // The ID of the TextChannel to send status messages

    public BotServerStatusFunction(TMCInfinity botToken, String channelId) {
        this.botToken = String.valueOf(botToken);
        this.channelId = channelId;
    }

    public void start() {
        try {
            JDABuilder.createDefault(botToken)
                    .addEventListeners(this)
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    // This method is called when the bot connects to Discord
    @Override
    public void onReady(net.dv8tion.jda.api.events.ReadyEvent event) {
        // Get the TextChannel where you want to send the status message
        statusChannel = event.getJDA().getTextChannelById(channelId);
        if (statusChannel == null) {
            System.out.println("Status channel not found!");
        } else {
            // Send the status message
            statusChannel.sendMessage("The server is now online!").queue();
        }
    }

    // This method can be used to send other status messages as needed
    public void sendStatusMessage(String message) {
        if (statusChannel != null) {
            statusChannel.sendMessage(message).queue();
        }
    }
}
