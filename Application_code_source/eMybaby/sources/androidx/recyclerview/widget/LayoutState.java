package androidx.recyclerview.widget;

import a.a.a.a.a;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class LayoutState {
    public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    public static final int ITEM_DIRECTION_HEAD = -1;
    public static final int ITEM_DIRECTION_TAIL = 1;
    public static final int LAYOUT_END = 1;
    public static final int LAYOUT_START = -1;
    public int mAvailable;
    public int mCurrentPosition;
    public int mEndLine = 0;
    public boolean mInfinite;
    public int mItemDirection;
    public int mLayoutDirection;
    public boolean mRecycle = true;
    public int mStartLine = 0;
    public boolean mStopInFocusable;

    public boolean hasMore(RecyclerView.State state) {
        int i = this.mCurrentPosition;
        return i >= 0 && i < state.getItemCount();
    }

    public View next(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return viewForPosition;
    }

    public String toString() {
        StringBuilder n = a.n("LayoutState{mAvailable=");
        n.append(this.mAvailable);
        n.append(", mCurrentPosition=");
        n.append(this.mCurrentPosition);
        n.append(", mItemDirection=");
        n.append(this.mItemDirection);
        n.append(", mLayoutDirection=");
        n.append(this.mLayoutDirection);
        n.append(", mStartLine=");
        n.append(this.mStartLine);
        n.append(", mEndLine=");
        n.append(this.mEndLine);
        n.append('}');
        return n.toString();
    }
}
