package com.lantern.physics;

import com.lantern.physics.ItemGroups.ModItemGroups;
import com.lantern.physics.block.ModBlocks;
import com.lantern.physics.items.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Initialize the Mod on this stage

public class LanternPhysics implements ModInitializer {
    public static final String MOD_ID = "lanternphysics";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItem();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
    }
}