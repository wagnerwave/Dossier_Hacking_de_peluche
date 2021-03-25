package a.c.a.e;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class e extends DefaultHandler {

    /* renamed from: a  reason: collision with root package name */
    public StringBuilder f25a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    public int f26b;

    /* renamed from: c  reason: collision with root package name */
    public d f27c;

    /* renamed from: d  reason: collision with root package name */
    public b f28d;

    /* renamed from: e  reason: collision with root package name */
    public c f29e;
    public g f;

    public void characters(char[] cArr, int i, int i2) {
        this.f25a.append(new String(cArr, i, i2).trim());
    }

    public void endDocument() {
    }

    public void endElement(String str, String str2, String str3) {
        String sb = this.f25a.toString();
        if (str3.equals("ga-code")) {
            if (this.f27c == null) {
                throw null;
            }
        } else if (str3.equals("frequency")) {
            d dVar = this.f27c;
            Integer.parseInt(sb);
            if (dVar == null) {
                throw null;
            }
        } else if (str3.equals("social-network")) {
            this.f27c.f23c.add(sb);
        } else if (str3.equals(NotificationCompat.CATEGORY_EVENT)) {
            this.f29e = null;
        } else if (str3.equals("screen")) {
            this.f = null;
        }
        this.f26b--;
        this.f25a.setLength(0);
    }

    public void startDocument() {
        this.f26b = 0;
        this.f27c = new d();
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        ArrayList arrayList;
        Object value;
        this.f26b++;
        if (str3.equals("category")) {
            b bVar = new b();
            this.f28d = bVar;
            attributes.getValue("code");
            if (bVar != null) {
                arrayList = this.f27c.f21a;
                value = this.f28d;
            } else {
                throw null;
            }
        } else if (str3.equals(NotificationCompat.CATEGORY_EVENT)) {
            c cVar = new c();
            this.f29e = cVar;
            attributes.getValue("code");
            if (cVar != null) {
                b bVar2 = this.f28d;
                c cVar2 = this.f29e;
                bVar2.f20a.add(cVar2);
                if (cVar2 == null) {
                    throw null;
                }
                return;
            }
            throw null;
        } else if (str3.equals("screen")) {
            g gVar = new g();
            this.f = gVar;
            attributes.getValue("code");
            if (gVar != null) {
                arrayList = this.f27c.f22b;
                value = this.f;
            } else {
                throw null;
            }
        } else if (str3.equals("android-activity")) {
            c cVar3 = this.f29e;
            if (cVar3 != null) {
                attributes.getValue("name");
                if (cVar3 == null) {
                    throw null;
                }
                return;
            }
            g gVar2 = this.f;
            if (gVar2 != null) {
                attributes.getValue("name");
                if (gVar2 == null) {
                    throw null;
                }
                return;
            }
            return;
        } else if (str3.equals("action")) {
            arrayList = this.f27c.f24d;
            value = attributes.getValue("code");
        } else {
            return;
        }
        arrayList.add(value);
    }
}
