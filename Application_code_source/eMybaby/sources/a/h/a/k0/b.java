package a.h.a.k0;

import a.g.a.b.l.c;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.cuatroochenta.commons.widget.CircularImageView;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Familia;
import com.tuya.smart.common.oOO0O0O0;

public class b extends ArrayAdapter<Familia> {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f3489a;

    /* renamed from: b  reason: collision with root package name */
    public final Familia[] f3490b;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public CircularImageView f3491a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f3492b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f3493c;

        public a(b bVar) {
        }
    }

    public b(Activity activity, Familia[] familiaArr) {
        super(activity, R.layout.row_familia, familiaArr);
        this.f3489a = activity;
        this.f3490b = familiaArr;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = ((LayoutInflater) this.f3489a.getSystemService("layout_inflater")).inflate(R.layout.row_familia, (ViewGroup) null);
            aVar = new a(this);
            CircularImageView circularImageView = (CircularImageView) view.findViewById(R.id.lo);
            aVar.f3491a = circularImageView;
            circularImageView.setBorder(true);
            aVar.f3491a.setBorderColor(this.f3489a.getResources().getColor(R.color.azul_selected));
            aVar.f3492b = (TextView) view.findViewById(R.id.texto1);
            aVar.f3493c = (TextView) view.findViewById(R.id.texto2);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Familia familia = this.f3490b[i];
        if (familia != null) {
            aVar.f3492b.setText(a.c.a.d.a.g(familia.getNombre()));
            if (!familia.getId().equals(oOO0O0O0.O0000oO0)) {
                aVar.f3493c.setText(a.c.a.d.a.g(familia.getTipo()));
                aVar.f3491a.setImageResource(R.drawable.baby_small_default);
                if (!familia.isPhotoEmpty()) {
                    AppMiniland.f().k.b(familia.getFoto(), aVar.f3491a, (a.g.a.b.b) null, (c) null);
                }
            }
        }
        return view;
    }
}
