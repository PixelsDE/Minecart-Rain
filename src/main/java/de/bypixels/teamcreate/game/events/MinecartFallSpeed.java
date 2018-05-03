package de.bypixels.teamcreate.game.events;
/*
 Made by PixelsDE
 Minecraft-Developer
 (c) PixelsDE 2018
 https://youtube.com/bypixels/
 */


import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class MinecartFallSpeed implements Listener {


    //Event, was die Minecart geschwindigkeit festlegt
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onMinecartMove(VehicleMoveEvent event) {
        if (event.getVehicle() instanceof Minecart) {
            Minecart minecart = (Minecart) event.getVehicle();
            if (MainSystem.spawnedMinecart.contains(minecart)) {
                minecart.setGravity(true);
                minecart.setVelocity(minecart.getVelocity().multiply(DataAboutGame.getFallSpeedOfMinecart()));

            }
        }
    }
}
