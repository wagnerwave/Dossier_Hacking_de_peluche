package c.a.b.g;

import android.content.Context;
import android.database.DataSetObserver;
import java.util.List;
import kankan.wheel.widget.WheelView;

public class b extends a implements c.a.b.b {
    public int m;
    public int n;
    public String o;

    public b(Context context, int i, int i2, String str) {
        super(context);
        this.m = i;
        this.n = i2;
        this.o = str;
    }

    public void a(WheelView wheelView, int i, int i2) {
        this.k = i2;
        List<DataSetObserver> list = this.f3770a;
        if (list != null) {
            for (DataSetObserver onChanged : list) {
                onChanged.onChanged();
            }
        }
    }

    public int d() {
        return (this.n - this.m) + 1;
    }
}
