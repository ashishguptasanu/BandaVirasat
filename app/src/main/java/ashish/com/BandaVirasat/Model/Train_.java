package ashish.com.BandaVirasat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ashish on 23/5/17.
 */
public class Train_ {

    @SerializedName("train_name")
    @Expose
    private String trainName;
    @SerializedName("rating")
    @Expose
    private float rating;
    @SerializedName("train_number")
    @Expose
    private String trainNumber;
    @SerializedName("train_to_code")
    @Expose
    private String trainToCode;
    @SerializedName("train_from_code")
    @Expose
    private String trainFromCode;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("stopage")
    @Expose
    private String stopage;
    @SerializedName("days")
    @Expose
    private String days;
    @SerializedName("train_to_name")
    @Expose
    private String trainToName;
    @SerializedName("train_from_name")
    @Expose
    private String trainFromName;

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainToCode() {
        return trainToCode;
    }

    public void setTrainToCode(String trainToCode) {
        this.trainToCode = trainToCode;
    }

    public String getTrainFromCode() {
        return trainFromCode;
    }

    public void setTrainFromCode(String trainFromCode) {
        this.trainFromCode = trainFromCode;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStopage() {
        return stopage;
    }

    public void setStopage(String stopage) {
        this.stopage = stopage;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTrainToName() {
        return trainToName;
    }

    public void setTrainToName(String trainToName) {
        this.trainToName = trainToName;
    }

    public String getTrainFromName() {
        return trainFromName;
    }

    public void setTrainFromName(String trainFromName) {
        this.trainFromName = trainFromName;
    }

}