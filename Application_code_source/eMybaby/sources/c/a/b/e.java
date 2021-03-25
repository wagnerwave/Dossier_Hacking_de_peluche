package c.a.b;

import android.view.View;
import android.widget.LinearLayout;
import c.a.b.g.b;
import java.util.LinkedList;
import java.util.List;
import kankan.wheel.widget.WheelView;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public List<View> f3760a;

    /* renamed from: b  reason: collision with root package name */
    public List<View> f3761b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f3762c;

    public e(WheelView wheelView) {
        this.f3762c = wheelView;
    }

    public final View a(List<View> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        View view = list.get(0);
        list.remove(0);
        return view;
    }

    public int b(LinearLayout linearLayout, int i, a aVar) {
        int i2 = i;
        int i3 = 0;
        while (i3 < linearLayout.getChildCount()) {
            int i4 = aVar.f3758a;
            if (!(i2 >= i4 && i2 <= (i4 + aVar.f3759b) + -1)) {
                View childAt = linearLayout.getChildAt(i3);
                int d2 = ((b) this.f3762c.getViewAdapter()).d();
                if ((i2 < 0 || i2 >= d2) && !this.f3762c.k) {
                    List<View> list = this.f3761b;
                    if (list == null) {
                        list = new LinkedList<>();
                    }
                    list.add(childAt);
                    this.f3761b = list;
                } else {
                    int i5 = i2;
                    while (i5 < 0) {
                        i5 += d2;
                    }
                    int i6 = i5 % d2;
                    List<View> list2 = this.f3760a;
                    if (list2 == null) {
                        list2 = new LinkedList<>();
                    }
                    list2.add(childAt);
                    this.f3760a = list2;
                }
                linearLayout.removeViewAt(i3);
                if (i3 == 0) {
                    i++;
                }
            } else {
                i3++;
            }
            i2++;
        }
        return i;
    }
}
