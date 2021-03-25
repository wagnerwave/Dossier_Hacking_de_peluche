package com.tuya.smart.mmkv;

import a.a.a.a.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MMKV implements SharedPreferences, SharedPreferences.Editor {
    public static final int ASHMEM_MODE = 4;
    public static final int MULTI_PROCESS_MODE = 2;
    public static final int SINGLE_PROCESS_MODE = 1;
    public static MMKVHandler gCallbackHandler;
    public static EnumMap<MMKVRecoverStrategic, Integer> recoverIndex;
    public static String rootDir = null;
    public long nativeHandle;

    static {
        EnumMap<MMKVRecoverStrategic, Integer> enumMap = new EnumMap<>(MMKVRecoverStrategic.class);
        recoverIndex = enumMap;
        int i = 0;
        enumMap.put(MMKVRecoverStrategic.OnErrorDiscard, 0);
        recoverIndex.put(MMKVRecoverStrategic.OnErrorRecover, 1);
        while (i < 3) {
            try {
                System.loadLibrary("c++_shared");
                System.loadLibrary("tuyammkv");
                break;
            } catch (Exception unused) {
                i++;
            }
        }
    }

    public MMKV(long j) {
        this.nativeHandle = j;
    }

    private native boolean containsKey(long j, String str);

    private native long count(long j);

    private native boolean decodeBool(long j, String str, boolean z);

    private native byte[] decodeBytes(long j, String str);

    private native double decodeDouble(long j, String str, double d2);

    private native float decodeFloat(long j, String str, float f);

    private native int decodeInt(long j, String str, int i);

    private native long decodeLong(long j, String str, long j2);

    private native String decodeString(long j, String str, String str2);

    private native String[] decodeStringSet(long j, String str);

    public static MMKV defaultMMKV() {
        if (rootDir != null) {
            return new MMKV(getDefaultMMKV(1, (String) null));
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV defaultMMKV(int i, String str) {
        if (rootDir != null) {
            return new MMKV(getDefaultMMKV(i, str));
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private native boolean encodeBool(long j, String str, boolean z);

    private native boolean encodeBytes(long j, String str, byte[] bArr);

    private native boolean encodeDouble(long j, String str, double d2);

    private native boolean encodeFloat(long j, String str, float f);

    private native boolean encodeInt(long j, String str, int i);

    private native boolean encodeLong(long j, String str, long j2);

    private native boolean encodeSet(long j, String str, String[] strArr);

    private native boolean encodeString(long j, String str, String str2);

    public static native long getDefaultMMKV(int i, String str);

    public static native long getMMKVWithAshmemFD(String str, int i, int i2, String str2);

    public static native long getMMKVWithID(String str, int i, String str2);

    public static native long getMMKVWithIDAndSize(String str, int i, int i2, String str2);

    public static String initialize(Context context) {
        String m = a.m(new StringBuilder(), context.getApplicationInfo().dataDir, "/files/tuyammkv");
        rootDir = m;
        initialize(m);
        return rootDir;
    }

    public static native void initialize(String str);

    public static native boolean isFileValid(String str);

    public static MMKV mmkvWithAshmemFD(String str, int i, int i2, String str2) {
        return new MMKV(getMMKVWithAshmemFD(str, i, i2, str2));
    }

    @Nullable
    public static MMKV mmkvWithAshmemID(Context context, String str, int i, int i2, String str2) {
        String str3;
        if (rootDir != null) {
            String processNameByPID = MMKVContentProvider.getProcessNameByPID(context, Process.myPid());
            if (processNameByPID == null || processNameByPID.length() == 0) {
                str3 = "process name detect fail, try again later";
            } else if (processNameByPID.contains(":")) {
                Uri contentUri = MMKVContentProvider.contentUri(context);
                if (contentUri == null) {
                    str3 = "MMKVContentProvider has invalid authority";
                } else {
                    Log.i("MMKV", "getting parcelable mmkv in process, Uri = " + contentUri);
                    Bundle bundle = new Bundle();
                    bundle.putInt(MMKVContentProvider.KEY_SIZE, i);
                    bundle.putInt(MMKVContentProvider.KEY_MODE, i2);
                    if (str2 != null) {
                        bundle.putString(MMKVContentProvider.KEY_CRYPT, str2);
                    }
                    Bundle call = context.getContentResolver().call(contentUri, MMKVContentProvider.FUNCTION_NAME, str, bundle);
                    if (call != null) {
                        call.setClassLoader(ParcelableMMKV.class.getClassLoader());
                        ParcelableMMKV parcelableMMKV = (ParcelableMMKV) call.getParcelable(MMKVContentProvider.KEY);
                        if (parcelableMMKV != null) {
                            MMKV mmkv = parcelableMMKV.toMMKV();
                            if (mmkv != null) {
                                Log.i("MMKV", mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                            }
                            return mmkv;
                        }
                    }
                    return null;
                }
            } else {
                Log.i("MMKV", "getting mmkv in main process");
                return new MMKV(getMMKVWithIDAndSize(str, i, i2 | 4, str2));
            }
            Log.e("MMKV", str3);
            return null;
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV mmkvWithID(String str) {
        if (rootDir != null) {
            return new MMKV(getMMKVWithID(str, 1, (String) null));
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV mmkvWithID(String str, int i) {
        if (rootDir != null) {
            return new MMKV(getMMKVWithID(str, i, (String) null));
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV mmkvWithID(String str, int i, String str2) {
        if (rootDir != null) {
            return new MMKV(getMMKVWithID(str, i, str2));
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static native void onExit();

    public static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategic = mMKVHandler.onMMKVCRCCheckFail(str);
        }
        Log.i("MMKV", "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        return recoverIndex.get(mMKVRecoverStrategic).intValue();
    }

    public static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategic = mMKVHandler.onMMKVFileLengthError(str);
        }
        Log.i("MMKV", "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        return recoverIndex.get(mMKVRecoverStrategic).intValue();
    }

    public static native int pageSize();

    public static void registerHandler(MMKVHandler mMKVHandler) {
        gCallbackHandler = mMKVHandler;
    }

    private native void removeValueForKey(long j, String str);

    private native long totalSize(long j);

    public static void unregisterHandler() {
        gCallbackHandler = null;
    }

    public native String[] allKeys();

    public void apply() {
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public native void checkReSetCryptKey(String str);

    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    public boolean commit() {
        sync();
        return true;
    }

    public boolean contains(String str) {
        return containsKey(str);
    }

    public boolean containsKey(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public long count() {
        return count(this.nativeHandle);
    }

    public native String cryptKey();

    public boolean decodeBool(String str) {
        return decodeBool(this.nativeHandle, str, false);
    }

    public boolean decodeBool(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public byte[] decodeBytes(String str) {
        return decodeBytes(this.nativeHandle, str);
    }

    public double decodeDouble(String str) {
        return decodeDouble(this.nativeHandle, str, 0.0d);
    }

    public double decodeDouble(String str, double d2) {
        return decodeDouble(this.nativeHandle, str, d2);
    }

    public float decodeFloat(String str) {
        return decodeFloat(this.nativeHandle, str, 0.0f);
    }

    public float decodeFloat(String str, float f) {
        return decodeFloat(this.nativeHandle, str, f);
    }

    public int decodeInt(String str) {
        return decodeInt(this.nativeHandle, str, 0);
    }

    public int decodeInt(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    public long decodeLong(String str) {
        return decodeLong(this.nativeHandle, str, 0);
    }

    public long decodeLong(String str, long j) {
        return decodeLong(this.nativeHandle, str, j);
    }

    public String decodeString(String str) {
        return decodeString(this.nativeHandle, str, (String) null);
    }

    public String decodeString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public Set<String> decodeStringSet(String str) {
        return decodeStringSet(str, (Set<String>) null);
    }

    public Set<String> decodeStringSet(String str, Set<String> set) {
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        return decodeStringSet == null ? set : new HashSet(Arrays.asList(decodeStringSet));
    }

    public SharedPreferences.Editor edit() {
        return this;
    }

    public boolean encode(String str, double d2) {
        return encodeDouble(this.nativeHandle, str, d2);
    }

    public boolean encode(String str, float f) {
        return encodeFloat(this.nativeHandle, str, f);
    }

    public boolean encode(String str, int i) {
        return encodeInt(this.nativeHandle, str, i);
    }

    public boolean encode(String str, long j) {
        return encodeLong(this.nativeHandle, str, j);
    }

    public boolean encode(String str, String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public boolean encode(String str, Set<String> set) {
        return encodeSet(this.nativeHandle, str, (String[]) set.toArray(new String[set.size()]));
    }

    public boolean encode(String str, boolean z) {
        return encodeBool(this.nativeHandle, str, z);
    }

    public boolean encode(String str, byte[] bArr) {
        return encodeBytes(this.nativeHandle, str, bArr);
    }

    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    public boolean getBoolean(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public float getFloat(String str, float f) {
        return decodeFloat(this.nativeHandle, str, f);
    }

    public int getInt(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    public long getLong(String str, long j) {
        return decodeLong(this.nativeHandle, str, j);
    }

    @Nullable
    public String getString(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return decodeStringSet(str, set);
    }

    public int importFromSharedPreferences(SharedPreferences sharedPreferences) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null || all.size() <= 0) {
            return 0;
        }
        for (Map.Entry next : all.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (!(str == null || value == null)) {
                if (value instanceof Boolean) {
                    encodeBool(this.nativeHandle, str, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    encodeInt(this.nativeHandle, str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    encodeLong(this.nativeHandle, str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    encodeFloat(this.nativeHandle, str, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    encodeDouble(this.nativeHandle, str, ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    encodeString(this.nativeHandle, str, (String) value);
                } else if (value instanceof Set) {
                    encode(str, (Set<String>) (Set) value);
                } else {
                    StringBuilder n = a.n("unknown type: ");
                    n.append(value.getClass());
                    Log.e("MMKV", n.toString());
                }
            }
        }
        return all.size();
    }

    public native void lock();

    public native String mmapID();

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        encodeBool(this.nativeHandle, str, z);
        return this;
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        encodeFloat(this.nativeHandle, str, f);
        return this;
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        encodeInt(this.nativeHandle, str, i);
        return this;
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        encodeLong(this.nativeHandle, str, j);
        return this;
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        encode(str, set);
        return this;
    }

    public native boolean reKey(String str);

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public SharedPreferences.Editor remove(String str) {
        removeValueForKey(str);
        return this;
    }

    public void removeValueForKey(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    public native void removeValuesForKeys(String[] strArr);

    public native void sync();

    public long totalSize() {
        return totalSize(this.nativeHandle);
    }

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }
}
