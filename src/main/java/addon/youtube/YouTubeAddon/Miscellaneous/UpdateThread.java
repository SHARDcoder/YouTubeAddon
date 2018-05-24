package addon.youtube.YouTubeAddon.Miscellaneous;

import addon.youtube.YouTubeAddon.ImplementedAddonFiles.SubCountAddon;

public class UpdateThread extends Thread {
    public Overlay overlay;
    public volatile boolean shouldStop = false;
    private int exceptionsInARow = 0;
    public UpdateThread(Overlay overlay) {
        this.overlay = overlay;
    }
    @Override
    public void run() {
        while (!shouldStop) {
            try {
                //Overlay.name = SubCountAddon.INSTANCE.getYoutubeAuth().getName(SubCountAddon.INSTANCE.channelUrl);
                //Overlay.value = SubCountAddon.INSTANCE.getYoutubeAuth().getSubs(SubCountAddon.INSTANCE.channelUrl).toString();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                exceptionsInARow++;
                if (exceptionsInARow >= 10) {
                    System.out.println("[ERROR] Failed 10 times to get the channel information, giving up!");
                    this.shouldStop = true;
                }
            }
        }
    }
}
