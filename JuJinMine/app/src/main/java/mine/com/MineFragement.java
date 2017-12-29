package mine.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import mine.R;

/**
 * Created by zhudongdong on 2017/12/28.
 */

public class MineFragement extends Fragment{
    private List<MineItem> itemsList = new ArrayList<>();
//private List<MineItem> itemsList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mine, container, false);
        ImageView imageView = v.findViewById(R.id.mine_topImage);
        imageView.setImageResource(R.mipmap.top_bg);

        ImageView iconView = v.findViewById(R.id.mine_iconImage);
        iconView.setImageResource(R.mipmap.person);

        initItems();
        MineAdapter mineAdapter = new MineAdapter(this.getContext(), R.layout.item_mine, itemsList);
        ListView listView = (ListView)v.findViewById(R.id.item_list);
        listView.setAdapter(mineAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MineItem item = itemsList.get(position);
                Toast.makeText(getContext(), item.getTitleName(), Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    private static final String TAG = "MineFragement";
    private void initItems() {
        String itemsString = LocalJsonUtils.getJson(this.getContext(), "MineSetting.json");
        try {
            JSONArray jsonArray = new JSONArray(itemsString);
            for (int i = 0; i < jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String imageName = jsonObject.getString("imageName");
                String titleName = jsonObject.getString("titleName");
                MineItem mineItem = new MineItem(imageName, titleName);
                itemsList.add(mineItem);
            }
//            Log.e(TAG, "initItems:" + jsonArray.length());
        }catch (Exception e){
            e.printStackTrace();
        }

//        Gson gson = new Gson();
//        List<MineItem> items = gson.fromJson(itemsString, new TypeToken<List<MineItem>>(){}.getType());

//        for (int i = 0; i < 2; i++){
//            MineItem item = new MineItem("left_icon", "Setting");
//            itemsList.add(item);
//        }
    }

//    @Override
//    public void onClick(View v) {
//        v
//    }
}
