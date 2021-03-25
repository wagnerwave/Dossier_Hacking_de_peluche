package e.a.a.g0.i;

import e.a.a.e0.a;
import e.a.a.e0.b;
import e.a.a.e0.c;
import e.a.a.e0.e;
import e.a.a.e0.g;
import e.a.a.e0.k;
import e.a.a.e0.m;
import java.util.Locale;

public class c0 implements c {
    public void a(b bVar, e eVar) {
        String lowerCase = eVar.f4897a.toLowerCase(Locale.ENGLISH);
        if (bVar.h() != null) {
            String lowerCase2 = bVar.h().toLowerCase(Locale.ENGLISH);
            if (!(bVar instanceof a) || !((a) bVar).e("domain")) {
                if (!bVar.h().equals(lowerCase)) {
                    StringBuilder n = a.a.a.a.a.n("Illegal domain attribute: \"");
                    n.append(bVar.h());
                    n.append("\".");
                    n.append("Domain of origin: \"");
                    n.append(lowerCase);
                    n.append("\"");
                    throw new g(n.toString());
                }
            } else if (lowerCase2.startsWith(".")) {
                int indexOf = lowerCase2.indexOf(46, 1);
                if ((indexOf < 0 || indexOf == lowerCase2.length() - 1) && !lowerCase2.equals(".local")) {
                    StringBuilder n2 = a.a.a.a.a.n("Domain attribute \"");
                    n2.append(bVar.h());
                    n2.append("\" violates RFC 2965: the value contains no embedded dots ");
                    n2.append("and the value is not .local");
                    throw new g(n2.toString());
                } else if (!d(lowerCase, lowerCase2)) {
                    StringBuilder n3 = a.a.a.a.a.n("Domain attribute \"");
                    n3.append(bVar.h());
                    n3.append("\" violates RFC 2965: effective host name does not ");
                    n3.append("domain-match domain attribute.");
                    throw new g(n3.toString());
                } else if (lowerCase.substring(0, lowerCase.length() - lowerCase2.length()).indexOf(46) != -1) {
                    StringBuilder n4 = a.a.a.a.a.n("Domain attribute \"");
                    n4.append(bVar.h());
                    n4.append("\" violates RFC 2965: ");
                    n4.append("effective host minus domain may not contain any dots");
                    throw new g(n4.toString());
                }
            } else {
                StringBuilder n5 = a.a.a.a.a.n("Domain attribute \"");
                n5.append(bVar.h());
                n5.append("\" violates RFC 2109: domain must start with a dot");
                throw new g(n5.toString());
            }
        } else {
            throw new g("Invalid cookie state: domain not specified");
        }
    }

    public boolean b(b bVar, e eVar) {
        String lowerCase = eVar.f4897a.toLowerCase(Locale.ENGLISH);
        String h = bVar.h();
        return d(lowerCase, h) && lowerCase.substring(0, lowerCase.length() - h.length()).indexOf(46) == -1;
    }

    public void c(m mVar, String str) {
        if (str == null) {
            throw new k("Missing value for domain attribute");
        } else if (str.trim().length() != 0) {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (!lowerCase.startsWith(".")) {
                lowerCase = '.' + lowerCase;
            }
            ((c) mVar).m(lowerCase);
        } else {
            throw new k("Blank value for domain attribute");
        }
    }

    public boolean d(String str, String str2) {
        return str.equals(str2) || (str2.startsWith(".") && str.endsWith(str2));
    }
}
