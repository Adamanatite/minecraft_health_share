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

public class PlayerDamageListener implements Listener {
	private Main plugin;
	
	public PlayerDamageListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player && plugin.enabled) {
			Player p = (Player) e.getEntity();
			double dmg = e.getFinalDamage();
			
			if(dmg > 0.05 && dmg < 1000000) {
				DecimalFormat f = new DecimalFormat("0.0");
				for(Player plr : Bukkit.getOnlinePlayers()) {
					if(!(plr.equals(p))) {
						plr.setHealth(Math.max(plr.getHealth() - dmg, 0d));
					}
					plr.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Utils.chat("&b" + p.getName() + " has taken &4&l" + f.format(dmg / 2) + "❤ &bdamage")));
				}
			}
		}

		
	}
	


	
}
