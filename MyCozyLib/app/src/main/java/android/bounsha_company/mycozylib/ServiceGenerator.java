package android.bounsha_company.mycozylib;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator
{
    private static BookAPI bookApi;

    public static BookAPI getBookApi()
    {
        if(bookApi == null)
        {
            bookApi = new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(BookAPI.class);
        }
        return bookApi;
    }
}
