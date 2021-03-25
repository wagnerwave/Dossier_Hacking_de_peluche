package a.d.a.a.e.q;

import com.tuya.smart.common.o0ooo00oo;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class e {
    static {
        Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static Map<String, String> a(URI uri, String str) {
        Map<String, String> emptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        HashMap hashMap = emptyMap;
        if (rawQuery != null) {
            hashMap = emptyMap;
            if (rawQuery.length() > 0) {
                HashMap hashMap2 = new HashMap();
                Scanner scanner = new Scanner(rawQuery);
                scanner.useDelimiter("&");
                while (scanner.hasNext()) {
                    String[] split = scanner.next().split(o0ooo00oo.O0000Oo0);
                    if (split.length == 0 || split.length > 2) {
                        throw new IllegalArgumentException("bad parameter");
                    }
                    try {
                        String decode = URLDecoder.decode(split[0], str);
                        String str2 = null;
                        if (split.length == 2) {
                            try {
                                str2 = URLDecoder.decode(split[1], str);
                            } catch (UnsupportedEncodingException e2) {
                                throw new IllegalArgumentException(e2);
                            }
                        }
                        hashMap2.put(decode, str2);
                    } catch (UnsupportedEncodingException e3) {
                        throw new IllegalArgumentException(e3);
                    }
                }
                hashMap = hashMap2;
            }
        }
        return hashMap;
    }
}
