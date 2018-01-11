package mine.com.SaveItems;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mine.R;

/**
 * Created by zhudongdong on 2018/1/10.
 */

public class SaveItemsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_save);

    }

    public void goSharedPreference(View v){
        Intent intent = new Intent(SaveItemsActivity.this, SharedPreferenceActivity.class);
        startActivity(intent);
    }

    public void goFile(View v){
        Intent intent = new Intent(SaveItemsActivity.this, SaveToFileActivity.class);
        startActivity(intent);
    }

    public void goSqlite(View v){
        Intent intent = new Intent(SaveItemsActivity.this, SaveToSqliteActivity.class);
        startActivity(intent);
    }

    public void goNet(View v){
        Intent intent = new Intent(SaveItemsActivity.this, SaveNetActivity.class);
        startActivity(intent);
    }
}
