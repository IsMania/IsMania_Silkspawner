package fr.ismania.silkspawner;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import fr.ismania.silkspawner.listeners.Listeners;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		getLogger().info("Plugin démarré !");

		//Enregistrement de l'event
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
	}

	public void onDisable() {

		getLogger().info("Plugin arrêté !");

	}

}
