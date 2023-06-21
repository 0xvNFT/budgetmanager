//package com.example.budgetmanager.ui.settingtab;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.budgetmanager.R;
//
//
//public class DanhListFragment extends Fragment {
//
//    private ImageView itemIconImageView;
//    private TextView itemTextView;
//
//    private String itemText;
//    private int itemIcon;
//
//    public DanhListFragment() {
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // Retrieve the selected item's data from the arguments bundle
//        Bundle args = getArguments();
//        if (args != null) {
//            itemText = args.getString("itemText");
//            itemIcon = args.getInt("itemIcon");
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View root = inflater.inflate(R.layout.fragment_danh_list, container, false);
//
//        // Get the references to the layout elements
//        itemIconImageView = root.findViewById(R.id.imageViewItemIcon);
//        itemTextView = root.findViewById(R.id.textViewItemText);
//
//        // Update the layout elements with the selected item's data
//        itemTextView.setText(itemText);
//        itemIconImageView.setImageResource(itemIcon);
//
//        return root;
//    }
//}