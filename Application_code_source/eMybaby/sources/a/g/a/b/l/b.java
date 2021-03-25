package a.g.a.b.l;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class b extends BufferedInputStream {
    public b(InputStream inputStream, int i) {
        super(inputStream, i);
    }

    public long skip(long j) {
        long j2 = 0;
        while (j2 < j) {
            long skip = this.in.skip(j - j2);
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                skip = 1;
            }
            j2 += skip;
        }
        return j2;
    }
}
