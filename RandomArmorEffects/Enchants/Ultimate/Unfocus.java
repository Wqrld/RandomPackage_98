package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Unfocus implements Listener {
	private Player player;
	private Random random = new Random();
	private ArrayList<String> bow = new ArrayList<String>();
	@EventHandler
	private void entityShootBowEvent(EntityShootBowEvent event) {
		if(!(event.getEntity() instanceof Player)) {
			return;
		} else {
			Player player = (Player) event.getEntity();
			if(player.getInventory().getItemInMainHand() == null || !(player.getInventory().getItemInMainHand().hasItemMeta()) || !(player.getInventory().getItemInMainHand().getItemMeta().hasLore())
					|| !(player.getInventory().getItemInMainHand().getType().equals(Material.BOW))) {
				return;
			} else {
				int chance = 12;
				for(int i = 1; i <= 5; i++) {
					chance = chance + 2;
					if(random.nextInt(100) <= chance && player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate.Unfocus.Unfocus" + i + ".ItemLore")))) {
						bow.add(player.getName());
						return;
					}
				}
				return;
			}
		}
	}
	@EventHandler
	private void projectileHitEvent(ProjectileHitEvent event) {
		if(event.getEntity().getShooter() instanceof Player && !(event.getEntity().getNearbyEntities(1, 1, 1).isEmpty()) 
				&& event.getEntity().getNearbyEntities(1, 1, 1).get(0) instanceof Player && !(event.getEntity().isOnGround())
				&& !(event.getEntity().getNearbyEntities(1, 1, 1).get(0).getName() == player.getName())
				&& RandomPackage.getEnabledEnchantsConfig().getBoolean("Ultimate.Unfocus") == true) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					int randomNumber = random.nextInt(11);
					if(randomNumber < 3) { randomNumber = 3; }
					if(event.getEntity().isOnGround()) { return;
					} else {
						player = (Player) event.getEntity().getNearbyEntities(1, 1, 1).get(0);
						if(bow.contains(player.getName())) {
							if(!(bow.contains(player.getName() + "1"))) {
								player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, 1, 0);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Unfocused")));
							}
							bow.add(player.getName() + "1");
							Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
								public void run() {
									bow.remove(player.getName());
									bow.remove(player.getName() + "1");
									if(!(bow.contains(player.getName())) && !(bow.contains(player.getName() + "1"))) {
										player.sendMessage(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Refocused")));
										player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, 1, 1);
									}
									return;
								}
							}, 20 * randomNumber);
							return;
						} else { return; }
					}
				}
			}, 1);
			return;
		} else {
			return;
		}
	}
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getDamager().getType().name().endsWith("ARROW")) || !(event.getEntity() instanceof Player) || player == null
				|| player.getName() == event.getEntity().getName()) {
			return;
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						if(bow.contains(player.getName() + "1")) {
							event.setDamage(event.getDamage() / 2);
							return;
						} else { return; }
					}
				}
			}, 1);
			return;
		}
	}
}