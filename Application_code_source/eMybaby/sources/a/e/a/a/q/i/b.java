package a.e.a.a.q.i;

import com.inuker.bluetooth.library.search.SearchResult;

public interface b {
    void onDeviceFounded(SearchResult searchResult);

    void onSearchCanceled();

    void onSearchStarted();

    void onSearchStopped();
}
