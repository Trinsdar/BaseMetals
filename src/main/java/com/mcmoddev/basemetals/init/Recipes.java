package com.mcmoddev.basemetals.init;

import com.mcmoddev.basemetals.data.MaterialNames;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.Oredicts;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

/**
 *
 * @author Jasmine Iwanek
 *
 */
public class Recipes extends com.mcmoddev.lib.init.Recipes {

	private Recipes() {
		throw new IllegalAccessError(SharedStrings.NOT_INSTANTIABLE);
	}

	/**
	 *
	 */
	public static void init() {
		initVanillaRecipes();
		initModSpecificRecipes();
	}

	protected static void initVanillaRecipes() {
		// all recipes for BaseMetals are currently in JSON - this exists in case there
		// are some we have to add
		// programmatically
	}

	private static void initModSpecificRecipes() {
		if (Materials.hasMaterial(MaterialNames.ADAMANTINE)) {
			final MMDMaterial adamantine = Materials.getMaterialByName(MaterialNames.ADAMANTINE);

			addAdditionalOredicts(adamantine, "Adamantite");
			addAdditionalOredicts(adamantine, "Adamantium");
			addAdditionalOredicts(adamantine, "Adamant");
		}

		if (Materials.hasMaterial(MaterialNames.STEEL)) {
			final MMDMaterial steel = Materials.getMaterialByName(MaterialNames.STEEL);

			if (steel.hasItem(Names.GEAR)) {
				OreDictionary.registerOre(Oredicts.SPROCKET, steel.getItemStack(Names.GEAR));
			}
		}
	}

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		register(event);
	}
}
