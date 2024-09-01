package net.tianben.tlsywenextras;

import net.fabricmc.api.ModInitializer;

import net.tianben.tlsywenextras.item.ModItems;
import net.tianben.tlsywenextras.item.group.ModItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class tlsywenextras implements ModInitializer {
	public static final String MOD_ID = "tlsywen-extra";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
	}
}