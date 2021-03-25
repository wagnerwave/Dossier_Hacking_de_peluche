package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {
    public static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    public static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    @Nullable
    public CalendarConstraints calendarConstraints;
    @Nullable
    public DateSelector<S> dateSelector;

    @NonNull
    public static <T> MaterialTextInputPicker<T> newInstance(@NonNull DateSelector<T> dateSelector2, @NonNull CalendarConstraints calendarConstraints2) {
        MaterialTextInputPicker<T> materialTextInputPicker = new MaterialTextInputPicker<>();
        Bundle bundle = new Bundle();
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector2);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
        materialTextInputPicker.setArguments(bundle);
        return materialTextInputPicker;
    }

    @NonNull
    public DateSelector<S> getDateSelector() {
        DateSelector<S> dateSelector2 = this.dateSelector;
        if (dateSelector2 != null) {
            return dateSelector2;
        }
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.dateSelector = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.dateSelector.onCreateTextInputView(layoutInflater, viewGroup, bundle, this.calendarConstraints, new OnSelectionChangedListener<S>() {
            public void onIncompleteSelectionChanged() {
                Iterator it = MaterialTextInputPicker.this.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    ((OnSelectionChangedListener) it.next()).onIncompleteSelectionChanged();
                }
            }

            public void onSelectionChanged(S s) {
                Iterator it = MaterialTextInputPicker.this.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    ((OnSelectionChangedListener) it.next()).onSelectionChanged(s);
                }
            }
        });
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
    }
}
