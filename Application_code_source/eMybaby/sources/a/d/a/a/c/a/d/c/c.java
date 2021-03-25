package a.d.a.a.c.a.d.c;

import a.c.a.f.b;
import a.d.a.a.e.k.d;
import a.d.a.a.e.k.e;
import a.d.a.a.e.k.f;
import a.d.a.a.e.k.l.l;
import a.d.a.a.e.n.a;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class c implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    public static final a f1212c = new a("RevokeAccessOperation", new String[0]);

    /* renamed from: a  reason: collision with root package name */
    public final String f1213a;

    /* renamed from: b  reason: collision with root package name */
    public final l f1214b = new l((d) null);

    public c(String str) {
        b.h(str);
        this.f1213a = str;
    }

    public static e<Status> a(@Nullable String str) {
        if (str == null) {
            Status status = new Status(4);
            b.l(status, "Result must not be null");
            b.e(!status.e(), "Status code must not be SUCCESS");
            f fVar = new f((d) null, status);
            fVar.e(status);
            return fVar;
        }
        c cVar = new c(str);
        new Thread(cVar).start();
        return cVar.f1214b;
    }

    public final void run() {
        Status status = Status.g;
        try {
            String valueOf = String.valueOf(this.f1213a);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(valueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f4205e;
            } else {
                f1212c.b("Unable to revoke access!", new Object[0]);
            }
            a aVar = f1212c;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            aVar.a(sb.toString(), new Object[0]);
        } catch (IOException e2) {
            a aVar2 = f1212c;
            String valueOf2 = String.valueOf(e2.toString());
            aVar2.b(valueOf2.length() != 0 ? "IOException when revoking access: ".concat(valueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e3) {
            a aVar3 = f1212c;
            String valueOf3 = String.valueOf(e3.toString());
            aVar3.b(valueOf3.length() != 0 ? "Exception when revoking access: ".concat(valueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.f1214b.e(status);
    }
}
