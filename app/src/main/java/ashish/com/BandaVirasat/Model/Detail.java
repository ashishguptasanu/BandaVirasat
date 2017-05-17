package ashish.com.BandaVirasat.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ashish on 20/12/16.
 */

public class Detail {
    @SerializedName("Detail")
    @Expose
    private List<Detail_> detail = null;

    public List<Detail_> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail_> detail) {
        this.detail = detail;
    }
}
