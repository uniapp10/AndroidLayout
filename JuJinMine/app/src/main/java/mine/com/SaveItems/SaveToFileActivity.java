package mine.com.SaveItems;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import mine.R;

/**
 * Created by zhudongdong on 2018/1/10.
 */

public class SaveToFileActivity extends AppCompatActivity {

    EditText editText_save;
    EditText editText_read;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_save_file);

        editText_save = (EditText)findViewById(R.id.editText_saveFile);
        editText_read = (EditText)findViewById(R.id.editText_readFile);
    }

    public void saveToFile(View v){
        String res =  editText_save.getText().toString();
        if (res.length() > 0){
            BufferedWriter bufferedWriter = null;
            try {
                String fileName = "userFile.txt";
                FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                bufferedWriter.write(res);

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    if(bufferedWriter != null){
                        bufferedWriter.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            Toast.makeText(this, "数据保存成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "请输入数据", Toast.LENGTH_SHORT).show();
        }
    }

    public void readFromFile(View v){
        BufferedReader bufferedReader = null;
        try {
            String fileName = "userFile.txt";
            bufferedReader = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
            StringBuilder stringBuilder = new StringBuilder();
            String res = "";
            while ((res = bufferedReader.readLine()) != null){
                stringBuilder.append(res);
            }
            editText_read.setText(stringBuilder.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
