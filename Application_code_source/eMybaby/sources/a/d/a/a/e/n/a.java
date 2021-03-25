package a.d.a.a.e.n;

import a.d.a.a.e.m.h;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f1421a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1422b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1423c;

    public a(String str, String... strArr) {
        String str2;
        if (strArr.length == 0) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str3 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str3);
            }
            sb.append(']');
            sb.append(' ');
            str2 = sb.toString();
        }
        this.f1422b = str2;
        this.f1421a = str;
        new h(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.f1421a, i)) {
            i++;
        }
        this.f1423c = i;
    }

    public void a(String str, @Nullable Object... objArr) {
        if (this.f1423c <= 3) {
            String str2 = this.f1421a;
            if (objArr.length > 0) {
                str = String.format(Locale.US, str, objArr);
            }
            Log.d(str2, this.f1422b.concat(str));
        }
    }

    public void b(String str, @Nullable Object... objArr) {
        String str2 = this.f1421a;
        if (objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        Log.e(str2, this.f1422b.concat(str));
    }
}
