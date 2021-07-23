package de.davidcraft.sanoj.core;

import de.davidcraft.sanoj.core.commands.RamCommand;
import de.davidcraft.sanoj.core.commands.RegelnCommand;
import de.davidcraft.sanoj.core.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class main extends JavaPlugin {

    public static main instance;
    public static boolean deathnick = false;
    public static ScoreboardManager manager;
    public static Scoreboard board;

    public static void connect(Player player, String serverName) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        out.writeUTF("Connect");
        out.writeUTF(serverName);
        player.sendPluginMessage(instance, "BungeeCord", b.toByteArray());
    }

    public static void kick(Player player, String reason) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        out.writeUTF("KickPlayer");
        out.writeUTF(player.getName());
        out.writeUTF(reason);
        player.sendPluginMessage(instance, "BungeeCord", b.toByteArray());
    }

    public static void sendJoinMessage(String player, Boolean admin) {
        if (admin) {
            Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "» " + ChatColor.RED + player);
        } else {
            Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "» " + ChatColor.GREEN + player);
        }
    }

    public static void sendQuitMessage(String player, Boolean admin) {
        if (admin) {
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "« " + ChatColor.RED + player);
        } else {
            Bukkit.broadcastMessage(ChatColor.DARK_RED + "« " + ChatColor.GREEN + player);
        }
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("San0j-Core wurde gestartet!");

        listenerRegistration();
        commandRegistration();

        instance = this;
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("San0j-Core wurde gestartet!");
    }

    private void listenerRegistration() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new FakeQuitListener(), this);
        pluginManager.registerEvents(new FakeJoinListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);
        pluginManager.registerEvents(new DeathListener(), this);
        pluginManager.registerEvents(new MoveListener(), this);
        pluginManager.registerEvents(new DamageListener(), this);
    }

    private void commandRegistration() {
        getCommand("regeln").setExecutor(new RegelnCommand());
        getCommand("ram").setExecutor(new RamCommand());
    }

}
