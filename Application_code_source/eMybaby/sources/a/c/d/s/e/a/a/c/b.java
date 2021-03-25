package a.c.d.s.e.a.a.c;

import a.c.a.f.d;
import a.c.d.m.f.s;
import a.c.d.m.f.t;
import a.c.d.r.j;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.cuatroochenta.miniland.model.BabyDiaryEntry;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.babyDiary.edit.BabyDiaryEditRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.e;
import e.a.a.f0.g.h.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONObject;

public class b extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f904b = "https://emybaby.com/api/diariobebe.php";

    /* renamed from: c  reason: collision with root package name */
    public long f905c;

    /* renamed from: d  reason: collision with root package name */
    public NotificationManager f906d;

    /* renamed from: e  reason: collision with root package name */
    public NotificationCompat.Builder f907e;
    public int f;
    public long g;

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public BabyDiaryEditRequest f908a;

        /* renamed from: b  reason: collision with root package name */
        public c f909b;

        public a(BabyDiaryEditRequest babyDiaryEditRequest, c cVar) {
            this.f908a = babyDiaryEditRequest;
            this.f909b = cVar;
        }

        public void run() {
            b bVar;
            String h;
            try {
                BabyDiaryEntry babyDiaryEntry = this.f908a.f4098a;
                File file = new File(babyDiaryEntry.getPhotoPath());
                a aVar = new a();
                C0046b bVar2 = new C0046b();
                if (!file.toString().startsWith("http") && file.exists()) {
                    b.this.f905c = file.length();
                    bVar2.a("file", new c(file));
                    bVar2.writeTo(new ByteArrayOutputStream((int) bVar2.getContentLength()));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("editarentrada", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.k.format(Calendar.getInstance().getTime()));
                hashMap.put("titulo", babyDiaryEntry.getTitle());
                hashMap.put("descripcion", babyDiaryEntry.getCommentary());
                hashMap.put("idEntrada", String.valueOf(babyDiaryEntry.getId()));
                b.this.f906d = (NotificationManager) ((AppMiniland) a.c.a.a.f).getApplicationContext().getSystemService("notification");
                b.this.f907e = new NotificationCompat.Builder(((AppMiniland) a.c.a.a.f).getApplicationContext(), "CHANNEL_ID");
                a.c.a.d.a.o(b.this.f906d);
                e eVar = new e(a.c.a.d.a.c(b.this.f904b, hashMap));
                g a2 = d.a();
                eVar.f = bVar2;
                b.this.f907e.setContentTitle(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_TITLE)).setContentText(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_DESC)).setContentIntent(PendingIntent.getActivity((AppMiniland) a.c.a.a.f, 0, new Intent(), 0)).setSmallIcon(R.mipmap.ic_launcher);
                JSONObject jSONObject = new JSONObject(a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(eVar).b()));
                if (jSONObject.has("idEntrada")) {
                    aVar.f42a = Boolean.TRUE;
                    aVar.f903c = jSONObject.getLong("idEntrada");
                    if (this.f909b != null) {
                        s.b bVar3 = (s.b) this.f909b;
                        s.this.f463a.runOnUiThread(new t(bVar3, aVar));
                    }
                    bVar = b.this;
                    h = a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_OK);
                } else {
                    aVar.f42a = Boolean.FALSE;
                    aVar.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_ECOGRAFIA);
                    bVar = b.this;
                    h = a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_KO);
                }
                b.a(bVar, h);
            } catch (Exception e2) {
                b bVar4 = b.this;
                if (!(bVar4.f906d == null || bVar4.f907e == null)) {
                    b.a(bVar4, a.c.a.d.a.h(R.string.TR_UPLOAD_SONG_KO));
                }
                a aVar2 = new a();
                aVar2.f42a = Boolean.FALSE;
                aVar2.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_ECOGRAFIA);
                c cVar = this.f909b;
                if (cVar != null) {
                    s.b bVar5 = (s.b) cVar;
                    s.this.f463a.runOnUiThread(new t(bVar5, aVar2));
                }
                e2.printStackTrace();
            }
        }
    }

    public b() {
        super("BABY_DIARY_ENTRY_EDIT");
    }

    public static void a(b bVar, String str) {
        if (bVar.f906d != null && bVar.f907e != null) {
            if (AppMiniland.f().n()) {
                bVar.f906d.cancel(0);
                return;
            }
            bVar.f907e.setContentText(str).setProgress(0, 0, false);
            bVar.f906d.notify(0, bVar.f907e.build());
        }
    }

    /* renamed from: a.c.d.s.e.a.a.c.b$b  reason: collision with other inner class name */
    public class C0046b extends e.a.a.f0.g.g {
        public C0046b() {
        }

        public void writeTo(OutputStream outputStream) {
            a aVar = new a(outputStream);
            e.a.a.f0.g.c cVar = this.f4927a;
            cVar.a(cVar.f4919d, aVar, true);
        }

        /* renamed from: a.c.d.s.e.a.a.c.b$b$a */
        public class a extends FilterOutputStream {
            public a(OutputStream outputStream) {
                super(outputStream);
                b.this.g = 0;
            }

            public void write(int i) {
                this.out.write(i);
                b bVar = b.this;
                bVar.g++;
                NotificationCompat.Builder builder = bVar.f907e;
                if (builder != null && bVar.f906d != null) {
                    builder.setProgress((int) bVar.f905c, i, false);
                    b bVar2 = b.this;
                    bVar2.f906d.notify(bVar2.f, bVar2.f907e.build());
                }
            }

            public void write(@NonNull byte[] bArr, int i, int i2) {
                this.out.write(bArr, i, i2);
                b bVar = b.this;
                long j = bVar.g + ((long) i2);
                bVar.g = j;
                NotificationCompat.Builder builder = bVar.f907e;
                if (builder != null && bVar.f906d != null) {
                    builder.setProgress((int) bVar.f905c, (int) j, false);
                    b bVar2 = b.this;
                    bVar2.f906d.notify(bVar2.f, bVar2.f907e.build());
                }
            }
        }
    }
}
