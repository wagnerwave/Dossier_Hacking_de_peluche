package a.c.d.j.b.d;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tuya.smart.android.common.utils.NetworkUtil;

public class b implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f174a;

    public b(e eVar) {
        this.f174a = eVar;
    }

    public void onRefresh() {
        if (NetworkUtil.isNetworkAvailable(this.f174a.getContext())) {
            this.f174a.f178b.c();
        } else {
            this.f174a.o();
        }
    }
}
