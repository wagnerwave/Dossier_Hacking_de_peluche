package com.cuatroochenta.miniland.player;

import a.c.a.f.b;
import a.c.a.f.e;
import android.app.IntentService;
import android.content.Intent;

public class PlayerNotifyService extends IntentService {
    public PlayerNotifyService() {
        super("PLAYER_NOTIFY_SERVICE");
    }

    public void onHandleIntent(Intent intent) {
        if ("com.cuatroochenta.miniland.PLAYER_ACTION".equalsIgnoreCase(intent.getAction())) {
            b.s0(this, intent);
            return;
        }
        int intExtra = intent.getIntExtra("EXTRA_PLAYER_NOTIFY_OPTION", -1);
        e.b(String.format("Sending action %d from notification", new Object[]{Integer.valueOf(intExtra)}));
        b.g0(this, intExtra);
    }
}
