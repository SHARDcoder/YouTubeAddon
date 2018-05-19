package net.youtubeaddon.SubscriberCountAddon;

import cc.hyperium.Hyperium;
import cc.hyperium.event.*;
import cc.hyperium.internal.addons.IAddon;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SubCountAddon implements IAddon {
    // The current instance of SubCountAddon
    public static SubCountAddon INSTANCE;
    // The logger for this addon
    public static final Logger LOGGER = LogManager.getLogger("SubCountAddon");
    // The YouTube authentication object
    private YoutubeAuthentication youtubeAuth;

    public String channelUrl = "https://www.youtube.com/user/PewDiePie";

    public YoutubeAuthentication getYoutubeAuth() {
        return youtubeAuth;
    }

    public void setYoutubeAuth(YoutubeAuthentication youtubeAuth) {
        this.youtubeAuth = youtubeAuth;
    }

    public Overlay overlay;

    @Override
    public void onLoad() {
        INSTANCE = this;
        LOGGER.info("Initializing YouTube API");
        youtubeAuth = new YoutubeAuthentication();
        EventBus.INSTANCE.register(this);
        EventBus.INSTANCE.register(overlay = new Overlay());
    }

    @InvokeEvent
    public void init(InitializationEvent e) {
        LOGGER.info("Registering commands");
        Hyperium.INSTANCE.getHandlers().getHyperiumCommandHandler().registerCommand(new TestCommand());
        LOGGER.info("Successfully initialized SubCountAddon!");
    }

    @Override
    public void onClose() {
        overlay.close();
        LOGGER.info("SubCountAddon has been shut down.");
    }

    @Override
    public void sendDebugInfo() {

    }
}