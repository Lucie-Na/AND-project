/**
 * This class create the database
 * by Naffien Lucie
 */
package android.bounsha_company.mycozylib.database.local_database;

import android.bounsha_company.mycozylib.models.Book;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Book.class}, version = 1, exportSchema = false)
abstract class BookRoomDatabase extends RoomDatabase
{
    //The database exposes DAOs through an abstract "getter" method for each @Dao.
    protected abstract BookDAO bookDAO();

    private static final int NUMBER_OF_THREADS = 4;
    protected static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    //singleton
    private static volatile BookRoomDatabase instance;

    /**
     * getRoomDatabase : return the only instance of BookRoomDatabase. If it doesn't already exists, create the database and the class instance
     * @param context : Context : application context
     * @return BookRoomDatabase : instance of the class that contains the "book" database
     */
    protected static BookRoomDatabase getRoomDatabase(Context context)
    {
        if(instance == null)
        {
            synchronized (BookRoomDatabase.class)
            {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        BookRoomDatabase.class, "book")
                        .addCallback(roomDatabaseCallback)
                        .build();
            }
        }
        return instance;
    }

    //#TODO
    //We've created an ExecutorService with a fixed thread pool that you will use to run database operations asynchronously on a background thread.
    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() ->
            {
                BookDAO dao = instance.bookDAO();
                //clean the database
                dao.deleteAll();

                dao.insert(new Book("test", "", "test", "test", 2021, "",0, "" ));
                dao.insert(new Book("test2", "", "test2", "test2", 2021, "",0, "" ));

            });
        }
    };
}
