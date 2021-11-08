package me.affinity.WhichFirst;

import org.bukkit.plugin.java.JavaPlugin;

import me.affinity.WhichFirst.listeners.Listeners;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		new Listeners(this);
	}

}
