package e.a.a.d0;

import e.a.a.g0.h.a;
import java.io.IOException;
import java.io.InputStream;

public class h extends InputStream implements g {

    /* renamed from: a  reason: collision with root package name */
    public InputStream f4858a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4859b;

    /* renamed from: c  reason: collision with root package name */
    public final a f4860c;

    public h(InputStream inputStream, a aVar) {
        if (inputStream != null) {
            this.f4858a = inputStream;
            this.f4859b = false;
            this.f4860c = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped stream may not be null.");
    }

    public void a() {
        if (this.f4858a != null) {
            boolean z = true;
            try {
                if (this.f4860c != null) {
                    a aVar = this.f4860c.f4856b;
                    if (aVar != null) {
                        aVar.i();
                    }
                    z = false;
                }
                if (z) {
                    this.f4858a.close();
                }
            } finally {
                this.f4858a = null;
            }
        }
    }

    public int available() {
        if (!c()) {
            return 0;
        }
        try {
            return this.f4858a.available();
        } catch (IOException e2) {
            a();
            throw e2;
        }
    }

    public void b(int i) {
        a aVar;
        InputStream inputStream = this.f4858a;
        if (inputStream != null && i < 0) {
            try {
                boolean z = true;
                if (this.f4860c != null) {
                    aVar = this.f4860c;
                    if (aVar != null) {
                        if (aVar.f4857c && aVar.f4856b != null) {
                            inputStream.close();
                            aVar.f4856b.f5007c = true;
                        }
                        aVar.d();
                        z = false;
                    } else {
                        throw null;
                    }
                }
                if (z) {
                    this.f4858a.close();
                }
                this.f4858a = null;
            } catch (Throwable th) {
                this.f4858a = null;
                throw th;
            }
        }
    }

    public boolean c() {
        if (!this.f4859b) {
            return this.f4858a != null;
        }
        throw new IOException("Attempted read on closed stream.");
    }

    public void close() {
        a aVar;
        boolean z = true;
        this.f4859b = true;
        InputStream inputStream = this.f4858a;
        if (inputStream != null) {
            try {
                if (this.f4860c != null) {
                    aVar = this.f4860c;
                    if (aVar != null) {
                        if (aVar.f4857c && aVar.f4856b != null) {
                            inputStream.close();
                            aVar.f4856b.f5007c = true;
                        }
                        aVar.d();
                        z = false;
                    } else {
                        throw null;
                    }
                }
                if (z) {
                    this.f4858a.close();
                }
                this.f4858a = null;
            } catch (Throwable th) {
                this.f4858a = null;
                throw th;
            }
        }
    }

    public int read() {
        if (!c()) {
            return -1;
        }
        try {
            int read = this.f4858a.read();
            b(read);
            return read;
        } catch (IOException e2) {
            a();
            throw e2;
        }
    }

    public int read(byte[] bArr) {
        if (!c()) {
            return -1;
        }
        try {
            int read = this.f4858a.read(bArr);
            b(read);
            return read;
        } catch (IOException e2) {
            a();
            throw e2;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        if (!c()) {
            return -1;
        }
        try {
            int read = this.f4858a.read(bArr, i, i2);
            b(read);
            return read;
        } catch (IOException e2) {
            a();
            throw e2;
        }
    }
}
