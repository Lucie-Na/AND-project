package android.bounsha_company.mycozylib.database.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BookAPI
{

    /*
    @GET, @POST, @PUT, @DELETE and @HEAD for request type on methods
    @Path and @Query for URL manipulation on parameters*/

    /**
     * getBook :
     * @param name : String :
     * @return Call<BookResponse> :
     */
    @GET("books/v1/volumes?q={name}")
    Call<BookResponse> getBook(@Path("name") String name);

}
