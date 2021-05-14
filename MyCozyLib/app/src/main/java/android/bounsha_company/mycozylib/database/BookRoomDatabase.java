package android.bounsha_company.mycozylib.database;

import android.bounsha_company.mycozylib.models.Book;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Book.class}, version = 1, exportSchema = false)
public abstract class BookRoomDatabase extends RoomDatabase
{
    public abstract BookDAO bookDAO();

    private static volatile BookRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile BookRoomDatabase instance;

    static BookRoomDatabase getRoomDatabase(Context context)
    {
        if(instance == null)
        {
            synchronized (BookRoomDatabase.class)
            {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        BookRoomDatabase.class, "book_database")
                        .build();
            }
        }
        return instance;
    }
}
