package a.d.a.a.e.k.l;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.LifecycleCallback;

public interface i {
    void b(String str, @NonNull LifecycleCallback lifecycleCallback);

    <T extends LifecycleCallback> T j(String str, Class<T> cls);

    Activity k();

    void startActivityForResult(Intent intent, int i);
}
