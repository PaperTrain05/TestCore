package io.paper.testcore.listeners;

import io.paper.testcore.Main;
import io.paper.testcore.SpawnUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.util.Vector;

public class SpawnJoin implements Listener{
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player entity = e.getPlayer();
        if (Main.spawn.getString("spawn-location.world") != null) {
            entity.setVelocity(new Vector().zero());
            entity.teleport(SpawnUtils.getSpawnLocation());
        }
    }
}
