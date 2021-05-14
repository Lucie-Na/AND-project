package android.bounsha_company.mycozylib.database;

import android.app.Application;
import android.bounsha_company.mycozylib.models.Book;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BookRepository {
    private BookDAO bookDAO;
    private LiveData<List<Book>> bookList;

    public BookRepository(Application application)
    {
        BookRoomDatabase bookRoomDatabase = BookRoomDatabase.getRoomDatabase(application);
        bookDAO = bookRoomDatabase.bookDAO();
        bookList = bookDAO.getTitleAsc();
    }

    public LiveData<List<Book>> getBookList()
    {
        return bookList;
    }

    public void insert (Book book)
    {
        BookRoomDatabase.databaseWriteExecutor.execute( () ->
                {
                    bookDAO.insert(book);
                }
        );
    }

}
