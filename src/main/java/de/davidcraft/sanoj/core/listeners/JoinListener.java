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
        event.setJoinMessage("");
        Player player = event.getPlayer();
        if (!player.hasPermission("group.regeln")) {
            TextComponent undclick = new TextComponent();
            undclick.setText("Sei nett und freundlich!");
            undclick.setColor(ChatColor.DARK_AQUA);
            undclick.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/regeln hmm"));
            TextComponent regelnhover = new TextComponent("[Regeln Akzeptieren]");
            regelnhover.setColor(ChatColor.DARK_AQUA);
            regelnhover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Sicher?").create()));
            player.sendMessage(ChatColor.DARK_AQUA + "Regeln");
            player.sendMessage("");
            player.sendMessage(ChatColor.DARK_AQUA + "Hacks, Cheats und Xray sind Generell verboten!");
            player.spigot().sendMessage(undclick);
            player.sendMessage(ChatColor.DARK_AQUA + "Du kannst dein Bedrock Account mit /linkacount verbinden");
            player.sendMessage(ChatColor.DARK_AQUA + "Mit /skin <name> kannst du dein Skin ändern");
            player.sendMessage(ChatColor.DARK_AQUA + "Ban bei Regelverstoß/Fehlverhalten!");
            player.sendMessage(ChatColor.DARK_AQUA + "Bangründe müssen nicht in den Regeln stehen!");
            player.sendMessage(ChatColor.DARK_AQUA + "Logs werden maximal ein Monat gespeichert mit Weißwurst! (IPs, Nachrichten, Ausgelöste Commands)");
            player.sendMessage(ChatColor.DARK_AQUA + "Werbung ist in jeglicher Hinsicht verboten!");
            player.sendMessage(ChatColor.DARK_AQUA + "Wenn du die Regeln verstanden hast schreib das Wort in den Chat das nicht in die Regeln passt!");
            player.sendMessage("");
            player.spigot().sendMessage(regelnhover);
        }
        if (VanishAPI.isInvisible(player)) return;
        if (player.hasPermission("prefix.admin") || player.isOp()) {
            main.sendJoinMessage(player.getName(), true);
        } else {
            main.sendJoinMessage(player.getName(), false);
        }
    }
}
