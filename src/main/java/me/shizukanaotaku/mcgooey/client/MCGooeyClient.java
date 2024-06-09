package me.shizukanaotaku.mcgooey.client;

import net.fabricmc.api.ClientModInitializer;

import static me.shizukanaotaku.mcgooey.MCGooey.LOGGER;

public class MCGooeyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        LOGGER.info("MCGooey client initialized.");
    }

}
