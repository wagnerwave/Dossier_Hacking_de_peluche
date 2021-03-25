package a.h.a;

import android.widget.AdapterView;

public class w implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f3560a;

    public w(z zVar) {
        this.f3560a = zVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.sozpic.miniland.modelos.Agenda} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: com.sozpic.miniland.modelos.Medica} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.sozpic.miniland.modelos.Agenda} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.sozpic.miniland.modelos.Agenda} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
        /*
            r0 = this;
            a.h.a.z r1 = r0.f3560a
            android.widget.ListView r1 = r1.f3568e
            android.widget.ListAdapter r1 = r1.getAdapter()
            java.lang.Object r1 = r1.getItem(r3)
            boolean r1 = r1 instanceof com.sozpic.miniland.modelos.Agenda
            if (r1 == 0) goto L_0x009b
            a.h.a.z r1 = r0.f3560a
            android.widget.ListView r1 = r1.f3568e
            android.widget.ListAdapter r1 = r1.getAdapter()
            java.lang.Object r1 = r1.getItem(r3)
            com.sozpic.miniland.modelos.Agenda r1 = (com.sozpic.miniland.modelos.Agenda) r1
            java.lang.String r2 = r1.getId()
            java.lang.String r3 = "0"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x009b
            r2 = 0
            com.sozpic.miniland.modelos.Medica r3 = r1.getMedicalRecord()
            if (r3 != 0) goto L_0x0041
            android.content.Intent r2 = new android.content.Intent
            a.h.a.z r3 = r0.f3560a
            androidx.fragment.app.FragmentActivity r3 = r3.getActivity()
            java.lang.Class<com.sozpic.miniland.DetalleCalendarioActivity> r4 = com.sozpic.miniland.DetalleCalendarioActivity.class
            r2.<init>(r3, r4)
            java.lang.String r3 = "KEY_INTENT_AGENDA"
            goto L_0x0091
        L_0x0041:
            com.sozpic.miniland.modelos.Medica r1 = r1.getMedicalRecord()
            int r3 = r1.getTipo()
            r4 = 2
            r5 = 1
            if (r3 != r4) goto L_0x005b
            android.content.Intent r2 = new android.content.Intent
            a.h.a.z r3 = r0.f3560a
            androidx.fragment.app.FragmentActivity r3 = r3.getActivity()
            java.lang.Class<com.sozpic.miniland.DetalleMedicaCitaActivity> r4 = com.sozpic.miniland.DetalleMedicaCitaActivity.class
            r2.<init>(r3, r4)
            goto L_0x0083
        L_0x005b:
            int r3 = r1.getTipo()
            r4 = 3
            if (r3 != r4) goto L_0x0070
            android.content.Intent r2 = new android.content.Intent
            a.h.a.z r3 = r0.f3560a
            androidx.fragment.app.FragmentActivity r3 = r3.getActivity()
            java.lang.Class<com.sozpic.miniland.DetalleMedicaVacunaActivity> r4 = com.sozpic.miniland.DetalleMedicaVacunaActivity.class
            r2.<init>(r3, r4)
            goto L_0x0083
        L_0x0070:
            int r3 = r1.getTipo()
            if (r3 != r5) goto L_0x0083
            android.content.Intent r2 = new android.content.Intent
            a.h.a.z r3 = r0.f3560a
            androidx.fragment.app.FragmentActivity r3 = r3.getActivity()
            java.lang.Class<com.sozpic.miniland.DetalleMedicaCrecimientoActivity> r4 = com.sozpic.miniland.DetalleMedicaCrecimientoActivity.class
            r2.<init>(r3, r4)
        L_0x0083:
            if (r2 == 0) goto L_0x0094
            int r3 = r1.getTipo()
            int r3 = r3 - r5
            java.lang.String r4 = "tipo"
            r2.putExtra(r4, r3)
            java.lang.String r3 = "KEY_INTENT_MEDICAL_RECORD"
        L_0x0091:
            r2.putExtra(r3, r1)
        L_0x0094:
            if (r2 == 0) goto L_0x009b
            a.h.a.z r1 = r0.f3560a
            r1.startActivity(r2)
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.h.a.w.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
    }
}
