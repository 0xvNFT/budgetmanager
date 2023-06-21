package com.example.budgetmanager.ui.accounttab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.budgetmanager.R;
import com.example.budgetmanager.ui.accounttab.Category1Fragment;

public class NgayoneFragment extends Fragment implements View.OnClickListener {

    private AppCompatButton category1;
    private AppCompatButton category2;
    private AppCompatButton category3;
    private AppCompatButton category4;

    public NgayoneFragment() {
    }

    public static NgayoneFragment newInstance() {
        return new NgayoneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ngayone, container, false);

        category1 = root.findViewById(R.id.category1);
        category2 = root.findViewById(R.id.category2);
        category3 = root.findViewById(R.id.category3);
        category4 = root.findViewById(R.id.category4);

        category1.setOnClickListener(this);
        category2.setOnClickListener(this);
        category3.setOnClickListener(this);
        category4.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (v.getId() == R.id.category1) {
            Fragment fragment1 = new Category1Fragment();
            fragmentTransaction.replace(R.id.fragment_container, fragment1);
        } else if (v.getId() == R.id.category2) {
            Fragment fragment2 = new Category2Fragment();
            fragmentTransaction.replace(R.id.fragment_container, fragment2);
        } else if (v.getId() == R.id.category3) {
            Fragment fragment3 = new Category3Fragment();
            fragmentTransaction.replace(R.id.fragment_container, fragment3);
        } else if (v.getId() == R.id.category4) {
            Fragment fragment4 = new Category4Fragment();
            fragmentTransaction.replace(R.id.fragment_container, fragment4);
        }

        fragmentTransaction.commit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        category1.performClick();
    }
}