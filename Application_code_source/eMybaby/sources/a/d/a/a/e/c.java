package a.d.a.a.e;

import a.c.a.f.b;
import a.d.a.a.e.k.l.i;
import a.d.a.a.e.m.e;
import a.d.a.a.e.m.u;
import a.d.a.a.e.m.v;
import a.d.a.a.h.d.d;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class c extends d {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f1230c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final c f1231d = new c();

    @SuppressLint({"HandlerLeak"})
    public class a extends d {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1232a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f1232a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int c2 = c.this.c(this.f1232a);
            PendingIntent pendingIntent = null;
            if (c.this == null) {
                throw null;
            } else if (g.g(c2)) {
                c cVar = c.this;
                Context context = this.f1232a;
                Intent a2 = cVar.a(context, c2, "n");
                if (a2 != null) {
                    pendingIntent = PendingIntent.getActivity(context, 0, a2, 134217728);
                }
                cVar.h(context, c2, pendingIntent);
            }
        }
    }

    public static Dialog e(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(a.d.a.a.e.m.d.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        g(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public static Dialog f(Context context, int i, e eVar, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(a.d.a.a.e.m.d.c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String string = context.getResources().getString(i != 1 ? i != 2 ? i != 3 ? 17039370 : a.d.a.a.d.c.common_google_play_services_enable_button : a.d.a.a.d.c.common_google_play_services_update_button : a.d.a.a.d.c.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, eVar);
        }
        String d2 = a.d.a.a.e.m.d.d(context, i);
        if (d2 != null) {
            builder.setTitle(d2);
        }
        return builder.create();
    }

    public static void g(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            j jVar = new j();
            b.l(dialog, "Cannot display null dialog");
            dialog.setOnCancelListener((DialogInterface.OnCancelListener) null);
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            jVar.f1248a = dialog;
            if (onCancelListener != null) {
                jVar.f1249b = onCancelListener;
            }
            jVar.show(supportFragmentManager, str);
            return;
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        b bVar = new b();
        b.l(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
        bVar.f1228a = dialog;
        if (onCancelListener != null) {
            bVar.f1229b = onCancelListener;
        }
        bVar.show(fragmentManager, str);
    }

    @Nullable
    public Intent a(Context context, int i, @Nullable String str) {
        return super.a(context, i, str);
    }

    public int b(Context context, int i) {
        return super.b(context, i);
    }

    public int c(Context context) {
        return b(context, d.f1238a);
    }

    public boolean d(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog f = f(activity, i, new u(super.a(activity, i, a.g.a.b.d.f), activity, i2), onCancelListener);
        if (f == null) {
            return false;
        }
        g(activity, f, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    @TargetApi(20)
    public final void h(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        if (i == 18) {
            new a(context).sendEmptyMessageDelayed(1, 120000);
        } else if (pendingIntent != null) {
            String e2 = i == 6 ? a.d.a.a.e.m.d.e(context, "common_google_play_services_resolution_required_title") : a.d.a.a.e.m.d.d(context, i);
            if (e2 == null) {
                e2 = context.getResources().getString(a.d.a.a.d.c.common_google_play_services_notification_ticker);
            }
            String f = (i == 6 || i == 19) ? a.d.a.a.e.m.d.f(context, "common_google_play_services_resolution_required_text", a.d.a.a.e.m.d.a(context)) : a.d.a.a.e.m.d.c(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(e2).setStyle(new NotificationCompat.BigTextStyle().bigText(f));
            if (b.V(context)) {
                b.n(b.N());
                style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
                if (b.W(context)) {
                    style.addAction(a.d.a.a.d.b.common_full_open_on_phone, resources.getString(a.d.a.a.d.c.common_open_on_phone), pendingIntent);
                } else {
                    style.setContentIntent(pendingIntent);
                }
            } else {
                style.setSmallIcon(17301642).setTicker(resources.getString(a.d.a.a.d.c.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(f);
            }
            if (b.O()) {
                b.n(b.O());
                synchronized (f1230c) {
                }
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String b2 = a.d.a.a.e.m.d.b(context);
                if (notificationChannel == null) {
                    notificationChannel = new NotificationChannel("com.google.android.gms.availability", b2, 4);
                } else {
                    if (!b2.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b2);
                    }
                    style.setChannelId("com.google.android.gms.availability");
                }
                notificationManager.createNotificationChannel(notificationChannel);
                style.setChannelId("com.google.android.gms.availability");
            }
            Notification build = style.build();
            if (i == 1 || i == 2 || i == 3) {
                i2 = 10436;
                g.f1244d.set(false);
            } else {
                i2 = 39789;
            }
            notificationManager.notify(i2, build);
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    public final boolean i(Activity activity, @NonNull i iVar, int i, DialogInterface.OnCancelListener onCancelListener) {
        Dialog f = f(activity, i, new v(super.a(activity, i, a.g.a.b.d.f), iVar, 2), onCancelListener);
        if (f == null) {
            return false;
        }
        g(activity, f, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }
}
