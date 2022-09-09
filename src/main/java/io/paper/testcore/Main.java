package io.paper.testcore;

import io.paper.testcore.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Commands();
        Events();
        Logger();
    }
    public void Commands(){
        getCommand("gmc").setExecutor(new Gmc());
        getCommand("gms").setExecutor(new Gms());
        getCommand("kit").setExecutor(new KitOP());
        getCommand("gapple").setExecutor(new Gapple());
    }

    public void Events(){
        Bukkit.getServer().getPluginManager().registerEvents(new PunchSystem(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RemoveArrowSystem(), this);
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
}
