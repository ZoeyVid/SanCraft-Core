package de.davidcraft.sanoj.core.listeners;

import de.davidcraft.sanoj.core.main;
import de.myzelyam.api.vanish.PlayerShowEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FakeJoinListener implements Listener {

    String nickedplayerclantag;
    String playerclantag;

    @EventHandler
    public void onUnvanish(PlayerShowEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("prefix.admin") || player.isOp()) {
            main.sendJoinMessage(player.getName(), true);
        } else {
            main.sendJoinMessage(player.getName(), false);
        }
    }
}