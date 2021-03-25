package a.c.d.m.i.k;

import a.c.a.d.a;
import a.c.a.f.e;
import a.c.d.r.i;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.cuatroochenta.miniland.pregnancy.customs.CircleGreenWeeksLeft;
import com.sozpic.miniland.R;
import java.util.Calendar;
import java.util.Date;

public abstract class m0 extends Fragment implements l0 {

    /* renamed from: a  reason: collision with root package name */
    public ProgressDialog f629a;

    /* renamed from: b  reason: collision with root package name */
    public View f630b;

    /* renamed from: c  reason: collision with root package name */
    public k0 f631c;

    /* renamed from: d  reason: collision with root package name */
    public TypedValue f632d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f633e;
    public TextView f;
    public TextView g;
    public FrameLayout h;
    public FrameLayout i;
    public LinearLayout j;
    public CircleGreenWeeksLeft k;

    public void A() {
        this.i.setOnClickListener((View.OnClickListener) null);
    }

    public void B() {
        this.h.setOnClickListener((View.OnClickListener) null);
    }

    public void C(String str, boolean z) {
        if (!getActivity().isFinishing()) {
            ProgressDialog progressDialog = this.f629a;
            if (progressDialog == null || !progressDialog.isShowing()) {
                try {
                    ProgressDialog progressDialog2 = new ProgressDialog(getActivity());
                    this.f629a = progressDialog2;
                    progressDialog2.setMessage(str);
                    this.f629a.setCancelable(z);
                    this.f629a.show();
                } catch (Exception e2) {
                    e.e(e2.getLocalizedMessage());
                }
            }
        }
    }

    public View m(@IdRes int i2) {
        return this.f630b.findViewById(i2);
    }

    public abstract String n();

    public abstract View.OnClickListener o();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        k0 k0Var = (k0) activity;
        this.f631c = k0Var;
        k0Var.n(this);
    }

    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f630b = layoutInflater.inflate(q(), viewGroup, false);
        v();
        u();
        w();
        t();
        this.f632d = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.selectableItemBackground, this.f632d, true);
        x();
        return this.f630b;
    }

    public void onDetach() {
        super.onDetach();
        this.f631c.j(this);
        this.f631c = null;
    }

    public int p() {
        TypedValue typedValue = this.f632d;
        if (typedValue != null) {
            return typedValue.resourceId;
        }
        return 0;
    }

    public abstract int q();

    public abstract String r();

    public void s() {
        ProgressDialog progressDialog = this.f629a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f629a.dismiss();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            B();
            A();
        }
    }

    public abstract void t();

    public abstract void u();

    public void v() {
        TextView textView = (TextView) m(R.id.tv_mama_section_header_title);
        this.f633e = textView;
        textView.setText(a.h(R.string.TR_MENU_MI_EMBARAZO_MAMA));
        TextView textView2 = (TextView) m(R.id.tv_mama_section_header_subtitle);
        this.f = textView2;
        textView2.setText(r());
        TextView textView3 = (TextView) m(R.id.tv_mama_add_new);
        this.g = textView3;
        textView3.setText(n());
        this.g.setOnClickListener(o());
        CircleGreenWeeksLeft circleGreenWeeksLeft = (CircleGreenWeeksLeft) m(R.id.mama_add_new_circle_weeks);
        this.k = circleGreenWeeksLeft;
        circleGreenWeeksLeft.setSemanasHoyText(a.h(R.string.TR_SEMANAS_HOY).toUpperCase());
        Date time = Calendar.getInstance().getTime();
        this.k.setWeeks((int) i.c(time));
        this.k.setDays((int) i.a(time));
    }

    public abstract void w();

    public abstract void x();

    public void y() {
        this.j.setVisibility(8);
    }

    public void z() {
        this.j.setVisibility(0);
    }
}
