package me.sponge.babelplugin;

import java.util.logging.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = "BabelPlugin", name = "Towerbuild to Babel", version = "0.0.1")
public class BabelPlugin {

    Logger logger;

    @SpongeEventHandler
    public void onConstruction(PreInitializationEvent event) {
        logger.info("Server is starting the first time!");
    }

    @SpongeEventHandler
    public void onServerStarting(ServerStartingEvent event) {
        logger.info("Server is starting ...");
    }

    @SpongeEventHandler
    public void onServerStopping(ServerStoppingEvent event) {
        logger.info("Server is stopping ...");
    }

}
