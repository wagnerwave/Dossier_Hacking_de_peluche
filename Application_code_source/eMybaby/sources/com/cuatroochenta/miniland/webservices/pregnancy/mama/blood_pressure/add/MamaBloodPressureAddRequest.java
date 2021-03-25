package com.cuatroochenta.miniland.webservices.pregnancy.mama.blood_pressure.add;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;

@SuppressLint({"ParcelCreator"})
public class MamaBloodPressureAddRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public String f4113a;

    /* renamed from: b  reason: collision with root package name */
    public String f4114b;

    /* renamed from: c  reason: collision with root package name */
    public int f4115c;

    /* renamed from: d  reason: collision with root package name */
    public int f4116d;

    public MamaBloodPressureAddRequest(String str, String str2, int i, int i2) {
        this.f4113a = str;
        this.f4114b = str2;
        this.f4115c = i;
        this.f4116d = i2;
    }
}
