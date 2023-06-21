package com.example.budgetmanager.ui.accounttab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import com.example.budgetmanager.R;

public class Category1Fragment extends Fragment {

    public Category1Fragment() {
    }

    public static Category1Fragment newInstance() {
        return new Category1Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category1, container, false);
    }
}