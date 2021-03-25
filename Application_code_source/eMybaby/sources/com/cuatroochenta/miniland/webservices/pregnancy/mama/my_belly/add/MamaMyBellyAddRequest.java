package com.cuatroochenta.miniland.webservices.pregnancy.mama.my_belly.add;

import a.c.d.r.j;
import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;
import com.cuatroochenta.miniland.model.MyBellyData;

@SuppressLint({"ParcelCreator"})
public class MamaMyBellyAddRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public String f4137a;

    /* renamed from: b  reason: collision with root package name */
    public String f4138b;

    /* renamed from: c  reason: collision with root package name */
    public String f4139c;

    public MamaMyBellyAddRequest(MyBellyData myBellyData) {
        this.f4137a = myBellyData.getTitle();
        this.f4138b = myBellyData.getDescription();
        j.j.format(myBellyData.getDate());
        this.f4139c = myBellyData.getImageUrl();
    }
}
