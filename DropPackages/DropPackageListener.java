package me.randomHashTags.randomPackage.DropPackages;


import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class DropPackageListener implements Listener {
	private static Inventory dropPackage;
	private ArrayList<Player> delay = new ArrayList<Player>();
	private ItemStack item = new ItemStack(Material.ACACIA_DOOR, 1);
	private ItemMeta itemMeta = item.getItemMeta();
	private ArrayList<String> lore = new ArrayList<String>();
	private Random random = new Random();
	private static String dropPackageRarity = null;
	
	private String getDropPackageRarity(InventoryClickEvent event) {
		if(!(event.isCancelled()) && !(event.getWhoClicked().getOpenInventory().getTitle() == null) && !(event.getCurrentItem() == null)) {
			if(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Legendary.ChestName")))) {
				return dropPackageRarity = "Legendary";
			} else if(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Ultimate.ChestName")))) {
				return dropPackageRarity = "Ultimate";
			} else if(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Elite.ChestName")))) {
				return dropPackageRarity = "Elite";
			} else if(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Unique.ChestName")))) {
				return dropPackageRarity = "Unique";
			} else if(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Simple.ChestName")))) {
				return dropPackageRarity = "Simple";
			} else {
				return null;
			}
		} else { return null; }
	}
	@EventHandler
	private void inventoryClickEvent(InventoryClickEvent event) {
		if(!(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Legendary.ChestName"))))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Ultimate.ChestName"))))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Elite.ChestName"))))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Unique.ChestName"))))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Simple.ChestName"))))) {
			return;
		} else {
			Player player = (Player) event.getWhoClicked();
			if(!(event.getCurrentItem() == null)
					&& event.getCurrentItem().getType().name().endsWith("CHEST")
					&& event.getCurrentItem().hasItemMeta()
					&& event.getCurrentItem().getItemMeta().hasDisplayName()
					&& !(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Legendary.Name"))))
					&& !(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Ultimate.Name"))))
					&& !(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Elite.Name"))))
					&& !(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Unique.Name"))))
					&& !(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Simple.Name"))))
					&& event.getCurrentItem().getItemMeta().hasLore()) {
				
				getDropPackageRarity(event);
				
				item = new ItemStack(Material.THIN_GLASS, 1);
				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString(dropPackageRarity + ".Pane.Name")));
				for(int i = 0; i < RandomPackage.getDropPackageConfig().getStringList(dropPackageRarity + ".Pane.Lore").size(); i++) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getStringList(dropPackageRarity + ".Pane.Lore").get(i).replace("%dropPackageRarity%", dropPackageRarity)));
				}
				itemMeta.setLore(lore);
				item.setItemMeta(itemMeta);
				
				event.setCancelled(true);
				player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 3);
				event.setCurrentItem(item);
				lore.clear();
				player.updateInventory();
				if(dropPackage.contains(Material.THIN_GLASS, 4)) {
					Bukkit.getScheduler().scheduleSyncRepeatingTask(RandomPackage.getPlugin(), new Runnable() {
						public void run() {
							if(!(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Legendary.ChestName"))))
									&& !(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Ultimate.ChestName"))))
									&& !(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Elite.ChestName"))))
									&& !(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Unique.ChestName"))))
									&& !(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Simple.ChestName"))))) {
								return;
							} else {
								String dropPackageRarity = null;
								if(dropPackage.contains(Material.THIN_GLASS, 4)) {
									delay.add(player);
									player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1, 2);
									
									item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) random.nextInt(6));
									itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString(dropPackageRarity + ".Pane.Name")));
									lore.add(ChatColor.GRAY + "You have chosen this pane.");
									itemMeta.setLore(lore);
									item.setItemMeta(itemMeta);
									Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
										public void run() {
											for(int i = 0; i <= 26; i++) {
												if(!(player.getOpenInventory().getItem(i).getType().name().endsWith("THIN_GLASS"))) {
													player.getOpenInventory().setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) random.nextInt(6)));
												} else if(player.getOpenInventory().getItem(i).getType().name().endsWith("THIN_GLASS")) {
													player.getOpenInventory().setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) random.nextInt(6)));
													player.getOpenInventory().getItem(i).setItemMeta(itemMeta);
												}
											}
										}
									}, 0L);
								} else {
									player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1, 2);
									for(int i = 0; i <= 26; i++) {
										if(player.getOpenInventory().getItem(i).getType().name().endsWith("STAINED_GLASS_PANE")
												&& player.getOpenInventory().getItem(i).hasItemMeta()
												&& player.getOpenInventory().getItem(i).getItemMeta().hasDisplayName()
												&& player.getOpenInventory().getItem(i).getItemMeta().hasLore()) {
											player.getOpenInventory().setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) random.nextInt(6)));
											
											String dropPackageRarityzz = null;
											
											getDropPackageRarity(event);
											
											if(player.getOpenInventory().getItem(i).getData().toString().equals("STAINED_GLASS_PANE(0)")) {
												dropPackageRarityzz = ChatColor.WHITE + "Simple";
											} else if(player.getOpenInventory().getItem(i).getData().toString().equals("STAINED_GLASS_PANE(1)")) {
												dropPackageRarityzz = ChatColor.GOLD + "Legendary";
											} else if(player.getOpenInventory().getItem(i).getData().toString().equals("STAINED_GLASS_PANE(3)")) {
												dropPackageRarityzz = ChatColor.AQUA + "Elite";
											} else if(player.getOpenInventory().getItem(i).getData().toString().equals("STAINED_GLASS_PANE(4)")) {
												dropPackageRarityzz = ChatColor.YELLOW + "Ultimate";
											} else if(player.getOpenInventory().getItem(i).getData().toString().equals("STAINED_GLASS_PANE(5)")) {
												dropPackageRarityzz = ChatColor.GREEN + "Unique";
											} else { return; }
											if(!(DropPackageListener.dropPackageRarity == null)
													&& player.getOpenInventory().getItem(i).hasItemMeta()
													&& player.getOpenInventory().getItem(i).getItemMeta().hasDisplayName()
													&& player.getOpenInventory().getItem(i).getItemMeta().hasLore()) {
												player.getOpenInventory().getItem(i).getItemMeta().setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString(DropPackageListener.dropPackageRarity + ".Pane.Name")));
											}
											item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) random.nextInt(6));
											itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString(DropPackageListener.dropPackageRarity + ".Pane.Name")));
											for(int o = 0; o < RandomPackage.getDropPackageConfig().getStringList(DropPackageListener.dropPackageRarity + ".Pane.Lore").size(); o++) {
												lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getStringList(DropPackageListener.dropPackageRarity + ".Pane.Lore").get(o).replace("%dropPackageRarity%", DropPackageListener.dropPackageRarity)));
											}
											itemMeta.setLore(lore);
											item.setItemMeta(itemMeta);
											player.getOpenInventory().getItem(i).setItemMeta(itemMeta);
										} else {
											player.getOpenInventory().setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) random.nextInt(6)));
										}
									}
									Bukkit.getScheduler().scheduleSyncDelayedTask(RandomPackage.getPlugin(), new Runnable() {
										public void run() {
											delay.remove(player);
											for(int i = 0; i <= 26; i++) {
												if(!(player.getOpenInventory().getItem(i) == null)
														&& !(player.getOpenInventory().getItem(i).hasItemMeta())) {
													player.getOpenInventory().setItem(i, new ItemStack(Material.AIR));
												}
											}
										}
									}, 80L);
									return;
								}
							}
						}
					}, 0L, 2L);
					return;
				} else {
					return;
				}
			} else if(!(event.getCurrentItem() == null)
					&& event.getCurrentItem().getType().name().endsWith("THIN_GLASS")
					&& event.getCurrentItem().hasItemMeta()
					&& event.getCurrentItem().getItemMeta().hasDisplayName()
					&& event.getCurrentItem().getItemMeta().hasLore()) {
				item = new ItemStack(Material.CHEST, event.getRawSlot() + 1);
				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("ChestOptions.DisplayName")));
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("ChestOptions.Lore1")));
				lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("ChestOptions.Lore2")));
				itemMeta.setLore(lore);
				item.setItemMeta(itemMeta);
				
				event.setCancelled(true);
				player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 2);
				event.setCurrentItem(item);
				player.updateInventory();
				return;
			} else {
				event.setCancelled(true);
				return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	private void inventoryClickEvent2(InventoryClickEvent event) {
		if(event.getWhoClicked().getOpenInventory() == null
				|| event.getCurrentItem() == null
				|| !(event.getCurrentItem().hasItemMeta())
				|| !(event.getCurrentItem().getType().name().endsWith("STAINED_GLASS_PANE"))
				|| !(event.getCurrentItem().getItemMeta().hasDisplayName())
				|| !(event.getCurrentItem().getItemMeta().hasLore())
				|| !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Legendary.ChestName"))))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Ultimate.ChestName"))))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Elite.ChestName"))))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Unique.ChestName"))))
				&& !(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Simple.ChestName"))))
				|| delay.contains(event.getWhoClicked())) {
			return;
		} else {
			Player player = (Player) event.getWhoClicked();
			String dropPackageRarity = null;
			
			getDropPackageRarity(event);
			
			if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("PaneSelectedOptions.Legendary.DisplayName")))) {
				dropPackageRarity = "LegendaryItems";
			} else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("PaneSelectedOptions.Ultimate.DisplayName")))) {
				dropPackageRarity = "UltimateItems";
			} else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("PaneSelectedOptions.Elite.DisplayName")))) {
				dropPackageRarity = "EliteItems";
			} else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("PaneSelectedOptions.Unique.DisplayName")))) {
				dropPackageRarity = "UniqueItems";
			} else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("PaneSelectedOptions.Simple.DisplayName")))) {
				dropPackageRarity = "SimpleItems";
			} else {
				dropPackageRarity = null;
				return;
			}
			Random random = new Random();
			int randomChance = 5;
			for(int i = 1; i <= 100; i++) {
				if(!(RandomPackage.getDropPackageConfig().getString(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + i) == null)) {
					randomChance = i + 1;
				}
			}
			int randomItem = random.nextInt(randomChance);
			if(randomItem == 0) {
				randomItem = 1;
			}
			if(RandomPackage.getDropPackageConfig().getString(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + randomItem) == null
					|| RandomPackage.getDropPackageConfig().getString(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + randomItem + ".Item").toUpperCase() == null) {
				return;
			} else {
				ArrayList<String> lore = new ArrayList<String>();
				for(int j = 1; j <= 12; j++) {
					if(!(RandomPackage.getDropPackageConfig().getString(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + randomItem + ".Lores.Lore" + j) == null)) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + randomItem + ".Lores.Lore" + j)));
					}
				}
				for(int i = 1; i <= 100; i++) {
					item = new ItemStack(Material.getMaterial(RandomPackage.getDropPackageConfig().getString(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + randomItem + ".Item").toUpperCase()), RandomPackage.getDropPackageConfig().getInt(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + randomItem + ".Amount"));
					itemMeta.setLore(lore);
					itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + randomItem + ".DisplayName")));
					for(int o = 1; o <= 5; o++) {
						if(!(RandomPackage.getDropPackageConfig().getString(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + randomItem + ".Enchants") == null)
								&& !(RandomPackage.getDropPackageConfig().getInt(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + randomItem + ".Enchants.Enchant" + o + "Level") == 0)) {
							itemMeta.addEnchant(Enchantment.getById(RandomPackage.getDropPackageConfig().getInt(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + randomItem + ".Enchants.Enchant" + o)), RandomPackage.getDropPackageConfig().getInt(DropPackageListener.dropPackageRarity + "." + dropPackageRarity + ".Item" + randomItem + ".Enchants.Enchant" + o + "Level"), true);
							//configItem.addEnchantment(Enchantment.getById(RandomPackage.getDropPackageConfig().getInt(dropPackageType + "." + dropPackageRarity + ".Item" + randomItem + ".Enchants.Enchant" + o)), RandomPackage.getDropPackageConfig().getInt(dropPackageType + "." + dropPackageRarity + ".Item" + randomItem + ".Enchants.Enchant" + o + "Level"));
						}
					}
					item.setItemMeta(itemMeta);
					
					event.setCurrentItem(item);
					event.setCancelled(true);
					player.updateInventory();
				}
			}
			return;
		}
	}
	@EventHandler
	private void inventoryCloseEvent(InventoryCloseEvent event) {
		Player player = (Player) event.getPlayer();
		if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Legendary.ChestName")))
				|| player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Ultimate.ChestName")))
				|| player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Elite.ChestName")))
				|| player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Unique.ChestName")))
				|| player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Simple.ChestName")))) {
			for(int i = 0; i <= 26; i++) {
				if(player.getOpenInventory().getItem(i).getType().name().endsWith("TRAPPED_CHEST")
						&& player.getOpenInventory().getItem(i).hasItemMeta()
						&& player.getOpenInventory().getItem(i).getItemMeta().hasDisplayName()
						&& player.getOpenInventory().getItem(i).getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Panes.Name")))
						&& player.getOpenInventory().getItem(i).getItemMeta().hasLore()
						|| player.getOpenInventory().getItem(i).getType().name().endsWith("THIN_GLASS")
						|| !(player.getOpenInventory().getItem(i).getType() == Material.AIR)
						&& player.getOpenInventory().getItem(i).getType().name().endsWith("STAINED_GLASS_PANE")) {
					String dropPackageType = null;
					if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Legendary.ChestName")))) {
						dropPackageType = "Legendary";
					} else if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Ultimate.ChestName")))) {
						dropPackageType = "Ultimate";
					} else if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Elite.ChestName")))) {
						dropPackageType = "Elite";
					} else if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Unique.ChestName")))) {
						dropPackageType = "Unique";
					} else if(player.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Simple.ChestName")))) {
						dropPackageType = "Simple";
					} else { return; }
					item = new ItemStack(Material.TRAPPED_CHEST, 1);
					itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString(dropPackageType + ".Name")));
					for(int o = 0; o < RandomPackage.getDropPackageConfig().getStringList("Panes.Lore").size(); o++) {
						lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getStringList("Panes.Lore").get(o)));
					}
					itemMeta.setLore(lore);
					item.setItemMeta(itemMeta);
					
					player.getInventory().addItem(item);
					player.updateInventory();
					return;
				} else if(!(player.getOpenInventory().getItem(i).getType() == Material.AIR)
						&& !(player.getOpenInventory().getItem(i).getType().name().endsWith("STAINED_GLASS_PANE"))) {
					player.getInventory().addItem(new ItemStack(player.getOpenInventory().getItem(i)));
				}
			}
			return;
		} else {
			return;
		}
	}
	@EventHandler
	private void dropPackageOpen(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(player.getInventory().getItemInMainHand() == null
				|| !(player.getInventory().getItemInMainHand().getType().name().endsWith(RandomPackage.getDropPackageConfig().getString("Panes.Item").toUpperCase()))
				|| !(player.getInventory().getItemInMainHand().hasItemMeta()) || !(player.getInventory().getItemInMainHand().getItemMeta().hasDisplayName())
				|| !(player.getInventory().getItemInMainHand().getItemMeta().hasLore())) {
			return;
		} else {
			String dropPackageType = null;
			if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Legendary.Name")))) {
				dropPackageType = "Legendary";
			} else if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Ultimate.Name")))) {
				dropPackageType = "Ultimate";
			} else if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Elite.Name")))) {
				dropPackageType = "Elite";
			} else if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Unique.Name")))) {
				dropPackageType = "Unique";
			} else if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Simple.Name")))) {
				dropPackageType = "Simple";
			} else { return; }
			event.setCancelled(true);
			dropPackage = Bukkit.createInventory(player, 27, ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString(dropPackageType + ".ChestName")));
			for(int i = 0; i <= 26; i++) {
				ArrayList<String> lore = new ArrayList<String>();
				item = new ItemStack(Material.getMaterial(RandomPackage.getDropPackageConfig().getString("Panes.Item").toUpperCase()) , i + 1);
				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getString("Panes.Name")));
				for(int o = 0; o < RandomPackage.getDropPackageConfig().getStringList("Panes.Lore").size(); o++) {
					lore.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getDropPackageConfig().getStringList("Panes.Lore").get(o)));
				}
				itemMeta.setLore(lore);
				item.setItemMeta(itemMeta);
				dropPackage.setItem(i, item);
			}
			player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
			player.openInventory(dropPackage);
			if(player.getInventory().getItemInMainHand().getAmount() > 1) {
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			} else {
				player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
			}
			player.updateInventory();
			return;
		}
	}
}
