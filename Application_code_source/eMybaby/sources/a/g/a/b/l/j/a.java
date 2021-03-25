package a.g.a.b.l.j;

import a.g.a.b.l.j.b;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

public class a<T> extends b<T> {
    public boolean offer(T t) {
        if (t != null) {
            b.d<E> dVar = new b.d<>(t);
            ReentrantLock reentrantLock = this.f3435e;
            reentrantLock.lock();
            try {
                boolean z = true;
                if (this.f3433c >= this.f3434d) {
                    z = false;
                } else {
                    b.d<E> dVar2 = this.f3431a;
                    dVar.f3443c = dVar2;
                    this.f3431a = dVar;
                    if (this.f3432b == null) {
                        this.f3432b = dVar;
                    } else {
                        dVar2.f3442b = dVar;
                    }
                    this.f3433c++;
                    this.f.signal();
                }
                return z;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw null;
        }
    }

    public T remove() {
        ReentrantLock reentrantLock = this.f3435e;
        reentrantLock.lock();
        try {
            T h = h();
            if (h != null) {
                return h;
            }
            throw new NoSuchElementException();
        } finally {
            reentrantLock.unlock();
        }
    }
}
