package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ViewModelStore {
    public final HashMap<String, ViewModel> mMap = new HashMap<>();

    public final void clear() {
        for (ViewModel clear : this.mMap.values()) {
            clear.clear();
        }
        this.mMap.clear();
    }

    public final ViewModel get(String str) {
        return this.mMap.get(str);
    }

    public Set<String> keys() {
        return new HashSet(this.mMap.keySet());
    }

    public final void put(String str, ViewModel viewModel) {
        ViewModel put = this.mMap.put(str, viewModel);
        if (put != null) {
            put.onCleared();
        }
    }
}
