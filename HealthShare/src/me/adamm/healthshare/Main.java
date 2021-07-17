package me.adamm.healthshare;

import org.bukkit.plugin.java.JavaPlugin;

import me.adamm.healthshare.commands.Toggle;
import me.adamm.healthshare.listeners.PlayerDamageListener;



public class Main extends JavaPlugin {
	
	public boolean enabled;
	
	@Override
	public void onEnable() {
		enabled = false;
		saveDefaultConfig();
		new PlayerDamageListener(this);
		new Toggle(this);
	}

}
