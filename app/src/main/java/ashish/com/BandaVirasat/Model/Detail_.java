package ashish.com.BandaVirasat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ashish on 20/12/16.
 */

public class Detail_ {
    @SerializedName("stopage")
    @Expose
    private String stopage;
    @SerializedName("arrival")
    @Expose
    private String arrival;
    @SerializedName("departure")
    @Expose
    private String departure;

    public String getStopage() {
        return stopage;
    }

    public void setStopage(String stopage) {
        this.stopage = stopage;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
}
