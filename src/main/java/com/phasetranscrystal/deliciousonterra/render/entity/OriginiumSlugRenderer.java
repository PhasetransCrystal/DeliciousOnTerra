package com.phasetranscrystal.deliciousonterra.render.entity;

import com.phasetranscrystal.deliciousonterra.entity.OriginiumSlug;
import com.phasetranscrystal.deliciousonterra.render.model.DOTGeoModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class OriginiumSlugRenderer extends GeoEntityRenderer<OriginiumSlug> {
    public OriginiumSlugRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DOTGeoModel<>("originium_slug","entity"));
    }

}
