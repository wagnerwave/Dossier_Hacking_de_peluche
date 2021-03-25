package com.cuatroochenta.miniland.emyscale;

import a.c.a.d.a;
import a.c.d.c;
import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.internal.view.SupportMenu;
import com.cuatroochenta.miniland.model.Measure;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.android.network.TuyaApiParams;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class MyScaleGraphFullScreenActivity extends c {

    /* renamed from: b  reason: collision with root package name */
    public Bebe f3872b;

    /* renamed from: c  reason: collision with root package name */
    public String f3873c;

    /* renamed from: d  reason: collision with root package name */
    public WebView f3874d;

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3874d.loadUrl(this.f3873c);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_myscale_graph_fullscreen);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.graph_full_screen_common_header);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.h(R.string.TR_EMYSCALE).toUpperCase());
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("KEY_INTENT_BABY")) {
            this.f3872b = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        }
        Bebe bebe = this.f3872b;
        if (bebe == null) {
            finish();
        } else if (bebe == null) {
            finish();
        } else {
            WebView webView = (WebView) findViewById(R.id.graph_full_screen_web);
            this.f3874d = webView;
            webView.setDrawingCacheBackgroundColor(SupportMenu.CATEGORY_MASK);
            WebSettings settings = this.f3874d.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setBuiltInZoomControls(true);
            HashMap hashMap = new HashMap();
            hashMap.put("idBebe", String.valueOf(this.f3872b.getId()));
            Usuario i = AppMiniland.f().i();
            hashMap.put("bd", i.getBd());
            hashMap.put("bdpre", i.getBdpre());
            hashMap.put(TuyaApiParams.KEY_APP_LANG, i.getLang());
            hashMap.put("unidad", Measure.getMeasureNameForWebservice(a.c.d.a.l().o()));
            this.f3873c = null;
            try {
                this.f3873c = a.c("https://emybaby.com/api/grafico.php", hashMap);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            if (a.j(this.f3873c)) {
                finish();
            } else {
                this.f3874d.loadUrl(this.f3873c);
            }
        }
    }
}
