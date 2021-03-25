package a.c.d.j.b.h.a;

import android.animation.TimeInterpolator;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.cuatroochenta.miniland.humidificador.base.widget.circleprogress.CircleProgressView;
import java.lang.ref.WeakReference;

public class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<CircleProgressView> f202a;

    /* renamed from: b  reason: collision with root package name */
    public float f203b;

    /* renamed from: c  reason: collision with root package name */
    public long f204c;

    /* renamed from: d  reason: collision with root package name */
    public long f205d;

    /* renamed from: e  reason: collision with root package name */
    public TimeInterpolator f206e = new DecelerateInterpolator();
    public TimeInterpolator f = new AccelerateDecelerateInterpolator();
    public double g;
    public long h = 0;

    public a(CircleProgressView circleProgressView) {
        super(circleProgressView.getContext().getMainLooper());
        this.f202a = new WeakReference<>(circleProgressView);
    }

    public final boolean a(CircleProgressView circleProgressView) {
        double currentTimeMillis = (double) (System.currentTimeMillis() - this.f204c);
        double d2 = circleProgressView.i;
        Double.isNaN(currentTimeMillis);
        Double.isNaN(currentTimeMillis);
        float f2 = (float) (currentTimeMillis / d2);
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float interpolation = this.f.getInterpolation(f2);
        float f3 = circleProgressView.f3894c;
        circleProgressView.f3892a = a.a.a.a.a.a(circleProgressView.f3893b, f3, interpolation, f3);
        return f2 >= 1.0f;
    }

    public final void b(CircleProgressView circleProgressView, Message message) {
        c cVar = c.END_SPINNING_START_ANIMATING;
        circleProgressView.m = cVar;
        d dVar = circleProgressView.n;
        if (dVar != null) {
            dVar.a(cVar);
        }
        circleProgressView.f3894c = 0.0f;
        circleProgressView.f3893b = ((float[]) message.obj)[1];
        this.f205d = System.currentTimeMillis();
        this.f203b = circleProgressView.f3896e;
        sendEmptyMessageDelayed(4, ((long) circleProgressView.j) - (SystemClock.uptimeMillis() - this.h));
    }

    public final void c(CircleProgressView circleProgressView) {
        c cVar = c.SPINNING;
        circleProgressView.m = cVar;
        d dVar = circleProgressView.n;
        if (dVar != null) {
            dVar.a(cVar);
        }
        float f2 = (360.0f / circleProgressView.f3895d) * circleProgressView.f3892a;
        circleProgressView.f3896e = f2;
        circleProgressView.g = f2;
        this.f205d = System.currentTimeMillis();
        this.f203b = circleProgressView.f3896e;
        int i = circleProgressView.j;
        this.g = (double) ((circleProgressView.f / circleProgressView.h) * ((float) i) * 2.0f);
        sendEmptyMessageDelayed(4, ((long) i) - (SystemClock.uptimeMillis() - this.h));
    }

    public final void d(CircleProgressView circleProgressView) {
        this.g = (double) ((circleProgressView.f3896e / circleProgressView.h) * ((float) circleProgressView.j) * 2.0f);
        this.f205d = System.currentTimeMillis();
        this.f203b = circleProgressView.f3896e;
    }

    public final void e(Message message, CircleProgressView circleProgressView) {
        circleProgressView.f3894c = circleProgressView.f3893b;
        float f2 = ((float[]) message.obj)[0];
        circleProgressView.f3893b = f2;
        circleProgressView.f3892a = f2;
        c cVar = c.IDLE;
        circleProgressView.m = cVar;
        d dVar = circleProgressView.n;
        if (dVar != null) {
            dVar.a(cVar);
        }
        circleProgressView.invalidate();
    }

    public void handleMessage(Message message) {
        float f2;
        c cVar = c.IDLE;
        c cVar2 = c.ANIMATING;
        CircleProgressView circleProgressView = (CircleProgressView) this.f202a.get();
        if (circleProgressView != null) {
            b bVar = b.values()[message.what];
            if (bVar == b.TICK) {
                removeMessages(4);
            }
            this.h = SystemClock.uptimeMillis();
            int ordinal = circleProgressView.m.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        int ordinal2 = bVar.ordinal();
                        if (ordinal2 == 0) {
                            c cVar3 = c.SPINNING;
                            circleProgressView.m = cVar3;
                            d dVar = circleProgressView.n;
                            if (dVar != null) {
                                dVar.a(cVar3);
                            }
                        } else if (ordinal2 != 2) {
                            if (ordinal2 != 3) {
                                if (ordinal2 == 4) {
                                    double currentTimeMillis = (double) (System.currentTimeMillis() - this.f205d);
                                    double d2 = this.g;
                                    Double.isNaN(currentTimeMillis);
                                    float f3 = (float) (currentTimeMillis / d2);
                                    if (f3 > 1.0f) {
                                        f3 = 1.0f;
                                    }
                                    float interpolation = (1.0f - this.f206e.getInterpolation(f3)) * this.f203b;
                                    circleProgressView.f3896e = interpolation;
                                    circleProgressView.g += circleProgressView.h;
                                    if (interpolation < 0.01f) {
                                        circleProgressView.m = cVar;
                                        d dVar2 = circleProgressView.n;
                                        if (dVar2 != null) {
                                            dVar2.a(cVar);
                                        }
                                    }
                                } else {
                                    return;
                                }
                            }
                            b(circleProgressView, message);
                            return;
                        }
                    } else if (ordinal == 3) {
                        int ordinal3 = bVar.ordinal();
                        if (ordinal3 == 0) {
                            circleProgressView.k = false;
                            c(circleProgressView);
                            return;
                        } else if (ordinal3 == 2) {
                            circleProgressView.k = false;
                        } else if (ordinal3 == 3) {
                            circleProgressView.f3894c = 0.0f;
                            circleProgressView.f3893b = ((float[]) message.obj)[1];
                        } else if (ordinal3 == 4) {
                            if (circleProgressView.f3896e > circleProgressView.f && !circleProgressView.k) {
                                double currentTimeMillis2 = (double) (System.currentTimeMillis() - this.f205d);
                                double d3 = this.g;
                                Double.isNaN(currentTimeMillis2);
                                float f4 = (float) (currentTimeMillis2 / d3);
                                if (f4 > 1.0f) {
                                    f4 = 1.0f;
                                }
                                circleProgressView.f3896e = (1.0f - this.f206e.getInterpolation(f4)) * this.f203b;
                            }
                            float f5 = circleProgressView.g + circleProgressView.h;
                            circleProgressView.g = f5;
                            if (f5 > 360.0f && !circleProgressView.k) {
                                this.f204c = System.currentTimeMillis();
                                circleProgressView.k = true;
                                d(circleProgressView);
                                d dVar3 = circleProgressView.n;
                                if (dVar3 != null) {
                                    dVar3.a(c.START_ANIMATING_AFTER_SPINNING);
                                }
                            }
                            if (circleProgressView.k) {
                                circleProgressView.g = 360.0f;
                                circleProgressView.f3896e -= circleProgressView.h;
                                a(circleProgressView);
                                double currentTimeMillis3 = (double) (System.currentTimeMillis() - this.f205d);
                                double d4 = this.g;
                                Double.isNaN(currentTimeMillis3);
                                float f6 = (float) (currentTimeMillis3 / d4);
                                if (f6 > 1.0f) {
                                    f6 = 1.0f;
                                }
                                circleProgressView.f3896e = (1.0f - this.f206e.getInterpolation(f6)) * this.f203b;
                            }
                            if (((double) circleProgressView.f3896e) < 0.1d) {
                                circleProgressView.m = cVar2;
                                d dVar4 = circleProgressView.n;
                                if (dVar4 != null) {
                                    dVar4.a(cVar2);
                                }
                                circleProgressView.invalidate();
                                circleProgressView.k = false;
                                circleProgressView.f3896e = circleProgressView.f;
                            } else {
                                circleProgressView.invalidate();
                            }
                        } else {
                            return;
                        }
                    } else if (ordinal == 5) {
                        int ordinal4 = bVar.ordinal();
                        if (ordinal4 != 0) {
                            if (ordinal4 != 2) {
                                if (ordinal4 == 3) {
                                    this.f204c = System.currentTimeMillis();
                                    circleProgressView.f3894c = circleProgressView.f3892a;
                                    circleProgressView.f3893b = ((float[]) message.obj)[1];
                                    return;
                                } else if (ordinal4 == 4) {
                                    if (a(circleProgressView)) {
                                        circleProgressView.m = cVar;
                                        d dVar5 = circleProgressView.n;
                                        if (dVar5 != null) {
                                            dVar5.a(cVar);
                                        }
                                        circleProgressView.f3892a = circleProgressView.f3893b;
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                        c(circleProgressView);
                        return;
                    } else {
                        return;
                    }
                    sendEmptyMessageDelayed(4, ((long) circleProgressView.j) - (SystemClock.uptimeMillis() - this.h));
                    return;
                }
                int ordinal5 = bVar.ordinal();
                if (ordinal5 == 1) {
                    circleProgressView.m = c.END_SPINNING;
                    d(circleProgressView);
                    d dVar6 = circleProgressView.n;
                    if (dVar6 != null) {
                        dVar6.a(circleProgressView.m);
                    }
                    sendEmptyMessageDelayed(4, ((long) circleProgressView.j) - (SystemClock.uptimeMillis() - this.h));
                    return;
                } else if (ordinal5 != 2) {
                    if (ordinal5 != 3) {
                        if (ordinal5 == 4) {
                            float f7 = circleProgressView.f3896e - circleProgressView.f;
                            double currentTimeMillis4 = (double) (System.currentTimeMillis() - this.f205d);
                            double d5 = this.g;
                            Double.isNaN(currentTimeMillis4);
                            float f8 = (float) (currentTimeMillis4 / d5);
                            if (f8 > 1.0f) {
                                f8 = 1.0f;
                            }
                            float interpolation2 = this.f206e.getInterpolation(f8);
                            if (Math.abs(f7) < 1.0f) {
                                f2 = circleProgressView.f;
                            } else {
                                float f9 = circleProgressView.f3896e;
                                float f10 = circleProgressView.f;
                                if (f9 < f10) {
                                    float f11 = this.f203b;
                                    f2 = a.a.a.a.a.a(f10, f11, interpolation2, f11);
                                } else {
                                    float f12 = this.f203b;
                                    f2 = f12 - ((f12 - f10) * interpolation2);
                                }
                            }
                            circleProgressView.f3896e = f2;
                            float f13 = circleProgressView.g + circleProgressView.h;
                            circleProgressView.g = f13;
                            if (f13 > 360.0f) {
                                circleProgressView.g = 0.0f;
                            }
                        } else {
                            return;
                        }
                    }
                    b(circleProgressView, message);
                    return;
                }
                sendEmptyMessageDelayed(4, ((long) circleProgressView.j) - (SystemClock.uptimeMillis() - this.h));
                circleProgressView.invalidate();
                return;
            }
            int ordinal6 = bVar.ordinal();
            if (ordinal6 != 0) {
                if (ordinal6 != 2) {
                    if (ordinal6 == 3) {
                        float[] fArr = (float[]) message.obj;
                        circleProgressView.f3894c = fArr[0];
                        circleProgressView.f3893b = fArr[1];
                        this.f204c = System.currentTimeMillis();
                        circleProgressView.m = cVar2;
                        d dVar7 = circleProgressView.n;
                        if (dVar7 != null) {
                            dVar7.a(cVar2);
                        }
                        sendEmptyMessageDelayed(4, ((long) circleProgressView.j) - (SystemClock.uptimeMillis() - this.h));
                        return;
                    } else if (ordinal6 == 4) {
                        removeMessages(4);
                        return;
                    } else {
                        return;
                    }
                }
            }
            c(circleProgressView);
            return;
            e(message, circleProgressView);
        }
    }
}
