package com.tuya.smart.android.base.mmkv.manager;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.tuya.smart.android.common.task.TuyaExecutor;
import com.tuya.smart.common.oo0o0oo0o;
import com.tuya.smart.mmkv.MMKV;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MMKVManager {
    public static final String MIGRATED = "migrated";
    public MMKV mMMKV;
    public boolean mMigrateDone;
    public SharedPreferences mOldSharePreferences;
    public ReentrantReadWriteLock mReadWriteLock;

    public MMKVManager(Context context, String str) {
        this(context, str, true);
    }

    public MMKVManager(Context context, String str, boolean z) {
        MMKV.initialize(context);
        this.mMMKV = MMKV.mmkvWithID(str, 2, oo0o0oo0o.O000000o(str));
        this.mOldSharePreferences = context.getSharedPreferences(str, 0);
        this.mReadWriteLock = new ReentrantReadWriteLock();
        if (z) {
            migrateSharePreference();
        } else {
            this.mMigrateDone = true;
        }
    }

    public void clear() {
        getWriteLock().lock();
        try {
            this.mMMKV.clear();
        } finally {
            getWriteLock().unlock();
        }
    }

    public boolean contains(String str) {
        getReadLock().lock();
        try {
            return this.mMigrateDone ? this.mMMKV.contains(str) : this.mOldSharePreferences.contains(str);
        } finally {
            getReadLock().unlock();
        }
    }

    public boolean getBoolean(String str, boolean z) {
        getReadLock().lock();
        try {
            return this.mMigrateDone ? this.mMMKV.getBoolean(str, z) : this.mOldSharePreferences.getBoolean(str, z);
        } finally {
            getReadLock().unlock();
        }
    }

    public float getFloat(String str, float f) {
        getReadLock().lock();
        try {
            return this.mMigrateDone ? this.mMMKV.getFloat(str, f) : this.mOldSharePreferences.getFloat(str, f);
        } finally {
            getReadLock().unlock();
        }
    }

    public int getInt(String str, int i) {
        getReadLock().lock();
        try {
            return this.mMigrateDone ? this.mMMKV.getInt(str, i) : this.mOldSharePreferences.getInt(str, i);
        } finally {
            getReadLock().unlock();
        }
    }

    public long getLong(String str, long j) {
        getReadLock().lock();
        try {
            return this.mMigrateDone ? this.mMMKV.getLong(str, j) : this.mOldSharePreferences.getLong(str, j);
        } finally {
            getReadLock().unlock();
        }
    }

    public ReentrantReadWriteLock.ReadLock getReadLock() {
        return this.mReadWriteLock.readLock();
    }

    @Nullable
    public String getString(String str, @Nullable String str2) {
        getReadLock().lock();
        try {
            return this.mMigrateDone ? this.mMMKV.getString(str, str2) : this.mOldSharePreferences.getString(str, str2);
        } finally {
            getReadLock().unlock();
        }
    }

    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        getReadLock().lock();
        try {
            return this.mMigrateDone ? this.mMMKV.getStringSet(str, set) : this.mOldSharePreferences.getStringSet(str, set);
        } finally {
            getReadLock().unlock();
        }
    }

    public ReentrantReadWriteLock.WriteLock getWriteLock() {
        return this.mReadWriteLock.writeLock();
    }

    public int importFromSharedPreferences() {
        Map<String, ?> all = this.mOldSharePreferences.getAll();
        if (all == null || all.size() <= 0) {
            return 0;
        }
        for (Map.Entry next : all.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (!(str == null || value == null || this.mMMKV.contains(str))) {
                if (value instanceof Boolean) {
                    this.mMMKV.putBoolean(str, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    this.mMMKV.putInt(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    this.mMMKV.putLong(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    this.mMMKV.putFloat(str, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    this.mMMKV.encode(str, ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    this.mMMKV.putString(str, (String) value);
                } else if (value instanceof Set) {
                    this.mMMKV.putStringSet(str, (Set) value);
                }
            }
        }
        return all.size();
    }

    public void migrateSharePreference() {
        boolean z = this.mMMKV.getBoolean(MIGRATED, false);
        this.mMigrateDone = z;
        if (!z) {
            TuyaExecutor.getInstance().excutorCallerRunsPolicy(new Runnable() {
                public void run() {
                    MMKVManager.this.getWriteLock().lock();
                    MMKVManager.this.importFromSharedPreferences();
                    MMKVManager.this.mOldSharePreferences.edit().clear().apply();
                    boolean unused = MMKVManager.this.mMigrateDone = true;
                    MMKVManager.this.mMMKV.putBoolean(MMKVManager.MIGRATED, MMKVManager.this.mMigrateDone);
                    MMKVManager.this.getWriteLock().unlock();
                }
            });
        }
    }

    public void putBoolean(String str, boolean z) {
        getWriteLock().lock();
        try {
            this.mMMKV.putBoolean(str, z);
        } finally {
            getWriteLock().unlock();
        }
    }

    public void putFloat(String str, float f) {
        getWriteLock().lock();
        try {
            this.mMMKV.putFloat(str, f);
        } finally {
            getWriteLock().unlock();
        }
    }

    public void putInt(String str, int i) {
        getWriteLock().lock();
        try {
            this.mMMKV.putInt(str, i);
        } finally {
            getWriteLock().unlock();
        }
    }

    public void putLong(String str, long j) {
        getWriteLock().lock();
        try {
            this.mMMKV.putLong(str, j);
        } finally {
            getWriteLock().unlock();
        }
    }

    public void putString(String str, @Nullable String str2) {
        getWriteLock().lock();
        try {
            this.mMMKV.putString(str, str2);
        } finally {
            getWriteLock().unlock();
        }
    }

    public void putStringSet(String str, @Nullable Set<String> set) {
        getWriteLock().lock();
        try {
            this.mMMKV.putStringSet(str, set);
        } finally {
            getWriteLock().unlock();
        }
    }

    public void remove(String str) {
        getWriteLock().lock();
        try {
            this.mMMKV.remove(str);
        } finally {
            getWriteLock().unlock();
        }
    }
}
