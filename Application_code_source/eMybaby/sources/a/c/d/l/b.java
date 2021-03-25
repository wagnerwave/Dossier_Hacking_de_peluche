package a.c.d.l;

import a.c.d.r.e;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import org.json.JSONException;

public class b extends Fragment {

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(b.this.getContext(), a.c.a.d.a.h(R.string.TR_URL_RECETAS_GRATUITAS));
        }
    }

    /* renamed from: a.c.d.l.b$b  reason: collision with other inner class name */
    public class C0017b implements View.OnClickListener {
        public C0017b() {
        }

        public void onClick(View view) {
            try {
                boolean z = AppMiniland.f().i().getOriginalJson().getBoolean("chefy_active");
                a aVar = new a();
                Bundle bundle = new Bundle();
                bundle.putBoolean("ARG_IS_ACTIVE", z);
                aVar.setArguments(bundle);
                aVar.show(b.this.getFragmentManager(), "chefy_download");
            } catch (JSONException e2) {
                e2.printStackTrace();
                a aVar2 = new a();
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("ARG_IS_ACTIVE", false);
                aVar2.setArguments(bundle2);
                aVar2.show(b.this.getFragmentManager(), "chefy_download");
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(b.this.getContext(), a.c.a.d.a.h(R.string.TR_URL_COMPRAR_CHEFY));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_nutrition, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_book_free_title);
        textView.setTypeface(e.a().f788a);
        textView.setText(a.c.a.d.a.h(R.string.TR_LIBRO_DE_RECETAS));
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_book_free_btn);
        textView2.setTypeface(e.a().f788a);
        textView2.setText(a.c.a.d.a.h(R.string.TR_DESCARGA_NUESTRA_SECCION_DE_RECETAS));
        textView2.setOnClickListener(new a());
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_book_chefy_title);
        textView3.setTypeface(e.a().f788a);
        textView3.setText(a.c.a.d.a.h(R.string.TR_LIBRO_DE_RECETAS_CHEFY));
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_book_chefy_btn);
        textView4.setTypeface(e.a().f788a);
        textView4.setText(a.c.a.d.a.h(R.string.TR_SI_TIENES_NUESTRA_CHEFY));
        textView4.setOnClickListener(new C0017b());
        TextView textView5 = (TextView) inflate.findViewById(R.id.tv_chefy_not_yet_title);
        textView5.setTypeface(e.a().f788a);
        textView5.setText(a.c.a.d.a.h(R.string.TR_AUN_NO_TIENES_TU_CHEFY));
        TextView textView6 = (TextView) inflate.findViewById(R.id.tv_chefy_not_yet_text);
        textView6.setTypeface(e.a().f789b);
        textView6.setText(a.c.a.d.a.h(R.string.TR_ENSENYA_A_TU_BEBE_A_COMER_SANO));
        TextView textView7 = (TextView) inflate.findViewById(R.id.tv_buy_chefy_btn);
        textView7.setTypeface(e.a().f788a);
        textView7.setText(a.c.a.d.a.h(R.string.TR_QUIERES_COMPRAR_NUESTRA_CHEFY));
        textView7.setOnClickListener(new c());
        return inflate;
    }
}
