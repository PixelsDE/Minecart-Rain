package de.bypixels.teamcreate.game.main;

import de.bypixels.teamcreate.game.commands.*;
import de.bypixels.teamcreate.game.events.*;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import de.bypixels.teamcreate.game.util.api.WinDetection;

import de.bypixels.teamcreate.game.util.api.specialEvents.PlayerDropOnGround;
import de.bypixels.teamcreate.game.util.api.specialEvents.PlayerWinEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class MainSystem extends JavaPlugin implements Listener {


    /******************************************************************
     *   Copyright Notice                                             *
     *   Copyright (c) PixelsDE | Daniel 2018                         *
     *   Created: 05.05.2018 / 11:59                                  *
     *   All contents of this source text are protected by copyright. *
     *   The copyright law, unless expressly indicated otherwise, is  *
     *   at PixelsDE | Daniel. All rights reserved                    *
     *   Any type of duplication, distribution, rental, sale, award,  *
     *   Public accessibility or other use                            *
     *   Requires the express written consent of PixelsDE | Daniel.   *
     *****************************************************************/

    //TODO: SPIELER WERDEN IN ARENA TELEPORTIERT
    //TODO: MINECARTS SPAWNEN IN DER ARENA GRENZE
    //TODO: DEATH TELEPORT LOCATION

    public static MainSystem plugin;

    private static boolean start;

    public static String PREFIX;

    //List of Player they are Playing
    public static List<Player> isPlaying = new ArrayList<>();


    //@param Minecart ArrayList of ALL spawned Minecarts
    public static List<Minecart> spawnedMinecarts = new ArrayList<>();


    @Override
    public void onEnable() {
        plugin = this;
        DataAboutGame.setDataInConfig();
        init(Bukkit.getPluginManager());


        try {
            for (Entity minecart : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()) {
                if (minecart instanceof Minecart) {
                    minecart.remove();
                }
            }
        } catch (Exception e) {
            MainSystem.printInConsole("Du musst erst die Welt festlegen!");
        }

    }


    //Some gettters and Setters

    public static MainSystem getPlugin() {
        return plugin;
    }

    public static String getPREFIX() {
        return PREFIX;
    }

    public static boolean isStart() {
        return start;
    }

    public static void setStart(boolean start) {
        MainSystem.start = start;
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
    @SuppressWarnings("deprecation")
    public void init(PluginManager pluginManager) {
        DataAboutGame.setDataInConfig();

        setStart(false);
        pluginManager.registerEvents(new DropOnGround(), this);
        pluginManager.registerEvents(new WinPlayerMove(), this);
        pluginManager.registerEvents(new MinecartFallSpeed(), this);
        pluginManager.registerEvents(new MinecartDespawnOnGround(), this);
        pluginManager.registerEvents(new MinecartDamage(), this);
        pluginManager.registerEvents(this, this);
        pluginManager.registerEvents(new MinecartJoinEvent(), this);

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
        MainSystem.getPlugin().getCommand("teleportinminecart").setExecutor(new CMDteleportInMinecart());

        DataAboutGame.setPREFIX(DataAboutGame.getPREFIX());

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


    @EventHandler(ignoreCancelled = true)
    public void onDroponGround(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (MainSystem.isPlaying.contains(player)) {
            if (MainSystem.isStart() == true) {
                if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
                    Bukkit.getPluginManager().callEvent(new PlayerDropOnGround(player));

                }
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerWin(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (WinDetection.checkForWin(player) == true) {
            if (MainSystem.isStart() == true) {
                Bukkit.getPluginManager().callEvent(new PlayerWinEvent(player));
            }
        }
    }

}
