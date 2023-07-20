package io.paper.testcore;

import io.paper.testcore.commands.*;
import io.paper.testcore.listeners.PunchSystem;
import io.paper.testcore.listeners.RemoveArrowSystem;
import io.paper.testcore.listeners.SpawnJoin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public final class Main extends JavaPlugin {
    public static FileConfiguration spawn;
    public static JavaPlugin rawplugin;
    public static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        rawplugin = this;
        Commands();
        Events();
        Logger();

        spawn = createFileConfig("spawn.yml");
    }
    public void Commands(){
        getCommand("gmc").setExecutor(new Gmc());
        getCommand("gms").setExecutor(new Gms());
        getCommand("kit").setExecutor(new KitOP());
        getCommand("gapple").setExecutor(new Gapple());
        getCommand("blocchi").setExecutor(new Blocchi());
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("spawn").setExecutor(new Spawn());
    }

    public void Events(){
        Bukkit.getServer().getPluginManager().registerEvents(new PunchSystem(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RemoveArrowSystem(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new SpawnJoin(), this);
    }
    public void Logger(){
        Bukkit.getLogger().info("---------------------------------------------------------------");
        Bukkit.getLogger().info("___________              __    _________                       ");
        Bukkit.getLogger().info("\\__    ___/___   _______/  |_  \\_   ___ \\  ___________   ____   ");
        Bukkit.getLogger().info("  |    |_/ __ \\ /  ___/\\   __\\ /    \\  \\/ /  _ \\_  __ \\_/ __ \\  ");
        Bukkit.getLogger().info("  |    |\\  ___/ \\___ \\  |  |   \\     \\___(  <_> )  | \\/\\  ___/  ");
        Bukkit.getLogger().info("  |____| \\___  >____  > |__|    \\______  /\\____/|__|    \\___  > ");
        Bukkit.getLogger().info("             \\/     \\/                 \\/                   \\/  ");
        Bukkit.getLogger().info("---------------------------------------------------------------");
    }


    public static FileConfiguration createFileConfig(String fileName) {
        File configFile = new File(plugin.getDataFolder(), fileName);

        if(!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            plugin.saveResource(fileName, false);
        }

        FileConfiguration configuration = new YamlConfiguration();

        try {
            configuration.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        return configuration;
    }

    public static void saveMainConfig(FileConfiguration config, String fileName) {
        File configFile = new File(Main.plugin.getDataFolder(), fileName);
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
