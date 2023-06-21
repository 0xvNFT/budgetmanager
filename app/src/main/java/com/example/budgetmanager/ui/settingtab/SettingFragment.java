package com.example.budgetmanager.ui.settingtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.budgetmanager.R;

public class SettingFragment extends Fragment {

    private SettingViewModel settingViewModel;
    private ImageView danh;
    private ImageView giao;
    private ImageView thong;
    private ImageView mac;
    private ImageView cong;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingViewModel = new ViewModelProvider(this).get(SettingViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_setting, container, false);

        danh = root.findViewById(R.id.danh);
        giao = root.findViewById(R.id.giao);
        thong = root.findViewById(R.id.thong);
        mac = root.findViewById(R.id.mac);
        cong = root.findViewById(R.id.cong);

        danh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingViewModel.onDanhClicked(v);
            }
        });

        giao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingViewModel.onGiaoClicked(v);
            }
        });

        thong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingViewModel.onThongClicked(v);
            }
        });

        mac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingViewModel.onMacClicked(v);
            }
        });

        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingViewModel.onCongClicked(v);
            }
        });

        settingViewModel.getDanhClickedLiveData().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    settingViewModel.resetDanhClicked();
                }
            }
        });

        settingViewModel.getGiaoClickedLiveData().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    settingViewModel.resetGiaoClicked();
                }
            }
        });

        settingViewModel.getThongClickedLiveData().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    settingViewModel.resetThongClicked();
                }
            }
        });

        settingViewModel.getMacClickedLiveData().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    settingViewModel.resetMacClicked();
                }
            }
        });

        settingViewModel.getCongClickedLiveData().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean clicked) {
                if (clicked) {
                    settingViewModel.resetCongClicked();
                }
            }
        });
        return root;
    }
}