package com.tuya.smart.common;

import android.content.SharedPreferences;
import com.tuya.smart.android.common.utils.L;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.List;

public class oo0o0o0oo extends oo0o0oo00 {
    public static final String O000000o = "DefaultRecoveryHandler";

    public boolean O000000o(Exception exc, KeyStore keyStore, List<String> list, SharedPreferences sharedPreferences) {
        L.e(O000000o, exc.toString());
        try {
            O000000o(keyStore, list);
            O000000o(sharedPreferences);
            return true;
        } catch (KeyStoreException e2) {
            L.e(O000000o, e2.toString());
            return false;
        }
    }
}
