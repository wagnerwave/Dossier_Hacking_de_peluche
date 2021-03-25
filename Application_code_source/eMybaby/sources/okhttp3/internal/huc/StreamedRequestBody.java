package okhttp3.internal.huc;

import android.support.v4.media.session.PlaybackStateCompat;
import okhttp3.internal.http.UnrepeatableRequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;

public final class StreamedRequestBody extends OutputStreamRequestBody implements UnrepeatableRequestBody {
    public final Pipe pipe;

    public StreamedRequestBody(long j) {
        Pipe pipe2 = new Pipe(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        this.pipe = pipe2;
        initOutputStream(Okio.buffer(pipe2.sink()), j);
    }

    public void writeTo(BufferedSink bufferedSink) {
        Buffer buffer = new Buffer();
        while (this.pipe.source().read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            bufferedSink.write(buffer, buffer.size());
        }
    }
}
