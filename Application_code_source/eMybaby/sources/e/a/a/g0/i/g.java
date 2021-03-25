package e.a.a.g0.i;

import a.a.a.a.a;
import e.a.a.e0.k;
import e.a.a.e0.m;
import java.util.Date;

public class g extends a {
    public void c(m mVar, String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt >= 0) {
                    ((c) mVar).f5063e = new Date((((long) parseInt) * 1000) + System.currentTimeMillis());
                    return;
                }
                throw new k(a.k("Negative max-age attribute: ", str));
            } catch (NumberFormatException unused) {
                throw new k(a.k("Invalid max-age attribute: ", str));
            }
        } else {
            throw new k("Missing value for max-age attribute");
        }
    }
}
