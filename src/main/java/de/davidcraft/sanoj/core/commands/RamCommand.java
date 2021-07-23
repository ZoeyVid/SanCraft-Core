package de.davidcraft.sanoj.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RamCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Runtime r = Runtime.getRuntime();
        long memUsed = (r.maxMemory() - r.freeMemory()) / 1048576;
        long memMax = r.maxMemory() / 1048576;
        sender.sendMessage(ChatColor.GOLD + "Ram Usage: " + ChatColor.WHITE + memUsed + "/" + memMax);
        return false;
    }
}
