package a.c.d.r;

import a.a.a.a.a;
import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

public class b implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    public Pattern f785a;

    public b(int i, int i2) {
        StringBuilder n = a.n("[0-9]{0,");
        n.append(i - 1);
        n.append("}+((\\.[0-9]{0,");
        n.append(i2 - 1);
        n.append("})?)||(\\.)?");
        this.f785a = Pattern.compile(n.toString());
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (!this.f785a.matcher(spanned).matches()) {
            return "";
        }
        return null;
    }
}
