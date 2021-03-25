package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.List;

public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new Parcelable.Creator<CompositeDateValidator>() {
        @NonNull
        public CompositeDateValidator createFromParcel(@NonNull Parcel parcel) {
            return new CompositeDateValidator((List) Preconditions.checkNotNull(parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader())));
        }

        @NonNull
        public CompositeDateValidator[] newArray(int i) {
            return new CompositeDateValidator[i];
        }
    };
    @NonNull
    public final List<CalendarConstraints.DateValidator> validators;

    public CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> list) {
        this.validators = list;
    }

    @NonNull
    public static CalendarConstraints.DateValidator allOf(@NonNull List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        return this.validators.equals(((CompositeDateValidator) obj).validators);
    }

    public int hashCode() {
        return this.validators.hashCode();
    }

    public boolean isValid(long j) {
        for (CalendarConstraints.DateValidator next : this.validators) {
            if (next != null && !next.isValid(j)) {
                return false;
            }
        }
        return true;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeList(this.validators);
    }
}
