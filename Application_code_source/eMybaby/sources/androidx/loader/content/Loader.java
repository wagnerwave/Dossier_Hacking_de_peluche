package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {
    public boolean mAbandoned = false;
    public boolean mContentChanged = false;
    public Context mContext;
    public int mId;
    public OnLoadCompleteListener<D> mListener;
    public OnLoadCanceledListener<D> mOnLoadCanceledListener;
    public boolean mProcessingChange = false;
    public boolean mReset = true;
    public boolean mStarted = false;

    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            Loader.this.onContentChanged();
        }
    }

    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(@NonNull Loader<D> loader);
    }

    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d2);
    }

    public Loader(@NonNull Context context) {
        this.mContext = context.getApplicationContext();
    }

    @MainThread
    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    @MainThread
    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    @NonNull
    public String dataToString(@Nullable D d2) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    @MainThread
    public void deliverCancellation() {
        OnLoadCanceledListener<D> onLoadCanceledListener = this.mOnLoadCanceledListener;
        if (onLoadCanceledListener != null) {
            onLoadCanceledListener.onLoadCanceled(this);
        }
    }

    @MainThread
    public void deliverResult(@Nullable D d2) {
        OnLoadCompleteListener<D> onLoadCompleteListener = this.mListener;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.onLoadComplete(this, d2);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }

    @MainThread
    public void forceLoad() {
        onForceLoad();
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    @MainThread
    public void onAbandon() {
    }

    @MainThread
    public boolean onCancelLoad() {
        return false;
    }

    @MainThread
    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    @MainThread
    public void onForceLoad() {
    }

    @MainThread
    public void onReset() {
    }

    @MainThread
    public void onStartLoading() {
    }

    @MainThread
    public void onStopLoading() {
    }

    @MainThread
    public void registerListener(int i, @NonNull OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.mListener == null) {
            this.mListener = onLoadCompleteListener;
            this.mId = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    @MainThread
    public void registerOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.mOnLoadCanceledListener == null) {
            this.mOnLoadCanceledListener = onLoadCanceledListener;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    @MainThread
    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    @MainThread
    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    @MainThread
    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    @MainThread
    public void unregisterListener(@NonNull OnLoadCompleteListener<D> onLoadCompleteListener) {
        OnLoadCompleteListener<D> onLoadCompleteListener2 = this.mListener;
        if (onLoadCompleteListener2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (onLoadCompleteListener2 == onLoadCompleteListener) {
            this.mListener = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    @MainThread
    public void unregisterOnLoadCanceledListener(@NonNull OnLoadCanceledListener<D> onLoadCanceledListener) {
        OnLoadCanceledListener<D> onLoadCanceledListener2 = this.mOnLoadCanceledListener;
        if (onLoadCanceledListener2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (onLoadCanceledListener2 == onLoadCanceledListener) {
            this.mOnLoadCanceledListener = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }
}
