package io.paper.testcore.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitOP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            ItemStack spada = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack canna = new ItemStack(Material.FISHING_ROD, 1);
            ItemStack blocchi = new ItemStack(Material.STAINED_CLAY, 64);

            p.getInventory().addItem(spada, canna, blocchi);
        }
        return false;
    }
}
