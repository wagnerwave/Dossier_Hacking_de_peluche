package a.c.d.j.f.b;

import a.c.d.j.b.d.e;
import android.app.Activity;
import android.content.Context;
import android.os.Message;
import com.tuya.smart.android.mvp.bean.Result;
import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.android.user.api.IRegisterCallback;
import com.tuya.smart.android.user.bean.User;

public class b extends BasePresenter {

    /* renamed from: a  reason: collision with root package name */
    public Activity f289a;

    /* renamed from: b  reason: collision with root package name */
    public a.c.d.j.f.a f290b;

    /* renamed from: c  reason: collision with root package name */
    public String f291c;

    /* renamed from: d  reason: collision with root package name */
    public IRegisterCallback f292d = new a();

    public class a implements IRegisterCallback {
        public a() {
        }

        public void onError(String str, String str2) {
            Message message = new Message();
            message.what = 16;
            Result result = new Result();
            result.error = str2;
            result.errorCode = str;
            message.obj = result;
            b.this.mHandler.sendMessage(message);
        }

        public void onSuccess(User user) {
            b.this.mHandler.sendEmptyMessage(15);
        }
    }

    public b(Context context, a.c.d.j.f.a aVar) {
        Activity activity = (Activity) context;
        this.f289a = activity;
        this.f290b = aVar;
        this.f291c = activity.getResources().getConfiguration().locale.getCountry();
    }

    public boolean handleMessage(Message message) {
        Result result;
        a.c.d.j.f.a aVar;
        int i = message.what;
        if (i != 15) {
            if (i == 16) {
                aVar = this.f290b;
                result = (Result) message.obj;
            }
            return super.handleMessage(message);
        }
        aVar = this.f290b;
        result = null;
        ((e) aVar).p(i, result);
        return super.handleMessage(message);
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
