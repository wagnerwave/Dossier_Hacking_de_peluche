package a.c.d.g;

import android.content.DialogInterface;
import android.view.inputmethod.InputMethodManager;
import com.cuatroochenta.miniland.emybuddy.BuddyActivateActivity;

public class b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BuddyActivateActivity f65a;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            BuddyActivateActivity.r(b.this.f65a);
            ((InputMethodManager) b.this.f65a.getSystemService("input_method")).hideSoftInputFromInputMethod(b.this.f65a.f3813b.getWindowToken(), 1);
        }
    }

    public b(BuddyActivateActivity buddyActivateActivity) {
        this.f65a = buddyActivateActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f65a.f3814c.post(new a());
    }
}
