package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Oxygenate implements Listener {
	@EventHandler
	private void blockBreakEvent(BlockBreakEvent event) {
		if(event.isCancelled() || event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) || !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("AXE")) && !(event.getPlayer().getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("SPADE"))
				&& !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("HOE"))
				|| !(RandomPackage.getEnabledEnchantsConfig().getBoolean("Simple.Oxygenate") == true)) {
			return;
		} else {
			Random random = new Random();
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple.Oxygenate.Oxygenate1.ItemLore")))
								&& random.nextInt(100) <= 85) {
							if(event.getPlayer().getRemainingAir() + 40 <= 300) {
								event.getPlayer().setRemainingAir(event.getPlayer().getRemainingAir() + 40);
								return;
							} else { return; }
						} else { return; }
					}
				}
			}, 1);
			return;
		}
	}
}
