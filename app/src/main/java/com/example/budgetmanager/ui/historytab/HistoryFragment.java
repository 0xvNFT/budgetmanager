package com.example.budgetmanager.ui.historytab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.budgetmanager.R;
import com.example.budgetmanager.ui.settingtab.EditTextActivity;
import com.example.budgetmanager.ui.settingtab.adapter.CustomListAdapter;
import com.example.budgetmanager.ui.settingtab.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {

    private ListView listView;
    private List<ListItem> itemList;

    public HistoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_history, container, false);

        // Initialize the ListView
        listView = root.findViewById(R.id.listView);

        // Create a list of items with icons and text
        itemList = new ArrayList<>();
        itemList.add(new ListItem("                                        1.015.215đ", R.drawable.tien));
        itemList.add(new ListItem("                                          981.348đ", R.drawable.tien));
        itemList.add(new ListItem("                                          920.193đ", R.drawable.tien));
        itemList.add(new ListItem("                                          869.451đ", R.drawable.tien));
        itemList.add(new ListItem("                                          811.756đ", R.drawable.tien));
        itemList.add(new ListItem("                                          751.918đ", R.drawable.tien));
        itemList.add(new ListItem("                                          682.476đ", R.drawable.tien));
        itemList.add(new ListItem("                                          600.120đ", R.drawable.tien));
        itemList.add(new ListItem("                                          511.400đ", R.drawable.tien));
        itemList.add(new ListItem("                                          404.770đ", R.drawable.tien));
        itemList.add(new ListItem("                                          301.550đ", R.drawable.tien));
        itemList.add(new ListItem("                                          203.641đ", R.drawable.tien));
        itemList.add(new ListItem("                                          100.557đ", R.drawable.tien));
        itemList.add(new ListItem("                                            5.815đ", R.drawable.tien));
        itemList.add(new ListItem("                                            1.890đ", R.drawable.tien));



        // Create the custom adapter and set it to the ListView
        CustomListAdapter adapter = new CustomListAdapter(requireContext(), itemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item from the adapter
                ListItem selectedItem = itemList.get(position);

                // Launch the EditTextActivity and pass the selected item's data
                Intent intent = new Intent(requireContext(), EditTextActivity.class);
                intent.putExtra("itemText", selectedItem.getName());
                intent.putExtra("itemIcon", selectedItem.getIcon());
                startActivity(intent);
            }
        });

        return root;
    }
}