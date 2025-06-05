package com.lantern.physics.ItemGroups;

import com.lantern.physics.LanternPhysics;
import com.lantern.physics.block.ModBlocks;
import com.lantern.physics.items.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup DEV_KIT_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LanternPhysics.MOD_ID, "dev_kit_item_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(Items.LANTERN))
                    .displayName(Text.translatable("itemGroup.lanternphysics.dev_kit_item_group"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.WIND_DEBUG_ITEM);
                        entries.add(ModBlocks.RAW_TESTING_BLOCK);
                        entries.add(ModItems.DEV_BLOCK_ITEM);
                        entries.add(ModBlocks.TESTING_BLOCK);
                        entries.add(ModBlocks.NULL);

                    })
                    .build());

    public static void registerItemGroups() {
        LanternPhysics.LOGGER.info("Registering Item Groups for " + LanternPhysics.MOD_ID);
    }
}
