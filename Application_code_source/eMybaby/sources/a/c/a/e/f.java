package a.c.a.e;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class f {

    /* renamed from: b  reason: collision with root package name */
    public static f f30b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f31a = new ArrayList<>();

    public f() {
        f30b = this;
    }

    public static final f c() {
        if (f30b == null) {
            f30b = new f();
        }
        return f30b;
    }

    public void a(a aVar) {
        this.f31a.add(aVar);
    }

    public void b(InputStream inputStream) {
        e eVar = new e();
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        try {
            XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            xMLReader.setContentHandler(eVar);
            xMLReader.parse(new InputSource(inputStream));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d(String str, String str2, String str3) {
        Iterator<a> it = this.f31a.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2, str3, (Long) null);
        }
    }

    public void e(String str) {
        Iterator<a> it = this.f31a.iterator();
        while (it.hasNext()) {
            it.next().b(str, (String) null);
        }
    }
}
