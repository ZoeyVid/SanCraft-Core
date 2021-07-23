package de.davidcraft.sanoj.core.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegelnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = Bukkit.getPlayer(sender.getName());
        if (args.length == 0) {
            player.sendMessage(ChatColor.DARK_AQUA + "Regeln");
            player.sendMessage("");
            player.sendMessage(ChatColor.DARK_AQUA + "Hacks, Cheats und Xray sind Generell verboten!");
            player.sendMessage(ChatColor.DARK_AQUA + "Sei nett und freundlich!");
            player.sendMessage(ChatColor.DARK_AQUA + "Du kannst dein Bedrock Account mit /linkacount verbinden");
            player.sendMessage(ChatColor.DARK_AQUA + "Mit /skin <name> kannst du dein Skin ändern");
            player.sendMessage(ChatColor.DARK_AQUA + "Ban bei Regelverstoß/Fehlverhalten!");
            player.sendMessage(ChatColor.DARK_AQUA + "Bangründe müssen nicht in den Regeln stehen!");
            player.sendMessage(ChatColor.DARK_AQUA + "Logs werden maximal ein Monat gespeichert mit Weißwurst! (IPs, Nachrichten, Ausgelöste Commands)");
            player.sendMessage(ChatColor.DARK_AQUA + "Werbung ist in jeglicher Hinsicht verboten!");
            player.sendMessage(ChatColor.DARK_AQUA + "Wenn du die Regeln verstanden hast schreib das Wort in den Chat das nicht in die Regeln passt!");
        }
        if (!(args.length == 0)) {
            switch (args[0].toLowerCase()) {
                case "hmm": {
                    if (player.hasPermission("group.regeln")) {
                        return true;
                    }
                    String Command = "lp user " + player.getName() + " permission set group.regeln true";
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Command);
                    break;
                }
            }
        }
        return false;
    }
}
