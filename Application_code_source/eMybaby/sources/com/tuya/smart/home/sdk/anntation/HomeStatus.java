package com.tuya.smart.home.sdk.anntation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface HomeStatus {
    public static final int ACCEPT = 2;
    public static final int REJECT = 3;
    public static final int WAITING = 1;
}
