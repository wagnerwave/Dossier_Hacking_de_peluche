package a.c.d.r;

import a.c.d.f.a;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.tuya.smart.common.OO000o0;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class j {

    /* renamed from: d  reason: collision with root package name */
    public static j f798d;

    /* renamed from: e  reason: collision with root package name */
    public static final SimpleDateFormat f799e = new SimpleDateFormat("yyyymmdd_hhmmss'.mp4'");
    public static DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
    public static DateFormat g = new SimpleDateFormat("dd-MM-yy");
    public static DateFormat h = new SimpleDateFormat("dd MMMM yyyy");
    public static DateFormat i = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public static DateFormat j = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static DateFormat k = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    public static DateFormat l = new SimpleDateFormat("HH:mm");
    public static DateFormat m = new SimpleDateFormat("HH:mm:ss");
    public static DateFormat n = new SimpleDateFormat("EEEE,dd/MM/yyyy");
    public static String o = "1";
    public static String p = "2";
    public static String q = OO000o0.O00000o;
    public static String r = OO000o0.O00000o0;
    public static String s = "5";

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f800a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f801b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Integer> f802c = new HashMap<>();

    static {
        new SimpleDateFormat("dd/MM/yyyy HH:mm");
    }

    public j() {
        f798d = this;
        h();
    }

    public static final j b() {
        if (f798d == null) {
            f798d = new j();
        }
        return f798d;
    }

    public static String c(int i2) {
        int i3;
        if (i2 == 0) {
            i3 = R.string.TR_UNIT_TYPE_KGS;
        } else if (i2 == 1) {
            i3 = R.string.TR_UNIT_TYPE_LBS;
        } else if (i2 == 2) {
            i3 = R.string.TR_UNIT_TYPE_STS;
        } else if (i2 == 3) {
            i3 = R.string.TR_UNIT_TYPE_OZS;
        } else if (i2 != 4) {
            return "";
        } else {
            i3 = R.string.TR_UNIT_TYPE_GRS;
        }
        return a.c.a.d.a.h(i3);
    }

    public void a(a aVar) {
        if (!this.f800a.contains(aVar)) {
            this.f800a.add(aVar);
        }
    }

    public int d(String str) {
        if (this.f802c.isEmpty()) {
            h();
        }
        if (this.f802c.containsKey(str)) {
            return this.f802c.get(str).intValue();
        }
        return 0;
    }

    public String e(String str) {
        if (this.f801b.isEmpty()) {
            h();
        }
        return this.f801b.containsKey(str) ? this.f801b.get(str) : "";
    }

    public String f() {
        return a.a.a.a.a.m(a.a.a.a.a.n("https://emybaby.com/politica_privacidad_"), AppMiniland.f().f1b, ".htm");
    }

    public String g() {
        StringBuilder sb = new StringBuilder("https://emybaby.com/");
        sb.append("terminos_y_condiciones");
        String str = AppMiniland.f().f1b;
        if (!"es".equals(str)) {
            sb.append("_");
            sb.append(str);
        }
        sb.append(".html");
        return sb.toString();
    }

    public void h() {
        this.f801b.clear();
        this.f801b.put("BUDDY_PARENTS", a.c.a.d.a.h(R.string.TR_PARENT_SOUNDS));
        this.f801b.put("BUDDY_NATURE", a.c.a.d.a.h(R.string.TR_NATURE));
        this.f801b.put("BUDDY_CLOSE_MUM", a.c.a.d.a.h(R.string.TR_CLOSE_TO_MUM));
        this.f801b.put("BUDDY_CLASSIC", a.c.a.d.a.h(R.string.TR_CLASSICAL_EXPERIENCE));
        this.f801b.put("BUDDY_LULLABIES", a.c.a.d.a.h(R.string.TR_LULLABIES));
        this.f801b.put("BUDDY_DEVICE", a.c.a.d.a.h(R.string.TR_DEVICE_MUSIC));
        this.f801b.put("BUDDY_FAVOURITES", a.c.a.d.a.h(R.string.TR_FAVOURITES));
        this.f801b.put("BUDDY_SETTINGS", a.c.a.d.a.h(R.string.TR_SETTINGS));
        this.f801b.put("PREGNANCY_ESCUCHA", a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_ESCUCHALATIDOS));
        this.f801b.put("PREGNANCY_MY_SOUNDS", a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_TUS_SONIDOS));
        this.f801b.put("PREGNANCY_BABY", a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_BEBE));
        this.f801b.put("PREGNANCY_MOM", a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_MAMA));
        this.f801b.put("PREGNANCY_MEDICAL_RECORDS", a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_CITAS_MEDICAS));
        this.f801b.put("PREGNANCY_CONTRACTIONS", a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_CONTRACCIONES));
        this.f801b.put("PREGNANCY_JOURNEY", a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_DIARIO_BEBE));
        this.f801b.put("PREGNANCY_SETTINGS", a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_AJUSTES));
        this.f802c.clear();
        this.f802c.put("BUDDY_PARENTS", Integer.valueOf(R.drawable.bg_menu_buddy_parents));
        this.f802c.put("BUDDY_NATURE", Integer.valueOf(R.drawable.bg_menu_buddy_nature));
        this.f802c.put("BUDDY_CLOSE_MUM", Integer.valueOf(R.drawable.bg_menu_buddy_close_mum));
        this.f802c.put("BUDDY_CLASSIC", Integer.valueOf(R.drawable.bg_menu_buddy_classical));
        this.f802c.put("BUDDY_LULLABIES", Integer.valueOf(R.drawable.bg_menu_buddy_lullabies));
        this.f802c.put("BUDDY_DEVICE", Integer.valueOf(R.drawable.bg_menu_buddy_device));
        this.f802c.put("BUDDY_FAVOURITES", Integer.valueOf(R.drawable.bg_menu_buddy_favourites));
        this.f802c.put("BUDDY_SETTINGS", Integer.valueOf(R.drawable.bg_menu_buddy_settings));
        this.f802c.put("PREGNANCY_ESCUCHA", Integer.valueOf(R.drawable.bg_menu_pregnancy_escucha));
        this.f802c.put("PREGNANCY_MY_SOUNDS", Integer.valueOf(R.drawable.bg_menu_pregnancy_my_sounds));
        this.f802c.put("PREGNANCY_BABY", Integer.valueOf(R.drawable.bg_menu_pregnancy_baby));
        this.f802c.put("PREGNANCY_MOM", Integer.valueOf(R.drawable.bg_menu_pregnancy_mom));
        this.f802c.put("PREGNANCY_MEDICAL_RECORDS", Integer.valueOf(R.drawable.bg_menu_pregnancy_medical_records));
        this.f802c.put("PREGNANCY_CONTRACTIONS", Integer.valueOf(R.drawable.bg_menu_pregnancy_contractions));
        this.f802c.put("PREGNANCY_JOURNEY", Integer.valueOf(R.drawable.bg_menu_pregnancy_journey));
        this.f802c.put("PREGNANCY_SETTINGS", Integer.valueOf(R.drawable.bg_menu_pregnancy_settings));
    }
}
