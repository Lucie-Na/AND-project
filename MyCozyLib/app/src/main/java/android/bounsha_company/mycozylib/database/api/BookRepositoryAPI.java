/**
 *
 * by Naffien Lucie
 */
package android.bounsha_company.mycozylib.database.api;

import android.bounsha_company.mycozylib.models.Book;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class BookRepositoryAPI
{
    private static BookRepositoryAPI instance;
    private final MutableLiveData<List<Book>> searchedBooks;

    /**
     * BookRepositoryAPI : initialize the new instance of this class
     */
    private BookRepositoryAPI()
    {
        searchedBooks = new MutableLiveData<List<Book>>();
    }

    /**
     * getInstance : return the only instance of this class
     * @return BookRepositoryAPI : unique instance of BookRepositoryAPI
     */
    public static synchronized BookRepositoryAPI getInstance()
    {
        if (instance == null)
        {
            instance = new BookRepositoryAPI();
        }
        return instance;
    }

    /**
     * getSearchedBook : return the result of a research
     * @return : LiveData<List<Book>> : research's result
     */
    public LiveData<List<Book>> getSearchedBook()
    {
        return searchedBooks;
    }

    /**
     * searchForBook : begin an asynchronous research in the API
     * @param bookTitle : String : researched title
     */
    public void searchForBook(String bookTitle)
    {
        BookAPI bookAPI = ServiceGenerator.getBookAPI();
        Call<BookResponse> call = bookAPI.getBookByTitle(bookTitle);
        call.enqueue(new Callback<BookResponse>()
        {
            // if the request succeed
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response)
            {
                if (response.isSuccessful())
                {
                    Log.e("Debug", "Retrofit : request success");
                    searchedBooks.setValue(response.body().getListBook());
                }
            }
            // if the request failed
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<BookResponse> call, Throwable t)
            {
                Log.e("Debug", "Retrofit : request failed");
            }
        });
    }
}
