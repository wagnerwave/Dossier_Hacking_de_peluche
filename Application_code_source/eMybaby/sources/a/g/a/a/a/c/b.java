package a.g.a.a.a.c;

import a.g.a.a.a.d.a;
import java.io.File;

public class b extends a.g.a.a.a.b {
    public b(File file, a aVar, int i) {
        super(file, aVar, i);
        if (i < 2097152) {
            a.e.a.a.r.b.f0("You set too small disc cache size (less than %1$d Mb)", 2);
        }
    }

    public int c(File file) {
        return (int) file.length();
    }
}
