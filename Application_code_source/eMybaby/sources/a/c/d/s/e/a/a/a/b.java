package a.c.d.s.e.a.a.a;

import a.c.a.f.d;
import a.c.d.m.f.r;
import a.c.d.m.f.s;
import a.c.d.r.j;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.cuatroochenta.miniland.model.BabyDiaryEntry;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.babyDiary.add.BabyDiaryEntryDataAddRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.k.e;
import e.a.a.f0.g.h.c;
import e.a.a.g0.g.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONObject;

public class b extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f891b;

    /* renamed from: c  reason: collision with root package name */
    public long f892c;

    /* renamed from: d  reason: collision with root package name */
    public NotificationManager f893d;

    /* renamed from: e  reason: collision with root package name */
    public NotificationCompat.Builder f894e;
    public int f = 101101;
    public long g;

    /* renamed from: a.c.d.s.e.a.a.a.b$b  reason: collision with other inner class name */
    public class C0045b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public c f896a;

        /* renamed from: b  reason: collision with root package name */
        public BabyDiaryEntryDataAddRequest f897b;

        public C0045b(BabyDiaryEntryDataAddRequest babyDiaryEntryDataAddRequest, c cVar) {
            this.f896a = cVar;
            this.f897b = babyDiaryEntryDataAddRequest;
        }

        public void run() {
            String str;
            b bVar;
            try {
                BabyDiaryEntry babyDiaryEntry = this.f897b.f4096a;
                a aVar = new a();
                HashMap hashMap = new HashMap();
                hashMap.put("anadirentrada", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.k.format(Calendar.getInstance().getTime()));
                hashMap.put("titulo", babyDiaryEntry.getTitle());
                hashMap.put("descripcion", babyDiaryEntry.getCommentary());
                b.this.f893d = (NotificationManager) ((AppMiniland) a.c.a.a.f).getApplicationContext().getSystemService("notification");
                b.this.f894e = new NotificationCompat.Builder(((AppMiniland) a.c.a.a.f).getApplicationContext(), "CHANNEL_ID");
                a.c.a.d.a.o(b.this.f893d);
                b.this.f894e.setContentTitle(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_TITLE)).setContentText(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_DESC)).setContentIntent(PendingIntent.getActivity((AppMiniland) a.c.a.a.f, 0, new Intent(), 0)).setSmallIcon(R.mipmap.ic_launcher);
                e eVar = new e(a.c.a.d.a.c(b.this.f891b, hashMap));
                if (babyDiaryEntry.getPhotoPath() != null) {
                    File file = new File(babyDiaryEntry.getPhotoPath());
                    if (file.exists()) {
                        b.this.f892c = file.length();
                        a aVar2 = new a();
                        aVar2.a("file", new c(file));
                        aVar2.writeTo(new ByteArrayOutputStream((int) aVar2.getContentLength()));
                        eVar.f = aVar2;
                    }
                }
                JSONObject jSONObject = new JSONObject(a.e.a.a.r.b.c0(((g) d.a()).g(eVar).b()));
                if (jSONObject.has("idEntrada")) {
                    aVar.f42a = Boolean.TRUE;
                    aVar.f890c = jSONObject.getLong("idEntrada");
                    if (this.f896a != null) {
                        s.a aVar3 = (s.a) this.f896a;
                        s.this.f463a.runOnUiThread(new r(aVar3, aVar));
                    }
                    bVar = b.this;
                    str = a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_OK);
                } else {
                    aVar.f42a = Boolean.FALSE;
                    aVar.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_ECOGRAFIA);
                    bVar = b.this;
                    str = a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_KO);
                }
                b.a(bVar, str);
            } catch (Exception e2) {
                b bVar2 = b.this;
                if (!(bVar2.f893d == null || bVar2.f894e == null)) {
                    b.a(bVar2, a.c.a.d.a.h(R.string.TR_UPLOAD_SONG_KO));
                }
                a aVar4 = new a();
                aVar4.f42a = Boolean.FALSE;
                aVar4.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_ECOGRAFIA);
                c cVar = this.f896a;
                if (cVar != null) {
                    s.a aVar5 = (s.a) cVar;
                    s.this.f463a.runOnUiThread(new r(aVar5, aVar4));
                }
                e2.printStackTrace();
            }
        }
    }

    public b(String str) {
        super("UPLOAD_SOUND_PREGNANCY_SERVICE");
        this.f891b = str;
    }

    public static void a(b bVar, String str) {
        if (bVar.f893d != null && bVar.f894e != null) {
            if (AppMiniland.f().n()) {
                bVar.f893d.cancel(bVar.f);
                return;
            }
            bVar.f894e.setContentText(str).setProgress(0, 0, false);
            bVar.f893d.notify(bVar.f, bVar.f894e.build());
        }
    }

    public class a extends e.a.a.f0.g.g {
        public a() {
        }

        public void writeTo(OutputStream outputStream) {
            C0044a aVar = new C0044a(outputStream);
            e.a.a.f0.g.c cVar = this.f4927a;
            cVar.a(cVar.f4919d, aVar, true);
        }

        /* renamed from: a.c.d.s.e.a.a.a.b$a$a  reason: collision with other inner class name */
        public class C0044a extends FilterOutputStream {
            public C0044a(OutputStream outputStream) {
                super(outputStream);
                b.this.g = 0;
            }

            public void write(int i) {
                this.out.write(i);
                b bVar = b.this;
                bVar.g++;
                NotificationCompat.Builder builder = bVar.f894e;
                if (builder != null && bVar.f893d != null) {
                    builder.setProgress((int) bVar.f892c, i, false);
                    b bVar2 = b.this;
                    bVar2.f893d.notify(bVar2.f, bVar2.f894e.build());
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                this.out.write(bArr, i, i2);
                b bVar = b.this;
                long j = bVar.g + ((long) i2);
                bVar.g = j;
                NotificationCompat.Builder builder = bVar.f894e;
                if (builder != null && bVar.f893d != null) {
                    builder.setProgress((int) bVar.f892c, (int) j, false);
                    b bVar2 = b.this;
                    bVar2.f893d.notify(bVar2.f, bVar2.f894e.build());
                }
            }
        }
    }
}
