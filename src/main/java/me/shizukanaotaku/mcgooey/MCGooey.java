package me.shizukanaotaku.mcgooey;

import me.shizukanaotaku.mcgooey.event.EventManager;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MCGooey implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger(MCGooey.class.getSimpleName());
    public static final EventManager EVENT_MANAGER = new EventManager();

    @Override
    public void onInitialize() {
        LOGGER.info("Initialized MCGooey");
    }

}
