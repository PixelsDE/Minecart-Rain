package de.bypixels.teamcreate.game.util;

import de.bypixels.teamcreate.game.main.MainSystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/******************************************************************
 *   Copyright Notice                                             * 
 *   Copyright (c) PixelsDE | Daniel 2018                         *                       
 *   Created: 22.05.2018 / 09:52                                  *
 *   All contents of this source text are protected by copyright. * 
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            * 
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/


public class SortedHashMap {

    public Map SortedHashMap(HashMap map) {
        Map<Object, Object> sorted = new TreeMap<Object, Object>(map);
                return sorted;
    }

    public static void sort() {
        HashMap<Integer, String> notwin = new HashMap<Integer, String>();
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (MainSystem.isPlaying.contains(all)) {
                notwin.put((int) all.getLocation().getY(), all.getName());
            }
        }

        HashMap<Integer, String> sortedMap = new HashMap<Integer, String>(notwin);
        for (Player all : Bukkit.getOnlinePlayers()) {
            for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
                all.sendMessage(MainSystem.getPREFIX()+ "§7Der Spieler: §6" + entry.getValue() + " §7hat eine Höhe von: §6" + entry.getKey() + " §7erreicht!");
            }
            all.sendMessage(MainSystem.getPREFIX() + "§7Die Spieler: §6" + MainSystem.winner);
        }

    }
}
