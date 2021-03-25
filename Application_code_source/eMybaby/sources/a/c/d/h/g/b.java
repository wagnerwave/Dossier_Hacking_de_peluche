package a.c.d.h.g;

import a.g.a.b.l.c;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cuatroochenta.commons.widget.CircularImageView;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Bebe;
import java.util.ArrayList;

public class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f147a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Bebe> f148b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public int f149c;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public CircularImageView f150a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f151b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f152c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f153d;

        public a(b bVar) {
        }
    }

    public b(Context context, int i) {
        this.f147a = context;
        this.f149c = i;
    }

    public int getCount() {
        return this.f148b.size();
    }

    public Object getItem(int i) {
        return this.f148b.get(i);
    }

    public long getItemId(int i) {
        if (this.f148b.get(i) == null) {
            return 0;
        }
        return (long) this.f148b.get(i).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        Resources resources;
        TextView textView;
        if (view == null || !(view.getTag() instanceof a)) {
            view = ((LayoutInflater) this.f147a.getSystemService("layout_inflater")).inflate(R.layout.item_myscale_baby, (ViewGroup) null);
            aVar = new a(this);
            CircularImageView circularImageView = (CircularImageView) view.findViewById(R.id.baby_item_image);
            aVar.f150a = circularImageView;
            circularImageView.setBorder(true);
            aVar.f151b = (TextView) view.findViewById(R.id.baby_item_name);
            aVar.f152c = (TextView) view.findViewById(R.id.baby_item_birthdate);
            ImageView imageView = (ImageView) view.findViewById(R.id.baby_item_disclosure);
            aVar.f153d = imageView;
            int i3 = this.f149c;
            if (i3 == 0) {
                imageView.setImageResource(R.drawable.ic_grey_arrow);
                textView = aVar.f152c;
                resources = this.f147a.getResources();
                i2 = R.color.baby_list_imgborder;
            } else if (i3 != 1) {
                if (i3 == 2) {
                    imageView.setImageResource(R.drawable.flechaverde);
                    textView = aVar.f152c;
                    resources = this.f147a.getResources();
                    i2 = R.color.medical_green;
                }
                view.setTag(aVar);
            } else {
                imageView.setImageResource(R.drawable.flecharosa);
                textView = aVar.f152c;
                resources = this.f147a.getResources();
                i2 = R.color.rosa;
            }
            textView.setTextColor(resources.getColor(i2));
            aVar.f150a.setBorderColor(this.f147a.getResources().getColor(i2));
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Bebe bebe = this.f148b.get(i);
        if (bebe != null) {
            aVar.f151b.setText(bebe.getFullName());
            aVar.f152c.setText(bebe.getFechanacimiento());
            aVar.f150a.setImageResource(R.drawable.baby_small_default);
            if (!bebe.isPhotoEmpty()) {
                AppMiniland.f().k.b(bebe.getFoto(), aVar.f150a, (a.g.a.b.b) null, (c) null);
            }
        }
        return view;
    }
}
