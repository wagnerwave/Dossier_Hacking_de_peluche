package a.f.a.f;

import com.tutk.IOTC.Camera;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.platform.AndroidPlatform;

public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f3336c = {82, 73, 70, 70};

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f3337d = {87, 65, 86, 69};

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f3338e = {102, 109, 116, 32};
    public static final byte[] f = {100, 97, 116, 97};

    /* renamed from: a  reason: collision with root package name */
    public int f3339a;

    /* renamed from: b  reason: collision with root package name */
    public int f3340b;

    public void a(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.write(f3336c);
            randomAccessFile.writeInt(a.e.a.a.r.b.b(this.f3339a));
            randomAccessFile.write(f3337d);
            randomAccessFile.write(f3338e);
            randomAccessFile.writeInt(a.e.a.a.r.b.b(16));
            randomAccessFile.writeShort(a.e.a.a.r.b.a(1));
            randomAccessFile.writeShort(a.e.a.a.r.b.a(1));
            randomAccessFile.writeInt(a.e.a.a.r.b.b(AndroidPlatform.MAX_LOG_LENGTH));
            randomAccessFile.writeInt(a.e.a.a.r.b.b(Camera.ThreadSendAudio.SAMPLE_RATE_IN_HZ));
            randomAccessFile.writeShort(a.e.a.a.r.b.a(2));
            randomAccessFile.writeShort(a.e.a.a.r.b.a(16));
            randomAccessFile.write(f);
            randomAccessFile.writeInt(a.e.a.a.r.b.b(this.f3340b));
            randomAccessFile.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
