package com.example.budgetmanager.ui.accounttab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import com.example.budgetmanager.R;

public class Category2Fragment extends Fragment {

    public Category2Fragment() {
    }

    public static Category2Fragment newInstance() {
        return new Category2Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category2, container, false);
    }
}