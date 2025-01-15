package com.kerbal.ferritemod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModItems {
    private static final Logger log = LoggerFactory.getLogger(ModItems.class);

    // CONSTRUCTOR
    public static Item register(Item item, RegistryKey<Item> registryKey) {
        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

        // Return the registered item!
        return registeredItem;
    }

    // ITEM GROUPS
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.FERRITE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.RAW_FERRITE_FRAGMENT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.FERRITE_FRAGMENT));
    }

    // FERRITE
    public static final RegistryKey<Item> FERRITE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FerriteMod.MOD_ID, "ferrite"));
    public static final Item FERRITE = register(
            new Item(new Item.Settings().registryKey(FERRITE_KEY)),
            FERRITE_KEY
    );

    // RAW FERRITE FRAGMENT
    public static final RegistryKey<Item> RAW_FERRITE_FRAGMENT_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FerriteMod.MOD_ID, "raw_ferrite_fragment"));
    public static final Item RAW_FERRITE_FRAGMENT = register(
            new Item(new Item.Settings().registryKey(RAW_FERRITE_FRAGMENT_KEY)),
            RAW_FERRITE_FRAGMENT_KEY
    );

    // FERRITE FRAGMENT
    public static final RegistryKey<Item> FERRITE_FRAGMENT_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FerriteMod.MOD_ID, "ferrite_fragment"));
    public static final Item FERRITE_FRAGMENT = register(
            new Item(new Item.Settings().registryKey(FERRITE_FRAGMENT_KEY).maxCount(16)),
            FERRITE_FRAGMENT_KEY
    );

}
