package a.f.a.c;

import android.media.AudioTrack;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.Arrays;

public class a implements AudioTrack.OnPlaybackPositionUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f3313a;

    public a(b bVar) {
        this.f3313a = bVar;
    }

    public void onMarkerReached(AudioTrack audioTrack) {
    }

    public void onPeriodicNotification(AudioTrack audioTrack) {
        b bVar = this.f3313a;
        if (!bVar.f3315b) {
            int i = (bVar.f3316c * 200) - (bVar.f3317d * MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            bVar.l = i;
            if (!bVar.k) {
                if (i >= 1280) {
                    bVar.k = true;
                } else {
                    bVar.l = 0;
                }
            } else if (i < 320) {
                bVar.l = 0;
                bVar.k = false;
            }
            b bVar2 = this.f3313a;
            int i2 = bVar2.l;
            if (i2 > 2880) {
                bVar2.f3316c = 0;
                bVar2.f3317d = 0;
                bVar2.f3318e = 0;
                bVar2.f = 0;
                bVar2.g = 0;
                bVar2.k = false;
                Arrays.fill(bVar2.i, 0);
                b bVar3 = this.f3313a;
                bVar3.f3314a.write(bVar3.i, 0, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            } else if (i2 >= 320) {
                bVar2.f3314a.write(bVar2.h, bVar2.f * MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
                b bVar4 = this.f3313a;
                bVar4.f3317d++;
                int i3 = bVar4.f + 1;
                bVar4.f = i3;
                if (i3 == 25) {
                    bVar4.j = bVar4.h[(i3 * MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP) - 1];
                    bVar4.f = 0;
                } else {
                    bVar4.j = bVar4.h[(i3 * MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP) - 1];
                }
            } else {
                Arrays.fill(bVar2.i, bVar2.j);
                b bVar5 = this.f3313a;
                bVar5.f3314a.write(bVar5.i, 0, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            }
        } else {
            Arrays.fill(bVar.i, 0);
            b bVar6 = this.f3313a;
            bVar6.f3314a.write(bVar6.i, 0, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
        }
        this.f3313a.g++;
    }
}
