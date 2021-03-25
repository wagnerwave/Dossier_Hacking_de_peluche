package a.e.a.a;

import a.e.a.a.r.b;
import java.util.UUID;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final UUID f3227a = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    /* renamed from: b  reason: collision with root package name */
    public static final UUID f3228b = UUID.fromString("00002901-0000-1000-8000-00805f9b34fb");

    public static String a(int i) {
        if (i == 0) {
            return "Disconnected";
        }
        if (i == 1) {
            return "Connecting";
        }
        if (i == 2) {
            return "Connected";
        }
        if (i == 3) {
            return "Disconnecting";
        }
        if (i == 19) {
            return "Service Ready";
        }
        return b.o("Unknown %d", Integer.valueOf(i));
    }
}
