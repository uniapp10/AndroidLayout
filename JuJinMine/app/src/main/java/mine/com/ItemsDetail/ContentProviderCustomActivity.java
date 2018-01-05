package mine.com.ItemsDetail;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import mine.R;

/**
 * Created by zhudongdong on 2018/1/5.
 */

public class ContentProviderCustomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_contentprovider_custom);
    }

    private String newId;

    private static final String TAG = "ContentProviderCustomAc";
    public void add(View v){
        Uri uri = Uri.parse("content://com.jujin.mine/contact");
        ContentValues values = new ContentValues();
        values.put("name", "zhuDong");
        values.put("number", "10000000");
        Uri newUri = getContentResolver().insert(uri, values);
        newId = newUri.getPathSegments().get(1);
        Log.e(TAG, "add: " + newId );
    }


    public void delete(View v){
        Uri uri = Uri.parse("content://com.jujin.mine/contact/"+newId);
        getContentResolver().delete(uri, null, null);
    }

    public void update(View v){
        Uri uri = Uri.parse("content://com.jujin.mine/contact/"+newId);
        ContentValues values = new ContentValues();
        values.put("name", "update");
        values.put("number", "110");
        getContentResolver().update(uri, values, null, null);
    }

    public void query(View v){
        Uri uri = Uri.parse("content://com.jujin.mine/contact");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null){
            while (cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String number = cursor.getString(cursor.getColumnIndex("number"));
                Log.e(TAG, "query: "+name + number );
            }
            cursor.close();
        }
    }
}
