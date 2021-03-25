package de.timroes.swipetodismiss;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public final class SwipeDismissList implements View.OnTouchListener {
    public long mAnimationTime;
    public int mAutoHideDelay;
    public OnDismissCallback mCallback;
    public int mDelayedMsgId;
    public String mDeleteMultipleString;
    public String mDeleteString;
    public float mDensity;
    public int mDismissAnimationRefCount;
    public int mDownPosition;
    public View mDownView;
    public float mDownX;
    public Handler mHandler;
    public AbsListView mListView;
    public int mMaxFlingVelocity;
    public int mMinFlingVelocity;
    public UndoMode mMode;
    public boolean mPaused;
    public SortedSet<PendingDismissData> mPendingDismisses;
    public int mSlop;
    public SwipeDirection mSwipeDirection;
    public boolean mSwipeDisabled;
    public boolean mSwiping;
    public boolean mTouchBeforeAutoHide;
    public List<Undoable> mUndoActions;
    public Button mUndoButton;
    public PopupWindow mUndoPopup;
    public TextView mUndoText;
    public VelocityTracker mVelocityTracker;
    public int mViewWidth;

    /* renamed from: de.timroes.swipetodismiss.SwipeDismissList$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$de$timroes$swipetodismiss$SwipeDismissList$SwipeDirection;
        public static final /* synthetic */ int[] $SwitchMap$de$timroes$swipetodismiss$SwipeDismissList$UndoMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0030 */
        static {
            /*
                de.timroes.swipetodismiss.SwipeDismissList$SwipeDirection[] r0 = de.timroes.swipetodismiss.SwipeDismissList.SwipeDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$de$timroes$swipetodismiss$SwipeDismissList$SwipeDirection = r0
                r1 = 0
                r2 = 1
                de.timroes.swipetodismiss.SwipeDismissList$SwipeDirection r3 = de.timroes.swipetodismiss.SwipeDismissList.SwipeDirection.BOTH     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r3 = $SwitchMap$de$timroes$swipetodismiss$SwipeDismissList$SwipeDirection     // Catch:{ NoSuchFieldError -> 0x0016 }
                de.timroes.swipetodismiss.SwipeDismissList$SwipeDirection r4 = de.timroes.swipetodismiss.SwipeDismissList.SwipeDirection.START     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r3 = 3
                int[] r4 = $SwitchMap$de$timroes$swipetodismiss$SwipeDismissList$SwipeDirection     // Catch:{ NoSuchFieldError -> 0x001d }
                de.timroes.swipetodismiss.SwipeDismissList$SwipeDirection r5 = de.timroes.swipetodismiss.SwipeDismissList.SwipeDirection.END     // Catch:{ NoSuchFieldError -> 0x001d }
                r4[r0] = r3     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                de.timroes.swipetodismiss.SwipeDismissList$UndoMode[] r4 = de.timroes.swipetodismiss.SwipeDismissList.UndoMode.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$de$timroes$swipetodismiss$SwipeDismissList$UndoMode = r4
                de.timroes.swipetodismiss.SwipeDismissList$UndoMode r5 = de.timroes.swipetodismiss.SwipeDismissList.UndoMode.SINGLE_UNDO     // Catch:{ NoSuchFieldError -> 0x002a }
                r4[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r1 = $SwitchMap$de$timroes$swipetodismiss$SwipeDismissList$UndoMode     // Catch:{ NoSuchFieldError -> 0x0030 }
                de.timroes.swipetodismiss.SwipeDismissList$UndoMode r4 = de.timroes.swipetodismiss.SwipeDismissList.UndoMode.COLLAPSED_UNDO     // Catch:{ NoSuchFieldError -> 0x0030 }
                r1[r0] = r0     // Catch:{ NoSuchFieldError -> 0x0030 }
            L_0x0030:
                int[] r0 = $SwitchMap$de$timroes$swipetodismiss$SwipeDismissList$UndoMode     // Catch:{ NoSuchFieldError -> 0x0036 }
                de.timroes.swipetodismiss.SwipeDismissList$UndoMode r1 = de.timroes.swipetodismiss.SwipeDismissList.UndoMode.MULTI_UNDO     // Catch:{ NoSuchFieldError -> 0x0036 }
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0036 }
            L_0x0036:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: de.timroes.swipetodismiss.SwipeDismissList.AnonymousClass5.<clinit>():void");
        }
    }

    public class HideUndoPopupHandler extends Handler {
        public HideUndoPopupHandler() {
        }

        public void handleMessage(Message message) {
            if (message.what == SwipeDismissList.this.mDelayedMsgId) {
                for (Undoable discard : SwipeDismissList.this.mUndoActions) {
                    discard.discard();
                }
                SwipeDismissList.this.mUndoActions.clear();
                SwipeDismissList.this.mUndoPopup.dismiss();
            }
        }
    }

    public interface OnDismissCallback {
        Undoable onDismiss(AbsListView absListView, int i);
    }

    public class PendingDismissData implements Comparable<PendingDismissData> {
        public int position;
        public View view;

        public PendingDismissData(int i, View view2) {
            this.position = i;
            this.view = view2;
        }

        public int compareTo(PendingDismissData pendingDismissData) {
            return pendingDismissData.position - this.position;
        }
    }

    public enum SwipeDirection {
        BOTH,
        START,
        END
    }

    public class UndoHandler implements View.OnClickListener {
        public UndoHandler() {
        }

        public void onClick(View view) {
            if (!SwipeDismissList.this.mUndoActions.isEmpty()) {
                int ordinal = SwipeDismissList.this.mMode.ordinal();
                if (ordinal == 0) {
                    ((Undoable) SwipeDismissList.this.mUndoActions.get(0)).undo();
                } else if (ordinal == 1) {
                    ((Undoable) SwipeDismissList.this.mUndoActions.get(SwipeDismissList.this.mUndoActions.size() - 1)).undo();
                    SwipeDismissList.this.mUndoActions.remove(SwipeDismissList.this.mUndoActions.size() - 1);
                } else if (ordinal == 2) {
                    Collections.reverse(SwipeDismissList.this.mUndoActions);
                    for (Undoable undo : SwipeDismissList.this.mUndoActions) {
                        undo.undo();
                    }
                }
                SwipeDismissList.this.mUndoActions.clear();
            }
            if (SwipeDismissList.this.mUndoActions.isEmpty()) {
                SwipeDismissList.this.mUndoPopup.dismiss();
            } else {
                SwipeDismissList.this.changePopupText();
                SwipeDismissList.this.changeButtonLabel();
            }
            SwipeDismissList.access$908(SwipeDismissList.this);
        }
    }

    public enum UndoMode {
        SINGLE_UNDO,
        MULTI_UNDO,
        COLLAPSED_UNDO
    }

    public static abstract class Undoable {
        public void discard() {
        }

        public String getTitle() {
            return null;
        }

        public abstract void undo();
    }

    public SwipeDismissList(AbsListView absListView, OnDismissCallback onDismissCallback) {
        this(absListView, onDismissCallback, UndoMode.SINGLE_UNDO);
    }

    public SwipeDismissList(AbsListView absListView, OnDismissCallback onDismissCallback, UndoMode undoMode) {
        this.mViewWidth = 1;
        this.mPendingDismisses = new TreeSet();
        this.mDismissAnimationRefCount = 0;
        this.mSwipeDirection = SwipeDirection.BOTH;
        this.mAutoHideDelay = 5000;
        this.mDeleteString = "Item deleted";
        this.mDeleteMultipleString = "%d items deleted";
        this.mTouchBeforeAutoHide = true;
        if (absListView != null) {
            this.mHandler = new HideUndoPopupHandler();
            this.mListView = absListView;
            this.mCallback = onDismissCallback;
            this.mMode = undoMode;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(absListView.getContext());
            this.mSlop = viewConfiguration.getScaledTouchSlop();
            this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            this.mAnimationTime = (long) absListView.getContext().getResources().getInteger(17694720);
            this.mDensity = this.mListView.getResources().getDisplayMetrics().density;
            absListView.setOnTouchListener(this);
            absListView.setOnScrollListener(makeScrollListener());
            this.mUndoActions = undoMode.ordinal() != 0 ? new ArrayList(10) : new ArrayList(1);
            return;
        }
        throw new IllegalArgumentException("listview must not be null.");
    }

    public static /* synthetic */ int access$306(SwipeDismissList swipeDismissList) {
        int i = swipeDismissList.mDismissAnimationRefCount - 1;
        swipeDismissList.mDismissAnimationRefCount = i;
        return i;
    }

    public static /* synthetic */ int access$908(SwipeDismissList swipeDismissList) {
        int i = swipeDismissList.mDelayedMsgId;
        swipeDismissList.mDelayedMsgId = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    public void changeButtonLabel() {
        int i;
        Resources resources;
        if (this.mUndoActions.size() <= 1 || this.mMode != UndoMode.COLLAPSED_UNDO) {
            resources = this.mListView.getResources();
            i = R.string.undo;
        } else {
            resources = this.mListView.getResources();
            i = R.string.undoall;
        }
        resources.getString(i);
    }

    /* access modifiers changed from: private */
    public void changePopupText() {
        String str;
        if (this.mUndoActions.size() > 1 && (str = this.mDeleteMultipleString) != null) {
            String.format(str, new Object[]{Integer.valueOf(this.mUndoActions.size())});
        } else if (this.mUndoActions.size() >= 1) {
            List<Undoable> list = this.mUndoActions;
            if (list.get(list.size() - 1).getTitle() != null) {
                List<Undoable> list2 = this.mUndoActions;
                list2.get(list2.size() - 1).getTitle();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private boolean isDirectionValid(float f) {
        int i = (Build.VERSION.SDK_INT < 17 || this.mListView.getLayoutDirection() != 1) ? 1 : -1;
        int ordinal = this.mSwipeDirection.ordinal();
        return ordinal != 1 ? ordinal != 2 || ((float) i) * f > 0.0f : ((float) i) * f < 0.0f;
    }

    private AbsListView.OnScrollListener makeScrollListener() {
        return new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                SwipeDismissList swipeDismissList = SwipeDismissList.this;
                boolean z = true;
                if (i == 1) {
                    z = false;
                }
                swipeDismissList.setEnabled(z);
            }
        };
    }

    /* access modifiers changed from: private */
    public void performDismiss(final View view, int i) {
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        final int height = view.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.mAnimationTime);
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SwipeDismissList.access$306(SwipeDismissList.this);
                if (SwipeDismissList.this.mDismissAnimationRefCount == 0) {
                    for (PendingDismissData pendingDismissData : SwipeDismissList.this.mPendingDismisses) {
                        if (SwipeDismissList.this.mMode == UndoMode.SINGLE_UNDO) {
                            for (Undoable discard : SwipeDismissList.this.mUndoActions) {
                                discard.discard();
                            }
                            SwipeDismissList.this.mUndoActions.clear();
                        }
                        Undoable onDismiss = SwipeDismissList.this.mCallback.onDismiss(SwipeDismissList.this.mListView, pendingDismissData.position);
                        if (onDismiss != null) {
                            SwipeDismissList.this.mUndoActions.add(onDismiss);
                        }
                        SwipeDismissList.access$908(SwipeDismissList.this);
                    }
                    if (!SwipeDismissList.this.mUndoActions.isEmpty()) {
                        SwipeDismissList.this.changePopupText();
                        SwipeDismissList.this.changeButtonLabel();
                        if (!SwipeDismissList.this.mTouchBeforeAutoHide) {
                            SwipeDismissList.this.mHandler.sendMessageDelayed(SwipeDismissList.this.mHandler.obtainMessage(SwipeDismissList.this.mDelayedMsgId), (long) SwipeDismissList.this.mAutoHideDelay);
                        }
                    }
                    for (PendingDismissData pendingDismissData2 : SwipeDismissList.this.mPendingDismisses) {
                        ViewHelper.setAlpha(pendingDismissData2.view, 1.0f);
                        ViewHelper.setTranslationX(pendingDismissData2.view, 0.0f);
                        ViewGroup.LayoutParams layoutParams = pendingDismissData2.view.getLayoutParams();
                        layoutParams.height = height;
                        pendingDismissData2.view.setLayoutParams(layoutParams);
                    }
                    SwipeDismissList.this.mPendingDismisses.clear();
                }
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                view.setLayoutParams(layoutParams);
            }
        });
        this.mPendingDismisses.add(new PendingDismissData(i, view));
        duration.start();
    }

    /* access modifiers changed from: private */
    public void setEnabled(boolean z) {
        this.mPaused = !z;
    }

    public void discardUndo() {
        for (Undoable discard : this.mUndoActions) {
            discard.discard();
        }
        this.mUndoActions.clear();
        this.mUndoPopup.dismiss();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cf, code lost:
        if (r0 > 0.0f) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d3, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010c, code lost:
        if (r8.mVelocityTracker.getXVelocity() > 0.0f) goto L_0x00d1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
            r8 = this;
            boolean r0 = r8.mSwipeDisabled
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r8.mViewWidth
            r2 = 2
            if (r0 >= r2) goto L_0x0013
            android.widget.AbsListView r0 = r8.mListView
            int r0 = r0.getWidth()
            r8.mViewWidth = r0
        L_0x0013:
            int r0 = r10.getActionMasked()
            r3 = 1
            if (r0 == 0) goto L_0x0164
            r9 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == r3) goto L_0x0090
            if (r0 == r2) goto L_0x0023
            goto L_0x0163
        L_0x0023:
            android.view.VelocityTracker r0 = r8.mVelocityTracker
            if (r0 == 0) goto L_0x0163
            boolean r2 = r8.mPaused
            if (r2 == 0) goto L_0x002d
            goto L_0x0163
        L_0x002d:
            r0.addMovement(r10)
            float r0 = r10.getRawX()
            float r2 = r8.mDownX
            float r0 = r0 - r2
            boolean r2 = r8.isDirectionValid(r0)
            if (r2 == 0) goto L_0x0064
            float r2 = java.lang.Math.abs(r0)
            int r5 = r8.mSlop
            float r5 = (float) r5
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x006b
            r8.mSwiping = r3
            android.widget.AbsListView r2 = r8.mListView
            r2.requestDisallowInterceptTouchEvent(r3)
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r10)
            int r10 = r10.getActionIndex()
            int r10 = r10 << 8
            r10 = r10 | 3
            r2.setAction(r10)
            android.widget.AbsListView r10 = r8.mListView
            r10.onTouchEvent(r2)
            goto L_0x006b
        L_0x0064:
            float r10 = r10.getRawX()
            r8.mDownX = r10
            r0 = 0
        L_0x006b:
            boolean r10 = r8.mSwiping
            if (r10 == 0) goto L_0x0163
            android.view.View r10 = r8.mDownView
            com.nineoldandroids.view.ViewHelper.setTranslationX(r10, r0)
            android.view.View r10 = r8.mDownView
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = java.lang.Math.abs(r0)
            float r0 = r0 * r1
            int r1 = r8.mViewWidth
            float r1 = (float) r1
            float r0 = r0 / r1
            float r0 = r9 - r0
            float r9 = java.lang.Math.min(r9, r0)
            float r9 = java.lang.Math.max(r4, r9)
            com.nineoldandroids.view.ViewHelper.setAlpha(r10, r9)
            return r3
        L_0x0090:
            android.view.VelocityTracker r0 = r8.mVelocityTracker
            if (r0 != 0) goto L_0x0096
            goto L_0x0163
        L_0x0096:
            float r0 = r10.getRawX()
            float r5 = r8.mDownX
            float r0 = r0 - r5
            android.view.VelocityTracker r5 = r8.mVelocityTracker
            r5.addMovement(r10)
            android.view.VelocityTracker r10 = r8.mVelocityTracker
            r5 = 1000(0x3e8, float:1.401E-42)
            r10.computeCurrentVelocity(r5)
            android.view.VelocityTracker r10 = r8.mVelocityTracker
            float r10 = r10.getXVelocity()
            float r10 = java.lang.Math.abs(r10)
            android.view.VelocityTracker r5 = r8.mVelocityTracker
            float r5 = r5.getYVelocity()
            float r5 = java.lang.Math.abs(r5)
            float r6 = java.lang.Math.abs(r0)
            int r7 = r8.mViewWidth
            int r7 = r7 / r2
            float r2 = (float) r7
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x00d6
            boolean r2 = r8.mSwiping
            if (r2 == 0) goto L_0x00d6
            int r10 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x00d3
        L_0x00d1:
            r10 = 1
            goto L_0x00d4
        L_0x00d3:
            r10 = 0
        L_0x00d4:
            r0 = 1
            goto L_0x0111
        L_0x00d6:
            int r2 = r8.mMinFlingVelocity
            float r2 = (float) r2
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 > 0) goto L_0x010f
            int r2 = r8.mMaxFlingVelocity
            float r2 = (float) r2
            int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x010f
            int r10 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x010f
            boolean r10 = r8.mSwiping
            if (r10 == 0) goto L_0x010f
            android.view.VelocityTracker r10 = r8.mVelocityTracker
            float r10 = r10.getXVelocity()
            boolean r10 = r8.isDirectionValid(r10)
            if (r10 == 0) goto L_0x010f
            int r10 = r8.mViewWidth
            float r10 = (float) r10
            r2 = 1045220557(0x3e4ccccd, float:0.2)
            float r10 = r10 * r2
            int r10 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r10 < 0) goto L_0x010f
            android.view.VelocityTracker r10 = r8.mVelocityTracker
            float r10 = r10.getXVelocity()
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x00d3
            goto L_0x00d1
        L_0x010f:
            r10 = 0
            r0 = 0
        L_0x0111:
            r2 = 0
            if (r0 == 0) goto L_0x0141
            android.view.View r9 = r8.mDownView
            int r0 = r8.mDownPosition
            int r5 = r8.mDismissAnimationRefCount
            int r5 = r5 + r3
            r8.mDismissAnimationRefCount = r5
            com.nineoldandroids.view.ViewPropertyAnimator r3 = com.nineoldandroids.view.ViewPropertyAnimator.animate(r9)
            if (r10 == 0) goto L_0x0126
            int r10 = r8.mViewWidth
            goto L_0x0129
        L_0x0126:
            int r10 = r8.mViewWidth
            int r10 = -r10
        L_0x0129:
            float r10 = (float) r10
            com.nineoldandroids.view.ViewPropertyAnimator r10 = r3.translationX(r10)
            com.nineoldandroids.view.ViewPropertyAnimator r10 = r10.alpha(r4)
            long r5 = r8.mAnimationTime
            com.nineoldandroids.view.ViewPropertyAnimator r10 = r10.setDuration(r5)
            de.timroes.swipetodismiss.SwipeDismissList$2 r3 = new de.timroes.swipetodismiss.SwipeDismissList$2
            r3.<init>(r9, r0)
            r10.setListener(r3)
            goto L_0x0158
        L_0x0141:
            android.view.View r10 = r8.mDownView
            com.nineoldandroids.view.ViewPropertyAnimator r10 = com.nineoldandroids.view.ViewPropertyAnimator.animate(r10)
            com.nineoldandroids.view.ViewPropertyAnimator r10 = r10.translationX(r4)
            com.nineoldandroids.view.ViewPropertyAnimator r9 = r10.alpha(r9)
            long r5 = r8.mAnimationTime
            com.nineoldandroids.view.ViewPropertyAnimator r9 = r9.setDuration(r5)
            r9.setListener(r2)
        L_0x0158:
            r8.mVelocityTracker = r2
            r8.mDownX = r4
            r8.mDownView = r2
            r9 = -1
            r8.mDownPosition = r9
            r8.mSwiping = r1
        L_0x0163:
            return r1
        L_0x0164:
            boolean r0 = r8.mPaused
            if (r0 == 0) goto L_0x0169
            return r1
        L_0x0169:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.widget.AbsListView r4 = r8.mListView
            int r4 = r4.getChildCount()
            int[] r2 = new int[r2]
            android.widget.AbsListView r5 = r8.mListView
            r5.getLocationOnScreen(r2)
            float r5 = r10.getRawX()
            int r5 = (int) r5
            r6 = r2[r1]
            int r5 = r5 - r6
            float r6 = r10.getRawY()
            int r6 = (int) r6
            r2 = r2[r3]
            int r6 = r6 - r2
        L_0x018b:
            if (r1 >= r4) goto L_0x01a2
            android.widget.AbsListView r2 = r8.mListView
            android.view.View r2 = r2.getChildAt(r1)
            r2.getHitRect(r0)
            boolean r7 = r0.contains(r5, r6)
            if (r7 == 0) goto L_0x019f
            r8.mDownView = r2
            goto L_0x01a2
        L_0x019f:
            int r1 = r1 + 1
            goto L_0x018b
        L_0x01a2:
            android.view.View r0 = r8.mDownView
            if (r0 == 0) goto L_0x01bf
            float r0 = r10.getRawX()
            r8.mDownX = r0
            android.widget.AbsListView r0 = r8.mListView
            android.view.View r1 = r8.mDownView
            int r0 = r0.getPositionForView(r1)
            r8.mDownPosition = r0
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r8.mVelocityTracker = r0
            r0.addMovement(r10)
        L_0x01bf:
            r9.onTouchEvent(r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: de.timroes.swipetodismiss.SwipeDismissList.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setAutoHideDelay(int i) {
        this.mAutoHideDelay = i;
    }

    public void setRequireTouchBeforeDismiss(boolean z) {
        this.mTouchBeforeAutoHide = z;
    }

    public void setSwipeDirection(SwipeDirection swipeDirection) {
        this.mSwipeDirection = swipeDirection;
    }

    public void setSwipeDisabled(boolean z) {
        this.mSwipeDisabled = z;
    }

    public void setUndoMultipleString(String str) {
        this.mDeleteMultipleString = str;
    }

    public void setUndoString(String str) {
        this.mDeleteString = str;
    }
}
