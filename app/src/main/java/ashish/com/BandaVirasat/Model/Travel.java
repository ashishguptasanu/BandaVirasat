package ashish.com.BandaVirasat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ashish on 20/12/16.
 */

public class Travel {
    @SerializedName("Travel")
    @Expose
    private List<Travel_> travel = null;

    public List<Travel_> getTravel() {
        return travel;
    }

    public void setTravel(List<Travel_> travel) {
        this.travel = travel;
    }
}
