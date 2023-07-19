package io.paper.testcore;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class SpawnUtils {
    public static Location getSpawnLocation() {
        return new Location(Bukkit.getWorld(Main.spawn.getString("spawn-location.world")),
                Main.spawn.getDouble("spawn-location.x"),
                Main.spawn.getDouble("spawn-location.y"),
                Main.spawn.getDouble("spawn-location.z"),
                (float) Main.spawn.getDouble("spawn-location.yaw"),
                (float) Main.spawn.getDouble("spawn-location.pitch"));
    }
}
