package a.c.d.g;

import android.content.DialogInterface;
import android.view.inputmethod.InputMethodManager;
import com.cuatroochenta.miniland.emybuddy.BuddyActivateActivity;

public class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BuddyActivateActivity f64a;

    public a(BuddyActivateActivity buddyActivateActivity) {
        this.f64a = buddyActivateActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        ((InputMethodManager) this.f64a.getSystemService("input_method")).hideSoftInputFromInputMethod(this.f64a.f3813b.getWindowToken(), 1);
    }
}
