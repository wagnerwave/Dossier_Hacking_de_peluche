package e.b.a.a.a;

import a.e.a.a.r.b;
import e.b.a.a.a.u.k;
import java.util.MissingResourceException;

public class n extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public int f5221a;

    /* renamed from: b  reason: collision with root package name */
    public Throwable f5222b;

    public n(int i) {
        this.f5221a = i;
    }

    public n(int i, Throwable th) {
        this.f5221a = i;
        this.f5222b = th;
    }

    public n(Throwable th) {
        this.f5221a = 0;
        this.f5222b = th;
    }

    public Throwable getCause() {
        return this.f5222b;
    }

    public String getMessage() {
        String str;
        Object newInstance;
        int i = this.f5221a;
        if (k.f5278a == null) {
            if (b.J("java.util.ResourceBundle")) {
                try {
                    newInstance = Class.forName("e.b.a.a.a.u.n").newInstance();
                } catch (Exception unused) {
                    return "";
                }
            } else if (b.J("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog")) {
                newInstance = Class.forName("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog").newInstance();
            }
            k.f5278a = (k) newInstance;
        }
        e.b.a.a.a.u.n nVar = (e.b.a.a.a.u.n) k.f5278a;
        if (nVar != null) {
            try {
                str = nVar.f5284b.getString(Integer.toString(i));
            } catch (MissingResourceException unused2) {
                str = "MqttException";
            }
            return str;
        }
        throw null;
    }

    public String toString() {
        String str = String.valueOf(getMessage()) + " (" + this.f5221a + ")";
        if (this.f5222b == null) {
            return str;
        }
        return String.valueOf(str) + " - " + this.f5222b.toString();
    }
}
