package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

public class TransitionValuesMaps {
    public final SparseArray<View> mIdValues = new SparseArray<>();
    public final LongSparseArray<View> mItemIdValues = new LongSparseArray<>();
    public final ArrayMap<String, View> mNameValues = new ArrayMap<>();
    public final ArrayMap<View, TransitionValues> mViewValues = new ArrayMap<>();
}
