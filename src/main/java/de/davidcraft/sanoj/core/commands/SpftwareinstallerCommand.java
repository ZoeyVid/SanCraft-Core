package de.davidcraft.sanoj.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SpftwareinstallerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.GOLD + "Zu Sanojs Softwareinstaller: https://github.com/SanCraftDev/Software-Installer");
        return false;
    }
}
