package com.tuya.smart.android.network.api;

import a.a.a.a.a;
import java.util.List;

public class DnsStatBean {
    public String host;
    public List<String> ips;
    public long useTime;

    public String getHost() {
        return this.host;
    }

    public List<String> getIps() {
        return this.ips;
    }

    public long getUseTime() {
        return this.useTime;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setIps(List<String> list) {
        this.ips = list;
    }

    public void setUseTime(long j) {
        this.useTime = j;
    }

    public String toString() {
        StringBuilder n = a.n("DnsStatBean{host='");
        a.x(n, this.host, '\'', ", useTime=");
        n.append(this.useTime);
        n.append(", ips=");
        n.append(this.ips);
        n.append('}');
        return n.toString();
    }
}
