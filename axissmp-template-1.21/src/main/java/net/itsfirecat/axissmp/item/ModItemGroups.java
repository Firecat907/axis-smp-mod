package net.itsfirecat.axissmp.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.itsfirecat.axissmp.AxisSMP;
import net.itsfirecat.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup AXIS_SMP_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AxisSMP.MOD_ID, "axis_smp_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.FREEZE_ARC))
                    .displayName(Text.translatable("itemgroup.axissmp.axis_smp_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.FREEZE_SHARD);
                        entries.add(ModItems.FREEZE_ARTIFACT);
                        entries.add(ModItems.FREEZE_ARC);
                        entries.add(ModItems.DASH_SHARD);
                        entries.add(ModItems.DASH_ARTIFACT);
                        entries.add(ModItems.DASH_ARC);
                        entries.add(ModItems.PULSE_ARTIFACT);
                        entries.add(ModItems.PULSE_ARC);
                        entries.add(ModItems.INFINITY_ARTIFACT);
                        entries.add(ModItems.INFINITY_ARC);
                        entries.add(ModBlocks.RECALL_ANCHOR);

                    }).build());

    public static void registerItemGroups() {
        AxisSMP.LOGGER.info("Registering Item Groups for " + AxisSMP.MOD_ID);
    }
}
