package android.bounsha_company.mycozylib;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class BookRepository
{
    private static BookRepository instance;
    private final MutableLiveData<Book> searchedBook;

    private BookRepository()
    {
        this.searchedBook = new MutableLiveData<>();
    }

    public static synchronized BookRepository getBookRepository()
    {
        if(instance == null)
        {
            instance = new BookRepository();
        }
        return instance;
    }

    public LiveData<Book> getSearchedBook()
    {
        return searchedBook;
    }

    public void searchForBook(String bookTitle)
    {
        BookAPI bookAPI = ServiceGenerator.getBookApi();
        Call<BookResponse> call = bookAPI.getBook(bookTitle);
        call.enqueue(new Callback<BookResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response)
            {
                if(response.isSuccessful())
                {
                    searchedBook.setValue(response.body().getBook());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<BookResponse> call, Throwable t)
            {
                Log.i("Retrofit", "Error with the API call");
            }
        });
    }
}
