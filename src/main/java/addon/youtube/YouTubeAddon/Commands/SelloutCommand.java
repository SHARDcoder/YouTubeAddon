package addon.youtube.YouTubeAddon.Commands;

import addon.youtube.YouTubeAddon.ImplementedAddonFiles.SelloutAddon;
import cc.hyperium.Hyperium;
import cc.hyperium.commands.BaseCommand;
import cc.hyperium.commands.CommandException;
import cc.hyperium.utils.ChatColor;
import net.minecraft.client.Minecraft;

import java.util.Collections;
import java.util.List;

public class SelloutCommand implements BaseCommand {
    @Override
    public String getName() {
        return "sellout";
    }

    @Override
    public String getUsage() {
        return "/sellout <help / set [channel name]>";
    }

    @Override
    public void onExecute(String[] args) throws CommandException {
        if (!YouTubeCommand.isOnlyCommand()) {
            if (args.length == 0) {
                if (SelloutAddon.getChannelName() == "thePlayer.getName()") {
                    Hyperium.INSTANCE.getNotification().display("Subscribe to ".concat(ChatColor.translateAlternateColorCodes('&', "&6&l").concat(Minecraft.getMinecraft().thePlayer.getName())), "\nYouTube Addon\n   Chachy & SHARDcoder", 10);
                } else {
                    Hyperium.INSTANCE.getNotification().display("Subscribe to ".concat(ChatColor.translateAlternateColorCodes('&', "&6&l").concat(SelloutAddon.getChannelName())), "\nYouTube Addon\n   Chachy & SHARDcoder", 10);
                }
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("help")) {
                    Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage("first you kick it in kanto\nthen you head to johto");
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("set")) {
                    SelloutAddon.channelName = args[1];
                }
            }
        } else {
            YouTubeCommand.onCommandNotRun();
        }
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.emptyList();
    }

    @Override
    public List<String> onTabComplete(String args[]) {
        return Collections.singletonList("sellout");
    }
}
