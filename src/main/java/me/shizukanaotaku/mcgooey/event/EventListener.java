package me.shizukanaotaku.mcgooey.event;

import java.lang.reflect.Method;

public interface EventListener {    
    
    default boolean isInterestedIn(Event event) {
        for (Method method : getClass().getDeclaredMethods()) {
            if (isEventHandler(method, event)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEventHandler(Method method, Event event) {
        return method.isAnnotationPresent(EventHandler.class) && method.getParameterCount() == 1 && method.getParameters()[0].getType() == event.getClass();
    }

}
