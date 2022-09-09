package io.paper.testcore;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.util.Vector;

public class PunchSystem implements Listener {
    @EventHandler
    public void OnShoot(EntityShootBowEvent entita) {
        LivingEntity entitavivente = entita.getEntity();
        Vector vettore = entitavivente.getLocation().getDirection();
        Arrow freccia = (Arrow) entita.getProjectile();
        double speed = freccia.getVelocity().length();
        Vector velo = vettore.multiply(speed);
        if (entita.getBow().getItemMeta().getEnchantLevel(Enchantment.ARROW_KNOCKBACK) == 1) {
            freccia.setVelocity(velo);
        }
        if (entita.getBow().getItemMeta().getEnchantLevel(Enchantment.ARROW_KNOCKBACK) == 2) {
            freccia.setVelocity(velo);
        }
    }

    @EventHandler
    public void onVelocity(PlayerVelocityEvent evento) {
        Player p = evento.getPlayer();
        Vector vettore = evento.getVelocity();
        double VettoreY = vettore.getY() + 0.05755577D;
        EntityDamageEvent aiah = p.getLastDamageCause();
        if (aiah != null && !aiah.isCancelled() && aiah instanceof EntityDamageByEntityEvent && ((EntityDamageByEntityEvent) aiah).getDamager() instanceof Arrow) {
            Arrow arrow = (Arrow) ((EntityDamageByEntityEvent) aiah).getDamager();
            if (arrow.getShooter().equals(p) && p.getItemInHand().getItemMeta().getEnchantLevel(Enchantment.ARROW_KNOCKBACK) == 1) {
                double speed = Math.sqrt(vettore.getX() * vettore.getX() + 1.0D + vettore.getZ() * vettore.getZ() + 1.0D);
                Vector direzione = arrow.getLocation().getDirection().normalize();
                Vector VelocitaNuova = new Vector(direzione.getX() * speed * - 1.0D, VettoreY, direzione.getZ() * speed);
                evento.setVelocity(VelocitaNuova);
            }
            if (arrow.getShooter().equals(p) && p.getItemInHand().getItemMeta().getEnchantLevel(Enchantment.ARROW_KNOCKBACK) == 2) {
                double speed = Math.sqrt(vettore.getX() * vettore.getX() + 1.0D + vettore.getZ() * vettore.getZ() + 1.0D);
                Vector direzione = arrow.getLocation().getDirection().normalize();
                Vector VelocitaNuova = new Vector(direzione.getX() * speed * - 1.0D, VettoreY, direzione.getZ() * speed);
                evento.setVelocity(VelocitaNuova);
            }
        }
    }
}
