package vidal.sergi.getfit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/**
 * Created by alu2011187 on 20/03/2018.
 */

public class CardAdapter extends ArrayAdapter<Integer>{
    public CardAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_content);
        imageView.setImageResource(getItem(position));
        return convertView;
    }
}
