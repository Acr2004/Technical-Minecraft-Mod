package net.acr.technicalminecraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TECHNICAL_TAB = new CreativeModeTab("technicaltab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.COPPER_INGOT.get());
        }
    };
}