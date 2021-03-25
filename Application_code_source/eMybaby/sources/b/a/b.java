package b.a;

import androidx.core.graphics.PaintCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tuya.smart.common.oOO0O0O0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public final class b {
    public static final Pattern i = Pattern.compile("\\|[^\\|]*\\|");
    public static final Pattern j = Pattern.compile("f{1,9}");
    public static final List<String> k;

    /* renamed from: a  reason: collision with root package name */
    public final String f3737a;

    /* renamed from: b  reason: collision with root package name */
    public final Locale f3738b;

    /* renamed from: c  reason: collision with root package name */
    public Collection<d> f3739c;

    /* renamed from: d  reason: collision with root package name */
    public Collection<c> f3740d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<Locale, List<String>> f3741e = new LinkedHashMap();
    public final Map<Locale, List<String>> f = new LinkedHashMap();
    public final Map<Locale, List<String>> g = new LinkedHashMap();
    public final C0090b h;

    /* renamed from: b.a.b$b  reason: collision with other inner class name */
    public final class C0090b {
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public int f3742a;

        /* renamed from: b  reason: collision with root package name */
        public int f3743b;

        public c() {
        }

        public c(a aVar) {
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public int f3744a;

        /* renamed from: b  reason: collision with root package name */
        public int f3745b;

        /* renamed from: c  reason: collision with root package name */
        public String f3746c;

        public d() {
        }

        public d(a aVar) {
        }

        public String toString() {
            StringBuilder n = a.a.a.a.a.n("Start:");
            n.append(this.f3744a);
            n.append(" End:");
            n.append(this.f3745b);
            n.append(" '");
            return a.a.a.a.a.m(n, this.f3746c, "'");
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        k = arrayList;
        arrayList.add("YYYY");
        k.add("YY");
        k.add("MMMM");
        k.add("MMM");
        k.add("MM");
        k.add("M");
        k.add("DD");
        k.add("D");
        k.add("WWWW");
        k.add("WWW");
        k.add("hh12");
        k.add("h12");
        k.add("hh");
        k.add("h");
        k.add("mm");
        k.add(PaintCompat.EM_STRING);
        k.add("ss");
        k.add("s");
        k.add("a");
        k.add("fffffffff");
        k.add("ffffffff");
        k.add("fffffff");
        k.add("ffffff");
        k.add("fffff");
        k.add("ffff");
        k.add("fff");
        k.add("ff");
        k.add("f");
    }

    public b(String str) {
        this.f3737a = str;
        this.f3738b = null;
        this.h = null;
        if (!a.e.a.a.r.b.b0(str)) {
            throw new IllegalArgumentException("DateTime format has no content.");
        }
    }

    public final String a(String str) {
        return (!a.e.a.a.r.b.b0(str) || str.length() != 1) ? str : a.a.a.a.a.k(oOO0O0O0.O0000oO0, str);
    }

    public final String b(String str) {
        return (!a.e.a.a.r.b.b0(str) || str.length() < 3) ? str : str.substring(0, 3);
    }

    public final String c(Integer num) {
        if (num == null) {
            return "";
        }
        Locale locale = this.f3738b;
        if (locale != null) {
            if (!this.f3741e.containsKey(locale)) {
                ArrayList arrayList = new ArrayList();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM", this.f3738b);
                for (int i2 = 0; i2 <= 11; i2++) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.set(1, RecyclerView.MAX_SCROLL_DURATION);
                    gregorianCalendar.set(2, i2);
                    gregorianCalendar.set(5, 15);
                    arrayList.add(simpleDateFormat.format(gregorianCalendar.getTime()));
                }
                this.f3741e.put(this.f3738b, arrayList);
            }
            return (String) this.f3741e.get(this.f3738b).get(num.intValue() - 1);
        }
        StringBuilder n = a.a.a.a.a.n("Your date pattern requires either a Locale, or your own custom localizations for text:");
        n.append(a.e.a.a.r.b.V(this.f3737a));
        throw new IllegalArgumentException(n.toString());
    }

    public final String d(Integer num) {
        if (num == null) {
            return "";
        }
        Locale locale = this.f3738b;
        if (locale != null) {
            if (!this.f.containsKey(locale)) {
                ArrayList arrayList = new ArrayList();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", this.f3738b);
                for (int i2 = 8; i2 <= 14; i2++) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.set(1, 2009);
                    gregorianCalendar.set(2, 1);
                    gregorianCalendar.set(5, i2);
                    arrayList.add(simpleDateFormat.format(gregorianCalendar.getTime()));
                }
                this.f.put(this.f3738b, arrayList);
            }
            return (String) this.f.get(this.f3738b).get(num.intValue() - 1);
        }
        StringBuilder n = a.a.a.a.a.n("Your date pattern requires either a Locale, or your own custom localizations for text:");
        n.append(a.e.a.a.r.b.V(this.f3737a));
        throw new IllegalArgumentException(n.toString());
    }

    public final String e(Integer num) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("a", this.f3738b);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, RecyclerView.MAX_SCROLL_DURATION);
        gregorianCalendar.set(2, 6);
        gregorianCalendar.set(5, 15);
        gregorianCalendar.set(11, num.intValue());
        return simpleDateFormat.format(gregorianCalendar.getTime());
    }

    public final Integer f(Integer num) {
        if (num == null) {
            return num;
        }
        if (num.intValue() == 0) {
            return 12;
        }
        return num.intValue() > 12 ? Integer.valueOf(num.intValue() - 12) : num;
    }

    public final String g(Object obj) {
        return obj != null ? String.valueOf(obj) : "";
    }
}
