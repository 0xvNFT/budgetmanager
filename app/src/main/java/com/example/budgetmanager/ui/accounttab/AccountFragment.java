package com.example.budgetmanager.ui.accounttab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.budgetmanager.R;


public class AccountFragment extends Fragment {

    private AccountViewModel accountViewModel;
    private AppCompatButton rectangle1;
    private AppCompatButton rectangle2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountViewModel = new ViewModelProvider(this).get(AccountViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_account, container, false);


        rectangle1 = root.findViewById(R.id.fsbtn);
        rectangle2 = root.findViewById(R.id.scndbtn);

        rectangle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountViewModel.onRectangle1Clicked(v);
            }
        });

        rectangle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountViewModel.onRectangle2Clicked(v);
            }
        });

        accountViewModel.getRectangle1ClickedLiveData().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    accountViewModel.resetRectangle1Clicked();
                }
            }
        });

        accountViewModel.getRectangle2ClickedLiveData().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    accountViewModel.resetRectangle2Clicked();
                }
            }
        });

        return root;
    }
}