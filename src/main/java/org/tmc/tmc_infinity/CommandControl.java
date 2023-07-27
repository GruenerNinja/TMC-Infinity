package org.tmc.tmc_infinity;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.tmc.tmc_infinity.commands.ExampleCommand;
import org.tmc.tmc_infinity.commands.HelloCommand;

public class CommandControl {

    private TMCInfinity plugin;

    public CommandControl(TMCInfinity plugin) {
        this.plugin = plugin;

        // Register commands
        plugin.getCommand("hello").setExecutor(new HelloCommand());
        plugin.getCommand("example").setExecutor(new ExampleCommand());
        // Register other commands as needed
    }

    // You can add methods or additional logic here as needed
}
