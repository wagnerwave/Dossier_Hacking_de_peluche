package androidx.media.utils;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;

public final class MediaConstants {
    @SuppressLint({"IntentName"})
    public static final String METADATA_KEY_CONTENT_ID = "androidx.media.MediaMetadatCompat.METADATA_KEY_CONTENT_ID";
    @SuppressLint({"IntentName"})
    public static final String PLAYBACK_STATE_EXTRAS_KEY_MEDIA_ID = "androidx.media.PlaybackStateCompat.Extras.KEY_MEDIA_ID";
    @SuppressLint({"IntentName"})
    public static final String SESSION_EXTRAS_KEY_ACCOUNT_NAME = "androidx.media.MediaSessionCompat.Extras.KEY_ACCOUNT_NAME";
    @SuppressLint({"IntentName"})
    public static final String SESSION_EXTRAS_KEY_ACCOUNT_TYPE = "androidx.media.MediaSessionCompat.Extras.KEY_ACCOUNT_TYPE";
    @SuppressLint({"IntentName"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String SESSION_EXTRAS_KEY_AUTHTOKEN = "androidx.media.MediaSessionCompat.Extras.KEY_AUTHTOKEN";
}
