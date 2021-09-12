package me.nexcreep.tntwatchdog;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class TntRefactor implements Listener {
    Logger log = new Logger();
    @EventHandler
    public void onPlaceTnt(BlockPlaceEvent e){
        Block b = e.getBlock();
        Player p = e.getPlayer();
        int[] l = new int[]{b.getX(), b.getY(), b.getZ()};
        if (b.getType() == Material.TNT){
            World.Environment DIM = b.getWorld().getEnvironment();
            String formatted = String.format("%s placed a TNT block in %s.",p.getDisplayName(), DIM);
            log.info(formatted);
            if (b.getWorld().getEnvironment().equals(World.Environment.NORMAL)){
             e.setCancelled(true);
             p.sendMessage("§4[TNT Watchdog] Lo siento pero no puedes poner la TNT aqui ^.^");
            }
        }
    };
    @EventHandler
    public void onExplodeTnt(EntityExplodeEvent e){
        if (e.getLocation().getWorld().getEnvironment().equals(World.Environment.NORMAL)){
            e.setCancelled(true);
        }
    }
}
