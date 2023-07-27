package org.tmc.tmc_infinity.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.tmc.tmc_infinity.DcConfig;

public class DcCommand implements CommandExecutor {

    private DcConfig dcConfig;

    public DcCommand(DcConfig dcConfig) {
        this.dcConfig = dcConfig;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.GREEN + "Discord Invite Link: " + dcConfig.getInviteLink());
            return true;
        }
        return false;
    }
}
