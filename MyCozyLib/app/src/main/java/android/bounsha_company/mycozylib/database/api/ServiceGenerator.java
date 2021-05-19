package android.bounsha_company.mycozylib.database.api;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator
{
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://www.googleapis.com")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();
    private static BookAPI bookAPI = retrofit.create(BookAPI.class);

    public static BookAPI getBookAPI()
    {
        return bookAPI;
    }

    public void requestBook(String bookTitle)
    {
        BookAPI bookAPI = ServiceGenerator.getBookAPI();
        Call<BookResponse> call = bookAPI.getBook(bookTitle);
        //call.enqueue() - asynchronous
        //call.execute() - synchronous
        call.enqueue(new Callback<BookResponse>()
        {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response)
            {
                if (response.code() == 200)
                {
                     book.setValue(response.body().getBook()); //Updating LiveData
                }
            }
            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }

}

