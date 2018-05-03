package de.bypixels.teamcreate.game.main;

import de.bypixels.teamcreate.game.commands.*;
import de.bypixels.teamcreate.game.events.*;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class MainSystem extends JavaPlugin {

    //TODO: SPIELER WERDEN IN ARENA TELEPORTIERT
    //TODO: MINECARTS SPAWNEN IN DER ARENA GRENZE
    //TODO: DEATH TELEPORT LOCATION

    public static MainSystem plugin;

    public static String PREFIX = "§7[§6MinecartRain§7]§f ";

    //List of Player they are Playing
    public static List<Player> isPlaying = new ArrayList<>();


    //@param Minecart ArrayList of ALL spawned Minecarts
    public static List<Minecart> spawnedMinecart = new ArrayList<>();

    @Override
    public void onEnable() {
        plugin = this;
        DataAboutGame.setDataInConfig();
        init(Bukkit.getPluginManager());

        for (Entity minecart : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()) {
            if (minecart instanceof Minecart) {
                minecart.remove();
            }
        }

    }


    //Some gettters and Setters

    public static MainSystem getPlugin() {
        return plugin;
    }

    public static String getPREFIX() {
        return PREFIX;
    }

    public static void setPREFIX(String PREFIX) {
        MainSystem.PREFIX = PREFIX;
    }

    @Override
    public void onDisable() {
        for (Entity minecart : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()) {
            if (minecart instanceof Minecart) {
                minecart.remove();
            }
        }
        Bukkit.getConsoleSender().sendMessage(MainSystem.PREFIX + "§4§aTh Plugin is: OFF!");
    }


    //Methode, welche besondere Daten einfügt
    public void init(PluginManager pluginManager) {
        DataAboutGame.setDataInConfig();

        pluginManager.registerEvents(new PlayerDropOnGround(), this);
        pluginManager.registerEvents(new WinPlayerMove(), this);
        pluginManager.registerEvents(new MinecartFallSpeed(), this);
        pluginManager.registerEvents(new MinecartDespawnOnGround(), this);
        pluginManager.registerEvents(new MinecartDamage(), this);

        MainSystem.getPlugin().getCommand("start").setExecutor(new CMDstartGame());
        MainSystem.getPlugin().getCommand("dataofgame").setExecutor(new CMDsetDatasOfGame());
        MainSystem.getPlugin().getCommand("setarena").setExecutor(new CMDsetArena());
        MainSystem.getPlugin().getCommand("deathlocation").setExecutor(new CMDsetDeathLocation());
        MainSystem.getPlugin().getCommand("backinarena").setExecutor(new CMDbackInArena());
        MainSystem.getPlugin().getCommand("highminecartspawn").setExecutor(new CMDsetMinecartSpawnHigh());
        MainSystem.getPlugin().getCommand("highminecartdespawn").setExecutor(new CMDsetMinecartDespawnHigh());
        MainSystem.getPlugin().getCommand("configreload").setExecutor(new CMDreloadConfig());
        MainSystem.getPlugin().getCommand("stoprain").setExecutor(new CMDstopGame());
        MainSystem.getPlugin().getCommand("removeminecarts").setExecutor(new CMDremove());

        Bukkit.getConsoleSender().sendMessage(MainSystem.PREFIX + "§aTh Plugin is: ON!");
    }

    //Methode, welche Text mit @param Text in die Konsole sendet
    public static void printInConsole(String text) {
        Bukkit.getConsoleSender().sendMessage(MainSystem.PREFIX + text);
    }


    //Methode, welche besonderen Text einem Spieler sendet
    public static void sendPlayerMessage(Player player, String message) {
        player.sendMessage(MainSystem.PREFIX + message);
    }

    public static void sendAllPlayerMessage(String message) {
        for (Player all : Bukkit.getOnlinePlayers())
            all.sendMessage(MainSystem.PREFIX + message);
    }


    //Removed alle Enititys wenns Minecarts sind!
    @Override
    public void onLoad() {
        for (Entity entity : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()) {
            if (entity instanceof Minecart) {
                entity.remove();
            }
        }

    }
}
