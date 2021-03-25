package com.cuatroochenta.miniland.webservices.pregnancy.baby.ultrasound.edit;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;
import com.cuatroochenta.miniland.model.UltrasoundPhoto;

@SuppressLint({"ParcelCreator"})
public class UltrasoundEditRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public UltrasoundPhoto f4110a;

    public UltrasoundEditRequest(UltrasoundPhoto ultrasoundPhoto) {
        this.f4110a = ultrasoundPhoto;
    }
}
