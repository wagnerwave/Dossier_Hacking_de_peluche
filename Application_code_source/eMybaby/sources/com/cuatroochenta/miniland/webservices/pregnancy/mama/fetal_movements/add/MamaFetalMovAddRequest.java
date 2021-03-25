package com.cuatroochenta.miniland.webservices.pregnancy.mama.fetal_movements.add;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;

@SuppressLint({"ParcelCreator"})
public class MamaFetalMovAddRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public String f4121a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4122b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4123c;

    public MamaFetalMovAddRequest(String str, boolean z, boolean z2) {
        this.f4121a = str;
        this.f4122b = z;
        this.f4123c = z2;
    }
}
