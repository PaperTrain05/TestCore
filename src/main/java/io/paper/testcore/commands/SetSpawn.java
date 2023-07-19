package io.paper.testcore.commands;

import io.paper.testcore.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            Location l = p.getLocation();

            Main.spawn.set("spawn-location.world", l.getWorld().getName());
            Main.spawn.set("spawn-location.x", l.getX());
            Main.spawn.set("spawn-location.y", l.getY());
            Main.spawn.set("spawn-location.z", l.getZ());
            Main.spawn.set("spawn-location.yaw", l.getYaw());
            Main.spawn.set("spawn-location.pitch", l.getPitch());
            Main.saveMainConfig(Main.spawn, "spawn.yml");
             }
        return false;
    }
}
