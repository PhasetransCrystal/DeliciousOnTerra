//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.phasetranscrystal.deliciousonterra.cursed;

import java.util.OptionalLong;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

public class DummyClientWorld extends ClientLevel {
    private static DummyClientWorld instance;

    public static DummyClientWorld getInstance() {
        if (instance == null) {
            instance = new DummyClientWorld();
        }

        return instance;
    }

    private DummyClientWorld() {
        super(DummyClientPlayNetworkHandler.getInstance(), new ClientLevel.ClientLevelData(Difficulty.EASY, false, true), ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath("title_screen_mobs", "dummy")), new CursedRegistryEntry(DummyClientWorld.DummyDimensionType.getInstance(), Registries.DIMENSION_TYPE), 0, 0, () -> {
            return Minecraft.getInstance().getProfiler();
        }, Minecraft.getInstance().levelRenderer, false, 0L);
    }

    public RegistryAccess registryAccess() {
        return super.registryAccess();
    }

    public static class DummyDimensionType {
        private static DimensionType instance;

        public DummyDimensionType() {
        }

        public static DimensionType getInstance() {
            if (instance == null) {
                instance = new DimensionType(OptionalLong.empty(), true, false, false, false, 1.0, false, false, 16, 32, 0, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 1.0F, new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 0), 0));
            }

            return instance;
        }
    }
}
