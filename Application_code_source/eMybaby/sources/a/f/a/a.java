package a.f.a;

import a.f.a.d.c;
import android.media.AudioTrack;
import android.util.Log;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService;
import com.luckcome.lmtpdecorder.help.ADPCM;
import com.tutk.IOTC.AVFrame;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public PipedInputStream f3304a = null;

    /* renamed from: b  reason: collision with root package name */
    public PipedOutputStream f3305b = null;

    /* renamed from: c  reason: collision with root package name */
    public b f3306c = null;

    /* renamed from: d  reason: collision with root package name */
    public a.f.a.d.b f3307d = null;

    /* renamed from: e  reason: collision with root package name */
    public C0079a f3308e = null;
    public a.f.a.c.b f = null;
    public b g = null;
    public boolean h = false;
    public boolean i = false;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public a.f.a.f.a m = null;

    /* renamed from: a.f.a.a$a  reason: collision with other inner class name */
    public class C0079a extends a.f.a.e.a {
        public C0079a() {
        }

        /* JADX INFO: finally extract failed */
        public void a() {
            boolean z;
            boolean z2;
            a.f.a.d.a aVar;
            boolean z3;
            int i;
            int i2;
            int i3;
            a.f.a.d.b bVar = a.this.f3307d;
            synchronized (bVar) {
                try {
                    z = false;
                    z2 = bVar.f3324d > 107;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z2) {
                a.f.a.d.b bVar2 = a.this.f3307d;
                synchronized (bVar2) {
                    if (bVar2.f3324d > 107) {
                        if (85 == bVar2.b(bVar2.f3323c) && -86 == bVar2.b(bVar2.f3323c + 1)) {
                            aVar = new a.f.a.d.a();
                            int i4 = 4096 - bVar2.f3323c;
                            int i5 = 10;
                            if (!(9 == bVar2.b(bVar2.f3323c + 2) || 8 == bVar2.b(bVar2.f3323c + 2))) {
                                if (25 != bVar2.b(bVar2.f3323c + 2)) {
                                    if (3 != bVar2.b(bVar2.f3323c + 2)) {
                                        if (1 != bVar2.b(bVar2.f3323c + 2)) {
                                            int i6 = bVar2.f3323c + 3;
                                            bVar2.f3323c = i6;
                                            bVar2.f3323c = i6 % 4096;
                                            bVar2.f3324d -= 3;
                                        }
                                    }
                                    aVar.f3319a = 2;
                                    if (i4 >= 10) {
                                        System.arraycopy(bVar2.f3321a, bVar2.f3323c, aVar.f3320b, 0, 10);
                                        i3 = bVar2.f3323c + 10;
                                        bVar2.f3323c = i3;
                                    } else {
                                        System.arraycopy(bVar2.f3321a, bVar2.f3323c, aVar.f3320b, 0, i4);
                                        int i7 = bVar2.f3323c + i4;
                                        bVar2.f3323c = i7;
                                        int i8 = i7 % 4096;
                                        bVar2.f3323c = i8;
                                        int i9 = 10 - i4;
                                        System.arraycopy(bVar2.f3321a, i8, aVar.f3320b, i4, i9);
                                        i3 = bVar2.f3323c + i9;
                                        bVar2.f3323c = i3;
                                    }
                                    bVar2.f3323c = i3 % 4096;
                                    i = bVar2.f3324d;
                                    bVar2.f3324d = i - i5;
                                }
                            }
                            aVar.f3319a = 1;
                            if (25 == bVar2.b(bVar2.f3323c + 2)) {
                                aVar.f3319a = 11;
                            }
                            if (i4 >= 107) {
                                System.arraycopy(bVar2.f3321a, bVar2.f3323c, aVar.f3320b, 0, 107);
                                i2 = bVar2.f3323c + 107;
                                bVar2.f3323c = i2;
                            } else {
                                System.arraycopy(bVar2.f3321a, bVar2.f3323c, aVar.f3320b, 0, i4);
                                int i10 = bVar2.f3323c + i4;
                                bVar2.f3323c = i10;
                                int i11 = i10 % 4096;
                                bVar2.f3323c = i11;
                                int i12 = 107 - i4;
                                System.arraycopy(bVar2.f3321a, i11, aVar.f3320b, i4, i12);
                                i2 = bVar2.f3323c + i12;
                                bVar2.f3323c = i2;
                            }
                            bVar2.f3323c = i2 % 4096;
                            i = bVar2.f3324d;
                            i5 = 107;
                            bVar2.f3324d = i - i5;
                        } else {
                            bVar2.f3324d--;
                            int i13 = bVar2.f3323c + 1;
                            bVar2.f3323c = i13;
                            if (i13 >= 4096) {
                                bVar2.f3323c = i13 % 4096;
                            }
                        }
                    }
                    aVar = null;
                }
                if (aVar != null) {
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        int i14 = aVar.f3319a;
                        if (i14 == 2) {
                            c cVar = new c();
                            byte[] bArr = aVar.f3320b;
                            cVar.f3325a = bArr[3] & AVFrame.FRM_STATE_UNKOWN;
                            byte b2 = bArr[4];
                            cVar.f3326b = bArr[5];
                            cVar.f3327c = bArr[6];
                            cVar.f3328d = (byte) (3 & bArr[7]);
                            byte b3 = bArr[7];
                            cVar.g = (byte) (bArr[8] & 15);
                            cVar.h = (byte) ((bArr[8] & Tnaf.POW_2_WIDTH) != 0 ? 1 : 0);
                            byte[] bArr2 = aVar.f3320b;
                            byte b4 = bArr2[8];
                            cVar.i = (byte) ((bArr2[8] & 64) != 0 ? 1 : 0);
                            cVar.j = (byte) ((aVar.f3320b[8] & 128) != 0 ? 1 : 0);
                            synchronized (aVar2) {
                                if (aVar2.j > 0) {
                                    aVar2.j--;
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            }
                            if (z3) {
                                cVar.f3329e = 1;
                            }
                            synchronized (aVar2) {
                                if (aVar2.k > 0) {
                                    aVar2.k--;
                                    z = true;
                                }
                            }
                            if (z) {
                                cVar.f = 1;
                            }
                            synchronized (aVar2) {
                                if (aVar2.l > 0) {
                                    aVar2.l--;
                                }
                            }
                            b bVar3 = aVar2.g;
                            if (bVar3 != null) {
                                PregnancyBTService.e eVar = (PregnancyBTService.e) bVar3;
                                if (cVar.f3329e != 0) {
                                    Log.v("LMTPD", "LMTPD...1...fm");
                                }
                                if (cVar.f != 0) {
                                    Log.v("LMTPD", "LMTPD...2...toco");
                                }
                                PregnancyBTService.c cVar2 = PregnancyBTService.this.f4009a;
                                if (cVar2 != null) {
                                    cVar2.c(cVar);
                                }
                            }
                        } else if (i14 == 1) {
                            short[] sArr = new short[200];
                            byte[] bArr3 = aVar.f3320b;
                            ADPCM.decodeAdpcm(sArr, 0, bArr3, 3, 100, bArr3[104], bArr3[105], bArr3[106]);
                            aVar2.a(sArr);
                        } else if (i14 == 11) {
                            short[] sArr2 = new short[200];
                            byte[] bArr4 = aVar.f3320b;
                            ADPCM.decodeAdpcmFor10Or12Bit(sArr2, 0, bArr4, 3, 100, bArr4[104], bArr4[105], bArr4[106], bArr4[103]);
                            aVar2.a(sArr2);
                        }
                    } else {
                        throw null;
                    }
                }
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public class b extends a.f.a.e.a {

        /* renamed from: b  reason: collision with root package name */
        public byte[] f3310b = new byte[107];

        /* renamed from: c  reason: collision with root package name */
        public int f3311c = 0;

        public b() {
        }

        public void a() {
            try {
                if (this.f3310b != null) {
                    int read = a.this.f3304a.read(this.f3310b);
                    this.f3311c = read;
                    a.this.f3307d.a(this.f3310b, 0, read);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void a(short[] sArr) {
        a.f.a.f.a aVar;
        a.f.a.c.b bVar = this.f;
        if (bVar != null) {
            System.arraycopy(sArr, 0, bVar.h, bVar.f3318e * 200, 200);
            bVar.f3316c++;
            int i2 = bVar.f3318e + 1;
            bVar.f3318e = i2;
            if (i2 == 40) {
                bVar.f3318e = 0;
            }
            bVar.f3315b = false;
        }
        if (this.i && (aVar = this.m) != null) {
            aVar.f3335e.encode(sArr, sArr.length);
        }
    }

    public void b() {
        a.f.a.f.a aVar;
        if (this.h && this.i && (aVar = this.m) != null) {
            this.i = false;
            FileOutputStream fileOutputStream = aVar.f3333c;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    aVar.f3333c = null;
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            a.f.a.f.b bVar = aVar.f3331a;
            if (bVar != null) {
                int i2 = aVar.f3334d;
                bVar.f3339a = i2 + 36;
                bVar.f3340b = i2;
                bVar.a(aVar.f3332b);
                aVar.f3331a = null;
            }
            File file = aVar.f3332b;
            if (file != null) {
                file.delete();
            }
        }
    }

    public void c() {
        AudioTrack audioTrack;
        if (this.i) {
            b();
        }
        this.h = false;
        b bVar = this.f3306c;
        if (bVar != null) {
            if (bVar.f3330a) {
                bVar.f3330a = false;
            }
            this.f3306c = null;
        }
        C0079a aVar = this.f3308e;
        if (aVar != null) {
            if (aVar.f3330a) {
                aVar.f3330a = false;
            }
            this.f3308e = null;
        }
        try {
            if (this.f3304a != null) {
                this.f3304a.close();
                this.f3304a = null;
            }
            if (this.f3305b != null) {
                this.f3305b.close();
                this.f3305b = null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        a.f.a.c.b bVar2 = this.f;
        if (!(bVar2 == null || (audioTrack = bVar2.f3314a) == null)) {
            audioTrack.release();
        }
        a.f.a.f.a aVar2 = this.m;
        if (aVar2 != null && aVar2.f3335e != null) {
            Log.e("LAME_MAIN", "stopMp3()... ");
            aVar2.f3335e.destroy();
        }
    }
}
