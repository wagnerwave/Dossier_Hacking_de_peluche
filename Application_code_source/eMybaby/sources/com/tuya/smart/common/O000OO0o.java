package com.tuya.smart.common;

import com.tuya.smart.android.blemesh.api.BusinessResultListener;
import com.tuya.smart.android.blemesh.bean.BLEUpgradeBean;
import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.bluemesh.IBlueMeshCreateCallback;
import com.tuya.smart.sdk.api.bluemesh.IBlueMeshManager;
import com.tuya.smart.sdk.api.bluemesh.IRequestMeshListCallback;
import com.tuya.smart.sdk.api.bluemesh.IRequestUpgradeInfoCallback;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class O000OO0o extends BasePresenter implements IBlueMeshManager {
    public O0000OOo O000000o;

    public static class O000000o {
        public static final O000OO0o O000000o = new O000OO0o();
    }

    public O000OO0o() {
        this.O000000o = new O0000OOo(TuyaSdk.getApplication(), this.mHandler);
    }

    public static IBlueMeshManager O000000o() {
        return O000000o.O000000o;
    }

    public void createBlueMesh(long j, String str, IBlueMeshCreateCallback iBlueMeshCreateCallback) {
        this.O000000o.O000000o(j, str, iBlueMeshCreateCallback);
    }

    public BlueMeshBean getBlueMeshBean(String str) {
        return O000O0o0.O000000o().O000000o(str);
    }

    public List<BlueMeshBean> getBlueMeshList() {
        return O000O0o0.O000000o().O000000o();
    }

    public DpsParseBean getTuyaMeshParseBean(String str, String str2) {
        return OO00o00.O00000Oo(str).O00000o(str2);
    }

    public void onDestroy() {
        super.onDestroy();
        O000O0o0.O00000Oo();
    }

    public String parseVenderIdFromDp(Set set, String str) {
        return OO00o00.O000000o(set, str);
    }

    public void requestMeshList(long j, final IRequestMeshListCallback iRequestMeshListCallback) {
        new O0OOo().getMeshList(j, new BusinessResultListener<ArrayList<BlueMeshBean>, BusinessResponse>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<BlueMeshBean> arrayList, String str) {
                IRequestMeshListCallback iRequestMeshListCallback = iRequestMeshListCallback;
                if (iRequestMeshListCallback != null) {
                    iRequestMeshListCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<BlueMeshBean> arrayList, String str) {
                IRequestMeshListCallback iRequestMeshListCallback = iRequestMeshListCallback;
                if (iRequestMeshListCallback != null) {
                    iRequestMeshListCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void requestUpgradeInfo(String str, final IRequestUpgradeInfoCallback iRequestUpgradeInfoCallback) {
        new O0OOo().meshFirmwareUpgradeCheck(str, new BusinessResultListener<ArrayList<BLEUpgradeBean>, BusinessResponse>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<BLEUpgradeBean> arrayList, String str) {
                IRequestUpgradeInfoCallback iRequestUpgradeInfoCallback = iRequestUpgradeInfoCallback;
                if (iRequestUpgradeInfoCallback != null) {
                    iRequestUpgradeInfoCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<BLEUpgradeBean> arrayList, String str) {
                IRequestUpgradeInfoCallback iRequestUpgradeInfoCallback = iRequestUpgradeInfoCallback;
                if (iRequestUpgradeInfoCallback != null) {
                    iRequestUpgradeInfoCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void updateBuleMesh(List<BlueMeshBean> list) {
        O000O0o0.O000000o().O000000o(list);
    }
}
