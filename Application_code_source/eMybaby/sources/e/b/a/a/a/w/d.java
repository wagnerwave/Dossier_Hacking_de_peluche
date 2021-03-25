package e.b.a.a.a.w;

import java.io.File;
import java.io.FilenameFilter;

public class d implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final String f5355a;

    public d(String str) {
        this.f5355a = str;
    }

    public boolean accept(File file, String str) {
        return str.endsWith(this.f5355a);
    }
}
