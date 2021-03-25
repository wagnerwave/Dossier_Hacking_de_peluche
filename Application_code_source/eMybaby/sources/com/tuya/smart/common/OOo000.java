package com.tuya.smart.common;

import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.home.sdk.api.IGwSearchListener;
import com.tuya.smart.home.sdk.api.ITuyaGwSearcher;
import com.tuya.smart.interior.enums.ActiveEnum;
import java.util.HashMap;
import java.util.List;

public class OOo000 implements o0oo00oo00, ITuyaGwSearcher {
    public IGwSearchListener O000000o;
    public HashMap<String, HgwBean> O00000Oo = new HashMap<>();
    public o0o00o0o00 O00000o0 = ((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class));

    private void O000000o(HgwBean hgwBean) {
        if (this.O000000o != null && this.O00000Oo.get(hgwBean.getGwId()) == null) {
            this.O00000Oo.put(hgwBean.getGwId(), hgwBean);
            this.O000000o.onDevFind(hgwBean);
        }
    }

    private boolean O00000Oo(HgwBean hgwBean) {
        return hgwBean != null && hgwBean.isToken() && hgwBean.getActive() == ActiveEnum.UNACTIVE.getType();
    }

    public void O000000o(List<HgwBean> list) {
        if (list != null) {
            for (HgwBean next : list) {
                if (O00000Oo(next)) {
                    O000000o(next);
                }
            }
        }
    }

    public void registerGwSearchListener(IGwSearchListener iGwSearchListener) {
        List<HgwBean> O00000o;
        if (this.O000000o == null) {
            this.O000000o = iGwSearchListener;
            o0o00o0o00 o0o00o0o00 = this.O00000o0;
            if (o0o00o0o00 != null) {
                o0o00o0o00.O000000o().O000000o((o0oo00oo00) this);
            }
            o0o00o0o00 o0o00o0o002 = this.O00000o0;
            if (o0o00o0o002 != null && (O00000o = o0o00o0o002.O000000o().O00000o()) != null) {
                for (HgwBean next : O00000o) {
                    if (O00000Oo(next)) {
                        O000000o(next);
                    }
                }
            }
        }
    }

    public void unRegisterGwSearchListener() {
        if (this.O000000o != null) {
            o0o00o0o00 o0o00o0o00 = this.O00000o0;
            if (o0o00o0o00 != null) {
                o0o00o0o00.O000000o().O00000Oo((o0oo00oo00) this);
            }
            this.O000000o = null;
            this.O00000Oo.clear();
        }
    }
}
