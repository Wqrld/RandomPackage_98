package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Trap implements Listener {
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager() instanceof Player) || !(event.getEntity() instanceof LivingEntity)
				|| !(RandomPackage.getEnabledEnchantsConfig().getBoolean("Elite.Trap") == true)) {
			return;
		} else {
			LivingEntity entity = (LivingEntity) event.getEntity();
			Player damager = (Player) event.getDamager();
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						if(damager.getInventory().getItemInMainHand() == null || !(damager.getInventory().getItemInMainHand().hasItemMeta()) || !(damager.getInventory().getItemInMainHand().getItemMeta().hasLore())
								|| !(damager.getInventory().getItemInMainHand().getType().name().endsWith("SWORD")) && !(damager.getInventory().getItemInMainHand().getType().name().endsWith("_AXE"))) {
							return;
						} else {
							Random random = new Random();
							int chance = 2;
							for(int i = 1; i <= 3; i++) {
								chance = chance + 2;
								if(damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Trap.Trap" + i + ".ItemLore")))
										&& random.nextInt(100) <= chance) {
									entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40 * i + 40, i + 1));
									return;
								}
							}
							return;
						}
					}
				}
			}, 1);
			return;
		}
	}
}
