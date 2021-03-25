package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public abstract class DateFormatTextWatcher implements TextWatcher {
    public final CalendarConstraints constraints;
    public final DateFormat dateFormat;
    public final String formatHint;
    public final String outOfRange;
    @NonNull
    public final TextInputLayout textInputLayout;

    public DateFormatTextWatcher(String str, DateFormat dateFormat2, @NonNull TextInputLayout textInputLayout2, CalendarConstraints calendarConstraints) {
        this.formatHint = str;
        this.dateFormat = dateFormat2;
        this.textInputLayout = textInputLayout2;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout2.getContext().getString(R.string.mtrl_picker_out_of_range);
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onInvalidDate() {
    }

    public void onTextChanged(@NonNull CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            this.textInputLayout.setError((CharSequence) null);
            onValidDate((Long) null);
            return;
        }
        try {
            Date parse = this.dateFormat.parse(charSequence.toString());
            this.textInputLayout.setError((CharSequence) null);
            long time = parse.getTime();
            if (!this.constraints.getDateValidator().isValid(time) || !this.constraints.isWithinBounds(time)) {
                this.textInputLayout.setError(String.format(this.outOfRange, new Object[]{DateStrings.getDateString(time)}));
                onInvalidDate();
                return;
            }
            onValidDate(Long.valueOf(parse.getTime()));
        } catch (ParseException unused) {
            String string = this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format);
            String format = String.format(this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format_use), new Object[]{this.formatHint});
            String format2 = String.format(this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format_example), new Object[]{this.dateFormat.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis()))});
            TextInputLayout textInputLayout2 = this.textInputLayout;
            textInputLayout2.setError(string + "\n" + format + "\n" + format2);
            onInvalidDate();
        }
    }

    public abstract void onValidDate(@Nullable Long l);
}
