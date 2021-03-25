package a.d.a.a.e.k.l;

import a.d.a.a.e.k.l.f;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;

public abstract class b0 {
    public b0(int i) {
    }

    public static Status d(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (remoteException instanceof TransactionTooLargeException) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void a(@NonNull Status status);

    public abstract void b(@NonNull r0 r0Var, boolean z);

    public abstract void c(@NonNull RuntimeException runtimeException);

    public abstract void e(f.a<?> aVar);
}
