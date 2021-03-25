package com.cuatroochenta.miniland.webservices.pregnancy.mama.weight.add;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;

@SuppressLint({"ParcelCreator"})
public class MamaWeightAddRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public float f4144a;

    /* renamed from: b  reason: collision with root package name */
    public String f4145b;

    public MamaWeightAddRequest(float f, String str) {
        this.f4144a = f;
        this.f4145b = str;
    }
}
