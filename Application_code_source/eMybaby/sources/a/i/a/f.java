package a.i.a;

import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.tuya.smart.common.o00000oo0;

public class f extends y {

    /* renamed from: b  reason: collision with root package name */
    public static final UriMatcher f3600b;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3601a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f3600b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f3600b.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f3600b.addURI("com.android.contacts", "contacts/#/photo", 2);
        f3600b.addURI("com.android.contacts", "contacts/#", 3);
        f3600b.addURI("com.android.contacts", "display_photo/#", 4);
    }

    public f(Context context) {
        this.f3601a = context;
    }

    public boolean c(w wVar) {
        Uri uri = wVar.f3680d;
        return o00000oo0.O00000o0.equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f3600b.match(wVar.f3680d) != -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.i.a.y.a f(a.i.a.w r5, int r6) {
        /*
            r4 = this;
            android.content.Context r6 = r4.f3601a
            android.content.ContentResolver r6 = r6.getContentResolver()
            android.net.Uri r5 = r5.f3680d
            android.content.UriMatcher r0 = f3600b
            int r0 = r0.match(r5)
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0038
            r3 = 2
            if (r0 == r3) goto L_0x0033
            r3 = 3
            if (r0 == r3) goto L_0x0040
            r1 = 4
            if (r0 != r1) goto L_0x001c
            goto L_0x0033
        L_0x001c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid uri: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        L_0x0033:
            java.io.InputStream r5 = r6.openInputStream(r5)
            goto L_0x0044
        L_0x0038:
            android.net.Uri r5 = android.provider.ContactsContract.Contacts.lookupContact(r6, r5)
            if (r5 != 0) goto L_0x0040
            r5 = r2
            goto L_0x0044
        L_0x0040:
            java.io.InputStream r5 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r6, r5, r1)
        L_0x0044:
            if (r5 == 0) goto L_0x004d
            a.i.a.y$a r2 = new a.i.a.y$a
            a.i.a.t$d r6 = a.i.a.t.d.DISK
            r2.<init>(r5, r6)
        L_0x004d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.a.f.f(a.i.a.w, int):a.i.a.y$a");
    }
}
