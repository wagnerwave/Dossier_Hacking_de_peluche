package e.a.a.d0;

import e.a.a.j;
import java.net.ConnectException;

public class i extends ConnectException {
    public i(j jVar, ConnectException connectException) {
        super("Connection to " + jVar + " refused");
        initCause(connectException);
    }
}
