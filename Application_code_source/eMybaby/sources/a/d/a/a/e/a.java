package a.d.a.a.e;

import a.c.a.f.b;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1225a = false;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<IBinder> f1226b = new LinkedBlockingQueue();

    public IBinder a(long j, TimeUnit timeUnit) {
        b.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f1225a) {
            this.f1225a = true;
            IBinder poll = this.f1226b.poll(j, timeUnit);
            if (poll != null) {
                return poll;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f1226b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
