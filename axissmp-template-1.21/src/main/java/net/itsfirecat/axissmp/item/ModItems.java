package net.itsfirecat.axissmp.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.itsfirecat.axissmp.AxisSMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FREEZE_SHARD = registerItem("freeze_shard", new Item(new Item.Settings()));
    public static final Item FREEZE_ARTIFACT = registerItem("freeze_artifact", new Item(new Item.Settings()));
    public static final Item FREEZE_ARC = registerItem("freeze_arc", new Item(new Item.Settings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AxisSMP.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AxisSMP.LOGGER.info("Registering Mod Items for " + AxisSMP.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FREEZE_SHARD);
            entries.add(FREEZE_ARTIFACT);
            entries.add(FREEZE_ARC);
        });
    }
}
