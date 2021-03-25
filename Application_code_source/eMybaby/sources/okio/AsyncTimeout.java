package okio;

import a.a.a.a.a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class AsyncTimeout extends Timeout {
    public static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    public static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    public static final int TIMEOUT_WRITE_SIZE = 65536;
    public static AsyncTimeout head;
    public boolean inQueue;
    public AsyncTimeout next;
    public long timeoutAt;

    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.timedOut();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                okio.AsyncTimeout r1 = okio.AsyncTimeout.awaitTimeout()     // Catch:{ all -> 0x001c }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x001c }
                goto L_0x0000
            L_0x000b:
                okio.AsyncTimeout r2 = okio.AsyncTimeout.head     // Catch:{ all -> 0x001c }
                if (r1 != r2) goto L_0x0017
                r1 = 0
                okio.AsyncTimeout unused = okio.AsyncTimeout.head = r1     // Catch:{ all -> 0x001c }
                monitor-exit(r0)     // Catch:{ all -> 0x001c }
                return
            L_0x0017:
                monitor-exit(r0)     // Catch:{ all -> 0x001c }
                r1.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x001c:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x001c }
                goto L_0x0020
            L_0x001f:
                throw r1
            L_0x0020:
                goto L_0x001f
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    public static AsyncTimeout awaitTimeout() {
        Class<AsyncTimeout> cls = AsyncTimeout.class;
        AsyncTimeout asyncTimeout = head.next;
        long nanoTime = System.nanoTime();
        if (asyncTimeout == null) {
            cls.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
        if (remainingNanos > 0) {
            long j = remainingNanos / 1000000;
            cls.wait(j, (int) (remainingNanos - (1000000 * j)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    public static synchronized boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
        boolean z;
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = head;
            while (true) {
                if (asyncTimeout2 == null) {
                    z = true;
                    break;
                } else if (asyncTimeout2.next == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    z = false;
                    break;
                } else {
                    asyncTimeout2 = asyncTimeout2.next;
                }
            }
        }
        return z;
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0054 A[EDGE_INSN: B:34:0x0054->B:23:0x0054 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void scheduleTimeout(okio.AsyncTimeout r6, long r7, boolean r9) {
        /*
            java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
            monitor-enter(r0)
            okio.AsyncTimeout r1 = head     // Catch:{ all -> 0x0069 }
            if (r1 != 0) goto L_0x0016
            okio.AsyncTimeout r1 = new okio.AsyncTimeout     // Catch:{ all -> 0x0069 }
            r1.<init>()     // Catch:{ all -> 0x0069 }
            head = r1     // Catch:{ all -> 0x0069 }
            okio.AsyncTimeout$Watchdog r1 = new okio.AsyncTimeout$Watchdog     // Catch:{ all -> 0x0069 }
            r1.<init>()     // Catch:{ all -> 0x0069 }
            r1.start()     // Catch:{ all -> 0x0069 }
        L_0x0016:
            long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0069 }
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x002f
            if (r9 == 0) goto L_0x002f
            long r3 = r6.deadlineNanoTime()     // Catch:{ all -> 0x0069 }
            long r3 = r3 - r1
            long r7 = java.lang.Math.min(r7, r3)     // Catch:{ all -> 0x0069 }
        L_0x002b:
            long r7 = r7 + r1
            r6.timeoutAt = r7     // Catch:{ all -> 0x0069 }
            goto L_0x003c
        L_0x002f:
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            goto L_0x002b
        L_0x0034:
            if (r9 == 0) goto L_0x0063
            long r7 = r6.deadlineNanoTime()     // Catch:{ all -> 0x0069 }
            r6.timeoutAt = r7     // Catch:{ all -> 0x0069 }
        L_0x003c:
            long r7 = r6.remainingNanos(r1)     // Catch:{ all -> 0x0069 }
            okio.AsyncTimeout r9 = head     // Catch:{ all -> 0x0069 }
        L_0x0042:
            okio.AsyncTimeout r3 = r9.next     // Catch:{ all -> 0x0069 }
            if (r3 == 0) goto L_0x0054
            okio.AsyncTimeout r3 = r9.next     // Catch:{ all -> 0x0069 }
            long r3 = r3.remainingNanos(r1)     // Catch:{ all -> 0x0069 }
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0051
            goto L_0x0054
        L_0x0051:
            okio.AsyncTimeout r9 = r9.next     // Catch:{ all -> 0x0069 }
            goto L_0x0042
        L_0x0054:
            okio.AsyncTimeout r7 = r9.next     // Catch:{ all -> 0x0069 }
            r6.next = r7     // Catch:{ all -> 0x0069 }
            r9.next = r6     // Catch:{ all -> 0x0069 }
            okio.AsyncTimeout r6 = head     // Catch:{ all -> 0x0069 }
            if (r9 != r6) goto L_0x0061
            r0.notify()     // Catch:{ all -> 0x0069 }
        L_0x0061:
            monitor-exit(r0)
            return
        L_0x0063:
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch:{ all -> 0x0069 }
            r6.<init>()     // Catch:{ all -> 0x0069 }
            throw r6     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r6 = move-exception
            monitor-exit(r0)
            goto L_0x006d
        L_0x006c:
            throw r6
        L_0x006d:
            goto L_0x006c
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.scheduleTimeout(okio.AsyncTimeout, long, boolean):void");
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final IOException exit(IOException iOException) {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    public final void exit(boolean z) {
        if (exit() && z) {
            throw newTimeoutException((IOException) null);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        return new Sink() {
            public void close() {
                AsyncTimeout.this.enter();
                try {
                    sink.close();
                    AsyncTimeout.this.exit(true);
                } catch (IOException e2) {
                    throw AsyncTimeout.this.exit(e2);
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            public void flush() {
                AsyncTimeout.this.enter();
                try {
                    sink.flush();
                    AsyncTimeout.this.exit(true);
                } catch (IOException e2) {
                    throw AsyncTimeout.this.exit(e2);
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                StringBuilder n = a.n("AsyncTimeout.sink(");
                n.append(sink);
                n.append(")");
                return n.toString();
            }

            public void write(Buffer buffer, long j) {
                Util.checkOffsetAndCount(buffer.size, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        Segment segment = buffer.head;
                        while (true) {
                            if (j2 >= 65536) {
                                break;
                            }
                            Segment segment2 = buffer.head;
                            j2 += (long) (segment2.limit - segment2.pos);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            segment = segment.next;
                        }
                        AsyncTimeout.this.enter();
                        try {
                            sink.write(buffer, j2);
                            j -= j2;
                            AsyncTimeout.this.exit(true);
                        } catch (IOException e2) {
                            throw AsyncTimeout.this.exit(e2);
                        } catch (Throwable th) {
                            AsyncTimeout.this.exit(false);
                            throw th;
                        }
                    } else {
                        return;
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        return new Source() {
            public void close() {
                try {
                    source.close();
                    AsyncTimeout.this.exit(true);
                } catch (IOException e2) {
                    throw AsyncTimeout.this.exit(e2);
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            public long read(Buffer buffer, long j) {
                AsyncTimeout.this.enter();
                try {
                    long read = source.read(buffer, j);
                    AsyncTimeout.this.exit(true);
                    return read;
                } catch (IOException e2) {
                    throw AsyncTimeout.this.exit(e2);
                } catch (Throwable th) {
                    AsyncTimeout.this.exit(false);
                    throw th;
                }
            }

            public Timeout timeout() {
                return AsyncTimeout.this;
            }

            public String toString() {
                StringBuilder n = a.n("AsyncTimeout.source(");
                n.append(source);
                n.append(")");
                return n.toString();
            }
        };
    }

    public void timedOut() {
    }
}
