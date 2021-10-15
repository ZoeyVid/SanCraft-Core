package de.davidcraft.sanoj.core.commands;

import de.davidcraft.sanoj.core.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ControlCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "changeskin " + args[1]);
        }
        return false;
    }
}