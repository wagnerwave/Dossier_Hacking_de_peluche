package e.a.a.g0.i;

import a.a.a.a.a;
import e.a.a.e0.b;
import e.a.a.e0.e;
import e.a.a.e0.g;
import java.util.Locale;
import java.util.StringTokenizer;

public class s extends e {
    public void a(b bVar, e eVar) {
        super.a(bVar, eVar);
        String str = eVar.f4897a;
        String h = bVar.h();
        if (str.contains(".")) {
            int countTokens = new StringTokenizer(h, ".").countTokens();
            String upperCase = h.toUpperCase(Locale.ENGLISH);
            if (upperCase.endsWith(".COM") || upperCase.endsWith(".EDU") || upperCase.endsWith(".NET") || upperCase.endsWith(".GOV") || upperCase.endsWith(".MIL") || upperCase.endsWith(".ORG") || upperCase.endsWith(".INT")) {
                if (countTokens < 2) {
                    throw new g("Domain attribute \"" + h + "\" violates the Netscape cookie specification for " + "special domains");
                }
            } else if (countTokens < 3) {
                throw new g(a.l("Domain attribute \"", h, "\" violates the Netscape cookie specification"));
            }
        }
    }

    public boolean b(b bVar, e eVar) {
        String str = eVar.f4897a;
        String h = bVar.h();
        if (h == null) {
            return false;
        }
        return str.endsWith(h);
    }
}
