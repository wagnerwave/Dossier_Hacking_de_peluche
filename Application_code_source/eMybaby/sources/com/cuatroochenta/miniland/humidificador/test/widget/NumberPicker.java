package com.cuatroochenta.miniland.humidificador.test.widget;

import a.h.a.g0;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.cuatroochenta.miniland.humidificador.device.DeviceControlActivity;
import com.sozpic.miniland.R;
import com.tutk.IOTC.AVIOCTRLDEFs;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class NumberPicker extends LinearLayout {
    public static final k i0 = new k();
    public static final char[] j0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785};
    public int A = Integer.MIN_VALUE;
    public int B;
    public final Scroller C;
    public final Scroller D;
    public int E;
    public i F;
    public c G;
    public b H;
    public float I;
    public long J;
    public float K;
    public VelocityTracker L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public final int Q;
    public final boolean R;
    public final Drawable S;
    public final int T;
    public int U = 0;
    public boolean V;
    public boolean W;

    /* renamed from: a  reason: collision with root package name */
    public int f3908a = 3;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public int f3909b = 1;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public final ImageButton f3910c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public final ImageButton f3911d;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public final EditText f3912e;
    public boolean e0;
    public final int f;
    public j f0;
    public final int g;
    public final h g0;
    public final int h;
    public int h0 = -1;
    public final int i;
    public int j;
    public final boolean k;
    public final int l;
    public int m;
    public String[] n;
    public int o;
    public int p;
    public int q;
    public g r;
    public f s;
    public d t;
    public long u = 300;
    public final SparseArray<String> v = new SparseArray<>();
    public final int[] w = new int[this.f3908a];
    public final Paint x;
    public final Drawable y;
    public int z;

    @TargetApi(16)
    public class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        public final Rect f3913a = new Rect();

        /* renamed from: b  reason: collision with root package name */
        public final int[] f3914b = new int[2];

        /* renamed from: c  reason: collision with root package name */
        public int f3915c = Integer.MIN_VALUE;

        public a() {
        }

        public final AccessibilityNodeInfo a(int i, String str, int i2, int i3, int i4, int i5) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(Button.class.getName());
            obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
            obtain.setSource(NumberPicker.this, i);
            obtain.setParent(NumberPicker.this);
            obtain.setText(str);
            obtain.setClickable(true);
            obtain.setLongClickable(true);
            obtain.setEnabled(NumberPicker.this.isEnabled());
            Rect rect = this.f3913a;
            rect.set(i2, i3, i4, i5);
            obtain.setBoundsInParent(rect);
            int[] iArr = this.f3914b;
            NumberPicker.this.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            obtain.setBoundsInScreen(rect);
            if (this.f3915c != i) {
                obtain.addAction(64);
            }
            if (this.f3915c == i) {
                obtain.addAction(128);
            }
            if (NumberPicker.this.isEnabled()) {
                obtain.addAction(16);
            }
            return obtain;
        }

        public final void b(String str, int i, List<AccessibilityNodeInfo> list) {
            if (i == 1) {
                String d2 = d();
                if (!TextUtils.isEmpty(d2) && d2.toString().toLowerCase().contains(str)) {
                    list.add(createAccessibilityNodeInfo(1));
                }
            } else if (i == 2) {
                Editable text = NumberPicker.this.f3912e.getText();
                if (TextUtils.isEmpty(text) || !text.toString().toLowerCase().contains(str)) {
                    Editable text2 = NumberPicker.this.f3912e.getText();
                    if (TextUtils.isEmpty(text2) || !text2.toString().toLowerCase().contains(str)) {
                        return;
                    }
                }
                list.add(createAccessibilityNodeInfo(2));
            } else if (i == 3) {
                String c2 = c();
                if (!TextUtils.isEmpty(c2) && c2.toString().toLowerCase().contains(str)) {
                    list.add(createAccessibilityNodeInfo(3));
                }
            }
        }

        public final String c() {
            NumberPicker numberPicker = NumberPicker.this;
            int i = numberPicker.q - 1;
            if (numberPicker.P) {
                i = numberPicker.j(i);
            }
            NumberPicker numberPicker2 = NumberPicker.this;
            int i2 = numberPicker2.o;
            if (i < i2) {
                return null;
            }
            String[] strArr = numberPicker2.n;
            if (strArr == null) {
                return numberPicker2.g(i);
            }
            return strArr[i - i2];
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            if (i == -1) {
                NumberPicker.this.getScrollX();
                NumberPicker.this.getScrollY();
                NumberPicker.this.getScrollX();
                NumberPicker.this.getRight();
                NumberPicker.this.getLeft();
                NumberPicker.this.getScrollY();
                NumberPicker.this.getBottom();
                NumberPicker.this.getTop();
                AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
                obtain.setClassName(NumberPicker.class.getName());
                obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
                obtain.setSource(NumberPicker.this);
                if (e()) {
                    obtain.addChild(NumberPicker.this, 3);
                }
                obtain.addChild(NumberPicker.this, 2);
                if (f()) {
                    obtain.addChild(NumberPicker.this, 1);
                }
                obtain.setParent((View) NumberPicker.this.getParentForAccessibility());
                obtain.setEnabled(NumberPicker.this.isEnabled());
                obtain.setScrollable(true);
                if (this.f3915c != -1) {
                    obtain.addAction(64);
                }
                if (this.f3915c == -1) {
                    obtain.addAction(128);
                }
                if (NumberPicker.this.isEnabled()) {
                    if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue()) {
                        obtain.addAction(4096);
                    }
                    if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue()) {
                        obtain.addAction(8192);
                    }
                }
                return obtain;
            } else if (i == 1) {
                String d2 = d();
                int scrollX = NumberPicker.this.getScrollX();
                NumberPicker numberPicker = NumberPicker.this;
                return a(1, d2, scrollX, numberPicker.b0 - numberPicker.T, (NumberPicker.this.getRight() - NumberPicker.this.getLeft()) + numberPicker.getScrollX(), (NumberPicker.this.getBottom() - NumberPicker.this.getTop()) + NumberPicker.this.getScrollY());
            } else if (i == 2) {
                AccessibilityNodeInfo createAccessibilityNodeInfo = NumberPicker.this.f3912e.createAccessibilityNodeInfo();
                createAccessibilityNodeInfo.setSource(NumberPicker.this, 2);
                if (this.f3915c != 2) {
                    createAccessibilityNodeInfo.addAction(64);
                }
                if (this.f3915c == 2) {
                    createAccessibilityNodeInfo.addAction(128);
                }
                return createAccessibilityNodeInfo;
            } else if (i != 3) {
                return super.createAccessibilityNodeInfo(i);
            } else {
                String c2 = c();
                int scrollX2 = NumberPicker.this.getScrollX();
                int scrollY = NumberPicker.this.getScrollY();
                int right = (NumberPicker.this.getRight() - NumberPicker.this.getLeft()) + NumberPicker.this.getScrollX();
                NumberPicker numberPicker2 = NumberPicker.this;
                return a(3, c2, scrollX2, scrollY, right, numberPicker2.a0 + numberPicker2.T);
            }
        }

        public final String d() {
            NumberPicker numberPicker = NumberPicker.this;
            int i = numberPicker.q + 1;
            if (numberPicker.P) {
                i = numberPicker.j(i);
            }
            NumberPicker numberPicker2 = NumberPicker.this;
            if (i > numberPicker2.p) {
                return null;
            }
            String[] strArr = numberPicker2.n;
            if (strArr == null) {
                return numberPicker2.g(i);
            }
            return strArr[i - numberPicker2.o];
        }

        public final boolean e() {
            return NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue();
        }

        public final boolean f() {
            return NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptyList();
            }
            String lowerCase = str.toLowerCase();
            ArrayList arrayList = new ArrayList();
            if (i == -1) {
                b(lowerCase, 3, arrayList);
                b(lowerCase, 2, arrayList);
                b(lowerCase, 1, arrayList);
                return arrayList;
            } else if (i != 1 && i != 2 && i != 3) {
                return super.findAccessibilityNodeInfosByText(str, i);
            } else {
                b(lowerCase, i, arrayList);
                return arrayList;
            }
        }

        public final void g(int i, int i2, String str) {
            if (((AccessibilityManager) NumberPicker.this.getContext().getSystemService("accessibility")).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
                obtain.setClassName(Button.class.getName());
                obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
                obtain.getText().add(str);
                obtain.setEnabled(NumberPicker.this.isEnabled());
                obtain.setSource(NumberPicker.this, i);
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.requestSendAccessibilityEvent(numberPicker, obtain);
            }
        }

        public void h(int i, int i2) {
            String str;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && e()) {
                        str = c();
                    } else {
                        return;
                    }
                } else if (((AccessibilityManager) NumberPicker.this.getContext().getSystemService("accessibility")).isEnabled()) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
                    NumberPicker.this.f3912e.onInitializeAccessibilityEvent(obtain);
                    NumberPicker.this.f3912e.onPopulateAccessibilityEvent(obtain);
                    obtain.setSource(NumberPicker.this, 2);
                    NumberPicker numberPicker = NumberPicker.this;
                    numberPicker.requestSendAccessibilityEvent(numberPicker, obtain);
                    return;
                } else {
                    return;
                }
            } else if (f()) {
                str = d();
            } else {
                return;
            }
            g(i, i2, str);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            boolean z = false;
            if (i != -1) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            if (i2 != 16) {
                                if (i2 != 64) {
                                    if (i2 != 128 || this.f3915c != i) {
                                        return false;
                                    }
                                    this.f3915c = Integer.MIN_VALUE;
                                    h(i, 65536);
                                    NumberPicker numberPicker = NumberPicker.this;
                                    numberPicker.invalidate(0, 0, numberPicker.getRight(), NumberPicker.this.a0);
                                    return true;
                                } else if (this.f3915c == i) {
                                    return false;
                                } else {
                                    this.f3915c = i;
                                    h(i, 32768);
                                    NumberPicker numberPicker2 = NumberPicker.this;
                                    numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.a0);
                                    return true;
                                }
                            } else if (!NumberPicker.this.isEnabled()) {
                                return false;
                            } else {
                                if (i == 1) {
                                    z = true;
                                }
                                NumberPicker.this.d(z);
                                h(i, 1);
                                return true;
                            }
                        }
                    } else if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 16) {
                                if (i2 != 64) {
                                    if (i2 != 128) {
                                        return NumberPicker.this.f3912e.performAccessibilityAction(i2, bundle);
                                    }
                                    if (this.f3915c != i) {
                                        return false;
                                    }
                                    this.f3915c = Integer.MIN_VALUE;
                                    h(i, 65536);
                                    NumberPicker.this.f3912e.invalidate();
                                    return true;
                                } else if (this.f3915c == i) {
                                    return false;
                                } else {
                                    this.f3915c = i;
                                    h(i, 32768);
                                    NumberPicker.this.f3912e.invalidate();
                                    return true;
                                }
                            } else if (!NumberPicker.this.isEnabled()) {
                                return false;
                            } else {
                                NumberPicker.this.u();
                                return true;
                            }
                        } else if (!NumberPicker.this.isEnabled() || !NumberPicker.this.f3912e.isFocused()) {
                            return false;
                        } else {
                            NumberPicker.this.f3912e.clearFocus();
                            return true;
                        }
                    } else if (!NumberPicker.this.isEnabled() || NumberPicker.this.f3912e.isFocused()) {
                        return false;
                    } else {
                        return NumberPicker.this.f3912e.requestFocus();
                    }
                } else if (i2 != 16) {
                    if (i2 != 64) {
                        if (i2 != 128 || this.f3915c != i) {
                            return false;
                        }
                        this.f3915c = Integer.MIN_VALUE;
                        h(i, 65536);
                        NumberPicker numberPicker3 = NumberPicker.this;
                        numberPicker3.invalidate(0, numberPicker3.b0, numberPicker3.getRight(), NumberPicker.this.getBottom());
                        return true;
                    } else if (this.f3915c == i) {
                        return false;
                    } else {
                        this.f3915c = i;
                        h(i, 32768);
                        NumberPicker numberPicker4 = NumberPicker.this;
                        numberPicker4.invalidate(0, numberPicker4.b0, numberPicker4.getRight(), NumberPicker.this.getBottom());
                        return true;
                    }
                } else if (!NumberPicker.this.isEnabled()) {
                    return false;
                } else {
                    NumberPicker.this.d(true);
                    h(i, 1);
                    return true;
                }
            } else if (i2 != 64) {
                if (i2 != 128) {
                    if (i2 != 4096) {
                        if (i2 == 8192) {
                            if (!NumberPicker.this.isEnabled() || (!NumberPicker.this.getWrapSelectorWheel() && NumberPicker.this.getValue() <= NumberPicker.this.getMinValue())) {
                                return false;
                            }
                            NumberPicker.this.d(false);
                            return true;
                        }
                    } else if (!NumberPicker.this.isEnabled() || (!NumberPicker.this.getWrapSelectorWheel() && NumberPicker.this.getValue() >= NumberPicker.this.getMaxValue())) {
                        return false;
                    } else {
                        NumberPicker.this.d(true);
                        return true;
                    }
                } else if (this.f3915c != i) {
                    return false;
                } else {
                    this.f3915c = Integer.MIN_VALUE;
                    NumberPicker.this.performAccessibilityAction(128, (Bundle) null);
                    return true;
                }
            } else if (this.f3915c == i) {
                return false;
            } else {
                this.f3915c = i;
                NumberPicker.this.performAccessibilityAction(64, (Bundle) null);
                return true;
            }
            return super.performAction(i, i2, bundle);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            NumberPicker.this.u();
            NumberPicker.this.V = true;
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3918a;

        public c() {
        }

        public void run() {
            NumberPicker.this.d(this.f3918a);
            NumberPicker numberPicker = NumberPicker.this;
            numberPicker.postDelayed(this, numberPicker.u);
        }
    }

    public interface d {
    }

    public class e extends NumberKeyListener {
        public e() {
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (NumberPicker.this.n == null) {
                CharSequence filter = super.filter(charSequence, i, i2, spanned, i3, i4);
                if (filter == null) {
                    filter = charSequence.subSequence(i, i2);
                }
                String str = String.valueOf(spanned.subSequence(0, i3)) + filter + spanned.subSequence(i4, spanned.length());
                if ("".equals(str)) {
                    return str;
                }
                if (NumberPicker.this.i(str) > NumberPicker.this.p) {
                    return "";
                }
                return filter;
            }
            String valueOf = String.valueOf(charSequence.subSequence(i, i2));
            if (TextUtils.isEmpty(valueOf)) {
                return "";
            }
            String str2 = String.valueOf(spanned.subSequence(0, i3)) + valueOf + spanned.subSequence(i4, spanned.length());
            String lowerCase = String.valueOf(str2).toLowerCase();
            for (String str3 : NumberPicker.this.n) {
                if (str3.toLowerCase().startsWith(lowerCase)) {
                    NumberPicker numberPicker = NumberPicker.this;
                    int length = str2.length();
                    int length2 = str3.length();
                    i iVar = numberPicker.F;
                    if (iVar == null) {
                        numberPicker.F = new i();
                    } else {
                        numberPicker.removeCallbacks(iVar);
                    }
                    i iVar2 = numberPicker.F;
                    iVar2.f3924a = length;
                    iVar2.f3925b = length2;
                    numberPicker.post(iVar2);
                    return str3.subSequence(i3, str3.length());
                }
            }
            return "";
        }

        public char[] getAcceptedChars() {
            return NumberPicker.j0;
        }

        public int getInputType() {
            return 1;
        }
    }

    public interface f {
        void a(NumberPicker numberPicker, int i);
    }

    public interface g {
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f3921a;

        /* renamed from: b  reason: collision with root package name */
        public int f3922b;

        public h() {
        }

        public void a() {
            this.f3922b = 0;
            this.f3921a = 0;
            NumberPicker.this.removeCallbacks(this);
            NumberPicker numberPicker = NumberPicker.this;
            if (numberPicker.d0) {
                numberPicker.d0 = false;
                numberPicker.invalidate(0, numberPicker.b0, numberPicker.getRight(), NumberPicker.this.getBottom());
            }
            NumberPicker numberPicker2 = NumberPicker.this;
            numberPicker2.e0 = false;
            if (0 != 0) {
                numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.a0);
            }
        }

        public void run() {
            NumberPicker numberPicker;
            NumberPicker numberPicker2;
            int right;
            NumberPicker numberPicker3;
            int i = this.f3922b;
            if (i == 1) {
                int i2 = this.f3921a;
                if (i2 == 1) {
                    numberPicker = NumberPicker.this;
                    numberPicker.d0 = true;
                    numberPicker.invalidate(0, numberPicker.b0, numberPicker.getRight(), NumberPicker.this.getBottom());
                    return;
                } else if (i2 == 2) {
                    numberPicker2 = NumberPicker.this;
                    numberPicker2.e0 = true;
                    right = numberPicker2.getRight();
                    numberPicker3 = NumberPicker.this;
                } else {
                    return;
                }
            } else if (i == 2) {
                int i3 = this.f3921a;
                if (i3 == 1) {
                    NumberPicker numberPicker4 = NumberPicker.this;
                    if (!numberPicker4.d0) {
                        numberPicker4.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                    }
                    numberPicker = NumberPicker.this;
                    numberPicker.d0 = !numberPicker.d0;
                    numberPicker.invalidate(0, numberPicker.b0, numberPicker.getRight(), NumberPicker.this.getBottom());
                    return;
                } else if (i3 == 2) {
                    NumberPicker numberPicker5 = NumberPicker.this;
                    if (!numberPicker5.e0) {
                        numberPicker5.postDelayed(this, (long) ViewConfiguration.getPressedStateDuration());
                    }
                    numberPicker2 = NumberPicker.this;
                    numberPicker2.e0 = !numberPicker2.e0;
                    right = numberPicker2.getRight();
                    numberPicker3 = NumberPicker.this;
                } else {
                    return;
                }
            } else {
                return;
            }
            numberPicker2.invalidate(0, 0, right, numberPicker3.a0);
        }
    }

    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f3924a;

        /* renamed from: b  reason: collision with root package name */
        public int f3925b;

        public i() {
        }

        public void run() {
            NumberPicker.this.f3912e.setSelection(this.f3924a, this.f3925b);
        }
    }

    public class j {

        /* renamed from: a  reason: collision with root package name */
        public a f3927a;

        public j(NumberPicker numberPicker, a.c.d.j.g.a.a aVar) {
            this.f3927a = new a();
        }

        public void a(int i, int i2) {
            a aVar = this.f3927a;
            if (aVar != null) {
                aVar.h(i, i2);
            }
        }
    }

    public static class k implements d {

        /* renamed from: a  reason: collision with root package name */
        public final StringBuilder f3928a = new StringBuilder();

        /* renamed from: b  reason: collision with root package name */
        public char f3929b;

        /* renamed from: c  reason: collision with root package name */
        public Formatter f3930c;

        /* renamed from: d  reason: collision with root package name */
        public final Object[] f3931d = new Object[1];

        public k() {
            Locale locale = Locale.getDefault();
            this.f3930c = new Formatter(this.f3928a, locale);
            this.f3929b = new DecimalFormatSymbols(locale).getZeroDigit();
        }
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g0.NumberPicker, R.attr.numberPickerStyle, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, R.layout.number_picker_with_selector_wheel);
        this.R = resourceId != 0;
        this.Q = obtainStyledAttributes.getColor(9, 0);
        this.S = obtainStyledAttributes.getDrawable(5);
        this.T = obtainStyledAttributes.getDimensionPixelSize(6, (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.f = obtainStyledAttributes.getDimensionPixelSize(7, (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics()));
        this.g = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        this.h = dimensionPixelSize;
        int i2 = this.g;
        if (i2 == -1 || dimensionPixelSize == -1 || i2 <= dimensionPixelSize) {
            this.i = obtainStyledAttributes.getDimensionPixelSize(4, -1);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(2, -1);
            this.j = dimensionPixelSize2;
            int i3 = this.i;
            if (i3 == -1 || dimensionPixelSize2 == -1 || i3 <= dimensionPixelSize2) {
                this.k = this.j == -1;
                this.y = obtainStyledAttributes.getDrawable(10);
                obtainStyledAttributes.recycle();
                this.g0 = new h();
                setWillNotDraw(!this.R);
                ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(resourceId, this, true);
                a.c.d.j.g.a.a aVar = new a.c.d.j.g.a.a(this);
                a.c.d.j.g.a.b bVar = new a.c.d.j.g.a.b(this);
                if (!this.R) {
                    ImageButton imageButton = (ImageButton) findViewById(R.id.np__increment);
                    this.f3910c = imageButton;
                    imageButton.setOnClickListener(aVar);
                    this.f3910c.setOnLongClickListener(bVar);
                } else {
                    this.f3910c = null;
                }
                if (!this.R) {
                    ImageButton imageButton2 = (ImageButton) findViewById(R.id.np__decrement);
                    this.f3911d = imageButton2;
                    imageButton2.setOnClickListener(aVar);
                    this.f3911d.setOnLongClickListener(bVar);
                } else {
                    this.f3911d = null;
                }
                EditText editText = (EditText) findViewById(R.id.np__numberpicker_input);
                this.f3912e = editText;
                editText.setTypeface(a.c.d.r.e.a().f788a);
                this.f3912e.setOnFocusChangeListener(new a.c.d.j.g.a.c(this));
                this.f3912e.setFilters(new InputFilter[]{new e()});
                this.f3912e.setEnabled(false);
                this.f3912e.setFocusable(false);
                this.f3912e.setFocusableInTouchMode(false);
                this.f3912e.setRawInputType(2);
                this.f3912e.setImeOptions(6);
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.M = viewConfiguration.getScaledTouchSlop();
                this.N = viewConfiguration.getScaledMinimumFlingVelocity();
                this.O = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
                this.l = (int) this.f3912e.getTextSize();
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize((float) this.l);
                paint.setTypeface(this.f3912e.getTypeface());
                paint.setColor(this.f3912e.getTextColors().getColorForState(LinearLayout.ENABLED_STATE_SET, -1));
                this.x = paint;
                this.C = new Scroller(getContext(), (Interpolator) null, true);
                this.D = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
                w();
                if (getImportantForAccessibility() == 0) {
                    setImportantForAccessibility(1);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        throw new IllegalArgumentException("minHeight > maxHeight");
    }

    private j getSupportAccessibilityNodeProvider() {
        return new j(this, (a.c.d.j.g.a.a) null);
    }

    public static final d getTwoDigitFormatter() {
        return i0;
    }

    public static String h(int i2) {
        return String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i2)});
    }

    public void computeScroll() {
        Scroller scroller = this.C;
        if (scroller.isFinished()) {
            scroller = this.D;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.E == 0) {
            this.E = scroller.getStartY();
        }
        scrollBy(0, currY - this.E);
        this.E = currY;
        if (!scroller.isFinished()) {
            invalidate();
        } else if (scroller == this.C) {
            if (!f()) {
                w();
            }
            p(0);
        } else if (this.U != 1) {
            w();
        }
    }

    public final void d(boolean z2) {
        if (this.R) {
            this.f3912e.setVisibility(4);
            if (!n(this.C)) {
                n(this.D);
            }
            this.E = 0;
            if (z2) {
                this.C.startScroll(0, 0, 0, -this.z, 300);
            } else {
                this.C.startScroll(0, 0, 0, this.z, 300);
            }
            invalidate();
            return;
        }
        t(z2 ? this.q + 1 : this.q - 1, true);
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        a aVar;
        if (!this.R) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (!((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            return false;
        }
        int y2 = (int) motionEvent.getY();
        int i2 = y2 < this.a0 ? 3 : y2 > this.b0 ? 1 : 2;
        int action = motionEvent.getAction() & 255;
        j supportAccessibilityNodeProvider = getSupportAccessibilityNodeProvider();
        if (action == 7) {
            int i3 = this.c0;
            if (i3 == i2 || i3 == -1) {
                return false;
            }
            supportAccessibilityNodeProvider.a(i3, 256);
            supportAccessibilityNodeProvider.a(i2, 128);
            this.c0 = i2;
            aVar = supportAccessibilityNodeProvider.f3927a;
            if (aVar == null) {
                return false;
            }
        } else if (action == 9) {
            supportAccessibilityNodeProvider.a(i2, 128);
            this.c0 = i2;
            aVar = supportAccessibilityNodeProvider.f3927a;
            if (aVar == null) {
                return false;
            }
        } else if (action != 10) {
            return false;
        } else {
            supportAccessibilityNodeProvider.a(i2, 256);
            this.c0 = -1;
            return false;
        }
        aVar.performAction(i2, 64, (Bundle) null);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004c, code lost:
        requestFocus();
        r5.h0 = r0;
        r();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        if (r5.C.isFinished() == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        if (r0 != 20) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        d(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getKeyCode()
            r1 = 19
            r2 = 20
            if (r0 == r1) goto L_0x0019
            if (r0 == r2) goto L_0x0019
            r1 = 23
            if (r0 == r1) goto L_0x0015
            r1 = 66
            if (r0 == r1) goto L_0x0015
            goto L_0x0065
        L_0x0015:
            r5.r()
            goto L_0x0065
        L_0x0019:
            boolean r1 = r5.R
            if (r1 != 0) goto L_0x001e
            goto L_0x0065
        L_0x001e:
            int r1 = r6.getAction()
            r3 = 1
            if (r1 == 0) goto L_0x0030
            if (r1 == r3) goto L_0x0028
            goto L_0x0065
        L_0x0028:
            int r1 = r5.h0
            if (r1 != r0) goto L_0x0065
            r6 = -1
            r5.h0 = r6
            return r3
        L_0x0030:
            boolean r1 = r5.P
            if (r1 != 0) goto L_0x0042
            if (r0 != r2) goto L_0x0037
            goto L_0x0042
        L_0x0037:
            int r1 = r5.getValue()
            int r4 = r5.getMinValue()
            if (r1 <= r4) goto L_0x0065
            goto L_0x004c
        L_0x0042:
            int r1 = r5.getValue()
            int r4 = r5.getMaxValue()
            if (r1 >= r4) goto L_0x0065
        L_0x004c:
            r5.requestFocus()
            r5.h0 = r0
            r5.r()
            android.widget.Scroller r6 = r5.C
            boolean r6 = r6.isFinished()
            if (r6 == 0) goto L_0x0064
            if (r0 != r2) goto L_0x0060
            r6 = 1
            goto L_0x0061
        L_0x0060:
            r6 = 0
        L_0x0061:
            r5.d(r6)
        L_0x0064:
            return r3
        L_0x0065:
            boolean r6 = super.dispatchKeyEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            r();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            r();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    public final void e(int i2) {
        String str;
        SparseArray<String> sparseArray = this.v;
        if (sparseArray.get(i2) == null) {
            int i3 = this.o;
            if (i2 < i3 || i2 > this.p) {
                str = "";
            } else {
                String[] strArr = this.n;
                str = strArr != null ? strArr[i2 - i3] : g(i2);
            }
            sparseArray.put(i2, str);
        }
    }

    public final boolean f() {
        int i2 = this.A - this.B;
        if (i2 == 0) {
            return false;
        }
        this.E = 0;
        int abs = Math.abs(i2);
        int i3 = this.z;
        if (abs > i3 / 2) {
            if (i2 > 0) {
                i3 = -i3;
            }
            i2 += i3;
        }
        this.D.startScroll(0, 0, 0, i2, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_SETSTREAMCTRL_REQ);
        invalidate();
        return true;
    }

    public final String g(int i2) {
        d dVar = this.t;
        if (dVar == null) {
            return h(i2);
        }
        k kVar = (k) dVar;
        if (kVar != null) {
            Locale locale = Locale.getDefault();
            if (kVar.f3929b != new DecimalFormatSymbols(locale).getZeroDigit()) {
                kVar.f3930c = new Formatter(kVar.f3928a, locale);
                kVar.f3929b = new DecimalFormatSymbols(locale).getZeroDigit();
            }
            kVar.f3931d[0] = Integer.valueOf(i2);
            StringBuilder sb = kVar.f3928a;
            sb.delete(0, sb.length());
            kVar.f3930c.format("%02d", kVar.f3931d);
            return kVar.f3930c.toString();
        }
        throw null;
    }

    @TargetApi(16)
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (!this.R) {
            return super.getAccessibilityNodeProvider();
        }
        if (this.f0 == null) {
            this.f0 = new j(this, (a.c.d.j.g.a.a) null);
        }
        return this.f0.f3927a;
    }

    public float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    public String[] getDisplayedValues() {
        return this.n;
    }

    public int getMaxValue() {
        return this.p;
    }

    public int getMinValue() {
        return this.o;
    }

    public int getSolidColor() {
        return this.Q;
    }

    public float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public int getValue() {
        return this.q;
    }

    public boolean getWrapSelectorWheel() {
        return this.P;
    }

    public final int i(String str) {
        if (this.n == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return this.o;
            }
        } else {
            for (int i2 = 0; i2 < this.n.length; i2++) {
                str = str.toLowerCase();
                if (this.n[i2].toLowerCase().startsWith(str)) {
                    return this.o + i2;
                }
            }
            return Integer.parseInt(str);
        }
    }

    public final int j(int i2) {
        int i3 = this.p;
        int i4 = this.o;
        return i2 > i3 ? (((i2 - i3) % (i3 - i4)) + i4) - 1 : i2 < i4 ? (i3 - ((i4 - i2) % (i3 - i4))) + 1 : i2;
    }

    public final void k() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive(this.f3912e)) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            if (this.R) {
                this.f3912e.setVisibility(4);
            }
        }
    }

    public final void l() {
        this.v.clear();
        int[] iArr = this.w;
        int value = getValue();
        for (int i2 = 0; i2 < this.w.length; i2++) {
            int i3 = (i2 - this.f3909b) + value;
            if (this.P) {
                i3 = j(i3);
            }
            iArr[i2] = i3;
            e(iArr[i2]);
        }
    }

    public final int m(int i2, int i3) {
        if (i3 == -1) {
            return i2;
        }
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        if (mode == 1073741824) {
            return i2;
        }
        throw new IllegalArgumentException(a.a.a.a.a.h("Unknown measure mode: ", mode));
    }

    public final boolean n(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i2 = this.A - ((this.B + finalY) % this.z);
        if (i2 == 0) {
            return false;
        }
        int abs = Math.abs(i2);
        int i3 = this.z;
        if (abs > i3 / 2) {
            i2 = i2 > 0 ? i2 - i3 : i2 + i3;
        }
        scrollBy(0, finalY + i2);
        return true;
    }

    public final void o(int i2) {
        g gVar = this.r;
        if (gVar != null) {
            DeviceControlActivity.s(((a.c.d.j.d.d) gVar).f254a, this);
        }
    }

    public void onDetachedFromWindow() {
        r();
    }

    public void onDraw(Canvas canvas) {
        if (!this.R) {
            super.onDraw(canvas);
            return;
        }
        float right = (float) ((getRight() - getLeft()) / 2);
        float f2 = (float) this.B;
        Drawable drawable = this.y;
        if (drawable != null && this.U == 0) {
            if (this.e0) {
                drawable.setState(LinearLayout.PRESSED_ENABLED_STATE_SET);
                this.y.setBounds(0, 0, getRight(), this.a0);
                this.y.draw(canvas);
            }
            if (this.d0) {
                this.y.setState(LinearLayout.PRESSED_ENABLED_STATE_SET);
                this.y.setBounds(0, this.b0, getRight(), getBottom());
                this.y.draw(canvas);
            }
        }
        int[] iArr = this.w;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            String str = this.v.get(iArr[i2]);
            if (i2 != this.f3909b || this.f3912e.getVisibility() != 0) {
                canvas.drawText(str, right, f2, this.x);
            }
            f2 += (float) this.z;
        }
        Drawable drawable2 = this.S;
        if (drawable2 != null) {
            int i3 = this.a0;
            drawable2.setBounds(0, i3, getRight(), this.T + i3);
            this.S.draw(canvas);
            int i4 = this.b0;
            this.S.setBounds(0, i4 - this.T, getRight(), i4);
            this.S.draw(canvas);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(NumberPicker.class.getName());
        accessibilityEvent.setScrollable(true);
        accessibilityEvent.setScrollY((this.o + this.q) * this.z);
        accessibilityEvent.setMaxScrollY((this.p - this.o) * this.z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.R
            r1 = 0
            if (r0 == 0) goto L_0x00dc
            boolean r0 = r5.isEnabled()
            if (r0 != 0) goto L_0x000d
            goto L_0x00dc
        L_0x000d:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            r5.r()
            android.widget.EditText r0 = r5.f3912e
            r2 = 4
            r0.setVisibility(r2)
            float r0 = r6.getY()
            r5.I = r0
            r5.K = r0
            long r2 = r6.getEventTime()
            r5.J = r2
            r5.V = r1
            r5.W = r1
            float r6 = r5.I
            int r0 = r5.a0
            float r0 = (float) r0
            r2 = 1
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x004a
            int r6 = r5.U
            if (r6 != 0) goto L_0x0068
            com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker$h r6 = r5.g0
            r0 = 2
            r6.a()
            r6.f3922b = r2
            r6.f3921a = r0
            goto L_0x005e
        L_0x004a:
            int r0 = r5.b0
            float r0 = (float) r0
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x0068
            int r6 = r5.U
            if (r6 != 0) goto L_0x0068
            com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker$h r6 = r5.g0
            r6.a()
            r6.f3922b = r2
            r6.f3921a = r2
        L_0x005e:
            com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker r0 = com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker.this
            int r3 = android.view.ViewConfiguration.getTapTimeout()
            long r3 = (long) r3
            r0.postDelayed(r6, r3)
        L_0x0068:
            android.view.ViewParent r6 = r5.getParent()
            r6.requestDisallowInterceptTouchEvent(r2)
            android.widget.Scroller r6 = r5.C
            boolean r6 = r6.isFinished()
            if (r6 != 0) goto L_0x0085
            android.widget.Scroller r6 = r5.C
            r6.forceFinished(r2)
            android.widget.Scroller r6 = r5.D
            r6.forceFinished(r2)
            r5.p(r1)
            goto L_0x00db
        L_0x0085:
            android.widget.Scroller r6 = r5.D
            boolean r6 = r6.isFinished()
            if (r6 != 0) goto L_0x0098
            android.widget.Scroller r6 = r5.C
            r6.forceFinished(r2)
            android.widget.Scroller r6 = r5.D
            r6.forceFinished(r2)
            goto L_0x00db
        L_0x0098:
            float r6 = r5.I
            int r0 = r5.a0
            float r0 = (float) r0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ad
            r5.k()
            int r6 = android.view.ViewConfiguration.getLongPressTimeout()
            long r3 = (long) r6
            r5.q(r1, r3)
            goto L_0x00db
        L_0x00ad:
            int r0 = r5.b0
            float r0 = (float) r0
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c0
            r5.k()
            int r6 = android.view.ViewConfiguration.getLongPressTimeout()
            long r0 = (long) r6
            r5.q(r2, r0)
            goto L_0x00db
        L_0x00c0:
            r5.W = r2
            com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker$b r6 = r5.H
            if (r6 != 0) goto L_0x00ce
            com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker$b r6 = new com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker$b
            r6.<init>()
            r5.H = r6
            goto L_0x00d1
        L_0x00ce:
            r5.removeCallbacks(r6)
        L_0x00d1:
            com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker$b r6 = r5.H
            int r0 = android.view.ViewConfiguration.getLongPressTimeout()
            long r0 = (long) r0
            r5.postDelayed(r6, r0)
        L_0x00db:
            return r2
        L_0x00dc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (!this.R) {
            super.onLayout(z2, i2, i3, i4, i5);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.f3912e.getMeasuredWidth();
        int measuredHeight2 = this.f3912e.getMeasuredHeight();
        int i6 = (measuredWidth - measuredWidth2) / 2;
        int i7 = (measuredHeight - measuredHeight2) / 2;
        this.f3912e.layout(i6, i7, measuredWidth2 + i6, measuredHeight2 + i7);
        if (z2) {
            l();
            int[] iArr = this.w;
            int bottom = (int) ((((float) ((getBottom() - getTop()) - (iArr.length * this.l))) / ((float) iArr.length)) + 0.5f);
            this.m = bottom;
            this.z = this.l + bottom;
            int top = (this.f3912e.getTop() + this.f3912e.getBaseline()) - (this.z * this.f3909b);
            this.A = top;
            this.B = top;
            w();
            setVerticalFadingEdgeEnabled(true);
            setFadingEdgeLength(((getBottom() - getTop()) - this.l) / 2);
            int height = getHeight();
            int i8 = this.f;
            int i9 = this.T;
            int i10 = ((height - i8) / 2) - i9;
            this.a0 = i10;
            this.b0 = (i9 * 2) + i10 + i8;
        }
    }

    public void onMeasure(int i2, int i3) {
        if (!this.R) {
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(m(i2, this.j), m(i3, this.h));
        setMeasuredDimension(s(this.i, getMeasuredWidth(), i2), s(this.g, getMeasuredHeight(), i3));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        h hVar;
        if (!isEnabled() || !this.R) {
            return false;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            b bVar = this.H;
            if (bVar != null) {
                removeCallbacks(bVar);
            }
            c cVar = this.G;
            if (cVar != null) {
                removeCallbacks(cVar);
            }
            this.g0.a();
            VelocityTracker velocityTracker = this.L;
            velocityTracker.computeCurrentVelocity(1000, (float) this.O);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > this.N) {
                this.E = 0;
                this.C.fling(0, yVelocity > 0 ? 0 : Integer.MAX_VALUE, 0, yVelocity, 0, 0, 0, Integer.MAX_VALUE);
                invalidate();
                p(2);
            } else {
                int y2 = (int) motionEvent.getY();
                int abs = (int) Math.abs(((float) y2) - this.I);
                motionEvent.getEventTime();
                ViewConfiguration.getTapTimeout();
                if (abs > this.M) {
                    f();
                } else if (this.W) {
                    this.W = false;
                    u();
                } else {
                    int i2 = (y2 / this.z) - this.f3909b;
                    if (i2 > 0) {
                        d(true);
                        hVar = this.g0;
                        hVar.a();
                        hVar.f3922b = 2;
                        hVar.f3921a = 1;
                    } else if (i2 < 0) {
                        d(false);
                        hVar = this.g0;
                        hVar.a();
                        hVar.f3922b = 2;
                        hVar.f3921a = 2;
                    }
                    NumberPicker.this.post(hVar);
                }
                p(0);
            }
            this.L.recycle();
            this.L = null;
        } else if (action == 2 && !this.V) {
            float y3 = motionEvent.getY();
            if (this.U == 1) {
                scrollBy(0, (int) (y3 - this.K));
                invalidate();
            } else if (((int) Math.abs(y3 - this.I)) > this.M) {
                r();
                p(1);
            }
            this.K = y3;
        }
        return true;
    }

    public final void p(int i2) {
        if (this.U != i2) {
            this.U = i2;
            f fVar = this.s;
            if (fVar != null) {
                fVar.a(this, i2);
            }
        }
    }

    public final void q(boolean z2, long j2) {
        c cVar = this.G;
        if (cVar == null) {
            this.G = new c();
        } else {
            removeCallbacks(cVar);
        }
        c cVar2 = this.G;
        cVar2.f3918a = z2;
        postDelayed(cVar2, j2);
    }

    public final void r() {
        c cVar = this.G;
        if (cVar != null) {
            removeCallbacks(cVar);
        }
        i iVar = this.F;
        if (iVar != null) {
            removeCallbacks(iVar);
        }
        b bVar = this.H;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        this.g0.a();
    }

    public final int s(int i2, int i3, int i4) {
        if (i2 == -1) {
            return i3;
        }
        int max = Math.max(i2, i3);
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                max = size;
            }
        } else if (size < max) {
            max = 16777216 | size;
        }
        return max | 0;
    }

    public void scrollBy(int i2, int i3) {
        int[] iArr = this.w;
        if ((this.P || i3 <= 0 || iArr[this.f3909b] > this.o) && (this.P || i3 >= 0 || iArr[this.f3909b] < this.p)) {
            this.B += i3;
            while (true) {
                int i4 = this.B;
                if (i4 - this.A <= this.m) {
                    break;
                }
                this.B = i4 - this.z;
                int length = iArr.length - 1;
                while (length > 0) {
                    int i5 = length - 1;
                    iArr[length] = iArr[i5];
                    length = i5;
                }
                int i6 = iArr[1] - 1;
                if (this.P && i6 < this.o) {
                    i6 = this.p;
                }
                iArr[0] = i6;
                e(i6);
                t(iArr[this.f3909b], true);
                if (!this.P && iArr[this.f3909b] <= this.o) {
                    this.B = this.A;
                }
            }
            while (true) {
                int i7 = this.B;
                if (i7 - this.A < (-this.m)) {
                    this.B = i7 + this.z;
                    int i8 = 0;
                    while (i8 < iArr.length - 1) {
                        int i9 = i8 + 1;
                        iArr[i8] = iArr[i9];
                        i8 = i9;
                    }
                    int i10 = iArr[iArr.length - 2] + 1;
                    if (this.P && i10 > this.p) {
                        i10 = this.o;
                    }
                    iArr[iArr.length - 1] = i10;
                    e(i10);
                    t(iArr[this.f3909b], true);
                    if (!this.P && iArr[this.f3909b] >= this.p) {
                        this.B = this.A;
                    }
                } else {
                    return;
                }
            }
        } else {
            this.B = this.A;
        }
    }

    public void setDisplayedValues(String[] strArr) {
        EditText editText;
        int i2;
        if (this.n != strArr) {
            this.n = strArr;
            if (strArr != null) {
                editText = this.f3912e;
                i2 = 524289;
            } else {
                editText = this.f3912e;
                i2 = 2;
            }
            editText.setRawInputType(i2);
            w();
            l();
            v();
        }
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!this.R) {
            this.f3910c.setEnabled(z2);
        }
        if (!this.R) {
            this.f3911d.setEnabled(z2);
        }
        this.f3912e.setEnabled(z2);
    }

    public void setFormatter(d dVar) {
        if (dVar != this.t) {
            this.t = dVar;
            l();
            w();
        }
    }

    public void setMaxValue(int i2) {
        if (this.p != i2) {
            if (i2 >= 0) {
                this.p = i2;
                if (i2 < this.q) {
                    this.q = i2;
                }
                setWrapSelectorWheel(this.p - this.o > this.w.length);
                l();
                w();
                v();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
    }

    public void setMinValue(int i2) {
        if (this.o != i2) {
            if (i2 >= 0) {
                this.o = i2;
                if (i2 > this.q) {
                    this.q = i2;
                }
                setWrapSelectorWheel(this.p - this.o > this.w.length);
                l();
                w();
                v();
                invalidate();
                return;
            }
            throw new IllegalArgumentException("minValue must be >= 0");
        }
    }

    public void setOnLongPressUpdateInterval(long j2) {
        this.u = j2;
    }

    public void setOnScrollListener(f fVar) {
        this.s = fVar;
    }

    public void setOnValueChangedListener(g gVar) {
        this.r = gVar;
    }

    public void setValue(int i2) {
        t(i2, false);
    }

    public void setWrapSelectorWheel(boolean z2) {
        boolean z3 = this.p - this.o >= this.w.length;
        if ((!z2 || z3) && z2 != this.P) {
            this.P = z2;
        }
    }

    public final void t(int i2, boolean z2) {
        if (this.q != i2) {
            int j2 = this.P ? j(i2) : Math.min(Math.max(i2, this.o), this.p);
            int i3 = this.q;
            this.q = j2;
            w();
            if (z2) {
                o(i3);
            }
            l();
            invalidate();
        }
    }

    public final void u() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            if (this.R) {
                this.f3912e.setVisibility(0);
            }
            this.f3912e.requestFocus();
            inputMethodManager.showSoftInput(this.f3912e, 0);
        }
    }

    public final void v() {
        int i2;
        if (this.k) {
            String[] strArr = this.n;
            int i3 = 0;
            if (strArr == null) {
                float f2 = 0.0f;
                for (int i4 = 0; i4 <= 9; i4++) {
                    float measureText = this.x.measureText(h(i4));
                    if (measureText > f2) {
                        f2 = measureText;
                    }
                }
                for (int i5 = this.p; i5 > 0; i5 /= 10) {
                    i3++;
                }
                i2 = (int) (((float) i3) * f2);
            } else {
                int length = strArr.length;
                int i6 = 0;
                while (i3 < length) {
                    float measureText2 = this.x.measureText(this.n[i3]);
                    if (measureText2 > ((float) i6)) {
                        i6 = (int) measureText2;
                    }
                    i3++;
                }
                i2 = i6;
            }
            int paddingRight = this.f3912e.getPaddingRight() + this.f3912e.getPaddingLeft() + i2;
            if (this.j != paddingRight) {
                int i7 = this.i;
                if (paddingRight > i7) {
                    this.j = paddingRight;
                } else {
                    this.j = i7;
                }
                invalidate();
            }
        }
    }

    public final boolean w() {
        String[] strArr = this.n;
        String g2 = strArr == null ? g(this.q) : strArr[this.q - this.o];
        if (TextUtils.isEmpty(g2) || g2.equals(this.f3912e.getText().toString())) {
            return false;
        }
        this.f3912e.setText(g2);
        return true;
    }
}
