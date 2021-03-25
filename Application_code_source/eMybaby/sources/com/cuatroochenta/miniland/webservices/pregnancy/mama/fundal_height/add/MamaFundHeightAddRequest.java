package com.cuatroochenta.miniland.webservices.pregnancy.mama.fundal_height.add;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;

@SuppressLint({"ParcelCreator"})
public class MamaFundHeightAddRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public String f4128a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f4129b;

    public MamaFundHeightAddRequest(String str, Integer num) {
        this.f4128a = str;
        this.f4129b = num;
    }
}
