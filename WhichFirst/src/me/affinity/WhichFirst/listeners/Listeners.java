package me.affinity.WhichFirst.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.inventory.ItemStack;

import io.netty.util.internal.ThreadLocalRandom;
import me.affinity.WhichFirst.Main;

public class Listeners implements Listener{
	private Main plugin;
	
	public Listeners(Main plugin){
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,  plugin);
	}
	
	@EventHandler
	public void eggOutcome(PlayerEggThrowEvent event) {
		
		if(event.isHatching() == true) {
			byte x = (byte) ThreadLocalRandom.current().nextInt(1, 1000000);
			event.setNumHatches(x);
		}
		
		if(event.isHatching() == false) {
			Player p = event.getPlayer();
			Egg e = event.getEgg();
			int y = ThreadLocalRandom.current().nextInt(1, 1000000);
			ItemStack stack = new ItemStack(Material.EGG, y);
			
			p.getWorld().dropItemNaturally(e.getLocation(), stack);
		}
	}

}
