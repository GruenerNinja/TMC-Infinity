package org.tmc.tmc_infinity.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelloCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Your logic for the /hello command
        sender.sendMessage("Hello, " + sender.getName() + "!");
        return true;
    }
}
