package mine.com.SaveItems;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mine.R;
import mine.com.FourItems.ContentProvider.MyDatabaseHelper;

/**
 * Created by zhudongdong on 2018/1/11.
 */

public class SaveToSqliteActivity extends AppCompatActivity {

    ListView listView;
    List<SaveBookItem> booksList = new ArrayList<SaveBookItem>();
    SaveItemAdapter adapter;
    private MyDatabaseHelper dbHelper;

    private TextView nameTextView;
    private TextView authorTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_save_sqlite);
        listView = (ListView)findViewById(R.id.listView_sqlite);
        adapter = new SaveItemAdapter(this, R.layout.item_save_slite_item, booksList);
        listView.setAdapter(adapter);

        dbHelper = new MyDatabaseHelper(this, "Book.db", null, 1);

        nameTextView = (TextView)findViewById(R.id.editText_bookName);
        authorTextView = (TextView)findViewById(R.id.editText_bookAuthor);
    }

    long lastId = 1;
    public void sqlite_add(View v){

        String name = nameTextView.getText().toString();
        String author = authorTextView.getText().toString();

        if (name.length() > 0 && author.length() > 0){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("author", author);
            lastId = db.insert("Book", null, values);
        }else {
            Toast.makeText(this, "书名或者作者为空", Toast.LENGTH_SHORT).show();
        }

    }

    public void sqlite_delete(View v){

        String name = nameTextView.getText().toString();
        if (name.length() > 0 ){

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.delete("Book", "name = ?", new String[]{name});
        }else {
            Toast.makeText(this, "请输入书名", Toast.LENGTH_SHORT).show();
        }
    }

    public void sqlite_update(View v){
        String name = nameTextView.getText().toString();
        String author = authorTextView.getText().toString();

        if (name.length() > 0 && author.length() > 0){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("author", author);
            db.update("Book", values, "name=?",new String[]{name});

            Toast.makeText(this, "更新成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "书名或者作者为空", Toast.LENGTH_SHORT).show();
        }
    }

    public void sqlite_query(View v){
        booksList.clear();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                SaveBookItem bookItem = new SaveBookItem(name, author);
                booksList.add(bookItem);
            }while (cursor.moveToNext());
        }
        cursor.close();

        adapter.notifyDataSetChanged();
    }
}
