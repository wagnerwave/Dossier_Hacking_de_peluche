package e.a.a.f0.g.h;

public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f4931a;

    public a(String str) {
        if (str != null) {
            this.f4931a = str;
            int indexOf = str.indexOf(47);
            if (indexOf != -1) {
                str.substring(0, indexOf);
                str.substring(indexOf + 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("MIME type may not be null");
    }
}
