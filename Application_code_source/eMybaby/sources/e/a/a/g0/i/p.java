package e.a.a.g0.i;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.SoftReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f5073a = {"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};

    /* renamed from: b  reason: collision with root package name */
    public static final Date f5074b;

    /* renamed from: c  reason: collision with root package name */
    public static final TimeZone f5075c = TimeZone.getTimeZone("GMT");

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> f5076a = new C0107a();

        /* renamed from: e.a.a.g0.i.p$a$a  reason: collision with other inner class name */
        public static class C0107a extends ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> {
            public Object initialValue() {
                return new SoftReference(new HashMap());
            }
        }
    }

    static {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(f5075c);
        instance.set(RecyclerView.MAX_SCROLL_DURATION, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        f5074b = instance.getTime();
    }

    public static Date a(String str, String[] strArr) {
        if (strArr == null) {
            strArr = f5073a;
        }
        Date date = f5074b;
        if (str.length() > 1 && str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1);
        }
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            Map map = (Map) a.f5076a.get().get();
            if (map == null) {
                map = new HashMap();
                a.f5076a.set(new SoftReference(map));
            }
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) map.get(str2);
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                map.put(str2, simpleDateFormat);
            }
            simpleDateFormat.set2DigitYearStart(date);
            try {
                return simpleDateFormat.parse(str);
            } catch (ParseException unused) {
                i++;
            }
        }
        throw new o(a.a.a.a.a.k("Unable to parse the date ", str));
    }
}
