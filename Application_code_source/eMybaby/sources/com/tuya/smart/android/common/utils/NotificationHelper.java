package com.tuya.smart.android.common.utils;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class NotificationHelper {

    public static class Builder {
        public final Params P = new Params();
        @NonNull
        public Context context;

        public class Params {
            public boolean autoCancel;
            @NonNull
            public String channelId;
            @NonNull
            public CharSequence channelName;
            @NonNull
            public String groupId;
            @NonNull
            public CharSequence groupName;
            @SuppressLint({"InlinedApi"})
            public int importance;
            @Nullable
            public Bitmap largeIcon;
            @DrawableRes
            public int largeIconRes;
            public boolean lights;
            @SuppressLint({"InlinedApi"})
            public int lockScreenVisibility;
            @Nullable
            public PendingIntent pendingIntent;
            public boolean showBadge;
            @DrawableRes
            public int smallIconRes;
            @NonNull
            public CharSequence text;
            @NonNull
            public CharSequence title;

            public Params() {
                this.groupId = "default_group";
                this.groupName = "default_group";
                this.channelId = "default_channel";
                this.channelName = "default_channel";
                this.autoCancel = false;
                this.pendingIntent = null;
                this.largeIcon = null;
                this.largeIconRes = -1;
                this.smallIconRes = -1;
                this.title = "";
                this.text = "";
                this.importance = 1;
                this.lockScreenVisibility = 0;
                this.showBadge = false;
                this.lights = false;
            }
        }

        public Builder(@NonNull Context context2) {
            this.context = context2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00fe, code lost:
            if (r2 != 4) goto L_0x0100;
         */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x010e  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0117  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x011b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.app.Notification build() {
            /*
                r6 = this;
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = -1
                r2 = 26
                if (r0 < r2) goto L_0x00b8
                android.content.Context r0 = r6.context
                android.content.Context r0 = r0.getApplicationContext()
                java.lang.String r2 = "notification"
                java.lang.Object r0 = r0.getSystemService(r2)
                android.app.NotificationManager r0 = (android.app.NotificationManager) r0
                if (r0 != 0) goto L_0x0019
                r0 = 0
                return r0
            L_0x0019:
                android.app.NotificationChannelGroup r2 = new android.app.NotificationChannelGroup
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r3 = r6.P
                java.lang.String r4 = r3.groupId
                java.lang.CharSequence r3 = r3.groupName
                r2.<init>(r4, r3)
                r0.createNotificationChannelGroup(r2)
                android.app.NotificationChannel r2 = new android.app.NotificationChannel
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r3 = r6.P
                java.lang.String r4 = r3.channelId
                java.lang.CharSequence r5 = r3.channelName
                int r3 = r3.importance
                r2.<init>(r4, r5, r3)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r3 = r6.P
                boolean r3 = r3.showBadge
                r2.setShowBadge(r3)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r3 = r6.P
                boolean r3 = r3.lights
                r2.enableLights(r3)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r3 = r6.P
                java.lang.String r3 = r3.groupId
                r2.setGroup(r3)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r3 = r6.P
                int r3 = r3.lockScreenVisibility
                r2.setLockscreenVisibility(r3)
                r0.createNotificationChannel(r2)
                android.app.Notification$Builder r0 = new android.app.Notification$Builder
                android.content.Context r2 = r6.context
                android.content.Context r2 = r2.getApplicationContext()
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r3 = r6.P
                java.lang.String r3 = r3.channelId
                r0.<init>(r2, r3)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                android.app.PendingIntent r2 = r2.pendingIntent
                android.app.Notification$Builder r0 = r0.setContentIntent(r2)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                java.lang.CharSequence r2 = r2.title
                android.app.Notification$Builder r0 = r0.setContentTitle(r2)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                java.lang.CharSequence r2 = r2.text
                android.app.Notification$Builder r0 = r0.setContentText(r2)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                boolean r2 = r2.autoCancel
                android.app.Notification$Builder r0 = r0.setAutoCancel(r2)
                long r2 = java.lang.System.currentTimeMillis()
                android.app.Notification$Builder r0 = r0.setWhen(r2)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                int r2 = r2.smallIconRes
                if (r2 == r1) goto L_0x0093
                r0.setSmallIcon(r2)
            L_0x0093:
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                android.graphics.Bitmap r3 = r2.largeIcon
                if (r3 == 0) goto L_0x009d
                r0.setLargeIcon(r3)
                goto L_0x00b2
            L_0x009d:
                int r2 = r2.largeIconRes
                if (r2 == r1) goto L_0x00b2
                android.content.Context r1 = r6.context
                android.content.res.Resources r1 = r1.getResources()
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                int r2 = r2.largeIconRes
                android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeResource(r1, r2)
                r0.setLargeIcon(r1)
            L_0x00b2:
                android.app.Notification r0 = r0.build()
                goto L_0x0134
            L_0x00b8:
                androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
                android.content.Context r2 = r6.context
                android.content.Context r2 = r2.getApplicationContext()
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r3 = r6.P
                java.lang.String r3 = r3.channelId
                r0.<init>(r2, r3)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                android.app.PendingIntent r2 = r2.pendingIntent
                androidx.core.app.NotificationCompat$Builder r0 = r0.setContentIntent(r2)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                java.lang.CharSequence r2 = r2.title
                androidx.core.app.NotificationCompat$Builder r0 = r0.setContentTitle(r2)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                java.lang.CharSequence r2 = r2.text
                androidx.core.app.NotificationCompat$Builder r0 = r0.setContentText(r2)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                boolean r2 = r2.autoCancel
                androidx.core.app.NotificationCompat$Builder r0 = r0.setAutoCancel(r2)
                long r2 = java.lang.System.currentTimeMillis()
                androidx.core.app.NotificationCompat$Builder r0 = r0.setWhen(r2)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                int r2 = r2.importance
                r3 = 1
                r4 = -2
                if (r2 == r3) goto L_0x0100
                r5 = 2
                if (r2 == r5) goto L_0x0104
                r5 = 3
                if (r2 == r5) goto L_0x0102
                r5 = 4
                if (r2 == r5) goto L_0x0105
            L_0x0100:
                r3 = -2
                goto L_0x0105
            L_0x0102:
                r3 = 0
                goto L_0x0105
            L_0x0104:
                r3 = -1
            L_0x0105:
                r0.setPriority(r3)
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                int r2 = r2.smallIconRes
                if (r2 == r1) goto L_0x0111
                r0.setSmallIcon(r2)
            L_0x0111:
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                android.graphics.Bitmap r3 = r2.largeIcon
                if (r3 == 0) goto L_0x011b
                r0.setLargeIcon(r3)
                goto L_0x0130
            L_0x011b:
                int r2 = r2.largeIconRes
                if (r2 == r1) goto L_0x0130
                android.content.Context r1 = r6.context
                android.content.res.Resources r1 = r1.getResources()
                com.tuya.smart.android.common.utils.NotificationHelper$Builder$Params r2 = r6.P
                int r2 = r2.largeIconRes
                android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeResource(r1, r2)
                r0.setLargeIcon(r1)
            L_0x0130:
                android.app.Notification r0 = r0.build()
            L_0x0134:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.android.common.utils.NotificationHelper.Builder.build():android.app.Notification");
        }

        public Builder setAutoCancel(boolean z) {
            this.P.autoCancel = z;
            return this;
        }

        public Builder setChannelId(@NonNull String str) {
            this.P.channelId = str;
            return this;
        }

        public Builder setChannelName(@NonNull String str) {
            this.P.channelName = str;
            return this;
        }

        public Builder setGroupId(@NonNull String str) {
            this.P.groupId = str;
            return this;
        }

        public Builder setGroupName(@NonNull String str) {
            this.P.groupName = str;
            return this;
        }

        public Builder setImportance(int i) {
            this.P.importance = i;
            return this;
        }

        public Builder setLargeIcon(@Nullable Bitmap bitmap) {
            this.P.largeIcon = bitmap;
            return this;
        }

        public Builder setLargeIconRes(@DrawableRes int i) {
            this.P.largeIconRes = i;
            return this;
        }

        public Builder setLights(boolean z) {
            this.P.lights = z;
            return this;
        }

        public Builder setLockScreenVisibility(int i) {
            this.P.lockScreenVisibility = i;
            return this;
        }

        public Builder setPendingIntent(@Nullable PendingIntent pendingIntent) {
            this.P.pendingIntent = pendingIntent;
            return this;
        }

        public Builder setShowBadge(boolean z) {
            this.P.showBadge = z;
            return this;
        }

        public Builder setSmallIconRes(@DrawableRes int i) {
            this.P.smallIconRes = i;
            return this;
        }

        public Builder setText(@NonNull CharSequence charSequence) {
            this.P.text = charSequence;
            return this;
        }

        public Builder setTitle(@NonNull CharSequence charSequence) {
            this.P.title = charSequence;
            return this;
        }
    }

    @RequiresApi(api = 26)
    public static void gotoNotificationChannelSettings(@NonNull Context context, String str) {
        Intent intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.CHANNEL_ID", str);
        intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        context.startActivity(intent);
    }
}
