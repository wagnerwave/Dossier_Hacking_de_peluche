package e.b.a.a.a.x;

import e.b.a.a.a.v.c;
import java.util.Enumeration;
import java.util.Properties;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5356a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f5357b = System.getProperty("line.separator", "\n");

    static {
        String name = e.b.a.a.a.u.a.class.getName();
        f5356a = name;
        c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public static String a(Properties properties, String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> propertyNames = properties.propertyNames();
        StringBuilder sb = new StringBuilder(String.valueOf(f5357b));
        sb.append("==============");
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append("==============");
        while (true) {
            sb.append(f5357b);
            stringBuffer.append(sb.toString());
            if (!propertyNames.hasMoreElements()) {
                stringBuffer.append("==========================================" + f5357b);
                return stringBuffer.toString();
            }
            String str3 = (String) propertyNames.nextElement();
            if (str3.length() >= 28) {
                str2 = str3;
            } else {
                StringBuffer stringBuffer2 = new StringBuffer(28);
                stringBuffer2.append(str3);
                int length = 28 - str3.length();
                while (true) {
                    length--;
                    if (length < 0) {
                        break;
                    }
                    stringBuffer2.append(' ');
                }
                str2 = stringBuffer2.toString();
            }
            sb = new StringBuilder(String.valueOf(str2));
            sb.append(":  ");
            sb.append(properties.get(str3));
        }
    }
}
