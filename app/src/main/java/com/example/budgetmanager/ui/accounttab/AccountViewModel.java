package com.example.budgetmanager.ui.accounttab;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.budgetmanager.R;

public class AccountViewModel extends ViewModel {
    private MutableLiveData<Boolean> rectangle1ClickedLiveData;
    private MutableLiveData<Boolean> rectangle2ClickedLiveData;
    private MutableLiveData<Boolean> goalbtnClickedLiveData;

    public AccountViewModel() {
        rectangle1ClickedLiveData = new MutableLiveData<>();
        rectangle2ClickedLiveData = new MutableLiveData<>();
        goalbtnClickedLiveData = new MutableLiveData<>();
    }

    public LiveData<Boolean> getRectangle1ClickedLiveData() {
        return rectangle1ClickedLiveData;
    }
    public LiveData<Boolean> getRectangle2ClickedLiveData() {
        return rectangle2ClickedLiveData;
    }
    public LiveData<Boolean> getGrpbtnClickedLiveData() {
        return goalbtnClickedLiveData;
    }

    public void onRectangle1Clicked() {
        rectangle1ClickedLiveData.postValue(true);
    }
    public void onRectangle2Clicked() {
        rectangle2ClickedLiveData.postValue(true);
    }
    public void onGoalbtnClicked(View v) {
        rectangle2ClickedLiveData.postValue(true);
    }
    public void resetRectangle1Clicked() {
        rectangle1ClickedLiveData.postValue(false);
    }
    public void resetRectangle2Clicked() {
        rectangle2ClickedLiveData.postValue(false);
    }
    public void resetGoalbtnClicked() {
        rectangle2ClickedLiveData.postValue(false);
    }

    public void onRectangle1Clicked(View view) {

        Navigation.findNavController(view).navigate(R.id.ngayoneFragment);
    }

    public void onRectangle2Clicked(View view) {
        Navigation.findNavController(view).navigate(R.id.ngaytwoFragment);
    }
}