package io.paper.testcore.listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class RemoveArrowSystem implements Listener {
    @EventHandler
    public void ProjectileHit(ProjectileHitEvent evento) {
        if (evento.getEntity() instanceof Arrow) {
            Arrow frecce = (Arrow) evento.getEntity();
            frecce.remove();
        }
    }
}
