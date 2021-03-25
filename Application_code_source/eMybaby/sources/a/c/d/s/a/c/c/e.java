package a.c.d.s.a.c.c;

import a.c.d.g.g;
import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatJellybean;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.cuatroochenta.miniland.model.Song;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.common.oOO0O0O0;
import com.tuya.smart.home.sdk.bean.scene.ConditionExtraInfoBean;
import e.a.a.f0.g.h.c;
import e.a.a.f0.g.h.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

public class e extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f851b;

    /* renamed from: c  reason: collision with root package name */
    public long f852c;

    /* renamed from: d  reason: collision with root package name */
    public NotificationManager f853d;

    /* renamed from: e  reason: collision with root package name */
    public NotificationCompat.Builder f854e;
    public int f = 101100;
    public long g;

    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f856a;

        /* renamed from: b  reason: collision with root package name */
        public b f857b;

        public b(b bVar, a aVar) {
            this.f856a = aVar;
            this.f857b = bVar;
        }

        public void run() {
            try {
                File file = new File(this.f857b.f844a);
                if (!file.exists()) {
                    c cVar = new c();
                    cVar.f847a = false;
                    BuddyPlayerActivity buddyPlayerActivity = (BuddyPlayerActivity) this.f856a;
                    buddyPlayerActivity.runOnUiThread(new g(buddyPlayerActivity, cVar));
                } else if (!a.c.a.d.a.j(this.f857b.f846c)) {
                    d dVar = new d(this.f857b.f846c);
                    e.this.f852c = file.length();
                    a aVar = new a();
                    aVar.a(NotificationCompatJellybean.KEY_TITLE, dVar);
                    c cVar2 = null;
                    aVar.a("favorite", new d(oOO0O0O0.O0000oO0, "text/plain", (Charset) null));
                    aVar.a(ConditionExtraInfoBean.CAL_TYPE_DURATION, new d(String.valueOf(this.f857b.f845b)));
                    aVar.a("file", new c(file));
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) aVar.getContentLength());
                    aVar.writeTo(byteArrayOutputStream);
                    new String(byteArrayOutputStream.toByteArray());
                    HashMap hashMap = new HashMap();
                    hashMap.put("subircancion", "1");
                    Usuario i = AppMiniland.f().i();
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("id", i.getId());
                    hashMap.put("pass", i.getPass());
                    e.this.f853d = (NotificationManager) ((AppMiniland) a.c.a.a.f).getApplicationContext().getSystemService("notification");
                    e.this.f854e = new NotificationCompat.Builder(((AppMiniland) a.c.a.a.f).getApplicationContext(), "CHANNEL_ID");
                    e.this.f854e.setContentTitle(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_SONG_TITLE)).setContentText(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_SONG_DESC)).setSmallIcon(R.mipmap.ic_launcher);
                    a.c.a.d.a.o(e.this.f853d);
                    e.a.a.c0.k.e eVar = new e.a.a.c0.k.e(a.c.a.d.a.c(e.this.f851b, hashMap));
                    e.a.a.c0.g a2 = a.c.a.f.d.a();
                    eVar.f = aVar;
                    String c0 = a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(eVar).b());
                    d dVar2 = new d();
                    try {
                        c cVar3 = new c();
                        dVar2.f850a = cVar3;
                        cVar3.f847a = false;
                        c0.replaceAll("&", "&amp;");
                        dVar2.a(c0);
                        cVar2 = dVar2.f850a;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (cVar2 == null) {
                        if (!(e.this.f853d == null || e.this.f854e == null)) {
                            e.a(e.this, a.c.a.d.a.h(R.string.TR_UPLOAD_SONG_KO));
                        }
                        c cVar4 = new c();
                        cVar4.f847a = false;
                        BuddyPlayerActivity buddyPlayerActivity2 = (BuddyPlayerActivity) this.f856a;
                        buddyPlayerActivity2.runOnUiThread(new g(buddyPlayerActivity2, cVar4));
                    } else if (cVar2.f847a) {
                        e.a(e.this, a.c.a.d.a.h(R.string.TR_UPLOAD_SONG_OK));
                        BuddyPlayerActivity buddyPlayerActivity3 = (BuddyPlayerActivity) this.f856a;
                        buddyPlayerActivity3.runOnUiThread(new g(buddyPlayerActivity3, cVar2));
                        Song song = cVar2.f849c;
                        if (song != null && !a.c.a.d.a.j(song.getUrlFile())) {
                            file.renameTo(a.c.c.b.c().b(cVar2.f849c.getUrlFile()));
                        }
                    } else {
                        e.a(e.this, a.c.a.d.a.h(R.string.TR_UPLOAD_SONG_KO));
                        BuddyPlayerActivity buddyPlayerActivity4 = (BuddyPlayerActivity) this.f856a;
                        buddyPlayerActivity4.runOnUiThread(new g(buddyPlayerActivity4, cVar2));
                    }
                } else {
                    c cVar5 = new c();
                    cVar5.f847a = false;
                    BuddyPlayerActivity buddyPlayerActivity5 = (BuddyPlayerActivity) this.f856a;
                    buddyPlayerActivity5.runOnUiThread(new g(buddyPlayerActivity5, cVar5));
                }
            } catch (Exception e3) {
                e eVar2 = e.this;
                if (!(eVar2.f853d == null || eVar2.f854e == null)) {
                    e.a(eVar2, a.c.a.d.a.h(R.string.TR_UPLOAD_SONG_KO));
                }
                c cVar6 = new c();
                cVar6.f847a = false;
                BuddyPlayerActivity buddyPlayerActivity6 = (BuddyPlayerActivity) this.f856a;
                buddyPlayerActivity6.runOnUiThread(new g(buddyPlayerActivity6, cVar6));
                e3.printStackTrace();
            }
        }
    }

    public e(String str) {
        super("UPLOAD_SONG_SERVICE");
        this.f851b = str;
    }

    public static void a(e eVar, String str) {
        if (eVar.f853d != null && eVar.f854e != null) {
            if (AppMiniland.f().n()) {
                eVar.f853d.cancel(eVar.f);
                return;
            }
            eVar.f854e.setContentText(str).setProgress(0, 0, false);
            eVar.f853d.notify(eVar.f, eVar.f854e.build());
        }
    }

    public class a extends e.a.a.f0.g.g {
        public a() {
        }

        public void writeTo(OutputStream outputStream) {
            C0043a aVar = new C0043a(outputStream);
            e.a.a.f0.g.c cVar = this.f4927a;
            cVar.a(cVar.f4919d, aVar, true);
        }

        /* renamed from: a.c.d.s.a.c.c.e$a$a  reason: collision with other inner class name */
        public class C0043a extends FilterOutputStream {
            public C0043a(OutputStream outputStream) {
                super(outputStream);
                e.this.g = 0;
            }

            public void write(int i) {
                this.out.write(i);
                e eVar = e.this;
                eVar.g++;
                NotificationCompat.Builder builder = eVar.f854e;
                if (builder != null && eVar.f853d != null) {
                    builder.setProgress((int) eVar.f852c, i, false);
                    e eVar2 = e.this;
                    eVar2.f853d.notify(eVar2.f, eVar2.f854e.build());
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                this.out.write(bArr, i, i2);
                e eVar = e.this;
                long j = eVar.g + ((long) i2);
                eVar.g = j;
                NotificationCompat.Builder builder = eVar.f854e;
                if (builder != null && eVar.f853d != null) {
                    builder.setProgress((int) eVar.f852c, (int) j, false);
                    e eVar2 = e.this;
                    eVar2.f853d.notify(eVar2.f, eVar2.f854e.build());
                }
            }
        }
    }
}
