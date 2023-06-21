package com.example.budgetmanager.ui.settingtab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.budgetmanager.R;
import com.example.budgetmanager.ui.settingtab.adapter.CustomListAdapter;
//import com.example.budgetmanager.ui.settingtab.model.EditFragment;
import com.example.budgetmanager.ui.settingtab.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class DanhFragment extends Fragment {

    private ListView listView;
    private List<ListItem> itemList;

    public DanhFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_danh, container, false);

        // Initialize the ListView
        listView = root.findViewById(R.id.listView);

        // Create a list of items with icons and text
        itemList = new ArrayList<>();
        itemList.add(new ListItem("Đồ Ăn & Thức Uống", R.drawable.icon1));
        itemList.add(new ListItem("Du Lịch", R.drawable.icon2));
        itemList.add(new ListItem("Mua Sắm", R.drawable.icon3));
        itemList.add(new ListItem("Nhà", R.drawable.icon4));
        itemList.add(new ListItem("Đi Lại", R.drawable.icon5));
        itemList.add(new ListItem("Lương", R.drawable.icon6));
        itemList.add(new ListItem("Khác", R.drawable.icon7));

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

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ListItem selectedItem = itemList.get(position);
//
//                EditFragment editFragment = new EditFragment();
//                Bundle args = new Bundle();
//                // Pass any necessary data to the EditFragment using arguments
//                editFragment.setArguments(args);
//
//                requireActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_container, editFragment)
//                        .addToBackStack(null)
//                        .commit();
//            }
//        });

        return root;
    }
}

