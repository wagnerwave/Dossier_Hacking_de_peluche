package a.e.a.a.r;

import a.c.a.d.a;
import a.e.a.a.r.c.c;
import a.g.a.b.d;
import a.g.a.b.l.e;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.android.material.badge.BadgeDrawable;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Familia;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.sdk.security.EncryptionManager;
import com.tuya.smart.common.OO000o0;
import com.tuya.smart.common.o00oo0o00o;
import com.tuya.smart.common.o0ooo00oo;
import e.a.a.g;
import e.a.a.i0.m;
import e.a.a.j;
import e.a.a.o;
import e.a.a.q;
import e.a.a.s;
import e.a.a.w;
import e.b.a.a.a.n;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public static <T> T A(Object obj, Class<?> cls, a.e.a.a.r.c.b bVar) {
        return B(obj, cls, bVar, false, false);
    }

    public static <T> T B(Object obj, Class<?> cls, a.e.a.a.r.c.b bVar, boolean z, boolean z2) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{cls}, new c(obj, bVar, z, z2));
    }

    public static int C(e.a.a.j0.c cVar) {
        if (cVar != null) {
            return cVar.b("http.socket.timeout", 0);
        }
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static <T> T D(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new c(obj, (a.e.a.a.r.c.b) null, false, true));
    }

    public static w E(e.a.a.j0.c cVar) {
        if (cVar != null) {
            Object e2 = cVar.e("http.protocol.version");
            return e2 == null ? q.f : (w) e2;
        }
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static int F(int i, Object obj) {
        if (obj == null) {
            return (i * 37) + 0;
        }
        if (!I(obj)) {
            return (i * 37) + obj.hashCode();
        }
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            i = F(i, Array.get(obj, i2));
        }
        return i;
    }

    public static int G(int i, Object obj) {
        return (i * 37) + (obj != null ? obj.hashCode() : 0);
    }

    public static void H(String str, Object... objArr) {
        O(4, (Throwable) null, str, objArr);
    }

    public static boolean I(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    public static boolean J(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean K(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean L() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean M(e.a.a.j0.c cVar) {
        if (cVar != null) {
            return cVar.c("http.connection.stalecheck", true);
        }
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static boolean N(char c2) {
        return c2 == ' ' || c2 == 9 || c2 == 13 || c2 == 10;
    }

    public static void O(int i, Throwable th, String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (th != null) {
            if (str == null) {
                str = th.getMessage();
            }
            str = String.format("%1$s\n%2$s", new Object[]{str, Log.getStackTraceString(th)});
        }
        String str2 = d.f;
        Log.println(i, d.f, str);
    }

    public static String P(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length << 1);
            for (int i = 0; i < length; i++) {
                sb.append(Character.forDigit((digest[i] & 240) >> 4, 16));
                sb.append(Character.forDigit(digest[i] & 15, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String Q(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        return i > 1 ? str.substring(i - 1) : str;
    }

    public static String R(String str) {
        int i;
        if (str.equals("1")) {
            i = R.string.TR_ESPECIALIST_PEDIATRICIAN;
        } else if (str.equals("2")) {
            i = R.string.TR_ESPECIALIST_OPHTHALMOLOGIST;
        } else if (str.equals(OO000o0.O00000o)) {
            i = R.string.TR_ESPECIALIST_OTOLARYNGOLOGIST;
        } else if (str.equals(OO000o0.O00000o0)) {
            i = R.string.TR_ESPECIALIST_ORTHO_TRAUMATOLOGY;
        } else if (str.equals("5")) {
            i = R.string.TR_ESPECIALIST_DERMATOLOGIST;
        } else if (!str.equals("6")) {
            return "";
        } else {
            i = R.string.TR_ESPECIALIST_NEUROLOGIST;
        }
        return a.h(i);
    }

    public static Bebe[] S(String str) {
        Bebe[] bebeArr;
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        Bebe bebe;
        int i2;
        JSONArray jSONArray;
        String str2 = str;
        Bebe[] bebeArr2 = null;
        if (str2 == null || str.length() <= 0 || str.length() == 0) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray(str2);
            Bebe[] bebeArr3 = new Bebe[jSONArray2.length()];
            int i3 = 0;
            int i4 = 0;
            while (i3 < jSONArray2.length()) {
                try {
                    JSONObject jSONObject = jSONArray2.getJSONObject(i3);
                    i = jSONObject.getInt("idBebe");
                    string = jSONObject.getString("nombre");
                    string2 = jSONObject.getString("apellidos");
                    string3 = jSONObject.getString("fechanacimiento");
                    string4 = jSONObject.getString("sexo");
                    string5 = jSONObject.getString("altura");
                    string6 = jSONObject.getString("peso");
                    string7 = jSONObject.getString("medidacabeza");
                    string8 = jSONObject.getString("colorojos");
                    string9 = jSONObject.getString("pelo");
                    string10 = jSONObject.getString("piel");
                    string11 = jSONObject.getString("hospital");
                    string12 = jSONObject.getString("ginecologo");
                    string13 = jSONObject.getString("matron");
                    string14 = jSONObject.getString("foto");
                    i2 = i3;
                    bebeArr = bebeArr3;
                    jSONArray = jSONArray2;
                } catch (JSONException e2) {
                    e = e2;
                    bebeArr = bebeArr3;
                    bebeArr2 = bebeArr;
                    StringBuilder n = a.a.a.a.a.n("Ex: ");
                    n.append(e.toString());
                    j("parsejson", n.toString());
                    return bebeArr2;
                }
                try {
                    bebe = new Bebe(i, string, string2, string3, string4, string5, string6, string7, string8, string9, string10, "", "", "", "", "", string11, string12, string13, string14);
                    bebeArr[i4] = bebe;
                    i4++;
                    i3 = i2 + 1;
                    bebeArr3 = bebeArr;
                    jSONArray2 = jSONArray;
                } catch (JSONException e3) {
                    e = e3;
                    bebeArr2 = bebeArr;
                    StringBuilder n2 = a.a.a.a.a.n("Ex: ");
                    n2.append(e.toString());
                    j("parsejson", n2.toString());
                    return bebeArr2;
                }
            }
            return bebeArr3;
        } catch (JSONException e4) {
            e = e4;
            StringBuilder n22 = a.a.a.a.a.n("Ex: ");
            n22.append(e.toString());
            j("parsejson", n22.toString());
            return bebeArr2;
        }
    }

    public static Familia[] T(String str) {
        Familia[] familiaArr = null;
        if (str != null && str.length() > 0) {
            if (str.length() == 0) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                familiaArr = new Familia[jSONArray.length()];
                int i = 0;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    familiaArr[i] = new Familia(jSONArray.getJSONObject(i2));
                    i++;
                }
            } catch (JSONException e2) {
                StringBuilder n = a.a.a.a.a.n("Ex: ");
                n.append(e2.toString());
                j("parsejson", n.toString());
            }
        }
        return familiaArr;
    }

    public static Usuario U(JSONObject jSONObject, String str, String str2) {
        Usuario usuario = null;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("cam");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            new a.h.a.n0.a(AppMiniland.f().getApplicationContext()).d(arrayList);
            Usuario usuario2 = new Usuario(jSONObject);
            try {
                a.c.d.a l = a.c.d.a.l();
                if (l != null) {
                    JSONObject originalJson = usuario2.getOriginalJson();
                    if (originalJson == null) {
                        SharedPreferences.Editor edit = l.f6a.edit();
                        edit.remove("KEY_USER_JSON");
                        edit.commit();
                    } else {
                        String jSONObject2 = originalJson.toString();
                        SharedPreferences.Editor edit2 = l.f6a.edit();
                        edit2.putString("KEY_USER_JSON", jSONObject2);
                        edit2.commit();
                    }
                    a.c.d.a.l().i("KEY_USER_PASSWORD", str2);
                    if (str == null) {
                        return usuario2;
                    }
                    a.c.d.a.l().i("KEY_USER_USERNAME", str);
                    return usuario2;
                }
                throw null;
            } catch (JSONException e2) {
                e = e2;
                usuario = usuario2;
                StringBuilder n = a.a.a.a.a.n("Ex: ");
                n.append(e.toString());
                j("parsejson", n.toString());
                return usuario;
            }
        } catch (JSONException e3) {
            e = e3;
            StringBuilder n2 = a.a.a.a.a.n("Ex: ");
            n2.append(e.toString());
            j("parsejson", n2.toString());
            return usuario;
        }
    }

    public static String V(Object obj) {
        StringBuilder n = a.a.a.a.a.n("'");
        n.append(String.valueOf(obj));
        n.append("'");
        return n.toString();
    }

    public static URI W(URI uri, URI uri2) {
        String uri3 = uri2.toString();
        if (uri3.startsWith("?")) {
            String uri4 = uri.toString();
            if (uri4.indexOf(63) > -1) {
                uri4 = uri4.substring(0, uri4.indexOf(63));
            }
            StringBuilder n = a.a.a.a.a.n(uri4);
            n.append(uri2.toString());
            return URI.create(n.toString());
        }
        boolean z = uri3.length() == 0;
        if (z) {
            uri2 = URI.create("#");
        }
        URI resolve = uri.resolve(uri2);
        if (z) {
            String uri5 = resolve.toString();
            resolve = URI.create(uri5.substring(0, uri5.indexOf(35)));
        }
        String path = resolve.getPath();
        if (path == null || path.indexOf("/.") == -1) {
            return resolve;
        }
        String[] split = path.split("/");
        Stack stack = new Stack();
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() != 0 && !".".equals(split[i])) {
                if (!"..".equals(split[i])) {
                    stack.push(split[i]);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            sb.append('/');
            sb.append((String) it.next());
        }
        try {
            return new URI(resolve.getScheme(), resolve.getAuthority(), sb.toString(), resolve.getQuery(), resolve.getFragment());
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static byte[] X(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        while (true) {
            length--;
            if (length < 0) {
                return bArr2;
            }
            bArr2[length] = bArr[i];
            i++;
        }
    }

    public static URI Y(URI uri, j jVar, boolean z) {
        if (uri != null) {
            String str = null;
            if (jVar != null) {
                String str2 = jVar.f5173d;
                String str3 = jVar.f5170a;
                int i = jVar.f5172c;
                String Q = Q(uri.getRawPath());
                String rawQuery = uri.getRawQuery();
                if (!z) {
                    str = uri.getRawFragment();
                }
                return i(str2, str3, i, Q, rawQuery, str);
            }
            String Q2 = Q(uri.getRawPath());
            String rawQuery2 = uri.getRawQuery();
            if (!z) {
                str = uri.getRawFragment();
            }
            return i((String) null, (String) null, -1, Q2, rawQuery2, str);
        }
        throw new IllegalArgumentException("URI may not be null");
    }

    public static void Z(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                View view = adapter.getView(i2, (View) null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = ((adapter.getCount() - 1) * listView.getDividerHeight()) + i + 20;
            listView.setLayoutParams(layoutParams);
        }
    }

    public static short a(short s) {
        return (short) (((s >> 8) & 255) | ((s & 255) << 8));
    }

    public static String[] a0(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        } else if (str2.length() > 0) {
            if (str.startsWith(str2)) {
                str = str.substring(str2.length());
            }
            if (!str.endsWith(str2)) {
                str = a.a.a.a.a.k(str, str2);
            }
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int indexOf = str.indexOf(str2, i2);
                if (indexOf == -1) {
                    break;
                }
                i3++;
                i2 = indexOf + str2.length();
            }
            String[] strArr = new String[i3];
            int i4 = 0;
            while (true) {
                int indexOf2 = str.indexOf(str2, i);
                if (indexOf2 == -1) {
                    return strArr;
                }
                strArr[i4] = str.substring(i, indexOf2);
                i = str2.length() + indexOf2;
                i4++;
            }
        } else {
            throw new IllegalArgumentException("Delimeter cannot be null or empty.");
        }
    }

    public static int b(int i) {
        return ((i >> 24) & 255) | ((i & 255) << 24) | (((i >> 8) & 255) << 16) | (((i >> 16) & 255) << 8);
    }

    public static boolean b0(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        try {
            return X(l(bArr, bArr2));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvalidKeyException e5) {
            e5.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e6) {
            e6.printStackTrace();
            return null;
        } catch (BadPaddingException e7) {
            e7.printStackTrace();
            return null;
        } catch (NoSuchProviderException e8) {
            e8.printStackTrace();
            return null;
        }
    }

    public static String c0(g gVar) {
        return d0(gVar, (String) null);
    }

    public static Object d(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Cloneable) {
            try {
                try {
                    return obj.getClass().getMethod("clone", (Class[]) null).invoke(obj, (Object[]) null);
                } catch (InvocationTargetException e2) {
                    Throwable cause = e2.getCause();
                    if (cause instanceof CloneNotSupportedException) {
                        throw ((CloneNotSupportedException) cause);
                    }
                    throw new Error("Unexpected exception", cause);
                } catch (IllegalAccessException e3) {
                    throw new IllegalAccessError(e3.getMessage());
                }
            } catch (NoSuchMethodException e4) {
                throw new NoSuchMethodError(e4.getMessage());
            }
        } else {
            throw new CloneNotSupportedException();
        }
    }

    public static String d0(g gVar, String str) {
        s b2;
        if (gVar != null) {
            InputStream content = gVar.getContent();
            String str2 = null;
            if (content == null) {
                return null;
            }
            try {
                if (gVar.getContentLength() <= 2147483647L) {
                    int contentLength = (int) gVar.getContentLength();
                    if (contentLength < 0) {
                        contentLength = 4096;
                    }
                    if (gVar.getContentType() != null) {
                        e.a.a.d[] c2 = gVar.getContentType().c();
                        if (c2.length > 0 && (b2 = c2[0].b("charset")) != null) {
                            str2 = b2.getValue();
                        }
                    }
                    if (str2 != null) {
                        str = str2;
                    }
                    if (str == null) {
                        str = "ISO-8859-1";
                    }
                    InputStreamReader inputStreamReader = new InputStreamReader(content, str);
                    e.a.a.l0.b bVar = new e.a.a.l0.b(contentLength);
                    char[] cArr = new char[1024];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read == -1) {
                            return bVar.toString();
                        }
                        bVar.d(cArr, 0, read);
                    }
                } else {
                    throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
                }
            } finally {
                content.close();
            }
        } else {
            throw new IllegalArgumentException("HTTP entity may not be null");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.lang.Comparable<T>> int e(T r0, T r1, b.a.e r2) {
        /*
            if (r0 == 0) goto L_0x0009
            if (r1 == 0) goto L_0x0009
            int r0 = r0.compareTo(r1)
            goto L_0x0021
        L_0x0009:
            if (r0 != 0) goto L_0x000e
            if (r1 != 0) goto L_0x000e
            goto L_0x001a
        L_0x000e:
            if (r0 != 0) goto L_0x0014
            if (r1 == 0) goto L_0x0014
            r0 = -1
            goto L_0x001b
        L_0x0014:
            if (r0 == 0) goto L_0x001a
            if (r1 != 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            b.a.e r1 = b.a.e.LAST
            if (r1 != r2) goto L_0x0021
            int r0 = r0 * -1
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.a.r.b.e(java.lang.Comparable, java.lang.Comparable, b.a.e):int");
    }

    public static void e0(String str, boolean z) {
        int i;
        try {
            int length = str.getBytes("UTF-8").length;
            boolean z2 = false;
            if (length < 1 || length > 65535) {
                throw new IllegalArgumentException(String.format("Invalid topic length, should be in range[%d, %d]!", new Object[]{new Integer(1), new Integer(65535)}));
            } else if (z) {
                String[] strArr = {"#", BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX};
                boolean z3 = false;
                for (int i2 = 0; i2 < 2; i2++) {
                    z3 = z3 || strArr[i2].equals(str);
                }
                if (!z3) {
                    if (K(str) || K("#")) {
                        i = 0;
                    } else {
                        int i3 = 0;
                        i = 0;
                        while (true) {
                            int indexOf = str.toString().indexOf("#".toString(), i3);
                            if (indexOf == -1) {
                                break;
                            }
                            i++;
                            i3 = indexOf + "#".length();
                        }
                    }
                    if (i > 1 || (str.contains("#") && !str.endsWith("/#"))) {
                        throw new IllegalArgumentException("Invalid usage of multi-level wildcard in topic string: " + str);
                    }
                    char charAt = BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX.charAt(0);
                    char charAt2 = "/".charAt(0);
                    char[] charArray = str.toCharArray();
                    int length2 = charArray.length;
                    int i4 = 0;
                    while (i4 < length2) {
                        int i5 = i4 - 1;
                        char c2 = i5 >= 0 ? charArray[i5] : 0;
                        int i6 = i4 + 1;
                        char c3 = i6 < length2 ? charArray[i6] : 0;
                        if (charArray[i4] != charAt || ((c2 == charAt2 || c2 == 0) && (c3 == charAt2 || c3 == 0))) {
                            i4 = i6;
                        } else {
                            throw new IllegalArgumentException(String.format("Invalid usage of single-level wildcard in topic string '%s'!", new Object[]{str}));
                        }
                    }
                }
            } else {
                char[] charArray2 = "#+".toCharArray();
                if (!K(str)) {
                    if (!(charArray2 == null || charArray2.length == 0)) {
                        int length3 = str.length();
                        int length4 = charArray2.length;
                        int i7 = length3 - 1;
                        int i8 = length4 - 1;
                        int i9 = 0;
                        loop3:
                        while (true) {
                            if (i9 >= length3) {
                                break;
                            }
                            char charAt3 = str.charAt(i9);
                            int i10 = 0;
                            while (i10 < length4) {
                                if (charArray2[i10] != charAt3 || (Character.isHighSurrogate(charAt3) && i10 != i8 && (i9 >= i7 || charArray2[i10 + 1] != str.charAt(i9 + 1)))) {
                                    i10++;
                                }
                            }
                            i9++;
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    throw new IllegalArgumentException("The topic name MUST NOT contain any wildcard characters (#+)");
                }
            }
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(e2.getMessage());
        }
    }

    public static void f(g gVar) {
        InputStream content;
        if (gVar != null && gVar.isStreaming() && (content = gVar.getContent()) != null) {
            content.close();
        }
    }

    public static void f0(String str, Object... objArr) {
        O(5, (Throwable) null, str, objArr);
    }

    public static n g(int i) {
        return (i == 4 || i == 5) ? new e.b.a.a.a.s(i) : new n(i);
    }

    public static n h(Throwable th) {
        return th.getClass().getName().equals("java.security.GeneralSecurityException") ? new e.b.a.a.a.s(th) : new n(th);
    }

    public static URI i(String str, String str2, int i, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i > 0) {
                sb.append(':');
                sb.append(i);
            }
        }
        if (str3 == null || !str3.startsWith("/")) {
            sb.append('/');
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return new URI(sb.toString());
    }

    public static void j(String str, String str2) {
        Log.d("MINILAND_EBABY", "metodo: " + str + " - " + str2);
    }

    public static void k(Throwable th) {
        O(6, th, (String) null, new Object[0]);
    }

    public static byte[] l(byte[] bArr, byte[] bArr2) {
        byte[] O000000o = o00oo0o00o.O000000o(bArr);
        byte[] O000000o2 = o00oo0o00o.O000000o(bArr2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(O000000o, EncryptionManager.O0000ooO);
        Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
        instance.init(1, secretKeySpec);
        return instance.doFinal(O000000o2);
    }

    public static boolean m(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean n(Object[] objArr, Object[] objArr2) {
        if (objArr == null) {
            return objArr2 == null;
        }
        if (objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            if (!m(objArr[i], objArr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static String o(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    public static String p(List<? extends s> list, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        for (s sVar : list) {
            String str3 = "ISO-8859-1";
            try {
                String encode = URLEncoder.encode(sVar.getName(), str != null ? str : str3);
                String value = sVar.getValue();
                if (value != null) {
                    if (str != null) {
                        str3 = str;
                    }
                    try {
                        str2 = URLEncoder.encode(value, str3);
                    } catch (UnsupportedEncodingException e2) {
                        throw new IllegalArgumentException(e2);
                    }
                } else {
                    str2 = "";
                }
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(encode);
                sb.append(o0ooo00oo.O0000Oo0);
                sb.append(str2);
            } catch (UnsupportedEncodingException e3) {
                throw new IllegalArgumentException(e3);
            }
        }
        return sb.toString();
    }

    public static String q(String str, e eVar) {
        return String.format("%1$s_%2$dx%3$d", new Object[]{str, Integer.valueOf(eVar.f3422a), Integer.valueOf(eVar.f3423b)});
    }

    public static byte[] r(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("data may not be null");
        } else if (str2.length() != 0) {
            try {
                return str.getBytes(str2);
            } catch (UnsupportedEncodingException unused) {
                return str.getBytes();
            }
        } else {
            throw new IllegalArgumentException("charset may not be null or empty");
        }
    }

    public static File s(Context context) {
        File file = null;
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file2 = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
            if (!file2.exists()) {
                if (!file2.mkdirs()) {
                    f0("Unable to create external cache directory", new Object[0]);
                } else {
                    try {
                        new File(file2, ".nomedia").createNewFile();
                    } catch (IOException unused) {
                        H("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
                    }
                }
            }
            file = file2;
        }
        return file == null ? context.getCacheDir() : file;
    }

    public static String t(e.a.a.j0.c cVar) {
        if (cVar != null) {
            String str = (String) cVar.e("http.auth.credential-charset");
            return str == null ? "US-ASCII" : str;
        }
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static String u(String str) {
        String str2;
        StringBuilder sb;
        try {
            o g = ((e.a.a.g0.g.g) a.c.a.f.d.a()).g(new e.a.a.c0.k.c(str));
            Log.d("MINILAND_EBABY", "Status code: " + ((m) g.s()).f5157b);
            return c0(g.b());
        } catch (e.a.a.c0.d e2) {
            e = e2;
            sb = new StringBuilder();
            str2 = "Error ClientProtocolException: ";
            sb.append(str2);
            sb.append(e.toString());
            Log.d("MINILAND_EBABY", sb.toString());
            return "";
        } catch (IOException e3) {
            e = e3;
            sb = new StringBuilder();
            str2 = "Error IOException: ";
            sb.append(str2);
            sb.append(e.toString());
            Log.d("MINILAND_EBABY", sb.toString());
            return "";
        }
    }

    public static String v(String str, String str2) {
        return u("https://emybaby.com/api/" + str2 + str);
    }

    public static String w(String str, String str2) {
        StringBuilder sb;
        String str3;
        try {
            o g = ((e.a.a.g0.g.g) a.c.a.f.d.a()).g(new e.a.a.c0.k.c(a.a.a.a.a.l("https://emybaby.com/api/", str2, str)));
            Log.d("MINILAND_EBABY", "Status code: " + ((m) g.s()).f5157b);
            return c0(g.b());
        } catch (e.a.a.c0.d e2) {
            e = e2;
            sb = new StringBuilder();
            str3 = "Error ClientProtocolException: ";
            sb.append(str3);
            sb.append(e.toString());
            Log.d("MINILAND_EBABY", sb.toString());
            return "";
        } catch (IOException e3) {
            e = e3;
            sb = new StringBuilder();
            str3 = "Error IOException: ";
            sb.append(str3);
            sb.append(e.toString());
            Log.d("MINILAND_EBABY", sb.toString());
            return "";
        }
    }

    public static String x(List<s> list, String str) {
        e.a.a.c0.g a2 = a.c.a.f.d.a();
        e.a.a.c0.k.e eVar = new e.a.a.c0.k.e(a.a.a.a.a.k("https://emybaby.com/api/", str));
        try {
            eVar.f = new e.a.a.c0.j.a(list, "UTF-8");
            o g = ((e.a.a.g0.g.g) a2).g(eVar);
            Log.d("MINILAND_EBABY", "Status code: " + ((m) g.s()).f5157b);
            return c0(g.b());
        } catch (e.a.a.c0.d | IOException unused) {
            return "";
        }
    }

    public static String y(e.a.a.j0.c cVar) {
        String str = (String) cVar.e("http.protocol.element-charset");
        return str == null ? "US-ASCII" : str;
    }

    public static File z(Context context) {
        File s = s(context);
        File file = new File(s, "uil-images");
        return (file.exists() || file.mkdir()) ? file : s;
    }
}
