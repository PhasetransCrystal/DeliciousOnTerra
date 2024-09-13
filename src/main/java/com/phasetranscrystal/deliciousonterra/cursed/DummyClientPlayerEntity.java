//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.phasetranscrystal.deliciousonterra.cursed;

import java.util.UUID;
import java.util.function.Function;

import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.StatsCounter;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class DummyClientPlayerEntity extends LocalPlayer {
    private static DummyClientPlayerEntity instance;
    private PlayerSkin skinTextures = null;
    public Function<EquipmentSlot, ItemStack> equippedStackSupplier = (slot) -> {
        return ItemStack.EMPTY;
    };

    public static DummyClientPlayerEntity getInstance() {
        if (instance == null) {
            instance = new DummyClientPlayerEntity();
        }

        return instance;
    }

    private DummyClientPlayerEntity() {
        super(Minecraft.getInstance(), DummyClientWorld.getInstance(), DummyClientPlayNetworkHandler.getInstance(), (StatsCounter)null, (ClientRecipeBook)null, false, false);
        this.setUUID(UUID.randomUUID());
        Minecraft.getInstance().getSkinManager().getOrLoad(this.getGameProfile()).thenAccept((textures) -> {
            this.skinTextures = textures;
        });
    }

    public boolean isModelPartShown(PlayerModelPart modelPart) {
        return true;
    }

    public PlayerSkin getSkin() {
        return this.skinTextures == null ? DefaultPlayerSkin.get(this.getUUID()) : this.skinTextures;
    }

    protected @Nullable PlayerInfo getPlayerInfo() {
        return null;
    }

    public boolean isSpectator() {
        return false;
    }

    public boolean isCreative() {
        return true;
    }

    public ItemStack getItemBySlot(EquipmentSlot slot) {
        return (ItemStack)this.equippedStackSupplier.apply(slot);
    }

    public Component getName() {
        return super.getName();
    }
}
