package mine.com;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mine.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goNext(View v){
        Intent intent = new Intent(MainActivity.this, MineActivity.class);
        startActivity(intent);
    }

    public void goLayout(View v){
        Intent intent = new Intent(MainActivity.this, LayoutActivity.class);
        startActivity(intent);
    }

}
