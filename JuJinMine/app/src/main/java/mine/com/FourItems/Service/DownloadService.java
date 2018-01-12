package mine.com.FourItems.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by zhudongdong on 2018/1/4.
 */

public class DownloadService extends Service {

    private static final String TAG = "DownloadService";
    @Override
    public void onCreate() {
        super.onCreate();
//        Log.e(TAG, "onCreate: "+"服务创建了");
        Toast.makeText(getApplicationContext(), "服务创建了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.e(TAG, "onCreate: "+"服务执行了");
        Toast.makeText(getApplicationContext(), "服务执行了", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Log.e(TAG, "onCreate: "+"服务销毁了");
        Toast.makeText(getApplicationContext(), "服务销毁了", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
//        Log.e(TAG, "onCreate: "+"服务绑定了");
        Toast.makeText(getApplicationContext(), "服务绑定了", Toast.LENGTH_SHORT).show();
        return null;
    }
}
