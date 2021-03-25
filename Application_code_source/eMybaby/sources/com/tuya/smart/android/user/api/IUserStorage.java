package com.tuya.smart.android.user.api;

import com.tuya.smart.android.user.bean.User;

public interface IUserStorage {
    User load();

    boolean remove();

    boolean store(User user);
}
