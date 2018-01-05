package mine.com.FourItems.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import mine.R;

/**
 * Created by zhudongdong on 2018/1/5.
 */

public class BroadcastActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    static final String BroadcastName = "com.jujin.mine.broadcast";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_activity_broadcast);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        intentFilter = new IntentFilter();
        intentFilter.addAction(BroadcastName);
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    public void sendBroadcast(View v){

        Intent intent = new Intent(BroadcastName);
        intent.putExtra("broadcastName", "第一个广播");
        localBroadcastManager.sendBroadcast(intent);
    }

    class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String info = intent.getStringExtra("broadcastName");
            Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
        }
    }
}
