package net.youtubeaddon.SubscriberCountAddon;

import cc.hyperium.commands.BaseCommand;
import cc.hyperium.commands.CommandException;
import cc.hyperium.event.EventBus;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.TickEvent;
import net.minecraft.client.Minecraft;

public class TestCommand implements BaseCommand {
    @Override
    public String getName() {
        return "subs";
    }

    @Override
    public String getUsage() {
        return "/subs <channel>";
    }

    @Override
    public void onExecute(String[] strings) throws CommandException {
        EventBus.INSTANCE.register(this);
    }

    @InvokeEvent
    public void onTick(TickEvent event) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiConfig());
        EventBus.INSTANCE.unregister(this);
    }
}
