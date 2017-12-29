package mine.com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mine.R;

/**
 * Created by zhudongdong on 2017/12/28.
 */

public class MineAdapter extends ArrayAdapter <MineItem>{
    private int resourceId;
    public MineAdapter(Context context, int textResourceId, List<MineItem> items){
        super(context, textResourceId, items);
        resourceId = textResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MineItem item = getItem(position);
        View view;
        ViewHolder viewHolder;

        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.leftImage = (ImageView)view.findViewById(R.id.icon_left);
            viewHolder.titleView = (TextView)view.findViewById(R.id.title_mine);
            viewHolder.rightImage = (ImageView)view.findViewById(R.id.icon_right);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        int leftIconId = this.getContext().getResources().getIdentifier(item.getImageName(), "mipmap", this.getContext().getPackageName());
        viewHolder.leftImage.setImageResource(leftIconId);
        viewHolder.rightImage.setImageResource(R.mipmap.arrow_right);
        viewHolder.titleView.setText(item.getTitleName());
        return view;
    }

    class ViewHolder{
        ImageView leftImage;
        TextView titleView;
        ImageView rightImage;
    }
}
