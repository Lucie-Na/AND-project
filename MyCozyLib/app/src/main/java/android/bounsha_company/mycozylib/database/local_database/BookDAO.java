/**
 * This interface contains all the queries needed to interact with the local database
 * by Naffien Lucie
 */
package android.bounsha_company.mycozylib.database.local_database;

import android.bounsha_company.mycozylib.models.Book;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDAO
{
    /**
     * insert : insert a given book in the database
     * @param book : book to insert
     */
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Book book);

    /**
     * deleteAll : clean the table "book"
     */
    @Query("DELETE FROM book")
    void deleteAll();

    /**
     * getTitleAsc : select everything from the table "book" sorted in title ascending order
     * @return LiveData<List<Book>> : list that contains all the books from the database
     */
    @Query("SELECT * FROM book ORDER BY title ASC")
    LiveData<List<Book>> getTitleAsc();
}
