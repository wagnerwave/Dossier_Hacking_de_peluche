package com.cuatroochenta.miniland.webservices.pregnancy.baby.babyDiary.edit;

import android.annotation.SuppressLint;
import com.cuatroochenta.commons.webservice.BaseServiceRequest;
import com.cuatroochenta.miniland.model.BabyDiaryEntry;

@SuppressLint({"ParcelCreator"})
public class BabyDiaryEditRequest extends BaseServiceRequest {

    /* renamed from: a  reason: collision with root package name */
    public BabyDiaryEntry f4098a;

    public BabyDiaryEditRequest(BabyDiaryEntry babyDiaryEntry) {
        this.f4098a = babyDiaryEntry;
    }
}
