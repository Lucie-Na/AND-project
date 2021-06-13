/**
 * This class execute initialize everything to make requests to the API
 * by Naffien Lucie
 */
package android.bounsha_company.mycozylib.database.api;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator
{

    private static BookAPI bookAPI;

    protected static BookAPI getBookAPI()
    {
        if (bookAPI == null)
        {
            bookAPI = new Retrofit.Builder()
                    .baseUrl("https://www.googleapis.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(BookAPI.class);
            Log.e("Debug", "Service Generator : created");
        }
        return bookAPI;
    }
}

