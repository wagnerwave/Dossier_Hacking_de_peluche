package com.tuya.smart.android.mvp.view;

public interface IView {
    void finishActivity();

    void hideLoading();

    void showLoading();

    void showLoading(int i);

    void showToast(int i);

    void showToast(String str);
}
