package mine.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mine.R;
import mine.com.Layouts.FrameLayoutActivtiy;
import mine.com.Layouts.LinearlayoutActivtiy;
import mine.com.Layouts.RelativeLayoutActivtiy;

/**
 * Created by zhudongdong on 2017/12/29.
 */

public class LayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_layout);
    }

    public void goLinearlayout(View v){
        Intent intent = new Intent(this, LinearlayoutActivtiy.class);
        startActivity(intent);
    }

    public void goRelativelayout(View v){
        Intent intent = new Intent(this, RelativeLayoutActivtiy.class);
        startActivity(intent);
    }

    public void goFramelayout(View v){
        Intent intent = new Intent(this, FrameLayoutActivtiy.class);
        startActivity(intent);
    }
}
