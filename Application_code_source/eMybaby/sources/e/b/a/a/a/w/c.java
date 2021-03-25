package e.b.a.a.a.w;

import java.io.File;
import java.io.FileFilter;

public class c implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    public final String f5354a;

    public c(String str) {
        this.f5354a = str;
    }

    public boolean accept(File file) {
        return file.getName().endsWith(this.f5354a);
    }
}
