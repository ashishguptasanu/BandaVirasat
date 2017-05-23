package ashish.com.BandaVirasat.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ashish on 23/5/17.
 */

public interface TrainResponse {
    @GET("o/json%2Ftrain?alt=media&token=f72123e8-a29a-462e-a964-a2dd5f737455")
    Call<Train> getTrain();
}
