package com.example.budgetmanager.ui.settingtab;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.budgetmanager.R;

public class SettingViewModel extends ViewModel {

    private final MutableLiveData<Boolean> getDanhClickedLiveData;
    private final MutableLiveData<Boolean> getGiaoClickedLiveData;
    private final MutableLiveData<Boolean> getThongClickedLiveData;
    private final MutableLiveData<Boolean> getMacClickedLiveData;
    private final MutableLiveData<Boolean> getCongClickedLiveData;

    public SettingViewModel() {
        getDanhClickedLiveData = new MutableLiveData<>();
        getGiaoClickedLiveData = new MutableLiveData<>();
        getThongClickedLiveData = new MutableLiveData<>();
        getMacClickedLiveData = new MutableLiveData<>();
        getCongClickedLiveData = new MutableLiveData<>();

    }

    public LiveData<Boolean> getDanhClickedLiveData() {
        return getDanhClickedLiveData;
    }

    public LiveData<Boolean> getGiaoClickedLiveData() {
        return getGiaoClickedLiveData;
    }

    public LiveData<Boolean> getThongClickedLiveData() {
        return getThongClickedLiveData;
    }

    public LiveData<Boolean> getMacClickedLiveData() {
        return getMacClickedLiveData;
    }

    public LiveData<Boolean> getCongClickedLiveData() {
        return getCongClickedLiveData;
    }


    public void resetDanhClicked() {
        getDanhClickedLiveData.postValue(false);
    }

    public void resetGiaoClicked() {
        getGiaoClickedLiveData.postValue(false);
    }

    public void resetThongClicked() {
        getThongClickedLiveData.postValue(false);
    }

    public void resetMacClicked() {
        getMacClickedLiveData.postValue(false);
    }

    public void resetCongClicked() {
        getCongClickedLiveData.postValue(false);
    }

    public void onDanhClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.danhFragment);
    }

    public void onGiaoClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.giaoFragment);
    }

    public void onThongClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.thongFragment);
    }

    public void onMacClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.macFragment);
    }

    public void onCongClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.congFragment);
    }

}