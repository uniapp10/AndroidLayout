package mine.com;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import mine.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final String TAG = "MainActivity";

    public void goNext(View v){
        Log.d(TAG, "instance initializer: MainActivity");
        Intent intent = new Intent(MainActivity.this, MineActivity.class);
        startActivity(intent);
    }
}
