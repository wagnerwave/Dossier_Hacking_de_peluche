package a.c.d.j.b.a;

import a.c.d.j.b.c.a;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.sozpic.miniland.R;
import com.tuya.smart.android.common.utils.L;

public class b extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public Toolbar f166a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f167b = true;

    /* renamed from: c  reason: collision with root package name */
    public View f168c;

    /* renamed from: d  reason: collision with root package name */
    public long f169d;

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector f170e;
    public boolean f = true;

    public static void setViewGone(View view) {
        if (view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static void setViewVisible(View view) {
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f170e;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void finishActivity() {
        onBackPressed();
    }

    public void hideLoading() {
        a.c.a.f.b.J();
    }

    public void o() {
        if (this.f166a == null) {
            this.f166a = (Toolbar) findViewById(R.id.toolbar_top_view);
        }
    }

    public void onBackPressed() {
        finish();
        a.c.a.f.b.Y(this, 1);
        super.onBackPressed();
        if (this.f) {
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        a.a(this);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        String str;
        if (isFinishing()) {
            return true;
        }
        if (i == 4 && Math.abs(keyEvent.getEventTime() - this.f169d) < 400) {
            str = "baseactivity onKeyDown after onResume to close, do none";
        } else if (keyEvent.getRepeatCount() > 0 || p(i, keyEvent)) {
            str = "baseactivity onKeyDown true";
        } else if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        } else {
            finish();
            a.c.a.f.b.Y(this, 1);
            return true;
        }
        L.d("BaseActivity", str);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 176) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onPause() {
        super.onPause();
        this.f167b = true;
    }

    public void onResume() {
        super.onResume();
        this.f167b = false;
        this.f169d = SystemClock.uptimeMillis();
    }

    public boolean p(int i, KeyEvent keyEvent) {
        if (i == 176) {
            return true;
        }
        if (i != 4) {
            return false;
        }
        onBackPressed();
        return true;
    }

    public void q() {
        Toolbar toolbar = this.f166a;
        if (toolbar != null) {
            toolbar.setNavigationIcon((int) R.drawable.ic_action_menu_atras);
            this.f166a.setNavigationOnClickListener(new a(this));
        }
    }

    public void r(String str) {
        Toolbar toolbar = this.f166a;
        if (toolbar != null) {
            toolbar.setTitle((CharSequence) str);
        }
    }

    public void setContentView(int i) {
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
        this.f168c = inflate;
        super.setContentView(inflate);
    }

    public void setContentView(View view) {
        this.f168c = view;
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.f168c = view;
        super.setContentView(view, layoutParams);
    }

    public void setTitle(int i) {
        Toolbar toolbar = this.f166a;
        if (toolbar != null) {
            toolbar.setTitle((CharSequence) a.c.a.d.a.h(i));
        }
    }

    public void showLoading() {
        a.c.a.f.b.n0(this, R.string.TR_LOADING);
    }

    public void showLoading(int i) {
        a.c.a.f.b.n0(this, i);
    }

    public void showToast(int i) {
        a.c.a.f.b.q0(this, i);
    }

    public void showToast(String str) {
        a.c.a.f.b.r0(this, str);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        if (this.f) {
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
        if (this.f) {
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }
}
