package de.bypixels.teamcreate.game.util;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

/**
 * Made by PixelsDE
 * +* Minecraft-Developer
 * +* (c) PixelsDE
 * +* https://youtube.com/bypixels/
 * +
 */
public class DataAboutGame {


    public DataAboutGame() {
    }

    public static File file = new File("plugins/Minecart-Rain/config.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);


    public static int boundaryOfMinecartSpawn;
    public static int highToWinGame;
    public static int timeBetweenMinecartSpawn;
    public static float fallSpeedOfMinecart;
    public static int amountOfSpawnedMinecarts;
    public static int timeBeforeStartRain;
    public static int timeBeforePutPlayerInMinecart;
    private static int highWhereMinecartsSpawn;
    private static int highWhereMinecartsDespawn;

    //Setzt die Daten in die Datei
    public static void setDataInConfig() {
        cfg.addDefault("boundaryOfMinecartSpawn", 15);
        cfg.addDefault("highToWinGame", 50);
        cfg.addDefault("fallSpeedOfMinecart", 0.5);
        cfg.addDefault("timeBetweenMinecartSpawn", 1);
        cfg.addDefault("amountOfSpawnedMinecarts", 1);
        cfg.addDefault("timeBeforeStartRain", 1);
        cfg.addDefault("timeBeforePutPlayerInMinecart", 3);
        cfg.options().copyDefaults(true);
        try {
            cfg.save(DataAboutGame.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Setzt die oben genannten Daten in die Datei
    public static void setMinecartSpawnHighInConfig() {
        DataAboutGame.cfg.addDefault("highWhereMinecartsSpawn", highWhereMinecartsSpawn);
        DataAboutGame.cfg.options().copyDefaults(true);
        try {
            DataAboutGame.cfg.save(DataAboutGame.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Setzt die oben genannten Daten in die Datei
    public static void setMinecartsDespawnHighInConfig() {
        DataAboutGame.cfg.addDefault("highWhereMinecartsDespawn", highWhereMinecartsDespawn);
        DataAboutGame.cfg.options().copyDefaults(true);
        try {
            DataAboutGame.cfg.save(DataAboutGame.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Some Getters and Setters
    public static int getAmountOfSpawnedMinecarts() {
        return cfg.getInt("amountOfSpawnedMinecarts");
    }

    public static void setAmountOfSpawnedMinecarts(int amountOfSpawnedMinecarts) {
        DataAboutGame.amountOfSpawnedMinecarts = amountOfSpawnedMinecarts;
    }

    public static int getBoundaryOfMinecartSpawn() {
        return cfg.getInt("boundaryOfMinecartSpawn");
    }

    public static void setBoundaryOfMinecartSpawn(int boundaryOfMinecartSpawn) {
        DataAboutGame.boundaryOfMinecartSpawn = boundaryOfMinecartSpawn;
    }

    public static int getHighToWinGame() {
        return cfg.getInt("highToWinGame");
    }

    public static void setHighToWinGame(int highToWinGame) {
        DataAboutGame.highToWinGame = highToWinGame;
    }

    public static float getFallSpeedOfMinecart() {
        return (float) cfg.getDouble("fallSpeedOfMinecart");
    }

    public static void setFallSpeedOfMinecart(float fallSpeedOfMinecart) {
        DataAboutGame.fallSpeedOfMinecart = fallSpeedOfMinecart;
    }

    public static int getTimeBetweenMinecartSpawn() {
        return cfg.getInt("timeBetweenMinecartSpawn");
    }

    public static void setTimeBetweenMinecartSpawn(int timeBetweenMinecartSpawn) {
        DataAboutGame.timeBetweenMinecartSpawn = timeBetweenMinecartSpawn;
    }

    public static int getTimeBeforeStartRain() {
        return timeBeforeStartRain;
    }

    public static void setTimeBeforeStartRain(int timeBeforeStartRain) {
        DataAboutGame.timeBeforeStartRain = timeBeforeStartRain;
    }

    public static int getTimeBeforePutPlayerInMinecart() {
        return timeBeforePutPlayerInMinecart;
    }

    public static void setTimeBeforePutPlayerInMinecart(int timeBeforePutPlayerInMinecart) {
        DataAboutGame.timeBeforePutPlayerInMinecart = timeBeforePutPlayerInMinecart;
    }


    public static int getHighWhereMinecartsSpawn() {
        return cfg.getInt("highWhereMinecartsSpawn");
    }

    public static void setHighWhereMinecartsSpawn(Player player) {
        DataAboutGame.highWhereMinecartsSpawn = (int) player.getLocation().getY();
    }

    public static int getHighWhereMinecartsDespawn() {
        return cfg.getInt("highWhereMinecartsDespawn");
    }

    public static void setHighWhereMinecartsDespawn(Player player) {
        DataAboutGame.highWhereMinecartsDespawn = (int) player.getLocation().getY();
    }

}


