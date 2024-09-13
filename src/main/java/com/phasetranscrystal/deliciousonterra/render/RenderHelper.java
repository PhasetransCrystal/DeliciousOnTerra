//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.phasetranscrystal.deliciousonterra.render;


import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import java.util.List;
import java.util.Random;

import com.phasetranscrystal.deliciousonterra.cursed.DummyClientWorld;
import com.phasetranscrystal.deliciousonterra.entity.EntityRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import org.joml.Quaternionf;

public class RenderHelper {
    private static final Random RANDOM = new Random();
    public static LivingEntity livingEntity = null;
    public static boolean foxRotate = false;
    public static boolean isNeoForge = false;
    private static final List<? extends EntityType<?>> ALLOW_ENTITIES;

    public RenderHelper() {
    }

    public static void endClientTick() {
        if (livingEntity == null) {
            Entity entity = ((EntityType)ALLOW_ENTITIES.get(RANDOM.nextInt(ALLOW_ENTITIES.size()))).create(DummyClientWorld.getInstance());
            if (entity instanceof LivingEntity) {
                livingEntity = (LivingEntity)entity;
            }
        }

        if (!(Minecraft.getInstance().screen instanceof TitleScreen)) {
            foxRotate = false;
        }

    }

    public static void renderEntity(PoseStack matrices, int x, int y, int size, float mouseX, float mouseY, LivingEntity entity, float scale) {
        float f = (float)Math.atan((double)(mouseX / 40.0F));
        float g = (float)Math.atan((double)(mouseY / 40.0F));
        matrices.pushPose();
        matrices.translate((float)x, (float)y, 1050.0F);
        matrices.scale(1.0F, 1.0F, -1.0F);
        matrices.translate(0.0, 0.0, 1000.0);
        matrices.scale((float)size, (float)size, (float)size);
        Quaternionf quaternion = Axis.ZP.rotationDegrees(180.0F);
        Quaternionf quaternion2 = Axis.XP.rotationDegrees(g * 20.0F);
        quaternion.mul(quaternion2);
        if (foxRotate && isNeoForge) {
            Quaternionf quaternion3 = Axis.XP.rotationDegrees(-20.0F);
            Quaternionf quaternion4 = Axis.YP.rotationDegrees((float)System.nanoTime() / 1000000.0F);
            quaternion.mul(quaternion3);
            quaternion.mul(quaternion4);
        }

        matrices.mulPose(quaternion);
        float h = entity.yBodyRot;
        float i = entity.getYRot();
        float j = entity.getXRot();
        float k = entity.yHeadRotO;
        float l = entity.yHeadRot;
        if (!foxRotate || !isNeoForge) {
            entity.yBodyRot = 180.0F + f * 20.0F;
            entity.setYRot(180.0F + f * 40.0F);
            entity.setXRot(-g * 20.0F);
            entity.yHeadRot = entity.getYRot();
            entity.yHeadRotO = entity.getYRot();
        }

        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        quaternion2.conjugate();
        entityRenderDispatcher.overrideCameraOrientation(quaternion2);
        entityRenderDispatcher.setRenderShadow(false);
        MultiBufferSource.BufferSource immediate = Minecraft.getInstance().renderBuffers().bufferSource();
        RenderSystem.runAsFancy(() -> {
            double width = entity.getBoundingBox().getXsize();
            double height = entity.getBoundingBox().getYsize();
            if (width > 0.6) {
                width *= (double)(1.0F / ((float)width / 0.6F));
                height = entity.getBoundingBox().getYsize() * (width / entity.getBoundingBox().getXsize());
            }

            if (height > 2.0) {
                width *= 1.0 / (height / 2.0);
            }

            matrices.scale((float)(width / entity.getBoundingBox().getXsize()), (float)(width / entity.getBoundingBox().getXsize()), (float)(width / entity.getBoundingBox().getXsize()));
            matrices.pushPose();
            matrices.scale(scale, scale, scale);
            entityRenderDispatcher.render(entity, 0.0, 0.0, 0.0, 0.0F, 1.0F, matrices, immediate, 15728880);
            matrices.popPose();
        });
        immediate.endBatch();
        entityRenderDispatcher.setRenderShadow(true);
        entity.yBodyRot = h;
        entity.setYRot(i);
        entity.setXRot(j);
        entity.yHeadRotO = k;
        entity.yHeadRot = l;
        matrices.popPose();
    }
    static {
        ALLOW_ENTITIES = List.of(EntityRegister.ORIGINIUM_SLUG.get());
    }
}
