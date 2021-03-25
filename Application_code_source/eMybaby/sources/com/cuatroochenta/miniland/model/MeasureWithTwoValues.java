package com.cuatroochenta.miniland.model;

import a.c.a.d.a;
import a.c.d.r.j;
import androidx.annotation.NonNull;
import java.text.ParseException;

public class MeasureWithTwoValues<Type1, Type2> implements Comparable<MeasureWithTwoValues<Type1, Type2>> {
    public Long id;
    public Long mDate;
    public Type1 mFirstValue;
    public Type2 mSecondValue;
    public String mTitle;
    public String stringDate;

    public MeasureWithTwoValues(long j, Type1 type1, Type2 type2, String str, String str2) {
        this.id = Long.valueOf(j);
        this.mFirstValue = type1;
        this.mSecondValue = type2;
        this.mTitle = str;
        this.stringDate = str2;
        try {
            setDate(Long.valueOf(j.j.parse(str2).getTime()));
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
    }

    public int compareTo(@NonNull MeasureWithTwoValues<Type1, Type2> measureWithTwoValues) {
        if (getId() == null || measureWithTwoValues.getId() == null) {
            return 0;
        }
        return measureWithTwoValues.getId().compareTo(getId());
    }

    public Long getDate() {
        return this.mDate;
    }

    public Type1 getFirstValue() {
        return this.mFirstValue;
    }

    public Long getId() {
        return this.id;
    }

    public Type2 getSecondValue() {
        return this.mSecondValue;
    }

    public String getStringDate() {
        return getDate() != null ? j.f.format(getDate()) : a.g(this.stringDate);
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setDate(Long l) {
        this.mDate = l;
    }

    public void setFirstValue(Type1 type1) {
        this.mFirstValue = type1;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setSecondValue(Type2 type2) {
        this.mSecondValue = type2;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }
}
