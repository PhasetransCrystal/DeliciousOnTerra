package com.phasetranscrystal.deliciousonterra.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.phasetranscrystal.deliciousonterra.DeliciousOnTerra;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ArcaneWorkBenchScreen extends Screen {
    public static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(DeliciousOnTerra.MODID, "textures/gui/dice_screen.png");

    public ArcaneWorkBenchScreen(Component component) {
        super(component);
    }



    protected void renderBg(@NotNull GuiGraphics graphics, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        int x = (this.width - 256) / 2;
        int y = (this.height - 256) / 2;
        graphics.blit(TEXTURE, x, y, 0, 0, 256, 256);
        RenderSystem.disableBlend();
        RenderSystem.disableDepthTest();
    }
    @Override
    public void render(@NotNull GuiGraphics context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        this.renderBg(context,delta,mouseX,mouseY);
    }

}
