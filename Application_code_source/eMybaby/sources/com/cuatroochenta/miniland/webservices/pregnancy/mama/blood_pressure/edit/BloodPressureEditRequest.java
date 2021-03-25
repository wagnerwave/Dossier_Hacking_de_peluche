package com.cuatroochenta.miniland.webservices.pregnancy.mama.blood_pressure.edit;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;
import com.cuatroochenta.miniland.model.MeasureWithTwoValues;

@SuppressLint({"ParcelCreator"})
public class BloodPressureEditRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public MeasureWithTwoValues<Integer, Integer> f4117a;

    public BloodPressureEditRequest(MeasureWithTwoValues<Integer, Integer> measureWithTwoValues) {
        this.f4117a = measureWithTwoValues;
    }
}
