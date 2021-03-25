package com.cuatroochenta.miniland.player;

import a.c.a.e.f;
import a.c.a.f.e;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.IBinder;
import com.cuatroochenta.miniland.model.Song;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayerService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f3933a = null;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Song> f3934b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Song> f3935c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public int f3936d = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3937e = false;
    public boolean f = false;
    public Thread g;
    public String h;
    public CountDownTimer i;
    public long j = 0;
    public long k = 0;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            while (PlayerService.this.f3933a != null && PlayerService.this.f3933a.isPlaying()) {
                try {
                    try {
                        PlayerService.this.h(3);
                        Thread.sleep(1000);
                    } catch (InterruptedException unused) {
                        e.b("PlayerService-> Updater thread interrupted");
                    }
                } catch (IllegalStateException unused2) {
                    e.b("PlayerService-> Updater thread Illegal Stated Player");
                    return;
                }
            }
        }
    }

    public class b extends CountDownTimer {
        public b(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            e.b("Player Service -> Countdown finished");
            PlayerService.this.b();
        }

        public void onTick(long j) {
            e.b(String.format("Player Service -> %d seconds to finish countdown ...", new Object[]{Long.valueOf(j / 1000)}));
        }
    }

    public final void b() {
        e.b("PlayerService-> finishPlaying - Stop Service");
        stopSelf();
    }

    public final String c() {
        try {
            return a.c.a.d.a.g(this.f3935c.get(this.f3936d).getTitle());
        } catch (Exception unused) {
            return "";
        }
    }

    public final void d() {
        long j2 = this.j;
        if (j2 > 0) {
            long currentTimeMillis = j2 - System.currentTimeMillis();
            this.k = currentTimeMillis;
            e.b(String.format("Player Utils-> Paused countdown remaining %d seconds", new Object[]{Long.valueOf(currentTimeMillis / 1000)}));
            l();
            h(3);
        }
    }

    public final void e(boolean z) {
        int i2;
        int i3 = this.f3936d;
        if (i3 >= 0 && i3 + 1 < this.f3935c.size()) {
            i2 = this.f3936d + 1;
        } else if (!this.f3935c.isEmpty()) {
            i2 = 0;
        } else if (z) {
            b();
            return;
        } else {
            return;
        }
        this.f3936d = i2;
        f(this.f3935c.get(i2));
    }

    public final void f(Song song) {
        this.f3933a.reset();
        try {
            this.f3933a.setDataSource(getApplicationContext(), song.getSource());
            this.f3933a.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
            e(false);
        }
    }

    public final void g(int i2) {
        this.f3936d = this.f3934b.indexOf(this.f3935c.get(i2));
        this.f3935c.clear();
        this.f3935c.addAll(this.f3934b);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(int r13) {
        /*
            r12 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.cuatroochenta.miniland.PLAYER_ACTION"
            r0.<init>(r1)
            java.lang.String r1 = "EXTRA_KEY_PLAYER_STATUS_CODE"
            r0.putExtra(r1, r13)
            java.lang.String r1 = r12.h
            java.lang.String r2 = "EXTRA_KEY_PLAYLIST_TYPE"
            r0.putExtra(r2, r1)
            boolean r1 = r12.f
            java.lang.String r2 = "EXTRA_KEY_INFO_CURRENT_TRACK"
            if (r1 == 0) goto L_0x0036
            int r1 = r12.f3936d
            if (r1 < 0) goto L_0x0036
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r3 = r12.f3935c
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0036
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r1 = r12.f3935c
            int r3 = r12.f3936d
            java.lang.Object r1 = r1.get(r3)
            com.cuatroochenta.miniland.model.Song r1 = (com.cuatroochenta.miniland.model.Song) r1
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r3 = r12.f3934b
            int r1 = r3.indexOf(r1)
            goto L_0x0038
        L_0x0036:
            int r1 = r12.f3936d
        L_0x0038:
            r0.putExtra(r2, r1)
            boolean r1 = r12.f
            java.lang.String r2 = "EXTRA_KEY_INFO_SHUFFLE_MODE"
            r0.putExtra(r2, r1)
            boolean r1 = r12.f3937e
            java.lang.String r2 = "EXTRA_KEY_INFO_IS_LOOP_MODE"
            r0.putExtra(r2, r1)
            java.lang.String r1 = r12.c()
            java.lang.String r2 = "EXTRA_KEY_INFO_CURRENT_SONG_NAME"
            r0.putExtra(r2, r1)
            android.media.MediaPlayer r1 = r12.f3933a
            if (r1 == 0) goto L_0x0079
            int r1 = r1.getCurrentPosition()
            int r1 = r1 / 1000
            java.lang.String r2 = "EXTRA_KEY_INFO_CURRENT_POSITION"
            r0.putExtra(r2, r1)
            android.media.MediaPlayer r1 = r12.f3933a
            boolean r1 = r1.isPlaying()
            java.lang.String r2 = "EXTRA_KEY_INFO_IS_PLAYING"
            r0.putExtra(r2, r1)
            android.media.MediaPlayer r1 = r12.f3933a
            int r1 = r1.getDuration()
            int r1 = r1 / 1000
            java.lang.String r2 = "EXTRA_KEY_INFO_TRACK_DURATION"
            r0.putExtra(r2, r1)
        L_0x0079:
            android.os.CountDownTimer r1 = r12.i
            r2 = 0
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.String r5 = "EXTRA_KEY_INFO_COUNTDOWN_TIMEFINISH"
            r6 = 1
            r7 = 0
            java.lang.String r9 = "EXTRA_KEY_INFO_COUNTDOWN_STATUS"
            if (r1 == 0) goto L_0x0098
            long r10 = r12.j
            int r1 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x0098
            r0.putExtra(r9, r2)
            long r7 = r12.j
            long r9 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r9
            goto L_0x00a3
        L_0x0098:
            long r10 = r12.k
            int r1 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x00a9
            r0.putExtra(r9, r6)
            long r7 = r12.k
        L_0x00a3:
            long r7 = r7 / r3
            int r1 = (int) r7
            r0.putExtra(r5, r1)
            goto L_0x00ad
        L_0x00a9:
            r1 = 2
            r0.putExtra(r9, r1)
        L_0x00ad:
            com.sozpic.miniland.AppMiniland r1 = com.sozpic.miniland.AppMiniland.f()
            boolean r1 = r1.n()
            if (r1 == 0) goto L_0x00cf
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r1[r2] = r13
            java.lang.String r13 = "PlayerService -> Send status %d to LocalBroadcast"
            java.lang.String r13 = java.lang.String.format(r13, r1)
            a.c.a.f.e.b(r13)
            androidx.localbroadcastmanager.content.LocalBroadcastManager r13 = androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(r12)
            r13.sendBroadcast(r0)
        L_0x00cf:
            r12.sendBroadcast(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.player.PlayerService.h(int):void");
    }

    public final void i(int i2) {
        Collections.shuffle(this.f3935c, new Random(System.nanoTime()));
        Song song = this.f3934b.get(i2);
        this.f3935c.remove(song);
        this.f3935c.add(0, song);
        this.f3936d = 0;
    }

    public final void j(long j2) {
        this.j = System.currentTimeMillis() + j2;
        this.k = 0;
        e.b(String.format("Player Service -> Start countdown with %d seconds", new Object[]{Long.valueOf(j2 / 1000)}));
        b bVar = new b(j2, 1000);
        this.i = bVar;
        bVar.start();
    }

    public final void k() {
        this.f3933a.setLooping(false);
        this.f3933a.start();
        h(0);
        Thread thread = new Thread(new a());
        this.g = thread;
        thread.start();
        if (this.k > 0) {
            e.b("PlayerService-> Restore timer after pause");
            j(this.k);
        }
        f.c().d("MY_BUDDY", "PLAY", a.c.a.d.a.g(c()));
    }

    public final void l() {
        CountDownTimer countDownTimer = this.i;
        if (countDownTimer != null) {
            this.j = 0;
            countDownTimer.cancel();
            this.i = null;
        }
    }

    public void onAudioFocusChange(int i2) {
        MediaPlayer mediaPlayer;
        float f2;
        MediaPlayer mediaPlayer2;
        if (i2 == -3) {
            MediaPlayer mediaPlayer3 = this.f3933a;
            if (mediaPlayer3 != null && mediaPlayer3.isPlaying()) {
                mediaPlayer = this.f3933a;
                f2 = 0.1f;
            } else {
                return;
            }
        } else if (i2 == -2) {
            MediaPlayer mediaPlayer4 = this.f3933a;
            if (mediaPlayer4 != null && mediaPlayer4.isPlaying()) {
                this.f3933a.pause();
                d();
                h(1);
                Thread thread = this.g;
                if (thread != null) {
                    thread.interrupt();
                    return;
                }
                return;
            }
            return;
        } else if (i2 == -1) {
            MediaPlayer mediaPlayer5 = this.f3933a;
            if (mediaPlayer5 != null && mediaPlayer5.isPlaying()) {
                this.f3933a.stop();
            }
            b();
            return;
        } else if (i2 == 1 && (mediaPlayer2 = this.f3933a) != null && mediaPlayer2.isPlaying()) {
            k();
            mediaPlayer = this.f3933a;
            f2 = 1.0f;
        } else {
            return;
        }
        mediaPlayer.setVolume(f2, f2);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f3937e) {
            mediaPlayer.start();
        } else {
            e(true);
        }
    }

    public void onDestroy() {
        e.b("PlayerService-> OnDestroyed");
        ((NotificationManager) getSystemService("notification")).cancel(480480);
        this.k = 0;
        l();
        MediaPlayer mediaPlayer = this.f3933a;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f3933a = null;
        }
        Thread thread = this.g;
        if (thread != null) {
            thread.interrupt();
        }
        this.f3936d = -1;
        h(2);
        super.onDestroy();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        boolean z = true;
        if (((AudioManager) getSystemService("audio")).requestAudioFocus(this, 3, 1) != 1) {
            z = false;
        }
        if (z) {
            k();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0201, code lost:
        if (r6.f3933a != null) goto L_0x0206;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r7, int r8, int r9) {
        /*
            r6 = this;
            android.media.MediaPlayer r8 = r6.f3933a
            r9 = 3
            r0 = 1
            if (r8 != 0) goto L_0x0023
            android.media.MediaPlayer r8 = new android.media.MediaPlayer
            r8.<init>()
            r6.f3933a = r8
            r8.setAudioStreamType(r9)
            android.media.MediaPlayer r8 = r6.f3933a
            r8.setOnPreparedListener(r6)
            android.media.MediaPlayer r8 = r6.f3933a
            r8.setOnCompletionListener(r6)
            android.media.MediaPlayer r8 = r6.f3933a
            android.content.Context r1 = r6.getApplicationContext()
            r8.setWakeMode(r1, r0)
        L_0x0023:
            if (r7 != 0) goto L_0x002c
            java.lang.String r7 = "Player Service-> Player stopped because intent onStartCommand is null"
            a.c.a.f.e.b(r7)
            goto L_0x0203
        L_0x002c:
            android.os.Bundle r8 = r7.getExtras()
            if (r8 == 0) goto L_0x01f7
            java.lang.String r1 = "EXTRA_KEY_PLAY_PLAYER_LIST"
            boolean r2 = r8.containsKey(r1)
            java.lang.String r3 = "EXTRA_KEY_SHUFFLE_CURRENT_LIST"
            java.lang.String r4 = "EXTRA_KEY_LOOP_CURRENT_LIST"
            r5 = 0
            if (r2 == 0) goto L_0x0094
            java.lang.String r2 = "PlayerService -> Received new playlist"
            a.c.a.f.e.b(r2)
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r2 = r6.f3935c
            r2.clear()
            java.util.ArrayList r1 = r8.getParcelableArrayList(r1)
            r6.f3934b = r1
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r2 = r6.f3935c
            r2.addAll(r1)
            boolean r1 = r8.getBoolean(r3, r5)
            r6.f = r1
            android.media.MediaPlayer r1 = r6.f3933a
            boolean r2 = r8.getBoolean(r4, r5)
            r1.setLooping(r2)
            boolean r1 = r8.getBoolean(r4, r5)
            r6.f3937e = r1
            java.lang.String r1 = "EXTRA_KEY_PLAYLIST_TYPE"
            java.lang.String r1 = r8.getString(r1)
            r6.h = r1
            boolean r1 = r6.f
            java.lang.String r2 = "EXTRA_KEY_FIRST_SONG_POSITION"
            if (r1 == 0) goto L_0x007f
            int r1 = r8.getInt(r2, r5)
            r6.i(r1)
            goto L_0x0085
        L_0x007f:
            int r1 = r8.getInt(r2, r5)
            r6.f3936d = r1
        L_0x0085:
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r1 = r6.f3935c
            int r2 = r6.f3936d
            java.lang.Object r1 = r1.get(r2)
            com.cuatroochenta.miniland.model.Song r1 = (com.cuatroochenta.miniland.model.Song) r1
            r6.f(r1)
            goto L_0x0176
        L_0x0094:
            boolean r1 = r8.containsKey(r4)
            if (r1 == 0) goto L_0x00ad
            boolean r1 = r8.getBoolean(r4, r5)
            r6.f3937e = r1
            if (r1 == 0) goto L_0x00ad
            boolean r1 = r6.f
            if (r1 == 0) goto L_0x00ad
            r6.f = r5
            int r1 = r6.f3936d
            r6.g(r1)
        L_0x00ad:
            boolean r1 = r8.containsKey(r3)
            if (r1 == 0) goto L_0x00cc
            boolean r1 = r8.getBoolean(r3, r5)
            r6.f = r1
            if (r1 == 0) goto L_0x00c7
            int r1 = r6.f3936d
            r6.i(r1)
            boolean r1 = r6.f3937e
            if (r1 == 0) goto L_0x00cc
            r6.f3937e = r5
            goto L_0x00cc
        L_0x00c7:
            int r1 = r6.f3936d
            r6.g(r1)
        L_0x00cc:
            java.lang.String r1 = "EXTRA_KEY_MOVE_TO_TRACK_NUM"
            boolean r2 = r8.containsKey(r1)
            java.lang.String r3 = "PlayerService-> Move to track out of bounds"
            if (r2 == 0) goto L_0x0107
            int r1 = r8.getInt(r1)
            if (r1 < 0) goto L_0x0104
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r2 = r6.f3935c
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x0104
            boolean r2 = r6.f
            if (r2 == 0) goto L_0x00f6
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r2 = r6.f3934b
            java.lang.Object r1 = r2.get(r1)
            com.cuatroochenta.miniland.model.Song r1 = (com.cuatroochenta.miniland.model.Song) r1
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r2 = r6.f3935c
            int r1 = r2.indexOf(r1)
        L_0x00f6:
            r6.f3936d = r1
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r2 = r6.f3935c
            java.lang.Object r1 = r2.get(r1)
            com.cuatroochenta.miniland.model.Song r1 = (com.cuatroochenta.miniland.model.Song) r1
            r6.f(r1)
            goto L_0x0107
        L_0x0104:
            a.c.a.f.e.b(r3)
        L_0x0107:
            java.lang.String r1 = "EXTRA_KEY_SEEK_TO_CURRENT_TRACK"
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L_0x011c
            android.media.MediaPlayer r2 = r6.f3933a
            if (r2 == 0) goto L_0x011c
            int r1 = r8.getInt(r1)
            int r1 = r1 * 1000
            r2.seekTo(r1)
        L_0x011c:
            java.lang.String r1 = "EXTRA_KEY_REMOVE_PLAYLIST_SONG"
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L_0x0176
            int r1 = r8.getInt(r1)
            if (r1 < 0) goto L_0x0173
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r2 = r6.f3935c
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x0173
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r2 = r6.f3935c
            int r3 = r6.f3936d
            java.lang.Object r2 = r2.get(r3)
            com.cuatroochenta.miniland.model.Song r2 = (com.cuatroochenta.miniland.model.Song) r2
            boolean r3 = r6.f
            if (r3 == 0) goto L_0x0154
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r3 = r6.f3934b
            java.lang.Object r3 = r3.get(r1)
            com.cuatroochenta.miniland.model.Song r3 = (com.cuatroochenta.miniland.model.Song) r3
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r4 = r6.f3934b
            r4.remove(r1)
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r1 = r6.f3935c
            int r1 = r1.indexOf(r3)
            goto L_0x0159
        L_0x0154:
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r3 = r6.f3934b
            r3.remove(r1)
        L_0x0159:
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r3 = r6.f3935c
            r3.remove(r1)
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r1 = r6.f3935c
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x016f
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r1 = r6.f3935c
            int r1 = r1.indexOf(r2)
            r6.f3936d = r1
            goto L_0x0176
        L_0x016f:
            r6.b()
            goto L_0x0176
        L_0x0173:
            a.c.a.f.e.b(r3)
        L_0x0176:
            r1 = -1
            java.lang.String r2 = "EXTRA_PLAYER_NOTIFY_OPTION"
            int r7 = r7.getIntExtra(r2, r1)
            if (r7 == 0) goto L_0x01d7
            switch(r7) {
                case 3: goto L_0x01b5;
                case 4: goto L_0x01b1;
                case 5: goto L_0x01ad;
                case 6: goto L_0x01a9;
                case 7: goto L_0x019a;
                case 8: goto L_0x018e;
                case 9: goto L_0x0189;
                case 10: goto L_0x0184;
                default: goto L_0x0182;
            }
        L_0x0182:
            goto L_0x01f7
        L_0x0184:
            r6.d()
            goto L_0x01f7
        L_0x0189:
            r6.l()
            goto L_0x01f7
        L_0x018e:
            long r7 = r6.k
            r1 = 0
            int r9 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r9 <= 0) goto L_0x01f7
            r6.j(r7)
            goto L_0x01f7
        L_0x019a:
            java.lang.String r7 = "EXTRA_KEY_START_COUNTDOWN"
            int r7 = r8.getInt(r7, r1)
            if (r7 <= 0) goto L_0x01f7
            int r7 = r7 * 1000
            long r7 = (long) r7
            r6.j(r7)
            goto L_0x01f7
        L_0x01a9:
            r6.h(r9)
            goto L_0x01f7
        L_0x01ad:
            r6.b()
            goto L_0x01f7
        L_0x01b1:
            r6.e(r5)
            goto L_0x01f7
        L_0x01b5:
            int r7 = r6.f3936d
            if (r7 <= 0) goto L_0x01ba
            goto L_0x01c8
        L_0x01ba:
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r7 = r6.f3935c
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x01f7
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r7 = r6.f3935c
            int r7 = r7.size()
        L_0x01c8:
            int r7 = r7 + r1
            r6.f3936d = r7
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r8 = r6.f3935c
            java.lang.Object r7 = r8.get(r7)
            com.cuatroochenta.miniland.model.Song r7 = (com.cuatroochenta.miniland.model.Song) r7
            r6.f(r7)
            goto L_0x01f7
        L_0x01d7:
            android.media.MediaPlayer r7 = r6.f3933a
            if (r7 == 0) goto L_0x01f7
            boolean r7 = r7.isPlaying()
            if (r7 == 0) goto L_0x01f4
            android.media.MediaPlayer r7 = r6.f3933a
            r7.pause()
            r6.d()
            r6.h(r0)
            java.lang.Thread r7 = r6.g
            if (r7 == 0) goto L_0x01f7
            r7.interrupt()
            goto L_0x01f7
        L_0x01f4:
            r6.k()
        L_0x01f7:
            java.util.ArrayList<com.cuatroochenta.miniland.model.Song> r7 = r6.f3935c
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x0203
            android.media.MediaPlayer r7 = r6.f3933a
            if (r7 != 0) goto L_0x0206
        L_0x0203:
            r6.b()
        L_0x0206:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.player.PlayerService.onStartCommand(android.content.Intent, int, int):int");
    }
}
