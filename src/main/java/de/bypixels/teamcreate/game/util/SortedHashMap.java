package de.bypixels.teamcreate.game.util;

import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.sql.MySQL;
import de.bypixels.teamcreate.game.util.sql.SQLPoints;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;


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

    public static void sortTheMap() {
        HashMap<Integer, String> playerhigh = new HashMap<Integer, String>();
        for (Player allPlayer : Bukkit.getOnlinePlayers()) {
            if (allPlayer.getGameMode() != GameMode.SPECTATOR) {
                if (!MainSystem.winner.contains(allPlayer)) {
                    playerhigh.put((int) allPlayer.getLocation().getY(), allPlayer.getName());
                }else{
                  /*  playerhigh.put(DataAboutGame.getHighToWinGame(), allPlayer.getName());*/
                }
            }
        }


        HashMap<Integer, String> sortedMap = new HashMap<Integer, String>(playerhigh);
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (MainSystem.mySQLClass.getCfg().getBoolean("MySQL") == true){
                SQLPoints.update((int) all.getLocation().getY(), all.getName());
            }
            if (!MainSystem.winner.contains(all)){
                for (Map.Entry<Integer, String> hoehe : sortedMap.entrySet()) {
                    all.sendMessage(MainSystem.getPREFIX() + "§7Der Spieler: §6" + all.getPlayer().getName() + " §7hat eine Höhe von: §6" + hoehe.getKey() + " §7erreicht!");

                }
            }

/*

            String names = "";
            for (int number = 0; number >= MainSystem.winner.size(); number++) {
                names = names + MainSystem.winner.get(number).getName().toString() + ", ";
            }
            all.sendMessage(MainSystem.getPREFIX() + "§7Die Spieler: §6" + names + "§7haben das Ziel erreicht!");
*/

        }
    }



    public Map SortedHashMap(HashMap map) {
        Map<Object, Object> sortedMap = new TreeMap<Object, Object>(map);
        return sortedMap;
    }
}
