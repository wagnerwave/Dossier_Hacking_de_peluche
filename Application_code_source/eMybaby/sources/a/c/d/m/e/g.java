package a.c.d.m.e;

import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;

public class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyPregnancyFragmentContainerActivity f347a;

    public g(MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity) {
        this.f347a = myPregnancyFragmentContainerActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.os.Parcelable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity r6 = r5.f347a
            androidx.fragment.app.Fragment r0 = r6.f3947e
            boolean r1 = r0 instanceof a.c.d.m.e.l.m
            java.lang.String r2 = "ACTION_EDIT"
            r3 = 0
            if (r1 == 0) goto L_0x003c
            r1 = 1932(0x78c, float:2.707E-42)
            a.c.d.m.e.l.m r0 = (a.c.d.m.e.l.m) r0
            java.util.List<com.cuatroochenta.miniland.model.UltrasoundPhoto> r4 = r0.f
            if (r4 == 0) goto L_0x0029
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x001a
            goto L_0x0029
        L_0x001a:
            java.util.List<com.cuatroochenta.miniland.model.UltrasoundPhoto> r3 = r0.f
            androidx.viewpager.widget.ViewPager r0 = r0.f426d
            int r0 = r0.getCurrentItem()
            java.lang.Object r0 = r3.get(r0)
            r3 = r0
            com.cuatroochenta.miniland.model.UltrasoundPhoto r3 = (com.cuatroochenta.miniland.model.UltrasoundPhoto) r3
        L_0x0029:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.cuatroochenta.miniland.pregnancy.baby.ultrasound.UltrasoundFormActivity> r4 = com.cuatroochenta.miniland.pregnancy.baby.ultrasound.UltrasoundFormActivity.class
            r0.<init>(r6, r4)
            r0.setAction(r2)
            java.lang.String r2 = "ARGS_ECOGRAPHY_PHOTO"
            r0.putExtra(r2, r3)
            r6.startActivityForResult(r0, r1)
            goto L_0x0068
        L_0x003c:
            boolean r1 = r0 instanceof a.c.d.m.e.k.o
            if (r1 == 0) goto L_0x0068
            r1 = 48293(0xbca5, float:6.7673E-41)
            a.c.d.m.e.k.o r0 = (a.c.d.m.e.k.o) r0
            androidx.fragment.app.Fragment r0 = r0.f392a
            boolean r4 = r0 instanceof a.c.d.m.e.k.i
            if (r4 == 0) goto L_0x0056
            a.c.d.m.e.k.i r0 = (a.c.d.m.e.k.i) r0
            a.c.d.m.e.k.a r0 = r0.j
            java.lang.Object r0 = r0.g()
            r3 = r0
            com.cuatroochenta.miniland.model.MedicalDataEntry r3 = (com.cuatroochenta.miniland.model.MedicalDataEntry) r3
        L_0x0056:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity> r4 = com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity.class
            r0.<init>(r6, r4)
            r0.setAction(r2)
            java.lang.String r2 = "ARGS_MEDICAL_DATA_ENTRY"
            r0.putExtra(r2, r3)
            r6.startActivityForResult(r0, r1)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.m.e.g.onClick(android.view.View):void");
    }
}
