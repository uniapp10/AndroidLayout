package mine.com.FourItems.ContentProvider;

import android.content.Context;
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
 * Created by zhudongdong on 2018/1/4.
 */

public class ContactsAdapter extends ArrayAdapter<ContactItem> {

    private int resourceId;
    public ContactsAdapter(Context context, int resourceId, List<ContactItem> list){
       super(context, resourceId, list);
        resourceId = resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(this.getContext()).inflate(R.layout.item_contentprovider, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.nameTextView = (TextView)view.findViewById(R.id.name_text);
            viewHolder.numberTextView = (TextView)view.findViewById(R.id.number_text);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        ContactItem contactItem = getItem(position);
        viewHolder.nameTextView.setText(contactItem.getName());
        viewHolder.numberTextView.setText(contactItem.getNumber());

        return view;
    }

    class ViewHolder{
        TextView nameTextView;
        TextView numberTextView;
    }
}
