package addon.youtube.YouTubeAddon.ImplementedAddonFiles;

import addon.youtube.YouTubeAddon.Miscellaneous.Overlay;
import addon.youtube.YouTubeAddon.Miscellaneous.YouTubeAuthentication;
import addon.youtube.YouTubeAddon.Commands.TestCommand;
import cc.hyperium.Hyperium;
import cc.hyperium.event.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SubCountAddon{
    // The current instance of SubCountAddon
    public static SubCountAddon INSTANCE;
    // The logger for this addon
    public static final Logger LOGGER = LogManager.getLogger("SubCountAddon");
    // The YouTube authentication object
    private static YouTubeAuthentication youtubeAuth;

    public String channelUrl = "https://www.youtube.com/user/PewDiePie";

    public YouTubeAuthentication getYoutubeAuth() {
        return youtubeAuth;
    }

    public void setYoutubeAuth(YouTubeAuthentication youtubeAuth) {
        this.youtubeAuth = youtubeAuth;
    }

    public static Overlay overlay;

    public static void callLoad() {
        LOGGER.info("Initializing YouTube API");
        youtubeAuth = new YouTubeAuthentication();
        EventBus.INSTANCE.register(overlay = new Overlay());
    }

    public static void callInit(InitializationEvent e) {
        LOGGER.info("Registering commands");
        Hyperium.INSTANCE.getHandlers().getHyperiumCommandHandler().registerCommand(new TestCommand());
        LOGGER.info("Successfully initialized SubCountAddon!");
    }

    public static void callClose() {
        //overlay.close();
        LOGGER.info("SubCountAddon has been shut down.");
    }
}