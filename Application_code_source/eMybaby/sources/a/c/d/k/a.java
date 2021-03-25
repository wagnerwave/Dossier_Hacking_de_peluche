package a.c.d.k;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.sozpic.miniland.R;

public class a extends Fragment {

    /* renamed from: a.c.d.k.a$a  reason: collision with other inner class name */
    public class C0015a implements View.OnClickListener {
        public C0015a() {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(a.this.getContext(), a.c.a.d.a.h(R.string.TR_ECO_FRIENDLY_URL));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(a.this.getContext(), "https://play.google.com/store/apps/details?id=com.miniland.growfun");
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(a.this.getContext(), a.c.a.d.a.h(R.string.TR_ECOMMERCE_URL));
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(a.this.getContext(), a.c.a.d.a.h(R.string.TR_BLOG_URL));
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            try {
                a.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + a.c.a.d.a.h(R.string.TR_MINILAND_WORLD_CONTACT_PHONE).trim())));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra("android.intent.extra.EMAIL", new String[]{a.c.a.d.a.h(R.string.TR_MINILAND_WORLD_CONTACT_EMAIL)});
            a.this.startActivity(Intent.createChooser(intent, a.c.a.d.a.h(R.string.TR_SEND_WITH)));
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(a.this.getContext(), a.c.a.d.a.h(R.string.TR_INSTAGRAM_URL));
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(a.this.getContext(), a.c.a.d.a.h(R.string.TR_FACEBOOK_URL));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_miniland_world, viewGroup, false);
        ((ImageView) inflate.findViewById(R.id.iv_banner)).setOnClickListener(new C0015a());
        TextView textView = (TextView) inflate.findViewById(R.id.tv_app_grow_fun_title);
        textView.setTypeface(a.c.d.r.e.a().f788a);
        textView.setText(a.c.a.d.a.h(R.string.TR_GROW_AND_FUN_TITLE));
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_app_grow_fun_text);
        textView2.setTypeface(a.c.d.r.e.a().f789b);
        textView2.setText(a.c.a.d.a.h(R.string.TR_GROW_AND_FUN_DESCRIPTION));
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_app_grow_fun_btn);
        textView3.setTypeface(a.c.d.r.e.a().f788a);
        textView3.setText(a.c.a.d.a.h(R.string.TR_GROW_AND_FUN_BUTTON));
        textView3.setOnClickListener(new b());
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_family_title);
        textView4.setTypeface(a.c.d.r.e.a().f788a);
        textView4.setText(a.c.a.d.a.h(R.string.TR_ECOMMERCE_TITLE));
        TextView textView5 = (TextView) inflate.findViewById(R.id.tv_family_text);
        textView5.setTypeface(a.c.d.r.e.a().f789b);
        textView5.setText(a.c.a.d.a.h(R.string.TR_ECOMMERCE_DESCRIPTION));
        TextView textView6 = (TextView) inflate.findViewById(R.id.tv_family_btn);
        textView6.setTypeface(a.c.d.r.e.a().f788a);
        textView6.setText(a.c.a.d.a.h(R.string.TR_ECOMMERCE_BUTTON));
        textView6.setOnClickListener(new c());
        TextView textView7 = (TextView) inflate.findViewById(R.id.tv_blog_btn);
        textView7.setTypeface(a.c.d.r.e.a().f788a);
        textView7.setText(a.c.a.d.a.h(R.string.TR_BLOG_BUTTON));
        textView7.setOnClickListener(new d());
        TextView textView8 = (TextView) inflate.findViewById(R.id.tv_find_us);
        textView8.setTypeface(a.c.d.r.e.a().f788a);
        textView8.setText(a.c.a.d.a.h(R.string.TR_FIND_US));
        ((RelativeLayout) inflate.findViewById(R.id.rl_contact_phone)).setOnClickListener(new e());
        ((RelativeLayout) inflate.findViewById(R.id.rl_contact_email)).setOnClickListener(new f());
        TextView textView9 = (TextView) inflate.findViewById(R.id.tv_contact_phone);
        textView9.setTypeface(a.c.d.r.e.a().f789b);
        textView9.setText(a.c.a.d.a.h(R.string.TR_MINILAND_WORLD_CONTACT_PHONE));
        TextView textView10 = (TextView) inflate.findViewById(R.id.tv_contact_email);
        textView10.setTypeface(a.c.d.r.e.a().f789b);
        textView10.setText(a.c.a.d.a.h(R.string.TR_MINILAND_WORLD_CONTACT_EMAIL));
        TextView textView11 = (TextView) inflate.findViewById(R.id.tv_social_networks);
        textView11.setTypeface(a.c.d.r.e.a().f788a);
        textView11.setText(a.c.a.d.a.h(R.string.TR_RR_SS));
        ((ImageView) inflate.findViewById(R.id.iv_social_instagram)).setOnClickListener(new g());
        ((ImageView) inflate.findViewById(R.id.iv_social_facebook)).setOnClickListener(new h());
        return inflate;
    }
}
