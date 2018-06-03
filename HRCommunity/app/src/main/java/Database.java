import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Database {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "first-name") //name staat voor field-name
    private String firstname;

    @ColumnInfo(name = "last-name")
    private String lastname;
    //getters and setters are ignored for brevity but are requirede for Room to work
}
