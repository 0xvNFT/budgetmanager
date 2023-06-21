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

public class NgaytwoFragment extends Fragment implements View.OnClickListener {

    private AppCompatButton category11;
    private AppCompatButton category12;
    private AppCompatButton category13;
    private AppCompatButton category14;

    public NgaytwoFragment() {
    }

    public static NgayoneFragment newInstance() {
        return new NgayoneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ngaytwo, container, false);

        category11 = root.findViewById(R.id.category11);
        category12 = root.findViewById(R.id.category12);
        category13 = root.findViewById(R.id.category13);
        category14 = root.findViewById(R.id.category14);

        category11.setOnClickListener(this);
        category12.setOnClickListener(this);
        category13.setOnClickListener(this);
        category14.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (v.getId() == R.id.category11) {
            Fragment fragment1 = new Category1Fragment();
            fragmentTransaction.replace(R.id.fragment_container2, fragment1);
        } else if (v.getId() == R.id.category12) {
            Fragment fragment2 = new Category2Fragment();
            fragmentTransaction.replace(R.id.fragment_container2, fragment2);
        } else if (v.getId() == R.id.category13) {
            Fragment fragment3 = new Category3Fragment();
            fragmentTransaction.replace(R.id.fragment_container2, fragment3);
        } else if (v.getId() == R.id.category14) {
            Fragment fragment4 = new Category4Fragment();
            fragmentTransaction.replace(R.id.fragment_container2, fragment4);
        }

        fragmentTransaction.commit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        category11.performClick();
    }
}