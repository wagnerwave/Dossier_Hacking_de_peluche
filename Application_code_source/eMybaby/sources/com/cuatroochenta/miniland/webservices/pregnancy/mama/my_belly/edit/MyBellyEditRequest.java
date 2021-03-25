package com.cuatroochenta.miniland.webservices.pregnancy.mama.my_belly.edit;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;
import com.cuatroochenta.miniland.model.MyBellyData;

@SuppressLint({"ParcelCreator"})
public class MyBellyEditRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public MyBellyData f4140a;

    public MyBellyEditRequest(MyBellyData myBellyData) {
        this.f4140a = myBellyData;
    }
}
