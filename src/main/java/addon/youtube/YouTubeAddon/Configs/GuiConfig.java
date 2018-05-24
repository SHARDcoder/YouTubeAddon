package addon.youtube.YouTubeAddon.Configs;

import addon.youtube.YouTubeAddon.ImplementedAddonFiles.SubCountAddon;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class GuiConfig extends GuiScreen {
    private boolean dragging;
    private int lastMouseX;
    private int lastMouseY;
    private int lastAddX;
    private int lastAddY;

    private GuiTextField urlField;

    @Override
    public void initGui() {
    }

    @Override
    protected void actionPerformed(GuiButton button) {

    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        if (state == 0) {
            this.dragging = false;
        }
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int lastButtonClicked, long timeSinceMouseClick) {
        /*if (!this.dragging && mouseX > SubCountAddon.INSTANCE.overlay.x && mouseX < SubCountAddon.INSTANCE.overlay.x + SubCountAddon.INSTANCE.overlay.getWidth() && mouseY > SubCountAddon.INSTANCE.overlay.y && mouseY < SubCountAddon.INSTANCE.overlay.y + SubCountAddon.INSTANCE.overlay.getHeight()) {
            this.dragging = true;
            this.lastMouseX = mouseX;
            this.lastMouseY = mouseY;
            this.lastAddX = SubCountAddon.INSTANCE.overlay.x;
            this.lastAddY = SubCountAddon.INSTANCE.overlay.y;
        }
        else if (this.dragging) {
            SubCountAddon.INSTANCE.overlay.x = this.lastAddX + (mouseX - this.lastMouseX);
            SubCountAddon.INSTANCE.overlay.y = this.lastAddY + (mouseY - this.lastMouseY);
        }*/
    }
}
