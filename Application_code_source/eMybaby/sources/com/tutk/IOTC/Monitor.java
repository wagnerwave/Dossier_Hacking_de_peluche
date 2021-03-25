package com.tutk.IOTC;

import a.a.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tutk.IOTC.AVIOCTRLDEFs;
import java.io.PrintStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressLint({"NewApi"})
public class Monitor extends SurfaceView implements SurfaceHolder.Callback, IRegisterIOTCListener, View.OnTouchListener, GestureDetector.OnGestureListener {
    public static final float DEFAULT_MAX_ZOOM_SCALE = 2.0f;
    public static final int DRAG = 1;
    public static final int FLING_MIN_DISTANCE = 100;
    public static final int FLING_MIN_VELOCITY = 0;
    public static final int NONE = 0;
    public static final int PTZ_DELAY = 1500;
    public static final int PTZ_SPEED = 8;
    public static final int ZOOM = 2;
    public int mAVChannel = -1;
    public Camera mCamera;
    public int mCurVideoHeight = 0;
    public int mCurVideoWidth = 0;
    public float mCurrentMaxScale = 2.0f;
    public float mCurrentScale = 1.0f;
    public GestureDetector mGestureDetector;
    public Bitmap mLastFrame;
    public Lock mLastFrameLock = new ReentrantLock();
    public long mLastZoomTime;
    public PointF mMidPoint = new PointF();
    public PointF mMidPointForCanvas = new PointF();
    public float mOrigDist = 0.0f;
    public int mPinchedMode = 0;
    public Rect mRectCanvas = new Rect();
    public Rect mRectMonitor = new Rect();
    public PointF mStartPoint = new PointF();
    public SurfaceHolder mSurHolder = null;
    public ThreadRender mThreadRender = null;
    public int vBottom;
    public int vLeft;
    public int vRight;
    public int vTop;

    public class ThreadRender extends Thread {
        public boolean mIsRunningThread;
        public Object mWaitObjectForStopThread;

        public ThreadRender() {
            this.mIsRunningThread = false;
            this.mWaitObjectForStopThread = new Object();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
            if (r1 != null) goto L_0x0041;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
            com.tutk.IOTC.Monitor.access$400(r5.this$0).unlockCanvasAndPost(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
            if (r1 == null) goto L_0x0067;
         */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x005d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                r0 = 1
                r5.mIsRunningThread = r0
            L_0x0003:
                boolean r0 = r5.mIsRunningThread
                if (r0 == 0) goto L_0x007b
                com.tutk.IOTC.Monitor r0 = com.tutk.IOTC.Monitor.this
                android.graphics.Bitmap r0 = r0.mLastFrame
                if (r0 == 0) goto L_0x0067
                com.tutk.IOTC.Monitor r0 = com.tutk.IOTC.Monitor.this
                android.graphics.Bitmap r0 = r0.mLastFrame
                boolean r0 = r0.isRecycled()
                if (r0 != 0) goto L_0x0067
                r0 = 0
                com.tutk.IOTC.Monitor r1 = com.tutk.IOTC.Monitor.this     // Catch:{ Exception -> 0x0050, all -> 0x004b }
                android.view.SurfaceHolder r1 = r1.mSurHolder     // Catch:{ Exception -> 0x0050, all -> 0x004b }
                android.graphics.Canvas r1 = r1.lockCanvas()     // Catch:{ Exception -> 0x0050, all -> 0x004b }
                if (r1 == 0) goto L_0x003f
                r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                r1.drawColor(r2)     // Catch:{ Exception -> 0x003d }
                com.tutk.IOTC.Monitor r2 = com.tutk.IOTC.Monitor.this     // Catch:{ Exception -> 0x003d }
                android.graphics.Bitmap r2 = r2.mLastFrame     // Catch:{ Exception -> 0x003d }
                com.tutk.IOTC.Monitor r3 = com.tutk.IOTC.Monitor.this     // Catch:{ Exception -> 0x003d }
                android.graphics.Rect r3 = r3.mRectCanvas     // Catch:{ Exception -> 0x003d }
                r1.drawBitmap(r2, r0, r3, r0)     // Catch:{ Exception -> 0x003d }
                goto L_0x003f
            L_0x003d:
                r0 = move-exception
                goto L_0x0054
            L_0x003f:
                if (r1 == 0) goto L_0x0067
            L_0x0041:
                com.tutk.IOTC.Monitor r0 = com.tutk.IOTC.Monitor.this
                android.view.SurfaceHolder r0 = r0.mSurHolder
                r0.unlockCanvasAndPost(r1)
                goto L_0x0067
            L_0x004b:
                r1 = move-exception
                r4 = r1
                r1 = r0
                r0 = r4
                goto L_0x005b
            L_0x0050:
                r1 = move-exception
                r4 = r1
                r1 = r0
                r0 = r4
            L_0x0054:
                r0.printStackTrace()     // Catch:{ all -> 0x005a }
                if (r1 == 0) goto L_0x0067
                goto L_0x0041
            L_0x005a:
                r0 = move-exception
            L_0x005b:
                if (r1 == 0) goto L_0x0066
                com.tutk.IOTC.Monitor r2 = com.tutk.IOTC.Monitor.this
                android.view.SurfaceHolder r2 = r2.mSurHolder
                r2.unlockCanvasAndPost(r1)
            L_0x0066:
                throw r0
            L_0x0067:
                java.lang.Object r0 = r5.mWaitObjectForStopThread     // Catch:{ InterruptedException -> 0x0076 }
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0076 }
                java.lang.Object r1 = r5.mWaitObjectForStopThread     // Catch:{ all -> 0x0073 }
                r2 = 33
                r1.wait(r2)     // Catch:{ all -> 0x0073 }
                monitor-exit(r0)     // Catch:{ all -> 0x0073 }
                goto L_0x0003
            L_0x0073:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0073 }
                throw r1     // Catch:{ InterruptedException -> 0x0076 }
            L_0x0076:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0003
            L_0x007b:
                java.io.PrintStream r0 = java.lang.System.out
                java.lang.String r1 = "===ThreadRender exit==="
                r0.println(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tutk.IOTC.Monitor.ThreadRender.run():void");
        }

        public void stopThread() {
            this.mIsRunningThread = false;
            try {
                this.mWaitObjectForStopThread.notify();
            } catch (Exception unused) {
            }
        }
    }

    public Monitor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SurfaceHolder holder = getHolder();
        this.mSurHolder = holder;
        holder.addCallback(this);
        this.mGestureDetector = new GestureDetector(this);
        setOnTouchListener(this);
        setLongClickable(true);
    }

    private void parseMidPoint(PointF pointF, float f, float f2, float f3, float f4) {
        pointF.set((f + f3) / 2.0f, (f2 + f4) / 2.0f);
    }

    @SuppressLint({"FloatMath"})
    private float spacing(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((y * y) + (x * x)));
    }

    public void attachCamera(Camera camera, int i) {
        this.mCamera = camera;
        camera.registerIOTCListener(this);
        this.mAVChannel = i;
        if (this.mThreadRender == null) {
            ThreadRender threadRender = new ThreadRender();
            this.mThreadRender = threadRender;
            threadRender.start();
        }
    }

    public void deattachCamera() {
        this.mAVChannel = -1;
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.unregisterIOTCListener(this);
            this.mCamera = null;
        }
        ThreadRender threadRender = this.mThreadRender;
        if (threadRender != null) {
            threadRender.stopThread();
            try {
                this.mThreadRender.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.mThreadRender = null;
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Camera camera;
        int i;
        int i2;
        int i3;
        int i4;
        Rect rect = this.mRectCanvas;
        if (rect.left == this.vLeft && rect.top == this.vTop && rect.right == this.vRight && rect.bottom == this.vBottom) {
            PrintStream printStream = System.out;
            StringBuilder n = a.n("velocityX: ");
            n.append(Math.abs(f));
            n.append(", velocityY: ");
            n.append(Math.abs(f2));
            printStream.println(n.toString());
            if (motionEvent.getX() - motionEvent2.getX() > 100.0f && Math.abs(f) > 0.0f) {
                Camera camera2 = this.mCamera;
                if (camera2 != null && (i4 = this.mAVChannel) >= 0) {
                    camera2.sendIOCtrl(i4, 4097, AVIOCTRLDEFs.SMsgAVIoctrlPtzCmd.parseContent((byte) 6, (byte) 8, (byte) 0, (byte) 0, (byte) 0, (byte) 0));
                }
            } else if (motionEvent2.getX() - motionEvent.getX() > 100.0f && Math.abs(f) > 0.0f) {
                Camera camera3 = this.mCamera;
                if (camera3 != null && (i3 = this.mAVChannel) >= 0) {
                    camera3.sendIOCtrl(i3, 4097, AVIOCTRLDEFs.SMsgAVIoctrlPtzCmd.parseContent((byte) 3, (byte) 8, (byte) 0, (byte) 0, (byte) 0, (byte) 0));
                }
            } else if (motionEvent.getY() - motionEvent2.getY() > 100.0f && Math.abs(f2) > 0.0f) {
                Camera camera4 = this.mCamera;
                if (camera4 != null && (i2 = this.mAVChannel) >= 0) {
                    camera4.sendIOCtrl(i2, 4097, AVIOCTRLDEFs.SMsgAVIoctrlPtzCmd.parseContent((byte) 2, (byte) 8, (byte) 0, (byte) 0, (byte) 0, (byte) 0));
                }
            } else if (motionEvent2.getY() - motionEvent.getY() > 100.0f && Math.abs(f2) > 0.0f && (camera = this.mCamera) != null && (i = this.mAVChannel) >= 0) {
                camera.sendIOCtrl(i, 4097, AVIOCTRLDEFs.SMsgAVIoctrlPtzCmd.parseContent((byte) 1, (byte) 8, (byte) 0, (byte) 0, (byte) 0, (byte) 0));
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (Monitor.this.mCamera != null && Monitor.this.mAVChannel >= 0) {
                        Monitor.this.mCamera.sendIOCtrl(Monitor.this.mAVChannel, 4097, AVIOCTRLDEFs.SMsgAVIoctrlPtzCmd.parseContent((byte) 0, (byte) 8, (byte) 0, (byte) 0, (byte) 0, (byte) 0));
                    }
                }
            }, 1500);
        }
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @SuppressLint({"NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.mGestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0 || action == 1) {
            return false;
        }
        if (action == 2) {
            int i = this.mPinchedMode;
            if (i == 1) {
                if (System.currentTimeMillis() - this.mLastZoomTime < 33) {
                    return true;
                }
                PointF pointF = new PointF();
                pointF.set(motionEvent.getX(), motionEvent.getY());
                PointF pointF2 = this.mStartPoint;
                int i2 = ((int) pointF.x) - ((int) pointF2.x);
                int i3 = ((int) pointF.y) - ((int) pointF2.y);
                this.mStartPoint = pointF;
                Rect rect = new Rect();
                rect.set(this.mRectCanvas);
                rect.offset(i2, i3);
                int i4 = rect.right;
                int i5 = rect.left;
                int i6 = i4 - i5;
                int i7 = rect.bottom - rect.top;
                Rect rect2 = this.mRectMonitor;
                int i8 = rect2.bottom - rect2.top;
                int i9 = rect2.right;
                int i10 = rect2.left;
                if (i8 > i9 - i10) {
                    if (i5 > i10) {
                        rect.left = i10;
                        rect.right = i10 + i6;
                    }
                    if (rect.top > this.mRectMonitor.top) {
                        int i11 = this.mRectCanvas.top;
                        rect.top = i11;
                        rect.bottom = i11 + i7;
                    }
                    int i12 = rect.right;
                    int i13 = this.mRectMonitor.right;
                    if (i12 < i13) {
                        rect.right = i13;
                        rect.left = i13 - i6;
                    }
                    if (rect.bottom < this.mRectMonitor.bottom) {
                        int i14 = this.mRectCanvas.bottom;
                        rect.bottom = i14;
                        rect.top = i14 - i7;
                    }
                } else {
                    if (i5 > i10) {
                        int i15 = this.mRectCanvas.left;
                        rect.left = i15;
                        rect.right = i15 + i6;
                    }
                    int i16 = rect.top;
                    int i17 = this.mRectMonitor.top;
                    if (i16 > i17) {
                        rect.top = i17;
                        rect.bottom = i17 + i7;
                    }
                    if (rect.right < this.mRectMonitor.right) {
                        int i18 = this.mRectCanvas.right;
                        rect.right = i18;
                        rect.left = i18 - i6;
                    }
                    int i19 = rect.bottom;
                    int i20 = this.mRectMonitor.bottom;
                    if (i19 < i20) {
                        rect.bottom = i20;
                        rect.top = i20 - i7;
                    }
                }
                PrintStream printStream = System.out;
                printStream.println("offset (" + i2 + ", " + i3 + "), after offset rect = (" + rect.left + ", " + rect.top + ", " + rect.right + ", " + rect.bottom + ")");
                this.mRectCanvas.set(rect);
            } else if (i != 2 || System.currentTimeMillis() - this.mLastZoomTime < 33 || motionEvent.getPointerCount() == 1) {
                return true;
            } else {
                float spacing = spacing(motionEvent);
                float f = spacing / this.mOrigDist;
                float f2 = this.mCurrentScale * f;
                this.mCurrentScale = f2;
                this.mOrigDist = spacing;
                float f3 = this.mCurrentMaxScale;
                if (f2 > f3) {
                    this.mCurrentScale = f3;
                    return true;
                }
                if (f2 < 1.0f) {
                    this.mCurrentScale = 1.0f;
                }
                PrintStream printStream2 = System.out;
                printStream2.println("newDist(" + spacing + ") / origDist(" + this.mOrigDist + ") = zoom scale(" + this.mCurrentScale + ")");
                int i21 = this.vRight;
                int i22 = this.vLeft;
                int i23 = (i21 - i22) * 3;
                int i24 = this.vBottom;
                int i25 = this.vTop;
                int i26 = (i24 - i25) * 3;
                float f4 = this.mCurrentScale;
                int i27 = (int) (((float) (i21 - i22)) * f4);
                int i28 = (int) (((float) (i24 - i25)) * f4);
                int i29 = i21 - i22;
                int i30 = i24 - i25;
                int width = (int) (((float) (this.mRectMonitor.width() / 2)) - (((float) ((this.mRectMonitor.width() / 2) - this.mRectCanvas.left)) * f));
                int height = (int) (((float) (this.mRectMonitor.height() / 2)) - (((float) ((this.mRectMonitor.height() / 2) - this.mRectCanvas.top)) * f));
                int i31 = width + i27;
                int i32 = height + i28;
                if (i27 <= i29 || i28 <= i30) {
                    width = this.vLeft;
                    height = this.vTop;
                    i31 = this.vRight;
                    i32 = this.vBottom;
                } else if (i27 >= i23 || i28 >= i26) {
                    Rect rect3 = this.mRectCanvas;
                    width = rect3.left;
                    height = rect3.top;
                    i31 = width + i23;
                    i32 = height + i26;
                }
                this.mRectCanvas.set(width, height, i31, i32);
                PrintStream printStream3 = System.out;
                printStream3.println("zoom -> l: " + width + ", t: " + height + ", r: " + i31 + ", b: " + i32 + ",  width: " + i27 + ", height: " + i28);
                this.mLastZoomTime = System.currentTimeMillis();
            }
        } else if (action == 5) {
            float spacing2 = spacing(motionEvent);
            if (spacing2 > 10.0f) {
                this.mPinchedMode = 2;
                this.mOrigDist = spacing2;
                PrintStream printStream4 = System.out;
                StringBuilder n = a.n("Action_Pointer_Down -> origDist(");
                n.append(this.mOrigDist);
                n.append(")");
                printStream4.println(n.toString());
            }
        } else if (action == 6 && this.mCurrentScale == 1.0f) {
            this.mPinchedMode = 0;
        }
        return true;
    }

    public void receiveChannelInfo(Camera camera, int i, int i2) {
    }

    public void receiveFrameData(Camera camera, int i, Bitmap bitmap) {
        if (this.mAVChannel == i) {
            this.mLastFrame = bitmap;
            if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                if (bitmap.getWidth() != this.mCurVideoWidth || bitmap.getHeight() != this.mCurVideoHeight) {
                    this.mCurVideoWidth = bitmap.getWidth();
                    this.mCurVideoHeight = bitmap.getHeight();
                    Rect rect = this.mRectCanvas;
                    Rect rect2 = this.mRectMonitor;
                    rect.set(0, 0, rect2.right, rect2.bottom);
                    Rect rect3 = this.mRectMonitor;
                    if (rect3.bottom - rect3.top < rect3.right - rect3.left) {
                        Log.i("IOTCamera", "Landscape layout");
                        double d2 = (double) this.mCurVideoWidth;
                        double d3 = (double) this.mCurVideoHeight;
                        Double.isNaN(d2);
                        Double.isNaN(d3);
                        double d4 = d2 / d3;
                        Rect rect4 = this.mRectCanvas;
                        Rect rect5 = this.mRectMonitor;
                        double d5 = (double) rect5.bottom;
                        Double.isNaN(d5);
                        int i2 = (int) (d5 * d4);
                        rect4.right = i2;
                        rect4.offset((rect5.right - i2) / 2, 0);
                    } else {
                        Log.i("IOTCamera", "Portrait layout");
                        double d6 = (double) this.mCurVideoWidth;
                        double d7 = (double) this.mCurVideoHeight;
                        Double.isNaN(d6);
                        Double.isNaN(d7);
                        double d8 = d6 / d7;
                        Rect rect6 = this.mRectCanvas;
                        Rect rect7 = this.mRectMonitor;
                        double d9 = (double) rect7.right;
                        Double.isNaN(d9);
                        int i3 = (int) (d9 / d8);
                        rect6.bottom = i3;
                        rect6.offset(0, (rect7.bottom - i3) / 2);
                    }
                    Rect rect8 = this.mRectCanvas;
                    int i4 = rect8.left;
                    this.vLeft = i4;
                    int i5 = rect8.top;
                    this.vTop = i5;
                    int i6 = rect8.right;
                    this.vRight = i6;
                    int i7 = rect8.bottom;
                    this.vBottom = i7;
                    this.mCurrentScale = 1.0f;
                    parseMidPoint(this.mMidPoint, (float) i4, (float) i5, (float) i6, (float) i7);
                    parseMidPoint(this.mMidPointForCanvas, (float) this.vLeft, (float) this.vTop, (float) this.vRight, (float) this.vBottom);
                    StringBuilder n = a.n("Change canvas size (");
                    Rect rect9 = this.mRectCanvas;
                    n.append(rect9.right - rect9.left);
                    n.append(", ");
                    Rect rect10 = this.mRectCanvas;
                    n.append(rect10.bottom - rect10.top);
                    n.append(")");
                    Log.i("IOTCamera", n.toString());
                }
            }
        }
    }

    public void receiveFrameInfo(Camera camera, int i, long j, int i2, int i3, int i4, int i5) {
    }

    public void receiveIOCtrlData(Camera camera, int i, int i2, byte[] bArr) {
    }

    public void receiveSessionInfo(Camera camera, int i) {
    }

    public void setMaxZoom(float f) {
        this.mCurrentMaxScale = f;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Rect rect;
        int i4;
        synchronized (this) {
            this.mRectMonitor.set(0, 0, i2, i3);
            this.mRectCanvas.set(0, 0, i2, i3);
            if (this.mCurVideoWidth != 0) {
                if (this.mCurVideoHeight != 0) {
                    if (this.mRectMonitor.bottom - this.mRectMonitor.top < this.mRectMonitor.right - this.mRectMonitor.left) {
                        Log.i("IOTCamera", "Landscape layout");
                        double d2 = (double) this.mCurVideoWidth;
                        double d3 = (double) this.mCurVideoHeight;
                        Double.isNaN(d2);
                        Double.isNaN(d3);
                        double d4 = d2 / d3;
                        Rect rect2 = this.mRectCanvas;
                        double d5 = (double) this.mRectMonitor.bottom;
                        Double.isNaN(d5);
                        rect2.right = (int) (d5 * d4);
                        this.mRectCanvas.offset((this.mRectMonitor.right - this.mRectCanvas.right) / 2, 0);
                        int i5 = this.mRectCanvas.left;
                        this.vLeft = i5;
                        int i6 = this.mRectCanvas.top;
                        this.vTop = i6;
                        int i7 = this.mRectCanvas.right;
                        this.vRight = i7;
                        int i8 = this.mRectCanvas.bottom;
                        this.vBottom = i8;
                        this.mCurrentScale = 1.0f;
                        parseMidPoint(this.mMidPoint, (float) i5, (float) i6, (float) i7, (float) i8);
                        parseMidPoint(this.mMidPointForCanvas, (float) this.vLeft, (float) this.vTop, (float) this.vRight, (float) this.vBottom);
                    } else {
                        Log.i("IOTCamera", "Portrait layout");
                        double d6 = (double) this.mCurVideoWidth;
                        double d7 = (double) this.mCurVideoHeight;
                        Double.isNaN(d6);
                        Double.isNaN(d7);
                        double d8 = d6 / d7;
                        Rect rect3 = this.mRectCanvas;
                        double d9 = (double) this.mRectMonitor.right;
                        Double.isNaN(d9);
                        rect3.bottom = (int) (d9 / d8);
                        rect = this.mRectCanvas;
                        i4 = (this.mRectMonitor.bottom - this.mRectCanvas.bottom) / 2;
                        rect.offset(0, i4);
                        int i52 = this.mRectCanvas.left;
                        this.vLeft = i52;
                        int i62 = this.mRectCanvas.top;
                        this.vTop = i62;
                        int i72 = this.mRectCanvas.right;
                        this.vRight = i72;
                        int i82 = this.mRectCanvas.bottom;
                        this.vBottom = i82;
                        this.mCurrentScale = 1.0f;
                        parseMidPoint(this.mMidPoint, (float) i52, (float) i62, (float) i72, (float) i82);
                        parseMidPoint(this.mMidPointForCanvas, (float) this.vLeft, (float) this.vTop, (float) this.vRight, (float) this.vBottom);
                    }
                }
            }
            if (i3 < i2) {
                this.mRectCanvas.right = (i3 * 4) / 3;
                this.mRectCanvas.offset((i2 - this.mRectCanvas.right) / 2, 0);
                int i522 = this.mRectCanvas.left;
                this.vLeft = i522;
                int i622 = this.mRectCanvas.top;
                this.vTop = i622;
                int i722 = this.mRectCanvas.right;
                this.vRight = i722;
                int i822 = this.mRectCanvas.bottom;
                this.vBottom = i822;
                this.mCurrentScale = 1.0f;
                parseMidPoint(this.mMidPoint, (float) i522, (float) i622, (float) i722, (float) i822);
                parseMidPoint(this.mMidPointForCanvas, (float) this.vLeft, (float) this.vTop, (float) this.vRight, (float) this.vBottom);
            } else {
                this.mRectCanvas.bottom = (i2 * 3) / 4;
                rect = this.mRectCanvas;
                i4 = (i3 - this.mRectCanvas.bottom) / 2;
                rect.offset(0, i4);
                int i5222 = this.mRectCanvas.left;
                this.vLeft = i5222;
                int i6222 = this.mRectCanvas.top;
                this.vTop = i6222;
                int i7222 = this.mRectCanvas.right;
                this.vRight = i7222;
                int i8222 = this.mRectCanvas.bottom;
                this.vBottom = i8222;
                this.mCurrentScale = 1.0f;
                parseMidPoint(this.mMidPoint, (float) i5222, (float) i6222, (float) i7222, (float) i8222);
                parseMidPoint(this.mMidPointForCanvas, (float) this.vLeft, (float) this.vTop, (float) this.vRight, (float) this.vBottom);
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
