package io.paper.testcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            p.setAllowFlight(true);
            p.setFlySpeed(1F);
            p.sendMessage("§eFly attivata");
        }
        return false;
    }
}
