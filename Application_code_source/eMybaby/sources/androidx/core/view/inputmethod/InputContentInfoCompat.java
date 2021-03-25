package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class InputContentInfoCompat {
    public final InputContentInfoCompatImpl mImpl;

    @RequiresApi(25)
    public static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {
        @NonNull
        public final InputContentInfo mObject;

        public InputContentInfoCompatApi25Impl(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.mObject = new InputContentInfo(uri, clipDescription, uri2);
        }

        public InputContentInfoCompatApi25Impl(@NonNull Object obj) {
            this.mObject = (InputContentInfo) obj;
        }

        @NonNull
        public Uri getContentUri() {
            return this.mObject.getContentUri();
        }

        @NonNull
        public ClipDescription getDescription() {
            return this.mObject.getDescription();
        }

        @Nullable
        public Object getInputContentInfo() {
            return this.mObject;
        }

        @Nullable
        public Uri getLinkUri() {
            return this.mObject.getLinkUri();
        }

        public void releasePermission() {
            this.mObject.releasePermission();
        }

        public void requestPermission() {
            this.mObject.requestPermission();
        }
    }

    public static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {
        @NonNull
        public final Uri mContentUri;
        @NonNull
        public final ClipDescription mDescription;
        @Nullable
        public final Uri mLinkUri;

        public InputContentInfoCompatBaseImpl(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.mContentUri = uri;
            this.mDescription = clipDescription;
            this.mLinkUri = uri2;
        }

        @NonNull
        public Uri getContentUri() {
            return this.mContentUri;
        }

        @NonNull
        public ClipDescription getDescription() {
            return this.mDescription;
        }

        @Nullable
        public Object getInputContentInfo() {
            return null;
        }

        @Nullable
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        public void releasePermission() {
        }

        public void requestPermission() {
        }
    }

    public interface InputContentInfoCompatImpl {
        @NonNull
        Uri getContentUri();

        @NonNull
        ClipDescription getDescription();

        @Nullable
        Object getInputContentInfo();

        @Nullable
        Uri getLinkUri();

        void releasePermission();

        void requestPermission();
    }

    public InputContentInfoCompat(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        this.mImpl = Build.VERSION.SDK_INT >= 25 ? new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2) : new InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
    }

    public InputContentInfoCompat(@NonNull InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.mImpl = inputContentInfoCompatImpl;
    }

    @Nullable
    public static InputContentInfoCompat wrap(@Nullable Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(obj));
        }
        return null;
    }

    @NonNull
    public Uri getContentUri() {
        return this.mImpl.getContentUri();
    }

    @NonNull
    public ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mImpl.getLinkUri();
    }

    public void releasePermission() {
        this.mImpl.releasePermission();
    }

    public void requestPermission() {
        this.mImpl.requestPermission();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getInputContentInfo();
    }
}
