package com.lantern.physics.items;

import com.lantern.physics.LanternPhysics;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LanternPhysics.MOD_ID, name), item);
    }

    public static Identifier id = Identifier.of(LanternPhysics.MOD_ID, "wind_debug_item");
    public static RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

    public static Item WIND_DEBUG_ITEM = registerItem("wind_debug_item", new Item(new Item.Settings().registryKey(key)));

    public static void registerModItem() {
        //Identifier id = Identifier.of("lanternphysics", "wind_debug_item");
        //RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        // Item.Settings settings = new Item.Settings()
        //        .registryKey(key);

        // Registry.register(Registries.ITEM, key, new Item(settings));

        LanternPhysics.LOGGER.info("Registering Mod Items for " + LanternPhysics.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(WIND_DEBUG_ITEM);
        });
    }
}
