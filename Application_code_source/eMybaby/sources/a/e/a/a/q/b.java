package a.e.a.a.q;

import a.e.a.a.q.i.a;
import android.os.Bundle;
import com.inuker.bluetooth.library.search.SearchResult;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.e.a.a.o.j.b f3276a;

    public b(a.e.a.a.o.j.b bVar) {
        this.f3276a = bVar;
    }

    public void onDeviceFounded(SearchResult searchResult) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra.search.result", searchResult);
        this.f3276a.onResponse(4, bundle);
    }

    public void onSearchCanceled() {
        this.f3276a.onResponse(3, null);
    }

    public void onSearchStarted() {
        this.f3276a.onResponse(1, null);
    }

    public void onSearchStopped() {
        this.f3276a.onResponse(2, null);
    }
}
