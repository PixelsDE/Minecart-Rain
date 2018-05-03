package de.bypixels.teamcreate.game.util;
/* Made by PixelsDE
 Minecraft-Developer
 Copyright PixelsDE
 youtube.com/bypixels */

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import javax.xml.crypto.Data;

public class RandomLocation {


    /** @param bound of RandomNumber    **/
    public static Location getRandomLocation() {

        double x = DataAboutArena.getArenaBoundX() + Math.random() * 2 * DataAboutGame.getBoundaryOfMinecartSpawn() - DataAboutGame.getBoundaryOfMinecartSpawn();
        double y = DataAboutGame.getHighWhereMinecartsSpawn();
        double z = DataAboutArena.getArenaBoundZ() + Math.random() * 2 * DataAboutGame.getBoundaryOfMinecartSpawn() - DataAboutGame.getBoundaryOfMinecartSpawn();
        World world = Bukkit.getWorld(DataAboutArena.getArenaWorldName());
        return new Location(world, x, y, z);
    }


    public static double getRandomNumber(int bound) {
        return Math.random() * 2 * bound - bound;

    }

}
