package mine.com.SaveItems;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import mine.R;

/**
 * Created by zhudongdong on 2018/1/11.
 */

public class SaveItemAdapter extends ArrayAdapter<SaveBookItem> {


    private int resourceId;

    public SaveItemAdapter(@NonNull Context context, @LayoutRes int resource, List<SaveBookItem> list) {
        super(context, resource, list);
        resourceId = resource;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v;
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            v = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder.nameTextView = (TextView)v.findViewById(R.id.book_name);
            viewHolder.authorTextView = (TextView)v.findViewById(R.id.book_author);
            v.setTag(viewHolder);
        }else {
            v = convertView;
            viewHolder = (ViewHolder)v.getTag();
        }
        SaveBookItem bookItem = getItem(position);
        viewHolder.nameTextView.setText(bookItem.getName());
        viewHolder.authorTextView.setText(bookItem.getAuthor());
        return v;
    }

    class ViewHolder{
        TextView nameTextView;
        TextView authorTextView;
    }

}
