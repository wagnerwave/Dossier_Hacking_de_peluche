package a.c.a.d;

import a.c.d.r.f;
import a.c.d.r.g;
import a.c.d.r.j;
import a.d.a.a.h.g.u2;
import a.d.a.a.h.g.v2;
import a.d.a.a.h.g.w2;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.util.TimeUtils;
import com.cuatroochenta.miniland.emyscale.MyScaleStatisticsActivity;
import com.cuatroochenta.miniland.help.HelpActivity;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Agenda;
import com.sozpic.miniland.modelos.Bebe;
import com.tuya.smart.common.o0ooo00oo;
import com.tuya.smart.common.oOO0O0O0;
import com.tuya.smart.home.sdk.bean.scene.PreCondition;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class a {
    public static int A(int i, int i2) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(w(i, i2, "index"));
    }

    public static void B(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), i);
    }

    public static void b(Context context, Agenda agenda) {
        if (agenda != null) {
            Date startDate = agenda.getStartDate();
            Date endDate = agenda.getEndDate();
            if (startDate != null) {
                context.startActivity(new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("beginTime", startDate.getTime()).putExtra("endTime", endDate != null ? endDate.getTime() : startDate.getTime() + 3600000).putExtra(NotificationCompatJellybean.KEY_TITLE, g(agenda.getNombre())).putExtra("description", g(agenda.getTexto())).putExtra("availability", 0).putExtra(PreCondition.TIMEINTERVAL_ALLDAY, agenda.isAllDay()));
            }
        }
    }

    public static String c(String str, HashMap<String, String> hashMap) {
        StringBuilder n = a.a.a.a.a.n(str);
        if (hashMap != null && !hashMap.isEmpty()) {
            n.append("?");
            boolean z = true;
            for (String next : hashMap.keySet()) {
                if (z) {
                    z = false;
                } else {
                    n.append("&");
                }
                n.append(next);
                n.append(o0ooo00oo.O0000Oo0);
                n.append(URLEncoder.encode(hashMap.get(next), "UTF-8"));
            }
        }
        return n.toString();
    }

    @NonNullDecl
    public static <T> T d(@NonNullDecl T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static String e(int i) {
        return f(i, false);
    }

    public static String f(int i, boolean z) {
        if (i <= 0) {
            return z ? "0:0:00" : "0:00";
        }
        int i2 = i / TimeUtils.SECONDS_PER_HOUR;
        int i3 = i - (i2 * TimeUtils.SECONDS_PER_HOUR);
        int i4 = i3 / 60;
        int i5 = i3 - (i4 * 60);
        StringBuilder sb = new StringBuilder();
        if (i2 > 0 || z) {
            sb.append(i2);
            sb.append(":");
        }
        if (i4 < 10) {
            sb.append(oOO0O0O0.O0000oO0);
        }
        sb.append(i4);
        sb.append(":");
        if (i5 < 10) {
            sb.append(oOO0O0O0.O0000oO0);
        }
        sb.append(i5);
        return sb.toString();
    }

    public static String g(String str) {
        return j(str) ? "" : str;
    }

    public static String h(int i) {
        a.c.a.a aVar = a.c.a.a.f;
        return aVar.c(aVar.getString(i));
    }

    public static String i(int i) {
        a.c.a.a aVar = a.c.a.a.f;
        return aVar.c(aVar.getString(i)).replace("%@", "%s");
    }

    public static boolean j(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean k(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable();
    }

    public static void l(Activity activity, String str) {
        Intent intent = new Intent(activity, HelpActivity.class);
        intent.putExtra("KEY_INTENT_HELP_SECTION_CODE", str);
        activity.startActivityForResult(intent, 1004);
    }

    public static void m(Context context, Bebe bebe) {
        if (bebe != null) {
            Intent intent = new Intent(context, MyScaleStatisticsActivity.class);
            intent.putExtra("KEY_INTENT_BABY", bebe);
            context.startActivity(intent);
        }
    }

    public static void n(Context context, String str) {
        if (!j(str)) {
            if (!str.startsWith("https://") && !str.startsWith("http://")) {
                str = a.a.a.a.a.k("https://", str);
            }
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    public static void o(NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT >= 26 && notificationManager != null && notificationManager.getNotificationChannel("CHANNEL_ID") == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
        }
    }

    public static void p(Calendar calendar) {
        calendar.set(11, calendar.getActualMinimum(11));
        calendar.set(12, calendar.getActualMinimum(12));
        calendar.set(13, calendar.getActualMinimum(13));
        calendar.set(14, calendar.getActualMinimum(14));
    }

    public static void q(Context context, g gVar) {
        CharSequence[] charSequenceArr = {j.c(0), j.c(1), j.c(3), j.c(4)};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(h(R.string.TR_SELECT_MEASURE_UNIT));
        builder.setCancelable(false);
        builder.setItems(charSequenceArr, new f(gVar));
        builder.show();
        a.c.a.e.f.c().e("SETTINGS_MYSCALE_UNIT_SELECTOR");
    }

    public static int r(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * -862048943), 15)) * 461845907);
    }

    public static int s(int i, int i2) {
        String str;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = x("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i2 < 0) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else {
            str = x("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static int t(@NullableDecl Object obj) {
        return r(obj == null ? 0 : obj.hashCode());
    }

    public static int u(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ((i + (next != null ? next.hashCode() : 0)) ^ -1) ^ -1;
        }
        return i;
    }

    public static <T> u2<T> v(u2<T> u2Var) {
        return ((u2Var instanceof v2) || (u2Var instanceof w2)) ? u2Var : u2Var instanceof Serializable ? new w2(u2Var) : new v2(u2Var);
    }

    public static String w(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return x("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return x("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static String x(@NullableDecl String str, @NullableDecl Object... objArr) {
        int indexOf;
        String str2;
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e2) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + name.length() + 1);
                    sb.append(name);
                    sb.append('@');
                    sb.append(hexString);
                    String sb2 = sb.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(sb2);
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", valueOf.length() != 0 ? "Exception during lenientFormat for ".concat(valueOf) : new String("Exception during lenientFormat for "), e2);
                    String name2 = e2.getClass().getName();
                    StringBuilder sb3 = new StringBuilder(name2.length() + String.valueOf(sb2).length() + 9);
                    sb3.append("<");
                    sb3.append(sb2);
                    sb3.append(" threw ");
                    sb3.append(name2);
                    sb3.append(">");
                    str2 = sb3.toString();
                }
            }
            objArr[i2] = str2;
        }
        StringBuilder sb4 = new StringBuilder((objArr.length * 16) + str.length());
        int i3 = 0;
        while (i < objArr.length && (indexOf = str.indexOf("%s", i3)) != -1) {
            sb4.append(str, i3, indexOf);
            sb4.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb4.append(str, i3, str.length());
        if (i < objArr.length) {
            sb4.append(" [");
            sb4.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb4.append(", ");
                sb4.append(objArr[i4]);
            }
            sb4.append(']');
        }
        return sb4.toString();
    }

    public static void y(int i, int i2, int i3) {
        String str;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                str = w(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                str = w(i2, i3, "end index");
            } else {
                str = x("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static boolean z(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
