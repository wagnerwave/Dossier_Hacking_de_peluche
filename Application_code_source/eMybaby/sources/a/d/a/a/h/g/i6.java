package a.d.a.a.h.g;

import java.io.IOException;

public class i6 extends IOException {
    public i6(String str) {
        super(str);
    }

    public static i6 a() {
        return new i6("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static i6 b() {
        return new i6("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static i6 c() {
        return new i6("Protocol message contained an invalid tag (zero).");
    }

    public static h6 d() {
        return new h6("Protocol message tag had invalid wire type.");
    }

    public static i6 e() {
        return new i6("Failed to parse the message.");
    }

    public static i6 f() {
        return new i6("Protocol message had invalid UTF-8.");
    }
}
