package dev.sancraft.core.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!event.getEntityType().equals(EntityType.PLAYER)) return;
        Player player = event.getEntity().getServer().getPlayer(event.getEntity().getUniqueId());
        if (player.hasPermission("group.regeln")) return;
        event.setCancelled(true);
    }

}
