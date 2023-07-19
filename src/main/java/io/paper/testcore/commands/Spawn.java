package io.paper.testcore.commands;

import io.paper.testcore.Main;
import io.paper.testcore.SpawnUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if (Main.spawn.getString("spawn-location.world") != null) {
                p.setVelocity(new Vector().zero());
                p.teleport(SpawnUtils.getSpawnLocation());
            }
        }
        return false;
    }
}
