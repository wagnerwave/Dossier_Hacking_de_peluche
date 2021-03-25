package okhttp3.internal.cache2;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import okio.Buffer;

public final class FileOperator {
    public static final int BUFFER_SIZE = 8192;
    public final byte[] byteArray;
    public final ByteBuffer byteBuffer;
    public final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel2) {
        byte[] bArr = new byte[8192];
        this.byteArray = bArr;
        this.byteBuffer = ByteBuffer.wrap(bArr);
        this.fileChannel = fileChannel2;
    }

    public void read(long j, Buffer buffer, long j2) {
        if (j2 >= 0) {
            while (j2 > 0) {
                try {
                    this.byteBuffer.limit((int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_URI, j2));
                    if (this.fileChannel.read(this.byteBuffer, j) != -1) {
                        int position = this.byteBuffer.position();
                        buffer.write(this.byteArray, 0, position);
                        long j3 = (long) position;
                        j += j3;
                        j2 -= j3;
                    } else {
                        throw new EOFException();
                    }
                } finally {
                    this.byteBuffer.clear();
                }
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public void write(long j, Buffer buffer, long j2) {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            try {
                int min = (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_URI, j2);
                buffer.read(this.byteArray, 0, min);
                this.byteBuffer.limit(min);
                do {
                    j += (long) this.fileChannel.write(this.byteBuffer, j);
                } while (this.byteBuffer.hasRemaining());
                j2 -= (long) min;
            } finally {
                this.byteBuffer.clear();
            }
        }
    }
}
