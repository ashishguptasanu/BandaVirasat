package ashish.com.BandaVirasat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feed {

    @SerializedName("feeds")
    @Expose
    private List<Feed_> feeds = null;

    public List<Feed_> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed_> feeds) {
        this.feeds = feeds;
    }

}