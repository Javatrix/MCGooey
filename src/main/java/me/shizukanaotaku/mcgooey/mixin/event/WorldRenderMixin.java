package me.shizukanaotaku.mcgooey.mixin.event;

import me.shizukanaotaku.mcgooey.event.Event;
import me.shizukanaotaku.mcgooey.event.events.WorldRenderEvent;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class WorldRenderMixin {

    @Inject(method = "renderWorld", at = @At("HEAD"), cancellable = true)
    public void worldRender(float tickDelta, long limitTime, MatrixStack matrices, CallbackInfo ci) {
        Event e = new WorldRenderEvent(tickDelta, limitTime, matrices);
        e.fire();
        if (e.isCancelled()) ci.cancel();
    }

}
