package a.d.a.a.e.m;

import a.d.a.a.e.m.b;
import a.d.a.a.h.e.c;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.zza;

public interface k extends IInterface {

    public static abstract class a extends a.d.a.a.h.e.a implements k {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        public final boolean e(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                ((b.i) this).g(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a(parcel, Bundle.CREATOR));
            } else if (i == 2) {
                parcel.readInt();
                Bundle bundle = (Bundle) c.a(parcel, Bundle.CREATOR);
                Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
            } else if (i != 3) {
                return false;
            } else {
                int readInt = parcel.readInt();
                IBinder readStrongBinder = parcel.readStrongBinder();
                zza zza = (zza) c.a(parcel, zza.CREATOR);
                b.i iVar = (b.i) this;
                a.c.a.f.b.l(iVar.f1367a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
                a.c.a.f.b.k(zza);
                iVar.f1367a.t = zza;
                iVar.g(readInt, readStrongBinder, zza.f4235a);
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
