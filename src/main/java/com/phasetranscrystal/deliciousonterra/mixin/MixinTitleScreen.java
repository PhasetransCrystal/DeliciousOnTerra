package com.phasetranscrystal.deliciousonterra.mixin;

import com.phasetranscrystal.deliciousonterra.render.RenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({TitleScreen.class})
public class MixinTitleScreen {
    public MixinTitleScreen() {
    }

    @Inject(
            method = {"<init>()V"},
            at = {@At("RETURN")}
    )
    private void mobsMainMenu_resetEntity(CallbackInfo ci) {
        RenderHelper.livingEntity = null;
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/gui/GuiGraphics;IIF)V"},
            at = {@At("RETURN")}
    )
    private void mobsMainMenu_render(GuiGraphics context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        TitleScreen sc = (TitleScreen) (Object)this;
        if (Minecraft.getInstance() != null) {
            int entityX = sc.width / 2 + 160;
            int height = sc.height / 4 + 132;
            LivingEntity livingEntity = RenderHelper.livingEntity;

            if (livingEntity != null) {
                RenderHelper.renderEntity(context.pose(), entityX , height, 30, (float)(-mouseX + entityX), (float)(-mouseY + height - 30), livingEntity, 1);
/*
                try {
                    RenderHelper.renderEntity(context.pose(), entityX , height, 30, (float)(-mouseX + entityX), (float)(-mouseY + height - 30), livingEntity, 1);
                } catch (Exception var14) {
                    RenderHelper.livingEntity = null;
                    RenderHelper.foxRotate = false;
                }*/
            }
        }

    }

    @Inject(
            method = {"mouseClicked(DDI)Z"},
            at = {@At("RETURN")}
    )
    private void handleFoxClick(double mouseX, double mouseY, int button, CallbackInfoReturnable<Boolean> cir) {
        TitleScreen sc = (TitleScreen) (Object)this;
        if (Minecraft.getInstance() != null) {
            int height = sc.height / 4 + 132;
            int entityX = sc.width / 2 + 160;
            if (mouseX >= (double)(entityX - 10) && mouseY >= (double)(height - 20) && mouseX <= (double)(entityX + 10) && mouseY <= (double)height) {
                RenderHelper.foxRotate = true;
            }
        }

    }
}
