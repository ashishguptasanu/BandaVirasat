package ashish.com.BandaVirasat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ashish on 23/5/17.
 */

public class Train {

    @SerializedName("train")
    @Expose
    private List<Train_> train = null;

    public List<Train_> getTrain() {
        return train;
    }

    public void setTrain(List<Train_> train) {
        this.train = train;
    }

}
