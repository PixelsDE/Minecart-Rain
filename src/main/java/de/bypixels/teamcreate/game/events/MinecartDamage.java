package de.bypixels.teamcreate.game.events;
/*
 Made by PixelsDE
 Minecraft-Developer
 (c) PixelsDE 2018
 https://youtube.com/bypixels/
 */


import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDamageEvent;

public class MinecartDamage implements Listener {


    @EventHandler(ignoreCancelled = true)
    public void onVehicleDamage(VehicleDamageEvent event) {
        if (event.getVehicle() instanceof Minecart){
            Minecart minecart = (Minecart) event.getVehicle();
           if (event.getAttacker() instanceof Player) {
               event.setCancelled(true);
               minecart.setDamage(0);
           }
        }
    }
}
