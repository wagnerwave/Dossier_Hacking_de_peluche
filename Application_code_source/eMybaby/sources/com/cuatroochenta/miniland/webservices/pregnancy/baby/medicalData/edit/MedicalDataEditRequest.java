package com.cuatroochenta.miniland.webservices.pregnancy.baby.medicalData.edit;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;

@SuppressLint({"ParcelCreator"})
public class MedicalDataEditRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public final long f4101a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4102b;

    /* renamed from: c  reason: collision with root package name */
    public final float f4103c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4104d;

    /* renamed from: e  reason: collision with root package name */
    public final float f4105e;
    public final int f;

    public MedicalDataEditRequest(long j, String str, float f2, float f3, float f4, int i) {
        this.f4101a = j;
        this.f4102b = str;
        this.f = i;
        this.f4103c = f2;
        this.f4104d = f3;
        this.f4105e = f4;
    }
}
