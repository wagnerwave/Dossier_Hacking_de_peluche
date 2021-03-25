package d.a.a;

import android.os.Process;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.Date;
import java.util.UUID;

public class g implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4829a = false;

    /* renamed from: b  reason: collision with root package name */
    public f f4830b;

    /* renamed from: c  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f4831c;

    public g(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, f fVar, boolean z) {
        this.f4831c = uncaughtExceptionHandler;
        this.f4829a = z;
        this.f4830b = fVar;
    }

    public static void a(String str, String str2) {
        try {
            throw null;
        } catch (Exception unused) {
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (a.f4810a != null) {
            f fVar = this.f4830b;
            Date date = new Date();
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            try {
                String uuid = UUID.randomUUID().toString();
                String str = a.f4810a + "/" + uuid + ".stacktrace";
                Log.d("HockeyApp", "Writing unhandled exception to: " + str);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
                bufferedWriter.write("Package: " + a.f4813d + "\n");
                bufferedWriter.write("Version Code: " + a.f4811b + "\n");
                bufferedWriter.write("Version Name: " + a.f4812c + "\n");
                bufferedWriter.write("Android: " + a.f4814e + "\n");
                bufferedWriter.write("Manufacturer: " + a.g + "\n");
                bufferedWriter.write("Model: " + a.f + "\n");
                if (a.h != null) {
                    bufferedWriter.write("CrashReporter Key: " + a.h + "\n");
                }
                bufferedWriter.write("Date: " + date + "\n");
                bufferedWriter.write("\n");
                bufferedWriter.write(stringWriter.toString());
                bufferedWriter.flush();
                bufferedWriter.close();
                if (fVar != null) {
                    a((String) null, uuid + ".user");
                    a((String) null, uuid + ".contact");
                    a((String) null, uuid + ".description");
                }
            } catch (Exception e2) {
                Log.e("HockeyApp", "Error saving exception stacktrace!\n", e2);
            }
            if (this.f4829a) {
                Process.killProcess(Process.myPid());
                System.exit(10);
                return;
            }
        }
        this.f4831c.uncaughtException(thread, th);
    }
}
