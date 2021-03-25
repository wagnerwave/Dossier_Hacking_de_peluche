package com.tuya.smart.android.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TuyaConcurrentList<T> {
    public List<T> mList = new ArrayList();
    public ReentrantReadWriteLock mLock = new ReentrantReadWriteLock(true);

    public interface QueryListCallback<T> {
        void query(T t);
    }

    public void add(T t) {
        if (t != null && !this.mList.contains(t)) {
            try {
                this.mLock.writeLock().lock();
                this.mList.add(t);
            } finally {
                this.mLock.writeLock().unlock();
            }
        }
    }

    public void clear() {
        try {
            this.mLock.writeLock().lock();
            this.mList.clear();
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public List<T> getList() {
        try {
            this.mLock.readLock().lock();
            return this.mList;
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    public void query(QueryListCallback<T> queryListCallback) {
        if (!this.mList.isEmpty()) {
            try {
                this.mLock.readLock().lock();
                for (T query : this.mList) {
                    queryListCallback.query(query);
                }
            } finally {
                this.mLock.readLock().unlock();
            }
        }
    }

    public void remove(T t) {
        if (this.mList.contains(t)) {
            try {
                this.mLock.writeLock().lock();
                this.mList.remove(t);
            } finally {
                this.mLock.writeLock().unlock();
            }
        }
    }

    public void removeAll(List<T> list) {
        if (list != null && !list.isEmpty()) {
            try {
                this.mLock.writeLock().lock();
                this.mList.removeAll(list);
            } finally {
                this.mLock.writeLock().unlock();
            }
        }
    }
}
