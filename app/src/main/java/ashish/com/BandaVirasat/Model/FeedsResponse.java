package ashish.com.BandaVirasat.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ashish on 22/5/17.
 */

public interface FeedsResponse {
    @GET("o/json%2Ffeeds?alt=media&token=63da1259-e75a-4835-8c4c-d450ce29c24f")
    Call<Feed> getFeeds();
}
