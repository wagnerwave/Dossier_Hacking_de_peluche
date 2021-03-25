package a.g.a.b;

import a.g.a.b.l.d;
import a.g.a.b.l.e;
import a.g.a.b.l.i;
import a.g.a.b.n.b;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.InputStream;
import java.net.URI;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final URI f3368a;

    /* renamed from: b  reason: collision with root package name */
    public final b f3369b;

    /* renamed from: c  reason: collision with root package name */
    public final b f3370c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3371d;

    public c(URI uri, b bVar, b bVar2) {
        this.f3368a = uri;
        this.f3369b = bVar;
        this.f3370c = bVar2;
    }

    public Bitmap a(e eVar, d dVar, i iVar) {
        int i;
        int i2;
        int i3;
        int i4;
        e eVar2 = eVar;
        d dVar2 = dVar;
        i iVar2 = iVar;
        d dVar3 = d.EXACTLY_STRETCHED;
        d dVar4 = d.EXACTLY;
        i iVar3 = i.FIT_INSIDE;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i5 = 1;
        if (dVar2 != d.NONE) {
            d dVar5 = d.IN_SAMPLE_POWER_OF_2;
            int i6 = eVar2.f3422a;
            int i7 = eVar2.f3423b;
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            InputStream a2 = this.f3369b.a(this.f3368a, this.f3370c.k);
            try {
                BitmapFactory.decodeStream(a2, (Rect) null, options2);
                try {
                    a2.close();
                } catch (Exception unused) {
                }
                int i8 = options2.outWidth;
                int i9 = options2.outHeight;
                int i10 = i8 / i6;
                int i11 = i9 / i7;
                if (iVar2 == iVar3) {
                    if (dVar2 == dVar5) {
                        i3 = 1;
                        while (true) {
                            int i12 = i8 / 2;
                            if (i12 < i6 && i9 / 2 < i7) {
                                break;
                            }
                            i9 /= 2;
                            i3 *= 2;
                            i8 = i12;
                        }
                    } else {
                        i3 = Math.max(i10, i11);
                    }
                } else if (dVar2 == dVar5) {
                    int i13 = 1;
                    while (true) {
                        int i14 = i8 / 2;
                        if (i14 < i6 || (i4 = i9 / 2) < i7) {
                            break;
                        }
                        i13 = i3 * 2;
                        i8 = i14;
                        i9 = i4;
                    }
                } else {
                    i3 = Math.min(i10, i11);
                }
                if (i3 < 1) {
                    i3 = 1;
                }
                Object[] objArr = {Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i3)};
                if (this.f3371d) {
                    a.e.a.a.r.b.H("Original image (%1$dx%2$d) is going to be subsampled to %3$dx%4$d view. Computed scale size - %5$d", objArr);
                }
                i5 = i3;
            } catch (Throwable th) {
                Throwable th2 = th;
                try {
                    a2.close();
                } catch (Exception unused2) {
                }
                throw th2;
            }
        }
        options.inSampleSize = i5;
        b bVar = this.f3370c;
        options.inPreferredConfig = bVar.i;
        InputStream a3 = this.f3369b.a(this.f3368a, bVar.k);
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(a3, (Rect) null, options);
            try {
                a3.close();
            } catch (Exception unused3) {
            }
            if (decodeStream == null) {
                Object[] objArr2 = {this.f3368a};
                if (this.f3371d) {
                    a.e.a.a.r.b.H("Image can't be decoded [%s]", objArr2);
                }
                return null;
            } else if (dVar2 != dVar4 && dVar2 != dVar3) {
                return decodeStream;
            } else {
                float width = (float) decodeStream.getWidth();
                float height = (float) decodeStream.getHeight();
                float f = width / ((float) eVar2.f3422a);
                float f2 = height / ((float) eVar2.f3423b);
                if ((iVar2 != iVar3 || f < f2) && (iVar2 != i.CROP || f >= f2)) {
                    i = eVar2.f3423b;
                    i2 = (int) (width / f2);
                } else {
                    i2 = eVar2.f3422a;
                    i = (int) (height / f);
                }
                if ((dVar2 != dVar4 || ((float) i2) >= width || ((float) i) >= height) && (dVar2 != dVar3 || ((float) i2) == width || ((float) i) == height)) {
                    return decodeStream;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, i2, i, true);
                if (createScaledBitmap != decodeStream) {
                    decodeStream.recycle();
                }
                Object[] objArr3 = {Integer.valueOf((int) width), Integer.valueOf((int) height), Integer.valueOf(i2), Integer.valueOf(i)};
                if (this.f3371d) {
                    a.e.a.a.r.b.H("Subsampled image (%1$dx%2$d) was scaled to %3$dx%4$d", objArr3);
                }
                return createScaledBitmap;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            try {
                a3.close();
            } catch (Exception unused4) {
            }
            throw th4;
        }
    }
}
