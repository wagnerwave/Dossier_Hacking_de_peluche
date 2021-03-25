package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

public class SingleGeneratedAdapterObserver implements LifecycleEventObserver {
    public final GeneratedAdapter mGeneratedAdapter;

    public SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.mGeneratedAdapter = generatedAdapter;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.mGeneratedAdapter.callMethods(lifecycleOwner, event, false, (MethodCallsLogger) null);
        this.mGeneratedAdapter.callMethods(lifecycleOwner, event, true, (MethodCallsLogger) null);
    }
}
