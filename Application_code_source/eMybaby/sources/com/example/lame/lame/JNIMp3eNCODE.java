package com.example.lame.lame;

import okhttp3.internal.platform.AndroidPlatform;

public class JNIMp3eNCODE {

    /* renamed from: a  reason: collision with root package name */
    public int f4158a = 1;

    /* renamed from: b  reason: collision with root package name */
    public int f4159b = AndroidPlatform.MAX_LOG_LENGTH;

    /* renamed from: c  reason: collision with root package name */
    public int f4160c = 8;

    /* renamed from: d  reason: collision with root package name */
    public int f4161d = 3;

    /* renamed from: e  reason: collision with root package name */
    public int f4162e = 5;

    static {
        System.loadLibrary("mp3lame");
    }

    public native void destroy();

    public native void encode(short[] sArr, int i);

    public final native void init(int i, int i2, int i3, int i4, int i5, String str);
}
