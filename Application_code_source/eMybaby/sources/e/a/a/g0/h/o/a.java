package e.a.a.g0.h.o;

import e.a.a.g0.h.j;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.logging.LogFactory;

@Deprecated
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final Lock f5035a;

    /* renamed from: b  reason: collision with root package name */
    public Set<b> f5036b = new HashSet();

    public a() {
        LogFactory.getLog(getClass());
        LogFactory.getLog(j.class);
        new HashMap();
        this.f5035a = new ReentrantLock();
    }
}
