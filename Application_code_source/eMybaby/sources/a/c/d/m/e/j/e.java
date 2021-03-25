package a.c.d.m.e.j;

import a.c.a.d.a;
import a.c.a.e.f;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.sdk.bean.ProductBean;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class e extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public TextView f358a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f359b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f360c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f361d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f362e;
    public ImageView f;
    public ImageView g;

    public static Fragment o(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("ARGS_GRAPH_TYPE", i);
        e eVar = new e();
        eVar.setArguments(bundle);
        return eVar;
    }

    public final void m(int i) {
        n(i != 0 ? i != 1 ? i != 3 ? "fl" : "hc" : "efw" : "ac");
    }

    public final void n(String str) {
        HashMap hashMap = new HashMap();
        Usuario i = AppMiniland.f().i();
        if (i != null) {
            hashMap.put("bd", i.getBd());
            hashMap.put("bdpre", i.getBdpre());
            hashMap.put("tipo", str);
            try {
                this.f360c.loadUrl(a.c("https://emybaby.com/api/graficodatosmedicos.php", hashMap));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_medical_data_graph, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.medical_data_graph_text_data_type_acronym);
        this.f358a = textView;
        textView.setVisibility(8);
        this.f361d = (ImageView) inflate.findViewById(R.id.medical_data_graph_button_efw);
        TextView textView2 = (TextView) inflate.findViewById(R.id.medical_data_graph_text_data_type);
        this.f359b = textView2;
        textView2.setVisibility(8);
        this.f362e = (ImageView) inflate.findViewById(R.id.medical_data_graph_button_graph_fl);
        this.f = (ImageView) inflate.findViewById(R.id.medical_data_graph_button_graph_hc);
        this.g = (ImageView) inflate.findViewById(R.id.medical_data_graph_button_graph_ac);
        WebView webView = (WebView) inflate.findViewById(R.id.medical_data_graph_webview);
        this.f360c = webView;
        ((LinearLayout.LayoutParams) webView.getLayoutParams()).setMargins(0, 0, 0, 0);
        m(getArguments().getInt("ARGS_GRAPH_TYPE", 2));
        this.g.setOnClickListener(new a(this));
        this.f361d.setOnClickListener(new b(this));
        this.f362e.setOnClickListener(new c(this));
        this.f.setOnClickListener(new d(this));
        this.f360c.getSettings().setJavaScriptEnabled(true);
        this.f360c.setScrollBarStyle(ProductBean.ATTR_HONGWAI_SUB);
        this.f360c.getSettings().setBuiltInZoomControls(true);
        this.f360c.setWebChromeClient(new WebChromeClient());
        return inflate;
    }

    public void onStart() {
        super.onStart();
        f.c().e("MI_EMBARAZO_BEBE_GRAFICA");
    }
}
