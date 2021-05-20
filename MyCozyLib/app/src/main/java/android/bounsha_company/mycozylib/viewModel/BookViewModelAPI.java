package android.bounsha_company.mycozylib.viewModel;

import android.bounsha_company.mycozylib.database.api.BookRepositoryAPI;
import android.bounsha_company.mycozylib.models.Book;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class BookViewModelAPI extends ViewModel
{
    private BookRepositoryAPI bookRepositoryAPI;

    /**
     * BookViewModelAPI : initialize the class instance with the api service
     */
    public BookViewModelAPI()
    {
        bookRepositoryAPI = BookRepositoryAPI.getInstance();
        Log.e("Debug", "View Model for API : repository created");
    }

    /**
     * getSearchedBook : return the content of the api as a list
     * @return LiveData<Book> : list that contains all the books from the database
     */
    public LiveData<List<Book>> getSearchedBook()
    {
        Log.e("Debug", "View Model for API : end book research");
        return bookRepositoryAPI.getSearchedBook();
    }

    /**
     * searchForBook : search for a book with a specific title
     * @param title : String : title researched
     */
    public void searchForBook(String title)
    {
        Log.e("Debug", "View Model for API : begin book research");
        bookRepositoryAPI.searchForBook(title);
    }
}
