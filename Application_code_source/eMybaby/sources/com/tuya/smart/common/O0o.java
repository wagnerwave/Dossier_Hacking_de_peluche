package com.tuya.smart.common;

import android.os.Handler;
import android.os.Message;
import com.tuya.sdk.tuyamesh.blemesh.search.BlueMeshSearch;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshSearch;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshSearchListener;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.builder.SearchBuilder;
import com.tuya.smart.sdk.TuyaSdk;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class O0o implements ITuyaBlueMeshSearch {
    public static final int O000000o = 1001;
    public final BlueMeshSearch O00000Oo = new BlueMeshSearch(TuyaSdk.getApplication());
    public final UUID[] O00000o;
    public final String O00000o0;
    public final int O00000oO;
    public ITuyaBlueMeshSearchListener O00000oo;
    public boolean O0000O0o;
    public Handler O0000OOo = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1001 || O0o.this.O00000oo == null) {
                return false;
            }
            O0o.this.O00000oo.onSearchFinish();
            return false;
        }
    });
    public Map<String, SearchDeviceBean> O0000Oo0 = new HashMap();

    public O0o(SearchBuilder searchBuilder) {
        this.O00000o0 = searchBuilder.getMeshName();
        this.O00000o = searchBuilder.getServiceUUIDs();
        this.O00000oo = searchBuilder.getTuyaBlueMeshSearchListener();
        this.O00000oO = searchBuilder.getTimeOut();
    }

    public void startSearch() {
        if (!this.O0000O0o) {
            this.O00000Oo.searchDeviceUnConnect(this.O00000o0, this.O00000o, (long) this.O00000oO, new o00oo00o00() {
                public void O000000o() {
                }

                public void O000000o(SearchDeviceBean searchDeviceBean) {
                    if (O0o.this.O0000Oo0.get(searchDeviceBean.getMacAdress()) == null) {
                        if (O0o.this.O00000oo != null) {
                            O0o.this.O00000oo.onSearched(searchDeviceBean);
                        }
                        O0o.this.O0000Oo0.put(searchDeviceBean.getMacAdress(), searchDeviceBean);
                    }
                }

                public void O00000Oo() {
                }
            });
            this.O0000OOo.sendEmptyMessageDelayed(1001, (long) this.O00000oO);
        }
    }

    public void stopSearch() {
        this.O0000O0o = true;
        this.O00000Oo.stopSearch();
        this.O00000oo = null;
        this.O0000OOo.removeMessages(1001);
    }
}
