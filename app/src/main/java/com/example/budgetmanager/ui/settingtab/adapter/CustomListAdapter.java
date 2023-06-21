package com.example.budgetmanager.ui.settingtab.adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.budgetmanager.R;
import com.example.budgetmanager.ui.settingtab.model.ListItem;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<ListItem> {

    public CustomListAdapter(Context context, List<ListItem> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_custom, parent, false);
        }

        ListItem currentItem = getItem(position);

        // Set the icon
        ImageView iconImageView = itemView.findViewById(R.id.imageViewIcon);
        iconImageView.setImageResource(currentItem.getIcon());

        // Set the text
        TextView nameTextView = itemView.findViewById(R.id.textViewName);
        nameTextView.setText(currentItem.getName());

        return itemView;
    }
}

