package com.tuya.smart.common;

import a.e.a.a.a;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean;
import com.tuya.sdk.sigmesh.model.SigMeshLogin$2;
import com.tuya.sdk.sigmesh.model.SigMeshLogin$3;
import com.tuya.sdk.sigmesh.model.SigMeshLogin$4;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.sdk.tuyamesh.blemesh.search.BlueMeshSearch;
import com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.UUID;

public class ooooo0o0o extends BaseModel {
    public static final int O000000o = 4081;
    public static final int O00000Oo = 4083;
    public static final int O00000o = 4085;
    public static final int O00000o0 = 4084;
    public static final int O00000oO = 4086;
    public static final int O00000oo = 247;
    public static final int O0000O0o = 4088;
    public static final String O0000Oo = "SigMeshLogin";
    public UUID[] O0000OOo = {o00o00o000.O0000OOo};
    public o00oo00o00 O0000Oo0 = new o00oo00o00() {
        public void O000000o() {
            ooooo0o0o.this.O000000o(MeshClientStatusEnum.INIT);
            ooooo0o0o ooooo0o0o = ooooo0o0o.this;
            ooooo0o0o.resultSuccess(ooooo0o0o.O0000O0o, ooooo0o0o.O0000Ooo);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ab, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void O000000o(com.tuya.smart.android.blemesh.bean.SearchDeviceBean r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.String r0 = "SigMeshLogin"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
                r1.<init>()     // Catch:{ all -> 0x00ac }
                java.lang.String r2 = "name: "
                r1.append(r2)     // Catch:{ all -> 0x00ac }
                java.lang.String r2 = r4.getMeshName()     // Catch:{ all -> 0x00ac }
                r1.append(r2)     // Catch:{ all -> 0x00ac }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ac }
                com.tuya.smart.android.common.utils.L.d(r0, r1)     // Catch:{ all -> 0x00ac }
                r0 = r4
                com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean r0 = (com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean) r0     // Catch:{ all -> 0x00ac }
                com.tuya.sdk.sigmesh.bean.ScanRecord r0 = r0.getScanRecordBean()     // Catch:{ all -> 0x00ac }
                com.tuya.smart.common.ooooo0o0o r1 = com.tuya.smart.common.ooooo0o0o.this     // Catch:{ all -> 0x00ac }
                java.util.UUID[] r1 = r1.O0000OOo     // Catch:{ all -> 0x00ac }
                r2 = 0
                r1 = r1[r2]     // Catch:{ all -> 0x00ac }
                byte[] r0 = com.tuya.smart.common.o00o0000oo.O000000o((com.tuya.sdk.sigmesh.bean.ScanRecord) r0, (java.util.UUID) r1)     // Catch:{ all -> 0x00ac }
                com.tuya.smart.common.ooooo0o0o r1 = com.tuya.smart.common.ooooo0o0o.this     // Catch:{ all -> 0x00ac }
                java.lang.String r2 = r4.getMacAdress()     // Catch:{ all -> 0x00ac }
                boolean r0 = r1.O000000o((byte[]) r0, (java.lang.String) r2)     // Catch:{ all -> 0x00ac }
                if (r0 != 0) goto L_0x0055
                java.lang.String r0 = "SigMeshLogin"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
                r1.<init>()     // Catch:{ all -> 0x00ac }
                java.lang.String r2 = "not found target: "
                r1.append(r2)     // Catch:{ all -> 0x00ac }
                java.lang.String r4 = r4.getMacAdress()     // Catch:{ all -> 0x00ac }
                r1.append(r4)     // Catch:{ all -> 0x00ac }
                java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x00ac }
                com.tuya.smart.android.common.utils.L.d(r0, r4)     // Catch:{ all -> 0x00ac }
                monitor-exit(r3)
                return
            L_0x0055:
                java.lang.String r0 = "SigMeshLogin"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
                r1.<init>()     // Catch:{ all -> 0x00ac }
                java.lang.String r2 = "found target: "
                r1.append(r2)     // Catch:{ all -> 0x00ac }
                java.lang.String r2 = r4.getMacAdress()     // Catch:{ all -> 0x00ac }
                r1.append(r2)     // Catch:{ all -> 0x00ac }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ac }
                com.tuya.smart.android.common.utils.L.d(r0, r1)     // Catch:{ all -> 0x00ac }
                com.tuya.smart.common.ooooo0o0o r0 = com.tuya.smart.common.ooooo0o0o.this     // Catch:{ all -> 0x00ac }
                com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum r0 = r0.O0000o     // Catch:{ all -> 0x00ac }
                com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum r1 = com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum.SEARCH     // Catch:{ all -> 0x00ac }
                if (r0 != r1) goto L_0x00aa
                com.tuya.smart.common.ooooo0o0o r0 = com.tuya.smart.common.ooooo0o0o.this     // Catch:{ all -> 0x00ac }
                com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum r1 = com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum.CONNECTING     // Catch:{ all -> 0x00ac }
                r0.O000000o((com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum) r1)     // Catch:{ all -> 0x00ac }
                java.lang.String r0 = "SigMeshLogin"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
                r1.<init>()     // Catch:{ all -> 0x00ac }
                java.lang.String r2 = "prepare connect: "
                r1.append(r2)     // Catch:{ all -> 0x00ac }
                java.lang.String r2 = r4.getMacAdress()     // Catch:{ all -> 0x00ac }
                r1.append(r2)     // Catch:{ all -> 0x00ac }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ac }
                com.tuya.smart.android.common.utils.L.d(r0, r1)     // Catch:{ all -> 0x00ac }
                com.tuya.smart.common.ooooo0o0o r0 = com.tuya.smart.common.ooooo0o0o.this     // Catch:{ all -> 0x00ac }
                com.tuya.smart.common.ooooo0o0o r1 = com.tuya.smart.common.ooooo0o0o.this     // Catch:{ all -> 0x00ac }
                com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean r1 = r1.O0000Ooo     // Catch:{ all -> 0x00ac }
                r0.O000000o((com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean) r1, (com.tuya.smart.android.blemesh.bean.SearchDeviceBean) r4)     // Catch:{ all -> 0x00ac }
                com.tuya.smart.common.ooooo0o0o r4 = com.tuya.smart.common.ooooo0o0o.this     // Catch:{ all -> 0x00ac }
                r4.O00000oO()     // Catch:{ all -> 0x00ac }
            L_0x00aa:
                monitor-exit(r3)
                return
            L_0x00ac:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.ooooo0o0o.AnonymousClass1.O000000o(com.tuya.smart.android.blemesh.bean.SearchDeviceBean):void");
        }

        public void O00000Oo() {
            L.d(ooooo0o0o.O0000Oo, "searchDeviceBean onSearchNothing");
            if (ooooo0o0o.this.O0000o == MeshClientStatusEnum.SEARCH) {
                ooooo0o0o.this.O000000o(MeshClientStatusEnum.INIT);
                ooooo0o0o ooooo0o0o = ooooo0o0o.this;
                ooooo0o0o.resultSuccess(ooooo0o0o.O000000o, ooooo0o0o.O0000Ooo);
            }
        }
    };
    public a O0000OoO;
    public TuyaSigMeshBean O0000Ooo;
    public MeshClientStatusEnum O0000o;
    public TuyaSigMeshBean O0000o0;
    public BlueMeshSearch O0000o00;
    public SearchDeviceBean O0000o0O;
    public final ITuyaBlueMesh O0000o0o;
    public a.e.a.a.o.h.a O0000oO = new SigMeshLogin$3(this);
    public boolean O0000oO0;

    public ooooo0o0o(SigMeshBean sigMeshBean, SafeHandler safeHandler) {
        super(TuyaSdk.getApplication(), safeHandler);
        this.O0000Ooo = new TuyaSigMeshBean(sigMeshBean);
        this.O0000OoO = o00o0o0o00.O000000o().O00000Oo();
        this.O0000o = MeshClientStatusEnum.INIT;
        this.O0000o00 = new BlueMeshSearch(TuyaSdk.getApplication());
        this.O0000o0o = new O000OO00(sigMeshBean.getMeshId());
    }

    /* access modifiers changed from: private */
    public void O000000o(TuyaSigMeshBean tuyaSigMeshBean, SearchDeviceBean searchDeviceBean) {
        this.O0000o0 = tuyaSigMeshBean;
        this.O0000o0O = searchDeviceBean;
        O000000o(searchDeviceBean.getMacAdress());
    }

    /* access modifiers changed from: private */
    public void O000000o(MeshClientStatusEnum meshClientStatusEnum) {
        this.O0000o = meshClientStatusEnum;
    }

    /* access modifiers changed from: private */
    public boolean O000000o(byte[] bArr, String str) {
        DeviceBean meshSubDevBeanByMac;
        return o00o0000oo.O0000o0(bArr) ? o00o0000oo.O000000o(this.O0000Ooo.getName(), bArr) : o00o0000oo.O0000o0O(bArr) && (meshSubDevBeanByMac = this.O0000o0o.getMeshSubDevBeanByMac(o00oo00ooo.O00000Oo(str))) != null && o00o0000oo.O000000o(this.O0000Ooo.getName(), bArr, o000oo0o0o.O000000o(meshSubDevBeanByMac.getNodeId()));
    }

    /* access modifiers changed from: private */
    public void O00000Oo(String str) {
        if (this.O0000oO != null) {
            StringBuilder q = a.a.a.a.a.q("unregisterConnectStatusListener:", str, "   Listener:");
            q.append(this.O0000oO);
            L.e(O0000Oo, q.toString());
            a aVar = this.O0000OoO;
            aVar.f3191a.b(str, this.O0000oO);
        }
    }

    private void O0000O0o() {
        StringBuilder n = a.a.a.a.a.n("startSearch  mSearching:");
        n.append(this.O0000o);
        L.e(O0000Oo, n.toString());
        MeshClientStatusEnum meshClientStatusEnum = this.O0000o;
        if (meshClientStatusEnum == MeshClientStatusEnum.INIT && meshClientStatusEnum != MeshClientStatusEnum.SEARCH) {
            L.d(O0000Oo, "startSearch");
            O000000o(MeshClientStatusEnum.SEARCH);
            this.O0000o00.searchDeviceUnConnect(this.O0000OOo, 10000, this.O0000Oo0);
        }
    }

    public void O000000o() {
        O0000O0o();
    }

    public void O000000o(o00o0o0o0o.O000000o o000000o) {
        if (this.O0000o0O != null) {
            L.e(O0000Oo, "doDiscoveryServices");
            a aVar = this.O0000OoO;
            aVar.f3191a.g(this.O0000o0O.getMacAdress(), new SigMeshLogin$4(this, o000000o));
        }
    }

    public void O00000Oo() {
        L.d(O0000Oo, "reLogin");
        if (this.O0000o0O == null || this.O0000o0 == null) {
            L.d(O0000Oo, "reLogin fail macAddress null");
            return;
        }
        O000000o(MeshClientStatusEnum.CONNECTING);
        O000000o(this.O0000o0O.getMacAdress());
    }

    public void O00000o() {
        if (this.O0000o0O != null) {
            L.e(O0000Oo, "doRefreshCache");
            a aVar = this.O0000OoO;
            aVar.f3191a.f(this.O0000o0O.getMacAdress());
        }
    }

    public void O00000o0() {
        L.d(O0000Oo, "stopConnect  mMeshLogin:" + this);
        O000000o(MeshClientStatusEnum.INIT);
        BlueMeshSearch blueMeshSearch = this.O0000o00;
        if (blueMeshSearch != null) {
            blueMeshSearch.stopSearch();
        }
        SearchDeviceBean searchDeviceBean = this.O0000o0O;
        if (searchDeviceBean != null) {
            String macAdress = searchDeviceBean.getMacAdress();
            L.d(O0000Oo, "stopConnect  macAdress:" + macAdress);
            if (!TextUtils.isEmpty(macAdress)) {
                a.a.a.a.a.v("disconnect:", macAdress, O0000Oo);
                this.O0000OoO.d(macAdress);
            }
        }
    }

    public void O00000oO() {
        if (this.O0000o == MeshClientStatusEnum.SEARCH) {
            O000000o(MeshClientStatusEnum.INIT);
        }
        BlueMeshSearch blueMeshSearch = this.O0000o00;
        if (blueMeshSearch != null) {
            blueMeshSearch.stopSearch();
        }
    }

    public MeshClientStatusEnum O00000oo() {
        return this.O0000o;
    }

    public void onDestroy() {
        O00000o0();
    }

    private void O000000o(String str) {
        BleConnectOptions.b bVar = new BleConnectOptions.b();
        bVar.f4321a = 3;
        bVar.f4323c = 10000;
        bVar.f4322b = 2;
        bVar.f4324d = RecyclerView.MAX_SCROLL_DURATION;
        this.O0000oO0 = true;
        this.O0000OoO.o(str, new BleConnectOptions(bVar), new SigMeshLogin$2(this, str));
        L.e(O0000Oo, "registerConnectStatusListener:" + str + DpTimerBean.FILL + this.O0000oO);
        a aVar = this.O0000OoO;
        aVar.f3191a.l(str, this.O0000oO);
    }
}
