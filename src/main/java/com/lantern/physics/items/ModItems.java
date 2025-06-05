package com.lantern.physics.items;

import com.lantern.physics.LanternPhysics;
import com.lantern.physics.items.custom.WindDebuggerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Identifier id = Identifier.of(LanternPhysics.MOD_ID, "wind_debug_item");
    public static RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
    public static Item WIND_DEBUG_ITEM = registerItem("wind_debug_item", new WindDebuggerItem(new Item.Settings().registryKey(key)));
    public static Identifier id2 = Identifier.of(LanternPhysics.MOD_ID, "dev_block_item");
    public static RegistryKey<Item> key2 = RegistryKey.of(RegistryKeys.ITEM, id2);

    public static Item DEV_BLOCK_ITEM = registerItem("dev_block_item", new Item(new Item.Settings().registryKey(key2)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LanternPhysics.MOD_ID, name), item);
    }

    public static void registerModItem() {
        LanternPhysics.LOGGER.info("Registering Mod Items for " + LanternPhysics.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(WIND_DEBUG_ITEM);
            entries.add(DEV_BLOCK_ITEM);
        });
    }
}
