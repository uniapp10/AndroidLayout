package mine.com;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mine.R;
import mine.com.SaveItems.SaveItemsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goLayout(View v){
        Intent intent = new Intent(MainActivity.this, LayoutActivity.class);
        startActivity(intent);
    }

    public void goItems(View v){
        Intent intent = new Intent(MainActivity.this, ItemsActivity.class);
        startActivity(intent);
    }

    public void goSaveItems(View v){
        Intent intent = new Intent(MainActivity.this, SaveItemsActivity.class);
        startActivity(intent);
    }
}
