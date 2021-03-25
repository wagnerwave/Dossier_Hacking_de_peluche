package com.tuya.smart.android.network.stat;

import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.network.api.DnsStatBean;
import com.tuya.smart.android.network.api.IApiEvent;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Dns;

public class TuyaDNS implements Dns {
    public List<InetAddress> lookup(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        List<InetAddress> lookup = Dns.SYSTEM.lookup(str);
        ArrayList arrayList = new ArrayList();
        if (lookup != null && lookup.size() > 0) {
            for (InetAddress inetAddress : lookup) {
                arrayList.add(inetAddress.toString());
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        DnsStatBean dnsStatBean = new DnsStatBean();
        dnsStatBean.setHost(str);
        dnsStatBean.setIps(arrayList);
        dnsStatBean.setUseTime(currentTimeMillis2);
        L.i("TuyaDNS", dnsStatBean.toString());
        ArrayList<IApiEvent> dnsStatEvents = ApiEvent.getDnsStatEvents();
        if (dnsStatEvents != null && dnsStatEvents.size() > 0) {
            Iterator<IApiEvent> it = dnsStatEvents.iterator();
            while (it.hasNext()) {
                it.next().onSuccess(dnsStatBean);
            }
        }
        return lookup;
    }
}
