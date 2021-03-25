package a.h.a.k0;

import a.g.a.b.b;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.cuatroochenta.commons.widget.CircularImageView;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Bebe;

public class c extends ArrayAdapter<Bebe> {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f3494a;

    /* renamed from: b  reason: collision with root package name */
    public final Bebe[] f3495b;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public CircularImageView f3496a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f3497b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f3498c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f3499d;

        public a(c cVar) {
        }
    }

    public c(Activity activity, Bebe[] bebeArr) {
        super(activity, R.layout.row_generica, bebeArr);
        this.f3494a = activity;
        this.f3495b = bebeArr;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = ((LayoutInflater) this.f3494a.getSystemService("layout_inflater")).inflate(R.layout.row_generica, (ViewGroup) null);
            aVar = new a(this);
            CircularImageView circularImageView = (CircularImageView) view.findViewById(R.id.lo);
            aVar.f3496a = circularImageView;
            circularImageView.setBorder(true);
            aVar.f3496a.setBorderColor(this.f3494a.getResources().getColor(R.color.azul_selected));
            aVar.f3497b = (TextView) view.findViewById(R.id.texto1);
            aVar.f3498c = (TextView) view.findViewById(R.id.texto2);
            aVar.f3499d = (TextView) view.findViewById(R.id.texto3);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Bebe bebe = this.f3495b[i];
        if (bebe != null) {
            aVar.f3497b.setText(bebe.getNombre());
            if (bebe.getId() != 0) {
                aVar.f3498c.setText(a.c.a.d.a.g(bebe.getFechanacimiento()));
                aVar.f3499d.setText(a.c.a.d.a.g(bebe.getAltura()));
                aVar.f3496a.setImageResource(R.drawable.baby_small_default);
                if (!bebe.isPhotoEmpty()) {
                    AppMiniland.f().k.b(bebe.getFoto(), aVar.f3496a, (b) null, (a.g.a.b.l.c) null);
                }
            } else {
                aVar.f3498c.setText((CharSequence) null);
                aVar.f3499d.setText((CharSequence) null);
                aVar.f3496a.setImageResource(R.drawable.baby_small_default);
            }
        }
        return view;
    }
}
