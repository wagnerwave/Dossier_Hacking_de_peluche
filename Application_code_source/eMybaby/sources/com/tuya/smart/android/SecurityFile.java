package com.tuya.smart.android;

public class SecurityFile {
    public long mNativePtr;

    static {
        System.loadLibrary("c++_shared");
        System.loadLibrary("tuyammkv");
    }

    public SecurityFile(String str, String str2, String str3) {
        this.mNativePtr = createSecurityFileInstance(str, str2, str3);
    }

    private native long createSecurityFileInstance(String str, String str2, String str3);

    private native String loadFormFileInternal(long j);

    private native void removeFileInternal(long j);

    private native void resetNativeInternal(long j);

    private native boolean storeToFileInternal(long j, String str);

    public void close() {
        resetNativeInternal(this.mNativePtr);
        this.mNativePtr = 0;
    }

    public String loadFromFile() {
        return loadFormFileInternal(this.mNativePtr);
    }

    public void remove() {
        removeFileInternal(this.mNativePtr);
        this.mNativePtr = 0;
    }

    public boolean storeToFile(String str) {
        return storeToFileInternal(this.mNativePtr, str);
    }
}
