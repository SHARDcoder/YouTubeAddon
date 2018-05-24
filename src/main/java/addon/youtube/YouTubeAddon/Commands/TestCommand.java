package addon.youtube.YouTubeAddon.Commands;

import addon.youtube.YouTubeAddon.Configs.GuiConfig;
import cc.hyperium.commands.BaseCommand;
import cc.hyperium.commands.CommandException;
import cc.hyperium.event.EventBus;
import cc.hyperium.event.InvokeEvent;
import cc.hyperium.event.TickEvent;
import net.minecraft.client.Minecraft;

import java.util.Collections;
import java.util.List;

public class TestCommand implements BaseCommand {
    @Override
    public String getName() {
        return "subscribers";
    }

    @Override
    public String getUsage() {
        return "/subscribers <channel>";
    }

    @Override
    public void onExecute(String[] strings) throws CommandException {
        if (!YouTubeCommand.onlyCommand) {
            //just curious as to why this is here? pretty sure its not needed
            EventBus.INSTANCE.register(this);
        } else {
            YouTubeCommand.onCommandNotRun();
        }
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("subs");
    }

    //@InvokeEvent
    //public void onTick(TickEvent event) {
        //Minecraft.getMinecraft().displayGuiScreen(new GuiConfig());
        //EventBus.INSTANCE.unregister(this);
    //}

    @Override
    public List<String> onTabComplete(String args[]) {
        return Collections.singletonList("subscribers");
    }
}
