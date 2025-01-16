package com.kerbal.ferritemod;

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
    public static Block register(Block block, RegistryKey<Block> blockKey, boolean shouldRegisterItem) {
        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like minecraft:air or minecraft:end_gateway
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());

            BlockItem blockItem = new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    // ITEM GROUPS
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register((itemGroup) -> {
            itemGroup.add(ModBlocks.FERRITE_ORE.asItem());
        });
    }

    // FERRITE ORE
    public static final RegistryKey<Block> FERRITE_ORE_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(FerriteMod.MOD_ID, "ferrite_ore")
    );
    public static final Block FERRITE_ORE = register(
            new Block(AbstractBlock.Settings.create().registryKey(FERRITE_ORE_KEY).sounds(BlockSoundGroup.STONE).requiresTool().strength(3f)),
            FERRITE_ORE_KEY,
            true
    );

}