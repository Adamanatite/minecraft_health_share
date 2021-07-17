package me.adamm.healthshare.utils;

import net.md_5.bungee.api.ChatColor;

/**
 * A set of utility methods to be used elsewhere in the plugin
 * 
 * @author Adam Fairlie
 */
public class Utils {
	
	/**
	 * A helper method to convert strings to coloured text in Minecraft
	 * 
	 * @param s The string to convert
	 * @see c The converted string
	 */
	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
}
