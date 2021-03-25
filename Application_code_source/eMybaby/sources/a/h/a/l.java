package a.h.a;

import android.app.DatePickerDialog;
import android.view.View;
import com.sozpic.miniland.MyProfileActivity;
import java.util.Calendar;

public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyProfileActivity f3508a;

    public l(MyProfileActivity myProfileActivity) {
        this.f3508a = myProfileActivity;
    }

    public void onClick(View view) {
        MyProfileActivity myProfileActivity = this.f3508a;
        if (myProfileActivity.m == null) {
            myProfileActivity.m = Calendar.getInstance();
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(myProfileActivity, new n(myProfileActivity), myProfileActivity.m.get(1), myProfileActivity.m.get(2), myProfileActivity.m.get(5));
        datePickerDialog.getDatePicker().setMaxDate(myProfileActivity.m.getTimeInMillis());
        datePickerDialog.show();
    }
}
