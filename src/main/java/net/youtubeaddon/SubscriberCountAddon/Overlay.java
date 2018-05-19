package net.youtubeaddon.SubscriberCountAddon;

import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.RenderHUDEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

import java.awt.*;

public class Overlay {
    public static volatile String value = "0";
    public static volatile String name = "Error";
    public int x;
    public int y;
    public Color backColor = new Color(255, 255, 255, 255 / 4 * 3);
    public Color textColor = Color.BLACK;
    private UpdateThread thread;
    private String valueType = "subscribers";
    public Overlay() {
        thread = new UpdateThread(this);
        thread.start();
    }
    public void close() {
        thread.shouldStop = true;
    }
    @InvokeEvent
    public void onRender(RenderHUDEvent event) {
        FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
        int maxX = x + getWidth();
        int maxY = y + getHeight();
        Gui.drawRect(x, y, maxX, maxY, backColor.getRGB());
        drawString(fr, name, getNameX(), getNameY(), textColor.getRGB());
        drawString(fr, SubCountAddon.INSTANCE.channelUrl, getUrlX(), getUrlY(), textColor.getRGB());
        drawString(fr, value + " " + valueType, getSubX(), getSubY(), textColor.getRGB());
    }

    private void drawString(FontRenderer fr, String name, int x, int y, int color) {
        fr.drawString(name, x, y, color);
    }

    public int getWidth() {
        int width = 5;
        int subStringWidth = Minecraft.getMinecraft().fontRendererObj.getStringWidth(value + " " + valueType);
        int nameStringWidth = Minecraft.getMinecraft().fontRendererObj.getStringWidth(name);
        int urlStringWidth = Minecraft.getMinecraft().fontRendererObj.getStringWidth(SubCountAddon.INSTANCE.channelUrl);
        if (subStringWidth > nameStringWidth) {
            if (subStringWidth > urlStringWidth) {
                width += subStringWidth;
            } else {
                width += urlStringWidth;
            }
        } else {
            if (nameStringWidth > urlStringWidth) {
                width += nameStringWidth;
            } else {
                width += urlStringWidth;
            }
        }
        width += 5;
        return width;
    }

    public int getHeight() {
        return Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT * 5;
    }

    private int getNameX() {
        int textWidth = Minecraft.getMinecraft().fontRendererObj.getStringWidth(name);
        int toAdd = getWidth() / 2 - textWidth / 2;
        return x + toAdd;
    }

    private int getUrlX() {
        int textWidth = Minecraft.getMinecraft().fontRendererObj.getStringWidth(SubCountAddon.INSTANCE.channelUrl);
        int toAdd = getWidth() / 2 - textWidth / 2;
        return x + toAdd;
    }

    private int getUrlY() {
        return y + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT / 2;
    }

    private int getNameY() {
        return getUrlY() + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT;
    }

    private int getSubX() {
        int toAdd = getWidth() / 2 - Minecraft.getMinecraft().fontRendererObj.getStringWidth(value + " " + valueType) / 2;
        return x + toAdd;
    }
    private int getSubY() {
        return getNameY() + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT * 2;
    }
}
