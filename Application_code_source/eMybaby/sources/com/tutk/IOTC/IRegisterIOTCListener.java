package com.tutk.IOTC;

import android.graphics.Bitmap;

public interface IRegisterIOTCListener {
    void receiveChannelInfo(Camera camera, int i, int i2);

    void receiveFrameData(Camera camera, int i, Bitmap bitmap);

    void receiveFrameInfo(Camera camera, int i, long j, int i2, int i3, int i4, int i5);

    void receiveIOCtrlData(Camera camera, int i, int i2, byte[] bArr);

    void receiveSessionInfo(Camera camera, int i);
}
