package com.google.zxing.client.android;

import a.d.c.l;
import a.d.c.m;
import a.d.c.q.a.b;
import a.d.c.q.a.c;
import a.d.c.q.a.g;
import a.d.c.q.a.h;
import a.d.c.q.a.i;
import a.d.c.q.a.k;
import a.d.c.q.a.n;
import a.d.c.q.a.o;
import a.d.c.q.a.q;
import a.d.c.q.a.r;
import a.d.c.q.a.t.c;
import a.d.c.q.a.t.d;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import java.io.IOException;
import java.util.Collection;
import java.util.EnumSet;

public final class CaptureActivity extends Activity implements SurfaceHolder.Callback {
    public static final String p = CaptureActivity.class.getSimpleName();
    public static final String[] q = {"http://zxing.appspot.com/scan", "zxing://scan/"};

    /* renamed from: a  reason: collision with root package name */
    public c f4306a;

    /* renamed from: b  reason: collision with root package name */
    public a.d.c.q.a.c f4307b;

    /* renamed from: c  reason: collision with root package name */
    public l f4308c;

    /* renamed from: d  reason: collision with root package name */
    public ViewfinderView f4309d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4310e;
    public View f;
    public l g;
    public boolean h;
    public i i;
    public String j;
    public Collection<a.d.c.a> k;
    public String l;
    public h m;
    public b n;
    public final DialogInterface.OnClickListener o = new a();

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(CaptureActivity.this.getString(q.zxing_url)));
            intent.addFlags(524288);
            CaptureActivity.this.startActivity(intent);
        }
    }

    static {
        EnumSet.of(m.ISSUE_NUMBER, m.SUGGESTED_PRICE, m.ERROR_CORRECTION_LEVEL, m.POSSIBLE_COUNTRY);
    }

    public final void a(l lVar) {
        l lVar2;
        a.d.c.q.a.c cVar = this.f4307b;
        if (!(cVar == null || (lVar2 = this.f4308c) == null)) {
            this.f4307b.sendMessage(Message.obtain(cVar, n.decode_succeeded, lVar2));
        }
        this.f4308c = null;
    }

    public final void b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(q.app_name));
        builder.setMessage(getString(q.msg_camera_framework_bug));
        builder.setPositiveButton(q.button_ok, new g(this));
        builder.setOnCancelListener(new g(this));
        builder.show();
    }

    public final void c(SurfaceHolder surfaceHolder) {
        try {
            this.f4306a.c(surfaceHolder);
            if (this.f4307b == null) {
                this.f4307b = new a.d.c.q.a.c(this, this.k, this.l, this.f4306a);
            }
            a((l) null);
        } catch (IOException e2) {
            Log.w(p, e2);
            b();
        } catch (RuntimeException e3) {
            Log.w(p, "Unexpected error initializing camera", e3);
            b();
        }
    }

    public final void d() {
        this.f.setVisibility(8);
        if (getIntent().hasExtra("INSTRUCTIONS_MESSAGE")) {
            this.f4310e.setText(getIntent().getStringExtra("INSTRUCTIONS_MESSAGE"));
        } else {
            this.f4310e.setText(q.msg_default_status);
        }
        this.f4310e.setVisibility(0);
        this.f4309d.setVisibility(0);
        this.g = null;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView(o.capture);
        this.h = false;
        this.m = new h(this);
        this.n = new b(this);
        PreferenceManager.setDefaultValues(this, r.preferences, false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, q.menu_share).setIcon(17301586);
        menu.add(0, 2, 0, q.menu_history).setIcon(17301578);
        menu.add(0, 3, 0, q.menu_settings).setIcon(17301577);
        menu.add(0, 4, 0, q.menu_help).setIcon(17301568);
        menu.add(0, 5, 0, q.menu_about).setIcon(17301569);
        return true;
    }

    public void onDestroy() {
        h hVar = this.m;
        hVar.a();
        hVar.f2932a.shutdown();
        super.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            i iVar = this.i;
            if (iVar == i.NATIVE_APP_INTENT) {
                setResult(0);
                finish();
                return true;
            } else if ((iVar == i.NONE || iVar == i.ZXING_LINK) && this.g != null) {
                a.d.c.q.a.c cVar = this.f4307b;
                if (cVar != null) {
                    cVar.sendEmptyMessageDelayed(n.restart_preview, 0);
                }
                d();
                return true;
            }
        } else if (i2 == 80 || i2 == 27) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(524288);
        int itemId = menuItem.getItemId();
        if (itemId == 3) {
            intent.setClassName(this, k.class.getName());
            startActivity(intent);
            return true;
        } else if (itemId != 5) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(q.title_about) + null);
            builder.setMessage(getString(q.msg_about) + "\n\n" + getString(q.zxing_url));
            builder.setIcon(a.d.c.q.a.m.launcher_icon);
            builder.setPositiveButton(q.button_open_browser, this.o);
            builder.setNegativeButton(q.button_cancel, (DialogInterface.OnClickListener) null);
            builder.show();
            return true;
        }
    }

    public void onPause() {
        a.d.c.q.a.c cVar = this.f4307b;
        if (cVar != null) {
            cVar.f2912c = c.a.DONE;
            a.d.c.q.a.t.c cVar2 = cVar.f2913d;
            Camera camera = cVar2.f2957c;
            if (camera != null && cVar2.g) {
                camera.stopPreview();
                d dVar = cVar2.k;
                dVar.f2962b = null;
                dVar.f2963c = 0;
                a.d.c.q.a.t.a aVar = cVar2.l;
                aVar.f2950a = null;
                aVar.f2951b = 0;
                cVar2.g = false;
            }
            Message.obtain(cVar.f2911b.a(), n.quit).sendToTarget();
            try {
                cVar.f2911b.join(500);
            } catch (InterruptedException unused) {
            }
            cVar.removeMessages(n.decode_succeeded);
            cVar.removeMessages(n.decode_failed);
            this.f4307b = null;
        }
        h hVar = this.m;
        hVar.a();
        hVar.f2933b.unregisterReceiver(hVar.f2935d);
        a.d.c.q.a.t.c cVar3 = this.f4306a;
        Camera camera2 = cVar3.f2957c;
        if (camera2 != null) {
            camera2.release();
            cVar3.f2957c = null;
            cVar3.f2958d = null;
            cVar3.f2959e = null;
        }
        if (!this.h) {
            ((SurfaceView) findViewById(n.preview_view)).getHolder().removeCallback(this);
        }
        super.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(1).setVisible(this.g == null);
        return true;
    }

    public void onResume() {
        Collection<a.d.c.a> collection;
        super.onResume();
        this.f4306a = new a.d.c.q.a.t.c(getApplication());
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(n.viewfinder_view);
        this.f4309d = viewfinderView;
        viewfinderView.setCameraManager(this.f4306a);
        this.f = findViewById(n.result_view);
        this.f4310e = (TextView) findViewById(n.status_view);
        this.f4307b = null;
        this.g = null;
        d();
        SurfaceHolder holder = ((SurfaceView) findViewById(n.preview_view)).getHolder();
        if (this.h) {
            c(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.n.a();
        h hVar = this.m;
        hVar.f2933b.registerReceiver(hVar.f2935d, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        hVar.b();
        Intent intent = getIntent();
        boolean z = true;
        if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean("preferences_copy_to_clipboard", true) && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("SAVE_HISTORY", true);
        }
        this.i = i.NONE;
        this.k = null;
        this.l = null;
        if (intent != null) {
            String action = intent.getAction();
            String dataString = intent.getDataString();
            if ("com.google.zxing.client.android.SCAN".equals(action)) {
                this.i = i.NATIVE_APP_INTENT;
                this.k = a.d.c.q.a.d.a(intent);
                if (intent.hasExtra("SCAN_WIDTH") && intent.hasExtra("SCAN_HEIGHT")) {
                    int intExtra = intent.getIntExtra("SCAN_WIDTH", 0);
                    int intExtra2 = intent.getIntExtra("SCAN_HEIGHT", 0);
                    if (intExtra > 0 && intExtra2 > 0) {
                        this.f4306a.e(intExtra, intExtra2);
                    }
                }
                String stringExtra = intent.getStringExtra("PROMPT_MESSAGE");
                if (stringExtra != null) {
                    this.f4310e.setText(stringExtra);
                }
            } else {
                if (dataString == null || !dataString.contains("http://www.google") || !dataString.contains("/m/products/scan")) {
                    if (dataString != null) {
                        String[] strArr = q;
                        int length = strArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            } else if (dataString.startsWith(strArr[i2])) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        this.i = i.ZXING_LINK;
                        this.j = dataString;
                        Uri parse = Uri.parse(dataString);
                        parse.getQueryParameter("ret");
                        collection = a.d.c.q.a.d.b(parse);
                    }
                } else {
                    this.i = i.PRODUCT_SEARCH_LINK;
                    this.j = dataString;
                    collection = a.d.c.q.a.d.f2919b;
                }
                this.k = collection;
            }
            this.l = intent.getStringExtra("CHARACTER_SET");
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            Log.e(p, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!this.h) {
            this.h = true;
            c(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.h = false;
    }
}
