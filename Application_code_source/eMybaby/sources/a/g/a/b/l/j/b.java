package a.g.a.b.l.j;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.HttpUrl;

public class b<E> extends AbstractQueue<E> implements Object<E>, Serializable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public transient d<E> f3431a;

    /* renamed from: b  reason: collision with root package name */
    public transient d<E> f3432b;

    /* renamed from: c  reason: collision with root package name */
    public transient int f3433c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3434d = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public final ReentrantLock f3435e;
    public final Condition f;
    public final Condition g = this.f3435e.newCondition();

    /* renamed from: a.g.a.b.l.j.b$b  reason: collision with other inner class name */
    public abstract class C0081b implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        public d<E> f3436a;

        /* renamed from: b  reason: collision with root package name */
        public E f3437b;

        /* renamed from: c  reason: collision with root package name */
        public d<E> f3438c;

        public C0081b() {
            ReentrantLock reentrantLock = b.this.f3435e;
            reentrantLock.lock();
            try {
                d<E> dVar = b.this.f3431a;
                this.f3436a = dVar;
                this.f3437b = dVar == null ? null : dVar.f3441a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public boolean hasNext() {
            return this.f3436a != null;
        }

        public E next() {
            d<E> dVar;
            E e2;
            d<E> dVar2 = this.f3436a;
            if (dVar2 != null) {
                this.f3438c = dVar2;
                E e3 = this.f3437b;
                ReentrantLock reentrantLock = b.this.f3435e;
                reentrantLock.lock();
                try {
                    d<E> dVar3 = this.f3436a;
                    while (true) {
                        dVar = dVar3.f3443c;
                        e2 = null;
                        if (dVar == null) {
                            dVar = null;
                            break;
                        } else if (dVar.f3441a != null) {
                            break;
                        } else if (dVar == dVar3) {
                            dVar = b.this.f3431a;
                            break;
                        } else {
                            dVar3 = dVar;
                        }
                    }
                    this.f3436a = dVar;
                    if (dVar != null) {
                        e2 = dVar.f3441a;
                    }
                    this.f3437b = e2;
                    return e3;
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            d<E> dVar = this.f3438c;
            if (dVar != null) {
                this.f3438c = null;
                ReentrantLock reentrantLock = b.this.f3435e;
                reentrantLock.lock();
                try {
                    if (dVar.f3441a != null) {
                        b.this.e(dVar);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public class c extends b<E>.b {
        public c(a aVar) {
            super();
        }
    }

    public static final class d<E> {

        /* renamed from: a  reason: collision with root package name */
        public E f3441a;

        /* renamed from: b  reason: collision with root package name */
        public d<E> f3442b;

        /* renamed from: c  reason: collision with root package name */
        public d<E> f3443c;

        public d(E e2) {
            this.f3441a = e2;
        }
    }

    public b() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f3435e = reentrantLock;
        this.f = reentrantLock.newCondition();
    }

    public boolean add(E e2) {
        if (e2 != null) {
            d dVar = new d(e2);
            ReentrantLock reentrantLock = this.f3435e;
            reentrantLock.lock();
            try {
                if (c(dVar)) {
                    return true;
                }
                throw new IllegalStateException("Deque full");
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw null;
        }
    }

    public final boolean c(d<E> dVar) {
        if (this.f3433c >= this.f3434d) {
            return false;
        }
        d<E> dVar2 = this.f3432b;
        dVar.f3442b = dVar2;
        this.f3432b = dVar;
        if (this.f3431a == null) {
            this.f3431a = dVar;
        } else {
            dVar2.f3443c = dVar;
        }
        this.f3433c++;
        this.f.signal();
        return true;
    }

    public void clear() {
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lock();
        try {
            d<E> dVar = this.f3431a;
            while (dVar != null) {
                dVar.f3441a = null;
                d<E> dVar2 = dVar.f3443c;
                dVar.f3442b = null;
                dVar.f3443c = null;
                dVar = dVar2;
            }
            this.f3432b = null;
            this.f3431a = null;
            this.f3433c = 0;
            this.g.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lock();
        try {
            for (d<E> dVar = this.f3431a; dVar != null; dVar = dVar.f3443c) {
                if (obj.equals(dVar.f3441a)) {
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E d() {
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lock();
        try {
            return this.f3431a == null ? null : this.f3431a.f3441a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw null;
        } else if (collection != this) {
            ReentrantLock reentrantLock = this.f3435e;
            reentrantLock.lock();
            try {
                int min = Math.min(i, this.f3433c);
                for (int i2 = 0; i2 < min; i2++) {
                    collection.add(this.f3431a.f3441a);
                    h();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void e(d<E> dVar) {
        d<E> dVar2 = dVar.f3442b;
        d<E> dVar3 = dVar.f3443c;
        if (dVar2 == null) {
            h();
        } else if (dVar3 == null) {
            d<E> dVar4 = this.f3432b;
            if (dVar4 != null) {
                d<E> dVar5 = dVar4.f3442b;
                dVar4.f3441a = null;
                dVar4.f3442b = dVar4;
                this.f3432b = dVar5;
                if (dVar5 == null) {
                    this.f3431a = null;
                } else {
                    dVar5.f3443c = null;
                }
                this.f3433c--;
                this.g.signal();
            }
        } else {
            dVar2.f3443c = dVar3;
            dVar3.f3442b = dVar2;
            dVar.f3441a = null;
            this.f3433c--;
            this.g.signal();
        }
    }

    public E element() {
        E d2 = d();
        if (d2 != null) {
            return d2;
        }
        throw new NoSuchElementException();
    }

    public final E h() {
        d<E> dVar = this.f3431a;
        if (dVar == null) {
            return null;
        }
        d<E> dVar2 = dVar.f3443c;
        E e2 = dVar.f3441a;
        dVar.f3441a = null;
        dVar.f3443c = dVar;
        this.f3431a = dVar2;
        if (dVar2 == null) {
            this.f3432b = null;
        } else {
            dVar2.f3442b = null;
        }
        this.f3433c--;
        this.g.signal();
        return e2;
    }

    public Iterator<E> iterator() {
        return new c((a) null);
    }

    public boolean offer(E e2, long j, TimeUnit timeUnit) {
        boolean z;
        if (e2 != null) {
            d dVar = new d(e2);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.f3435e;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    if (c(dVar)) {
                        z = true;
                        break;
                    } else if (nanos <= 0) {
                        z = false;
                        break;
                    } else {
                        nanos = this.g.awaitNanos(nanos);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            return z;
        }
        throw null;
    }

    public E peek() {
        return d();
    }

    public E poll() {
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lock();
        try {
            return h();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void put(E e2) {
        if (e2 != null) {
            d dVar = new d(e2);
            ReentrantLock reentrantLock = this.f3435e;
            reentrantLock.lock();
            while (!c(dVar)) {
                try {
                    this.g.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            return;
        }
        throw null;
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lock();
        try {
            return this.f3434d - this.f3433c;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean remove(Object obj) {
        boolean z = false;
        if (obj != null) {
            ReentrantLock reentrantLock = this.f3435e;
            reentrantLock.lock();
            try {
                d<E> dVar = this.f3431a;
                while (true) {
                    if (dVar == null) {
                        break;
                    } else if (obj.equals(dVar.f3441a)) {
                        e(dVar);
                        z = true;
                        break;
                    } else {
                        dVar = dVar.f3443c;
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return z;
    }

    public int size() {
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lock();
        try {
            return this.f3433c;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() {
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lock();
        while (true) {
            try {
                E h = h();
                if (h != null) {
                    return h;
                }
                this.f.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public Object[] toArray() {
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.f3433c];
            int i = 0;
            d<E> dVar = this.f3431a;
            while (dVar != null) {
                int i2 = i + 1;
                objArr[i] = dVar.f3441a;
                dVar = dVar.f3443c;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lock();
        try {
            int length = tArr.length;
            T[] tArr2 = tArr;
            if (length < this.f3433c) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f3433c);
            }
            int i = 0;
            d<E> dVar = this.f3431a;
            while (dVar != null) {
                tArr2[i] = dVar.f3441a;
                dVar = dVar.f3443c;
                i++;
            }
            if (tArr2.length > i) {
                tArr2[i] = null;
            }
            return tArr2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public String toString() {
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lock();
        try {
            d<E> dVar = this.f3431a;
            if (dVar == null) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                E e2 = dVar.f3441a;
                if (e2 == this) {
                    e2 = "(this Collection)";
                }
                sb.append(e2);
                dVar = dVar.f3443c;
                if (dVar == null) {
                    sb.append(']');
                    String sb2 = sb.toString();
                    reentrantLock.unlock();
                    return sb2;
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public E poll(long j, TimeUnit timeUnit) {
        E h;
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                h = h();
                if (h != null) {
                    break;
                } else if (nanos <= 0) {
                    h = null;
                    break;
                } else {
                    nanos = this.f.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return h;
    }
}
