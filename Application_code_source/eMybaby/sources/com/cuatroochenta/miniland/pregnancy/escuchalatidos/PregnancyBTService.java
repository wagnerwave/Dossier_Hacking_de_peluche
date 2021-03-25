package com.cuatroochenta.miniland.pregnancy.escuchalatidos;

import a.f.a.a;
import android.annotation.SuppressLint;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.media.AudioTrack;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import com.example.lame.lame.JNIMp3eNCODE;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;
import java.util.UUID;
import okhttp3.internal.platform.AndroidPlatform;

@SuppressLint({"NewApi"})
public class PregnancyBTService extends Service {
    public static final UUID o = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* renamed from: a  reason: collision with root package name */
    public c f4009a = null;

    /* renamed from: b  reason: collision with root package name */
    public BluetoothAdapter f4010b = BluetoothAdapter.getDefaultAdapter();

    /* renamed from: c  reason: collision with root package name */
    public BluetoothDevice f4011c;

    /* renamed from: d  reason: collision with root package name */
    public BluetoothSocket f4012d = null;

    /* renamed from: e  reason: collision with root package name */
    public OutputStream f4013e = null;
    public boolean f = false;
    public a.f.a.a g = null;
    public e h = null;
    public String i = null;
    public b j = new b();
    public Handler k = new a();
    public d l = null;
    public boolean m = false;
    public f n = null;

    public class a extends Handler {
        public a() {
        }

        public void handleMessage(Message message) {
            if (message.what == 10) {
                c cVar = PregnancyBTService.this.f4009a;
                if (cVar != null) {
                    cVar.a(2);
                }
                PregnancyBTService pregnancyBTService = PregnancyBTService.this;
                pregnancyBTService.m = true;
                pregnancyBTService.n = new f((a) null);
                PregnancyBTService.this.n.start();
            }
        }
    }

    public class b extends Binder {
        public b() {
        }
    }

    public interface c {
        void a(int i);

        void b(String str);

        void c(a.f.a.d.c cVar);
    }

    public class d extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public BluetoothDevice f4016a;

        public d(BluetoothDevice bluetoothDevice) {
            this.f4016a = bluetoothDevice;
        }

        public void run() {
            c cVar;
            try {
                PregnancyBTService.this.f4012d = this.f4016a.createRfcommSocketToServiceRecord(PregnancyBTService.o);
            } catch (IOException e2) {
                e2.printStackTrace();
                c cVar2 = PregnancyBTService.this.f4009a;
                if (cVar2 != null) {
                    cVar2.a(3);
                }
            }
            PregnancyBTService.this.f4010b.cancelDiscovery();
            int i = 3;
            while (true) {
                if (i > 0) {
                    try {
                        PregnancyBTService.this.f4012d.connect();
                        if (PregnancyBTService.this.f4009a != null) {
                            PregnancyBTService.this.f4009a.a(4);
                        }
                        PregnancyBTService.this.k.sendEmptyMessage(10);
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        i--;
                        if (i == 0 && (cVar = PregnancyBTService.this.f4009a) != null) {
                            cVar.a(3);
                        }
                    }
                }
            }
            try {
                PregnancyBTService.this.f4013e = PregnancyBTService.this.f4012d.getOutputStream();
            } catch (IOException e4) {
                e4.printStackTrace();
                PregnancyBTService.this.f4013e = null;
                e4.printStackTrace();
            }
        }
    }

    public class e implements a.f.a.b {
        public e() {
        }
    }

    public class f extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public InputStream f4019a = null;

        public f(a aVar) {
        }

        public void run() {
            PregnancyBTService pregnancyBTService;
            try {
                this.f4019a = PregnancyBTService.this.f4012d.getInputStream();
                if (PregnancyBTService.this.f4009a != null) {
                    PregnancyBTService.this.f4009a.a(4);
                }
            } catch (IOException unused) {
                c cVar = PregnancyBTService.this.f4009a;
                if (cVar != null) {
                    cVar.a(3);
                }
                PregnancyBTService.this.m = false;
            }
            byte[] bArr = new byte[2048];
            while (true) {
                pregnancyBTService = PregnancyBTService.this;
                if (!pregnancyBTService.m) {
                    break;
                }
                try {
                    int read = this.f4019a.read(bArr);
                    a.f.a.a aVar = PregnancyBTService.this.g;
                    if (aVar.h) {
                        try {
                            aVar.f3305b.write(bArr, 0, read);
                            aVar.f3305b.flush();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                } catch (IOException unused2) {
                    c cVar2 = PregnancyBTService.this.f4009a;
                    if (cVar2 != null) {
                        cVar2.a(5);
                    }
                    PregnancyBTService.this.m = false;
                }
            }
            BluetoothSocket bluetoothSocket = pregnancyBTService.f4012d;
            if (bluetoothSocket != null) {
                try {
                    bluetoothSocket.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public void a() {
        this.m = false;
        BluetoothSocket bluetoothSocket = this.f4012d;
        if (bluetoothSocket != null) {
            try {
                bluetoothSocket.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        this.l = null;
        this.n = null;
        this.g.c();
    }

    public void b() {
        this.f = false;
        this.g.b();
        File file = a.c.c.b.c().f46a;
        c cVar = this.f4009a;
        if (cVar != null) {
            cVar.b(file.getAbsolutePath() + "/" + this.i + ".mp3");
        }
    }

    public void c() {
        File file = a.c.c.b.c().f46a;
        String valueOf = String.valueOf(System.currentTimeMillis());
        this.i = valueOf;
        a.f.a.a aVar = this.g;
        if (!aVar.h) {
            aVar.i = false;
        } else {
            a.f.a.f.a aVar2 = new a.f.a.f.a();
            aVar.m = aVar2;
            aVar2.f3334d = 0;
            try {
                aVar2.f3332b = new File(file, String.valueOf(valueOf) + ".wav");
                aVar2.f3333c = new FileOutputStream(aVar2.f3332b, true);
                a.f.a.f.b bVar = new a.f.a.f.b();
                aVar2.f3331a = bVar;
                bVar.a(aVar2.f3332b);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            aVar.i = true;
            a.f.a.f.a aVar3 = aVar.m;
            if (aVar3.f3335e == null) {
                aVar3.f3335e = new JNIMp3eNCODE();
            }
            File file2 = aVar3.f3332b;
            if (file2 != null) {
                String file3 = file2.toString();
                JNIMp3eNCODE jNIMp3eNCODE = aVar3.f3335e;
                jNIMp3eNCODE.init(jNIMp3eNCODE.f4158a, jNIMp3eNCODE.f4159b, jNIMp3eNCODE.f4160c, jNIMp3eNCODE.f4161d, jNIMp3eNCODE.f4162e, String.valueOf(file3.substring(0, file3.lastIndexOf("."))) + ".mp3");
            }
        }
        this.f = true;
        File file4 = new File(Environment.getExternalStorageDirectory() + "/luckcome/data");
        if (file4.exists() && file4.delete()) {
            File file5 = new File(Environment.getExternalStorageDirectory() + "/luckcome");
            if (file5.exists()) {
                file5.delete();
            }
        }
        c cVar = this.f4009a;
        if (cVar != null) {
            cVar.a(1);
        }
    }

    public void d() {
        if (this.l == null) {
            this.l = new d(this.f4011c);
        }
        this.l.start();
        a.f.a.a aVar = this.g;
        if (aVar != null) {
            aVar.f3306c = new a.b();
            a.C0079a aVar2 = new a.C0079a();
            aVar.f3308e = aVar2;
            aVar2.start();
            a.b bVar = aVar.f3306c;
            if (bVar != null) {
                bVar.start();
            }
            aVar.h = true;
            return;
        }
        throw null;
    }

    public IBinder onBind(Intent intent) {
        return this.j;
    }

    public void onCreate() {
        this.g = new a.f.a.a();
        e eVar = new e();
        this.h = eVar;
        a.f.a.a aVar = this.g;
        aVar.g = eVar;
        if (aVar != null) {
            aVar.f3304a = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            aVar.f3305b = pipedOutputStream;
            try {
                pipedOutputStream.connect(aVar.f3304a);
                aVar.f3307d = new a.f.a.d.b();
                a.f.a.c.b bVar = new a.f.a.c.b();
                aVar.f = bVar;
                AudioTrack audioTrack = new AudioTrack(3, AndroidPlatform.MAX_LOG_LENGTH, 4, 2, AudioTrack.getMinBufferSize(AndroidPlatform.MAX_LOG_LENGTH, 4, 2) * 1, 1);
                bVar.f3314a = audioTrack;
                audioTrack.setPositionNotificationPeriod(MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
                bVar.f3314a.setPlaybackPositionUpdateListener(new a.f.a.c.a(bVar));
                bVar.f3316c = 0;
                bVar.f3317d = 0;
                bVar.f3318e = 0;
                bVar.f = 0;
                bVar.g = 0;
                bVar.f3315b = true;
                bVar.f3314a.play();
                Arrays.fill(bVar.i, 0);
                bVar.f3314a.write(bVar.i, 0, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
                bVar.f3314a.write(bVar.i, 0, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
                bVar.f3314a.write(bVar.i, 0, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            } catch (IOException e2) {
                e2.printStackTrace();
                try {
                    aVar.f3304a.close();
                    aVar.f3305b.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                aVar.f3304a = null;
                aVar.f3305b = null;
            }
            aVar.h = false;
            return;
        }
        throw null;
    }

    public void onDestroy() {
        AudioTrack audioTrack;
        super.onDestroy();
        a.f.a.a aVar = this.g;
        if (aVar != null) {
            try {
                if (aVar.f3304a != null) {
                    aVar.f3304a.close();
                    aVar.f3304a = null;
                }
                if (aVar.f3305b != null) {
                    aVar.f3305b.close();
                    aVar.f3305b = null;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (aVar.h) {
                aVar.c();
            }
            if (aVar.f3307d != null) {
                aVar.f3307d = null;
            }
            if (aVar.g != null) {
                aVar.g = null;
            }
            a.f.a.c.b bVar = aVar.f;
            if (!(bVar == null || (audioTrack = bVar.f3314a) == null)) {
                audioTrack.release();
            }
            this.g = null;
            this.h = null;
            return;
        }
        throw null;
    }

    public boolean onUnbind(Intent intent) {
        a();
        return super.onUnbind(intent);
    }
}
