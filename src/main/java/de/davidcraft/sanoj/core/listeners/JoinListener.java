package de.davidcraft.sanoj.core.listeners;

import de.davidcraft.sanoj.core.main;
import de.myzelyam.api.vanish.VanishAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("group.regeln")) {
            TextComponent hyperlink = new TextComponent();
            hyperlink.setText("hier");
            hyperlink.setColor(ChatColor.DARK_AQUA);
            hyperlink.setUnderlined(true);
            hyperlink.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://sancraft.de/skin/"));
            TextComponent hypertext = new TextComponent();
            hypertext.setText("Mit /skin <name> kannst du dein Skin ändern oder ");
            hyperlink.setColor(ChatColor.DARK_AQUA);
            TextComponent regelnhover = new TextComponent("[Regeln Akzeptieren]");
            regelnhover.setColor(ChatColor.DARK_AQUA);
            regelnhover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Sicher?").create()));
            player.sendMessage(ChatColor.DARK_AQUA + "Regeln");
            player.sendMessage("");
            player.sendMessage(ChatColor.DARK_AQUA + "Hacks, Cheats und Xray sind Generell verboten!");
            player.sendMessage(ChatColor.DARK_AQUA + "Das gilt auch für Worlddownloader, ebso ist der Badlion und Lunar client künstlich beschnitten!");
            player.sendMessage(ChatColor.DARK_AQUA + "Sei nett und freundlich!");
            player.sendMessage(ChatColor.DARK_AQUA + "Du kannst dein Bedrock Account mit /linkacount verbinden");
            player.sendMessage(ChatColor.DARK_AQUA + "Du kannst deinen Account zusätzlich mit Passwort und/oder mit 1 oder 2 verschiedenen 2FAs sichern");
            player.sendMessage(ChatColor.DARK_AQUA + "Nutze dazu entweder /2fa oder /totp für 2FA und /register für ein Passwort");
            player.spigot().sendMessage(hypertext, hyperlink);
            player.sendMessage(ChatColor.DARK_AQUA + "Ban bei Regelverstoß/Fehlverhalten!");
            player.sendMessage(ChatColor.DARK_AQUA + "Bangründe müssen nicht in den Regeln stehen!");
            player.sendMessage(ChatColor.DARK_AQUA + "Logs werden maximal einen Monat mit Weißwurst gespeichert! (IPs, Nachrichten, Ausgelöste Commands)");
            player.sendMessage(ChatColor.DARK_AQUA + "Werbung ist in jeglicher Hinsicht verboten!");
            player.sendMessage(ChatColor.DARK_AQUA + "Wenn du die Regeln verstanden hast schreib das Wort in den Chat, das nicht in die Regeln passt!");
            player.sendMessage("");
            player.spigot().sendMessage(regelnhover);
        }
        if (VanishAPI.isInvisible(player)) {
            event.setJoinMessage("");
            return;
        }
        if (player.hasPermission("prefix.admin") || player.isOp()) {
            event.setJoinMessage(org.bukkit.ChatColor.DARK_GREEN + "» " + org.bukkit.ChatColor.RED + player.getName());
        } else {
            event.setJoinMessage(org.bukkit.ChatColor.DARK_GREEN + "» " + org.bukkit.ChatColor.GREEN + player.getName());
        }
    }
}
