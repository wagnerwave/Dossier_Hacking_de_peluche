package e.a.a.f0.g;

import a.a.a.a.a;
import e.a.a.c;
import e.a.a.i0.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Random;

public class g implements e.a.a.g {

    /* renamed from: e  reason: collision with root package name */
    public static final char[] f4926e = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    public final c f4927a;

    /* renamed from: b  reason: collision with root package name */
    public final c f4928b;

    /* renamed from: c  reason: collision with root package name */
    public long f4929c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f4930d;

    public g() {
        d dVar = d.STRICT;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            char[] cArr = f4926e;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        String sb2 = sb.toString();
        this.f4927a = new c("form-data", (Charset) null, sb2, dVar);
        this.f4928b = new b("Content-Type", a.k("multipart/form-data; boundary=", sb2));
        this.f4930d = true;
    }

    public void a(String str, e.a.a.f0.g.h.b bVar) {
        a aVar = new a(str, bVar);
        c cVar = this.f4927a;
        if (cVar != null) {
            cVar.f4918c.add(aVar);
            this.f4930d = true;
            return;
        }
        throw null;
    }

    public c b() {
        return null;
    }

    public boolean c() {
        return !isRepeatable();
    }

    public InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public long getContentLength() {
        long j;
        if (this.f4930d) {
            c cVar = this.f4927a;
            Iterator<a> it = cVar.f4918c.iterator();
            long j2 = 0;
            while (true) {
                j = -1;
                if (it.hasNext()) {
                    long contentLength = it.next().f4912c.getContentLength();
                    if (contentLength < 0) {
                        break;
                    }
                    j2 += contentLength;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        cVar.a(cVar.f4919d, byteArrayOutputStream, false);
                        j = j2 + ((long) byteArrayOutputStream.toByteArray().length);
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            this.f4929c = j;
            this.f4930d = false;
        }
        return this.f4929c;
    }

    public c getContentType() {
        return this.f4928b;
    }

    public boolean isRepeatable() {
        for (a aVar : this.f4927a.f4918c) {
            if (aVar.f4912c.getContentLength() < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isStreaming() {
        return !isRepeatable();
    }
}
