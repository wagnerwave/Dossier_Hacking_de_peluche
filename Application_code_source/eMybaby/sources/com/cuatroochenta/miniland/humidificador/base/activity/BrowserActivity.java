package com.cuatroochenta.miniland.humidificador.base.activity;

import a.c.d.j.b.a.b;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.appcompat.widget.Toolbar;
import com.sozpic.miniland.R;

public class BrowserActivity extends b {
    public WebView g;

    public class a implements Toolbar.OnMenuItemClickListener {
        public a() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getItemId() != R.id.menu_refresh) {
                return false;
            }
            BrowserActivity.this.g.stopLoading();
            BrowserActivity.this.g.reload();
            return true;
        }
    }

    public void onBackPressed() {
        if (!this.g.canGoBack()) {
            super.onBackPressed();
            finish();
            a.c.a.f.b.Y(this, 1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
        if (r7.indexOf("file:///") != -1) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a9, code lost:
        if (r1 != false) goto L_0x00ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            r7 = 2131492901(0x7f0c0025, float:1.8609267E38)
            r6.setContentView((int) r7)
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "Toolbar"
            r1 = 1
            boolean r0 = r7.getBooleanExtra(r0, r1)
            java.lang.String r2 = "Title"
            java.lang.String r2 = r7.getStringExtra(r2)
            java.lang.String r3 = "from_pannel"
            r4 = 0
            boolean r3 = r7.getBooleanExtra(r3, r4)
            r6.o()
            androidx.appcompat.widget.Toolbar r5 = r6.f166a
            if (r5 == 0) goto L_0x002b
            r5.setVisibility(r4)
        L_0x002b:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 == 0) goto L_0x0040
            int[] r2 = new int[r1]
            r5 = 2130968622(0x7f04002e, float:1.7545903E38)
            r2[r4] = r5
            android.content.res.TypedArray r2 = r6.obtainStyledAttributes(r2)
            java.lang.String r2 = r2.getString(r4)
        L_0x0040:
            r6.r(r2)
            r2 = 8
            r6.q()
            r5 = -1
            if (r3 == 0) goto L_0x005e
            r3 = 2131297835(0x7f09062b, float:1.8213626E38)
            android.view.View r3 = r6.findViewById(r3)
            if (r3 == 0) goto L_0x0057
            r3.setVisibility(r2)
        L_0x0057:
            androidx.appcompat.widget.Toolbar r3 = r6.f166a
            if (r3 == 0) goto L_0x005e
            r3.setTitleTextColor((int) r5)
        L_0x005e:
            if (r0 != 0) goto L_0x0067
            androidx.appcompat.widget.Toolbar r0 = r6.f166a
            if (r0 == 0) goto L_0x0067
            r0.setVisibility(r2)
        L_0x0067:
            java.lang.String r0 = "Uri"
            java.lang.String r0 = r7.getStringExtra(r0)
            java.lang.String r2 = "Login"
            r7.getBooleanExtra(r2, r4)
            java.lang.String r2 = "Refresh"
            r7.getBooleanExtra(r2, r1)
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L_0x00ab
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 == 0) goto L_0x0085
        L_0x0083:
            r1 = 0
            goto L_0x00a9
        L_0x0085:
            java.lang.String r7 = "utf-8"
            java.lang.String r7 = java.net.URLDecoder.decode(r0, r7)     // Catch:{ UnsupportedEncodingException -> 0x00a4 }
            java.lang.String r2 = "http://"
            int r2 = r7.indexOf(r2)
            if (r2 == r5) goto L_0x00a9
            java.lang.String r2 = "https://"
            int r2 = r7.indexOf(r2)
            if (r2 == r5) goto L_0x00a9
            java.lang.String r2 = "file:///"
            int r7 = r7.indexOf(r2)
            if (r7 != r5) goto L_0x0083
            goto L_0x00a9
        L_0x00a4:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0083
        L_0x00a9:
            if (r1 != 0) goto L_0x00ad
        L_0x00ab:
            java.lang.String r0 = "about:blank"
        L_0x00ad:
            r7 = 2131558402(0x7f0d0002, float:1.8742119E38)
            com.cuatroochenta.miniland.humidificador.base.activity.BrowserActivity$a r1 = new com.cuatroochenta.miniland.humidificador.base.activity.BrowserActivity$a
            r1.<init>()
            androidx.appcompat.widget.Toolbar r2 = r6.f166a
            if (r2 == 0) goto L_0x00c1
            r2.inflateMenu(r7)
            androidx.appcompat.widget.Toolbar r7 = r6.f166a
            r7.setOnMenuItemClickListener(r1)
        L_0x00c1:
            r7 = 2131297848(0x7f090638, float:1.8213653E38)
            android.view.View r7 = r6.findViewById(r7)
            android.webkit.WebView r7 = (android.webkit.WebView) r7
            r6.g = r7
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.lang.String r1 = com.tuya.smart.android.common.utils.TyCommonUtil.getLang(r6)
            java.lang.String r2 = "Accept-Language"
            r7.put(r2, r1)
            android.webkit.WebView r1 = r6.g
            r1.loadUrl(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.humidificador.base.activity.BrowserActivity.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        super.onDestroy();
        ((ViewGroup) findViewById(R.id.browser_layout)).removeView(this.g);
        WebView webView = this.g;
        if (webView != null) {
            webView.destroy();
            this.g = null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isFinishing() || i != 4 || !this.g.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.g.goBack();
        return true;
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("Uri");
            a.a.a.a.a.v("Browser : onNewIntent 2:", stringExtra, "Browser");
            WebView webView = this.g;
            if (!(webView == null || stringExtra == null)) {
                webView.loadUrl(stringExtra);
            }
        }
        super.onNewIntent(intent);
    }

    public void onPause() {
        super.onPause();
        WebView webView = this.g;
        if (webView != null) {
            webView.onPause();
        }
    }

    public void onResume() {
        super.onResume();
        WebView webView = this.g;
        if (webView != null) {
            webView.onResume();
        }
    }

    public boolean p(int i, KeyEvent keyEvent) {
        return i == 4 && this.g.canGoBack();
    }
}
