package a.d.a.a.e.q;

import androidx.annotation.Nullable;
import java.util.regex.Pattern;

public class g {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static boolean a(@Nullable String str) {
        return str == null || str.trim().isEmpty();
    }
}
