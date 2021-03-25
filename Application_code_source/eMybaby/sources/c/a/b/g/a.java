package c.a.b.g;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public List<DataSetObserver> f3770a;

    /* renamed from: b  reason: collision with root package name */
    public int f3771b = -15724528;

    /* renamed from: c  reason: collision with root package name */
    public int f3772c = 24;

    /* renamed from: d  reason: collision with root package name */
    public int f3773d = -15724528;

    /* renamed from: e  reason: collision with root package name */
    public int f3774e = 24;
    public int f = -1;
    public Context g;
    public LayoutInflater h;
    public int i;
    public int j;
    public int k = 0;
    public Typeface l = null;

    public a(Context context) {
        this.g = context;
        this.i = -1;
        this.j = 0;
        this.h = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
        if (r5 != null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
        if (r5 != null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        r4.setTypeface(android.graphics.Typeface.SANS_SERIF, 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.widget.TextView r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r3.k
            r2 = 10
            if (r1 >= r2) goto L_0x0012
            java.lang.String r1 = "0"
            r0.append(r1)
            int r1 = r3.k
        L_0x0012:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            boolean r5 = r5.equalsIgnoreCase(r0)
            r0 = 17
            r1 = -1
            r2 = 1
            if (r5 == 0) goto L_0x0045
            int r5 = r3.f3773d
            r4.setTextColor(r5)
            int r5 = r3.f
            if (r5 == r1) goto L_0x0034
            r4.setGravity(r5)
            goto L_0x0037
        L_0x0034:
            r4.setGravity(r0)
        L_0x0037:
            int r5 = r3.f3774e
            float r5 = (float) r5
            r4.setTextSize(r5)
            r4.setLines(r2)
            android.graphics.Typeface r5 = r3.l
            if (r5 == 0) goto L_0x0066
            goto L_0x0062
        L_0x0045:
            int r5 = r3.f3771b
            r4.setTextColor(r5)
            int r5 = r3.f
            if (r5 == r1) goto L_0x0052
            r4.setGravity(r5)
            goto L_0x0055
        L_0x0052:
            r4.setGravity(r0)
        L_0x0055:
            int r5 = r3.f3772c
            float r5 = (float) r5
            r4.setTextSize(r5)
            r4.setLines(r2)
            android.graphics.Typeface r5 = r3.l
            if (r5 == 0) goto L_0x0066
        L_0x0062:
            r4.setTypeface(r5)
            goto L_0x006b
        L_0x0066:
            android.graphics.Typeface r5 = android.graphics.Typeface.SANS_SERIF
            r4.setTypeface(r5, r2)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.b.g.a.b(android.widget.TextView, java.lang.String):void");
    }

    public final View c(int i2, ViewGroup viewGroup) {
        if (i2 == -1) {
            return new TextView(this.g);
        }
        if (i2 != 0) {
            return this.h.inflate(i2, viewGroup, false);
        }
        return null;
    }
}
