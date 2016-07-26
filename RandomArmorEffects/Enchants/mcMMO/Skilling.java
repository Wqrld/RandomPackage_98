package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.mcMMO;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.nossr50.events.experience.McMMOPlayerXpGainEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Skilling implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	private void mcMMOPlayerXpGainEvent(McMMOPlayerXpGainEvent event) {
		if(event.getSkill().getName().equalsIgnoreCase("mining") || event.getSkill().getName().equalsIgnoreCase("excavation") || event.getSkill().getName().equalsIgnoreCase("fishing")
				|| event.getSkill().getName().equalsIgnoreCase("woodcutting")) {
			if(event.isCancelled() || event.getPlayer().getInventory().getItemInMainHand() == null || !(event.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
					|| !(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore())
					|| !(RandomPackage.getEnabledEnchantsConfig().getBoolean("Ultimate.Skilling") == true)) {
				 return;
			} else {
				Random random = new Random();
				int chance = 35;
				for(int i = 1; i <= 10; i++) {
					chance = chance + 5;
					if(random.nextInt(100) <= chance && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Skilling.Skilling" + i + ".ItemLore")))) {
						event.setXpGained(event.getXpGained() * 2);
						return;
					}
				}
				return;
			}
		} else { return; }
	}
}
