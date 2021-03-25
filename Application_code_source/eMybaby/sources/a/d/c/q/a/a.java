package a.d.c.q.a;

import android.media.MediaPlayer;

public final class a implements MediaPlayer.OnCompletionListener {
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.seekTo(0);
    }
}
