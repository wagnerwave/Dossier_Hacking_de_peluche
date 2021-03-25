package a.a.a.a;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.sozpic.miniland.MyProfileActivity;
import com.sozpic.miniland.modelos.ElementoMenu;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.o00o0000oo;
import com.tuya.smart.common.o00oo0oo00;
import com.tuya.spongycastle.asn1.ASN1ObjectIdentifier;
import java.util.HashMap;

/* compiled from: outline */
public class a {
    public static View A(int i, TextView textView, Dialog dialog, int i2) {
        textView.setText(a.c.a.d.a.h(i));
        return dialog.findViewById(i2);
    }

    public static View B(TextView textView, Typeface typeface, int i, MyProfileActivity myProfileActivity, int i2) {
        textView.setTypeface(typeface);
        textView.setText(a.c.a.d.a.h(i));
        return myProfileActivity.findViewById(i2);
    }

    public static ElementoMenu C(int i) {
        ElementoMenu elementoMenu = new ElementoMenu();
        elementoMenu.setId(i);
        return elementoMenu;
    }

    public static ApiParams D(String str, String str2, String str3, String str4) {
        ApiParams apiParams = new ApiParams(str, str2);
        apiParams.putPostData(str3, str4);
        return apiParams;
    }

    public static ApiParams E(String str, String str2, boolean z) {
        ApiParams apiParams = new ApiParams(str, str2);
        apiParams.setSessionRequire(z);
        return apiParams;
    }

    public static ApiParams F(String str, String str2, boolean z, String str3, String str4) {
        ApiParams apiParams = new ApiParams(str, str2);
        apiParams.setSessionRequire(z);
        apiParams.putPostData(str3, str4);
        return apiParams;
    }

    public static float a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static int b(int i, int i2, int i3, int i4) {
        return i + i2 + i3 + i4;
    }

    public static ASN1ObjectIdentifier c(String str) {
        return new ASN1ObjectIdentifier(str).intern();
    }

    public static String d(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String e(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String f(Exception exc, StringBuilder sb) {
        sb.append(exc.toString());
        return sb.toString();
    }

    public static String g(Object obj, StringBuilder sb) {
        sb.append(obj.getClass().getName());
        return sb.toString();
    }

    public static String h(String str, int i) {
        return str + i;
    }

    public static String i(String str, long j) {
        return str + j;
    }

    public static String j(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String k(String str, String str2) {
        return str + str2;
    }

    public static String l(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String m(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder n(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder o(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder p(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder q(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static HashMap r(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        return hashMap;
    }

    public static void s(int i, ElementoMenu elementoMenu, int i2) {
        elementoMenu.setNombre(a.c.a.d.a.h(i));
        elementoMenu.setImagen(i2);
    }

    public static void t(FragmentActivity fragmentActivity, Class cls) {
        fragmentActivity.startActivity(new Intent(fragmentActivity, cls));
    }

    public static void u(String str, Fragment fragment, String str2) {
        Log.v(str2, str + fragment);
    }

    public static void v(String str, String str2, String str3) {
        L.d(str3, str + str2);
    }

    public static long w(long j, long j2, long j3, long j4) {
        return (j * j2) + j3 + j4;
    }

    public static void x(StringBuilder sb, String str, char c2, String str2) {
        sb.append(str);
        sb.append(c2);
        sb.append(str2);
    }

    public static void y(byte[] bArr, boolean z, StringBuilder sb, String str) {
        sb.append(o00o0000oo.O000000o(bArr, z));
        o00oo0oo00.O000000o(str, sb.toString());
    }

    public static void z(byte[] bArr, boolean z, StringBuilder sb, String str) {
        sb.append(o00o0000oo.O000000o(bArr, z));
        o00oo0oo00.O00000o(str, sb.toString());
    }
}
