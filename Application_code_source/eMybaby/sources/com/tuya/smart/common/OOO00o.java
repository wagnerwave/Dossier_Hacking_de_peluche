package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.mvp.bean.Result;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.interior.config.bean.ActiveTokenBean;
import com.tuya.smart.interior.device.bean.GwDevResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OOO00o extends BasePresenter implements o0o00ooo00 {
    public static final String O000000o = "CheckDevActiveStatusByToken";
    public static final int O00000o = 23;
    public final OO0OOo0 O00000Oo = new OOO0oO(TuyaSmartNetWork.getAppContext(), this.mHandler);
    public String O00000o0;
    public boolean O00000oO;
    public Map<String, Boolean> O00000oo;
    public Map<String, Boolean> O0000O0o;
    public o0o00ooo0o O0000OOo;
    public OOO00Oo O0000Oo0;

    public OOO00o(Context context, String str, o0o00ooo0o o0o00ooo0o) {
        super(context);
        this.O00000o0 = new ActiveTokenBean(str).getToken();
        this.O0000OOo = o0o00ooo0o;
        this.O00000oo = new HashMap();
        this.O0000O0o = new HashMap();
        this.O0000Oo0 = new OOO00Oo(new HashMap(), new HashMap(), new HashMap());
    }

    private void O000000o(GwDevResp gwDevResp) {
        StringBuilder n = a.n("configSuccess dev:");
        n.append(gwDevResp.getGwId());
        L.d(O000000o, n.toString());
        o0o00ooo0o o0o00ooo0o = this.O0000OOo;
        if (o0o00ooo0o != null) {
            o0o00ooo0o.O000000o(gwDevResp);
        }
    }

    private void O000000o(ArrayList<GwDevResp> arrayList) {
        Object obj;
        Map map;
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<GwDevResp> it = arrayList.iterator();
            while (it.hasNext()) {
                GwDevResp next = it.next();
                String gwId = next.getGwId();
                if (this.O00000oo.get(gwId) == null) {
                    arrayList2.add(next);
                    this.O00000oo.put(gwId, Boolean.TRUE);
                }
                if (!next.getIsOnline().booleanValue()) {
                    OOO00Oo oOO00Oo = this.O0000Oo0;
                    if (oOO00Oo != null) {
                        map = oOO00Oo.O00000oO();
                        gwId = "step";
                        obj = "online";
                    }
                } else if (this.O0000O0o.get(gwId) == null) {
                    O000000o(next);
                    map = this.O0000O0o;
                    obj = Boolean.TRUE;
                }
                map.put(gwId, obj);
            }
            if (this.O0000OOo != null && !arrayList2.isEmpty()) {
                this.O0000OOo.O000000o((List<GwDevResp>) arrayList2);
            }
        }
    }

    private void O00000o() {
        if (!this.O00000oO) {
            this.mHandler.sendEmptyMessageDelayed(23, 2000);
        }
    }

    public OOO00Oo O000000o() {
        return this.O0000Oo0;
    }

    public void O00000Oo() {
        L.d(O000000o, "startSearch");
        this.O00000oO = false;
        O00000o();
    }

    public void O00000o0() {
        L.d(O000000o, "stopSearch");
        this.O00000oo.clear();
        this.O0000O0o.clear();
        this.O00000oO = true;
        this.mHandler.removeMessages(23);
    }

    public boolean handleMessage(Message message) {
        if (this.O00000oO) {
            return false;
        }
        int i = message.what;
        if (i == 8) {
            OOO00Oo oOO00Oo = this.O0000Oo0;
            if (oOO00Oo != null) {
                oOO00Oo.O00000oO().put("step", "token_failure");
            }
            if (!TextUtils.equals(((Result) message.obj).getErrorCode(), "EXPIRE")) {
                O00000o();
            }
        } else if (i == 9) {
            O00000o();
            O000000o((ArrayList<GwDevResp>) (ArrayList) ((Result) message.obj).getObj());
        } else if (i == 18) {
            o0o00ooo0o o0o00ooo0o = this.O0000OOo;
            if (o0o00ooo0o != null) {
                o0o00ooo0o.O00000Oo((List) ((Result) message.obj).getObj());
            }
        } else if (i == 23) {
            this.O00000Oo.O000000o(this.O00000o0);
        }
        return super.handleMessage(message);
    }

    public void onDestroy() {
        L.d(O000000o, "onDestroy");
        this.O00000Oo.onDestroy();
        O00000o0();
    }
}
