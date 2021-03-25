package a.e.a.a.q.i;

import com.inuker.bluetooth.library.search.SearchResult;

public interface a {
    void onDeviceFounded(SearchResult searchResult);

    void onSearchCanceled();

    void onSearchStarted();

    void onSearchStopped();
}
