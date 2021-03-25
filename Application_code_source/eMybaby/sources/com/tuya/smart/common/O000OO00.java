package com.tuya.smart.common;

import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.interior.enums.BizParentTypeEnum;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddGroupCallback;
import com.tuya.smart.sdk.api.bluemesh.IAddSubDevCallback;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;

public class O000OO00 extends BasePresenter implements ITuyaBlueMesh {
    public final String O000000o;
    public O0000Oo O00000Oo = new O0000OOo(TuyaSdk.getApplication(), this.mHandler);

    public O000OO00(String str) {
        this.O000000o = str;
    }

    public void addGroup(String str, String str2, String str3, IAddGroupCallback iAddGroupCallback) {
        if (ooooo00oo.O000000o().getSigMeshBean(this.O000000o) != null) {
            this.O00000Oo.O000000o(str, str3, this.O000000o, BizParentTypeEnum.MESH.getType(), str2, 3, iAddGroupCallback);
            return;
        }
        this.O00000Oo.O000000o(str, str3, this.O000000o, BizParentTypeEnum.MESH.getType(), str2, 1, iAddGroupCallback);
    }

    public void addSubDev(String str, String str2, String str3, String str4, String str5, IAddSubDevCallback iAddSubDevCallback) {
        this.O00000Oo.O000000o(this.O000000o, str, str2, str3, str4, str5, iAddSubDevCallback);
    }

    public void addSubDev(String str, String str2, String str3, String str4, String str5, String str6, String str7, IAddSubDevCallback iAddSubDevCallback) {
        this.O00000Oo.O000000o(this.O000000o, str, str2, str3, str4, str5, str6, str7, iAddSubDevCallback);
    }

    public void broadcastDps(String str, String str2, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(this.O000000o, (String) null, str, str2, 1, iResultCallback);
    }

    public void getDataByDpIds(String str, List<Integer> list, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(this.O000000o, str, list, iResultCallback);
    }

    public DeviceBean getMeshSubDevBean(String str) {
        return ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OoO().O00000Oo(str);
    }

    public DeviceBean getMeshSubDevBeanByMac(String str) {
        return ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OoO().O00000o(this.O000000o, str);
    }

    public DeviceBean getMeshSubDevBeanByNodeId(String str) {
        return ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OoO().O00000o0(this.O000000o, str);
    }

    public List<DeviceBean> getMeshSubDevList() {
        return ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OoO().O00000o(this.O000000o);
    }

    public boolean isCloudOnline() {
        for (DeviceBean next : getMeshSubDevList()) {
            if (next.isBleMeshWifi() && next.isCloudOnline()) {
                return true;
            }
        }
        return false;
    }

    public void multicastDps(String str, String str2, String str3, IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(this.O000000o, str, str2, str3, 2, iResultCallback);
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000Oo.onDestroy();
    }

    public void publishDps(String str, String str2, String str3, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(this.O000000o, str, str2, str3, 0, iResultCallback);
    }

    public void publishRawData(byte[] bArr, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(this.O000000o, bArr, iResultCallback);
    }

    public void removeMesh(IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(this.O000000o, iResultCallback);
    }

    public void removeMeshSubDev(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(str, this.O000000o, iResultCallback);
    }

    public void renameMesh(String str, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(this.O000000o, str, iResultCallback);
    }

    public void renameMeshSubDev(String str, String str2, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(this.O000000o, str, str2, iResultCallback);
    }
}
