package me.shizukanaotaku.mcgooey.event.events;

import me.shizukanaotaku.mcgooey.event.Event;
import net.minecraft.client.util.math.MatrixStack;

public class WorldRenderEvent extends Event {

    private final float tickDelta;
    private final long limitTime;
    private final MatrixStack matrices;

    public WorldRenderEvent(float tickDelta, long limitTime, MatrixStack matrices) {
        this.tickDelta = tickDelta;
        this.limitTime = limitTime;
        this.matrices = matrices;
    }

    public float getTickDelta() {
        return tickDelta;
    }

    public long getLimitTime() {
        return limitTime;
    }

    public MatrixStack getMatrices() {
        return matrices;
    }
}
