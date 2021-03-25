package a.d.a.a.h.g;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class y7 extends z7<FieldDescriptorType, Object> {
    public y7(int i) {
        super(i, (y7) null);
    }

    public final void d() {
        if (!this.f2060d) {
            for (int i = 0; i < g(); i++) {
                Map.Entry f = f(i);
                if (((t5) f.getKey()).d()) {
                    f.setValue(Collections.unmodifiableList((List) f.getValue()));
                }
            }
            for (Map.Entry entry : i()) {
                if (((t5) entry.getKey()).d()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.d();
    }
}
