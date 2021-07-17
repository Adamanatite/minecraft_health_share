package me.adamm.healthshare;

import org.bukkit.plugin.java.JavaPlugin;

import me.adamm.healthshare.commands.Toggle;
import me.adamm.healthshare.listeners.PlayerDamageListener;
import me.adamm.healthshare.utils.Utils;

/**
 * The main class for the minecraft plugin
 * 
 * @author Adam Fairlie
 */
public class Main extends JavaPlugin {
	
	/*Whether the damage share function is toggled*/
	public boolean enabled;
	
	/**
	 * The method called when the plugin is enabled
	 */
	@Override
	public void onEnable() {
		enabled = false;
		saveDefaultConfig();
		//Create damage listener and toggle command
		new PlayerDamageListener(this);
		new Toggle(this);
	}

}
