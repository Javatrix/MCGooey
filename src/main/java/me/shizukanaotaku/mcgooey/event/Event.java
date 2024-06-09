package me.shizukanaotaku.mcgooey.event;

import me.shizukanaotaku.mcgooey.MCGooey;

public abstract class Event {

    private boolean cancelled;

    public void fire() {
        MCGooey.EVENT_MANAGER.fireEvent(this);
    }

    public void cancel() {
        cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }

}
