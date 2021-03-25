package com.cuatroochenta.miniland.webservices.pregnancy.mama.fetal_movements.edit;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;
import com.cuatroochenta.miniland.model.MeasureWithTwoValues;

@SuppressLint({"ParcelCreator"})
public class FetalMovementEditRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public MeasureWithTwoValues<Boolean, Boolean> f4124a;

    public FetalMovementEditRequest(MeasureWithTwoValues<Boolean, Boolean> measureWithTwoValues) {
        this.f4124a = measureWithTwoValues;
    }
}
