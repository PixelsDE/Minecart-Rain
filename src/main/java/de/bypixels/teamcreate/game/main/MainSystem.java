package de.bypixels.teamcreate.game.main;

import de.bypixels.teamcreate.game.commands.*;
import de.bypixels.teamcreate.game.events.EVENTMovingEntities;
import de.bypixels.teamcreate.game.events.EVENTplayerDropOnGround;
import de.bypixels.teamcreate.game.events.EVENTwinPlayerMove;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.Bukkit;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class MainSystem extends JavaPlugin {

    //TODO: SPIELER WERDEN IN ARENA TELEPORTIERT
    //TODO: MINECARTS SPAWNEN IN DER ARENA GRENZE
    //TODO: DEATH TELEPORT LOCATION

    public static MainSystem plugin;

    public static String PREFIX = "§7[§6MinecartRain§7]§f ";

    //Arraylist of Player they are Playing
    public static ArrayList<Player> isPlaying = new ArrayList<>();


    //ArrayList of all spawned Minecarts
    public static ArrayList<Minecart> spawnedMinecart = new ArrayList<>();

    @Override
    public void onEnable() {

        plugin = this;
        DataAboutGame.setDataInConfig();
        init(Bukkit.getPluginManager());
    }


    public static MainSystem getPlugin() {
        return plugin;
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(MainSystem.PREFIX + "§4OFF!");
    }

    public void init(PluginManager pluginManager) {

        DataAboutGame.setDataInConfig();

        pluginManager.registerEvents(new EVENTMovingEntities(), this);
        pluginManager.registerEvents(new EVENTplayerDropOnGround(), this);
        pluginManager.registerEvents(new EVENTwinPlayerMove(), this);

        MainSystem.getPlugin().getCommand("start").setExecutor(new CMDstartGame());
        MainSystem.getPlugin().getCommand("dataofgame").setExecutor(new CMDsetDatasOfGame());
        MainSystem.getPlugin().getCommand("setarena").setExecutor(new CMDsetArena());
        MainSystem.getPlugin().getCommand("deathlocation").setExecutor(new CMDsetDeathLocation());
        MainSystem.getPlugin().getCommand("backinarena").setExecutor(new CMDbackInArena());
        MainSystem.getPlugin().getCommand("highminecartspawn").setExecutor(new CMDsetMinecartSpawnHigh());
        MainSystem.getPlugin().getCommand("minecartdespawnhigh").setExecutor(new CMDsetMinecartDespawnHigh());
        Bukkit.getConsoleSender().sendMessage(MainSystem.PREFIX + "§aON!");
    }
}

