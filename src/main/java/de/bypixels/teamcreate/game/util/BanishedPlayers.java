package de.bypixels.teamcreate.game.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

/******************************************************************
 *   Copyright Notice                                             * 
 *   Copyright (c) PixelsDE | Daniel 2018                         *                       
 *   Created: 09.05.2018 / 19:26                                  *
 *   All contents of this source text are protected by copyright. * 
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            * 
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/


public class BanishedPlayers {


    public BanishedPlayers() {
    }

    public static File file = new File("plugins/Minecart-Rain/banished.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    private static List<String> banishedPlayers;


    public static void setInConfig(){
        cfg.addDefault("banishedPlayers", banishedPlayers);
        cfg.options().copyDefaults(true);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getBanishedPlayers() {
        return cfg.getStringList("banishedPlayers");
    }

    public static void setBanishedPlayers(List<String> banishedPlayers) {
        BanishedPlayers.banishedPlayers = banishedPlayers;
    }
}
