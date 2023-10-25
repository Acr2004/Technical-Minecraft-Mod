package net.acr.technicalminecraft.item;

import net.acr.technicalminecraft.TechnicalMinecraft;
import net.acr.technicalminecraft.item.custom.DiceItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TechnicalMinecraft.MOD_ID);

    public static final RegistryObject<Item> RAW_COPPER = ITEMS.register("raw_copper",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TECHNICAL_TAB)));

    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TECHNICAL_TAB)));

    public static final RegistryObject<Item> DICE = ITEMS.register("dice",
            () -> new DiceItem(new Item.Properties().tab(ModCreativeModeTab.TECHNICAL_TAB).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}