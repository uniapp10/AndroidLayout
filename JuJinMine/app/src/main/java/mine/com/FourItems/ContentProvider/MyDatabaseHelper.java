package mine.com.FourItems.ContentProvider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by zhudongdong on 2018/1/5.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_CONTACT = "create table Contact (" +
            "id integer primary key autoincrement," +
            "name text," +
            "number text)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                            int version){
        super(context, name, factory, version);

        mContext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACT);

        Toast.makeText(mContext, "创建数据库成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Contact");
        onCreate(db);
        Toast.makeText(mContext, "重新创建了数据库", Toast.LENGTH_SHORT).show();
    }


}
