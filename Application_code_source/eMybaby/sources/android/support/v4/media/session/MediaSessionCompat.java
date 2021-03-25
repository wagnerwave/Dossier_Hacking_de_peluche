package android.support.v4.media.session;

import a.a.a.a.a;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_PLAYBACK_SPEED = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_PLAYBACK_SPEED = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    public static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    public static final String DATA_CALLING_PID = "data_calling_pid";
    public static final String DATA_CALLING_UID = "data_calling_uid";
    public static final String DATA_EXTRAS = "data_extras";
    @Deprecated
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    @Deprecated
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SESSION2_TOKEN = "android.support.v4.media.session.SESSION_TOKEN2";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    public static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    public static final String TAG = "MediaSessionCompat";
    public static int sMaxBitmapSize;
    public final ArrayList<OnActiveChangeListener> mActiveListeners;
    public final MediaControllerCompat mController;
    public final MediaSessionImpl mImpl;

    public static abstract class Callback {
        public final MediaSession.Callback mCallbackFwk;
        @GuardedBy("mLock")
        public CallbackHandler mCallbackHandler;
        public final Object mLock = new Object();
        public boolean mMediaPlayPausePendingOnHandler;
        @GuardedBy("mLock")
        public WeakReference<MediaSessionImpl> mSessionImpl;

        public class CallbackHandler extends Handler {
            public static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;

            public CallbackHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                MediaSessionImpl mediaSessionImpl;
                CallbackHandler callbackHandler;
                if (message.what == 1) {
                    synchronized (Callback.this.mLock) {
                        mediaSessionImpl = (MediaSessionImpl) Callback.this.mSessionImpl.get();
                        callbackHandler = Callback.this.mCallbackHandler;
                    }
                    if (mediaSessionImpl != null && Callback.this == mediaSessionImpl.getCallback() && callbackHandler != null) {
                        mediaSessionImpl.setCurrentControllerInfo((MediaSessionManager.RemoteUserInfo) message.obj);
                        Callback.this.handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
                        mediaSessionImpl.setCurrentControllerInfo((MediaSessionManager.RemoteUserInfo) null);
                    }
                }
            }
        }

        @RequiresApi(21)
        public class MediaSessionCallbackApi21 extends MediaSession.Callback {
            public MediaSessionCallbackApi21() {
            }

            private void clearCurrentControllerInfo(MediaSessionImpl mediaSessionImpl) {
                mediaSessionImpl.setCurrentControllerInfo((MediaSessionManager.RemoteUserInfo) null);
            }

            private MediaSessionImplApi21 getSessionImplIfCallbackIsSet() {
                MediaSessionImplApi21 mediaSessionImplApi21;
                synchronized (Callback.this.mLock) {
                    mediaSessionImplApi21 = (MediaSessionImplApi21) Callback.this.mSessionImpl.get();
                }
                if (Callback.this == mediaSessionImplApi21.getCallback()) {
                    return mediaSessionImplApi21;
                }
                return null;
            }

            private void setCurrentControllerInfo(MediaSessionImpl mediaSessionImpl) {
                if (Build.VERSION.SDK_INT < 28) {
                    String callingPackage = mediaSessionImpl.getCallingPackage();
                    if (TextUtils.isEmpty(callingPackage)) {
                        callingPackage = MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER;
                    }
                    mediaSessionImpl.setCurrentControllerInfo(new MediaSessionManager.RemoteUserInfo(callingPackage, -1, -1));
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.support.v4.media.session.MediaSessionCompat$QueueItem} */
            /* JADX WARNING: type inference failed for: r2v0 */
            /* JADX WARNING: type inference failed for: r2v4, types: [android.os.IBinder] */
            /* JADX WARNING: type inference failed for: r2v6 */
            /* JADX WARNING: type inference failed for: r2v7 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCommand(java.lang.String r6, android.os.Bundle r7, android.os.ResultReceiver r8) {
                /*
                    r5 = this;
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21 r0 = r5.getSessionImplIfCallbackIsSet()
                    if (r0 != 0) goto L_0x0007
                    return
                L_0x0007:
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r7)
                    r5.setCurrentControllerInfo(r0)
                    java.lang.String r1 = "android.support.v4.media.session.command.GET_EXTRA_BINDER"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b5 }
                    r2 = 0
                    if (r1 == 0) goto L_0x003e
                    android.os.Bundle r6 = new android.os.Bundle     // Catch:{ BadParcelableException -> 0x00b5 }
                    r6.<init>()     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.session.MediaSessionCompat$Token r7 = r0.getSessionToken()     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.session.IMediaSession r1 = r7.getExtraBinder()     // Catch:{ BadParcelableException -> 0x00b5 }
                    java.lang.String r3 = "android.support.v4.media.session.EXTRA_BINDER"
                    if (r1 != 0) goto L_0x0028
                    goto L_0x002c
                L_0x0028:
                    android.os.IBinder r2 = r1.asBinder()     // Catch:{ BadParcelableException -> 0x00b5 }
                L_0x002c:
                    androidx.core.app.BundleCompat.putBinder(r6, r3, r2)     // Catch:{ BadParcelableException -> 0x00b5 }
                    java.lang.String r1 = "android.support.v4.media.session.SESSION_TOKEN2"
                    androidx.versionedparcelable.VersionedParcelable r7 = r7.getSession2Token()     // Catch:{ BadParcelableException -> 0x00b5 }
                    androidx.versionedparcelable.ParcelUtils.putVersionedParcelable(r6, r1, r7)     // Catch:{ BadParcelableException -> 0x00b5 }
                    r7 = 0
                    r8.send(r7, r6)     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x00bc
                L_0x003e:
                    java.lang.String r1 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b5 }
                    java.lang.String r3 = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"
                    if (r1 == 0) goto L_0x0054
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.os.Parcelable r7 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.MediaDescriptionCompat r7 = (android.support.v4.media.MediaDescriptionCompat) r7     // Catch:{ BadParcelableException -> 0x00b5 }
                    r6.onAddQueueItem(r7)     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x00bc
                L_0x0054:
                    java.lang.String r1 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b5 }
                    java.lang.String r4 = "android.support.v4.media.session.command.ARGUMENT_INDEX"
                    if (r1 == 0) goto L_0x006e
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.os.Parcelable r8 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.MediaDescriptionCompat r8 = (android.support.v4.media.MediaDescriptionCompat) r8     // Catch:{ BadParcelableException -> 0x00b5 }
                    int r7 = r7.getInt(r4)     // Catch:{ BadParcelableException -> 0x00b5 }
                    r6.onAddQueueItem(r8, r7)     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x00bc
                L_0x006e:
                    java.lang.String r1 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b5 }
                    if (r1 == 0) goto L_0x0082
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.os.Parcelable r7 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.MediaDescriptionCompat r7 = (android.support.v4.media.MediaDescriptionCompat) r7     // Catch:{ BadParcelableException -> 0x00b5 }
                L_0x007e:
                    r6.onRemoveQueueItem(r7)     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x00bc
                L_0x0082:
                    java.lang.String r1 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b5 }
                    if (r1 == 0) goto L_0x00af
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r6 = r0.mQueue     // Catch:{ BadParcelableException -> 0x00b5 }
                    if (r6 == 0) goto L_0x00bc
                    r6 = -1
                    int r6 = r7.getInt(r4, r6)     // Catch:{ BadParcelableException -> 0x00b5 }
                    if (r6 < 0) goto L_0x00a6
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r7 = r0.mQueue     // Catch:{ BadParcelableException -> 0x00b5 }
                    int r7 = r7.size()     // Catch:{ BadParcelableException -> 0x00b5 }
                    if (r6 >= r7) goto L_0x00a6
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r7 = r0.mQueue     // Catch:{ BadParcelableException -> 0x00b5 }
                    java.lang.Object r6 = r7.get(r6)     // Catch:{ BadParcelableException -> 0x00b5 }
                    r2 = r6
                    android.support.v4.media.session.MediaSessionCompat$QueueItem r2 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r2     // Catch:{ BadParcelableException -> 0x00b5 }
                L_0x00a6:
                    if (r2 == 0) goto L_0x00bc
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.MediaDescriptionCompat r7 = r2.getDescription()     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x007e
                L_0x00af:
                    android.support.v4.media.session.MediaSessionCompat$Callback r1 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b5 }
                    r1.onCommand(r6, r7, r8)     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x00bc
                L_0x00b5:
                    java.lang.String r6 = "MediaSessionCompat"
                    java.lang.String r7 = "Could not unparcel the extra data."
                    android.util.Log.e(r6, r7)
                L_0x00bc:
                    r5.clearCurrentControllerInfo(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.Callback.MediaSessionCallbackApi21.onCommand(java.lang.String, android.os.Bundle, android.os.ResultReceiver):void");
            }

            public void onCustomAction(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    try {
                        if (str.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                            Bundle bundle2 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                            MediaSessionCompat.ensureClassLoader(bundle2);
                            Callback.this.onPlayFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                        } else if (str.equals(MediaSessionCompat.ACTION_PREPARE)) {
                            Callback.this.onPrepare();
                        } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                            String string = bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID);
                            Bundle bundle3 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                            MediaSessionCompat.ensureClassLoader(bundle3);
                            Callback.this.onPrepareFromMediaId(string, bundle3);
                        } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                            String string2 = bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY);
                            Bundle bundle4 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                            MediaSessionCompat.ensureClassLoader(bundle4);
                            Callback.this.onPrepareFromSearch(string2, bundle4);
                        } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                            Bundle bundle5 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                            MediaSessionCompat.ensureClassLoader(bundle5);
                            Callback.this.onPrepareFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle5);
                        } else if (str.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                            Callback.this.onSetCaptioningEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                        } else if (str.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                            Callback.this.onSetRepeatMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                        } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                            Callback.this.onSetShuffleMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                        } else if (str.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                            Bundle bundle6 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                            MediaSessionCompat.ensureClassLoader(bundle6);
                            Callback.this.onSetRating((RatingCompat) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle6);
                        } else if (str.equals(MediaSessionCompat.ACTION_SET_PLAYBACK_SPEED)) {
                            Callback.this.onSetPlaybackSpeed(bundle.getFloat(MediaSessionCompat.ACTION_ARGUMENT_PLAYBACK_SPEED, 1.0f));
                        } else {
                            Callback.this.onCustomAction(str, bundle);
                        }
                    } catch (BadParcelableException unused) {
                        Log.e(MediaSessionCompat.TAG, "Could not unparcel the data.");
                    }
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onFastForward() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onFastForward();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public boolean onMediaButtonEvent(Intent intent) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet == null) {
                    return false;
                }
                setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                boolean onMediaButtonEvent = Callback.this.onMediaButtonEvent(intent);
                clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                return onMediaButtonEvent || super.onMediaButtonEvent(intent);
            }

            public void onPause() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPause();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onPlay() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPlay();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPlayFromMediaId(str, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPlayFromSearch(str, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            @RequiresApi(23)
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPlayFromUri(uri, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            @RequiresApi(24)
            public void onPrepare() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPrepare();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            @RequiresApi(24)
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPrepareFromMediaId(str, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            @RequiresApi(24)
            public void onPrepareFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPrepareFromSearch(str, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            @RequiresApi(24)
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onPrepareFromUri(uri, bundle);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onRewind() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onRewind();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onSeekTo(long j) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSeekTo(j);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            @RequiresApi(29)
            public void onSetPlaybackSpeed(float f) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSetPlaybackSpeed(f);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onSetRating(Rating rating) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSetRating(RatingCompat.fromRating(rating));
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onSetRating(Rating rating, Bundle bundle) {
            }

            public void onSkipToNext() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSkipToNext();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onSkipToPrevious() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSkipToPrevious();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onSkipToQueueItem(long j) {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onSkipToQueueItem(j);
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }

            public void onStop() {
                MediaSessionImplApi21 sessionImplIfCallbackIsSet = getSessionImplIfCallbackIsSet();
                if (sessionImplIfCallbackIsSet != null) {
                    setCurrentControllerInfo(sessionImplIfCallbackIsSet);
                    Callback.this.onStop();
                    clearCurrentControllerInfo(sessionImplIfCallbackIsSet);
                }
            }
        }

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackFwk = new MediaSessionCallbackApi21();
            } else {
                this.mCallbackFwk = null;
            }
            this.mSessionImpl = new WeakReference<>((Object) null);
        }

        public void handleMediaPlayPauseIfPendingOnHandler(MediaSessionImpl mediaSessionImpl, Handler handler) {
            if (this.mMediaPlayPausePendingOnHandler) {
                boolean z = false;
                this.mMediaPlayPausePendingOnHandler = false;
                handler.removeMessages(1);
                PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                long actions = playbackState == null ? 0 : playbackState.getActions();
                boolean z2 = playbackState != null && playbackState.getState() == 3;
                boolean z3 = (516 & actions) != 0;
                if ((actions & 514) != 0) {
                    z = true;
                }
                if (z2 && z) {
                    onPause();
                } else if (!z2 && z3) {
                    onPlay();
                }
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            MediaSessionImpl mediaSessionImpl;
            CallbackHandler callbackHandler;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.mLock) {
                mediaSessionImpl = (MediaSessionImpl) this.mSessionImpl.get();
                callbackHandler = this.mCallbackHandler;
            }
            if (mediaSessionImpl == null || callbackHandler == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            MediaSessionManager.RemoteUserInfo currentControllerInfo = mediaSessionImpl.getCurrentControllerInfo();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 79 || keyCode == 85) {
                if (keyEvent.getRepeatCount() != 0) {
                    handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
                } else if (this.mMediaPlayPausePendingOnHandler) {
                    callbackHandler.removeMessages(1);
                    this.mMediaPlayPausePendingOnHandler = false;
                    PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                    if (((playbackState == null ? 0 : playbackState.getActions()) & 32) != 0) {
                        onSkipToNext();
                    }
                } else {
                    this.mMediaPlayPausePendingOnHandler = true;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, currentControllerInfo), (long) ViewConfiguration.getDoubleTapTimeout());
                }
                return true;
            }
            handleMediaPlayPauseIfPendingOnHandler(mediaSessionImpl, callbackHandler);
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetCaptioningEnabled(boolean z) {
        }

        public void onSetPlaybackSpeed(float f) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void onSetRepeatMode(int i) {
        }

        public void onSetShuffleMode(int i) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onStop() {
        }

        public void setSessionImpl(MediaSessionImpl mediaSessionImpl, Handler handler) {
            synchronized (this.mLock) {
                this.mSessionImpl = new WeakReference<>(mediaSessionImpl);
                CallbackHandler callbackHandler = null;
                if (this.mCallbackHandler != null) {
                    this.mCallbackHandler.removeCallbacksAndMessages((Object) null);
                }
                if (mediaSessionImpl != null) {
                    if (handler != null) {
                        callbackHandler = new CallbackHandler(handler.getLooper());
                    }
                }
                this.mCallbackHandler = callbackHandler;
            }
        }
    }

    public interface MediaSessionImpl {
        Callback getCallback();

        String getCallingPackage();

        MediaSessionManager.RemoteUserInfo getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z);

        void setCallback(Callback callback, Handler handler);

        void setCaptioningEnabled(boolean z);

        void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setRepeatMode(int i);

        void setSessionActivity(PendingIntent pendingIntent);

        void setShuffleMode(int i);
    }

    @RequiresApi(18)
    public static class MediaSessionImplApi18 extends MediaSessionImplBase {
        public static boolean sIsMbrPendingIntentSupported = true;

        public MediaSessionImplApi18(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, componentName, pendingIntent, versionedParcelable, bundle);
        }

        public int getRccTransportControlFlagsFromActions(long j) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
            return (j & 256) != 0 ? rccTransportControlFlagsFromActions | 256 : rccTransportControlFlagsFromActions;
        }

        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                try {
                    this.mAudioManager.registerMediaButtonEventReceiver(pendingIntent);
                } catch (NullPointerException unused) {
                    Log.w(MediaSessionCompat.TAG, "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    sIsMbrPendingIntentSupported = false;
                }
            }
            if (!sIsMbrPendingIntentSupported) {
                super.registerMediaButtonEventReceiver(pendingIntent, componentName);
            }
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener) null);
                return;
            }
            this.mRcc.setPlaybackPositionUpdateListener(new RemoteControlClient.OnPlaybackPositionUpdateListener() {
                public void onPlaybackPositionUpdate(long j) {
                    MediaSessionImplApi18.this.postToHandler(18, -1, -1, Long.valueOf(j), (Bundle) null);
                }
            });
        }

        public void setRccState(PlaybackStateCompat playbackStateCompat) {
            long position = playbackStateCompat.getPosition();
            float playbackSpeed = playbackStateCompat.getPlaybackSpeed();
            long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.getState() == 3) {
                long j = 0;
                if (position > 0) {
                    if (lastPositionUpdateTime > 0) {
                        j = elapsedRealtime - lastPositionUpdateTime;
                        if (playbackSpeed > 0.0f && playbackSpeed != 1.0f) {
                            j = (long) (((float) j) * playbackSpeed);
                        }
                    }
                    position += j;
                }
            }
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()), position, playbackSpeed);
        }

        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
            }
        }
    }

    @RequiresApi(19)
    public static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        public MediaSessionImplApi19(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, componentName, pendingIntent, versionedParcelable, bundle);
        }

        public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle) {
            RemoteControlClient.MetadataEditor buildRccMetadata = super.buildRccMetadata(bundle);
            PlaybackStateCompat playbackStateCompat = this.mState;
            if (((playbackStateCompat == null ? 0 : playbackStateCompat.getActions()) & 128) != 0) {
                buildRccMetadata.addEditableKey(268435457);
            }
            if (bundle == null) {
                return buildRccMetadata;
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR)) {
                buildRccMetadata.putLong(8, bundle.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_RATING)) {
                buildRccMetadata.putObject(101, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING)) {
                buildRccMetadata.putObject(268435457, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
            }
            return buildRccMetadata;
        }

        public int getRccTransportControlFlagsFromActions(long j) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
            return (j & 128) != 0 ? rccTransportControlFlagsFromActions | 512 : rccTransportControlFlagsFromActions;
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener) null);
                return;
            }
            this.mRcc.setMetadataUpdateListener(new RemoteControlClient.OnMetadataUpdateListener() {
                public void onMetadataUpdate(int i, Object obj) {
                    if (i == 268435457 && (obj instanceof Rating)) {
                        MediaSessionImplApi19.this.postToHandler(19, -1, -1, RatingCompat.fromRating(obj), (Bundle) null);
                    }
                }
            });
        }
    }

    @RequiresApi(21)
    public static class MediaSessionImplApi21 implements MediaSessionImpl {
        @GuardedBy("mLock")
        public Callback mCallback;
        public boolean mCaptioningEnabled;
        public boolean mDestroyed = false;
        public final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks = new RemoteCallbackList<>();
        public final Object mLock = new Object();
        public MediaMetadataCompat mMetadata;
        public PlaybackStateCompat mPlaybackState;
        public List<QueueItem> mQueue;
        public int mRatingType;
        @GuardedBy("mLock")
        public MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        public int mRepeatMode;
        public final MediaSession mSessionFwk;
        public Bundle mSessionInfo;
        public int mShuffleMode;
        public final Token mToken;

        public class ExtraSession extends IMediaSession.Stub {
            public ExtraSession() {
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                throw new AssertionError();
            }

            public void adjustVolume(int i, int i2, String str) {
                throw new AssertionError();
            }

            public void fastForward() {
                throw new AssertionError();
            }

            public Bundle getExtras() {
                throw new AssertionError();
            }

            public long getFlags() {
                throw new AssertionError();
            }

            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            public String getPackageName() {
                throw new AssertionError();
            }

            public PlaybackStateCompat getPlaybackState() {
                MediaSessionImplApi21 mediaSessionImplApi21 = MediaSessionImplApi21.this;
                return MediaSessionCompat.getStateWithUpdatedPosition(mediaSessionImplApi21.mPlaybackState, mediaSessionImplApi21.mMetadata);
            }

            public List<QueueItem> getQueue() {
                return null;
            }

            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            public int getRatingType() {
                return MediaSessionImplApi21.this.mRatingType;
            }

            public int getRepeatMode() {
                return MediaSessionImplApi21.this.mRepeatMode;
            }

            public Bundle getSessionInfo() {
                if (MediaSessionImplApi21.this.mSessionInfo == null) {
                    return null;
                }
                return new Bundle(MediaSessionImplApi21.this.mSessionInfo);
            }

            public int getShuffleMode() {
                return MediaSessionImplApi21.this.mShuffleMode;
            }

            public String getTag() {
                throw new AssertionError();
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            public boolean isCaptioningEnabled() {
                return MediaSessionImplApi21.this.mCaptioningEnabled;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            public void next() {
                throw new AssertionError();
            }

            public void pause() {
                throw new AssertionError();
            }

            public void play() {
                throw new AssertionError();
            }

            public void playFromMediaId(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void playFromSearch(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void playFromUri(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepare() {
                throw new AssertionError();
            }

            public void prepareFromMediaId(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepareFromSearch(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepareFromUri(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public void previous() {
                throw new AssertionError();
            }

            public void rate(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (!MediaSessionImplApi21.this.mDestroyed) {
                    MediaSessionImplApi21.this.mExtraControllerCallbacks.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void removeQueueItemAt(int i) {
                throw new AssertionError();
            }

            public void rewind() {
                throw new AssertionError();
            }

            public void seekTo(long j) {
                throw new AssertionError();
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            public void sendCustomAction(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            public void setCaptioningEnabled(boolean z) {
                throw new AssertionError();
            }

            public void setPlaybackSpeed(float f) {
                throw new AssertionError();
            }

            public void setRepeatMode(int i) {
                throw new AssertionError();
            }

            public void setShuffleMode(int i) {
                throw new AssertionError();
            }

            public void setShuffleModeEnabledRemoved(boolean z) {
            }

            public void setVolumeTo(int i, int i2, String str) {
                throw new AssertionError();
            }

            public void skipToQueueItem(long j) {
                throw new AssertionError();
            }

            public void stop() {
                throw new AssertionError();
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21.this.mExtraControllerCallbacks.unregister(iMediaControllerCallback);
            }
        }

        public MediaSessionImplApi21(MediaSession mediaSession, VersionedParcelable versionedParcelable, Bundle bundle) {
            this.mSessionFwk = mediaSession;
            this.mToken = new Token(this.mSessionFwk.getSessionToken(), new ExtraSession(), versionedParcelable);
            this.mSessionInfo = bundle;
            setFlags(3);
        }

        public MediaSessionImplApi21(Object obj) {
            if (obj instanceof MediaSession) {
                this.mSessionFwk = (MediaSession) obj;
                this.mToken = new Token(this.mSessionFwk.getSessionToken(), new ExtraSession());
                this.mSessionInfo = null;
                setFlags(3);
                return;
            }
            throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        }

        public Callback getCallback() {
            Callback callback;
            synchronized (this.mLock) {
                callback = this.mCallback;
            }
            return callback;
        }

        public String getCallingPackage() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                return (String) this.mSessionFwk.getClass().getMethod("getCallingPackage", new Class[0]).invoke(this.mSessionFwk, new Object[0]);
            } catch (Exception e2) {
                Log.e(MediaSessionCompat.TAG, "Cannot execute MediaSession.getCallingPackage()", e2);
                return null;
            }
        }

        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            synchronized (this.mLock) {
                remoteUserInfo = this.mRemoteUserInfo;
            }
            return remoteUserInfo;
        }

        public Object getMediaSession() {
            return this.mSessionFwk;
        }

        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return this.mSessionFwk.isActive();
        }

        public void release() {
            this.mDestroyed = true;
            this.mExtraControllerCallbacks.kill();
            this.mSessionFwk.setCallback((MediaSession.Callback) null);
            this.mSessionFwk.release();
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 23) {
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
            this.mSessionFwk.sendSessionEvent(str, bundle);
        }

        public void setActive(boolean z) {
            this.mSessionFwk.setActive(z);
        }

        public void setCallback(Callback callback, Handler handler) {
            synchronized (this.mLock) {
                this.mCallback = callback;
                this.mSessionFwk.setCallback(callback == null ? null : callback.mCallbackFwk, handler);
                if (callback != null) {
                    callback.setSessionImpl(this, handler);
                }
            }
        }

        public void setCaptioningEnabled(boolean z) {
            if (this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = remoteUserInfo;
            }
        }

        public void setExtras(Bundle bundle) {
            this.mSessionFwk.setExtras(bundle);
        }

        @SuppressLint({"WrongConstant"})
        public void setFlags(int i) {
            this.mSessionFwk.setFlags(i | 1 | 2);
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            this.mSessionFwk.setMediaButtonReceiver(pendingIntent);
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            this.mMetadata = mediaMetadataCompat;
            this.mSessionFwk.setMetadata(mediaMetadataCompat == null ? null : (MediaMetadata) mediaMetadataCompat.getMediaMetadata());
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            this.mPlaybackState = playbackStateCompat;
            for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.mExtraControllerCallbacks.finishBroadcast();
            this.mSessionFwk.setPlaybackState(playbackStateCompat == null ? null : (PlaybackState) playbackStateCompat.getPlaybackState());
        }

        public void setPlaybackToLocal(int i) {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setLegacyStreamType(i);
            this.mSessionFwk.setPlaybackToLocal(builder.build());
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            this.mSessionFwk.setPlaybackToRemote((VolumeProvider) volumeProviderCompat.getVolumeProvider());
        }

        public void setQueue(List<QueueItem> list) {
            ArrayList arrayList;
            MediaSession mediaSession;
            this.mQueue = list;
            if (list == null) {
                mediaSession = this.mSessionFwk;
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (QueueItem queueItem : list) {
                    arrayList.add((MediaSession.QueueItem) queueItem.getQueueItem());
                }
                mediaSession = this.mSessionFwk;
            }
            mediaSession.setQueue(arrayList);
        }

        public void setQueueTitle(CharSequence charSequence) {
            this.mSessionFwk.setQueueTitle(charSequence);
        }

        public void setRatingType(int i) {
            if (Build.VERSION.SDK_INT < 22) {
                this.mRatingType = i;
            } else {
                this.mSessionFwk.setRatingType(i);
            }
        }

        public void setRepeatMode(int i) {
            if (this.mRepeatMode != i) {
                this.mRepeatMode = i;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            this.mSessionFwk.setSessionActivity(pendingIntent);
        }

        public void setShuffleMode(int i) {
            if (this.mShuffleMode != i) {
                this.mShuffleMode = i;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i);
                    } catch (RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }
    }

    @RequiresApi(28)
    public static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        public MediaSessionImplApi28(MediaSession mediaSession, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(mediaSession, versionedParcelable, bundle);
        }

        public MediaSessionImplApi28(Object obj) {
            super(obj);
        }

        @NonNull
        public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            return new MediaSessionManager.RemoteUserInfo(this.mSessionFwk.getCurrentControllerInfo());
        }

        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }
    }

    @RequiresApi(29)
    public static class MediaSessionImplApi29 extends MediaSessionImplApi28 {
        public MediaSessionImplApi29(MediaSession mediaSession, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(mediaSession, versionedParcelable, bundle);
        }

        public MediaSessionImplApi29(Object obj) {
            super(obj);
            this.mSessionInfo = ((MediaSession) obj).getController().getSessionInfo();
        }
    }

    public static class MediaSessionImplBase implements MediaSessionImpl {
        public static final int RCC_PLAYSTATE_NONE = 0;
        public final AudioManager mAudioManager;
        public volatile Callback mCallback;
        public boolean mCaptioningEnabled;
        public final Context mContext;
        public final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks = new RemoteCallbackList<>();
        public boolean mDestroyed = false;
        public Bundle mExtras;
        public int mFlags = 3;
        public MessageHandler mHandler;
        public boolean mIsActive = false;
        public int mLocalStream;
        public final Object mLock = new Object();
        public final ComponentName mMediaButtonReceiverComponentName;
        public final PendingIntent mMediaButtonReceiverIntent;
        public MediaMetadataCompat mMetadata;
        public final String mPackageName;
        public List<QueueItem> mQueue;
        public CharSequence mQueueTitle;
        public int mRatingType;
        public final RemoteControlClient mRcc;
        public MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        public int mRepeatMode;
        public PendingIntent mSessionActivity;
        public final Bundle mSessionInfo;
        public int mShuffleMode;
        public PlaybackStateCompat mState;
        public final MediaSessionStub mStub;
        public final String mTag;
        public final Token mToken;
        public VolumeProviderCompat.Callback mVolumeCallback = new VolumeProviderCompat.Callback() {
            public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
                if (MediaSessionImplBase.this.mVolumeProvider == volumeProviderCompat) {
                    MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                    MediaSessionImplBase.this.sendVolumeInfoChanged(new ParcelableVolumeInfo(mediaSessionImplBase.mVolumeType, mediaSessionImplBase.mLocalStream, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
                }
            }
        };
        public VolumeProviderCompat mVolumeProvider;
        public int mVolumeType;

        public static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.command = str;
                this.extras = bundle;
                this.stub = resultReceiver;
            }
        }

        public class MediaSessionStub extends IMediaSession.Stub {
            public MediaSessionStub() {
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(25, (Object) mediaDescriptionCompat);
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                postToHandler(26, (Object) mediaDescriptionCompat, i);
            }

            public void adjustVolume(int i, int i2, String str) {
                MediaSessionImplBase.this.adjustVolume(i, i2);
            }

            public void fastForward() {
                postToHandler(16);
            }

            public Bundle getExtras() {
                Bundle bundle;
                synchronized (MediaSessionImplBase.this.mLock) {
                    bundle = MediaSessionImplBase.this.mExtras;
                }
                return bundle;
            }

            public long getFlags() {
                long j;
                synchronized (MediaSessionImplBase.this.mLock) {
                    j = (long) MediaSessionImplBase.this.mFlags;
                }
                return j;
            }

            public PendingIntent getLaunchPendingIntent() {
                PendingIntent pendingIntent;
                synchronized (MediaSessionImplBase.this.mLock) {
                    pendingIntent = MediaSessionImplBase.this.mSessionActivity;
                }
                return pendingIntent;
            }

            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.mMetadata;
            }

            public String getPackageName() {
                return MediaSessionImplBase.this.mPackageName;
            }

            public PlaybackStateCompat getPlaybackState() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (MediaSessionImplBase.this.mLock) {
                    playbackStateCompat = MediaSessionImplBase.this.mState;
                    mediaMetadataCompat = MediaSessionImplBase.this.mMetadata;
                }
                return MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat);
            }

            public List<QueueItem> getQueue() {
                List<QueueItem> list;
                synchronized (MediaSessionImplBase.this.mLock) {
                    list = MediaSessionImplBase.this.mQueue;
                }
                return list;
            }

            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.mQueueTitle;
            }

            public int getRatingType() {
                return MediaSessionImplBase.this.mRatingType;
            }

            public int getRepeatMode() {
                return MediaSessionImplBase.this.mRepeatMode;
            }

            public Bundle getSessionInfo() {
                if (MediaSessionImplBase.this.mSessionInfo == null) {
                    return null;
                }
                return new Bundle(MediaSessionImplBase.this.mSessionInfo);
            }

            public int getShuffleMode() {
                return MediaSessionImplBase.this.mShuffleMode;
            }

            public String getTag() {
                return MediaSessionImplBase.this.mTag;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                synchronized (MediaSessionImplBase.this.mLock) {
                    i = MediaSessionImplBase.this.mVolumeType;
                    i2 = MediaSessionImplBase.this.mLocalStream;
                    VolumeProviderCompat volumeProviderCompat = MediaSessionImplBase.this.mVolumeProvider;
                    if (i == 2) {
                        int volumeControl = volumeProviderCompat.getVolumeControl();
                        int maxVolume = volumeProviderCompat.getMaxVolume();
                        i3 = volumeProviderCompat.getCurrentVolume();
                        i4 = maxVolume;
                        i5 = volumeControl;
                    } else {
                        i4 = MediaSessionImplBase.this.mAudioManager.getStreamMaxVolume(i2);
                        i3 = MediaSessionImplBase.this.mAudioManager.getStreamVolume(i2);
                        i5 = 2;
                    }
                }
                return new ParcelableVolumeInfo(i, i2, i5, i4, i3);
            }

            public boolean isCaptioningEnabled() {
                return MediaSessionImplBase.this.mCaptioningEnabled;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                return true;
            }

            public void next() {
                postToHandler(14);
            }

            public void pause() {
                postToHandler(12);
            }

            public void play() {
                postToHandler(7);
            }

            public void playFromMediaId(String str, Bundle bundle) {
                postToHandler(8, (Object) str, bundle);
            }

            public void playFromSearch(String str, Bundle bundle) {
                postToHandler(9, (Object) str, bundle);
            }

            public void playFromUri(Uri uri, Bundle bundle) {
                postToHandler(10, (Object) uri, bundle);
            }

            public void postToHandler(int i) {
                MediaSessionImplBase.this.postToHandler(i, 0, 0, (Object) null, (Bundle) null);
            }

            public void postToHandler(int i, int i2) {
                MediaSessionImplBase.this.postToHandler(i, i2, 0, (Object) null, (Bundle) null);
            }

            public void postToHandler(int i, Object obj) {
                MediaSessionImplBase.this.postToHandler(i, 0, 0, obj, (Bundle) null);
            }

            public void postToHandler(int i, Object obj, int i2) {
                MediaSessionImplBase.this.postToHandler(i, i2, 0, obj, (Bundle) null);
            }

            public void postToHandler(int i, Object obj, Bundle bundle) {
                MediaSessionImplBase.this.postToHandler(i, 0, 0, obj, bundle);
            }

            public void prepare() {
                postToHandler(3);
            }

            public void prepareFromMediaId(String str, Bundle bundle) {
                postToHandler(4, (Object) str, bundle);
            }

            public void prepareFromSearch(String str, Bundle bundle) {
                postToHandler(5, (Object) str, bundle);
            }

            public void prepareFromUri(Uri uri, Bundle bundle) {
                postToHandler(6, (Object) uri, bundle);
            }

            public void previous() {
                postToHandler(15);
            }

            public void rate(RatingCompat ratingCompat) {
                postToHandler(19, (Object) ratingCompat);
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
                postToHandler(31, (Object) ratingCompat, bundle);
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (MediaSessionImplBase.this.mDestroyed) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                    } catch (Exception unused) {
                    }
                } else {
                    MediaSessionImplBase.this.mControllerCallbacks.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(MediaSessionImplBase.this.getPackageNameForUid(Binder.getCallingUid()), Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(27, (Object) mediaDescriptionCompat);
            }

            public void removeQueueItemAt(int i) {
                postToHandler(28, i);
            }

            public void rewind() {
                postToHandler(17);
            }

            public void seekTo(long j) {
                postToHandler(18, (Object) Long.valueOf(j));
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                postToHandler(1, (Object) new Command(str, bundle, resultReceiverWrapper == null ? null : resultReceiverWrapper.mResultReceiver));
            }

            public void sendCustomAction(String str, Bundle bundle) {
                postToHandler(20, (Object) str, bundle);
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                postToHandler(21, (Object) keyEvent);
                return true;
            }

            public void setCaptioningEnabled(boolean z) {
                postToHandler(29, (Object) Boolean.valueOf(z));
            }

            public void setPlaybackSpeed(float f) {
                postToHandler(32, (Object) Float.valueOf(f));
            }

            public void setRepeatMode(int i) {
                postToHandler(23, i);
            }

            public void setShuffleMode(int i) {
                postToHandler(30, i);
            }

            public void setShuffleModeEnabledRemoved(boolean z) {
            }

            public void setVolumeTo(int i, int i2, String str) {
                MediaSessionImplBase.this.setVolumeTo(i, i2);
            }

            public void skipToQueueItem(long j) {
                postToHandler(11, (Object) Long.valueOf(j));
            }

            public void stop() {
                postToHandler(13);
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase.this.mControllerCallbacks.unregister(iMediaControllerCallback);
            }
        }

        public class MessageHandler extends Handler {
            public static final int KEYCODE_MEDIA_PAUSE = 127;
            public static final int KEYCODE_MEDIA_PLAY = 126;
            public static final int MSG_ADD_QUEUE_ITEM = 25;
            public static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            public static final int MSG_ADJUST_VOLUME = 2;
            public static final int MSG_COMMAND = 1;
            public static final int MSG_CUSTOM_ACTION = 20;
            public static final int MSG_FAST_FORWARD = 16;
            public static final int MSG_MEDIA_BUTTON = 21;
            public static final int MSG_NEXT = 14;
            public static final int MSG_PAUSE = 12;
            public static final int MSG_PLAY = 7;
            public static final int MSG_PLAY_MEDIA_ID = 8;
            public static final int MSG_PLAY_SEARCH = 9;
            public static final int MSG_PLAY_URI = 10;
            public static final int MSG_PREPARE = 3;
            public static final int MSG_PREPARE_MEDIA_ID = 4;
            public static final int MSG_PREPARE_SEARCH = 5;
            public static final int MSG_PREPARE_URI = 6;
            public static final int MSG_PREVIOUS = 15;
            public static final int MSG_RATE = 19;
            public static final int MSG_RATE_EXTRA = 31;
            public static final int MSG_REMOVE_QUEUE_ITEM = 27;
            public static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            public static final int MSG_REWIND = 17;
            public static final int MSG_SEEK_TO = 18;
            public static final int MSG_SET_CAPTIONING_ENABLED = 29;
            public static final int MSG_SET_PLAYBACK_SPEED = 32;
            public static final int MSG_SET_REPEAT_MODE = 23;
            public static final int MSG_SET_SHUFFLE_MODE = 30;
            public static final int MSG_SET_VOLUME = 22;
            public static final int MSG_SKIP_TO_ITEM = 11;
            public static final int MSG_STOP = 13;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            private void onMediaButtonEvent(KeyEvent keyEvent, Callback callback) {
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    PlaybackStateCompat playbackStateCompat = MediaSessionImplBase.this.mState;
                    long actions = playbackStateCompat == null ? 0 : playbackStateCompat.getActions();
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79) {
                        if (keyCode != 126) {
                            if (keyCode != 127) {
                                switch (keyCode) {
                                    case 85:
                                        break;
                                    case 86:
                                        if ((actions & 1) != 0) {
                                            callback.onStop();
                                            return;
                                        }
                                        return;
                                    case 87:
                                        if ((actions & 32) != 0) {
                                            callback.onSkipToNext();
                                            return;
                                        }
                                        return;
                                    case 88:
                                        if ((actions & 16) != 0) {
                                            callback.onSkipToPrevious();
                                            return;
                                        }
                                        return;
                                    case 89:
                                        if ((actions & 8) != 0) {
                                            callback.onRewind();
                                            return;
                                        }
                                        return;
                                    case 90:
                                        if ((actions & 64) != 0) {
                                            callback.onFastForward();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            } else if ((actions & 2) != 0) {
                                callback.onPause();
                                return;
                            } else {
                                return;
                            }
                        } else if ((actions & 4) != 0) {
                            callback.onPlay();
                            return;
                        } else {
                            return;
                        }
                    }
                    Log.w(MediaSessionCompat.TAG, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                }
            }

            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void handleMessage(android.os.Message r8) {
                /*
                    r7 = this;
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    android.support.v4.media.session.MediaSessionCompat$Callback r0 = r0.mCallback
                    if (r0 != 0) goto L_0x0007
                    return
                L_0x0007:
                    android.os.Bundle r1 = r8.getData()
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r1)
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r2 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    androidx.media.MediaSessionManager$RemoteUserInfo r3 = new androidx.media.MediaSessionManager$RemoteUserInfo
                    java.lang.String r4 = "data_calling_pkg"
                    java.lang.String r4 = r1.getString(r4)
                    java.lang.String r5 = "data_calling_pid"
                    int r5 = r1.getInt(r5)
                    java.lang.String r6 = "data_calling_uid"
                    int r6 = r1.getInt(r6)
                    r3.<init>(r4, r5, r6)
                    r2.setCurrentControllerInfo(r3)
                    java.lang.String r2 = "data_extras"
                    android.os.Bundle r1 = r1.getBundle(r2)
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r1)
                    r2 = 0
                    int r3 = r8.what     // Catch:{ all -> 0x0172 }
                    r4 = 0
                    switch(r3) {
                        case 1: goto L_0x015f;
                        case 2: goto L_0x0157;
                        case 3: goto L_0x0153;
                        case 4: goto L_0x014b;
                        case 5: goto L_0x0143;
                        case 6: goto L_0x013b;
                        case 7: goto L_0x0137;
                        case 8: goto L_0x012f;
                        case 9: goto L_0x0127;
                        case 10: goto L_0x011f;
                        case 11: goto L_0x0113;
                        case 12: goto L_0x010f;
                        case 13: goto L_0x010b;
                        case 14: goto L_0x0107;
                        case 15: goto L_0x0102;
                        case 16: goto L_0x00fd;
                        case 17: goto L_0x00f8;
                        case 18: goto L_0x00eb;
                        case 19: goto L_0x00e2;
                        case 20: goto L_0x00d9;
                        case 21: goto L_0x00be;
                        case 22: goto L_0x00b5;
                        case 23: goto L_0x00ae;
                        case 24: goto L_0x003a;
                        case 25: goto L_0x00a5;
                        case 26: goto L_0x009a;
                        case 27: goto L_0x0095;
                        case 28: goto L_0x0066;
                        case 29: goto L_0x0059;
                        case 30: goto L_0x0052;
                        case 31: goto L_0x0049;
                        case 32: goto L_0x003c;
                        default: goto L_0x003a;
                    }     // Catch:{ all -> 0x0172 }
                L_0x003a:
                    goto L_0x016c
                L_0x003c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    java.lang.Float r8 = (java.lang.Float) r8     // Catch:{ all -> 0x0172 }
                    float r8 = r8.floatValue()     // Catch:{ all -> 0x0172 }
                    r0.onSetPlaybackSpeed(r8)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0049:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    android.support.v4.media.RatingCompat r8 = (android.support.v4.media.RatingCompat) r8     // Catch:{ all -> 0x0172 }
                    r0.onSetRating(r8, r1)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0052:
                    int r8 = r8.arg1     // Catch:{ all -> 0x0172 }
                    r0.onSetShuffleMode(r8)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0059:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0172 }
                    boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0172 }
                    r0.onSetCaptioningEnabled(r8)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0066:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r1 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x0172 }
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r1 = r1.mQueue     // Catch:{ all -> 0x0172 }
                    if (r1 == 0) goto L_0x016c
                    int r1 = r8.arg1     // Catch:{ all -> 0x0172 }
                    if (r1 < 0) goto L_0x0089
                    int r1 = r8.arg1     // Catch:{ all -> 0x0172 }
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r3 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x0172 }
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r3 = r3.mQueue     // Catch:{ all -> 0x0172 }
                    int r3 = r3.size()     // Catch:{ all -> 0x0172 }
                    if (r1 >= r3) goto L_0x0089
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r1 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x0172 }
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r1 = r1.mQueue     // Catch:{ all -> 0x0172 }
                    int r8 = r8.arg1     // Catch:{ all -> 0x0172 }
                    java.lang.Object r8 = r1.get(r8)     // Catch:{ all -> 0x0172 }
                    android.support.v4.media.session.MediaSessionCompat$QueueItem r8 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r8     // Catch:{ all -> 0x0172 }
                    goto L_0x008a
                L_0x0089:
                    r8 = r2
                L_0x008a:
                    if (r8 == 0) goto L_0x016c
                    android.support.v4.media.MediaDescriptionCompat r8 = r8.getDescription()     // Catch:{ all -> 0x0172 }
                L_0x0090:
                    r0.onRemoveQueueItem(r8)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0095:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    android.support.v4.media.MediaDescriptionCompat r8 = (android.support.v4.media.MediaDescriptionCompat) r8     // Catch:{ all -> 0x0172 }
                    goto L_0x0090
                L_0x009a:
                    java.lang.Object r1 = r8.obj     // Catch:{ all -> 0x0172 }
                    android.support.v4.media.MediaDescriptionCompat r1 = (android.support.v4.media.MediaDescriptionCompat) r1     // Catch:{ all -> 0x0172 }
                    int r8 = r8.arg1     // Catch:{ all -> 0x0172 }
                    r0.onAddQueueItem(r1, r8)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x00a5:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    android.support.v4.media.MediaDescriptionCompat r8 = (android.support.v4.media.MediaDescriptionCompat) r8     // Catch:{ all -> 0x0172 }
                    r0.onAddQueueItem(r8)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x00ae:
                    int r8 = r8.arg1     // Catch:{ all -> 0x0172 }
                    r0.onSetRepeatMode(r8)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x00b5:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x0172 }
                    int r8 = r8.arg1     // Catch:{ all -> 0x0172 }
                    r0.setVolumeTo(r8, r4)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x00be:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    android.view.KeyEvent r8 = (android.view.KeyEvent) r8     // Catch:{ all -> 0x0172 }
                    android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0172 }
                    java.lang.String r3 = "android.intent.action.MEDIA_BUTTON"
                    r1.<init>(r3)     // Catch:{ all -> 0x0172 }
                    java.lang.String r3 = "android.intent.extra.KEY_EVENT"
                    r1.putExtra(r3, r8)     // Catch:{ all -> 0x0172 }
                    boolean r1 = r0.onMediaButtonEvent(r1)     // Catch:{ all -> 0x0172 }
                    if (r1 != 0) goto L_0x016c
                    r7.onMediaButtonEvent(r8, r0)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x00d9:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0172 }
                    r0.onCustomAction(r8, r1)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x00e2:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    android.support.v4.media.RatingCompat r8 = (android.support.v4.media.RatingCompat) r8     // Catch:{ all -> 0x0172 }
                    r0.onSetRating(r8)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x00eb:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0172 }
                    long r3 = r8.longValue()     // Catch:{ all -> 0x0172 }
                    r0.onSeekTo(r3)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x00f8:
                    r0.onRewind()     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x00fd:
                    r0.onFastForward()     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0102:
                    r0.onSkipToPrevious()     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0107:
                    r0.onSkipToNext()     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x010b:
                    r0.onStop()     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x010f:
                    r0.onPause()     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0113:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0172 }
                    long r3 = r8.longValue()     // Catch:{ all -> 0x0172 }
                    r0.onSkipToQueueItem(r3)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x011f:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ all -> 0x0172 }
                    r0.onPlayFromUri(r8, r1)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0127:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0172 }
                    r0.onPlayFromSearch(r8, r1)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x012f:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0172 }
                    r0.onPlayFromMediaId(r8, r1)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0137:
                    r0.onPlay()     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x013b:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ all -> 0x0172 }
                    r0.onPrepareFromUri(r8, r1)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0143:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0172 }
                    r0.onPrepareFromSearch(r8, r1)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x014b:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0172 }
                    r0.onPrepareFromMediaId(r8, r1)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0153:
                    r0.onPrepare()     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x0157:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x0172 }
                    int r8 = r8.arg1     // Catch:{ all -> 0x0172 }
                    r0.adjustVolume(r8, r4)     // Catch:{ all -> 0x0172 }
                    goto L_0x016c
                L_0x015f:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0172 }
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command r8 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.Command) r8     // Catch:{ all -> 0x0172 }
                    java.lang.String r1 = r8.command     // Catch:{ all -> 0x0172 }
                    android.os.Bundle r3 = r8.extras     // Catch:{ all -> 0x0172 }
                    android.os.ResultReceiver r8 = r8.stub     // Catch:{ all -> 0x0172 }
                    r0.onCommand(r1, r3, r8)     // Catch:{ all -> 0x0172 }
                L_0x016c:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r8 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    r8.setCurrentControllerInfo(r2)
                    return
                L_0x0172:
                    r8 = move-exception
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    r0.setCurrentControllerInfo(r2)
                    goto L_0x017a
                L_0x0179:
                    throw r8
                L_0x017a:
                    goto L_0x0179
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MessageHandler.handleMessage(android.os.Message):void");
            }
        }

        public MediaSessionImplBase(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
            if (componentName != null) {
                this.mContext = context;
                this.mPackageName = context.getPackageName();
                this.mSessionInfo = bundle;
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
                this.mTag = str;
                this.mMediaButtonReceiverComponentName = componentName;
                this.mMediaButtonReceiverIntent = pendingIntent;
                this.mStub = new MediaSessionStub();
                this.mToken = new Token(this.mStub, (IMediaSession) null, versionedParcelable);
                this.mRatingType = 0;
                this.mVolumeType = 1;
                this.mLocalStream = 3;
                this.mRcc = new RemoteControlClient(pendingIntent);
                return;
            }
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null");
        }

        private void sendCaptioningEnabled(boolean z) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendEvent(String str, Bundle bundle) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendExtras(Bundle bundle) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onExtrasChanged(bundle);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat mediaMetadataCompat) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onMetadataChanged(mediaMetadataCompat);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List<QueueItem> list) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onQueueChanged(list);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence charSequence) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onQueueTitleChanged(charSequence);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendRepeatMode(int i) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onSessionDestroyed();
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        private void sendShuffleMode(int i) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(PlaybackStateCompat playbackStateCompat) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        public void adjustVolume(int i, int i2) {
            if (this.mVolumeType == 2) {
                VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.onAdjustVolume(i);
                    return;
                }
                return;
            }
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, i, i2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
            if (r2 != null) goto L_0x001d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
            if (r2 != null) goto L_0x001d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00c4  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00e5  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00f5  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0104  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.media.RemoteControlClient.MetadataEditor buildRccMetadata(android.os.Bundle r7) {
            /*
                r6 = this;
                android.media.RemoteControlClient r0 = r6.mRcc
                r1 = 1
                android.media.RemoteControlClient$MetadataEditor r0 = r0.editMetadata(r1)
                if (r7 != 0) goto L_0x000a
                return r0
            L_0x000a:
                java.lang.String r2 = "android.media.metadata.ART"
                boolean r3 = r7.containsKey(r2)
                r4 = 100
                r5 = 0
                if (r3 == 0) goto L_0x0029
                android.os.Parcelable r2 = r7.getParcelable(r2)
                android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
                if (r2 == 0) goto L_0x0025
            L_0x001d:
                android.graphics.Bitmap$Config r3 = r2.getConfig()
                android.graphics.Bitmap r2 = r2.copy(r3, r5)
            L_0x0025:
                r0.putBitmap(r4, r2)
                goto L_0x003a
            L_0x0029:
                java.lang.String r2 = "android.media.metadata.ALBUM_ART"
                boolean r3 = r7.containsKey(r2)
                if (r3 == 0) goto L_0x003a
                android.os.Parcelable r2 = r7.getParcelable(r2)
                android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
                if (r2 == 0) goto L_0x0025
                goto L_0x001d
            L_0x003a:
                java.lang.String r2 = "android.media.metadata.ALBUM"
                boolean r3 = r7.containsKey(r2)
                if (r3 == 0) goto L_0x0049
                java.lang.String r2 = r7.getString(r2)
                r0.putString(r1, r2)
            L_0x0049:
                java.lang.String r1 = "android.media.metadata.ALBUM_ARTIST"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x005a
                r2 = 13
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x005a:
                java.lang.String r1 = "android.media.metadata.ARTIST"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x006a
                r2 = 2
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x006a:
                java.lang.String r1 = "android.media.metadata.AUTHOR"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x007a
                r2 = 3
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x007a:
                java.lang.String r1 = "android.media.metadata.COMPILATION"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x008b
                r2 = 15
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x008b:
                java.lang.String r1 = "android.media.metadata.COMPOSER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x009b
                r2 = 4
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x009b:
                java.lang.String r1 = "android.media.metadata.DATE"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00ab
                r2 = 5
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x00ab:
                java.lang.String r1 = "android.media.metadata.DISC_NUMBER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00bc
                r2 = 14
                long r3 = r7.getLong(r1)
                r0.putLong(r2, r3)
            L_0x00bc:
                java.lang.String r1 = "android.media.metadata.DURATION"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00cd
                r2 = 9
                long r3 = r7.getLong(r1)
                r0.putLong(r2, r3)
            L_0x00cd:
                java.lang.String r1 = "android.media.metadata.GENRE"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00dd
                r2 = 6
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x00dd:
                java.lang.String r1 = "android.media.metadata.TITLE"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00ed
                r2 = 7
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x00ed:
                java.lang.String r1 = "android.media.metadata.TRACK_NUMBER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00fc
                long r1 = r7.getLong(r1)
                r0.putLong(r5, r1)
            L_0x00fc:
                java.lang.String r1 = "android.media.metadata.WRITER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x010d
                r2 = 11
                java.lang.String r7 = r7.getString(r1)
                r0.putString(r2, r7)
            L_0x010d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.buildRccMetadata(android.os.Bundle):android.media.RemoteControlClient$MetadataEditor");
        }

        public Callback getCallback() {
            Callback callback;
            synchronized (this.mLock) {
                callback = this.mCallback;
            }
            return callback;
        }

        public String getCallingPackage() {
            return null;
        }

        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            synchronized (this.mLock) {
                remoteUserInfo = this.mRemoteUserInfo;
            }
            return remoteUserInfo;
        }

        public Object getMediaSession() {
            return null;
        }

        public String getPackageNameForUid(int i) {
            String nameForUid = this.mContext.getPackageManager().getNameForUid(i);
            return TextUtils.isEmpty(nameForUid) ? MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER : nameForUid;
        }

        public PlaybackStateCompat getPlaybackState() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.mLock) {
                playbackStateCompat = this.mState;
            }
            return playbackStateCompat;
        }

        public int getRccStateFromState(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        public int getRccTransportControlFlagsFromActions(long j) {
            int i = (1 & j) != 0 ? 32 : 0;
            if ((2 & j) != 0) {
                i |= 16;
            }
            if ((4 & j) != 0) {
                i |= 4;
            }
            if ((8 & j) != 0) {
                i |= 2;
            }
            if ((16 & j) != 0) {
                i |= 1;
            }
            if ((32 & j) != 0) {
                i |= 128;
            }
            if ((64 & j) != 0) {
                i |= 64;
            }
            return (j & 512) != 0 ? i | 8 : i;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return this.mIsActive;
        }

        public void postToHandler(int i, int i2, int i3, Object obj, Bundle bundle) {
            synchronized (this.mLock) {
                if (this.mHandler != null) {
                    Message obtainMessage = this.mHandler.obtainMessage(i, i2, i3, obj);
                    Bundle bundle2 = new Bundle();
                    int callingUid = Binder.getCallingUid();
                    bundle2.putInt("data_calling_uid", callingUid);
                    bundle2.putString(MediaSessionCompat.DATA_CALLING_PACKAGE, getPackageNameForUid(callingUid));
                    int callingPid = Binder.getCallingPid();
                    if (callingPid > 0) {
                        bundle2.putInt("data_calling_pid", callingPid);
                    } else {
                        bundle2.putInt("data_calling_pid", -1);
                    }
                    if (bundle != null) {
                        bundle2.putBundle(MediaSessionCompat.DATA_EXTRAS, bundle);
                    }
                    obtainMessage.setData(bundle2);
                    obtainMessage.sendToTarget();
                }
            }
        }

        public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.registerMediaButtonEventReceiver(componentName);
        }

        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            updateMbrAndRcc();
            sendSessionDestroyed();
            setCallback((Callback) null, (Handler) null);
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            sendEvent(str, bundle);
        }

        public void sendVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onVolumeInfoChanged(parcelableVolumeInfo);
                } catch (RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        public void setActive(boolean z) {
            if (z != this.mIsActive) {
                this.mIsActive = z;
                updateMbrAndRcc();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0032  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback r5, android.os.Handler r6) {
            /*
                r4 = this;
                java.lang.Object r0 = r4.mLock
                monitor-enter(r0)
                android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler r1 = r4.mHandler     // Catch:{ all -> 0x0039 }
                r2 = 0
                if (r1 == 0) goto L_0x000d
                android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler r1 = r4.mHandler     // Catch:{ all -> 0x0039 }
                r1.removeCallbacksAndMessages(r2)     // Catch:{ all -> 0x0039 }
            L_0x000d:
                if (r5 == 0) goto L_0x001c
                if (r6 != 0) goto L_0x0012
                goto L_0x001c
            L_0x0012:
                android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler r1 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler     // Catch:{ all -> 0x0039 }
                android.os.Looper r3 = r6.getLooper()     // Catch:{ all -> 0x0039 }
                r1.<init>(r3)     // Catch:{ all -> 0x0039 }
                goto L_0x001d
            L_0x001c:
                r1 = r2
            L_0x001d:
                r4.mHandler = r1     // Catch:{ all -> 0x0039 }
                android.support.v4.media.session.MediaSessionCompat$Callback r1 = r4.mCallback     // Catch:{ all -> 0x0039 }
                if (r1 == r5) goto L_0x002c
                android.support.v4.media.session.MediaSessionCompat$Callback r1 = r4.mCallback     // Catch:{ all -> 0x0039 }
                if (r1 == 0) goto L_0x002c
                android.support.v4.media.session.MediaSessionCompat$Callback r1 = r4.mCallback     // Catch:{ all -> 0x0039 }
                r1.setSessionImpl(r2, r2)     // Catch:{ all -> 0x0039 }
            L_0x002c:
                r4.mCallback = r5     // Catch:{ all -> 0x0039 }
                android.support.v4.media.session.MediaSessionCompat$Callback r5 = r4.mCallback     // Catch:{ all -> 0x0039 }
                if (r5 == 0) goto L_0x0037
                android.support.v4.media.session.MediaSessionCompat$Callback r5 = r4.mCallback     // Catch:{ all -> 0x0039 }
                r5.setSessionImpl(r4, r6)     // Catch:{ all -> 0x0039 }
            L_0x0037:
                monitor-exit(r0)     // Catch:{ all -> 0x0039 }
                return
            L_0x0039:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0039 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.setCallback(android.support.v4.media.session.MediaSessionCompat$Callback, android.os.Handler):void");
        }

        public void setCaptioningEnabled(boolean z) {
            if (this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                sendCaptioningEnabled(z);
            }
        }

        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = remoteUserInfo;
            }
        }

        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
            sendExtras(bundle);
        }

        public void setFlags(int i) {
            synchronized (this.mLock) {
                this.mFlags = i | 1 | 2;
            }
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new MediaMetadataCompat.Builder(mediaMetadataCompat, MediaSessionCompat.sMaxBitmapSize).build();
            }
            synchronized (this.mLock) {
                this.mMetadata = mediaMetadataCompat;
            }
            sendMetadata(mediaMetadataCompat);
            if (this.mIsActive) {
                buildRccMetadata(mediaMetadataCompat == null ? null : mediaMetadataCompat.getBundle()).apply();
            }
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                this.mState = playbackStateCompat;
            }
            sendState(playbackStateCompat);
            if (this.mIsActive) {
                if (playbackStateCompat == null) {
                    this.mRcc.setPlaybackState(0);
                    this.mRcc.setTransportControlFlags(0);
                    return;
                }
                setRccState(playbackStateCompat);
                this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(playbackStateCompat.getActions()));
            }
        }

        public void setPlaybackToLocal(int i) {
            VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.setCallback((VolumeProviderCompat.Callback) null);
            }
            this.mLocalStream = i;
            this.mVolumeType = 1;
            int i2 = this.mVolumeType;
            int i3 = this.mLocalStream;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(i2, i3, 2, this.mAudioManager.getStreamMaxVolume(i3), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            if (volumeProviderCompat != null) {
                VolumeProviderCompat volumeProviderCompat2 = this.mVolumeProvider;
                if (volumeProviderCompat2 != null) {
                    volumeProviderCompat2.setCallback((VolumeProviderCompat.Callback) null);
                }
                this.mVolumeType = 2;
                this.mVolumeProvider = volumeProviderCompat;
                sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
                volumeProviderCompat.setCallback(this.mVolumeCallback);
                return;
            }
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        public void setQueue(List<QueueItem> list) {
            this.mQueue = list;
            sendQueue(list);
        }

        public void setQueueTitle(CharSequence charSequence) {
            this.mQueueTitle = charSequence;
            sendQueueTitle(charSequence);
        }

        public void setRatingType(int i) {
            this.mRatingType = i;
        }

        public void setRccState(PlaybackStateCompat playbackStateCompat) {
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()));
        }

        public void setRepeatMode(int i) {
            if (this.mRepeatMode != i) {
                this.mRepeatMode = i;
                sendRepeatMode(i);
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            synchronized (this.mLock) {
                this.mSessionActivity = pendingIntent;
            }
        }

        public void setShuffleMode(int i) {
            if (this.mShuffleMode != i) {
                this.mShuffleMode = i;
                sendShuffleMode(i);
            }
        }

        public void setVolumeTo(int i, int i2) {
            if (this.mVolumeType == 2) {
                VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.onSetVolumeTo(i);
                    return;
                }
                return;
            }
            this.mAudioManager.setStreamVolume(this.mLocalStream, i, i2);
        }

        public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
        }

        public void updateMbrAndRcc() {
            if (this.mIsActive) {
                registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                this.mAudioManager.registerRemoteControlClient(this.mRcc);
                setMetadata(this.mMetadata);
                setPlaybackState(this.mState);
                return;
            }
            unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
        }
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        };
        public static final int UNKNOWN_ID = -1;
        public final MediaDescriptionCompat mDescription;
        public final long mId;
        public MediaSession.QueueItem mItemFwk;

        public QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            } else if (j != -1) {
                this.mDescription = mediaDescriptionCompat;
                this.mId = j;
                this.mItemFwk = queueItem;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        public QueueItem(Parcel parcel) {
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this((MediaSession.QueueItem) null, mediaDescriptionCompat, j);
        }

        public static QueueItem fromQueueItem(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
            return new QueueItem(queueItem, MediaDescriptionCompat.fromMediaDescription(queueItem.getDescription()), queueItem.getQueueId());
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object fromQueueItem : list) {
                arrayList.add(fromQueueItem(fromQueueItem));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            if (this.mItemFwk != null || Build.VERSION.SDK_INT < 21) {
                return this.mItemFwk;
            }
            MediaSession.QueueItem queueItem = new MediaSession.QueueItem((MediaDescription) this.mDescription.getMediaDescription(), this.mId);
            this.mItemFwk = queueItem;
            return queueItem;
        }

        public String toString() {
            StringBuilder n = a.n("MediaSession.QueueItem {Description=");
            n.append(this.mDescription);
            n.append(", Id=");
            n.append(this.mId);
            n.append(" }");
            return n.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.mDescription.writeToParcel(parcel, i);
            parcel.writeLong(this.mId);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        };
        public ResultReceiver mResultReceiver;

        public ResultReceiverWrapper(Parcel parcel) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public ResultReceiverWrapper(@NonNull ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.mResultReceiver.writeToParcel(parcel, i);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            public Token createFromParcel(Parcel parcel) {
                return new Token(Build.VERSION.SDK_INT >= 21 ? parcel.readParcelable((ClassLoader) null) : parcel.readStrongBinder());
            }

            public Token[] newArray(int i) {
                return new Token[i];
            }
        };
        @GuardedBy("mLock")
        public IMediaSession mExtraBinder;
        public final Object mInner;
        public final Object mLock;
        @GuardedBy("mLock")
        public VersionedParcelable mSession2Token;

        public Token(Object obj) {
            this(obj, (IMediaSession) null, (VersionedParcelable) null);
        }

        public Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, (VersionedParcelable) null);
        }

        public Token(Object obj, IMediaSession iMediaSession, VersionedParcelable versionedParcelable) {
            this.mLock = new Object();
            this.mInner = obj;
            this.mExtraBinder = iMediaSession;
            this.mSession2Token = versionedParcelable;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Token fromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER));
            VersionedParcelable versionedParcelable = ParcelUtils.getVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN);
            Token token = (Token) bundle.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (token == null) {
                return null;
            }
            return new Token(token.mInner, asInterface, versionedParcelable);
        }

        public static Token fromToken(Object obj) {
            return fromToken(obj, (IMediaSession) null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Token fromToken(Object obj, IMediaSession iMediaSession) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            if (obj instanceof MediaSession.Token) {
                return new Token(obj, iMediaSession);
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Object obj2 = this.mInner;
            Object obj3 = ((Token) obj).mInner;
            if (obj2 == null) {
                return obj3 == null;
            }
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public IMediaSession getExtraBinder() {
            IMediaSession iMediaSession;
            synchronized (this.mLock) {
                iMediaSession = this.mExtraBinder;
            }
            return iMediaSession;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public VersionedParcelable getSession2Token() {
            VersionedParcelable versionedParcelable;
            synchronized (this.mLock) {
                versionedParcelable = this.mSession2Token;
            }
            return versionedParcelable;
        }

        public Object getToken() {
            return this.mInner;
        }

        public int hashCode() {
            Object obj = this.mInner;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void setExtraBinder(IMediaSession iMediaSession) {
            synchronized (this.mLock) {
                this.mExtraBinder = iMediaSession;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setSession2Token(VersionedParcelable versionedParcelable) {
            synchronized (this.mLock) {
                this.mSession2Token = versionedParcelable;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            synchronized (this.mLock) {
                if (this.mExtraBinder != null) {
                    BundleCompat.putBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER, this.mExtraBinder.asBinder());
                }
                if (this.mSession2Token != null) {
                    ParcelUtils.putVersionedParcelable(bundle, MediaSessionCompat.KEY_SESSION2_TOKEN, this.mSession2Token);
                }
            }
            return bundle;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.mInner, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.mInner);
            }
        }
    }

    public MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        this.mActiveListeners = new ArrayList<>();
        this.mImpl = mediaSessionImpl;
        this.mController = new MediaControllerCompat(context, this);
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str) {
        this(context, str, (ComponentName) null, (PendingIntent) null);
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, (Bundle) null);
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, (VersionedParcelable) null);
    }

    /* JADX WARNING: type inference failed for: r12v6, types: [android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl] */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaSessionCompat(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.NonNull java.lang.String r11, @androidx.annotation.Nullable android.content.ComponentName r12, @androidx.annotation.Nullable android.app.PendingIntent r13, @androidx.annotation.Nullable android.os.Bundle r14, @androidx.annotation.Nullable androidx.versionedparcelable.VersionedParcelable r15) {
        /*
            r9 = this;
            r9.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9.mActiveListeners = r0
            if (r10 == 0) goto L_0x00d4
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x00cc
            if (r12 != 0) goto L_0x0021
            android.content.ComponentName r12 = androidx.media.session.MediaButtonReceiver.getMediaButtonReceiverComponent(r10)
            if (r12 != 0) goto L_0x0021
            java.lang.String r0 = "MediaSessionCompat"
            java.lang.String r1 = "Couldn't find a unique registered media button receiver in the given context."
            android.util.Log.w(r0, r1)
        L_0x0021:
            r5 = r12
            if (r5 == 0) goto L_0x0035
            if (r13 != 0) goto L_0x0035
            android.content.Intent r12 = new android.content.Intent
            java.lang.String r13 = "android.intent.action.MEDIA_BUTTON"
            r12.<init>(r13)
            r12.setComponent(r5)
            r13 = 0
            android.app.PendingIntent r13 = android.app.PendingIntent.getBroadcast(r10, r13, r12, r13)
        L_0x0035:
            r6 = r13
            int r12 = android.os.Build.VERSION.SDK_INT
            r13 = 21
            if (r12 < r13) goto L_0x0080
            android.media.session.MediaSession r11 = r9.createFwkMediaSession(r10, r11, r14)
            int r12 = android.os.Build.VERSION.SDK_INT
            r13 = 29
            if (r12 < r13) goto L_0x004e
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi29 r12 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi29
            r12.<init>(r11, r15, r14)
        L_0x004b:
            r9.mImpl = r12
            goto L_0x005e
        L_0x004e:
            r13 = 28
            if (r12 < r13) goto L_0x0058
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi28 r12 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi28
            r12.<init>(r11, r15, r14)
            goto L_0x004b
        L_0x0058:
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21 r12 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21
            r12.<init>(r11, r15, r14)
            goto L_0x004b
        L_0x005e:
            android.os.Handler r11 = new android.os.Handler
            android.os.Looper r12 = android.os.Looper.myLooper()
            if (r12 == 0) goto L_0x006b
            android.os.Looper r12 = android.os.Looper.myLooper()
            goto L_0x006f
        L_0x006b:
            android.os.Looper r12 = android.os.Looper.getMainLooper()
        L_0x006f:
            r11.<init>(r12)
            android.support.v4.media.session.MediaSessionCompat$1 r12 = new android.support.v4.media.session.MediaSessionCompat$1
            r12.<init>()
            r9.setCallback(r12, r11)
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl r11 = r9.mImpl
            r11.setMediaButtonReceiver(r6)
            goto L_0x00ab
        L_0x0080:
            r13 = 19
            if (r12 < r13) goto L_0x0091
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19 r12 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19
            r2 = r12
            r3 = r10
            r4 = r11
            r7 = r15
            r8 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8)
        L_0x008e:
            r9.mImpl = r12
            goto L_0x00ab
        L_0x0091:
            r13 = 18
            if (r12 < r13) goto L_0x00a0
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18 r12 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18
            r2 = r12
            r3 = r10
            r4 = r11
            r7 = r15
            r8 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x008e
        L_0x00a0:
            android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r12 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
            r2 = r12
            r3 = r10
            r4 = r11
            r7 = r15
            r8 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x008e
        L_0x00ab:
            android.support.v4.media.session.MediaControllerCompat r11 = new android.support.v4.media.session.MediaControllerCompat
            r11.<init>((android.content.Context) r10, (android.support.v4.media.session.MediaSessionCompat) r9)
            r9.mController = r11
            int r11 = sMaxBitmapSize
            if (r11 != 0) goto L_0x00cb
            r11 = 1
            r12 = 1134559232(0x43a00000, float:320.0)
            android.content.res.Resources r10 = r10.getResources()
            android.util.DisplayMetrics r10 = r10.getDisplayMetrics()
            float r10 = android.util.TypedValue.applyDimension(r11, r12, r10)
            r11 = 1056964608(0x3f000000, float:0.5)
            float r10 = r10 + r11
            int r10 = (int) r10
            sMaxBitmapSize = r10
        L_0x00cb:
            return
        L_0x00cc:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "tag must not be null or empty"
            r10.<init>(r11)
            throw r10
        L_0x00d4:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "context must not be null"
            r10.<init>(r11)
            goto L_0x00dd
        L_0x00dc:
            throw r10
        L_0x00dd:
            goto L_0x00dc
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.<init>(android.content.Context, java.lang.String, android.content.ComponentName, android.app.PendingIntent, android.os.Bundle, androidx.versionedparcelable.VersionedParcelable):void");
    }

    @RequiresApi(21)
    private MediaSession createFwkMediaSession(Context context, String str, Bundle bundle) {
        return Build.VERSION.SDK_INT >= 29 ? new MediaSession(context, str, bundle) : new MediaSession(context, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void ensureClassLoader(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21 || context == null || obj == null) {
            return null;
        }
        return new MediaSessionCompat(context, i >= 29 ? new MediaSessionImplApi29(obj) : i >= 28 ? new MediaSessionImplApi28(obj) : new MediaSessionImplApi21(obj));
    }

    public static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j = -1;
        if (playbackStateCompat.getPosition() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getState() != 3 && playbackStateCompat.getState() != 4 && playbackStateCompat.getState() != 5) {
            return playbackStateCompat;
        }
        long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
        if (lastPositionUpdateTime <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long position = playbackStateCompat.getPosition() + ((long) (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - lastPositionUpdateTime))));
        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
            j = mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
        }
        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), (j < 0 || position <= j) ? position < 0 ? 0 : position : j, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Bundle unparcelWithClassLoader(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ensureClassLoader(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e(TAG, "Could not unparcel the data.");
            return null;
        }
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.mActiveListeners.add(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.mActiveListeners.remove(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.mImpl.sendSessionEvent(str, bundle);
            return;
        }
        throw new IllegalArgumentException("event cannot be null or empty");
    }

    public void setActive(boolean z) {
        this.mImpl.setActive(z);
        Iterator<OnActiveChangeListener> it = this.mActiveListeners.iterator();
        while (it.hasNext()) {
            it.next().onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, (Handler) null);
    }

    public void setCallback(Callback callback, Handler handler) {
        if (callback == null) {
            this.mImpl.setCallback((Callback) null, (Handler) null);
            return;
        }
        MediaSessionImpl mediaSessionImpl = this.mImpl;
        if (handler == null) {
            handler = new Handler();
        }
        mediaSessionImpl.setCallback(callback, handler);
    }

    public void setCaptioningEnabled(boolean z) {
        this.mImpl.setCaptioningEnabled(z);
    }

    public void setExtras(Bundle bundle) {
        this.mImpl.setExtras(bundle);
    }

    public void setFlags(int i) {
        this.mImpl.setFlags(i);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.mImpl.setMediaButtonReceiver(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.mImpl.setMetadata(mediaMetadataCompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.mImpl.setPlaybackState(playbackStateCompat);
    }

    public void setPlaybackToLocal(int i) {
        this.mImpl.setPlaybackToLocal(i);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat != null) {
            this.mImpl.setPlaybackToRemote(volumeProviderCompat);
            return;
        }
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void setQueue(List<QueueItem> list) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            for (QueueItem next : list) {
                if (next != null) {
                    if (hashSet.contains(Long.valueOf(next.getQueueId()))) {
                        StringBuilder n = a.n("Found duplicate queue id: ");
                        n.append(next.getQueueId());
                        Log.e(TAG, n.toString(), new IllegalArgumentException("id of each queue item should be unique"));
                    }
                    hashSet.add(Long.valueOf(next.getQueueId()));
                } else {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
            }
        }
        this.mImpl.setQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mImpl.setQueueTitle(charSequence);
    }

    public void setRatingType(int i) {
        this.mImpl.setRatingType(i);
    }

    public void setRepeatMode(int i) {
        this.mImpl.setRepeatMode(i);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.mImpl.setSessionActivity(pendingIntent);
    }

    public void setShuffleMode(int i) {
        this.mImpl.setShuffleMode(i);
    }
}
