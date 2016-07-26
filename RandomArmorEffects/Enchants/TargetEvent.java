package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetEvent;

public class TargetEvent implements Listener {
	@EventHandler
	private void entityTargetEvent(EntityTargetEvent event) {
		if(!(event.getTarget() instanceof Player)) {
			return;
		} else {
			if(!(event.getEntity().getCustomName() == null) && ChatColor.stripColor(event.getEntity().getCustomName()).startsWith(ChatColor.stripColor(event.getTarget().getName()))) {
				event.setCancelled(true);
				return;
			} else { return; }
		}
	}
	@EventHandler
	private void entityDeathEvent(EntityDeathEvent event) {
		for(Player player : Bukkit.getServer().getOnlinePlayers()) {
			if(!(event.getEntity().getCustomName() == null) && ChatColor.stripColor(event.getEntity().getCustomName()).contains(ChatColor.stripColor(player.getName()))) {
				event.setDroppedExp(0);
				event.getDrops().clear();
				return;
			}
		}
		return;
	}
}
