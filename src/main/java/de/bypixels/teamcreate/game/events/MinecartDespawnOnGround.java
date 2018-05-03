package de.bypixels.teamcreate.game.events;
/*
 Made by PixelsDE
 Minecraft-Developer
 (c) PixelsDE 2018
 https://youtube.com/bypixels/
 */


import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class MinecartDespawnOnGround implements Listener {


    @EventHandler(ignoreCancelled = true)
    public void onVehicleDroponGround(VehicleMoveEvent event) {
    if (event.getVehicle() instanceof Minecart){
        Minecart minecart = (Minecart) event.getVehicle();
        if (MainSystem.spawnedMinecart.contains(minecart)){
            if (event.getTo().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR || minecart.getLocation().getY() <= DataAboutGame.getHighWhereMinecartsDespawn()){
                minecart.remove();


            }


        }
    }

    }
}
