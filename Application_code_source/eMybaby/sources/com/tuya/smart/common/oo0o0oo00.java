package com.tuya.smart.common;

import android.content.SharedPreferences;
import java.security.KeyStore;
import java.util.Collections;
import java.util.List;

public abstract class oo0o0oo00 {
    public void O000000o(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
        }
    }

    public void O000000o(KeyStore keyStore) {
        if (keyStore != null) {
            for (T t : Collections.list(keyStore.aliases())) {
                if (keyStore.containsAlias(t)) {
                    keyStore.deleteEntry(t);
                }
            }
        }
    }

    public void O000000o(KeyStore keyStore, List<String> list) {
        if (keyStore != null && list != null) {
            for (String next : list) {
                if (keyStore.containsAlias(next)) {
                    keyStore.deleteEntry(next);
                }
            }
        }
    }

    public abstract boolean O000000o(Exception exc, KeyStore keyStore, List<String> list, SharedPreferences sharedPreferences);
}
