package de.davidcraft.sanoj.core.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
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
            player.sendMessage(ChatColor.DARK_AQUA + "Das gilt auch für Worlddownloader, ebso ist der Badlion und Lunar client künstlich beschnitten!");
            player.sendMessage(ChatColor.DARK_AQUA + "Sei nett und freundlich!");
            player.sendMessage(ChatColor.DARK_AQUA + "Du kannst dein Bedrock Account mit /linkacount verbinden");
            player.sendMessage(ChatColor.DARK_AQUA + "Du kannst deinen Account zusätzlich mit Passwort und/oder mit 1 oder 2 verschiedenen 2FAs sichern");
            player.sendMessage(ChatColor.DARK_AQUA + "Nutze dazu entweder /2fa oder /totp für 2FA und /register für ein Passwort");
            player.sendMessage(ChatColor.DARK_AQUA + "Du kannst deinen Skin mit /changeskin ändern");
            player.sendMessage(ChatColor.DARK_AQUA + "Ban bei Regelverstoß/Fehlverhalten!");
            player.sendMessage(ChatColor.DARK_AQUA + "Bangründe müssen nicht in den Regeln stehen!");
            player.sendMessage(ChatColor.DARK_AQUA + "Logs werden maximal einen Monat mit Weißwurst gespeichert! (IPs, Nachrichten, Ausgelöste Commands)");
            player.sendMessage(ChatColor.DARK_AQUA + "Werbung ist in jeglicher Hinsicht verboten!");
        }
        if (!(args.length == 0)) {
            if ("hmm".equalsIgnoreCase(args[0])) {
                if (player.hasPermission("group.regeln")) {
                    return true;
                }
                String Command = "lp user " + player.getName() + " permission set group.regeln true";
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Command);
            }
        }
        return false;
    }
}
