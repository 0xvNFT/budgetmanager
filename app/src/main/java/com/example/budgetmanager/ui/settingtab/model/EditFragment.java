//package com.example.budgetmanager.ui.settingtab.model;
//
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//
//import com.example.budgetmanager.R;
//
//public class EditFragment extends Fragment {
//
//    public EditFragment() {
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_edit, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        // Retrieve the arguments passed from DanhFragment
//        Bundle args = getArguments();
//        if (args != null) {
//            String itemText = args.getString("itemText");
//            // Update the necessary views in the EditFragment using the itemText
//        }
//
//        // Find and set up the necessary views and their functionality, such as EditText and Save button
//        EditText editText = view.findViewById(R.id.editText);
//        Button saveButton = view.findViewById(R.id.saveButton);
//
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle the save button click here
//                String inputText = editText.getText().toString();
//                // Perform any necessary actions with the input text
//            }
//        });
//    }
//}