package a.c.d.j.c;

import android.content.Context;
import com.tuya.smart.android.common.utils.SafeHandler;
import com.tuya.smart.android.mvp.model.BaseModel;
import com.tuya.smart.sdk.api.ITuyaActivator;
import com.tuya.smart.sdk.enums.ActivatorModelEnum;

public class c extends BaseModel {

    /* renamed from: a  reason: collision with root package name */
    public ITuyaActivator f228a;

    /* renamed from: b  reason: collision with root package name */
    public ActivatorModelEnum f229b;

    public c(Context context, SafeHandler safeHandler) {
        super(context, safeHandler);
    }

    public void onDestroy() {
        ITuyaActivator iTuyaActivator = this.f228a;
        if (iTuyaActivator != null) {
            iTuyaActivator.onDestroy();
        }
    }
}
