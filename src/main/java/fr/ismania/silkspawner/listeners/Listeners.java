package fr.ismania.silkspawner.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class Listeners implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		Player p = e.getPlayer();
		Material detruit = e.getBlock().getType();

		if(detruit == Material.MOB_SPAWNER) {
			
			CreatureSpawner spawner = (CreatureSpawner) e.getBlock().getState();
			ItemStack itemInHand = p.getItemInHand();
			
			if(itemInHand == null) return;
			
			if(p.getWorld() == Bukkit.getWorld("ASkyBlock")) {
				
				if(itemInHand.getItemMeta().getDisplayName().equals("§c§lPioche à Spawners") && itemInHand.getItemMeta().getDisplayName() != null) {
					
					if(spawner.getSpawnedType() == EntityType.CHICKEN || spawner.getSpawnedType() == EntityType.VILLAGER || spawner.getSpawnedType() == EntityType.BLAZE || spawner.getSpawnedType() == EntityType.SKELETON || spawner.getSpawnedType() == EntityType.ZOMBIE || spawner.getSpawnedType() == EntityType.CREEPER || spawner.getSpawnedType() == EntityType.PIG || spawner.getSpawnedType() == EntityType.COW || spawner.getSpawnedType() == EntityType.SPIDER || spawner.getSpawnedType() == EntityType.SQUID || spawner.getSpawnedType() == EntityType.RABBIT || spawner.getSpawnedType() == EntityType.SHEEP || spawner.getSpawnedType() == EntityType.SLIME || spawner.getSpawnedType() == EntityType.WITCH || spawner.getSpawnedType() == EntityType.GUARDIAN) {
						
						ItemStack mob_spawner = new ItemStack(Material.MOB_SPAWNER);
						BlockStateMeta mob_spawner_meta = (BlockStateMeta) mob_spawner.getItemMeta();
						
						CreatureSpawner cSpawner = spawner;
						cSpawner.setSpawnedType(spawner.getSpawnedType());
						cSpawner.setCreatureTypeByName(spawner.getCreatureTypeName());
						
						mob_spawner_meta.setBlockState(cSpawner);
						mob_spawner_meta.setDisplayName(cSpawner.getCreatureTypeName() + " Spawner");
						mob_spawner.setItemMeta(mob_spawner_meta);
						
						p.getWorld().dropItem(e.getBlock().getLocation(), mob_spawner);
						
					}

				}

			} else {
				p.sendMessage("§cTu ne peux pas récupérer de spawners dans ce monde !");
				e.setCancelled(true);
			}

		}
		
	}
	
}

