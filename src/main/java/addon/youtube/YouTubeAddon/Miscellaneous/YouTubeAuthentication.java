package addon.youtube.YouTubeAddon.Miscellaneous;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;

public class YouTubeAuthentication {
    private static final String KEY = "AIzaSyDOpwa86kRTuMRcnG-bw5Prxl-lQ3-QGQY";
    private final YouTube youtube;
    private Channel channel;

    public YouTubeAuthentication() {
        HttpRequestInitializer httpRequestInitializer = request -> {
        };
        this.youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), httpRequestInitializer)
                .setApplicationName("Subscriber Count Addon")
                .build();
    }

    public List<Channel> searchChannels(String channelName) throws IOException {


        YouTube.Channels.List search = youtube.channels().list("statistics");
        search.setKey(KEY);
        ChannelListResponse response = search.execute();
        return response.getItems();
    }

    public String getName(String urlString) throws Throwable {
        URL url = new URL(urlString);
        String username;
        boolean isUsername;
        try {
            if (url.getHost().equals("youtube.com") || url.getHost().equals("www.youtube.com") || url.getHost().equals("youtu.be")) {
                if (url.getFile().startsWith("/user")) {
                    isUsername = true;
                    username = url.getFile().split("/")[2];
                } else {
                    isUsername = false;
                    username = url.getFile().split("/")[2];
                }
            } else {
                throw new IllegalArgumentException("Not a valid YouTube URL");
            }
        } catch (Throwable t) {
            t.printStackTrace();
            throw new IllegalArgumentException("Not a valid YouTube URL");
        }
        YouTube.Channels.List search = isUsername ? youtube.channels().list("snippet").setKey(KEY).setForUsername(username) : youtube.channels().list("statistics").setKey(KEY).setId(username);
        ChannelListResponse response = search.execute();
        return getName(response.getItems().get(0));
    }

    public String getName(Channel channel) {
        return channel.getSnippet().getTitle();
    }

    public BigInteger getSubs(String urlString) throws Throwable {
        URL url = new URL(urlString);
        String username;
        boolean isUsername;
        try {
            if (url.getHost().equals("youtube.com") || url.getHost().equals("www.youtube.com") || url.getHost().equals("youtu.be")) {
                if (url.getFile().startsWith("/user")) {
                    isUsername = true;
                    username = url.getFile().split("/")[2];
                } else {
                    isUsername = false;
                    username = url.getFile().split("/")[2];
                }
            } else {
                throw new IllegalArgumentException("Not a valid YouTube URL");
            }
        } catch (Throwable t) {
            t.printStackTrace();
            throw new IllegalArgumentException("Not a valid YouTube URL");
        }
        YouTube.Channels.List search = isUsername ? youtube.channels().list("statistics").setKey(KEY).setForUsername(username) : youtube.channels().list("statistics").setKey(KEY).setId(username);
        ChannelListResponse response = search.execute();
        return response.getItems().get(0).getStatistics().getSubscriberCount();
    }
}
