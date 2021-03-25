package a.d.c.r.l;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final a f3007a;

    public c(a aVar) {
        this.f3007a = aVar;
    }

    public void a(int[] iArr, int i) {
        int[] iArr2;
        b bVar;
        b bVar2;
        int[] iArr3 = iArr;
        int i2 = i;
        b bVar3 = new b(this.f3007a, iArr3);
        int[] iArr4 = new int[i2];
        boolean equals = this.f3007a.equals(a.m);
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            a aVar = this.f3007a;
            int i4 = equals ? i3 + 1 : i3;
            aVar.c();
            int b2 = bVar3.b(aVar.f3000a[i4]);
            iArr4[(i2 - 1) - i3] = b2;
            if (b2 != 0) {
                z = false;
            }
        }
        if (!z) {
            b bVar4 = new b(this.f3007a, iArr4);
            b b3 = this.f3007a.b(i2, 1);
            if (b3.d() < bVar4.d()) {
                b bVar5 = b3;
                b3 = bVar4;
                bVar4 = bVar5;
            }
            a aVar2 = this.f3007a;
            aVar2.c();
            b bVar6 = aVar2.f3003d;
            a aVar3 = this.f3007a;
            aVar3.c();
            b bVar7 = aVar3.f3002c;
            a aVar4 = this.f3007a;
            aVar4.c();
            b bVar8 = aVar4.f3002c;
            a aVar5 = this.f3007a;
            aVar5.c();
            b bVar9 = aVar5.f3003d;
            b bVar10 = bVar8;
            b bVar11 = bVar9;
            while (bVar4.d() >= i2 / 2) {
                if (!bVar4.e()) {
                    a aVar6 = this.f3007a;
                    aVar6.c();
                    b bVar12 = aVar6.f3002c;
                    int e2 = this.f3007a.e(bVar4.c(bVar4.d()));
                    while (b3.d() >= bVar4.d() && !b3.e()) {
                        int d2 = b3.d() - bVar4.d();
                        int f = this.f3007a.f(b3.c(b3.d()), e2);
                        b a2 = bVar12.a(this.f3007a.b(d2, f));
                        if (d2 >= 0) {
                            if (f == 0) {
                                a aVar7 = bVar4.f3005a;
                                aVar7.c();
                                bVar2 = aVar7.f3002c;
                                bVar = a2;
                            } else {
                                int length = bVar4.f3006b.length;
                                int[] iArr5 = new int[(d2 + length)];
                                int i5 = 0;
                                while (i5 < length) {
                                    iArr5[i5] = bVar4.f3005a.f(bVar4.f3006b[i5], f);
                                    i5++;
                                    int i6 = i;
                                    a2 = a2;
                                }
                                bVar = a2;
                                bVar2 = new b(bVar4.f3005a, iArr5);
                            }
                            b3 = b3.a(bVar2);
                            int i7 = i;
                            bVar12 = bVar;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                    b a3 = bVar12.g(bVar7).a(bVar6);
                    b a4 = bVar12.g(bVar11).a(bVar10);
                    bVar6 = bVar7;
                    bVar10 = bVar11;
                    bVar7 = a3;
                    bVar11 = a4;
                    i2 = i;
                    b bVar13 = b3;
                    b3 = bVar4;
                    bVar4 = bVar13;
                } else {
                    throw new d("r_{i-1} was zero");
                }
            }
            int i8 = 0;
            int c2 = bVar11.c(0);
            if (c2 != 0) {
                int e3 = this.f3007a.e(c2);
                b[] bVarArr = {bVar11.f(e3), bVar4.f(e3)};
                b bVar14 = bVarArr[0];
                b bVar15 = bVarArr[1];
                int d3 = bVar14.d();
                if (d3 == 1) {
                    iArr2 = new int[]{bVar14.c(1)};
                } else {
                    int[] iArr6 = new int[d3];
                    int i9 = 0;
                    for (int i10 = 1; i10 < this.f3007a.f3004e && i9 < d3; i10++) {
                        if (bVar14.b(i10) == 0) {
                            iArr6[i9] = this.f3007a.e(i10);
                            i9++;
                        }
                    }
                    if (i9 == d3) {
                        iArr2 = iArr6;
                    } else {
                        throw new d("Error locator degree does not match number of roots");
                    }
                }
                int length2 = iArr2.length;
                int[] iArr7 = new int[length2];
                for (int i11 = 0; i11 < length2; i11++) {
                    int e4 = this.f3007a.e(iArr2[i11]);
                    int i12 = 1;
                    for (int i13 = 0; i13 < length2; i13++) {
                        if (i11 != i13) {
                            int f2 = this.f3007a.f(iArr2[i13], e4);
                            i12 = this.f3007a.f(i12, (f2 & 1) == 0 ? f2 | 1 : f2 & -2);
                        }
                    }
                    iArr7[i11] = this.f3007a.f(bVar15.b(e4), this.f3007a.e(i12));
                    if (equals) {
                        iArr7[i11] = this.f3007a.f(iArr7[i11], e4);
                    }
                }
                while (i8 < iArr2.length) {
                    int length3 = iArr3.length - 1;
                    a aVar8 = this.f3007a;
                    int i14 = iArr2[i8];
                    aVar8.c();
                    if (i14 != 0) {
                        int i15 = length3 - aVar8.f3001b[i14];
                        if (i15 >= 0) {
                            iArr3[i15] = iArr3[i15] ^ iArr7[i8];
                            i8++;
                        } else {
                            throw new d("Bad error location");
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                return;
            }
            throw new d("sigmaTilde(0) was zero");
        }
    }
}
