package net.itsfirecat.axissmp;

import net.fabricmc.api.ModInitializer;

import net.itsfirecat.axissmp.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AxisSMP implements ModInitializer {
	public static final String MOD_ID = "axissmp";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}