package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

public class BatchingListUpdateCallback implements ListUpdateCallback {
    public static final int TYPE_ADD = 1;
    public static final int TYPE_CHANGE = 3;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_REMOVE = 2;
    public int mLastEventCount = -1;
    public Object mLastEventPayload = null;
    public int mLastEventPosition = -1;
    public int mLastEventType = 0;
    public final ListUpdateCallback mWrapped;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i = this.mLastEventType;
        if (i != 0) {
            if (i == 1) {
                this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
            } else if (i == 2) {
                this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
            } else if (i == 3) {
                this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
            }
            this.mLastEventPayload = null;
            this.mLastEventType = 0;
        }
    }

    public void onChanged(int i, int i2, Object obj) {
        int i3;
        if (this.mLastEventType == 3) {
            int i4 = this.mLastEventPosition;
            int i5 = this.mLastEventCount;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.mLastEventPayload == obj) {
                this.mLastEventPosition = Math.min(i, i4);
                this.mLastEventCount = Math.max(i5 + i4, i3) - this.mLastEventPosition;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i;
        this.mLastEventCount = i2;
        this.mLastEventPayload = obj;
        this.mLastEventType = 3;
    }

    public void onInserted(int i, int i2) {
        int i3;
        if (this.mLastEventType == 1 && i >= (i3 = this.mLastEventPosition)) {
            int i4 = this.mLastEventCount;
            if (i <= i3 + i4) {
                this.mLastEventCount = i4 + i2;
                this.mLastEventPosition = Math.min(i, i3);
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i;
        this.mLastEventCount = i2;
        this.mLastEventType = 1;
    }

    public void onMoved(int i, int i2) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i, i2);
    }

    public void onRemoved(int i, int i2) {
        int i3;
        if (this.mLastEventType != 2 || (i3 = this.mLastEventPosition) < i || i3 > i + i2) {
            dispatchLastEvent();
            this.mLastEventPosition = i;
            this.mLastEventCount = i2;
            this.mLastEventType = 2;
            return;
        }
        this.mLastEventCount += i2;
        this.mLastEventPosition = i;
    }
}
