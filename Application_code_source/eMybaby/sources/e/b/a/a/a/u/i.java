package e.b.a.a.a.u;

import a.e.a.a.r.b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public File f5275a;

    /* renamed from: b  reason: collision with root package name */
    public RandomAccessFile f5276b;

    /* renamed from: c  reason: collision with root package name */
    public Object f5277c;

    public i(File file, String str) {
        this.f5275a = new File(file, str);
        if (b.J("java.nio.channels.FileLock")) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.f5275a, "rw");
                this.f5276b = randomAccessFile;
                Object invoke = randomAccessFile.getClass().getMethod("getChannel", new Class[0]).invoke(this.f5276b, new Object[0]);
                this.f5277c = invoke.getClass().getMethod("tryLock", new Class[0]).invoke(invoke, new Object[0]);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException unused) {
                this.f5277c = null;
            }
            if (this.f5277c == null) {
                a();
                throw new Exception("Problem obtaining file lock");
            }
        }
    }

    public void a() {
        try {
            if (this.f5277c != null) {
                this.f5277c.getClass().getMethod("release", new Class[0]).invoke(this.f5277c, new Object[0]);
                this.f5277c = null;
            }
        } catch (Exception unused) {
        }
        RandomAccessFile randomAccessFile = this.f5276b;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            this.f5276b = null;
        }
        File file = this.f5275a;
        if (file != null && file.exists()) {
            this.f5275a.delete();
        }
        this.f5275a = null;
    }
}
