package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.mcMMO;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Greatsword implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)
				|| !(RandomPackage.getEnabledEnchantsConfig().getBoolean("Legendary.Greatsword") == true)) { return;
		} else {
			Player damager = (Player) event.getDamager();
			Player victim = (Player) event.getEntity();
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						Random random = new Random();
						int chance = 30;
						double multiplier = 1.1;
						for(int i = 1; i <= 5; i++) {
							multiplier = multiplier + 0.1;
							chance = chance + 2;
							if(random.nextInt(100) <= chance && !(damager.getInventory().getItemInMainHand() == null) && damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")
									&& damager.getInventory().getItemInMainHand().hasItemMeta() && damager.getInventory().getItemInMainHand().getItemMeta().hasLore()
									&& damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary.Greatsword.Greatsword" + i + ".ItemLore")))
									&& !(victim.getInventory().getItemInMainHand() == null) && victim.getInventory().getItemInMainHand().getType().name().endsWith("BOW")) {
								event.setDamage(event.getDamage() * multiplier);
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
