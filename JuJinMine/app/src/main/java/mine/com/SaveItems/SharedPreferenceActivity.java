package mine.com.SaveItems;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mine.R;

/**
 * Created by zhudongdong on 2018/1/10.
 */

public class SharedPreferenceActivity extends AppCompatActivity {

    EditText userText;
    EditText pwdText;
    TextView resTextView;
    public static final String ACCOUNT = "account";
    public static final String PASSWORD = "password";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_save_shared);

        userText = (EditText)findViewById(R.id.editText_usr);
        pwdText = (EditText)findViewById(R.id.editText_pwd);
        resTextView = (TextView)findViewById(R.id.textView_usrAndPwd);
    }

    public void saveData(View v){
        sharedPreferences = getSharedPreferences("UserInfo", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String usrStr = userText.getText().toString();
        String pwdStr = pwdText.getText().toString();
        if (usrStr.length() > 0 && pwdStr.length() > 0){
            editor.putString(ACCOUNT, usrStr);
            editor.putString(PASSWORD, pwdStr);
            editor.commit();
            Toast.makeText(this, "存储成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "用户名或密码为空", Toast.LENGTH_SHORT).show();
        }
    }

    public void readData(View v){
        String str = sharedPreferences.getString(ACCOUNT, "为空") + "   " + sharedPreferences.getString(PASSWORD, "为空");
        resTextView.setText(str);
    }

}
