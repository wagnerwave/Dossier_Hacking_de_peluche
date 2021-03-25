package e.a.a;

import java.io.Serializable;

public final class q extends w implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final q f5192d = new q(0, 9);

    /* renamed from: e  reason: collision with root package name */
    public static final q f5193e = new q(1, 0);
    public static final q f = new q(1, 1);

    public q(int i, int i2) {
        super("HTTP", i, i2);
    }

    public w b(int i, int i2) {
        if (i == this.f5195b && i2 == this.f5196c) {
            return this;
        }
        if (i == 1) {
            if (i2 == 0) {
                return f5193e;
            }
            if (i2 == 1) {
                return f;
            }
        }
        return (i == 0 && i2 == 9) ? f5192d : new q(i, i2);
    }
}
