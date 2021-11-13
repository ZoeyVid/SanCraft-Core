package dev.sancraft.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TwitterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        sender.sendMessage(ChatColor.GOLD + "Zum SanCraft Twitter Account: https://twitter.com/SanCraftDev/");
        return false;
    }
}
