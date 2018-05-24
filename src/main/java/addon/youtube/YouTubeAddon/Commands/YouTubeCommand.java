package addon.youtube.YouTubeAddon.Commands;

import addon.youtube.YouTubeAddon.ImplementedAddonFiles.SelloutAddon;
import cc.hyperium.Hyperium;
import cc.hyperium.commands.BaseCommand;
import cc.hyperium.commands.CommandException;
import cc.hyperium.utils.ChatColor;
import net.minecraft.client.Minecraft;

import java.util.Collections;
import java.util.List;

public class YouTubeCommand implements BaseCommand {
    public static Boolean onlyCommand = true;

    public static Boolean isOnlyCommand() {
        return onlyCommand;
    }

    public static void onCommandNotRun() {
        Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[&4Y&fT&0A&6] &f").concat("This command is not enabled right now\n").concat(ChatColor.translateAlternateColorCodes('&', "&6[&4Y&fT&0A&6] &f")).concat("To enable it, run /youtube onlyCommand false"), false);
    }

    @Override
    public String getName() {
        return "youtube";
    }

    @Override
    public String getUsage() {
        return "/youtube <subs / sellout / onlyCommand [true / false]>";
    }

    @Override
    public void onExecute(String[] args) throws CommandException {
        //onlyCommand
        if (args[0].equalsIgnoreCase("onlyCommand")) {
            if (args.length == 1) {
                if (onlyCommand) {
                    Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[&4Y&fT&0A&6] &f").concat("onlyCommand is set to true"), false);
                } else {
                    Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[&4Y&fT&0A&6] &f").concat("onlyCommand is set to false"), false);
                }
            } else if (args.length == 2) {
                if (args[1].equalsIgnoreCase("true")) {
                    onlyCommand = true;
                    Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[&4Y&fT&0A&6] &f").concat("Enabled command restrictions"), false);
                } else if (args[1].equalsIgnoreCase("false")) {
                    onlyCommand = false;
                    Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[&4Y&fT&0A&6] &f").concat("Disabled command restrictions"), false);
                }
            }
        }

        //subcount
        if (args[0].equalsIgnoreCase("subs")) {
            //your sub count thing goes here
            //or call the method and integrate later idc
        }

        //sellout
        if (args[0].equalsIgnoreCase("sellout")) {
            if (args.length == 1) {
                if (SelloutAddon.getChannelName() == "thePlayer.getName()"){
                    Hyperium.INSTANCE.getNotification().display("Subscribe to ".concat(ChatColor.translateAlternateColorCodes('&', "&6&l").concat(Minecraft.getMinecraft().thePlayer.getName())), "\nYouTube Addon\n   Chachy & SHARDcoder", 10);
                } else {
                   Hyperium.INSTANCE.getNotification().display("Subscribe to ".concat(ChatColor.translateAlternateColorCodes('&', "&6&l").concat(SelloutAddon.getChannelName())), "\nYouTube Addon\n    Chachy & SHARDcoder", 10);
                }
            } else if (args.length == 2) {
                if (args[1].equalsIgnoreCase("help")) {
                    Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[&4Y&fT&0A&6] &f").concat("onlyCommand is set to false"), false);
                }
            } else if (args.length == 3) {
                if (args[1].equalsIgnoreCase("set")) {
                    SelloutAddon.channelName = args[2];
                    Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[&4Y&fT&0A&6] &f").concat("Channel name set to ").concat(ChatColor.translateAlternateColorCodes('&', "&6&l").concat(SelloutAddon.getChannelName())), false);
                }
            }
        }
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("yt");
    }

    @Override
    public List<String> onTabComplete(String args[]) {
        return Collections.singletonList("youtube");
    }
}
