package com.google.android.gms.common.api.internal;

import a.d.a.a.e.k.l.h;
import a.d.a.a.e.k.l.i;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;

public class LifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    public final i f4216a;

    public LifecycleCallback(i iVar) {
        this.f4216a = iVar;
    }

    @Keep
    public static i getChimeraLifecycleFragmentImpl(h hVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @MainThread
    public void a() {
    }

    public Activity b() {
        return this.f4216a.k();
    }

    @MainThread
    public void c(int i, int i2, Intent intent) {
    }

    @MainThread
    public void d(Bundle bundle) {
    }

    @MainThread
    public void e() {
    }

    @MainThread
    public void f(Bundle bundle) {
    }

    @MainThread
    public void g() {
    }

    @MainThread
    public void h() {
    }
}
