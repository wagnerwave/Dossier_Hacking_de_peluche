package com.tuya.smart.common;

import a.a.a.a.a;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tuya.sdk.device.bean.OtaProgressEventBean;
import com.tuya.sdk.device.bean.OtaUpdateEventBean;
import com.tuya.sdk.device.bean.RomUpdateBean;
import com.tuya.sdk.device.bean.RomUpdateProgressEventBean;
import com.tuya.sdk.device.enums.RomUpgradeStatusEnum;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.device.bean.HardwareUpgradeBean;
import com.tuya.smart.android.device.bean.UpgradeInfoBean;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.common.oO000O0O;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IGetOtaInfoCallback;
import com.tuya.smart.sdk.api.IOtaListener;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaOta;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.List;

public class oO0O000o extends BasePresenter implements o0OO0o00, o0OOOO0o, o0OOo000, o0OOoOO0, ITuyaOta {
    public static final String O000000o = "TuyaOtaPresenter";
    public String O00000Oo;
    public final oO000O0O O00000o;
    public String O00000o0;
    public String O00000oO;
    public IOtaListener O00000oo;
    public volatile boolean O0000O0o;
    public HardwareUpgradeBean O0000OOo;
    public oO000Oo0 O0000Oo = new oO000Oo0() {
        public void O000000o() {
        }

        public void O000000o(int i) {
        }

        public void O000000o(String str, String str2) {
            if (oO0O000o.this.O00000oo != null) {
                oO0O000o.this.O00000oo.onFailure(-1, str, str2);
            }
        }

        public void O00000Oo() {
        }

        public void O00000o() {
        }

        public void O00000o0() {
        }
    };
    public boolean O0000Oo0 = true;

    /* renamed from: com.tuya.smart.common.oO0O000o$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] O000000o;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.tuya.sdk.device.enums.RomUpdateEnum[] r0 = com.tuya.sdk.device.enums.RomUpdateEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                O000000o = r0
                r1 = 2
                com.tuya.sdk.device.enums.RomUpdateEnum r2 = com.tuya.sdk.device.enums.RomUpdateEnum.UPDATED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = O000000o     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.tuya.sdk.device.enums.RomUpdateEnum r2 = com.tuya.sdk.device.enums.RomUpdateEnum.ERROR     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 3
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oO0O000o.AnonymousClass2.<clinit>():void");
        }
    }

    public oO0O000o(Application application, String str, String str2, String str3) {
        this.O00000oO = str;
        this.O00000o0 = str2;
        this.O00000Oo = str3;
        this.O00000o = new oO000O0O(str2, application, this.mHandler);
        TuyaSdk.getEventBus().register(this);
    }

    public oO0O000o(Context context, String str) {
        this.O00000o0 = str;
        this.O00000o = new oO000O0O(str, context, this.mHandler);
        TuyaSdk.getEventBus().register(this);
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        if (dev != null) {
            this.O0000Oo0 = TuyaUtil.checkBvVersion(dev.getBv(), 3.0f);
        }
    }

    private void O000000o() {
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O00000o0);
        if (dev == null) {
            IOtaListener iOtaListener = this.O00000oo;
            if (iOtaListener != null) {
                iOtaListener.onFailure(-1, "11002", "device has been removed");
            }
        } else if (dev.isBleMesh() || !TextUtils.isEmpty(dev.getCadv()) || dev.isZigBeeSubDev()) {
            getOtaInfo(new IGetOtaInfoCallback() {
                public void onFailure(String str, String str2) {
                    if (oO0O000o.this.O00000oo != null) {
                        oO0O000o.this.O00000oo.onFailure(-1, str, str2);
                    }
                }

                public void onSuccess(List<UpgradeInfoBean> list) {
                    int O00000Oo;
                    if (oO0O000o.O00000o0(list) == -1 && (O00000Oo = oO0O000o.O00000o(list)) != -1) {
                        oO0O000o.this.O000000o(O00000Oo);
                    }
                }
            });
        } else if (this.O0000Oo0) {
            this.O00000o.O000000o((oO000o00) new oO000o00() {
                public void O000000o(HardwareUpgradeBean hardwareUpgradeBean) {
                    HardwareUpgradeBean unused = oO0O000o.this.O0000OOo = hardwareUpgradeBean;
                    if (oO0O000o.O00000Oo(hardwareUpgradeBean)) {
                        oO0O000o.this.O00000o.O000000o(oO0O000o.this.O0000Oo);
                    } else if (oO0O000o.O000000o(hardwareUpgradeBean)) {
                        oO0O000o.this.O00000o.O00000Oo(oO0O000o.this.O0000Oo);
                    }
                }

                public void O000000o(String str, String str2) {
                    if (oO0O000o.this.O00000oo != null) {
                        oO0O000o.this.O00000oo.onFailure(-1, str, str2);
                    }
                }
            });
        } else {
            this.O00000o.O000000o((IGetOtaInfoCallback) new IGetOtaInfoCallback() {
                public void onFailure(String str, String str2) {
                    if (oO0O000o.this.O00000oo != null) {
                        oO0O000o.this.O00000oo.onFailure(-1, str, str2);
                    }
                }

                public void onSuccess(List<UpgradeInfoBean> list) {
                    int O00000Oo;
                    if (oO0O000o.O00000o0(list) == -1 && (O00000Oo = oO0O000o.O00000o(list)) != -1) {
                        oO0O000o.this.O000000o(O00000Oo);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(final int i) {
        this.O00000o.O000000o(i, new oO000O0O.O000000o() {
            public void O000000o() {
            }

            public void O000000o(String str, String str2) {
                if (oO0O000o.this.O00000oo != null) {
                    oO0O000o.this.O00000oo.onFailure(i, str, str2);
                }
            }
        });
    }

    private void O000000o(RomUpdateBean romUpdateBean) {
        IOtaListener iOtaListener;
        int i = AnonymousClass2.O000000o[romUpdateBean.getStatus().ordinal()];
        if (i == 1) {
            IOtaListener iOtaListener2 = this.O00000oo;
            if (iOtaListener2 != null) {
                iOtaListener2.onSuccess(this.O0000OOo.getDev().getType());
            }
            O000000o();
        } else if (i == 2 && (iOtaListener = this.O00000oo) != null) {
            iOtaListener.onFailure(this.O0000OOo.getDev().getType(), o0OoO00O.O0000o0o, (String) null);
        }
    }

    private void O000000o(String str) {
        oO0OO000.O000000o().queryDev(str, new ITuyaDataCallback<DeviceBean>() {
            /* renamed from: O000000o */
            public void onSuccess(DeviceBean deviceBean) {
            }

            public void onError(String str, String str2) {
            }
        });
    }

    public static boolean O000000o(HardwareUpgradeBean hardwareUpgradeBean) {
        UpgradeInfoBean gw = hardwareUpgradeBean.getGw();
        return gw != null && RomUpgradeStatusEnum.to(gw.getUpgradeStatus()) == RomUpgradeStatusEnum.NEW_VERSION;
    }

    public static boolean O00000Oo(HardwareUpgradeBean hardwareUpgradeBean) {
        UpgradeInfoBean dev = hardwareUpgradeBean.getDev();
        return dev != null && RomUpgradeStatusEnum.to(dev.getUpgradeStatus()) == RomUpgradeStatusEnum.NEW_VERSION;
    }

    public static int O00000o(List<UpgradeInfoBean> list) {
        if (list == null || list.size() <= 0) {
            return -1;
        }
        for (UpgradeInfoBean next : list) {
            StringBuilder n = a.n("type = ");
            n.append(next.getUpgradeType());
            n.append("---current=");
            n.append(next.getCurrentVersion());
            n.append("--version=");
            n.append(next.getVersion());
            n.append("---status=");
            n.append(next.getUpgradeStatus());
            L.d(O000000o, n.toString());
            if (next.getUpgradeStatus() == 1) {
                return next.getType();
            }
        }
        return -1;
    }

    public static int O00000o0(List<UpgradeInfoBean> list) {
        if (list == null || list.size() <= 0) {
            return -1;
        }
        for (UpgradeInfoBean next : list) {
            if (next.getUpgradeStatus() == 2) {
                return next.getType();
            }
        }
        return -1;
    }

    public void getOtaInfo(final IGetOtaInfoCallback iGetOtaInfoCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O00000o0);
        if (dev == null) {
            IOtaListener iOtaListener = this.O00000oo;
            if (iOtaListener != null) {
                iOtaListener.onFailure(-1, "11002", "device has been removed");
            }
        } else if (dev.isBleMesh() || !TextUtils.isEmpty(dev.getCadv()) || dev.isZigBeeSubDev()) {
            this.O00000o.O000000o((Business.ResultListener<ArrayList<UpgradeInfoBean>>) new Business.ResultListener<ArrayList<UpgradeInfoBean>>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, ArrayList<UpgradeInfoBean> arrayList, String str) {
                    IGetOtaInfoCallback iGetOtaInfoCallback = iGetOtaInfoCallback;
                    if (iGetOtaInfoCallback != null) {
                        iGetOtaInfoCallback.onFailure(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                    }
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, ArrayList<UpgradeInfoBean> arrayList, String str) {
                    IGetOtaInfoCallback iGetOtaInfoCallback = iGetOtaInfoCallback;
                    if (iGetOtaInfoCallback != null) {
                        iGetOtaInfoCallback.onSuccess(arrayList);
                    }
                }
            });
        } else if (this.O0000Oo0) {
            this.O00000o.O000000o((oO000o00) new oO000o00() {
                public void O000000o(HardwareUpgradeBean hardwareUpgradeBean) {
                    HardwareUpgradeBean unused = oO0O000o.this.O0000OOo = hardwareUpgradeBean;
                    ArrayList arrayList = new ArrayList();
                    if (hardwareUpgradeBean.getGw() != null) {
                        arrayList.add(hardwareUpgradeBean.getGw());
                    }
                    if (hardwareUpgradeBean.getDev() != null) {
                        arrayList.add(hardwareUpgradeBean.getDev());
                    }
                    IGetOtaInfoCallback iGetOtaInfoCallback = iGetOtaInfoCallback;
                    if (iGetOtaInfoCallback != null) {
                        iGetOtaInfoCallback.onSuccess(arrayList);
                    }
                }

                public void O000000o(String str, String str2) {
                    IGetOtaInfoCallback iGetOtaInfoCallback = iGetOtaInfoCallback;
                    if (iGetOtaInfoCallback != null) {
                        iGetOtaInfoCallback.onFailure(str, str2);
                    }
                }
            });
        } else {
            this.O00000o.O000000o((IGetOtaInfoCallback) new IGetOtaInfoCallback() {
                public void onFailure(String str, String str2) {
                    IGetOtaInfoCallback iGetOtaInfoCallback = iGetOtaInfoCallback;
                    if (iGetOtaInfoCallback != null) {
                        iGetOtaInfoCallback.onFailure(str, str2);
                    }
                }

                public void onSuccess(List<UpgradeInfoBean> list) {
                    IGetOtaInfoCallback iGetOtaInfoCallback = iGetOtaInfoCallback;
                    if (iGetOtaInfoCallback != null) {
                        iGetOtaInfoCallback.onSuccess(list);
                    }
                }
            });
        }
    }

    public void onDestroy() {
        this.O00000o.onDestroy();
        TuyaSdk.getEventBus().unregister(this);
    }

    public void onEvent(OtaProgressEventBean otaProgressEventBean) {
        if (TextUtils.isEmpty(otaProgressEventBean.getMeshId()) || TextUtils.isEmpty(otaProgressEventBean.getCid())) {
            if (!TextUtils.equals(otaProgressEventBean.getDevId(), this.O00000o0) && !TextUtils.equals(otaProgressEventBean.getMeshId(), this.O00000o0)) {
                return;
            }
        } else if (!TextUtils.equals(this.O00000oO, otaProgressEventBean.getMeshId()) || !TextUtils.equals(this.O00000Oo, otaProgressEventBean.getCid())) {
            return;
        }
        L.d(O000000o, otaProgressEventBean.toString());
        IOtaListener iOtaListener = this.O00000oo;
        if (iOtaListener != null) {
            iOtaListener.onProgress(otaProgressEventBean.getFirmwareType(), TuyaUtil.stringToInt(otaProgressEventBean.getProgress()));
        }
    }

    public void onEvent(OtaUpdateEventBean otaUpdateEventBean) {
        IOtaListener iOtaListener;
        if (TextUtils.equals(otaUpdateEventBean.getDevId(), this.O00000o0)) {
            L.d(O000000o, otaUpdateEventBean.toString());
            int i = AnonymousClass2.O000000o[otaUpdateEventBean.getStatus().ordinal()];
            if (i == 1) {
                IOtaListener iOtaListener2 = this.O00000oo;
                if (iOtaListener2 != null) {
                    iOtaListener2.onSuccess(otaUpdateEventBean.getFirmwareType());
                }
                O000000o(otaUpdateEventBean.getDevId());
                O000000o();
            } else if (i == 2 && (iOtaListener = this.O00000oo) != null) {
                iOtaListener.onFailure(otaUpdateEventBean.getFirmwareType(), o0OoO00O.O0000o0o, (String) null);
            }
        }
    }

    public void onEventMainThread(RomUpdateBean romUpdateBean) {
        if (TextUtils.isEmpty(romUpdateBean.devId) || TextUtils.isEmpty(romUpdateBean.gwId)) {
            if (TextUtils.isEmpty(romUpdateBean.gwId) || !TextUtils.equals(romUpdateBean.getGwId(), this.O00000o0)) {
                return;
            }
        } else if (!TextUtils.equals(romUpdateBean.getDevId(), this.O00000o0)) {
            return;
        }
        O000000o(romUpdateBean);
    }

    public void onEventMainThread(RomUpdateProgressEventBean romUpdateProgressEventBean) {
        UpgradeInfoBean upgradeInfoBean;
        IOtaListener iOtaListener;
        if (TextUtils.isEmpty(romUpdateProgressEventBean.devId) || TextUtils.isEmpty(romUpdateProgressEventBean.gwId)) {
            if (!TextUtils.isEmpty(romUpdateProgressEventBean.gwId) && TextUtils.equals(romUpdateProgressEventBean.getGwId(), this.O00000o0)) {
                iOtaListener = this.O00000oo;
                upgradeInfoBean = this.O0000OOo.getGw();
            } else {
                return;
            }
        } else if (TextUtils.equals(romUpdateProgressEventBean.getDevId(), this.O00000o0)) {
            iOtaListener = this.O00000oo;
            upgradeInfoBean = this.O0000OOo.getDev();
        } else {
            return;
        }
        iOtaListener.onProgress(upgradeInfoBean.getType(), Integer.parseInt(romUpdateProgressEventBean.getProgress()));
    }

    public void setOtaListener(IOtaListener iOtaListener) {
        this.O00000oo = iOtaListener;
    }

    public void startOta() {
        if (!this.O0000O0o) {
            this.O0000O0o = true;
            O000000o();
        }
    }
}
