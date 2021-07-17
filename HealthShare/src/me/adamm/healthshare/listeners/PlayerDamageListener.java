package me.adamm.healthshare.listeners;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import me.adamm.healthshare.Main;
import me.adamm.healthshare.utils.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

/**
 * A listener for when a player takes damage
 * 
 * @author
 */
public class PlayerDamageListener implements Listener {
	/*Reference to main class*/
	private Main plugin;
	
	/*Class constructor*/
	public PlayerDamageListener(Main plugin) {
		/*Register listener with plugin*/
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	/**
	 * An event triggered every time a player takes damage, to share the damage
	 * 
	 * @param e The damage event triggered
	 * @see Utils#chat(String)
	 */
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		//Check entity is a player and damage sharing is on
		if(e.getEntity() instanceof Player && plugin.enabled) {
			Player p = (Player) e.getEntity();
			double dmg = e.getFinalDamage();
			//Check damage isn't a shield block or a /kill
			if(dmg > 0.05 && dmg < 1000000) {
				DecimalFormat f = new DecimalFormat("0.0");
				//Apply damage to all other players
				for(Player plr : Bukkit.getOnlinePlayers()) {
					if(!(plr.equals(p))) {
						plr.setHealth(Math.max(plr.getHealth() - dmg, 0d));
					}
					//Add message to action bar to announce damage
					plr.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Utils.chat("&b" + p.getName() + " has taken &4&l" + f.format(dmg / 2) + "❤ &bdamage")));
				}
			}
		}

		
	}
	


	
}
