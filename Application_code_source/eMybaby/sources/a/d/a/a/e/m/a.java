package a.d.a.a.e.m;

import a.d.a.a.e.m.j;
import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public class a extends j.a {
    public static Account h(j jVar) {
        if (jVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return jVar.d();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
