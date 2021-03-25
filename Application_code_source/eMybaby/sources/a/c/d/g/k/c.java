package a.c.d.g.k;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.util.TimeUtils;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.cuatroochenta.miniland.player.PlayerService;
import com.sozpic.miniland.R;
import kankan.wheel.widget.WheelView;

public class c extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public int f119a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f120b = 0;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f121c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f122d;

    /* renamed from: e  reason: collision with root package name */
    public WheelView f123e;
    public TextView f;
    public TextView g;
    public TextView h;
    public ViewGroup i;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            c cVar = c.this;
            int i = cVar.f119a;
            if (i == 0 || i == 1) {
                a.c.a.f.b.g0(c.this.getActivity(), 9);
                return;
            }
            if (!a.c.a.f.b.U(cVar.getActivity()) && (c.this.getActivity() instanceof BuddyPlayerActivity)) {
                ((BuddyPlayerActivity) c.this.getActivity()).w(0);
            }
            int currentItem = c.this.f123e.getCurrentItem() + (c.this.f122d.getCurrentItem() * 60) + (c.this.f121c.getCurrentItem() * TimeUtils.SECONDS_PER_HOUR);
            FragmentActivity activity = c.this.getActivity();
            if (a.c.a.f.b.U(activity)) {
                Intent intent = new Intent(activity, PlayerService.class);
                intent.putExtra("EXTRA_PLAYER_NOTIFY_OPTION", 7);
                intent.putExtra("EXTRA_KEY_START_COUNTDOWN", currentItem);
                activity.startService(intent);
            }
            c.this.dismiss();
        }
    }

    /* renamed from: a.c.d.g.k.c$c  reason: collision with other inner class name */
    public class C0004c implements View.OnClickListener {
        public C0004c() {
        }

        public void onClick(View view) {
            FragmentActivity fragmentActivity;
            int i;
            c cVar = c.this;
            int i2 = cVar.f119a;
            if (i2 == 0) {
                fragmentActivity = cVar.getActivity();
                i = 10;
            } else if (i2 == 1) {
                fragmentActivity = cVar.getActivity();
                i = 8;
            } else {
                return;
            }
            a.c.a.f.b.g0(fragmentActivity, i);
        }
    }

    public final void m() {
        TextView textView;
        int i2;
        int i3 = this.f119a;
        if (i3 != 0) {
            if (i3 != 1) {
                this.f.setVisibility(8);
                this.i.setVisibility(0);
                this.g.setText(a.c.a.d.a.h(R.string.TR_START));
                this.g.setBackgroundResource(R.drawable.bg_green_leftbottom_rounded);
                this.h.setText(a.c.a.d.a.h(R.string.TR_PAUSE));
                textView = this.h;
                i2 = R.drawable.bg_grey_rightbottom_rounded;
                textView.setBackgroundResource(i2);
            }
            this.h.setText(a.c.a.d.a.h(R.string.TR_RESUME));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
            alphaAnimation.setDuration(1000);
            alphaAnimation.setStartOffset(20);
            alphaAnimation.setRepeatMode(2);
            alphaAnimation.setRepeatCount(-1);
            this.f.startAnimation(alphaAnimation);
        }
        if (this.f119a != 1) {
            this.h.setText(a.c.a.d.a.h(R.string.TR_PAUSE));
            this.f.clearAnimation();
        }
        this.f.setText(a.c.a.d.a.e(this.f120b));
        this.i.setVisibility(8);
        this.f.setVisibility(0);
        this.g.setText(a.c.a.d.a.h(R.string.TR_CANCEL));
        this.g.setBackgroundResource(R.drawable.bg_red_leftbottom_rounded);
        textView = this.h;
        i2 = R.drawable.bg_green_rightbottom_rounded;
        textView.setBackgroundResource(i2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f119a = arguments.getInt("ARG_STATUS", -1);
            this.f120b = arguments.getInt("ARG_TIME_FINISH", 0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_dialog_timer, viewGroup, false);
        ((ImageView) inflate.findViewById(R.id.timer_dialog_close)).setOnClickListener(new a());
        this.g = (TextView) inflate.findViewById(R.id.timer_dialog_left_button);
        this.h = (TextView) inflate.findViewById(R.id.timer_dialog_right_button);
        this.g.setOnClickListener(new b());
        this.h.setOnClickListener(new C0004c());
        ((TextView) inflate.findViewById(R.id.timer_dialog_title)).setText(a.c.a.d.a.h(R.string.TR_PLAY_TIME));
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.time_dialog_picker_container);
        this.i = viewGroup2;
        viewGroup2.setVisibility(8);
        this.f121c = (WheelView) inflate.findViewById(R.id.timer_dialog_hour);
        this.f122d = (WheelView) inflate.findViewById(R.id.timer_dialog_mins);
        this.f123e = (WheelView) inflate.findViewById(R.id.timer_dialog_sec);
        c.a.b.g.b bVar = new c.a.b.g.b(getActivity(), 0, 23, "%02d");
        bVar.f3772c = getResources().getDimensionPixelSize(R.dimen.fuente_home);
        bVar.f3771b = getResources().getColor(R.color.dialog_border);
        bVar.f3774e = getResources().getDimensionPixelSize(R.dimen.fuente_home);
        bVar.f = 17;
        bVar.f3773d = ViewCompat.MEASURED_STATE_MASK;
        c.a.b.g.b bVar2 = new c.a.b.g.b(getActivity(), 0, 59, "%02d");
        bVar2.f3771b = getResources().getColor(R.color.dialog_border);
        bVar2.f3772c = getResources().getDimensionPixelSize(R.dimen.fuente_home);
        bVar2.f3774e = getResources().getDimensionPixelSize(R.dimen.fuente_home);
        bVar2.f = 17;
        bVar2.f3773d = ViewCompat.MEASURED_STATE_MASK;
        c.a.b.g.b bVar3 = new c.a.b.g.b(getActivity(), 0, 59, "%02d");
        bVar3.f3771b = getResources().getColor(R.color.dialog_border);
        bVar3.f3772c = getResources().getDimensionPixelSize(R.dimen.fuente_home);
        bVar3.f3774e = getResources().getDimensionPixelSize(R.dimen.fuente_home);
        bVar3.f = 17;
        bVar3.f3773d = ViewCompat.MEASURED_STATE_MASK;
        this.f121c.setViewAdapter(bVar);
        this.f123e.setViewAdapter(bVar2);
        this.f122d.setViewAdapter(bVar3);
        this.f121c.p.add(bVar);
        this.f123e.p.add(bVar2);
        this.f122d.p.add(bVar3);
        this.f121c.setCyclic(true);
        this.f122d.setCyclic(true);
        this.f123e.setCyclic(true);
        this.f121c.setDrawShadows(false);
        this.f123e.setDrawShadows(false);
        this.f122d.setDrawShadows(false);
        TextView textView = (TextView) inflate.findViewById(R.id.time_dialog_countdown);
        this.f = textView;
        textView.setVisibility(8);
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawableResource(17170445);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        m();
    }
}
