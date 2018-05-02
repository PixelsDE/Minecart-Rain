package de.bypixels.teamcreate.game.util;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;

/**
 * Made by PixelsDE
 * +* Minecraft-Developer
 * +* (c) PixelsDE 2018
 * +* https://youtube.com/bypixels/
 * +
 */

public class DataAboutArena {


    public static File file = new File("plugins/TeamCreate/location.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private static int highWhereMinecartsDespawn;
    private static int ArenaBoundZ;
    private static int ArenaBoundX;
    private static int highWhereMinecartsSpawn;
    private static String ArenaWorld;
    private static String deathWorldName;
    private static int deathWorldX;
    private static int deathWorldY;
    private static int deathWorldZ;
    private static int backInArenaX;
    private static int backInArenaY;
    private static int backInArenaZ;
    private static String backInArenaWorldName;


    //Setzt die oben genannten Daten in die Datei
    public static void setMinecartsDespawnHighInConfig() {
        DataAboutArena.cfg.addDefault("HighWhereMinecartsDespawn", DataAboutArena.highWhereMinecartsDespawn);
        DataAboutArena.cfg.options().copyDefaults(true);
        try {
            DataAboutArena.cfg.save(DataAboutArena.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setBackInArenaLocInConfig() {
        cfg.set("backInArenaX", backInArenaX);
        cfg.set("backInArenaY", backInArenaY);
        cfg.set("backInArenaZ", backInArenaZ);
        cfg.set("backInArenaWorldName", backInArenaWorldName);
        try {
            cfg.save(DataAboutArena.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Setzt die oben genannten Daten in die Datei
    public static void setMinecartSpawnHighInConfig() {
        DataAboutArena.cfg.addDefault("HighWhereMinecartsSpawn", highWhereMinecartsSpawn);
        DataAboutArena.cfg.options().copyDefaults(true);
        try {
            DataAboutArena.cfg.save(DataAboutArena.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Setzt die oben genannten Daten in die Datei
    public static void setArenaInConfig() {
        cfg.set("ArenaBoundZ", DataAboutArena.ArenaBoundZ);
        cfg.set("ArenaBoundX", DataAboutArena.ArenaBoundX);
        cfg.set("ArenaWorld", DataAboutArena.ArenaWorld);
        try {
            DataAboutArena.cfg.save(DataAboutArena.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Setzt die oben genannten Werte der Deathloc in die Config
    public static void setDeathLocInConfig() {
        DataAboutArena.cfg.set("deathx", deathWorldX);
        DataAboutArena.cfg.set("deathy", deathWorldY);
        DataAboutArena.cfg.set("deathz", deathWorldZ);
        DataAboutArena.cfg.set("deathworld", deathWorldName);
        try {
            DataAboutArena.cfg.save(DataAboutArena.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Some Getters and Setters need @param player

    public static int getHighWhereMinecartsSpawn() {
        return cfg.getInt("HighWhereMinecartsSpawn");
    }

    public static void setHighWhereMinecartsSpawn(Player player) {
        DataAboutArena.highWhereMinecartsSpawn = (int) player.getLocation().getY();
    }

    public static int getHighWhereMinecartsDespawn() {
        return cfg.getInt("HighWhereMinecartsDespawn");
    }

    public static void setHighWhereMinecartsDespawn(Player player) {
        DataAboutArena.highWhereMinecartsDespawn = (int) player.getLocation().getY();
    }

    public static int getArenaBoundZ() {
        return cfg.getInt("ArenaBoundZ");
    }

    public static void setArenaBoundZ(Player player) {
        DataAboutArena.ArenaBoundZ = (int) player.getLocation().getZ();
    }

    public static int getArenaBoundX() {
        return cfg.getInt("ArenaBoundY");
    }

    public static void setArenaBoundX(Player player) {
        DataAboutArena.ArenaBoundX = (int) player.getLocation().getX();
    }

    public static String getArenaWorldName() {
        return cfg.getString("ArenaWorld");
    }

    public static void setArenaWorld(String arenaWorld) {
        DataAboutArena.ArenaWorld = arenaWorld;
    }

    public static String getDeathWorldName() {
        return deathWorldName;
    }

    public static void setDeathWorldName(String deathWorldName) {
        DataAboutArena.deathWorldName = deathWorldName;
    }

    public static int getDeathWorldX() {
        return cfg.getInt("deathWorldX");
    }

    public static void setDeathWorldX(Player player) {
        DataAboutArena.deathWorldX = (int) player.getLocation().getX();
    }

    public static int getDeathWorldY() {
        return cfg.getInt("deathWorldY");
    }

    public static void setDeathWorldY(Player player) {
        DataAboutArena.deathWorldY = (int) player.getLocation().getY();
    }

    public static int getDeathWorldZ() {
        return cfg.getInt("deathWorldZ");
    }

    public static void setDeathWorldZ(Player player) {
        DataAboutArena.deathWorldZ = (int) player.getLocation().getZ();
    }

    public static int getBackInArenaX() {
        return cfg.getInt("backInArenaX");
    }

    public static void setBackInArenaX(Player player) {
        DataAboutArena.backInArenaX = (int) player.getLocation().getX();
    }

    public static int getBackInArenaY() {
        return cfg.getInt("backInArenaY");
    }

    public static void setBackInArenaY(Player player) {
        DataAboutArena.backInArenaY = (int) player.getLocation().getY();
    }

    public static int getBackInArenaZ() {
        return cfg.getInt("backInArenaZ");
    }

    public static void setBackInArenaZ(Player player) {
        DataAboutArena.backInArenaZ = (int) player.getLocation().getZ();
    }

    public static String getBackInArenaWorldName() {
        return cfg.getString("backInArenaWorldName");
    }

    public static void setBackInArenaWorldName(String backInArenaWorldName) {
        DataAboutArena.backInArenaWorldName = backInArenaWorldName;
    }
}


