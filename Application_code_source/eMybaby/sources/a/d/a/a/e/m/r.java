package a.d.a.a.e.m;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public final class r extends Button {
    public r(Context context) {
        super(context, (AttributeSet) null, 16842824);
    }

    public static int a(int i, int i2, int i3, int i4) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i3;
        }
        if (i == 2) {
            return i4;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unknown color scheme: ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }
}
