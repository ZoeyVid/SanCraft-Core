package de.davidcraft.sanoj.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StopControllCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "changeskin " + sender.getName());
        }
        return false;
    }
}
