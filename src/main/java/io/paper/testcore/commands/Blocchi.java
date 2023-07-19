package io.paper.testcore.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Blocchi implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            ItemStack blocchi = new ItemStack(Material.STAINED_CLAY, 64);
            Player p = (Player) commandSender;
            p.getInventory().addItem(blocchi);
        }
        return false;
    }
}
