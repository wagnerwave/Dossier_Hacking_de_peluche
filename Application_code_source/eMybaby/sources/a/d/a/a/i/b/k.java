package a.d.a.a.i.b;

import a.a.a.a.a;
import a.d.a.a.e.q.c;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class k extends y5 {

    /* renamed from: c  reason: collision with root package name */
    public long f2308c;

    /* renamed from: d  reason: collision with root package name */
    public String f2309d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f2310e;
    public AccountManager f;
    public Boolean g;
    public long h;

    public k(c5 c5Var) {
        super(c5Var);
    }

    public final boolean q() {
        Calendar instance = Calendar.getInstance();
        this.f2308c = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        this.f2309d = a.d(String.valueOf(lowerCase2).length() + String.valueOf(lowerCase).length() + 1, lowerCase, "-", lowerCase2);
        return false;
    }

    public final boolean s(Context context) {
        if (this.f2310e == null) {
            this.f2310e = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.f2310e = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f2310e.booleanValue();
    }

    public final long t() {
        n();
        return this.f2308c;
    }

    public final String u() {
        n();
        return this.f2309d;
    }

    @WorkerThread
    public final long v() {
        b();
        return this.h;
    }

    @WorkerThread
    public final boolean w() {
        b();
        if (((c) this.f2563a.n) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.h > 86400000) {
                this.g = null;
            }
            Boolean bool = this.g;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (ContextCompat.checkSelfPermission(this.f2563a.f2123a, "android.permission.GET_ACCOUNTS") != 0) {
                i().j.a("Permission error checking for dasher/unicorn accounts");
            } else {
                if (this.f == null) {
                    this.f = AccountManager.get(this.f2563a.f2123a);
                }
                try {
                    Account[] result = this.f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, (AccountManagerCallback) null, (Handler) null).getResult();
                    if (result == null || result.length <= 0) {
                        Account[] result2 = this.f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, (AccountManagerCallback) null, (Handler) null).getResult();
                        if (result2 != null && result2.length > 0) {
                            this.g = Boolean.TRUE;
                            this.h = currentTimeMillis;
                            return true;
                        }
                    } else {
                        this.g = Boolean.TRUE;
                        this.h = currentTimeMillis;
                        return true;
                    }
                } catch (AuthenticatorException | OperationCanceledException | IOException e2) {
                    i().g.b("Exception checking account types", e2);
                }
            }
            this.h = currentTimeMillis;
            this.g = Boolean.FALSE;
            return false;
        }
        throw null;
    }
}
