package ashish.com.BandaVirasat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ashish on 20/12/16.
 */

public class Travel_ {
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("json_url")
    @Expose
    private String jsonUrl;
    @SerializedName("total_buses")
    @Expose
    private String total_buses;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getJsonUrl() {
        return jsonUrl;
    }

    public void setJsonUrl(String jsonUrl) {
        this.jsonUrl = jsonUrl;
    }

    public String getTotal_buses() {
        return total_buses;
    }

    public void setTotal_buses(String total_buses) {
        this.total_buses = total_buses;
    }
}
