package e.a.a.l0;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f5187a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5188b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5189c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5190d;

    /* renamed from: e  reason: collision with root package name */
    public final String f5191e;

    public d(String str, String str2, String str3, String str4, String str5) {
        this.f5187a = str;
        this.f5188b = str2 == null ? "UNAVAILABLE" : str2;
        this.f5189c = str3 == null ? "UNAVAILABLE" : str3;
        this.f5190d = str4 == null ? "UNAVAILABLE" : str4;
        this.f5191e = str5 == null ? "UNAVAILABLE" : str5;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.f5191e.length() + this.f5190d.length() + this.f5189c.length() + this.f5188b.length() + this.f5187a.length() + 20);
        stringBuffer.append("VersionInfo(");
        stringBuffer.append(this.f5187a);
        stringBuffer.append(':');
        stringBuffer.append(this.f5188b);
        if (!"UNAVAILABLE".equals(this.f5189c)) {
            stringBuffer.append(':');
            stringBuffer.append(this.f5189c);
        }
        if (!"UNAVAILABLE".equals(this.f5190d)) {
            stringBuffer.append(':');
            stringBuffer.append(this.f5190d);
        }
        stringBuffer.append(')');
        if (!"UNAVAILABLE".equals(this.f5191e)) {
            stringBuffer.append('@');
            stringBuffer.append(this.f5191e);
        }
        return stringBuffer.toString();
    }
}
