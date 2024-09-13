package com.phasetranscrystal.deliciousonterra.mixin;

import com.phasetranscrystal.deliciousonterra.cursed.DummyClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({LivingEntityRenderer.class})
public class MixinLivingEntityRenderer<T extends LivingEntity> {
    public MixinLivingEntityRenderer() {
    }

    @Inject(
            method = {"shouldShowName(Lnet/minecraft/world/entity/LivingEntity;)Z"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void handleLabel(T livingEntity, CallbackInfoReturnable<Boolean> cir) {
        if (livingEntity instanceof DummyClientPlayerEntity || Minecraft.getInstance().screen instanceof TitleScreen) {
            cir.setReturnValue(false);
        }

    }
}
