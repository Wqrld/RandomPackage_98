package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.mcMMO;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.nossr50.events.experience.McMMOPlayerXpGainEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Training implements Listener {
	@EventHandler
	private void mcMMOPlayerXpGainEvent(McMMOPlayerXpGainEvent event) {
		if(event.isCancelled() || event.getPlayer().getInventory().getItemInMainHand() == null
				|| !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) || !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
				|| !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("SWORD")) && !(event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("_AXE"))
				|| !(RandomPackage.getEnabledEnchantsConfig().getBoolean("Ultimate.Training") == true)) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				@SuppressWarnings("deprecation")
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Random random = new Random();
						int xp = random.nextInt(3) + 1;
						int chance = 5;
						for(int i = 1; i <= 10; i++) {
							chance = chance + 5;
							if(random.nextInt(100) <= chance && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Training.Training" + i + ".ItemLore")))) {
								event.setXpGained(event.getXpGained() * xp);
								return;
							}
						}
						return;
					}
				}
			}, 1);
			return;
		}
	}
}
