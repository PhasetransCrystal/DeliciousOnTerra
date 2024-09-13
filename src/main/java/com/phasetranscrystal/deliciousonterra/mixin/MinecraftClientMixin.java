package com.phasetranscrystal.deliciousonterra.mixin;

import com.phasetranscrystal.deliciousonterra.render.RenderHelper;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Minecraft.class})
public class MinecraftClientMixin {
    public MinecraftClientMixin() {
    }

    @Inject(
            method = {"tick()V"},
            at = {@At("TAIL")}
    )
    private void endTick(CallbackInfo ci) {
        RenderHelper.endClientTick();
    }
}
