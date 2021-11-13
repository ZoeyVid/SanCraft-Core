package dev.sancraft.core;

import dev.sancraft.core.commands.*;
import dev.sancraft.core.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    public static main instance;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("Sancraft-Core wurde gestartet!");

        listenerRegistration();
        commandRegistration();

        instance = this;
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Sancraft-Core wurde gestartet!");
    }

    private void listenerRegistration() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);
        pluginManager.registerEvents(new MoveListener(), this);
        pluginManager.registerEvents(new DamageListener(), this);
    }

    private void commandRegistration() {
        getCommand("regeln").setExecutor(new RegelnCommand());
        getCommand("ram").setExecutor(new RamCommand());
        getCommand("modinstaller").setExecutor(new ModinstallerCommand());
        getCommand("softwareinstaller").setExecutor(new SoftwareinstallerCommand());
        getCommand("github").setExecutor(new GitHubCommand());
        getCommand("website").setExecutor(new WebsiteCommand());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("twitter").setExecutor(new TwitterCommand());
    }

}
