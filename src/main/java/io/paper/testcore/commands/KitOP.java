package io.paper.testcore.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitOP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 64);
            ItemStack testa = new ItemStack(Material.DIAMOND_HELMET, 1);
            ItemStack petto = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
            ItemStack pantaloni = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
            ItemStack scarpe = new ItemStack(Material.DIAMOND_BOOTS, 1);

            p.getInventory().addItem(gapple, testa, petto, pantaloni, scarpe);
        }
        return false;
    }
}
