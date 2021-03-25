package a.d.c.q.a;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.IOException;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f2907a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f2908b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2909c;

    public b(Activity activity) {
        this.f2907a = activity;
        a();
    }

    public void a() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f2907a);
        Activity activity = this.f2907a;
        boolean z = defaultSharedPreferences.getBoolean("preferences_play_beep", true);
        if (z && ((AudioManager) activity.getSystemService("audio")).getRingerMode() != 2) {
            z = false;
        }
        this.f2909c = z;
        defaultSharedPreferences.getBoolean("preferences_vibrate", false);
        if (this.f2909c && this.f2908b == null) {
            this.f2907a.setVolumeControlStream(3);
            Activity activity2 = this.f2907a;
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setOnCompletionListener(new a());
            AssetFileDescriptor openRawResourceFd = activity2.getResources().openRawResourceFd(p.beep);
            try {
                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
            } catch (IOException e2) {
                Log.w("b", e2);
                mediaPlayer = null;
            }
            this.f2908b = mediaPlayer;
        }
    }
}
