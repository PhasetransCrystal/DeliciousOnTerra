package com.phasetranscrystal.deliciousonterra.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.GameRenderer;
import org.jetbrains.annotations.NotNull;

public class ArkTitleScreen extends TitleScreen {
    private static ArkTitleScreen instance;
    private final ShaderInstance SHADER_INSTANCE = GameRenderer.getPositionTexColorShader();

    public ArkTitleScreen() {
        super();
    }

    public static ArkTitleScreen getInstance() {
        if (instance == null) {
            instance = new ArkTitleScreen();
        }
        return instance;
    }

    public static void preLoadResources() {
    }

    @Override
    public void init() {
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        // RenderSystem.setShader(() -> SHADER_INSTANCE);
        this.renderBg(guiGraphics.pose(),mouseX,mouseY,partialTick);
    }


    public void renderBg(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
    }


}

