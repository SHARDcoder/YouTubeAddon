package addon.youtube.YouTubeAddon;

import addon.youtube.YouTubeAddon.Commands.YouTubeCommand;
import addon.youtube.YouTubeAddon.ImplementedAddonFiles.SelloutAddon;
import addon.youtube.YouTubeAddon.ImplementedAddonFiles.SubCountAddon;
import addon.youtube.YouTubeAddon.ImplementedAddonFiles.ViewCountAddon;
import cc.hyperium.Hyperium;
import cc.hyperium.event.EventBus;
import cc.hyperium.event.InitializationEvent;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.internal.addons.IAddon;

public class YouTubeAddon implements IAddon {
    @Override
    public void onLoad() {
        System.out.println("[YouTubeAddon] Addon loaded");
        EventBus.INSTANCE.register(this);
        SubCountAddon.callLoad();
        SelloutAddon.callLoad();
        ViewCountAddon.callLoad();
    }

    @InvokeEvent
    public void init(InitializationEvent event) {
        Hyperium.INSTANCE.getHandlers().getHyperiumCommandHandler().registerCommand(new YouTubeCommand());
        SubCountAddon.callInit(event);
        SelloutAddon.callInit(event);
        ViewCountAddon.callInit(event);
    }

    @Override
    public void onClose() {
        System.out.println("[YouTubeAddon] Addon closed");
        SubCountAddon.callClose();
        SelloutAddon.callClose();
        ViewCountAddon.callClose();
    }

    @Override
    public void sendDebugInfo() {
    }
}
