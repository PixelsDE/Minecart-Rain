package de.bypixels.teamcreate.game.util;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

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

    public static File file = new File("plugins/TeamCreate/config.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);


    public static int boundaryOfMinecartSpawn;
    public static int highToWinGame;
    public static int timeToSpawnMinecart;
    public static float fallSpeedOfMinecart;
    public static int amountOfSpawnedMinecarts;


    //Setzt die Daten in die Datei
    public static void setDataInConfig() {
        cfg.addDefault("boundaryOfMinecartSpawn", 20);
        cfg.addDefault("highToWinGame", 50);
        cfg.addDefault("fallSpeedOfMinecart", 0.5);
        cfg.addDefault("timeToSpawnMinecart", 1);
        cfg.addDefault("amountOfSpawnedMinecarts", 1);

        cfg.options().copyDefaults(true);
        try {
            cfg.save(DataAboutGame.file);
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

    public static int getTimeToSpawnMinecart() {
        return cfg.getInt("timeToSpawnMinecart");
    }

    public static void setTimeToSpawnMinecart(int timeToSpawnMinecart) {
        DataAboutGame.timeToSpawnMinecart = timeToSpawnMinecart;
    }


}


