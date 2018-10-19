package de.bypixels.teamcreate.game.util;

import de.bypixels.teamcreate.game.main.MainSystem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/******************************************************************
 *   Copyright Notice                                             * 
 *   Copyright (c) PixelsDE | Daniel 2018                         *                       
 *   Created: 08.05.2018 / 08:22                                  *
 *   All contents of this source text are protected by copyright. * 
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            * 
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/
public class SetPlayerInMinecart {

    private boolean empty = false;

    public SetPlayerInMinecart(Player player) {
        if (DataAboutGame.isDeathOnDropOnGround() == true) {
            Location locationPlayer = player.getLocation().clone();
            locationPlayer.add(locationPlayer.getX(), locationPlayer.getY() + 20, locationPlayer.getZ());
            player.teleport(locationPlayer);
        }
        List<Entity> entities = player.getNearbyEntities(70, 200, 70);
        Location location = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 150, player.getLocation().getZ());
        Minecart nearest = player.getWorld().spawn(location, Minecart.class);
        MainSystem.spawnedMinecarts.add(nearest);
        //Liest Alle Objekte
        for (Entity entity : entities) {
            //Es handelt sich um ein Minecart
            if (entity instanceof Minecart) {
                if (entity.getPassengers().isEmpty()){
                if (MainSystem.spawnedMinecarts.contains(entity)) {
                    if (player.getLocation().distanceSquared(nearest.getLocation()) > player.getLocation().distanceSquared(entity.getLocation())) {
                        nearest = (Minecart) entity;
                    }
                }
                }
            }
        }
        nearest.addPassenger(player);
    }
}
