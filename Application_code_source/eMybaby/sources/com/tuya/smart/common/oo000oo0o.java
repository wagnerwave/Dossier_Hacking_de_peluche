package com.tuya.smart.common;

import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.network.api.ApiEventBean;
import com.tuya.smart.android.network.api.IApiEvent;
import com.tuya.smart.android.network.stat.ApiEvent;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class oo000oo0o implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        ArrayList<IApiEvent> apiEvents = ApiEvent.getApiEvents();
        long nanoTime = System.nanoTime();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            L.d("OkHttp", String.format("Sending request %s on %s%n%s", new Object[]{request.url(), chain.connection(), request.headers()}));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Response proceed = chain.proceed(request);
        long currentTimeMillis2 = System.currentTimeMillis();
        double nanoTime2 = (double) (System.nanoTime() - nanoTime);
        Double.isNaN(nanoTime2);
        double d2 = nanoTime2 / 1000000.0d;
        L.d("OkHttp", String.format("Received response for %s in %.1fms%n%s", new Object[]{proceed.request().url(), Double.valueOf(d2), proceed.headers()}));
        if (!(apiEvents == null || apiEvents.size() == 0)) {
            ApiEventBean apiEventBean = new ApiEventBean();
            try {
                String httpUrl = request.url().toString();
                String str = httpUrl.split("a=")[1].split("&")[0];
                String str2 = httpUrl.split("v=")[1].split("&")[0];
                apiEventBean.setApi(str);
                apiEventBean.setApiVersion(str2);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            apiEventBean.setSuccess(true);
            apiEventBean.setErrorCode("");
            apiEventBean.setErrorMsg("");
            try {
                apiEventBean.setRequestTime(currentTimeMillis + "");
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            apiEventBean.setResponseTime(currentTimeMillis2 + "");
            apiEventBean.setUseTime(d2 + "");
            Iterator<IApiEvent> it = apiEvents.iterator();
            while (it.hasNext()) {
                it.next().onSuccess(apiEventBean);
            }
        }
        return proceed;
    }
}
