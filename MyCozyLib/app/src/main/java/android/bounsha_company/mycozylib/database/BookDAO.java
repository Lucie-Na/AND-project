package android.bounsha_company.mycozylib.database;

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

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(Book book);

    //clean the table
    @Query("DELETE FROM book")
    public void deleteAll();

    //select everything from the table sorted in ascending order
    @Query("SELECT * FROM book ORDER BY title ASC")
    public LiveData<List<Book>> getTitleAsc();
}
