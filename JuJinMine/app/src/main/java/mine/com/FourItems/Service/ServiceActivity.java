package mine.com.FourItems.Service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mine.R;

/**
 * Created by zhudongdong on 2018/1/4.
 */

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_activity_service);
    }

    public void startService(View v){
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);
    }

    public void stopService(View v){
        Intent intent = new Intent(this, DownloadService.class);
        stopService(intent);
    }
}
