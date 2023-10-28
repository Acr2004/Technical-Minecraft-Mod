package net.acr.technicalminecraft.world.feature;

import net.acr.technicalminecraft.TechnicalMinecraft;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, TechnicalMinecraft.MOD_ID);



    public static final RegistryObject<PlacedFeature> COPPER_ORE_PLACED = PLACED_FEATURES.register("copper_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.COPPER_ORE.getHolder().get(), commonOrePlacement(7,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_COPPER_ORE_PLACED = PLACED_FEATURES.register("nether_copper_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_COPPER_ORE.getHolder().get(), commonOrePlacement(7,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> END_COPPER_ORE_PLACED = PLACED_FEATURES.register("end_copper_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.END_COPPER_ORE.getHolder().get(), commonOrePlacement(7,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));



    public static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier modifier1) {
        return List.of(modifier, InSquarePlacement.spread(), modifier1, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int i, PlacementModifier modifier) {
        return orePlacement(CountPlacement.of(i), modifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int i, PlacementModifier modifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(i), modifier);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}