package com.sozpic.miniland;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

public class TermometroPantallaActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static Timer f4560a = new Timer();

    public class a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f4561a;

        /* renamed from: com.sozpic.miniland.TermometroPantallaActivity$a$a  reason: collision with other inner class name */
        public class C0100a implements Runnable {
            public C0100a() {
            }

            public void run() {
                try {
                    TermometroPantallaActivity.this.finish();
                } catch (Exception unused) {
                }
            }
        }

        public a(Handler handler) {
            this.f4561a = handler;
        }

        public void run() {
            this.f4561a.post(new C0100a());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_termometro_pantalla);
        f4560a.schedule(new a(new Handler()), 5000);
    }
}
