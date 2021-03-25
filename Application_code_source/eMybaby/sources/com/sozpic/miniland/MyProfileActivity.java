package com.sozpic.miniland;

import a.c.d.c;
import a.c.d.r.e;
import a.c.d.s.f.a.a;
import a.c.d.s.f.a.c;
import a.c.d.s.f.b.d;
import a.h.a.l;
import a.h.a.m;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSpinner;
import com.cuatroochenta.miniland.model.MyProfile;
import com.cuatroochenta.miniland.webservices.profile.get.MyProfileGetRequest;
import com.cuatroochenta.miniland.webservices.profile.post.MyProfilePostRequest;
import com.tuya.smart.common.OO000o0;
import com.tuya.smart.common.oOO0O0O0;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MyProfileActivity extends c implements a, a.c.d.s.f.b.a {

    /* renamed from: b  reason: collision with root package name */
    public EditText f4480b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f4481c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f4482d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4483e;
    public AppCompatSpinner f;
    public AppCompatSpinner g;
    public EditText h;
    public EditText i;
    public EditText j;
    public EditText k;
    public EditText l;
    public Calendar m;
    public List<String> n;
    public List<String> o;

    public static void q(MyProfileActivity myProfileActivity) {
        if (myProfileActivity != null) {
            MyProfile myProfile = new MyProfile();
            myProfile.setName(myProfileActivity.f4480b.getText().toString());
            myProfile.setSurname(myProfileActivity.f4481c.getText().toString());
            myProfile.setBirthDate(myProfileActivity.r(myProfileActivity.f4483e.getText().toString(), true));
            String obj = myProfileActivity.f.getSelectedItem().toString();
            String[] iSOCountries = Locale.getISOCountries();
            HashMap hashMap = new HashMap();
            for (String str : iSOCountries) {
                hashMap.put(new Locale("", str).getDisplayCountry(), str);
            }
            myProfile.setCountryCode((String) hashMap.get(obj));
            myProfile.setChildren(myProfileActivity.g.getSelectedItem().toString());
            myProfile.setPhone(myProfileActivity.h.getText().toString());
            myProfile.setAddress(myProfileActivity.i.getText().toString());
            myProfile.setPostalCode(myProfileActivity.j.getText().toString());
            myProfile.setTown(myProfileActivity.k.getText().toString());
            myProfile.setProvince(myProfileActivity.l.getText().toString());
            new d.a(new MyProfilePostRequest(myProfile), myProfileActivity).start();
            myProfileActivity.p(a.c.a.d.a.h(R.string.TR_UPDATING), false);
            return;
        }
        throw null;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_my_profile);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_MI_PERFIL));
        EditText editText = (EditText) a.a.a.a.a.B((TextView) findViewById(R.id.tv_profile_name), e.a().f788a, R.string.TR_NAME, this, R.id.et_profile_name);
        this.f4480b = editText;
        editText.setTypeface(e.a().f789b);
        EditText editText2 = (EditText) a.a.a.a.a.B((TextView) findViewById(R.id.tv_profile_surname), e.a().f788a, R.string.TR_SURNAME, this, R.id.et_profile_surname);
        this.f4481c = editText2;
        editText2.setTypeface(e.a().f789b);
        EditText editText3 = (EditText) a.a.a.a.a.B((TextView) findViewById(R.id.tv_profile_email), e.a().f788a, R.string.TR_EMAIL, this, R.id.et_profile_email);
        this.f4482d = editText3;
        editText3.setTypeface(e.a().f789b);
        TextView textView = (TextView) a.a.a.a.a.B((TextView) findViewById(R.id.tv_profile_born_date), e.a().f788a, R.string.TR_DATE_BIRTH, this, R.id.et_profile_born_date);
        this.f4483e = textView;
        textView.setTypeface(e.a().f789b);
        this.f4483e.setOnClickListener(new l(this));
        this.f = (AppCompatSpinner) a.a.a.a.a.B((TextView) findViewById(R.id.tv_profile_country), e.a().f788a, R.string.TR_COUNTRY, this, R.id.sp_country);
        Locale[] availableLocales = Locale.getAvailableLocales();
        this.n = new ArrayList();
        for (Locale displayCountry : availableLocales) {
            String displayCountry2 = displayCountry.getDisplayCountry();
            if (displayCountry2.trim().length() > 0 && !this.n.contains(displayCountry2)) {
                this.n.add(displayCountry2);
            }
        }
        Collections.sort(this.n);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_item, this.n);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.f.setAdapter((SpinnerAdapter) arrayAdapter);
        this.g = (AppCompatSpinner) a.a.a.a.a.B((TextView) findViewById(R.id.tv_profile_childs), e.a().f788a, R.string.TR_NUMBER_OF_CHILDREN, this, R.id.sp_childs);
        ArrayList arrayList = new ArrayList();
        this.o = arrayList;
        arrayList.add(oOO0O0O0.O0000oO0);
        this.o.add("1");
        this.o.add("2");
        this.o.add(OO000o0.O00000o);
        this.o.add(OO000o0.O00000o0);
        this.o.add("5");
        this.o.add("6");
        this.o.add("7");
        this.o.add("8");
        this.o.add("9");
        this.o.add("10");
        this.o.add("11");
        this.o.add("12");
        this.o.add("13");
        this.o.add("14");
        this.o.add("15");
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, R.layout.simple_spinner_item, this.o);
        arrayAdapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.g.setAdapter((SpinnerAdapter) arrayAdapter2);
        EditText editText4 = (EditText) a.a.a.a.a.B((TextView) findViewById(R.id.tv_profile_phone), e.a().f788a, R.string.TR_TELEFONO, this, R.id.et_profile_phone);
        this.h = editText4;
        editText4.setTypeface(e.a().f789b);
        EditText editText5 = (EditText) a.a.a.a.a.B((TextView) findViewById(R.id.tv_profile_address), e.a().f788a, R.string.TR_DIRECCION, this, R.id.et_profile_address);
        this.i = editText5;
        editText5.setTypeface(e.a().f789b);
        EditText editText6 = (EditText) a.a.a.a.a.B((TextView) findViewById(R.id.tv_profile_postal_code), e.a().f788a, R.string.TR_CODIGO_POSTAL, this, R.id.et_profile_postal_code);
        this.j = editText6;
        editText6.setTypeface(e.a().f789b);
        EditText editText7 = (EditText) a.a.a.a.a.B((TextView) findViewById(R.id.tv_profile_town), e.a().f788a, R.string.TR_LOCALIDAD, this, R.id.et_profile_town);
        this.k = editText7;
        editText7.setTypeface(e.a().f789b);
        EditText editText8 = (EditText) a.a.a.a.a.B((TextView) findViewById(R.id.tv_profile_province), e.a().f788a, R.string.TR_PROVINCIA, this, R.id.et_profile_province);
        this.l = editText8;
        editText8.setTypeface(e.a().f789b);
        TextView textView2 = (TextView) findViewById(R.id.tv_btn_profile_save);
        textView2.setTypeface(e.a().f788a);
        textView2.setText(a.c.a.d.a.h(R.string.TR_GUARDAR));
        textView2.setOnClickListener(new m(this));
        new c.a(new MyProfileGetRequest(), this).start();
        p(a.c.a.d.a.h(R.string.TR_GETTING_INFO), false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public final String r(String str, boolean z) {
        String str2 = "d 'de' MMMM 'de' yyyy";
        String str3 = z ? str2 : "dd-MM-yyyy";
        if (z) {
            str2 = "dd-MM-yyyy";
        }
        try {
            return new SimpleDateFormat(str2).format(new SimpleDateFormat(str3).parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
