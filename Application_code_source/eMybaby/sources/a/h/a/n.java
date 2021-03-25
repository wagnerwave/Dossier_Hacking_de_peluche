package a.h.a;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;
import com.sozpic.miniland.MyProfileActivity;

public class n implements DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyProfileActivity f3523a;

    public n(MyProfileActivity myProfileActivity) {
        this.f3523a = myProfileActivity;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        MyProfileActivity myProfileActivity = this.f3523a;
        TextView textView = myProfileActivity.f4483e;
        textView.setText(myProfileActivity.r(i3 + "-" + (i2 + 1) + "-" + i, false));
    }
}
