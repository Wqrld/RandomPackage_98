package me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.NotFinished;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class Clarity implements Listener {
	@EventHandler
	private void playerMoveEvent(PlayerMoveEvent event) {
		if(event.getPlayer().hasPotionEffect(PotionEffectType.BLINDNESS)) {
		} else { return; }
	}
}
