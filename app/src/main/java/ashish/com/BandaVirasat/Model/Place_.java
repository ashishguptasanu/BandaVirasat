package ashish.com.BandaVirasat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ashish on 21/5/17.
 */
public class Place_ {

    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("place_name")
    @Expose
    private String placeName;
    @SerializedName("place_description")
    @Expose
    private String placeDescription;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("long")
    @Expose
    private double _long;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLong() {
        return _long;
    }

    public void setLong(double _long) {
        this._long = _long;
    }

}
