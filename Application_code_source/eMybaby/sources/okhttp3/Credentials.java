package okhttp3;

import a.a.a.a.a;
import java.nio.charset.Charset;
import okio.ByteString;

public final class Credentials {
    public static String basic(String str, String str2) {
        return basic(str, str2, Charset.forName("ISO-8859-1"));
    }

    public static String basic(String str, String str2, Charset charset) {
        return a.k("Basic ", ByteString.of((str + ":" + str2).getBytes(charset)).base64());
    }
}
