package a.i.a;

import a.a.a.a.a;
import java.io.PrintWriter;

public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3585a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3586b;

    /* renamed from: c  reason: collision with root package name */
    public final long f3587c;

    /* renamed from: d  reason: collision with root package name */
    public final long f3588d;

    /* renamed from: e  reason: collision with root package name */
    public final long f3589e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final long n;

    public b0(int i2, int i3, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, int i4, int i5, int i6, long j10) {
        this.f3585a = i2;
        this.f3586b = i3;
        this.f3587c = j2;
        this.f3588d = j3;
        this.f3589e = j4;
        this.f = j5;
        this.g = j6;
        this.h = j7;
        this.i = j8;
        this.j = j9;
        this.k = i4;
        this.l = i5;
        this.m = i6;
        this.n = j10;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f3585a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f3586b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f3586b) / ((float) this.f3585a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f3587c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f3588d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f3589e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        StringBuilder n2 = a.n("StatsSnapshot{maxSize=");
        n2.append(this.f3585a);
        n2.append(", size=");
        n2.append(this.f3586b);
        n2.append(", cacheHits=");
        n2.append(this.f3587c);
        n2.append(", cacheMisses=");
        n2.append(this.f3588d);
        n2.append(", downloadCount=");
        n2.append(this.k);
        n2.append(", totalDownloadSize=");
        n2.append(this.f3589e);
        n2.append(", averageDownloadSize=");
        n2.append(this.h);
        n2.append(", totalOriginalBitmapSize=");
        n2.append(this.f);
        n2.append(", totalTransformedBitmapSize=");
        n2.append(this.g);
        n2.append(", averageOriginalBitmapSize=");
        n2.append(this.i);
        n2.append(", averageTransformedBitmapSize=");
        n2.append(this.j);
        n2.append(", originalBitmapCount=");
        n2.append(this.l);
        n2.append(", transformedBitmapCount=");
        n2.append(this.m);
        n2.append(", timeStamp=");
        n2.append(this.n);
        n2.append('}');
        return n2.toString();
    }
}
