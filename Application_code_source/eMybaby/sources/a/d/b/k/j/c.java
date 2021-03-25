package a.d.b.k.j;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final File f2815a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final a.d.b.c f2816b;

    public enum a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public c(@NonNull a.d.b.c cVar) {
        cVar.a();
        File filesDir = cVar.f2715a.getFilesDir();
        StringBuilder n = a.a.a.a.a.n("PersistedInstallation.");
        n.append(cVar.c());
        n.append(".json");
        this.f2815a = new File(filesDir, n.toString());
        this.f2816b = cVar;
    }

    @NonNull
    public d a(@NonNull d dVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", ((a) dVar).f2802a);
            jSONObject.put("Status", ((a) dVar).f2803b.ordinal());
            jSONObject.put("AuthToken", ((a) dVar).f2804c);
            jSONObject.put("RefreshToken", ((a) dVar).f2805d);
            jSONObject.put("TokenCreationEpochInSecs", ((a) dVar).f);
            jSONObject.put("ExpiresInSecs", ((a) dVar).f2806e);
            jSONObject.put("FisError", ((a) dVar).g);
            a.d.b.c cVar = this.f2816b;
            cVar.a();
            File createTempFile = File.createTempFile("PersistedInstallation", "tmp", cVar.f2715a.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (createTempFile.renameTo(this.f2815a)) {
                return dVar;
            }
            throw new IOException("unable to rename the tmpfile to PersistedInstallation");
        } catch (IOException | JSONException unused) {
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.b.k.j.d b() {
        /*
            r11 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 16384(0x4000, float:2.2959E-41)
            byte[] r2 = new byte[r1]
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException | JSONException -> 0x002d }
            java.io.File r5 = r11.f2815a     // Catch:{ IOException | JSONException -> 0x002d }
            r4.<init>(r5)     // Catch:{ IOException | JSONException -> 0x002d }
        L_0x0011:
            int r5 = r4.read(r2, r3, r1)     // Catch:{ all -> 0x0028 }
            if (r5 >= 0) goto L_0x0024
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0028 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0028 }
            r1.<init>(r0)     // Catch:{ all -> 0x0028 }
            r4.close()     // Catch:{ IOException | JSONException -> 0x002d }
            goto L_0x0032
        L_0x0024:
            r0.write(r2, r3, r5)     // Catch:{ all -> 0x0028 }
            goto L_0x0011
        L_0x0028:
            r0 = move-exception
            r4.close()     // Catch:{ all -> 0x002c }
        L_0x002c:
            throw r0     // Catch:{ IOException | JSONException -> 0x002d }
        L_0x002d:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
        L_0x0032:
            r0 = 0
            java.lang.String r2 = "Fid"
            java.lang.String r2 = r1.optString(r2, r0)
            java.lang.String r4 = "Status"
            int r3 = r1.optInt(r4, r3)
            java.lang.String r4 = "AuthToken"
            java.lang.String r4 = r1.optString(r4, r0)
            java.lang.String r5 = "RefreshToken"
            java.lang.String r5 = r1.optString(r5, r0)
            r6 = 0
            java.lang.String r8 = "TokenCreationEpochInSecs"
            long r8 = r1.optLong(r8, r6)
            java.lang.String r10 = "ExpiresInSecs"
            long r6 = r1.optLong(r10, r6)
            java.lang.String r10 = "FisError"
            java.lang.String r0 = r1.optString(r10, r0)
            a.d.b.k.j.d$a r1 = a.d.b.k.j.d.a()
            a.d.b.k.j.a$b r1 = (a.d.b.k.j.a.b) r1
            r1.f2807a = r2
            a.d.b.k.j.c$a[] r2 = a.d.b.k.j.c.a.values()
            r2 = r2[r3]
            r1.c(r2)
            r1.f2809c = r4
            r1.f2810d = r5
            r1.d(r8)
            r1.b(r6)
            r1.g = r0
            a.d.b.k.j.d r0 = r1.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.b.k.j.c.b():a.d.b.k.j.d");
    }
}
