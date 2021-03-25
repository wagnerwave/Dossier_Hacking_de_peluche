package e.a.a.f0.g;

import e.a.a.l0.a;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final a f4915e = b(e.f4923a, ": ");
    public static final a f = b(e.f4923a, "\r\n");
    public static final a g = b(e.f4923a, "--");

    /* renamed from: a  reason: collision with root package name */
    public final Charset f4916a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4917b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a> f4918c;

    /* renamed from: d  reason: collision with root package name */
    public final d f4919d;

    public c(String str, Charset charset, String str2, d dVar) {
        if (str2 != null) {
            this.f4916a = charset == null ? e.f4923a : charset;
            this.f4917b = str2;
            this.f4918c = new ArrayList();
            this.f4919d = dVar;
            return;
        }
        throw new IllegalArgumentException("Multipart boundary may not be null");
    }

    public static a b(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        a aVar = new a(encode.remaining());
        aVar.a(encode.array(), encode.position(), encode.remaining());
        return aVar;
    }

    public static void c(a aVar, OutputStream outputStream) {
        outputStream.write(aVar.f5181a, 0, aVar.f5182b);
    }

    public static void d(f fVar, Charset charset, OutputStream outputStream) {
        a b2 = b(charset, fVar.f4924a);
        outputStream.write(b2.f5181a, 0, b2.f5182b);
        c(f4915e, outputStream);
        a b3 = b(charset, fVar.f4925b);
        outputStream.write(b3.f5181a, 0, b3.f5182b);
        c(f, outputStream);
    }

    public final void a(d dVar, OutputStream outputStream, boolean z) {
        a b2 = b(this.f4916a, this.f4917b);
        for (a next : this.f4918c) {
            c(g, outputStream);
            outputStream.write(b2.f5181a, 0, b2.f5182b);
            c(f, outputStream);
            b bVar = next.f4911b;
            int ordinal = dVar.ordinal();
            if (ordinal == 0) {
                Iterator<f> it = bVar.iterator();
                while (it.hasNext()) {
                    f next2 = it.next();
                    a b3 = b(e.f4923a, next2.f4924a);
                    outputStream.write(b3.f5181a, 0, b3.f5182b);
                    c(f4915e, outputStream);
                    a b4 = b(e.f4923a, next2.f4925b);
                    outputStream.write(b4.f5181a, 0, b4.f5182b);
                    c(f, outputStream);
                }
            } else if (ordinal == 1) {
                d(next.f4911b.c("Content-Disposition"), this.f4916a, outputStream);
                if (next.f4912c.c() != null) {
                    d(next.f4911b.c("Content-Type"), this.f4916a, outputStream);
                }
            }
            c(f, outputStream);
            if (z) {
                next.f4912c.writeTo(outputStream);
            }
            c(f, outputStream);
        }
        c(g, outputStream);
        outputStream.write(b2.f5181a, 0, b2.f5182b);
        c(g, outputStream);
        c(f, outputStream);
    }
}
