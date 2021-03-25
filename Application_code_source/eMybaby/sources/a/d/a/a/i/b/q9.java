package a.d.a.a.i.b;

import a.d.a.a.e.q.c;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import java.util.List;
import java.util.Map;

public final class q9 implements d4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2489a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o9 f2490b;

    public q9(o9 o9Var, String str) {
        this.f2490b = o9Var;
        this.f2489a = str;
    }

    /* JADX INFO: finally extract failed */
    public final void a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        d J;
        o9 o9Var = this.f2490b;
        o9Var.T();
        o9Var.O();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                o9Var.r = false;
                o9Var.w();
                throw th2;
            }
        }
        List<Long> list = o9Var.v;
        o9Var.v = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                o4 o4Var = o9Var.j.o().f2317e;
                if (((c) o9Var.j.n) != null) {
                    o4Var.b(System.currentTimeMillis());
                    o9Var.j.o().f.b(0);
                    o9Var.v();
                    o9Var.j.i().n.c("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                    o9Var.J().b0();
                    try {
                        for (Long next : list) {
                            try {
                                J = o9Var.J();
                                long longValue = next.longValue();
                                J.b();
                                J.n();
                                if (J.t().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e2) {
                                J.i().f.b("Failed to delete a bundle in a queue table", e2);
                                throw e2;
                            } catch (SQLiteException e3) {
                                if (o9Var.w == null || !o9Var.w.contains(next)) {
                                    throw e3;
                                }
                            }
                        }
                        o9Var.J().s();
                        o9Var.J().e0();
                        o9Var.w = null;
                        if (!o9Var.I().u() || !o9Var.u()) {
                            o9Var.x = -1;
                            o9Var.v();
                        } else {
                            o9Var.P();
                        }
                        o9Var.m = 0;
                    } catch (Throwable th3) {
                        o9Var.J().e0();
                        throw th3;
                    }
                } else {
                    throw null;
                }
            } catch (SQLiteException e4) {
                o9Var.j.i().f.b("Database error while trying to delete uploaded bundles", e4);
                if (((c) o9Var.j.n) != null) {
                    o9Var.m = SystemClock.elapsedRealtime();
                    o9Var.j.i().n.b("Disable upload, time", Long.valueOf(o9Var.m));
                } else {
                    throw null;
                }
            }
        } else {
            o9Var.j.i().n.c("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            o4 o4Var2 = o9Var.j.o().f;
            if (((c) o9Var.j.n) != null) {
                o4Var2.b(System.currentTimeMillis());
                if (i != 503) {
                    if (i != 429) {
                        z = false;
                    }
                }
                if (z) {
                    o4 o4Var3 = o9Var.j.o().g;
                    if (((c) o9Var.j.n) != null) {
                        o4Var3.b(System.currentTimeMillis());
                    } else {
                        throw null;
                    }
                }
                o9Var.J().J(list);
                o9Var.v();
            } else {
                throw null;
            }
        }
        o9Var.r = false;
        o9Var.w();
    }
}
