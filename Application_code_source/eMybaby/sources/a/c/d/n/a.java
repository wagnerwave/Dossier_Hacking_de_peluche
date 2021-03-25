package a.c.d.n;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.sozpic.miniland.R;
import java.util.ArrayList;

public class a extends DialogFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ImageView> f730a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f731b = 0;

    /* renamed from: a.c.d.n.a$a  reason: collision with other inner class name */
    public class C0036a implements View.OnClickListener {
        public C0036a() {
        }

        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f731b >= 4) {
                aVar.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.sozpic.miniland")));
            }
            a.this.dismiss();
            if (a.this.f731b > 0) {
                a.c.d.a.l().g("KEY_RATE_APP_SHOW_DIALOG", Boolean.FALSE);
                new b().show(a.this.getFragmentManager(), "THANKS_FOR_RATING_DIALOG");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m(androidx.fragment.app.FragmentManager r11) {
        /*
            a.c.d.a r0 = a.c.d.a.l()
            java.lang.String r1 = "KEY_RATE_APP_SHOW_DIALOG"
            r2 = 1
            boolean r0 = r0.a(r1, r2)
            if (r0 == 0) goto L_0x0069
            a.c.d.a r0 = a.c.d.a.l()
            android.content.SharedPreferences r1 = r0.f6a
            java.lang.String r3 = "KEY_RATE_APP_TIMESTAMP"
            boolean r1 = r1.contains(r3)
            r4 = -9223372036854775808
            if (r1 == 0) goto L_0x0028
            android.content.SharedPreferences r1 = r0.f6a
            long r6 = r1.getLong(r3, r4)
            java.lang.Long r1 = java.lang.Long.valueOf(r6)
            goto L_0x0029
        L_0x0028:
            r1 = 0
        L_0x0029:
            r6 = 0
            if (r1 == 0) goto L_0x0051
            long r7 = r1.longValue()
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x0035
            goto L_0x0051
        L_0x0035:
            long r4 = java.lang.System.currentTimeMillis()
            long r7 = r1.longValue()
            r9 = 1296000000(0x4d3f6400, double:6.40309077E-315)
            long r7 = r7 + r9
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x005c
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            r0.h(r3, r1)
            goto L_0x005d
        L_0x0051:
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.h(r3, r1)
        L_0x005c:
            r2 = 0
        L_0x005d:
            if (r2 == 0) goto L_0x0069
            a.c.d.n.a r0 = new a.c.d.n.a
            r0.<init>()
            java.lang.String r1 = "RATE_APP_DIALOG"
            r0.show((androidx.fragment.app.FragmentManager) r11, (java.lang.String) r1)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.n.a.m(androidx.fragment.app.FragmentManager):void");
    }

    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            this.f731b = ((Integer) view.getTag()).intValue();
            int i = 0;
            while (i < this.f730a.size()) {
                this.f730a.get(i).setColorFilter(ContextCompat.getColor(view.getContext(), i < this.f731b ? R.color.color_FFAA20 : R.color.color_D8D8D8));
                i++;
            }
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_rate_app, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.dialog_rate_app_title)).setText(a.c.a.d.a.h(R.string.TR_TE_GUSTA_LA_APP));
        ((TextView) inflate.findViewById(R.id.dialog_rate_app_subtitle)).setText(a.c.a.d.a.h(R.string.TR_TE_AGRADECERIAMOS_QUE_VALORARAS_NUESTRA_APP));
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_rate_app_cancel);
        textView.setText(a.c.a.d.a.h(R.string.TR_AHORA_NO));
        textView.setOnClickListener(new C0036a());
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_rate_app_rate);
        textView2.setText(a.c.a.d.a.h(R.string.TR_VALORAR));
        textView2.setOnClickListener(new b());
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dialog_rate_app_first_star);
        imageView.setTag(1);
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.dialog_rate_app_second_star);
        imageView2.setTag(2);
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.dialog_rate_app_third_star);
        imageView3.setTag(3);
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.dialog_rate_app_fourth_star);
        imageView4.setTag(4);
        imageView4.setOnClickListener(this);
        ImageView imageView5 = (ImageView) inflate.findViewById(R.id.dialog_rate_app_fifth_star);
        imageView5.setTag(5);
        imageView5.setOnClickListener(this);
        ArrayList<ImageView> arrayList = new ArrayList<>();
        this.f730a = arrayList;
        arrayList.add(imageView);
        this.f730a.add(imageView2);
        this.f730a.add(imageView3);
        this.f730a.add(imageView4);
        this.f730a.add(imageView5);
        getDialog().getWindow().requestFeature(1);
        return inflate;
    }
}
