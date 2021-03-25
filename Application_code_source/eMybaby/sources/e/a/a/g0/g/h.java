package e.a.a.g0.g;

import e.a.a.k0.c;
import e.a.a.m;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final int f4988a = 3;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4989b = false;

    public boolean a(IOException iOException, int i, c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        } else if (i > this.f4988a || (iOException instanceof InterruptedIOException) || (iOException instanceof UnknownHostException) || (iOException instanceof ConnectException) || (iOException instanceof SSLException)) {
            return false;
        } else {
            if (!(((m) cVar.b("http.request")) instanceof e.a.a.h)) {
                return true;
            }
            Boolean bool = (Boolean) cVar.b("http.request_sent");
            return !(bool != null && bool.booleanValue()) || this.f4989b;
        }
    }
}
