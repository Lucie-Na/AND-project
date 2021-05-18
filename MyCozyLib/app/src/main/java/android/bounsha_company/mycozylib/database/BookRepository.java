/**
 * This class execute all the database's queries
 * by Naffien Lucie
 */
package android.bounsha_company.mycozylib.database;

import android.app.Application;
import android.bounsha_company.mycozylib.models.Book;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BookRepository {
    private BookDAO bookDAO;

    /**
     * BookRepository : initialize the class instance with the database and the queries
     * @param application : Application
     */
    public BookRepository(Application application)
    {
        BookRoomDatabase bookRoomDatabase = BookRoomDatabase.getRoomDatabase(application);
        bookDAO = bookRoomDatabase.bookDAO();
    }

    /**
     * getBookList : return the content of the database as a list, sorted by title ascending order
     * @return LiveData<List<Book>> : list that contains all the books from the database
     */
    public LiveData<List<Book>> getBookList()
    {
        return bookDAO.getTitleAsc();
    }

    /**
     * insert : insert a given book in the database
     * @param book : Book : book to insert
     */
    public void insert (Book book)
    {
        BookRoomDatabase.databaseWriteExecutor.execute( () ->
                {
                    bookDAO.insert(book);
                }
        );
    }

    /**
     * deleteAll : clean the database
     */
    public void deleteAll()
    {
        BookRoomDatabase.databaseWriteExecutor.execute( () ->
                {
                    bookDAO.deleteAll();
                }
        );
    }

}
