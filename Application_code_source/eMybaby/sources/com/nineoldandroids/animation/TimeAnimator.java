package com.nineoldandroids.animation;

public class TimeAnimator extends ValueAnimator {
    public TimeListener mListener;
    public long mPreviousTime = -1;

    public interface TimeListener {
        void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2);
    }

    public void animateValue(float f) {
    }

    public boolean animationFrame(long j) {
        long j2 = 0;
        if (this.mPlayingState == 0) {
            this.mPlayingState = 1;
            long j3 = this.mSeekTime;
            if (j3 < 0) {
                this.mStartTime = j;
            } else {
                this.mStartTime = j - j3;
                this.mSeekTime = -1;
            }
        }
        if (this.mListener == null) {
            return false;
        }
        long j4 = j - this.mStartTime;
        long j5 = this.mPreviousTime;
        if (j5 >= 0) {
            j2 = j - j5;
        }
        this.mPreviousTime = j;
        this.mListener.onTimeUpdate(this, j4, j2);
        return false;
    }

    public void initAnimation() {
    }

    public void setTimeListener(TimeListener timeListener) {
        this.mListener = timeListener;
    }
}
