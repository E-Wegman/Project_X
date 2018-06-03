import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DatabaseDao {
    @Query("SELECT * FROM `database`")
    List<Database> getAll();

    @Query("SELECT * FROM `database` WHERE `first-name` LIKE :first AND " + "`last-name` LIKE :last LIMIT 1")
    Database findbyName(String first, String last);

    @Insert
    void insertAll(Database... databases);

    @Delete
    void delete(Database database);
}
