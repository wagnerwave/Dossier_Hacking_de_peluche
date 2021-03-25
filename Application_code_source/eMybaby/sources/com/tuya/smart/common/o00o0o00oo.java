package com.tuya.smart.common;

import com.tuya.smart.sdk.bean.BlueMeshBean;
import java.util.ArrayList;
import java.util.List;

public class o00o0o00oo extends BlueMeshBean {
    public int O000000o;
    public String O00000Oo;
    public byte[] O00000o;
    public int O00000o0;
    public List<Integer> O00000oO;

    public o00o0o00oo() {
    }

    public o00o0o00oo(BlueMeshBean blueMeshBean) {
        setMeshId(blueMeshBean.getMeshId());
        setCode(blueMeshBean.getCode());
        setPassword(blueMeshBean.getPassword());
        setShare(blueMeshBean.isShare());
        setLocalKey(blueMeshBean.getLocalKey());
        setName(blueMeshBean.getName());
        setPv(blueMeshBean.getPv());
    }

    public int O000000o() {
        return this.O000000o;
    }

    public void O000000o(int i) {
        this.O000000o = i;
    }

    public void O000000o(String str) {
        this.O00000Oo = str;
    }

    public void O000000o(byte[] bArr) {
        if (bArr != null) {
            this.O00000o = (byte[]) bArr.clone();
        } else {
            this.O00000o = null;
        }
    }

    public String O00000Oo() {
        return this.O00000Oo;
    }

    public void O00000Oo(int i) {
        this.O00000o0 = i;
    }

    public byte[] O00000o() {
        byte[] bArr = this.O00000o;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public int O00000o0() {
        return this.O00000o0;
    }

    public int O00000oO() {
        int O00000Oo2 = o00oo00ooo.O00000Oo(this.O00000oO);
        if (O00000Oo2 != -1) {
            if (this.O00000oO == null) {
                this.O00000oO = new ArrayList();
            }
            this.O00000oO.add(Integer.valueOf(O00000Oo2));
        }
        return O00000Oo2;
    }
}
