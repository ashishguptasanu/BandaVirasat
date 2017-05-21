package ashish.com.BandaVirasat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ashish on 21/5/17.
 */

public class Place {

    @SerializedName("places")
    @Expose
    private List<Place_> places = null;

    public List<Place_> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place_> places) {
        this.places = places;
    }
}