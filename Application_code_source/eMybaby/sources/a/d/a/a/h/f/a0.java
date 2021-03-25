package a.d.a.a.h.f;

import a.d.a.a.h.f.m0;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.tuya.smart.android.device.bean.StringSchemaBean;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

public class a0<T extends m0> extends e {

    /* renamed from: b  reason: collision with root package name */
    public l0<T> f1469b;

    public a0(h hVar, l0<T> l0Var) {
        super(hVar);
        this.f1469b = l0Var;
    }

    public final T r(XmlResourceParser xmlResourceParser) {
        int eventType;
        String trim;
        String str;
        try {
            xmlResourceParser.next();
            eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim2)) {
                            if (this.f1469b == null) {
                                throw null;
                            }
                        }
                    } else if (lowerCase.equals(StringSchemaBean.type)) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim3 != null) {
                            this.f1469b.c(attributeValue2, trim3);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue((String) null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim)) {
                            try {
                                this.f1469b.a(attributeValue3, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e2) {
                                e = e2;
                                str = "Error parsing bool configuration value";
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue((String) null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim)) {
                            try {
                                this.f1469b.b(attributeValue4, Integer.parseInt(trim));
                            } catch (NumberFormatException e3) {
                                e = e3;
                                str = "Error parsing int configuration value";
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException | XmlPullParserException e4) {
            n("Error parsing tracker configuration file", e4);
        }
        return this.f1469b.f1527b;
        f(str, trim, e);
        eventType = xmlResourceParser.next();
    }
}
