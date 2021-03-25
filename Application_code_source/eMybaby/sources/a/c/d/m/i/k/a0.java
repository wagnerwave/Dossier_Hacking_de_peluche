package a.c.d.m.i.k;

import a.c.d.s.e.d.d.c.d;
import a.c.d.s.e.d.d.d.c;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.cuatroochenta.miniland.model.MyBellyData;
import com.cuatroochenta.miniland.pregnancy.mama.MyBellyImageFormActivity;
import com.cuatroochenta.miniland.utils.CustomViewPager;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.my_belly.list.MamaMyBellyListRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.my_belly.remove.MamaMyBellyRemoveRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import java.util.ArrayList;
import java.util.List;

public class a0 extends m0 implements a.c.d.s.e.d.d.c.a, a.c.d.s.e.d.d.d.a {
    public CustomViewPager l;
    public g m;
    public TextView n;
    public TextView o;
    public ImageView p;
    public MyBellyData q;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c.d.s.e.d.d.c.b f521a;

        public a(a.c.d.s.e.d.d.c.b bVar) {
            this.f521a = bVar;
        }

        public void run() {
            a0.this.s();
            if (this.f521a.f42a.booleanValue()) {
                List<MyBellyData> list = this.f521a.f1056c;
                g gVar = a0.this.m;
                gVar.f530b.clear();
                gVar.f530b.addAll(list);
                gVar.notifyDataSetChanged();
                if (list.size() != 0) {
                    a0 a0Var = a0.this;
                    String title = list.get(0).getTitle();
                    String description = list.get(0).getDescription();
                    a0Var.n.setText(title);
                    a0Var.o.setText(description);
                    return;
                }
                return;
            }
            a.c.a.f.b.h0(a0.this.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_DATOS_MI_TRIPITA), a.c.a.d.a.h(R.string.TR_ACEPTAR));
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            MyBellyData myBellyData = a0.this.m.f530b.get(i);
            a0 a0Var = a0.this;
            String title = myBellyData.getTitle();
            String description = myBellyData.getDescription();
            a0Var.n.setText(title);
            a0Var.o.setText(description);
            a0.this.q = myBellyData;
        }
    }

    public class c implements View.OnLongClickListener {
        public c() {
        }

        public boolean onLongClick(View view) {
            a0 a0Var = a0.this;
            g gVar = a0Var.m;
            a0Var.q = gVar.f530b.get(a0Var.l.getCurrentItem());
            a0.this.z();
            return true;
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            a0.this.startActivityForResult(new Intent(a0.this.getActivity(), MyBellyImageFormActivity.class), 205);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            if (a0.this.q != null) {
                Intent intent = new Intent(a0.this.getActivity(), MyBellyImageFormActivity.class);
                intent.putExtra("key_image_url", a0.this.q.getImageUrl());
                intent.putExtra("key_image_title", a0.this.q.getTitle());
                intent.putExtra("key_image_description", a0.this.q.getDescription());
                intent.putExtra("ARGS_MY_BELLY_ID", a0.this.q.getId());
                intent.putExtra("ARGS_MY_BELLY_IMAGE", a0.this.q.getImageUrl());
                a0.this.startActivityForResult(intent, 208);
            }
        }
    }

    public class f implements View.OnClickListener {

        public class a implements DialogInterface.OnClickListener {
            public a(f fVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                a0 a0Var = a0.this;
                Long id = a0Var.q.getId();
                if (a0Var != null) {
                    a0Var.C(a.c.a.d.a.h(R.string.TR_DELETING_MI_TRIPITA), false);
                    new c.a(new a.c.d.s.e.d.d.d.c(), new MamaMyBellyRemoveRequest(id), a0Var).start();
                    a0.this.y();
                    return;
                }
                throw null;
            }
        }

        public f() {
        }

        public void onClick(View view) {
            a0 a0Var = a0.this;
            if (a0Var.q != null) {
                new AlertDialog.Builder(a0Var.getActivity()).setTitle((CharSequence) a.c.a.d.a.h(R.string.TR_INFORMATION)).setMessage((CharSequence) a.c.a.d.a.h(R.string.TR_DELETE_MI_TRIPITA_CONFIRM)).setPositiveButton((CharSequence) a.c.a.d.a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) new b()).setNegativeButton((CharSequence) a.c.a.d.a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) new a(this)).show();
            }
        }
    }

    public class g extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public Context f529a;

        /* renamed from: b  reason: collision with root package name */
        public List<MyBellyData> f530b = new ArrayList();

        public class a implements a.g.a.b.l.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ImageView f532a;

            public a(g gVar, ImageView imageView) {
                this.f532a = imageView;
            }

            public void a(String str, View view, Bitmap bitmap) {
                this.f532a.setImageBitmap(bitmap);
            }

            public void b(String str, View view) {
            }

            public void c(String str, View view, a.g.a.b.l.a aVar) {
            }

            public void d(String str, View view) {
            }
        }

        public class b implements View.OnLongClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ MyBellyData f533a;

            public b(MyBellyData myBellyData) {
                this.f533a = myBellyData;
            }

            public boolean onLongClick(View view) {
                a0 a0Var = a0.this;
                a0Var.q = this.f533a;
                a0Var.z();
                return true;
            }
        }

        public class c implements View.OnClickListener {
            public c() {
            }

            public void onClick(View view) {
                a0 a0Var = a0.this;
                if (a0Var.q != null) {
                    a0Var.y();
                    a0.this.q = null;
                }
            }
        }

        public g(Context context) {
            this.f529a = context;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((LinearLayout) obj);
        }

        public int getCount() {
            return this.f530b.size();
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(this.f529a).inflate(R.layout.my_belly_images_item, viewGroup, false);
            MyBellyData myBellyData = this.f530b.get(i);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.img_my_belly_item);
            if (myBellyData.getImageUrl().startsWith("http")) {
                a.g.a.b.d.e().h(myBellyData.getImageUrl(), new a(this, imageView));
            } else {
                imageView.setImageBitmap(BitmapFactory.decodeFile(myBellyData.getImageUrl()));
            }
            imageView.setOnLongClickListener(new b(myBellyData));
            imageView.setOnClickListener(new c());
            viewGroup.addView(inflate);
            return inflate;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public void A() {
        this.i.setOnClickListener(new f());
    }

    public void B() {
        this.h.setOnClickListener(new e());
    }

    public void D() {
        Usuario i = AppMiniland.f().i();
        if (i != null) {
            C(a.c.a.d.a.h(R.string.TR_UPDATING), false);
            new d.a(new MamaMyBellyListRequest(i.getId(), i.getPass()), this).start();
        }
    }

    public void E(a.c.d.s.e.d.d.c.b bVar) {
        getActivity().runOnUiThread(new a(bVar));
    }

    public boolean h() {
        if (this.q == null) {
            return false;
        }
        y();
        this.q = null;
        return true;
    }

    public String n() {
        return null;
    }

    public View.OnClickListener o() {
        return null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 205 && i2 == -1) {
            MyBellyData myBellyData = (MyBellyData) intent.getParcelableExtra("ARGS_MY_BELLY_IMAGE");
            this.m.f530b.add(0, myBellyData);
            this.m.notifyDataSetChanged();
            String title = myBellyData.getTitle();
            String description = myBellyData.getDescription();
            this.n.setText(title);
            this.o.setText(description);
            this.l.setCurrentItem(0);
        } else if (i == 208 && i2 == -1) {
            MyBellyData myBellyData2 = (MyBellyData) intent.getParcelableExtra("ARGS_MY_BELLY_IMAGE");
            g gVar = this.m;
            gVar.f530b.set(this.l.getCurrentItem(), myBellyData2);
            this.o.setText(myBellyData2.getDescription());
            this.n.setText(myBellyData2.getTitle());
            this.m.notifyDataSetChanged();
        } else {
            super.onActivityResult(i, i2, intent);
            return;
        }
        y();
    }

    public void onStart() {
        super.onStart();
        a.c.a.e.f.c().e("MI_EMBARAZO_MAMA_TRIPITA");
    }

    public int q() {
        return R.layout.fragment_mama_my_belly;
    }

    public String r() {
        return null;
    }

    public void t() {
        this.p.setOnClickListener(new d());
    }

    public void u() {
        CustomViewPager customViewPager = (CustomViewPager) m(R.id.vp_my_belly);
        this.l = customViewPager;
        customViewPager.addOnPageChangeListener(new b());
        m(R.id.rl_mama_my_belly_bottom).setOnLongClickListener(new c());
        this.n = (TextView) m(R.id.tv_mama_my_belly_img_title);
        this.o = (TextView) m(R.id.tv_mama_my_belly_img_subtitle);
        this.p = (ImageView) m(R.id.img_mama_my_belly_add_new);
    }

    public void v() {
        ((TextView) m(R.id.tv_mama_my_belly_title)).setText(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_MAMA).toUpperCase());
        ((TextView) m(R.id.tv_mama_my_belly_subtitle)).setText(a.c.a.d.a.h(R.string.TR_MI_TRIPITA).toUpperCase());
    }

    public void w() {
    }

    public void x() {
        g gVar = new g(getActivity());
        this.m = gVar;
        this.l.setAdapter(gVar);
        D();
    }
}
