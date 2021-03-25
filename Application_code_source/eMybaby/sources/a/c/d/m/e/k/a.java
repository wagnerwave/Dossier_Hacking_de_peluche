package a.c.d.m.e.k;

import a.c.d.r.k.a;
import a.c.d.r.k.f;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cuatroochenta.miniland.model.MedicalDataEntry;
import com.sozpic.miniland.R;
import java.util.Locale;

public class a extends f<MedicalDataEntry> {
    public void a(a.C0042a aVar) {
        aVar.a(R.id.item_medical_data_text_date);
        aVar.a(R.id.item_medical_data_text_fl);
        aVar.a(R.id.item_medical_data_text_hc);
        aVar.a(R.id.item_medical_data_text_ac);
        aVar.a(R.id.item_medical_data_text_efw);
    }

    public void b(int i, Object obj, a.C0042a aVar) {
        MedicalDataEntry medicalDataEntry = (MedicalDataEntry) obj;
        ((TextView) aVar.c(R.id.item_medical_data_text_date)).setText(medicalDataEntry.getTitle());
        String valueOf = String.valueOf(medicalDataEntry.getEFW());
        String i2 = a.c.a.d.a.i(R.string.TR_G_PLACEHOLDER);
        String format = String.format(Locale.getDefault(), i2, new Object[]{valueOf});
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new RelativeSizeSpan(0.65f), valueOf.length(), format.length(), 33);
        ((TextView) aVar.c(R.id.item_medical_data_text_efw)).setText(spannableString);
        ((TextView) aVar.c(R.id.item_medical_data_text_fl)).setText(j(medicalDataEntry.getFL()));
        ((TextView) aVar.c(R.id.item_medical_data_text_hc)).setText(j(medicalDataEntry.getHC()));
        ((TextView) aVar.c(R.id.item_medical_data_text_ac)).setText(j(medicalDataEntry.getAC()));
    }

    public long c(int i, Object obj) {
        return ((MedicalDataEntry) obj).getId();
    }

    public View d(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_medical_data, viewGroup, false);
    }

    public final Spannable j(float f) {
        String format = String.format(Locale.getDefault(), "%.1f", new Object[]{Float.valueOf(f)});
        String i = a.c.a.d.a.i(R.string.TR_MM_PLACEHOLDER);
        String format2 = String.format(Locale.getDefault(), i, new Object[]{format});
        SpannableString spannableString = new SpannableString(format2);
        spannableString.setSpan(new RelativeSizeSpan(0.65f), format.length(), format2.length(), 33);
        return spannableString;
    }
}
