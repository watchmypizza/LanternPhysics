package com.lantern.physics.block;

import com.lantern.physics.LanternPhysics;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block TESTING_BLOCK = registerBlock("testing_block",
            AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK));

    public static final Block RAW_TESTING_BLOCK = registerBlock("raw_testing_block",
            AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE));

    public static final Block NULL = registerBlock("null",
            AbstractBlock.Settings.create()
                    .strength(50f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.SCULK_CATALYST));

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LanternPhysics.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(blockKey));
        Registry.register(Registries.BLOCK, blockKey, block);
        registerBlockItem(name, block);

        return block;
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LanternPhysics.MOD_ID, name));
        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, blockItem);
    }

    public static void registerModBlocks() {
        LanternPhysics.LOGGER.info("Registering ModBlocks for " + LanternPhysics.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.TESTING_BLOCK);
            entries.add(ModBlocks.RAW_TESTING_BLOCK);
            entries.add(ModBlocks.NULL);
        });
    }
}