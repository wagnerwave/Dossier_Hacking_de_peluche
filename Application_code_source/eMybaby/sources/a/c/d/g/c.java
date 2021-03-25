package a.c.d.g;

import android.view.inputmethod.InputMethodManager;
import com.cuatroochenta.miniland.emybuddy.BuddyActivateActivity;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BuddyActivateActivity f67a;

    public c(BuddyActivateActivity buddyActivateActivity) {
        this.f67a = buddyActivateActivity;
    }

    public void run() {
        this.f67a.f3813b.requestFocus();
        ((InputMethodManager) this.f67a.getSystemService("input_method")).showSoftInput(this.f67a.f3813b, 1);
    }
}
