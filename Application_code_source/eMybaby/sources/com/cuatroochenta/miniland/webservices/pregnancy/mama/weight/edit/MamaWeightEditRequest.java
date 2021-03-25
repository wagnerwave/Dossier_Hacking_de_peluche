package com.cuatroochenta.miniland.webservices.pregnancy.mama.weight.edit;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;
import java.util.Date;

@SuppressLint({"ParcelCreator"})
public class MamaWeightEditRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public Date f4147a;

    /* renamed from: b  reason: collision with root package name */
    public String f4148b;

    /* renamed from: c  reason: collision with root package name */
    public float f4149c;

    /* renamed from: d  reason: collision with root package name */
    public long f4150d;

    public MamaWeightEditRequest(Date date, String str, float f, long j) {
        this.f4147a = date;
        this.f4148b = str;
        this.f4149c = f;
        this.f4150d = j;
    }
}
