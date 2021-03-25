package a.f.a.f;

import android.os.Environment;
import com.example.lame.lame.JNIMp3eNCODE;
import java.io.File;
import java.io.FileOutputStream;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f3331a = null;

    /* renamed from: b  reason: collision with root package name */
    public File f3332b;

    /* renamed from: c  reason: collision with root package name */
    public FileOutputStream f3333c;

    /* renamed from: d  reason: collision with root package name */
    public int f3334d;

    /* renamed from: e  reason: collision with root package name */
    public JNIMp3eNCODE f3335e;

    public a() {
        File file = new File(Environment.getExternalStorageDirectory() + "/luckcome/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f3332b = null;
        this.f3333c = null;
        this.f3334d = 0;
        this.f3335e = null;
        String.valueOf(System.currentTimeMillis());
    }
}
