package e.b.a.a.a;

import e.b.a.a.a.u.q;
import e.b.a.a.a.u.t.c;
import e.b.a.a.a.u.t.u;

public class t implements g {

    /* renamed from: a  reason: collision with root package name */
    public q f5223a = null;

    public t() {
    }

    public t(String str) {
        this.f5223a = new q(str);
    }

    public c getActionCallback() {
        return this.f5223a.k;
    }

    public d getClient() {
        return this.f5223a.j;
    }

    public int[] getGrantedQos() {
        int[] iArr = new int[0];
        u uVar = this.f5223a.f;
        return uVar instanceof e.b.a.a.a.u.t.q ? ((e.b.a.a.a.u.t.q) uVar).f5334e : iArr;
    }

    public int getMessageId() {
        return this.f5223a.m;
    }

    public u getResponse() {
        return this.f5223a.f;
    }

    public boolean getSessionPresent() {
        u uVar = this.f5223a.f;
        if (uVar instanceof c) {
            return ((c) uVar).f;
        }
        return false;
    }
}
