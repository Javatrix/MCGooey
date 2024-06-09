package me.shizukanaotaku.mcgooey.event;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static me.shizukanaotaku.mcgooey.MCGooey.LOGGER;

public class EventManager {

    private final List<EventListener> listeners = new ArrayList<>();

    public void register(EventListener listener) {
        listeners.add(listener);
    }

    public void unregister(EventListener listener) {
        listeners.remove(listener);
    }

    public void fireEvent(Event event) {
        for (EventListener listener : listeners) {
            if (listener.isInterestedIn(event)) {
                tryToPassEvent(event, listener);
            }
        }
    }

    private static void tryToPassEvent(Event event, EventListener listener) {
        Method handler = null;
        try {
            handler = getHandlerMethod(event, listener);
            if (handler != null) {
                handler.invoke(listener, event);
            }
        } catch (InvocationTargetException ignored) {
        } catch (IllegalAccessException e) {
            LOGGER.warn(String.format("Event handling method has to be public and marked with @EventHandler annotation. Problematic method: %s in event listener %s.", handler, listener.getClass().getSimpleName()));
            throw new RuntimeException(e);
        }
    }

    /**
     * Used to retrieve the correct method to handle the event.
     *
     * @param event    The event to handle
     * @param listener The listener that tries to handle the event
     * @return Method that should be invoked to notify the listener of the event, or null if such method does not exist.
     */
    private static @Nullable Method getHandlerMethod(Event event, EventListener listener) {
        Method handler;
        try {
            handler = listener.getClass().getDeclaredMethod("on" + event.getClass().getSimpleName(), event.getClass());
        } catch (NoSuchMethodException e) {
            return null;
        }
        if (handler.isAnnotationPresent(EventHandler.class)) {
            return handler;
        } else {
            return null;
        }
    }

}
