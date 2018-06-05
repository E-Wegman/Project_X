import android.arch.persistence.room.Database;
import android.arch.persistence.room.*;


@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

//  To actually make a database
//AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//        AppDatabase.class, "database-name").build();
