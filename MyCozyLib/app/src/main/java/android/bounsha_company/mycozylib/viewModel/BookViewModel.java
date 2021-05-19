/**
 * This class process all the data needed from the database
 * by Naffien Lucie
 */
package android.bounsha_company.mycozylib.viewModel;

import android.app.Application;
import android.bounsha_company.mycozylib.database.local_database.BookRepository;
import android.bounsha_company.mycozylib.models.Book;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BookViewModel extends AndroidViewModel
{
    private BookRepository bookRepository;

    /**
     * BookViewModel : initialize the class instance with the database repository
     * @param application : Application
     */
    public BookViewModel(@NonNull Application application)
    {
        super(application);
        bookRepository = new BookRepository(application);
    }

    /**
     * getBookList : return the content of the database as a list, sorted by title ascending order
     * @return LiveData<List<Book>> : list that contains all the books from the database
     */
    public LiveData<List<Book>> getBookList()
    {
        return bookRepository.getBookList();
    }

    /**
     * insert : insert a given book in the database. Wrap the same method from the BookRepository class
     * @param book : Book : book to insert
     */
    public void insert (Book book)
    {
        bookRepository.insert(book);
    }

    /**
     * deleteAll : clean the database
     */
    public void deleteAll()
    {
        bookRepository.deleteAll();
    }
}
