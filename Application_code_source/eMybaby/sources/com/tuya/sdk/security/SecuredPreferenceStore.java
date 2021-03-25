package com.tuya.sdk.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.tuya.sdk.security.EncryptionManager;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.oo0o0oo00;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class SecuredPreferenceStore implements SharedPreferences {
    public static final String O000000o = "VERSION";
    public static final int[] O00000Oo = {10};
    public static final String O00000o = "SecuredPreferenceStore";
    public static final String O00000o0 = "SPS_file";
    public static oo0o0oo00 O0000OOo;
    public static SecuredPreferenceStore O0000Oo0;
    public final String[] O00000oO;
    public SharedPreferences O00000oo;
    public EncryptionManager O0000O0o;

    public class MigrationFailedException extends Exception {
        public MigrationFailedException(String str, Throwable th) {
            super(str, th);
        }
    }

    public class O000000o implements SharedPreferences.Editor {
        public SharedPreferences.Editor O000000o;

        public O000000o() {
            this.O000000o = SecuredPreferenceStore.this.O00000oo.edit();
        }

        public SharedPreferences.Editor O000000o(String str, byte[] bArr) {
            return bArr != null ? putString(str, EncryptionManager.O00000o(bArr)) : remove(str);
        }

        public void apply() {
            this.O000000o.apply();
        }

        public SharedPreferences.Editor clear() {
            for (String next : SecuredPreferenceStore.this.O00000oo.getAll().keySet()) {
                if (!next.equals(SecuredPreferenceStore.O000000o) && !SecuredPreferenceStore.this.O00000o0(next)) {
                    this.O000000o.remove(next);
                }
            }
            return this;
        }

        public boolean commit() {
            return this.O000000o.commit();
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            return putString(str, Boolean.toString(z));
        }

        public SharedPreferences.Editor putFloat(String str, float f) {
            return putString(str, Float.toString(f));
        }

        public SharedPreferences.Editor putInt(String str, int i) {
            return putString(str, Integer.toString(i));
        }

        public SharedPreferences.Editor putLong(String str, long j) {
            return putString(str, Long.toString(j));
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            if (SecuredPreferenceStore.this.O00000Oo(str)) {
                L.e(SecuredPreferenceStore.O00000o, "Trying to store value for a reserved key, value: " + str2);
                return this;
            }
            try {
                this.O000000o.putString(EncryptionManager.O00000o0(str), SecuredPreferenceStore.this.O0000O0o.O000000o(str2));
            } catch (Exception e2) {
                L.e(SecuredPreferenceStore.O00000o, e2.toString());
            }
            return this;
        }

        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (SecuredPreferenceStore.this.O00000Oo(str)) {
                L.e(SecuredPreferenceStore.O00000o, "Trying to store value for a reserved key, value: " + set);
                return this;
            }
            try {
                String O00000o0 = EncryptionManager.O00000o0(str);
                HashSet hashSet = new HashSet(set.size());
                for (String O000000o2 : set) {
                    hashSet.add(SecuredPreferenceStore.this.O0000O0o.O000000o(O000000o2));
                }
                this.O000000o.putStringSet(O00000o0, hashSet);
            } catch (Exception e2) {
                L.e(SecuredPreferenceStore.O00000o, e2.toString());
            }
            return this;
        }

        public SharedPreferences.Editor remove(String str) {
            if (SecuredPreferenceStore.this.O00000Oo(str)) {
                L.e(SecuredPreferenceStore.O00000o, "Trying to remove value for a reserved key");
                return this;
            }
            try {
                this.O000000o.remove(EncryptionManager.O00000o0(str));
            } catch (Exception e2) {
                L.e(SecuredPreferenceStore.O00000o, e2.toString());
            }
            return this;
        }
    }

    public interface O00000Oo {
        boolean O000000o(Exception exc, KeyStore keyStore, List<String> list);
    }

    public class O00000o0 {
        public String O000000o;
        public String O00000Oo;
        public Context O00000o;
        public byte[] O00000o0;

        public O00000o0(Context context, String str, String str2, byte[] bArr) {
            this.O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = bArr;
            this.O00000o = context;
        }

        public void O000000o() {
            boolean z;
            SharedPreferences sharedPreferences;
            String str;
            if (this.O000000o != null || this.O00000Oo != null || this.O00000o0 != null) {
                boolean z2 = false;
                SharedPreferences sharedPreferences2 = this.O00000o.getSharedPreferences(SecuredPreferenceStore.O00000o0, 0);
                String str2 = this.O000000o;
                if (str2 == null || str2.equals(SecuredPreferenceStore.O00000o0)) {
                    sharedPreferences = sharedPreferences2;
                    z = false;
                } else {
                    sharedPreferences = this.O00000o.getSharedPreferences(this.O000000o, 0);
                    z = true;
                }
                try {
                    if (sharedPreferences.getString(EncryptionManager.O00000o0(EncryptionManager.O00000o0), (String) null) == null && (str = this.O00000Oo) != null && !str.equals(EncryptionManager.O00000o)) {
                        z2 = true;
                    }
                    if ((z || z2) && sharedPreferences2.getAll().size() > 0) {
                        try {
                            EncryptionManager encryptionManager = new EncryptionManager(this.O00000o, sharedPreferences2, (O00000Oo) null);
                            EncryptionManager encryptionManager2 = new EncryptionManager(this.O00000o, sharedPreferences, this.O00000Oo, this.O00000o0, (O00000Oo) null);
                            Map<String, ?> all = sharedPreferences2.getAll();
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            for (Map.Entry next : all.entrySet()) {
                                String str3 = (String) next.getKey();
                                if (!str3.equals(EncryptionManager.O00000o0(encryptionManager.O000000o)) && !str3.equals(EncryptionManager.O00000o0(encryptionManager.O00000oO))) {
                                    if (!str3.equals(EncryptionManager.O00000o0(encryptionManager.O00000Oo))) {
                                        if (next.getValue() != null) {
                                            if (next.getValue() instanceof Set) {
                                                HashSet hashSet = new HashSet();
                                                for (String O00000Oo2 : (Set) next.getValue()) {
                                                    hashSet.add(encryptionManager2.O000000o(encryptionManager.O00000Oo(O00000Oo2)));
                                                }
                                                edit.putStringSet(str3, hashSet);
                                            } else if (next.getValue() instanceof String) {
                                                edit.putString(str3, encryptionManager2.O000000o(encryptionManager.O00000Oo((String) next.getValue())));
                                            } else {
                                                L.e(SecuredPreferenceStore.O00000o, "Found a value that is not String or Set, key: " + str3 + ", value: " + next.getValue());
                                            }
                                        }
                                    }
                                }
                            }
                            if (edit.commit()) {
                                edit.putInt(SecuredPreferenceStore.O000000o, 10).apply();
                                O000000o(SecuredPreferenceStore.O00000o0);
                            }
                        } catch (InvalidKeyException e2) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e2);
                        } catch (UnrecoverableEntryException e3) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e3);
                        } catch (KeyStoreException e4) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e4);
                        } catch (NoSuchAlgorithmException e5) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e5);
                        } catch (NoSuchProviderException e6) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e6);
                        } catch (UnsupportedEncodingException e7) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e7);
                        } catch (InvalidAlgorithmParameterException e8) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e8);
                        } catch (EncryptionManager.InvalidMacException e9) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e9);
                        } catch (IllegalBlockSizeException e10) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e10);
                        } catch (BadPaddingException e11) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e11);
                        } catch (NoSuchPaddingException e12) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e12);
                        } catch (IOException e13) {
                            throw new MigrationFailedException("Migration to Version: 0.7.0: Encryption/Hashing Error", e13);
                        }
                    }
                } catch (NoSuchAlgorithmException e14) {
                    throw new MigrationFailedException("Migration to Version: 0.7.0: Failed to hash a key", e14);
                } catch (UnsupportedEncodingException e15) {
                    throw new MigrationFailedException("Migration to Version: 0.7.0: Failed to hash a key", e15);
                }
            }
        }

        public void O000000o(int i) {
            if (i == 10) {
                L.d(SecuredPreferenceStore.O00000o, "Migrating to: " + i);
                O000000o();
            }
        }

        public void O000000o(int i, int i2) {
            if (i < i2) {
                for (int i3 : SecuredPreferenceStore.O00000Oo) {
                    if (i < i3) {
                        O000000o(i3);
                        i = i3;
                    }
                }
                SecuredPreferenceStore.this.O00000oo.edit().putInt(SecuredPreferenceStore.O000000o, i2).apply();
            }
        }

        public void O000000o(String str) {
            SharedPreferences sharedPreferences = this.O00000o.getSharedPreferences(str, 0);
            if (sharedPreferences.getAll().size() > 0) {
                sharedPreferences.edit().clear().apply();
            }
            if (Build.VERSION.SDK_INT >= 24) {
                this.O00000o.deleteSharedPreferences(str);
                return;
            }
            try {
                new File(this.O00000o.getCacheDir().getParent() + "/shared_prefs/" + str + ActivityChooserModel.HISTORY_FILE_EXTENSION).delete();
            } catch (Exception unused) {
                L.w(SecuredPreferenceStore.O00000o, "Unable to remove store file completely");
            }
        }
    }

    public SecuredPreferenceStore(@NonNull Context context, @Nullable String str, @Nullable String str2, @Nullable byte[] bArr) {
        L.d(O00000o, "Create instancee");
        SharedPreferences sharedPreferences = context.getSharedPreferences(str == null ? O00000o0 : str, 0);
        this.O00000oo = sharedPreferences;
        sharedPreferences.getInt(O000000o, 9);
        EncryptionManager encryptionManager = new EncryptionManager(context, this.O00000oo, str2, bArr, new O00000Oo() {
            public boolean O000000o(Exception exc, KeyStore keyStore, List<String> list) {
                if (SecuredPreferenceStore.O0000OOo != null) {
                    return SecuredPreferenceStore.O0000OOo.O000000o(exc, keyStore, list, SecuredPreferenceStore.this.O00000oo);
                }
                throw new RuntimeException(exc);
            }
        });
        this.O0000O0o = encryptionManager;
        this.O00000oO = new String[]{O000000o, EncryptionManager.O00000o0, encryptionManager.O00000oO, encryptionManager.O00000Oo, encryptionManager.O000000o};
    }

    public static synchronized SecuredPreferenceStore O000000o() {
        SecuredPreferenceStore securedPreferenceStore;
        synchronized (SecuredPreferenceStore.class) {
            if (O0000Oo0 != null) {
                securedPreferenceStore = O0000Oo0;
            } else {
                throw new IllegalStateException("Must call init() before using the store");
            }
        }
        return securedPreferenceStore;
    }

    public static void O000000o(Context context, oo0o0oo00 oo0o0oo00) {
        O000000o(context, O00000o0, (String) null, (byte[]) null, oo0o0oo00);
    }

    public static void O000000o(Context context, @Nullable String str, @Nullable String str2, @Nullable byte[] bArr, oo0o0oo00 oo0o0oo00) {
        if (O0000Oo0 != null) {
            L.w(O00000o, "init called when there already is a non-null instance of the class");
            return;
        }
        O000000o(oo0o0oo00);
        O0000Oo0 = new SecuredPreferenceStore(context, str, str2, bArr);
    }

    public static void O000000o(oo0o0oo00 oo0o0oo00) {
        O0000OOo = oo0o0oo00;
    }

    /* access modifiers changed from: private */
    public boolean O00000Oo(String str) {
        return Arrays.asList(this.O00000oO).contains(str);
    }

    /* access modifiers changed from: private */
    public boolean O00000o0(String str) {
        String str2;
        String[] strArr = this.O00000oO;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                if (str.equals(EncryptionManager.O00000o0(strArr[i]))) {
                    return true;
                }
                i++;
            } catch (NoSuchAlgorithmException e2) {
                str2 = e2.toString();
                L.e(O00000o, str2);
                i++;
            } catch (UnsupportedEncodingException e3) {
                str2 = e3.toString();
                L.e(O00000o, str2);
                i++;
            }
        }
        return false;
    }

    public byte[] O000000o(String str) {
        String string = getString(str, (String) null);
        if (string != null) {
            return EncryptionManager.O00000o(string);
        }
        return null;
    }

    public EncryptionManager O00000Oo() {
        return this.O0000O0o;
    }

    /* renamed from: O00000o0 */
    public O000000o edit() {
        return new O000000o();
    }

    public boolean contains(String str) {
        try {
            return this.O00000oo.contains(EncryptionManager.O00000o0(str));
        } catch (Exception e2) {
            L.e(O00000o, e2.toString());
            return false;
        }
    }

    public Map<String, Object> getAll() {
        Map<String, ?> all = this.O00000oo.getAll();
        HashMap hashMap = new HashMap(all.size());
        if (all.size() > 0) {
            for (String next : all.keySet()) {
                if (!next.equals(O000000o) && !O00000o0(next)) {
                    try {
                        hashMap.put(next, this.O0000O0o.O00000Oo((String) all.get(next)));
                    } catch (Exception e2) {
                        L.e(O00000o, e2.toString());
                    }
                }
            }
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = getString(str, (String) null);
        return string != null ? Boolean.parseBoolean(string) : z;
    }

    public float getFloat(String str, float f) {
        String string = getString(str, (String) null);
        return string != null ? Float.parseFloat(string) : f;
    }

    public int getInt(String str, int i) {
        String string = getString(str, (String) null);
        return string != null ? Integer.parseInt(string) : i;
    }

    public long getLong(String str, long j) {
        String string = getString(str, (String) null);
        return string != null ? Long.parseLong(string) : j;
    }

    public String getString(String str, String str2) {
        if (!O00000Oo(str)) {
            try {
                String string = this.O00000oo.getString(EncryptionManager.O00000o0(str), (String) null);
                if (string != null) {
                    return this.O0000O0o.O00000Oo(string);
                }
            } catch (Exception e2) {
                L.e(O00000o, e2.toString());
            }
        }
        return str2;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        if (!O00000Oo(str)) {
            try {
                Set<String> stringSet = this.O00000oo.getStringSet(EncryptionManager.O00000o0(str), (Set) null);
                if (stringSet != null) {
                    HashSet hashSet = new HashSet(stringSet.size());
                    for (String O00000Oo2 : stringSet) {
                        hashSet.add(this.O0000O0o.O00000Oo(O00000Oo2));
                    }
                    return hashSet;
                }
            } catch (Exception e2) {
                L.e(O00000o, e2.toString());
            }
        }
        return set;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences sharedPreferences = this.O00000oo;
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences sharedPreferences = this.O00000oo;
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }
}
