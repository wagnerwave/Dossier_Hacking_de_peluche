package a.d.c.q.a;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import java.util.ArrayList;

public final class k extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public CheckBoxPreference f2945a;

    /* renamed from: b  reason: collision with root package name */
    public CheckBoxPreference f2946b;

    /* renamed from: c  reason: collision with root package name */
    public CheckBoxPreference f2947c;

    public final void a() {
        ArrayList arrayList = new ArrayList(3);
        if (this.f2945a.isChecked()) {
            arrayList.add(this.f2945a);
        }
        if (this.f2946b.isChecked()) {
            arrayList.add(this.f2946b);
        }
        if (this.f2947c.isChecked()) {
            arrayList.add(this.f2947c);
        }
        boolean z = arrayList.size() < 2;
        CheckBoxPreference[] checkBoxPreferenceArr = {this.f2945a, this.f2946b, this.f2947c};
        for (int i = 0; i < 3; i++) {
            CheckBoxPreference checkBoxPreference = checkBoxPreferenceArr[i];
            checkBoxPreference.setEnabled(!z || !arrayList.contains(checkBoxPreference));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(r.preferences);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        preferenceScreen.getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        this.f2945a = (CheckBoxPreference) preferenceScreen.findPreference("preferences_decode_1D");
        this.f2946b = (CheckBoxPreference) preferenceScreen.findPreference("preferences_decode_QR");
        this.f2947c = (CheckBoxPreference) preferenceScreen.findPreference("preferences_decode_Data_Matrix");
        a();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        a();
    }
}
