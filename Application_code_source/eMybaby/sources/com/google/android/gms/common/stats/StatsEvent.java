package com.google.android.gms.common.stats;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public String toString() {
        WakeLockEvent wakeLockEvent = (WakeLockEvent) this;
        long j = wakeLockEvent.f4239b;
        int i = wakeLockEvent.f4240c;
        long j2 = wakeLockEvent.p;
        String str = wakeLockEvent.f4241d;
        int i2 = wakeLockEvent.g;
        List<String> list = wakeLockEvent.h;
        String str2 = "";
        String join = list == null ? str2 : TextUtils.join(",", list);
        int i3 = wakeLockEvent.k;
        String str3 = wakeLockEvent.f4242e;
        if (str3 == null) {
            str3 = str2;
        }
        String str4 = wakeLockEvent.l;
        if (str4 == null) {
            str4 = str2;
        }
        float f = wakeLockEvent.m;
        String str5 = wakeLockEvent.f;
        if (str5 != null) {
            str2 = str5;
        }
        boolean z = wakeLockEvent.o;
        StringBuilder sb = new StringBuilder(str2.length() + str4.length() + str3.length() + String.valueOf(join).length() + String.valueOf(str).length() + 51);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(z);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 53);
        sb3.append(j);
        sb3.append("\t");
        sb3.append(i);
        sb3.append("\t");
        sb3.append(j2);
        sb3.append(sb2);
        return sb3.toString();
    }
}
