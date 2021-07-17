package me.adamm.healthshare.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.adamm.healthshare.Main;
import me.adamm.healthshare.utils.Utils;

/**
 * A command used to toggle the health sharing feature
 * @author Adam Fairlie
 */
public class Toggle implements CommandExecutor {
	/*Reference to main class*/
	private Main plugin;
	
	/*Class constructor*/
	public Toggle(Main plugin) {
		/*Register command with plugin*/
		this.plugin = plugin;
		plugin.getCommand("hstoggle").setExecutor(this);
	}
	
	/**
	 * Command executor for the toggle command, to toggle damage sharing
	 * 
	 * @param sender The command sender
	 * @param cmd The command executed
	 * @param label The label used to execute the command
	 * @param args The arguments used after the command
	 * @see Utils#chat(String)
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//Check sender is a server operator
		if(sender.isOp()) {
			//Toggle enabled variable
			if(plugin.enabled) {
				plugin.enabled = false;
				sender.sendMessage(Utils.chat("&4Health Share disabled"));
			}
			else {
				plugin.enabled = true;
				sender.sendMessage(Utils.chat("&2Health Share enabled"));
			}
			
		}
		return false;
	}

}
