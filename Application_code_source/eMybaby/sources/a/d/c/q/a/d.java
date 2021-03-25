package a.d.c.q.a;

import a.d.c.a;
import android.content.Intent;
import android.net.Uri;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.regex.Pattern;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f2918a = Pattern.compile(",");

    /* renamed from: b  reason: collision with root package name */
    public static final Collection<a> f2919b = EnumSet.of(a.UPC_A, a.UPC_E, a.EAN_13, a.EAN_8, a.RSS_14);

    /* renamed from: c  reason: collision with root package name */
    public static final Collection<a> f2920c;

    /* renamed from: d  reason: collision with root package name */
    public static final Collection<a> f2921d = EnumSet.of(a.QR_CODE);

    /* renamed from: e  reason: collision with root package name */
    public static final Collection<a> f2922e = EnumSet.of(a.DATA_MATRIX);

    static {
        EnumSet of = EnumSet.of(a.CODE_39, a.CODE_93, a.CODE_128, a.ITF);
        f2920c = of;
        of.addAll(f2919b);
    }

    public static Collection<a> a(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return c(stringExtra != null ? Arrays.asList(f2918a.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }

    public static Collection<a> b(Uri uri) {
        List<String> queryParameters = uri.getQueryParameters("SCAN_FORMATS");
        if (!(queryParameters == null || queryParameters.size() != 1 || queryParameters.get(0) == null)) {
            queryParameters = Arrays.asList(f2918a.split(queryParameters.get(0)));
        }
        return c(queryParameters, uri.getQueryParameter("SCAN_MODE"));
    }

    public static Collection<a> c(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet<E> noneOf = EnumSet.noneOf(a.class);
            try {
                for (String valueOf : iterable) {
                    noneOf.add(a.valueOf(valueOf));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str == null) {
            return null;
        }
        if ("PRODUCT_MODE".equals(str)) {
            return f2919b;
        }
        if ("QR_CODE_MODE".equals(str)) {
            return f2921d;
        }
        if ("DATA_MATRIX_MODE".equals(str)) {
            return f2922e;
        }
        if ("ONE_D_MODE".equals(str)) {
            return f2920c;
        }
        return null;
    }
}
