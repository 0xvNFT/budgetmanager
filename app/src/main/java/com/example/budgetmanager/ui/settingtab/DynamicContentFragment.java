//package com.example.budgetmanager.ui.settingtab;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.budgetmanager.R;
//
//
//public class DynamicContentFragment extends Fragment {
//
//    private TextView textViewStaticLabel;
//    private EditText editTextDynamicAmount;
//    private Button buttonSave;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View root = inflater.inflate(R.layout.layout_dynamic_content, container, false);
//
//        TextView textViewDynamicTitle = root.findViewById(R.id.textViewDynamicTitle);
//        TextView textViewStaticDescription = root.findViewById(R.id.textViewStaticDescription);
//        textViewStaticLabel = root.findViewById(R.id.textViewStaticLabel);
//        editTextDynamicAmount = root.findViewById(R.id.editTextDynamicAmount);
//        buttonSave = root.findViewById(R.id.buttonSave);
//
//        // Retrieve the data passed from the previous fragment
//        Bundle args = getArguments();
//        if (args != null) {
//            String itemText = args.getString("itemText");
//            int itemIcon = args.getInt("itemIcon");
//
//            // Set the static text
//            textViewDynamicTitle.setText("Khác");
//            textViewStaticDescription.setText("Lưu trữ số tiền chi tiêu của bạn hàng ngày, để quản lý dễ dàng hơn");
//            textViewStaticLabel.setText("Số Tiền Chi Tiêu");
//            // Set the dynamic text
//            editTextDynamicAmount.setHint("Nhập Vào Đây");
//            buttonSave.setText("Lưu Lại");
//
//            // Add click listeners or any other logic for the dynamic elements
//            buttonSave.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String amount = editTextDynamicAmount.getText().toString();
//                    // Perform your desired action with the entered amount
//                }
//            });
//        }
//
//        return root;
//    }
//}