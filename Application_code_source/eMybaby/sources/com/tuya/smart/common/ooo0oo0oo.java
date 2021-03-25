package com.tuya.smart.common;

import a.a.a.a.a;
import a.e.a.a.o.j.e;
import a.e.a.a.o.j.i;
import com.tuya.sdk.sigmesh.action.SigNewOtaAction$3;
import com.tuya.sdk.sigmesh.action.SigNewOtaAction$4;
import com.tuya.sdk.sigmesh.action.SigNewOtaAction$5;
import com.tuya.sdk.sigmesh.bean.DeviceInfoRep;
import com.tuya.sdk.sigmesh.bean.OTAFileRep;
import com.tuya.sdk.sigmesh.bean.OTAOffsetRep;
import com.tuya.sdk.sigmesh.bean.OTAResultRep;
import com.tuya.sdk.sigmesh.bean.OTASendRep;
import com.tuya.sdk.sigmesh.bean.OTAStartRep;
import com.tuya.sdk.sigmesh.bean.Reps;
import com.tuya.sdk.sigmesh.bean.Ret;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0oo0oo;
import com.tuya.smart.common.ooo0oo0o0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ooo0oo0oo extends o00o0oo0oo {
    public static final String O00000Oo = "SigNewOtaAction";
    public ooo0oo0o0 O000000o = null;
    public String O00000o0;
    public byte[] O0000o = {-1, -1, -1, -1};
    public byte[] O0000o0 = new byte[0];
    public o00o000o00 O0000o00 = new o00o000o00();
    public int O0000o0O = 10;
    public byte[] O0000o0o;
    public int O0000oO = 0;
    public String O0000oO0;
    public int O0000oOO;
    public o00o000ooo O0000oOo = new o00o000ooo();
    public ooo0oo0o0.O000000o O0000oo = new ooo0oo0o0.O000000o() {
        public void O000000o(String str) {
            ooo0oo0oo.this.O0000OoO.postDelayed(new Runnable() {
                public void run() {
                    ooo0oo0oo.this.O0000OoO();
                }
            }, 1000);
        }

        public void O000000o(String str, String str2) {
            if (ooo0oo0oo.this.O0000OOo != null) {
                ooo0oo0oo.this.O0000OOo.O000000o(String.valueOf(str), "start notify error");
            }
        }

        public void O000000o(byte[] bArr) {
            Ret O000000o2 = ooo0oo0oo.this.O0000oOo.O000000o(bArr, ooo0oo0oo.this.O00000o0, ooo0oo0oo.this.O0000o0);
            if (O000000o2 != null) {
                if (!O000000o2.reps.success()) {
                    o00oo0oo00.O00000Oo(ooo0oo0oo.O00000Oo, "onNotificationReceived: parse error " + O000000o2);
                }
                ooo0oo0oo.this.O000000o(O000000o2);
            }
        }

        public void O00000Oo() {
        }
    };
    public DeviceInfoRep O0000oo0;

    public ooo0oo0oo(o00oo0000o o00oo0000o) {
        super(o00oo0000o);
        this.O00000o0 = o00oo0000o.O000000o();
        this.O0000oO0 = o00oo0000o.O0000OoO();
    }

    private void O000000o(int i) {
        o00oo0oo00.O00000Oo(O00000Oo, "sendOTAOffset");
        O000000o(o00o0000oo.O000000o(new byte[]{0}, o00o0000oo.O00000o(i)), o00o0000oo.O00000Oo(this.O00000o0, this.O0000o0), 14, (byte[]) null, 5);
    }

    /* access modifiers changed from: private */
    public void O000000o(Ret ret) {
        String str;
        o00o0oo0oo.O000000o o000000o;
        String str2;
        o00o0oo0oo.O000000o o000000o2;
        String str3;
        String str4;
        o00o0oo0oo.O000000o o000000o3;
        String str5;
        o00oo0oo00.O000000o(O00000Oo, ret.toString());
        int i = ret.code;
        if (i == 0) {
            if (ret.reps.success()) {
                Reps reps = ret.reps;
                if (reps instanceof DeviceInfoRep) {
                    DeviceInfoRep deviceInfoRep = (DeviceInfoRep) reps;
                    this.O0000oo0 = deviceInfoRep;
                    this.O0000o0 = deviceInfoRep.srand;
                    O0000Ooo();
                    return;
                }
            }
            o000000o2 = this.O0000OOo;
            if (o000000o2 != null) {
                str3 = O00OOo.O000Oo0;
                str4 = "get device info fail";
            } else {
                return;
            }
        } else {
            if (i == 12) {
                boolean success = ret.reps.success();
                str = O00OOo.O000Oo0O;
                if (success) {
                    Reps reps2 = ret.reps;
                    if (reps2 instanceof OTAStartRep) {
                        if (!((OTAStartRep) reps2).allowUpdate || ((OTAStartRep) reps2).otaVersion != 3) {
                            o000000o = this.O0000OOo;
                            if (o000000o != null) {
                                str2 = "start ota rep not allow";
                            } else {
                                return;
                            }
                        } else {
                            O00000Oo(((OTAStartRep) reps2).maxLimit);
                            O0000o00();
                            return;
                        }
                    }
                }
                o000000o = this.O0000OOo;
                if (o000000o != null) {
                    str2 = "ota start fail";
                } else {
                    return;
                }
            } else if (i == 13) {
                if (!ret.reps.success() || !(ret.reps instanceof OTAFileRep)) {
                    o000000o3 = this.O0000OOo;
                    if (o000000o3 != null) {
                        str5 = "ota prepare response error";
                    } else {
                        return;
                    }
                } else {
                    o00oo0oo00.O00000Oo(O00000Oo, "dealWithResponse:FUN_SENDER_OTA_FILE parse error " + ret);
                    Reps reps3 = ret.reps;
                    if (((OTAFileRep) reps3).state == 0) {
                        O000000o(o00o000ooo.O000000o((OTAFileRep) reps3, this.O00000o));
                        return;
                    }
                    o000000o3 = this.O0000OOo;
                    if (o000000o3 != null) {
                        str5 = "ota prepare state not 0";
                    } else {
                        return;
                    }
                }
                o000000o3.O000000o(O00OOo.O000Oo0o, str5);
                return;
            } else {
                if (i == 14) {
                    if (ret.reps.success()) {
                        Reps reps4 = ret.reps;
                        if (reps4 instanceof OTAOffsetRep) {
                            this.O0000oO = ((OTAOffsetRep) reps4).offset;
                            this.O0000oOO = 0;
                        }
                    }
                    o000000o2 = this.O0000OOo;
                    if (o000000o2 != null) {
                        str3 = O00OOo.O000OoO0;
                        str4 = "ota send offset fail";
                    } else {
                        return;
                    }
                } else if (i == 15) {
                    boolean success2 = ret.reps.success();
                    str = O00OOo.O00O0Oo;
                    if (success2) {
                        Reps reps5 = ret.reps;
                        if (reps5 instanceof OTASendRep) {
                            if (((OTASendRep) reps5).state != 0) {
                                o000000o = this.O0000OOo;
                                if (o000000o != null) {
                                    str2 = "ota send data state not 0";
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                    o000000o = this.O0000OOo;
                    if (o000000o != null) {
                        str2 = "ota send data error";
                    } else {
                        return;
                    }
                } else if (i == 16) {
                    boolean success3 = ret.reps.success();
                    str = O00OOo.O000OoO;
                    if (success3) {
                        Reps reps6 = ret.reps;
                        if (reps6 instanceof OTAResultRep) {
                            if (((OTAResultRep) reps6).state == 0) {
                                this.O0000OOo.O000000o();
                                return;
                            }
                            o000000o = this.O0000OOo;
                            if (o000000o != null) {
                                str2 = "ota send data over state not 0";
                            } else {
                                return;
                            }
                        }
                    }
                    o000000o = this.O0000OOo;
                    if (o000000o != null) {
                        str2 = "ota send data over error";
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                O0000o0();
                return;
            }
            o000000o.O000000o(str, str2);
            return;
        }
        o000000o2.O000000o(str3, str4);
    }

    private void O000000o(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        byte[] O000000o2 = o00o000oo0.O000000o(this.O0000o00.O000000o(), 0, i, bArr, bArr.length);
        if (bArr3 == null) {
            bArr3 = o00o000oo0.O000000o();
        }
        byte[] O000000o3 = o00o000oo0.O000000o(bArr2, i2, bArr3, O000000o2);
        O000000o(o000ooo00o.O000000o(2, O000000o3, O000000o3.length), 0, new SigNewOtaAction$3(this));
    }

    /* access modifiers changed from: private */
    public void O000000o(byte[][] bArr, int i, i iVar) {
        if (i < bArr.length) {
            UUID uuid = o00o00o000.O0000OoO;
            UUID uuid2 = o00o00o000.O0000Ooo;
            CommandBean newInstance = CommandBean.newInstance();
            newInstance.serviceUUID = uuid;
            newInstance.macAddress = this.O00000oo;
            newInstance.characteristicUUID = uuid2;
            newInstance.data = bArr[i];
            O00000Oo(newInstance, new SigNewOtaAction$4(this, iVar, bArr, i));
        } else if (iVar != null) {
            iVar.onResponse(0);
        }
    }

    private void O00000Oo(int i) {
        if (i < 10) {
            i = 10;
        }
        this.O0000o0O = i;
    }

    /* access modifiers changed from: private */
    public void O0000OoO() {
        o00oo0oo00.O00000Oo(O00000Oo, "sendDeviceInfo");
        O000000o((byte[]) null, o00o0000oo.O00000Oo(this.O00000o0), 0, (byte[]) null, 4);
    }

    private void O0000Ooo() {
        o00oo0oo00.O00000Oo(O00000Oo, "sendStartOta");
        byte[] bArr = {0};
        O000000o(bArr, o00o0000oo.O00000Oo(this.O00000o0, this.O0000o0), 12, (byte[]) null, 5);
    }

    private void O0000o0() {
        byte[] O00000Oo2 = O00000Oo();
        o00o0oo0oo.O000000o o000000o = this.O0000OOo;
        if (o000000o != null) {
            o000000o.O000000o((int) (((((float) this.O0000oO) * 1.0f) / ((float) this.O00000o.length)) * 100.0f));
        }
        byte[] O00000Oo3 = o00o0000oo.O00000Oo(this.O00000o0, this.O0000o0);
        if (O00000Oo2 != null) {
            o00oo0oo00.O00000Oo(O00000Oo, "miio-sendOTAData");
            O000000o(O00000Oo2, O00000Oo3, 15, (byte[]) null, 5);
            return;
        }
        o00oo0oo00.O00000Oo(O00000Oo, "miio-send OTA OVER Data");
        O000000o(new byte[]{0}, O00000Oo3, 16, (byte[]) null, 5);
    }

    private void O0000o00() {
        o00oo0oo00.O00000Oo(O00000Oo, "prepareForFirmwareFile");
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(this.O00000o);
            this.O0000o0o = digest;
            O000000o(o00o000oo0.O000000o(this.O00000o, this.O0000o, digest, this.O0000oO0), o00o0000oo.O00000Oo(this.O00000o0, this.O0000o0), 13, (byte[]) null, 5);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            this.O0000OOo.O000000o(O00OOo.O000Oo0o, "ota prepare file fail");
        }
    }

    public void O000000o() {
        this.O0000Ooo = System.currentTimeMillis();
        o00oo0oo00.O000000o(O00000Oo, "sendOtaData");
        if (!this.O0000Oo0) {
            this.O000000o = new ooo0oo0o0(this.O00000oo, this.O0000oo);
            this.O0000OoO.postDelayed(new Runnable() {
                public void run() {
                    ooo0oo0oo.this.O000000o.O000000o();
                }
            }, 1000);
            this.O0000Oo0 = true;
        }
    }

    public void O000000o(O00o0 o00o0) {
        UUID uuid = o00o00o000.O00000o0;
        UUID uuid2 = o00o00o000.O00000o;
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = uuid;
        newInstance.macAddress = this.O00000oo;
        newInstance.characteristicUUID = uuid2;
        o00oo0oo00.O00000Oo(O00000Oo, "read requestFirmware");
        O000000o(newInstance, (e) new SigNewOtaAction$5(this, o00o0));
    }

    public byte[] O00000Oo() {
        StringBuilder n = a.n("getRequestPackage: index = ");
        n.append(this.O0000oOO);
        n.append(", offset = ");
        n.append(this.O0000oO);
        n.append(", length = ");
        n.append(this.O00000o.length);
        n.append(", percent = ");
        n.append((((float) this.O0000oO) * 1.0f) / ((float) this.O00000o.length));
        o00oo0oo00.O00000o0(O00000Oo, n.toString());
        int i = this.O0000oO;
        byte[] bArr = this.O00000o;
        if (i >= bArr.length) {
            o00oo0oo00.O00000Oo(O00000Oo, "getRequestPackage:  send Over");
            return null;
        }
        byte[] O000000o2 = o00o0000oo.O000000o(bArr, i, this.O0000o0O);
        this.O0000oO += O000000o2.length;
        byte[] O00000oO = o00o0000oo.O00000oO(this.O0000oOO);
        byte[] O00000oO2 = o00o0000oo.O00000oO(O000000o2.length);
        byte[] O0000oO02 = o00o0000oo.O0000oO0(O000000o2);
        this.O0000oOO++;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new byte[]{0});
        arrayList.add(O00000oO);
        arrayList.add(O00000oO2);
        arrayList.add(O0000oO02);
        arrayList.add(O000000o2);
        return o00o0000oo.O000000o((List<byte[]>) arrayList);
    }
}
