package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffectType;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class Virus implements Listener {
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
				int chance = 30;
				for(int i = 1; i <= 4; i++) {
					chance = chance + 5;
					if(random.nextInt(100) <= chance && player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite.Virus.Virus" + i + ".ItemLore")))) {
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
				&& event.getEntity().getNearbyEntities(1, 1, 1).get(0) instanceof Player && !(event.getEntity().isOnGround())) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.getEntity().isOnGround()) { return;
					} else {
						player = (Player) event.getEntity().getShooter();
						Player player = (Player) event.getEntity().getShooter();
						Player entity = (Player) event.getEntity().getNearbyEntities(1, 1, 1).get(0);
						if(bow.contains(player.getName())) {
							bow.add(player.getName() + "1");
							if(random.nextInt(10) == 0) { entity.removePotionEffect(PotionEffectType.REGENERATION); }
							return;
						} else { return; }
					}
				}
			}, 1);
			return;
		} else if(event.getEntity().getShooter() instanceof Player && bow.contains(((Player) event.getEntity().getShooter()).getName())) {
			bow.remove(((Player) event.getEntity().getShooter()).getName());
			return;
		} else {
			return;
		}
	}
	@EventHandler
	private void entityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof Player) || !(event.getDamager().getType().name().endsWith("ARROW"))
				|| player == null || !(bow.contains(player.getName())) || !(bow.contains(player.getName() + "1"))
				|| !(RandomPackage.getEnabledEnchantsConfig().getBoolean("Elite.Virus") == true)) {
			return;
		} else {
			Player entity = (Player) event.getEntity();
			Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
				public void run() {
					if(event.isCancelled()) { return;
					} else {
						double damage = 1.0;
						if(entity.hasPotionEffect(PotionEffectType.WITHER)) { damage = damage + random.nextDouble() * 2; }
						if(entity.hasPotionEffect(PotionEffectType.POISON)) { damage = damage + random.nextDouble() * 2; }
						event.setDamage(event.getDamage() * damage);
						player.sendMessage("" + damage);
						bow.remove(player.getName());
						bow.remove(player.getName() + "1");
						return;
					}
				}
			}, 1);
			return;
		}
	}
}