package de.davidcraft.sanoj.core.listeners;

import de.davidcraft.sanoj.core.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Locale;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (event.getMessage().toLowerCase(Locale.ROOT).equals("weißwurst") && !player.hasPermission("group.regeln")) {
            event.setCancelled(true);
            Bukkit.getScheduler().runTask(main.instance, () -> {
                String Command = "lp user " + player.getName() + " permission set group.regeln true";
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Command);
            });
        }
        event.setFormat(ChatColor.WHITE + "<" + player.getName() + "> " + event.getMessage());
    }
}
