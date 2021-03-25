package e.a.a.c0;

import java.io.IOException;

public class d extends IOException {
    public d(String str) {
        super(str);
    }

    public d(Throwable th) {
        initCause(th);
    }
}
