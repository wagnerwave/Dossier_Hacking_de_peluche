package a.c.d.r;

import a.c.a.a;
import android.graphics.Typeface;
import com.sozpic.miniland.AppMiniland;

public class e {

    /* renamed from: d  reason: collision with root package name */
    public static e f787d;

    /* renamed from: a  reason: collision with root package name */
    public Typeface f788a = Typeface.createFromAsset(AppMiniland.f().getAssets(), "fonts/gothamrb.otf");

    /* renamed from: b  reason: collision with root package name */
    public Typeface f789b = Typeface.createFromAsset(((AppMiniland) a.f).getAssets(), "fonts/gothamr.otf");

    /* renamed from: c  reason: collision with root package name */
    public Typeface f790c = Typeface.createFromAsset(((AppMiniland) a.f).getAssets(), "fonts/HelveticaNeueMedium.ttf");

    public e() {
        f787d = this;
    }

    public static final e a() {
        if (f787d == null) {
            f787d = new e();
        }
        return f787d;
    }
}
