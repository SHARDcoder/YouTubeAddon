package addon.youtube.YouTubeAddon.ImplementedAddonFiles;

import addon.youtube.YouTubeAddon.Commands.SelloutCommand;
import cc.hyperium.Hyperium;
import cc.hyperium.event.InitializationEvent;

public class SelloutAddon {
    public static String channelName = "thePlayer.getName()";

    public static String getChannelName() {
        return channelName;
    }

    public static void callLoad () {
        System.out.println("[YouTubeAddon] Sellout loaded");
    }

    public static void callInit (InitializationEvent event) {
        Hyperium.INSTANCE.getHandlers().getHyperiumCommandHandler().registerCommand(new SelloutCommand());
    }

    public static void callClose () {
        System.out.println("[YouTubeAddon] Sellout closed");
    }
}
