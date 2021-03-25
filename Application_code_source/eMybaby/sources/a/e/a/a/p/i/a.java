package a.e.a.a.p.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public abstract class a implements Handler.Callback {
    public static final int MSG_INVOKE = 1;
    public static final int MSG_SYNC_INVOKE = 2;
    public Handler mHandler;
    public Handler mSyncHandler;

    public a() {
        if (Looper.myLooper() != null) {
            this.mHandler = new Handler(Looper.myLooper(), this);
            this.mSyncHandler = new Handler(Looper.getMainLooper(), this);
            return;
        }
        throw new IllegalStateException();
    }

    public boolean handleMessage(Message message) {
        Object[] objArr = (Object[]) message.obj;
        int i = message.what;
        if (i == 1) {
            onInvoke(objArr);
        } else if (i == 2) {
            onSyncInvoke(objArr);
        }
        return true;
    }

    public final void invoke(Object... objArr) {
        this.mHandler.obtainMessage(1, objArr).sendToTarget();
    }

    public final void invokeSync(Object... objArr) {
        this.mSyncHandler.obtainMessage(2, objArr).sendToTarget();
    }

    public abstract void onInvoke(Object... objArr);

    public abstract void onSyncInvoke(Object... objArr);
}
