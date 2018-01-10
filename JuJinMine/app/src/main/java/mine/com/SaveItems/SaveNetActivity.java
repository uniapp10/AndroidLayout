package mine.com.SaveItems;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

import mine.R;

/**
 * Created by zhudongdong on 2018/1/10.
 */

public class SaveNetActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_save_net);

        webView = (WebView)findViewById(R.id.save_webView);
    }

    public void loadUrl(View v){
        webView.loadUrl("https://www.jianshu.com/c/ce92018685f3");
    }
}
