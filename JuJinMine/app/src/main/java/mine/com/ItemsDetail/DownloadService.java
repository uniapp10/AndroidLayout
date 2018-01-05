package mine.com.ItemsDetail;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zhudongdong on 2018/1/4.
 */

public class DownloadService extends Service {

    private static final String TAG = "DownloadService";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: "+"服务创建了");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onCreate: "+"服务执行了");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onCreate: "+"服务销毁了");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onCreate: "+"服务绑定了");
        return null;
    }
}
