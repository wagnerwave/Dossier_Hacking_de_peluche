package okhttp3.internal.http2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class Ping {
    public final CountDownLatch latch = new CountDownLatch(1);
    public long received = -1;
    public long sent = -1;

    public void cancel() {
        if (this.received == -1) {
            long j = this.sent;
            if (j != -1) {
                this.received = j - 1;
                this.latch.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void receive() {
        if (this.received != -1 || this.sent == -1) {
            throw new IllegalStateException();
        }
        this.received = System.nanoTime();
        this.latch.countDown();
    }

    public long roundTripTime() {
        this.latch.await();
        return this.received - this.sent;
    }

    public long roundTripTime(long j, TimeUnit timeUnit) {
        if (this.latch.await(j, timeUnit)) {
            return this.received - this.sent;
        }
        return -2;
    }

    public void send() {
        if (this.sent == -1) {
            this.sent = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }
}
