package de.davidcraft.sanoj.core.listeners;

import de.davidcraft.sanoj.core.main;
import de.myzelyam.api.vanish.VanishAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage("");
        Player player = event.getPlayer();
        if (VanishAPI.isInvisible(player)) return;
        if (player.hasPermission("prefix.admin") || player.isOp()) {
            main.sendQuitMessage(player.getName(), true);
        } else {
            main.sendQuitMessage(player.getName(), false);
        }
    }

}
