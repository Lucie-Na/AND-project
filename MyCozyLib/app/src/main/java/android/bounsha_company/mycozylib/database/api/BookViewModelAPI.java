package android.bounsha_company.mycozylib.database.api;

import android.bounsha_company.mycozylib.models.Book;
import android.bounsha_company.mycozylib.models.BookApi;
import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.GsonBuilder;

import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookViewModelAPI extends ViewModel
{
    private MutableLiveData<List<BookApi>> listBookByNameApi;
    private MutableLiveData<List<Book>> listBookByName;
    private BookAPI api;

    public LiveData<List<Book>> getBook()
    {
        if(listBookByName == null)
        {
            initializeInstance();
        }
        return listBookByName;
    }

    public LiveData<List<Book>> getBookByName(String name)
    {
        if(listBookByName == null)
        {
            initializeInstance();
        }
        loadBookByName(name == null ? "" : name);

        return listBookByName;
    }

    private void initializeInstance()
    {
        listBookByName = new MutableLiveData<List<Book>>();
        listBookByNameApi = new MutableLiveData<List<BookApi>>();

        listBookByNameApi.observeForever(() ->
        {
            List<BookApi> listBookApiTemp = null;
            List<Book> listBookTemp = null;
            listBookApiTemp.addAll((Collection)listBookByNameApi);
            for (BookApi bookApi : listBookApiTemp)
            {
                listBookTemp.add((Book) bookApi);
            }
            listBookByName.setValue(listBookTemp);
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BookAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        api = retrofit.create(BookAPI.class);
    }

    private void loadBookByName(String name)
    {
        Call<List<BookApi>> call = api.getBookByTitle(name);

        call.enqueue(new Callback<List<BookApi>>()
        {
            @Override
            public void onResponse(Call<List<BookApi>> call, Response<List<BookApi>> response)
            {
                listBookByNameApi.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<BookApi>> call, Throwable t)
            {
                Log.e("Debug API View Model", t.getMessage());
            }
        });
    }

}
