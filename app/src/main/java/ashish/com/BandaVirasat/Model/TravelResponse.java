package ashish.com.BandaVirasat.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ashish on 20/12/16.
 */

public interface TravelResponse {
    @GET("/bandavirasat/travel_main")
    Call<Travel> getTravel();
}
