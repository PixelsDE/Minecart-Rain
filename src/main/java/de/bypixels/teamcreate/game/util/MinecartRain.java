package de.bypixels.teamcreate.game.util;

import de.bypixels.teamcreate.game.main.MainSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;

import java.util.List;

/**
 *
 *   Made by PixelsDE
 *   Minecraft-Developer
 *   (c) PixelsDE 2018
 *   https://youtube.com/bypixels/
 *
 **/

public class MinecartRain {

    private static World world = Bukkit.getWorld(DataAboutArena.getArenaWorldName());
    public static int TaskID;
    private static List<Entity> nearMinecarts = DataAboutArena.getArenaMiddle().getWorld().getEntities();
    private static Minecart minecart;

    //Spawned die Minecarts
    public static void startMinecartRain() {

       TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainSystem.getPlugin(), new Runnable() {
            @Override
            public void run() {
                    minecart = world.spawn(RandomLocation.getRandomLocation(), Minecart.class);
                    minecart.setCustomName("Get UP!");
                    minecart.setCustomNameVisible(true);
                    MainSystem.spawnedMinecart.add(minecart);
            }
        }, DataAboutGame.getTimeBetweenMinecartSpawn()*5*5, DataAboutGame.getTimeBetweenMinecartSpawn()*5);

    }



    @SuppressWarnings("deprecation")
    @Deprecated
    //Setzt die Spieler in die Minecarts
    public static void setPlayerInMinecart(Player player) {
        for (Entity entity : nearMinecarts) {
            if (entity instanceof Minecart) {
                Minecart minecart = (Minecart) entity;
                if (minecart.getPassengers() == null) {
                    if (MainSystem.spawnedMinecart.contains(minecart))
                        minecart.setPassenger(player);
                } else {

                }
            }
        }
    }

}
