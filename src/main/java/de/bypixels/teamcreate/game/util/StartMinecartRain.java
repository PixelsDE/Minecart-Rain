package de.bypixels.teamcreate.game.util;

/**
 * Made by PixelsDE
 * +* Minecraft-Developer
 * +* (c) PixelsDE 2018
 * +* https://youtube.com/bypixels/
 * +
 */

public class StartMinecartRain {
/*

    public static int TaskID;
    public StartMinecartRain(Player player) {

    }

    public Location setRandomLocationinBound(Player player) {

        World world = Bukkit.getWorld(DataAboutArena.cfg.getString("world"));
        this.location = new Location(world, DataAboutArena.cfg.getInt("boundx"), DataAboutArena.cfg.getInt("boundy"), DataAboutArena.cfg.getInt("boundz"));

            this.location.setX(DataAboutArena.cfg.getDouble("boundx") + Math.random() * 2 * boundary - boundary);
            this.location.setZ(DataAboutArena.cfg.getDouble("boundz") + Math.random() * 2 * boundary - boundary);
            this.location.setY(player.getLocation().getY() + MainSystem.dataAboutGame.getDataInt("high_above_player"));
            return this.location;

    }




    public void startRain(Player player) {
        try {
            World world = Bukkit.getWorld(DataAboutArena.cfg.getString("world"));
            Location loc = new Location(world, DataAboutArena.cfg.getInt("boundx"), DataAboutArena.cfg.getInt("boundy")+5, DataAboutArena.cfg.getInt("boundz"));
            player.getPlayer().teleport(loc);
            Location block = player.getLocation();
            Bukkit.getWorld(player.getWorld().getName()).spawn(block, Minecart.class);
            List<Entity> near = loc.getWorld().getEntities();
            for (Entity entity : near) {
                if (entity instanceof Minecart) {
                    Minecart minecart = (Minecart) entity;
                    if (player.getLocation().distance(minecart.getLocation()) <= 2) {
                        minecart.setPassenger(player);
                    }
                }
            }


            TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainSystem.getPlugin(), new Runnable() {
                @Override
                public void run() {

                    if (MainSystem.isPlaying.contains(player)) {

                        world.spawn(setRandomLocationinBound(player), Minecart.class);
                        for (Player all : Bukkit.getOnlinePlayers()){
                        if (all.getLocation().getY() >= whereHashMap.get(all).getY()+  MainSystem.dataAboutGame.getDataInt("high_to_win")+5){
                            for (Player a : Bukkit.getOnlinePlayers())
                               a.sendMessage("§a Der Spieler : §6"+ all.getName() + " §ahat es geschafft!");
                               MainSystem.isPlaying.remove(all);
                               all.sendMessage("§aDu hast es geschafft!");
                               whereHashMap.remove(all);
                           }
                        }
                    }
                }
            }, MainSystem.dataAboutGame.getDataInt("time_spawn_minecart"),  MainSystem.dataAboutGame.getDataInt("time_spawn_minecart"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

*/

}
