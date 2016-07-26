package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class BlockBreakCheck implements Listener {
	@EventHandler
	private void blockBreakEvent(BlockBreakEvent event) {
		if(event.isCancelled()) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) {
						return;
					} else {
						return;
					}
				}
			}, 2);
			return;
		}
	}
}
