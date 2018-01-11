package mine.com.FourItems.ContentProvider;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mine.R;

/**
 * Created by zhudongdong on 2018/1/4.
 */

public class ContentProviderActivity extends AppCompatActivity {

    ContactsAdapter adapter;
    List<ContactItem> contactsList = new ArrayList<ContactItem>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity_contentprovider);

        ListView listView = (ListView)findViewById(R.id.contentProvider_item);
        adapter = new ContactsAdapter(this, R.layout.item_contentprovider, contactsList);
        listView.setAdapter(adapter);
    }

    //读取联系人
    public void getContracts(View v){
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS}, 1);
        }else {
            readContacts();
        }
    }
    @TargetApi(26)
    private void readContacts() {
        Cursor cursor = null;

      try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,null,null,null);
            if (cursor != null){
                while (cursor.moveToNext()){
                    String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String numberName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    ContactItem item = new ContactItem(displayName, numberName);
                    contactsList.add(item);
                }
            }

            adapter.notifyDataSetChanged();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (cursor != null){
                cursor.close();
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "你允许了读取联系人权限", Toast.LENGTH_SHORT).show();
                    readContacts();
                }else {
                    Toast.makeText(this, "你拒绝了读取联系人权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
    //创建ContentProvider

    public void giveProvider(View v){
        Intent intent = new Intent(this, ContentProviderCustomActivity.class);
        startActivity(intent);
    }
}
