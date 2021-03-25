package d.a.a.i;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f4835a = Pattern.compile("[0-9a-f]+", 2);

    public static String a(String str) {
        if (str != null) {
            String trim = str.trim();
            Matcher matcher = f4835a.matcher(trim);
            if (trim.length() != 32) {
                throw new IllegalArgumentException("App ID length must be 32 characters.");
            } else if (matcher.matches()) {
                return trim;
            } else {
                throw new IllegalArgumentException("App ID must match regex pattern /[0-9a-f]+/i");
            }
        } else {
            throw new IllegalArgumentException("App ID must not be null.");
        }
    }
}
