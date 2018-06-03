import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Database.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract DatabaseDao databaseDao();

    //To get the database use:
    //
    //AppDatabase db = Room.databaseBuilder(getApplicationContext(),
    //      AppDatabase.class, "database-name").build();

}
