package com.tuya.smart.common;

import com.tuya.smart.sdk.bean.BlueMeshGroupBean;
import com.tuya.smart.sdk.bean.BlueMeshRoomBean;
import com.tuya.smart.sdk.bean.BlueMeshSubDevBean;
import java.util.ArrayList;
import java.util.List;

public class O00OOOo {
    public List<BlueMeshSubDevBean> O000000o;
    public List<BlueMeshGroupBean> O00000Oo;
    public List<BlueMeshRoomBean> O00000o0;

    public List<BlueMeshSubDevBean> O000000o() {
        return this.O000000o;
    }

    public void O000000o(BlueMeshGroupBean blueMeshGroupBean) {
        if (this.O00000Oo == null) {
            this.O00000Oo = new ArrayList();
        }
        this.O00000Oo.add(blueMeshGroupBean);
    }

    public void O000000o(BlueMeshRoomBean blueMeshRoomBean) {
        if (this.O00000o0 == null) {
            this.O00000o0 = new ArrayList();
        }
        this.O00000o0.add(blueMeshRoomBean);
    }

    public void O000000o(BlueMeshSubDevBean blueMeshSubDevBean) {
        if (this.O000000o == null) {
            this.O000000o = new ArrayList();
        }
        this.O000000o.add(blueMeshSubDevBean);
    }

    public void O000000o(List<BlueMeshSubDevBean> list) {
        this.O000000o = list;
    }

    public List<BlueMeshGroupBean> O00000Oo() {
        return this.O00000Oo;
    }

    public void O00000Oo(List<BlueMeshGroupBean> list) {
        this.O00000Oo = list;
    }

    public List<BlueMeshRoomBean> O00000o0() {
        return this.O00000o0;
    }

    public void O00000o0(List<BlueMeshRoomBean> list) {
        this.O00000o0 = list;
    }
}
