/**
 * This interface contains all the queries needed to interact with the API
 * by Naffien Lucie
 */
package android.bounsha_company.mycozylib.database.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookAPI
{

    /*
    @GET, @POST, @PUT, @DELETE and @HEAD for request type on methods
    @Path and @Query for URL manipulation on parameters*/

    /**
     * getBook : research for a specific book in the API
     * @param name : String : book title to research
     * @return Call<BookResponse> : list of corresponding books
     */
    @GET("books/v1/volumes?")
    Call<BookResponse> getBookByTitle(@Query("name") String name);

}
