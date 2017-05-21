package ashish.com.BandaVirasat.Model;

import retrofit2.Call;
import retrofit2.http.GET;


public interface NearByPlacesResponse {
    @GET("o/json%2Fnearby?alt=media&token=057009c4-4ba1-4e96-ac50-17ff72a63639")
    Call<Place> getPlaces();
}
