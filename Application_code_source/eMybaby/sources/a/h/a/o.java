package a.h.a;

import a.c.a.d.a;
import a.c.d.s.f.a.b;
import com.cuatroochenta.miniland.model.MyProfile;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.MyProfileActivity;
import com.sozpic.miniland.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f3535a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyProfileActivity f3536b;

    public o(MyProfileActivity myProfileActivity, b bVar) {
        this.f3536b = myProfileActivity;
        this.f3535a = bVar;
    }

    public void run() {
        this.f3536b.o();
        if (this.f3535a.f42a.booleanValue()) {
            MyProfileActivity myProfileActivity = this.f3536b;
            MyProfile myProfile = this.f3535a.f1137c;
            myProfileActivity.f4480b.setText(myProfile.getName());
            myProfileActivity.f4481c.setText(myProfile.getSurname());
            myProfileActivity.f4482d.setText(AppMiniland.f().i().getCorreo());
            String birthDate = myProfile.getBirthDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                if (myProfileActivity.m == null) {
                    myProfileActivity.m = Calendar.getInstance();
                }
                myProfileActivity.m.setTime(simpleDateFormat.parse(birthDate));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
            myProfileActivity.f4483e.setText(myProfileActivity.r(myProfile.getBirthDate(), false));
            Locale locale = new Locale("", myProfile.getCountryCode());
            locale.getDisplayCountry();
            myProfileActivity.f.setSelection(myProfileActivity.n.indexOf(locale.getDisplayCountry()));
            myProfileActivity.g.setSelection(myProfileActivity.o.indexOf(myProfile.getChildren()));
            myProfileActivity.h.setText(myProfile.getPhone());
            myProfileActivity.i.setText(myProfile.getAddress());
            myProfileActivity.j.setText(myProfile.getPostalCode());
            myProfileActivity.k.setText(myProfile.getTown());
            myProfileActivity.l.setText(myProfile.getProvince());
            return;
        }
        a.c.a.f.b.h0(this.f3536b, a.h(R.string.TR_ERROR_RECUPERANDO_PERFIL_USUARIO), a.h(R.string.TR_ACEPTAR));
    }
}
