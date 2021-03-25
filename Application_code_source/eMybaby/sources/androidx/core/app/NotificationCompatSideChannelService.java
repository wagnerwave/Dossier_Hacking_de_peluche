package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.INotificationSideChannel;

public abstract class NotificationCompatSideChannelService extends Service {

    public class NotificationSideChannelStub extends INotificationSideChannel.Stub {
        public NotificationSideChannelStub() {
        }

        public void cancel(String str, int i, String str2) {
            NotificationCompatSideChannelService.this.checkPermission(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancel(str, i, str2);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void cancelAll(String str) {
            NotificationCompatSideChannelService.this.checkPermission(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.cancelAll(str);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void notify(String str, int i, String str2, Notification notification) {
            NotificationCompatSideChannelService.this.checkPermission(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.notify(str, i, str2, notification);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public abstract void cancel(String str, int i, String str2);

    public abstract void cancelAll(String str);

    public void checkPermission(int i, String str) {
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        int length = packagesForUid.length;
        int i2 = 0;
        while (i2 < length) {
            if (!packagesForUid[i2].equals(str)) {
                i2++;
            } else {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i + " is not authorized for package " + str);
    }

    public abstract void notify(String str, int i, String str2, Notification notification);

    public IBinder onBind(Intent intent) {
        if (!intent.getAction().equals(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL) || Build.VERSION.SDK_INT > 19) {
            return null;
        }
        return new NotificationSideChannelStub();
    }
}
