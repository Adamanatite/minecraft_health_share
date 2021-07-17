package me.adamm.healthshare.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.adamm.healthshare.Main;
import me.adamm.healthshare.utils.Utils;

public class Toggle implements CommandExecutor {
	private Main plugin;
	
	public Toggle(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("hstoggle").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.isOp()) {
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
