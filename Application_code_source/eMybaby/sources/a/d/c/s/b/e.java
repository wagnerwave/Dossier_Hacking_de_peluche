package a.d.c.s.b;

import a.d.c.f;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.tutk.IOTC.AVFrame;

public final class e {
    public static final e[] h = {new e(1, 10, 10, 8, 8, new c(5, new b(1, 3, (a) null), (a) null)), new e(2, 12, 12, 10, 10, new c(7, new b(1, 5, (a) null), (a) null)), new e(3, 14, 14, 12, 12, new c(10, new b(1, 8, (a) null), (a) null)), new e(4, 16, 16, 14, 14, new c(12, new b(1, 12, (a) null), (a) null)), new e(5, 18, 18, 16, 16, new c(14, new b(1, 18, (a) null), (a) null)), new e(6, 20, 20, 18, 18, new c(18, new b(1, 22, (a) null), (a) null)), new e(7, 22, 22, 20, 20, new c(20, new b(1, 30, (a) null), (a) null)), new e(8, 24, 24, 22, 22, new c(24, new b(1, 36, (a) null), (a) null)), new e(9, 26, 26, 24, 24, new c(28, new b(1, 44, (a) null), (a) null)), new e(10, 32, 32, 14, 14, new c(36, new b(1, 62, (a) null), (a) null)), new e(11, 36, 36, 16, 16, new c(42, new b(1, 86, (a) null), (a) null)), new e(12, 40, 40, 18, 18, new c(48, new b(1, 114, (a) null), (a) null)), new e(13, 44, 44, 20, 20, new c(56, new b(1, 144, (a) null), (a) null)), new e(14, 48, 48, 22, 22, new c(68, new b(1, 174, (a) null), (a) null)), new e(15, 52, 52, 24, 24, new c(42, new b(2, 102, (a) null), (a) null)), new e(16, 64, 64, 14, 14, new c(56, new b(2, AVFrame.MEDIA_CODEC_AUDIO_PCM, (a) null), (a) null)), new e(17, 72, 72, 16, 16, new c(36, new b(4, 92, (a) null), (a) null)), new e(18, 80, 80, 18, 18, new c(48, new b(4, 114, (a) null), (a) null)), new e(19, 88, 88, 20, 20, new c(56, new b(4, 144, (a) null), (a) null)), new e(20, 96, 96, 22, 22, new c(68, new b(4, 174, (a) null), (a) null)), new e(21, 104, 104, 24, 24, new c(56, new b(6, 136, (a) null), (a) null)), new e(22, 120, 120, 18, 18, new c(68, new b(6, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, (a) null), (a) null)), new e(23, 132, 132, 20, 20, new c(62, new b(8, 163, (a) null), (a) null)), new e(24, 144, 144, 22, 22, new c(62, new b(8, 156, (a) null), new b(2, 155, (a) null), (a) null)), new e(25, 8, 18, 6, 16, new c(7, new b(1, 5, (a) null), (a) null)), new e(26, 8, 32, 6, 14, new c(11, new b(1, 10, (a) null), (a) null)), new e(27, 12, 26, 10, 24, new c(14, new b(1, 16, (a) null), (a) null)), new e(28, 12, 36, 10, 16, new c(18, new b(1, 22, (a) null), (a) null)), new e(29, 16, 36, 14, 16, new c(24, new b(1, 32, (a) null), (a) null)), new e(30, 16, 48, 14, 22, new c(28, new b(1, 49, (a) null), (a) null))};

    /* renamed from: a  reason: collision with root package name */
    public final int f3025a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3026b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3027c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3028d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3029e;
    public final c f;
    public final int g;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f3030a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3031b;

        public b(int i, int i2, a aVar) {
            this.f3030a = i;
            this.f3031b = i2;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f3032a;

        /* renamed from: b  reason: collision with root package name */
        public final b[] f3033b;

        public c(int i, b bVar, a aVar) {
            this.f3032a = i;
            this.f3033b = new b[]{bVar};
        }

        public c(int i, b bVar, b bVar2, a aVar) {
            this.f3032a = i;
            this.f3033b = new b[]{bVar, bVar2};
        }
    }

    public e(int i, int i2, int i3, int i4, int i5, c cVar) {
        this.f3025a = i;
        this.f3026b = i2;
        this.f3027c = i3;
        this.f3028d = i4;
        this.f3029e = i5;
        this.f = cVar;
        int i6 = cVar.f3032a;
        int i7 = 0;
        for (b bVar : cVar.f3033b) {
            i7 += (bVar.f3031b + i6) * bVar.f3030a;
        }
        this.g = i7;
    }

    public static e a(int i, int i2) {
        if ((i & 1) == 0 && (i2 & 1) == 0) {
            for (e eVar : h) {
                if (eVar.f3026b == i && eVar.f3027c == i2) {
                    return eVar;
                }
            }
            throw f.f2869a;
        }
        throw f.f2869a;
    }

    public String toString() {
        return String.valueOf(this.f3025a);
    }
}
