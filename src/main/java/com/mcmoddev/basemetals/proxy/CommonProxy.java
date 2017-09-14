package com.mcmoddev.basemetals.proxy;

import com.mcmoddev.basemetals.init.*;
import com.mcmoddev.basemetals.util.Config;
import com.mcmoddev.basemetals.util.EventHandler;
import com.mcmoddev.lib.fuels.FuelRegistry;
import com.mcmoddev.lib.integration.IntegrationManager;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Base Metals Common Proxy
 *
 * @author Jasmine Iwanek
 *
 */
public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {

		Config.init();

		Materials.init();
		FuelRegistry.init();
		Fluids.init();
		ItemGroups.init();
		Blocks.init();
		Items.init();

		// icons have to be setup after the blocks and items are initialized
		ItemGroups.setupIcons();
		VillagerTrades.init();

		IntegrationManager.INSTANCE.preInit(event);
		IntegrationManager.INSTANCE.runCallbacks("preInit");
	}

/*	public void onRemap(FMLMissingMappingsEvent event) {
		for (final MissingMapping mapping : event.get()) {
			if (mapping.resourceLocation.getResourceDomain().equals(BaseMetals.MODID)) {
				if (mapping.type.equals(GameRegistry.Type.BLOCK)) {
					if ((Options.isMaterialEnabled(MaterialNames.MERCURY)) && ("liquid_mercury".equals(mapping.resourceLocation.getResourcePath()))) {
						mapping.remap(Materials.getMaterialByName(MaterialNames.MERCURY).getFluidBlock());
					}
				} else if (mapping.type.equals(GameRegistry.Type.ITEM)) {
					if ((Options.isMaterialEnabled(MaterialNames.COAL)) && ("carbon_powder".equals(mapping.resourceLocation.getResourcePath()))) {
						mapping.remap(Materials.getMaterialByName(MaterialNames.COAL).getItem(Names.POWDER));
					}
				}
			}
		}
	}*/

	public void init(FMLInitializationEvent event) {
		Recipes.init();

//		Achievements.init();
		FuelRegistry.register();
		IntegrationManager.INSTANCE.runCallbacks("init");
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}

	public void postInit(FMLPostInitializationEvent event) {
		IntegrationManager.INSTANCE.runCallbacks("postInit");
		Config.postInit();
	}
}
