package mine.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mine.R;
import mine.com.FourItems.Activity.AcitivityItem;
import mine.com.FourItems.Broadcast.BroadcastActivity;
import mine.com.FourItems.ContentProvider.ContentProviderActivity;
import mine.com.FourItems.Service.ServiceActivity;

/**
 * Created by zhudongdong on 2018/1/3.
 */

public class ItemsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.items_layout);
    }

    public void goToActivity(View v){
        Intent intent = new Intent(ItemsActivity.this, AcitivityItem.class);
        startActivity(intent);
    }

    public void goToService(View v){
        Intent intent = new Intent(ItemsActivity.this, ServiceActivity.class);
        startActivity(intent);
    }


    public void goToContentProvider(View v){
        Intent intent = new Intent(ItemsActivity.this, ContentProviderActivity.class);
        startActivity(intent);
    }


    public void goToBroadcast(View v){
        Intent intent = new Intent(this, BroadcastActivity.class);
        startActivity(intent);
    }
}
