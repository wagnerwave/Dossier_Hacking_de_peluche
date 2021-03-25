package a.c.d.r;

import a.c.a.d.a;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class i {
    public static long a(Date date) {
        Date e2 = e();
        if (!date.after(e2)) {
            return 0;
        }
        return TimeUnit.MILLISECONDS.toDays(date.getTime() - e2.getTime()) % 7;
    }

    public static String b(Date date) {
        return d(date) + " / " + j.g.format(date);
    }

    public static long c(Date date) {
        Date e2 = e();
        if (!date.after(e2)) {
            return 0;
        }
        return TimeUnit.MILLISECONDS.toDays(date.getTime() - e2.getTime()) / 7;
    }

    public static String d(Date date) {
        return String.format(Locale.getDefault(), a.i(R.string.TR_SEMANA_PLACEHOLDER), new Object[]{String.valueOf(c(date)), String.valueOf(a(date))});
    }

    public static Date e() {
        Date birthDate = AppMiniland.f().i().getBirthDate();
        Calendar instance = Calendar.getInstance();
        instance.setTime(birthDate);
        instance.add(3, -40);
        return instance.getTime();
    }
}
