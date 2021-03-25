package a.d.a.a.e.k;

import com.google.android.gms.common.Feature;

public final class k extends UnsupportedOperationException {

    /* renamed from: a  reason: collision with root package name */
    public final Feature f1264a;

    public k(Feature feature) {
        this.f1264a = feature;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.f1264a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
