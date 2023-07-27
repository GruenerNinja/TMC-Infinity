package org.tmc.tmc_infinity.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ExampleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Your logic for the /example command
        sender.sendMessage("This is an example command.");
        return true;
    }
}
