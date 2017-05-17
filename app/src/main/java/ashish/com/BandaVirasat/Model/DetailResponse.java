package ashish.com.BandaVirasat.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by ashish on 20/12/16.
 */

public interface DetailResponse {
    @GET
    Call<Detail> getJSON(@Url String url);
}
