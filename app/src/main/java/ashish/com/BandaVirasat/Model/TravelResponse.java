package ashish.com.BandaVirasat.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ashish on 20/12/16.
 */

public interface TravelResponse {
    @GET("/v0/b/banda-virasat-6812b.appspot.com/o/json%2Ftravel_main?alt=media&token=8e3bb132-20d0-4640-8d1f-119d2049a461")
    Call<Travel> getTravel();
}
