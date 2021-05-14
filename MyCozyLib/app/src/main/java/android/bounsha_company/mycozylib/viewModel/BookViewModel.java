package android.bounsha_company.mycozylib.viewModel;

import android.app.Application;
import android.bounsha_company.mycozylib.database.BookRepository;
import android.bounsha_company.mycozylib.models.Book;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BookViewModel extends AndroidViewModel
{
    private BookRepository bookRepository;
    private LiveData<List<Book>> bookList;

    public BookViewModel(@NonNull Application application)
    {
        super(application);
        bookRepository = new BookRepository(application);
        bookList = bookRepository.getBookList();
    }

    public LiveData<List<Book>> getBookList()
    {
        return bookList;
    }

    public void insert (Book book)
    {
        bookRepository.insert(book);
    }
}
