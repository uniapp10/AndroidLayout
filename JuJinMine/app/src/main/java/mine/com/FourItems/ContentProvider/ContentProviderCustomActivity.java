package mine.com.FourItems.ContentProvider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mine.R;
import mine.com.SaveItems.SaveBookItem;
import mine.com.SaveItems.SaveItemAdapter;

/**
 * Created by zhudongdong on 2018/1/5.
 */

public class ContentProviderCustomActivity extends AppCompatActivity {

    ListView listView;
    List<SaveBookItem> booksList = new ArrayList<SaveBookItem>();
    SaveItemAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_contentprovider_custom);
        listView = (ListView)findViewById(R.id.listView_contentProvider);
        adapter = new SaveItemAdapter(this, R.layout.item_save_slite_item, booksList);
        listView.setAdapter(adapter);
    }

    private String newId = "1";

    private static final String TAG = "ContentProviderCustomAc";
    public void add(View v){
        Uri uri = Uri.parse("content://com.jujin.mine/contact");
        ContentValues values = new ContentValues();
        values.put("name", "冬风破");
        values.put("author", "冬风破10");
        Uri newUri = getContentResolver().insert(uri, values);
        newId = newUri.getPathSegments().get(1);
//        Log.e(TAG, "add: " + newId );

        Toast.makeText(this, "添加数据成功", Toast.LENGTH_SHORT).show();
        query(v);
    }


    public void delete(View v){
        Uri uri = Uri.parse("content://com.jujin.mine/contact/"+newId);
        getContentResolver().delete(uri, null, null);

        Toast.makeText(this, "删除数据成功", Toast.LENGTH_SHORT).show();
        query(v);
    }

    public void update(View v){
        Uri uri = Uri.parse("content://com.jujin.mine/contact/"+newId);
        ContentValues values = new ContentValues();
        values.put("name", "update");
        values.put("author", "110");
        getContentResolver().update(uri, values, null, null);
        Toast.makeText(this, "更新数据成功", Toast.LENGTH_SHORT).show();
        query(v);
    }

    public void query(View v){
        Uri uri = Uri.parse("content://com.jujin.mine/contact");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        booksList.clear();
        if (cursor != null){
            while (cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
//                Log.e(TAG, "query: "+name + number );
                SaveBookItem item = new SaveBookItem(name, author);
                booksList.add(item);
            }
            cursor.close();
        }

        adapter.notifyDataSetChanged();
    }
}
