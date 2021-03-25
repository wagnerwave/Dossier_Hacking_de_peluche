package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.inuker.bluetooth.library.model.BleGattService;
import com.tuya.sdk.sigmesh.bean.ControlMessage;
import com.tuya.sdk.sigmesh.bean.ProvisioningCapabilities;
import com.tuya.sdk.sigmesh.util.ExtendedInvalidCipherTextException;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.common.O00Ooo00;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.common.ooo00oo0o;
import com.tuya.smart.common.ooo0oo0o0;
import java.util.ArrayList;
import java.util.List;

public class oooo000oo {
    public static final String O000000o = "TuyaSigMeshProvisioningImpl";
    public static final long O0000ooo = 20000;
    public static final int O00oOooO = 8448;
    public oooo0000o O00000Oo;
    public Handler O00000o;
    public O00Oo00o O00000o0;
    public int O00000oO = 2;
    public String O00000oo = ooo0oo0o0.O00000Oo;
    public O00o O0000O0o = new O00o() {
        public void O000000o(SearchDeviceBean searchDeviceBean, String str) {
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, str);
            }
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            Message message = new Message();
            message.obj = searchDeviceBean;
            message.what = oooo000oo.O00oOooO;
            Bundle bundle = new Bundle();
            bundle.putString(BusinessResponse.KEY_ERRCODE, str);
            bundle.putString(BusinessResponse.KEY_ERRMSG, str2);
            message.setData(bundle);
            oooo000oo.this.O00000o.sendMessageDelayed(message, 200);
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, boolean z) {
            Runnable runnable;
            Handler handler;
            o00oo0oo00.O00000Oo(oooo000oo.O000000o, "connect success  reconnect:" + z);
            if (!z) {
                oooo000oo.this.O00000Oo(searchDeviceBean);
                ooo0oo0o0 unused = oooo000oo.this.O0000oOO = new ooo0oo0o0(searchDeviceBean.getMacAdress(), oooo000oo.this.O00oOooo);
                handler = oooo000oo.this.O00000o;
                runnable = new Runnable() {
                    public void run() {
                        oooo000oo oooo000oo = oooo000oo.this;
                        oooo000oo.O00000oo = ooo0oo0o0.O00000Oo;
                        oooo000oo.O0000oOO.O00000Oo();
                    }
                };
            } else {
                oooo000oo.this.O00000Oo(searchDeviceBean);
                ooo0oo0o0 unused2 = oooo000oo.this.O0000oOO = new ooo0oo0o0(searchDeviceBean.getMacAdress(), oooo000oo.this.O00oOooo);
                handler = oooo000oo.this.O00000o;
                runnable = new Runnable() {
                    public void run() {
                        oooo000oo oooo000oo = oooo000oo.this;
                        oooo000oo.O00000oo = ooo0oo0o0.O000000o;
                        oooo000oo.O0000oOO.O00000o0();
                    }
                };
            }
            handler.postDelayed(runnable, 500);
        }

        public void O000000o(List<BleGattService> list) {
        }
    };
    public o0000oo0o0 O0000OOo = new o0000oo0o0() {
        public void O000000o(SearchDeviceBean searchDeviceBean, ProvisioningCapabilities provisioningCapabilities) {
            o00oo0oo00.O000000o(oooo000oo.O000000o, "invite success ");
            if (searchDeviceBean instanceof SigMeshSearchDeviceBean) {
                SigMeshSearchDeviceBean sigMeshSearchDeviceBean = (SigMeshSearchDeviceBean) searchDeviceBean;
                sigMeshSearchDeviceBean.setCapabilities(provisioningCapabilities);
                sigMeshSearchDeviceBean.getUnprovisionedMeshNode().setProvisioningCapabilities(provisioningCapabilities);
            }
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O0000oO);
            }
            oooo000oo.this.O00000Oo.O000000o(provisioningCapabilities);
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            oooo000oo.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public o0000oo00o O0000Oo = new o0000oo00o() {
        public void O000000o(SearchDeviceBean searchDeviceBean) {
            o00oo0oo00.O000000o(oooo000oo.O000000o, "provisoning confim success !!!");
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O0000ooo);
            }
            oooo000oo.this.O00000Oo.O00000o();
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            oooo000oo.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public o0000oo000 O0000Oo0 = new o0000oo000() {
        public void O000000o(SearchDeviceBean searchDeviceBean) {
            o00oo0oo00.O000000o(oooo000oo.O000000o, "send public key success ");
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O0000oo);
            }
            oooo000oo.this.O00000Oo.O00000o0();
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str) {
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, str);
            }
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            oooo000oo.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public o0000oo0oo O0000OoO = new o0000oo0oo() {
        public void O000000o(SearchDeviceBean searchDeviceBean) {
            o00oo0oo00.O000000o(oooo000oo.O000000o, "random confim success !!!");
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O00oOooo);
            }
            oooo000oo.this.O00000Oo.O00000oO();
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            oooo000oo.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public o0000ooo00 O0000Ooo = new o0000ooo00() {
        public void O000000o(SearchDeviceBean searchDeviceBean) {
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O000O0Oo);
            }
            o00oo0oo00.O00000Oo(oooo000oo.O000000o, "first step  send data success!!!");
            oooo000oo oooo000oo = oooo000oo.this;
            oooo000oo.O0000oO = 1;
            oooo000oo.O00000Oo.O00000oo();
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            oooo000oo.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public o0000o0ooo O0000o = new o0000o0ooo() {
        public void O000000o(SearchDeviceBean searchDeviceBean) {
            o00oo0oo00.O00000Oo(oooo000oo.O000000o, "config network transmit success");
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O000OOo0);
            }
            oooo000oo.this.O00000Oo.O0000Ooo();
            oooo000oo.this.O00000Oo.O000000o(searchDeviceBean, (O00Ooo00.O000000o) null);
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            o00oo0oo00.O00000Oo(oooo000oo.O000000o, "config network transmit fail");
            oooo000oo.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public o0000o00oo O0000o0 = new o0000o00oo() {
        public void O000000o(SearchDeviceBean searchDeviceBean) {
            o00oo0oo00.O00000Oo(oooo000oo.O000000o, "config appkey add success");
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O000O0oO);
            }
            oooo000oo.this.O00000Oo.O0000Oo0();
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            oooo000oo.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public o0000o0o00 O0000o00 = new o0000o0o00() {
        public void O000000o(SearchDeviceBean searchDeviceBean) {
            o00oo0oo00.O00000Oo(oooo000oo.O000000o, "config composition success");
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O000O0o0);
            }
            oooo000oo.this.O00000o.postDelayed(new Runnable() {
                public void run() {
                    oooo000oo.this.O00000Oo.O0000OOo();
                }
            }, 200);
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            oooo000oo.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public o0000o0o0o O0000o0O = new o0000o0o0o() {
        public void O000000o(SearchDeviceBean searchDeviceBean) {
            o00oo0oo00.O00000Oo(oooo000oo.O000000o, "config bind model success");
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O000OO00);
            }
            oooo000oo.this.O00000Oo.O0000Oo();
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            oooo000oo.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public o0000o0oo0 O0000o0o = new o0000o0oo0() {
        public void O000000o(SearchDeviceBean searchDeviceBean) {
            o00oo0oo00.O00000Oo(oooo000oo.O000000o, "config model publication success");
            O00Oo00o o00Oo00o = oooo000oo.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, O00OOo.O000OO);
            }
            oooo000oo.this.O00000Oo.O0000OoO();
        }

        public void O000000o(SearchDeviceBean searchDeviceBean, String str, String str2) {
            o00oo0oo00.O00000Oo(oooo000oo.O000000o, "config model publication fail");
            oooo000oo.this.O000000o(searchDeviceBean, str, str2);
        }
    };
    public int O0000oO = 0;
    public int O0000oO0 = 1;
    public ooo0oo0o0 O0000oOO;
    public List<ooooo00o0> O0000oOo = new ArrayList();
    public o000oo0000 O0000oo;
    public List<ooooo000o> O0000oo0 = new ArrayList();
    public ooooo0oo0 O0000ooO;
    public ooo0oo0o0.O000000o O00oOooo = new ooo0oo0o0.O000000o() {
        public void O000000o(String str) {
            Handler handler;
            Runnable runnable;
            o00oo0oo00.O00000Oo(oooo000oo.O000000o, "enableNotificationSuccess");
            if (TextUtils.equals(str, ooo0oo0o0.O00000Oo)) {
                handler = oooo000oo.this.O00000o;
                runnable = new Runnable() {
                    public void run() {
                        oooo000oo.this.O00000Oo.O00000Oo();
                    }
                };
            } else {
                handler = oooo000oo.this.O00000o;
                runnable = new Runnable() {
                    public void run() {
                        oooo000oo.this.O00000Oo.O0000O0o();
                    }
                };
            }
            handler.postDelayed(runnable, 500);
        }

        public void O000000o(final String str, String str2) {
            o00oo0oo00.O00000Oo(oooo000oo.O000000o, "notify fail " + str + DpTimerBean.FILL + str2 + "  count:" + oooo000oo.this.O00000oO);
            oooo000oo oooo000oo = oooo000oo.this;
            if (oooo000oo.O00000oO > 0) {
                o00oo0oo00.O00000Oo(oooo000oo.O000000o, "try enable notify");
                oooo000oo oooo000oo2 = oooo000oo.this;
                oooo000oo2.O00000oO--;
                oooo000oo2.O00000Oo.O0000o00();
                oooo000oo.this.O00000o.postDelayed(new Runnable() {
                    public void run() {
                        oooo000oo.this.O00000Oo.O0000o0().O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
                            public void O000000o(String str, String str2) {
                                AnonymousClass3 r2 = AnonymousClass3.this;
                                oooo000oo.this.O00000Oo.O000000o(str, str2);
                            }

                            public void O00000Oo() {
                                if (TextUtils.equals(oooo000oo.this.O00000oo, ooo0oo0o0.O00000Oo)) {
                                    oooo000oo.this.O0000oOO.O00000Oo();
                                } else {
                                    oooo000oo.this.O0000oOO.O00000o0();
                                }
                            }
                        });
                    }
                }, 2000);
                return;
            }
            oooo000oo.O00000Oo.O000000o(str, str2);
        }

        public void O000000o(byte[] bArr) {
            StringBuilder n = a.n("Notify onUnSecretNotify --> ");
            n.append(o00oo0o00o.O00000Oo(bArr, ":"));
            o00oo0oo00.O000000o(oooo000oo.O000000o, n.toString());
            oooo000oo.this.O000000o(bArr);
        }

        public void O00000Oo() {
        }
    };

    public oooo000oo(final oooo0000o oooo0000o, O00Oo00o o00Oo00o) {
        this.O00000Oo = oooo0000o;
        this.O00000o0 = o00Oo00o;
        this.O0000oo = new o000oo0000(O00Oo00.O000000o());
        this.O0000ooO = new ooooo0oo0(O00Oo00.O000000o(), this.O0000oo);
        this.O0000oo.O000000o((o000oo00o0) new o000oo00o0() {
            public void O000000o(ControlMessage controlMessage) {
                o00oo0oo00.O000000o(oooo000oo.O000000o, "sendSegmentAcknowledgementMessage ");
                oooo0000o.O000000o(oooo000oo.this.O0000oo.O00000o0(controlMessage));
            }

            public byte[] O000000o(byte[] bArr) {
                SigMeshSearchDeviceBean O0000o = oooo000oo.this.O00000Oo.O0000o();
                if (O0000o == null || O0000o.getMeshAddress() != o000oo0o0o.O00000Oo(bArr)) {
                    return null;
                }
                return O0000o.getProvisionedMeshNode().getDeviceKey();
            }
        });
        this.O00000o = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                String str;
                String str2;
                if (message.what == 8448) {
                    SearchDeviceBean searchDeviceBean = (SearchDeviceBean) message.obj;
                    Bundle data = message.getData();
                    if (data != null) {
                        str2 = data.getString(BusinessResponse.KEY_ERRCODE);
                        str = data.getString(BusinessResponse.KEY_ERRMSG);
                    } else {
                        str2 = O00OOo.O000OoOo;
                        str = "connect break off";
                    }
                    oooo000oo.this.O000000o(searchDeviceBean, str2, str);
                }
            }
        };
    }

    private synchronized void O000000o(com.tuya.sdk.sigmesh.bean.Message message) {
        for (ooooo000o O000000o2 : this.O0000oo0) {
            O000000o2.O000000o(message);
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(byte[] bArr) {
        if (bArr[0] == 3) {
            O00000Oo(bArr);
        } else if (bArr[0] == 0) {
            try {
                com.tuya.sdk.sigmesh.bean.Message O00000o2 = this.O0000oo.O00000o(bArr);
                if (O00000o2 == null) {
                    o00oo0oo00.O00000o(O000000o, "Message reassembly may not be completed yet!");
                } else if (O00000o2 instanceof ControlMessage) {
                    this.O0000ooO.O000000o((ControlMessage) O00000o2, oo0o0oooo.O000000o().O0000O0o());
                } else {
                    O000000o(O00000o2);
                }
            } catch (ExtendedInvalidCipherTextException e2) {
                StringBuilder n = a.n("Decryption failed in ");
                n.append(e2.getTag());
                n.append(" : ");
                n.append(e2.getMessage());
                o00oo0oo00.O00000Oo(O000000o, n.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo(SearchDeviceBean searchDeviceBean) {
        new ooo00oo0o(searchDeviceBean.getMacAdress(), o00o0000o0.O000000o, new ooo00oo0o.O000000o() {
            public void O000000o(Integer num) {
                o00oo0oo00.O000000o(oooo000oo.O000000o, "mtuConfig success  mtu:" + num);
                oo0o0oooo.O000000o().O000000o(num.intValue());
            }

            public void O000000o(String str, String str2) {
                o00oo0oo00.O000000o(oooo000oo.O000000o, "mtuConfig fail " + str);
            }
        }).O000000o();
    }

    private synchronized void O00000Oo(byte[] bArr) {
        for (ooooo00o0 O000000o2 : this.O0000oOo) {
            O000000o2.O000000o(bArr);
        }
    }

    private void O0000o0() {
        this.O0000oO0 = 1;
        this.O0000oO = 0;
        this.O00000oO = 2;
    }

    public O00o O000000o() {
        return this.O0000O0o;
    }

    public void O000000o(SearchDeviceBean searchDeviceBean) {
        o00oo0oo00.O00000Oo(O000000o, String.format("onDealSuccess single config time %d s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.O00000Oo.O0000o0o())}));
        this.O00000o.removeMessages(O00oOooO);
        this.O00000Oo.O0000Ooo();
        O0000o0();
        ooo0oo0o0 ooo0oo0o0 = this.O0000oOO;
        if (ooo0oo0o0 != null) {
            ooo0oo0o0.O00000oO();
        }
        O00Oo00o o00Oo00o = this.O00000o0;
        if (o00Oo00o != null) {
            o00Oo00o.O000000o(searchDeviceBean);
        }
        this.O00000o.postDelayed(new Runnable() {
            public void run() {
                oooo000oo.this.O00000Oo.O0000o0O();
            }
        }, 500);
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, String str, String str2) {
        StringBuilder q = a.q("dealFail ", str2, " retryCount:");
        q.append(this.O0000oO0);
        q.append("   searchBean:");
        q.append(searchDeviceBean);
        o00oo0oo00.O00000Oo(O000000o, q.toString());
        this.O00000o.removeMessages(O00oOooO);
        this.O00000Oo.O0000Ooo();
        ooo0oo0o0 ooo0oo0o0 = this.O0000oOO;
        if (ooo0oo0o0 != null) {
            ooo0oo0o0.O00000oO();
        }
        if (this.O0000oO0 <= 0 || searchDeviceBean == null || TextUtils.equals(str, O00OOo.O000OOoo) || TextUtils.equals(str, O00OOo.O000Oo00)) {
            O0000o0();
            O00Oo00o o00Oo00o = this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o(searchDeviceBean, str, str2);
            }
            this.O00000o.postDelayed(new Runnable() {
                public void run() {
                    oooo000oo.this.O00000Oo.O0000o0O();
                }
            }, 1000);
            return;
        }
        this.O0000oO0--;
        this.O00000o.postDelayed(new Runnable() {
            public void run() {
                if (oooo000oo.this.O0000oO == 0) {
                    StringBuilder n = a.n("retry first login mac:");
                    n.append(searchDeviceBean.getMacAdress());
                    o00oo0oo00.O00000Oo(oooo000oo.O000000o, n.toString());
                    oooo000oo.this.O00000Oo.O000000o(searchDeviceBean);
                    return;
                }
                StringBuilder n2 = a.n("retry secend login mac:");
                n2.append(searchDeviceBean.getMacAdress());
                o00oo0oo00.O00000Oo(oooo000oo.O000000o, n2.toString());
                oooo000oo.this.O00000Oo.O00000oo();
            }
        }, 1000);
    }

    public synchronized void O000000o(ooooo000o ooooo000o) {
        this.O0000oo0.add(ooooo000o);
    }

    public synchronized void O000000o(ooooo00o0 ooooo00o0) {
        this.O0000oOo.add(ooooo00o0);
    }

    public o0000oo0o0 O00000Oo() {
        return this.O0000OOo;
    }

    public synchronized void O00000Oo(ooooo000o ooooo000o) {
        this.O0000oo0.remove(ooooo000o);
    }

    public synchronized void O00000Oo(ooooo00o0 ooooo00o0) {
        this.O0000oOo.remove(ooooo00o0);
    }

    public o0000oo00o O00000o() {
        return this.O0000Oo;
    }

    public o0000oo000 O00000o0() {
        return this.O0000Oo0;
    }

    public o0000oo0oo O00000oO() {
        return this.O0000OoO;
    }

    public o0000ooo00 O00000oo() {
        return this.O0000Ooo;
    }

    public o0000o0o00 O0000O0o() {
        return this.O0000o00;
    }

    public o0000o00oo O0000OOo() {
        return this.O0000o0;
    }

    public o0000o0oo0 O0000Oo() {
        return this.O0000o0o;
    }

    public o0000o0o0o O0000Oo0() {
        return this.O0000o0O;
    }

    public o0000o0ooo O0000OoO() {
        return this.O0000o;
    }

    public o000oo0000 O0000Ooo() {
        return this.O0000oo;
    }

    public void O0000o00() {
        this.O00000o0 = null;
        this.O00000Oo.O0000Ooo();
        List<ooooo00o0> list = this.O0000oOo;
        if (list != null) {
            list.clear();
        }
    }
}
