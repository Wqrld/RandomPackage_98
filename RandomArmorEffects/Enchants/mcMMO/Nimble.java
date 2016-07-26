package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.mcMMO;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.nossr50.events.experience.McMMOPlayerXpGainEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Nimble implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	private void mcMMOPlayerXpGainEvent(McMMOPlayerXpGainEvent event) {
		if(event.getSkill().getName().equalsIgnoreCase("acrobatics") && !(event.isCancelled())) {
			if(event.getPlayer().getInventory().getBoots() == null || !(event.getPlayer().getInventory().getBoots().hasItemMeta())
					|| !(event.getPlayer().getInventory().getBoots().getItemMeta().hasLore())
					|| !(RandomPackage.getEnabledEnchantsConfig().getBoolean("Elite.Nimble") == true)) {
				 return;
			} else {
				Random random = new Random();
				int chance = 40;
				for(int i = 1; i <= 5; i++) {
					chance = chance + 5;
					if(random.nextInt(100) <= chance && event.getPlayer().getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Nimble.Nimble" + i + ".ItemLore")))) {
						event.setXpGained(event.getXpGained() * (Math.addExact(1, random.nextInt(3))));
						return;
					}
				}
				return;
			}
		} else { return; }
	}
}
