package a.d.b.i;

import androidx.annotation.NonNull;

public interface c {

    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f2783a;

        /* access modifiers changed from: public */
        a(int i) {
            this.f2783a = i;
        }
    }

    @NonNull
    a a(@NonNull String str);
}
