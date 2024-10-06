package com.happyrespawnanchor.resharpedrenderfixpatch.mixin;

import mods.flammpfeil.slashblade.client.renderer.util.BladeRenderState;
import net.minecraft.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static mods.flammpfeil.slashblade.client.renderer.util.BladeRenderState.renderOverrided;

@Mixin(BladeRenderState.class)
public class BladeRenderStateMixin {
    @Inject(at = @At("TAIL"), target = "renderOverrided", remap = false)
    public void renderOverridedMixin(CallbackInfo ci) {
        renderOverrided(stack, model, target, texture, matrixStackIn, bufferIn,
        packedLightIn, Util.memoize(BladeRenderState::getSlashBladeBlend), true);
    }
}
