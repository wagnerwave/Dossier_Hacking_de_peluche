package com.tuya.smart.common;

import com.tuya.smart.android.blemesh.api.BusinessResultListener;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.bluemesh.IRequestSigMeshListCallback;
import com.tuya.smart.sdk.api.bluemesh.ISigMeshCreateCallback;
import com.tuya.smart.sdk.api.bluemesh.ISigMeshManager;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;
import java.util.List;

public class ooooo00oo extends BasePresenter implements ISigMeshManager {
    public O0000OOo O000000o;

    public static class O000000o {
        public static final ooooo00oo O000000o = new ooooo00oo();
    }

    public ooooo00oo() {
        this.O000000o = new O0000OOo(TuyaSdk.getApplication(), this.mHandler);
    }

    public static ISigMeshManager O000000o() {
        return O000000o.O000000o;
    }

    public void createSigMesh(long j, ISigMeshCreateCallback iSigMeshCreateCallback) {
        this.O000000o.O000000o(j, iSigMeshCreateCallback);
    }

    public SigMeshBean getSigMeshBean(String str) {
        return oooo0o000.O000000o().O000000o(str);
    }

    public List<SigMeshBean> getSigMeshList() {
        return oooo0o000.O000000o().O000000o();
    }

    public void onDestroy() {
        super.onDestroy();
        oooo0o000.O00000Oo();
    }

    public void requestSigMeshList(long j, final IRequestSigMeshListCallback iRequestSigMeshListCallback) {
        new O0OOo().getSigMeshList(j, new BusinessResultListener<ArrayList<SigMeshBean>, BusinessResponse>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<SigMeshBean> arrayList, String str) {
                IRequestSigMeshListCallback iRequestSigMeshListCallback = iRequestSigMeshListCallback;
                if (iRequestSigMeshListCallback != null) {
                    iRequestSigMeshListCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, ArrayList<SigMeshBean> arrayList, String str) {
                IRequestSigMeshListCallback iRequestSigMeshListCallback = iRequestSigMeshListCallback;
                if (iRequestSigMeshListCallback != null) {
                    iRequestSigMeshListCallback.onSuccess(arrayList);
                }
            }
        });
    }

    public void updateSigMesh(List<SigMeshBean> list) {
        oooo0o000.O000000o().O000000o(list);
    }
}
