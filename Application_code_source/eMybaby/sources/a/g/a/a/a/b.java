package a.g.a.a.a;

import a.g.a.a.a.d.a;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public int f3343c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f3344d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<File, Long> f3345e = Collections.synchronizedMap(new HashMap());

    public b(File file, a aVar, int i) {
        super(file, aVar);
        this.f3344d = i;
        int i2 = 0;
        for (File file2 : this.f3341a.listFiles()) {
            i2 += c(file2);
            this.f3345e.put(file2, Long.valueOf(file2.lastModified()));
        }
        this.f3343c = i2;
    }

    public File a(String str) {
        File file = new File(this.f3341a, this.f3342b.a(str));
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(valueOf.longValue());
        this.f3345e.put(file, valueOf);
        return file;
    }

    public void b(String str, File file) {
        int i;
        File file2;
        int c2 = c(file);
        while (this.f3343c + c2 > this.f3344d) {
            if (this.f3345e.isEmpty()) {
                i = 0;
            } else {
                Set<Map.Entry<File, Long>> entrySet = this.f3345e.entrySet();
                synchronized (this.f3345e) {
                    file2 = null;
                    Long l = null;
                    for (Map.Entry next : entrySet) {
                        if (file2 == null) {
                            file2 = (File) next.getKey();
                            l = (Long) next.getValue();
                        } else {
                            Long l2 = (Long) next.getValue();
                            if (l2.longValue() < l.longValue()) {
                                file2 = (File) next.getKey();
                                l = l2;
                            }
                        }
                    }
                }
                i = c(file2);
                if (file2.delete()) {
                    this.f3345e.remove(file2);
                }
            }
            if (i == 0) {
                break;
            }
            this.f3343c -= i;
        }
        this.f3343c += c2;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(valueOf.longValue());
        this.f3345e.put(file, valueOf);
    }

    public abstract int c(File file);
}
