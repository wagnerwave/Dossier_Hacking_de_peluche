package com.cuatroochenta.miniland.webservices.pregnancy.mama.fundal_height.edit;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;
import java.util.Date;

@SuppressLint({"ParcelCreator"})
public class FundalHeightEditRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public Date f4130a;

    /* renamed from: b  reason: collision with root package name */
    public String f4131b;

    /* renamed from: c  reason: collision with root package name */
    public int f4132c;

    /* renamed from: d  reason: collision with root package name */
    public long f4133d;

    public FundalHeightEditRequest(Date date, String str, int i, long j) {
        this.f4130a = date;
        this.f4131b = str;
        this.f4132c = i;
        this.f4133d = j;
    }
}
