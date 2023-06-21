package com.example.budgetmanager.ui.settingtab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.budgetmanager.R;
import com.example.budgetmanager.ui.settingtab.adapter.CustomListAdapter;
import com.example.budgetmanager.ui.settingtab.model.ListItem;

import java.util.ArrayList;
import java.util.List;


public class MacFragment extends Fragment {

    private ListView listViewMac;
    private List<ListItem> itemListMac;

    public MacFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mac, container, false);

        // Initialize the ListView
        listViewMac = root.findViewById(R.id.listViewMac);

        // Create a list of items with icons and text
        itemListMac = new ArrayList<>();
        itemListMac.add(new ListItem("Philippine PHP", R.drawable.phil));
        itemListMac.add(new ListItem("Rúp Nga RUB", R.drawable.russia));
        itemListMac.add(new ListItem("Việt Nam Đồng VND", R.drawable.vieet));
        itemListMac.add(new ListItem("Hàn Quốc KRN", R.drawable.korea));
        itemListMac.add(new ListItem("U-ru-goay UYU", R.drawable.urag));
        itemListMac.add(new ListItem("Campuchia RIEL", R.drawable.khea));
        itemListMac.add(new ListItem("Yên Nhật JPY", R.drawable.japan));
        itemListMac.add(new ListItem("Đô la Mỹ USD", R.drawable.uniteds));

        // Create the custom adapter and set it to the ListView
        CustomListAdapter adapter = new CustomListAdapter(requireContext(), itemListMac);
        listViewMac.setAdapter(adapter);

        listViewMac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item from the adapter
                ListItem selectedItem = itemListMac.get(position);

                // Launch the EditTextActivity and pass the selected item's data
                Intent intent = new Intent(requireContext(), EditTextActivity.class);
                intent.putExtra("", selectedItem.getName());
                intent.putExtra("", selectedItem.getIcon());
                startActivity(intent);
            }
        });
        return root;
    }
}