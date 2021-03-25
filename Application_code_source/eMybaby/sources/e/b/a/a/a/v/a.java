package e.b.a.a.a.v;

import com.tuya.smart.common.oOO0O0O0;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public Logger f5347a = null;

    /* renamed from: b  reason: collision with root package name */
    public ResourceBundle f5348b = null;

    /* renamed from: c  reason: collision with root package name */
    public ResourceBundle f5349c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f5350d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f5351e = null;
    public String f = null;

    public void a(String str, String str2, String str3) {
        j(2, str, str2, str3, (Object[]) null, (Throwable) null);
    }

    public void b(String str, String str2, String str3) {
        m(6, str, str2, str3, (Object[]) null, (Throwable) null);
    }

    public void c(String str, String str2, String str3, Object[] objArr, Throwable th) {
        m(5, str, str2, str3, objArr, th);
    }

    public void d(String str, String str2, String str3, Object[] objArr) {
        j(1, str, str2, str3, objArr, (Throwable) null);
    }

    public void e(String str, String str2, String str3, Object[] objArr) {
        m(5, str, str2, str3, objArr, (Throwable) null);
    }

    public boolean f(int i) {
        return this.f5347a.isLoggable(l(i));
    }

    public void g(ResourceBundle resourceBundle, String str, String str2) {
        this.f5349c = this.f5348b;
        this.f5351e = str2;
        this.f = str;
        this.f5347a = Logger.getLogger(str);
        this.f5348b = resourceBundle;
        this.f5349c = resourceBundle;
        this.f5350d = resourceBundle.getString(oOO0O0O0.O0000oO0);
    }

    public void h(String str, String str2, String str3) {
        m(5, str, str2, str3, (Object[]) null, (Throwable) null);
    }

    public void i(String str) {
        this.f5351e = str;
    }

    public void j(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        Level l = l(i);
        if (this.f5347a.isLoggable(l)) {
            k(l, str, str2, this.f5348b, str3, objArr, (Throwable) null);
        }
    }

    public final void k(Level level, String str, String str2, ResourceBundle resourceBundle, String str3, Object[] objArr, Throwable th) {
        if (str3.indexOf("=====") == -1) {
            try {
                str3 = resourceBundle.getString(str3);
            } catch (MissingResourceException unused) {
            }
            str3 = MessageFormat.format(str3, objArr);
        }
        LogRecord logRecord = new LogRecord(level, a.a.a.a.a.m(new StringBuilder(String.valueOf(this.f5351e)), ": ", str3));
        logRecord.setSourceClassName(str);
        logRecord.setSourceMethodName(str2);
        logRecord.setLoggerName(this.f);
        if (th != null) {
            logRecord.setThrown(th);
        }
        this.f5347a.log(logRecord);
    }

    public final Level l(int i) {
        switch (i) {
            case 1:
                return Level.SEVERE;
            case 2:
                return Level.WARNING;
            case 3:
                return Level.INFO;
            case 4:
                return Level.CONFIG;
            case 5:
                return Level.FINE;
            case 6:
                return Level.FINER;
            case 7:
                return Level.FINEST;
            default:
                return null;
        }
    }

    public void m(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        Level l = l(i);
        if (this.f5347a.isLoggable(l)) {
            k(l, str, str2, this.f5349c, str3, objArr, th);
        }
    }
}
