package de.bypixels.teamcreate.game.util.api.checks;

import de.bypixels.teamcreate.game.util.DataAboutArena;
import de.bypixels.teamcreate.game.util.DataAboutGame;


/******************************************************************
 *   Copyright Notice                                             * 
 *   Copyright (c) PixelsDE | Daniel 2018                         *                       
 *   Created: 08.05.2018 / 16:01                                  *
 *   All contents of this source text are protected by copyright. * 
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            * 
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/
public class ExceptionWinHighUnEqualsPlayerSpawnHigh extends CheckException{

    public ExceptionWinHighUnEqualsPlayerSpawnHigh() throws CheckException {
        super("Die Spawnhoehe kann nicht gleich mit der Hoehe sein wo man gewinnt!", DataAboutGame.getHighToWinGame(), DataAboutArena.getArenaBoundY());
    }
}
