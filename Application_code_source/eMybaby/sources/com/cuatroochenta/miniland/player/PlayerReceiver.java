package com.cuatroochenta.miniland.player;

import a.a.a.a.a;
import a.c.a.f.b;
import a.c.a.f.e;
import a.c.d.g.j.c;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.sozpic.miniland.R;

public class PlayerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public BuddyPlayerActivity f3932a;

    public PlayerReceiver() {
        this.f3932a = null;
    }

    public PlayerReceiver(BuddyPlayerActivity buddyPlayerActivity) {
        this.f3932a = buddyPlayerActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            b.g0(context, 0);
        } else if ("com.cuatroochenta.miniland.PLAYER_ACTION".equalsIgnoreCase(intent.getAction())) {
            BuddyPlayerActivity buddyPlayerActivity = this.f3932a;
            if (buddyPlayerActivity == null) {
                e.b("Update notification");
                b.s0(context, intent);
            } else if (buddyPlayerActivity != null) {
                e.b("Received message from PlayerService");
                buddyPlayerActivity.f3827d = intent.getStringExtra("EXTRA_KEY_PLAYLIST_TYPE");
                intent.getIntExtra("EXTRA_KEY_PLAYER_STATUS_CODE", -1);
                int intExtra = intent.getIntExtra("EXTRA_KEY_INFO_CURRENT_TRACK", -1);
                int intExtra2 = intent.getIntExtra("EXTRA_KEY_INFO_CURRENT_POSITION", -1);
                buddyPlayerActivity.g.setSelected(intent.getBooleanExtra("EXTRA_KEY_INFO_IS_LOOP_MODE", false));
                buddyPlayerActivity.h.setSelected(intent.getBooleanExtra("EXTRA_KEY_INFO_SHUFFLE_MODE", false));
                buddyPlayerActivity.m = intent.getBooleanExtra("EXTRA_KEY_INFO_IS_PLAYING", false);
                int intExtra3 = intent.getIntExtra("EXTRA_KEY_INFO_TRACK_DURATION", -1);
                TextView textView = buddyPlayerActivity.l;
                StringBuilder n = a.n("-");
                n.append(a.c.a.d.a.e(intExtra3 - intExtra2));
                textView.setText(n.toString());
                buddyPlayerActivity.j.setMax(intExtra3);
                if (buddyPlayerActivity.m && intExtra2 > 0) {
                    buddyPlayerActivity.j.setProgress(intExtra2);
                    buddyPlayerActivity.k.setText(a.c.a.d.a.e(intExtra2));
                }
                buddyPlayerActivity.f.setImageResource(buddyPlayerActivity.m ? R.drawable.ic_pause : R.drawable.ic_play);
                c cVar = (c) buddyPlayerActivity.f3828e.getAdapter();
                if (cVar != null) {
                    if (a.c.a.d.a.j(buddyPlayerActivity.f3827d) || !buddyPlayerActivity.f3827d.equals(buddyPlayerActivity.f3826c)) {
                        e.b("Other playlist is current playing -> ignore info");
                        if (-1 != cVar.f90c) {
                            cVar.f90c = -1;
                        }
                    } else if (intExtra != cVar.f90c) {
                        cVar.f90c = intExtra;
                    }
                    cVar.notifyDataSetChanged();
                }
                buddyPlayerActivity.o = intent.getIntExtra("EXTRA_KEY_INFO_COUNTDOWN_STATUS", -1);
                buddyPlayerActivity.p = intent.getIntExtra("EXTRA_KEY_INFO_COUNTDOWN_TIMEFINISH", -1);
                int i = buddyPlayerActivity.o;
                if (i == 0 || i == 1) {
                    buddyPlayerActivity.i.setSelected(true);
                } else if (i == 2) {
                    buddyPlayerActivity.i.setSelected(false);
                }
                a.c.d.g.k.c cVar2 = buddyPlayerActivity.z;
                if (cVar2 != null && cVar2.isVisible()) {
                    a.c.d.g.k.c cVar3 = buddyPlayerActivity.z;
                    int i2 = buddyPlayerActivity.o;
                    int i3 = buddyPlayerActivity.p;
                    cVar3.f119a = i2;
                    cVar3.f120b = i3;
                    cVar3.m();
                }
            } else {
                throw null;
            }
        }
    }
}
