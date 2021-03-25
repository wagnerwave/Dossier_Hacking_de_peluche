package e.b.a.a.a.u;

import e.b.a.a.a.m;
import e.b.a.a.a.n;
import e.b.a.a.a.t;
import e.b.a.a.a.u.t.o;
import e.b.a.a.a.u.t.u;
import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class f {

    /* renamed from: d  reason: collision with root package name */
    public static final b f5261d = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", f.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public Hashtable f5262a;

    /* renamed from: b  reason: collision with root package name */
    public String f5263b;

    /* renamed from: c  reason: collision with root package name */
    public n f5264c = null;

    public f(String str) {
        f5261d.i(str);
        this.f5262a = new Hashtable();
        this.f5263b = str;
        f5261d.h("e.b.a.a.a.u.f", "<Init>", "308");
    }

    public void a() {
        f5261d.e("e.b.a.a.a.u.f", "clear", "305", new Object[]{new Integer(this.f5262a.size())});
        synchronized (this.f5262a) {
            this.f5262a.clear();
        }
    }

    public int b() {
        int size;
        synchronized (this.f5262a) {
            size = this.f5262a.size();
        }
        return size;
    }

    public m[] c() {
        m[] mVarArr;
        synchronized (this.f5262a) {
            f5261d.h("e.b.a.a.a.u.f", "getOutstandingDelTokens", "311");
            Vector vector = new Vector();
            Enumeration elements = this.f5262a.elements();
            while (elements.hasMoreElements()) {
                t tVar = (t) elements.nextElement();
                if (tVar != null && (tVar instanceof m) && !tVar.f5223a.n) {
                    vector.addElement(tVar);
                }
            }
            mVarArr = (m[]) vector.toArray(new m[vector.size()]);
        }
        return mVarArr;
    }

    public t d(u uVar) {
        return (t) this.f5262a.get(uVar.m());
    }

    public void e(n nVar) {
        synchronized (this.f5262a) {
            f5261d.e("e.b.a.a.a.u.f", "quiesce", "309", new Object[]{nVar});
            this.f5264c = nVar;
        }
    }

    public t f(String str) {
        f5261d.e("e.b.a.a.a.u.f", "removeToken", "306", new Object[]{str});
        if (str != null) {
            return (t) this.f5262a.remove(str);
        }
        return null;
    }

    public t g(u uVar) {
        return f(uVar.m());
    }

    public m h(o oVar) {
        m mVar;
        synchronized (this.f5262a) {
            String num = new Integer(oVar.f5339b).toString();
            if (this.f5262a.containsKey(num)) {
                mVar = (m) this.f5262a.get(num);
                f5261d.e("e.b.a.a.a.u.f", "restoreToken", "302", new Object[]{num, oVar, mVar});
            } else {
                mVar = new m(this.f5263b);
                mVar.f5223a.i = num;
                this.f5262a.put(num, mVar);
                f5261d.e("e.b.a.a.a.u.f", "restoreToken", "303", new Object[]{num, oVar, mVar});
            }
        }
        return mVar;
    }

    public void i(t tVar, String str) {
        synchronized (this.f5262a) {
            f5261d.e("e.b.a.a.a.u.f", "saveToken", "307", new Object[]{str, tVar.toString()});
            tVar.f5223a.i = str;
            this.f5262a.put(str, tVar);
        }
    }

    public void j(t tVar, u uVar) {
        synchronized (this.f5262a) {
            if (this.f5264c == null) {
                String m = uVar.m();
                f5261d.e("e.b.a.a.a.u.f", "saveToken", "300", new Object[]{m, uVar});
                i(tVar, m);
            } else {
                throw this.f5264c;
            }
        }
    }

    public String toString() {
        String stringBuffer;
        String property = System.getProperty("line.separator", "\n");
        StringBuffer stringBuffer2 = new StringBuffer();
        synchronized (this.f5262a) {
            Enumeration elements = this.f5262a.elements();
            while (elements.hasMoreElements()) {
                stringBuffer2.append("{" + ((t) elements.nextElement()).f5223a + "}" + property);
            }
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }
}
