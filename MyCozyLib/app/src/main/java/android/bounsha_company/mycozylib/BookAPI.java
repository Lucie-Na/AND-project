package android.bounsha_company.mycozylib;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface BookAPI
{
    @GET("api/v2/pokemon/{name}")
    Call<BookResponse> getBook(@Path("name") String name);
}
