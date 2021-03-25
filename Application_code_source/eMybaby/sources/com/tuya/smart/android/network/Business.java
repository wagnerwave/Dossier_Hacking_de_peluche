package com.tuya.smart.android.network;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.network.api.ApiEventBean;
import com.tuya.smart.android.network.api.IApiEvent;
import com.tuya.smart.android.network.bean.PageList;
import com.tuya.smart.android.network.business.BusinessResult;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.android.network.request.OKHttpBusinessRequest;
import com.tuya.smart.android.network.stat.ApiEvent;
import com.tuya.smart.android.network.util.ParseHelper;
import com.tuya.smart.android.network.util.TimeStampManager;
import com.tuya.smart.common.oo000oooo;
import com.tuya.smart.mqtt.MqttServiceConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class Business {
    public static final String BUSINESS_IO_EXCEPTION = "106";
    public static final String BUSINESS_JSON_EXCEPTION = "102";
    public static final String BUSINESS_NEED_LOGIN = "105";
    public static final String BUSINESS_NETWORK_ERROR = "103";
    public static final String BUSINESS_NETWORK_UNKNOWN = "101";
    public static final String BUSINESS_TIME_ERROR = "104";
    public static final String TAG = "Business";
    public static ExecutorService executor = Executors.newFixedThreadPool(4);
    public boolean isCanceled = false;
    public final Handler mHandler;
    public String tagRequest = toString();

    public interface OnNeedLoginListener {
        void onNeedLogin(Context context);
    }

    public abstract class RequestTask<T> implements Runnable, Callback {
        public TuyaApiParams apiParams;
        public boolean isRetryMode = false;
        public ResultListener<T> listener;
        public int retryTime = 1;

        public RequestTask(TuyaApiParams tuyaApiParams, ResultListener<T> resultListener) {
            this.apiParams = tuyaApiParams;
            this.listener = resultListener;
        }

        private boolean checkApiParams() {
            if (!this.apiParams.isSessionRequire() || !TextUtils.isEmpty(this.apiParams.getSession())) {
                return true;
            }
            BusinessResponse businessResponse = new BusinessResponse();
            businessResponse.setApi(this.apiParams.getApiName());
            businessResponse.setV(this.apiParams.getApiVersion());
            businessResponse.setErrorMsg("Session is not exist and need login again");
            businessResponse.setErrorCode(BusinessResponse.RESULT_SESSION_LOSS);
            onFailure(businessResponse, (Object) null, this.apiParams.getApiName());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(BusinessResponse.KEY_APINAME, (Object) this.apiParams.getApiName());
            L.logServer("session_invalid", jSONObject);
            return false;
        }

        private void onFailure(final BusinessResponse businessResponse, final T t, final String str) {
            if (Business.this.mHandler != null) {
                L.e(Business.TAG, businessResponse.getErrorMsg());
                Business.this.mHandler.post(new Runnable() {
                    public void run() {
                        ResultListener<T> resultListener = RequestTask.this.listener;
                        if (resultListener != null) {
                            resultListener.onFailure(businessResponse, t, str);
                        }
                    }
                });
                return;
            }
            ResultListener<T> resultListener = this.listener;
            if (resultListener != null) {
                resultListener.onFailure(businessResponse, t, str);
            }
        }

        private void onFailure(Call call, Response response) {
            L.e(Business.TAG, response.message());
            BusinessResponse businessResponse = new BusinessResponse();
            businessResponse.setErrorCode("101");
            businessResponse.setErrorMsg(oo000oooo.O000000o(TuyaSmartNetWork.getAppContext(), String.valueOf(response.code())));
            onFailure(businessResponse, (Object) null, this.apiParams.getApiName());
        }

        private void onFailureWithJSONException(Call call, Response response, String str) {
            BusinessResponse businessResponse = new BusinessResponse();
            businessResponse.setErrorCode("102");
            businessResponse.setErrorMsg(oo000oooo.O000000o(TuyaSmartNetWork.getAppContext(), "json error"));
            onFailure(businessResponse, (Object) null, this.apiParams.getApiName());
        }

        private void onRequest() {
            if (!Business.this.isCanceled) {
                TuyaSmartNetWork.getOkHttpClient().newCall(OKHttpBusinessRequest.newOKHttpRequest(this.apiParams, TuyaSmartNetWork.getRequestHeaders(), Business.this.tagRequest)).enqueue(this);
            }
        }

        private void onSuccess(final BusinessResponse businessResponse, final T t, final String str) {
            if (Business.this.mHandler != null) {
                Business.this.mHandler.post(new Runnable() {
                    public void run() {
                        ResultListener<T> resultListener = RequestTask.this.listener;
                        if (resultListener != null) {
                            resultListener.onSuccess(businessResponse, t, str);
                        }
                    }
                });
                return;
            }
            ResultListener<T> resultListener = this.listener;
            if (resultListener != null) {
                resultListener.onSuccess(businessResponse, t, str);
            }
        }

        private void onSuccessResponse(Call call, BusinessResponse businessResponse) {
            if (businessResponse.isSuccess()) {
                onSuccessResult(call, businessResponse);
            } else if (!this.isRetryMode) {
                onSuccessResponseWithResultFailure(call, businessResponse);
            } else {
                onFailure(businessResponse, (Object) null, businessResponse.getApi());
            }
        }

        private void onSuccessResponseWithResultFailure(Call call, BusinessResponse businessResponse) {
            if (BusinessResponse.RESULT_TIME_INVALID.equals(businessResponse.getErrorCode())) {
                TimeStampManager.instance().updateTimeStamp(businessResponse.getTimestamp());
                TimeStampManager.instance().save(TuyaSmartNetWork.getAppContext());
                onRetry();
                return;
            }
            if (BusinessResponse.RESULT_SESSION_INVALID.equals(businessResponse.getErrorCode()) || BusinessResponse.RESULT_SESSION_LOSS.equals(businessResponse.getErrorCode())) {
                L.e(Business.TAG, "session is not exist");
                Business.this.mHandler.post(new Runnable() {
                    public void run() {
                        TuyaSmartNetWork.needLogin();
                    }
                });
                businessResponse.setErrorCode("105");
            }
            onFailure(businessResponse, (Object) null, businessResponse.getApi());
        }

        private void onSuccessResult(Call call, BusinessResponse businessResponse) {
            Object onParser = onParser(businessResponse);
            if (businessResponse.isSuccess()) {
                onSuccess(businessResponse, onParser, businessResponse.getApi());
            } else {
                onFailure(businessResponse, (Object) null, businessResponse.getApi());
            }
        }

        public void onFailure(Call call, IOException iOException) {
            String message = iOException.getMessage();
            iOException.printStackTrace();
            L.i("Business Error, %s", message);
            if (this.listener != null) {
                if (call == null || !call.isCanceled()) {
                    BusinessResponse businessResponse = new BusinessResponse();
                    businessResponse.setApi(this.apiParams.getApiName());
                    businessResponse.setV(this.apiParams.getApiVersion());
                    businessResponse.setErrorCode("103");
                    businessResponse.setErrorMsg(oo000oooo.O000000o(TuyaSmartNetWork.getAppContext(), message));
                    onFailure(businessResponse, (Object) null, this.apiParams.getApiName());
                    ArrayList<IApiEvent> apiEvents = ApiEvent.getApiEvents();
                    if (apiEvents != null && apiEvents.size() != 0) {
                        ApiEventBean apiEventBean = new ApiEventBean();
                        apiEventBean.setApi(this.apiParams.getApiName());
                        apiEventBean.setApiVersion(this.apiParams.getApiVersion());
                        apiEventBean.setSuccess(false);
                        apiEventBean.setErrorCode(message);
                        apiEventBean.setErrorMsg(businessResponse.getErrorMsg());
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", call.request().url().toString());
                        hashMap.put("params", call.request().url().query());
                        hashMap.put("success", Boolean.FALSE);
                        hashMap.put(MqttServiceConstants.TRACE_EXCEPTION, iOException.getLocalizedMessage());
                        for (IApiEvent next : apiEvents) {
                            next.onFailure(apiEventBean);
                            next.onFailure(hashMap);
                        }
                    }
                }
            }
        }

        public abstract T onParser(BusinessResponse businessResponse);

        public void onResponse(Call call, Response response) {
            if (this.listener != null) {
                if (call != null && call.isCanceled()) {
                    return;
                }
                if (response.isSuccessful()) {
                    try {
                        String string = response.body().string();
                        L.logJson(Business.TAG, "api: " + this.apiParams.getApiName() + " " + string);
                        onSuccessResponse(call, (BusinessResponse) JSON.parseObject(string, BusinessResponse.class));
                        ArrayList<IApiEvent> apiEvents = ApiEvent.getApiEvents();
                        if (apiEvents != null && apiEvents.size() != 0 && call != null) {
                            for (IApiEvent onSuccess : apiEvents) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("url", call.request().url().toString());
                                hashMap.put("params", call.request().url().query());
                                hashMap.put("success", Boolean.TRUE);
                                onSuccess.onSuccess(hashMap);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        onFailureWithJSONException(call, response, e2.getMessage());
                    }
                } else {
                    onFailure(call, response);
                }
            }
        }

        public void onRetry() {
            this.isRetryMode = true;
            int i = this.retryTime;
            this.retryTime = i - 1;
            if (i > 0) {
                onRequest();
            }
        }

        public void run() {
            if (checkApiParams()) {
                onRequest();
            }
        }
    }

    public interface ResultListener<T> {
        void onFailure(BusinessResponse businessResponse, T t, String str);

        void onSuccess(BusinessResponse businessResponse, T t, String str);
    }

    public Business() {
        this.mHandler = Looper.myLooper() == Looper.getMainLooper() ? new Handler() : new Handler(Looper.getMainLooper());
    }

    public Business(Handler handler) {
        this.mHandler = handler;
    }

    private <T> BusinessResult<T> onFailureResponseSync(BusinessResult<T> businessResult, Response response) {
        BusinessResponse businessResponse = new BusinessResponse();
        businessResponse.setErrorCode("101");
        businessResponse.setErrorMsg(oo000oooo.O000000o(TuyaSmartNetWork.getAppContext(), String.valueOf(response.code())));
        businessResult.setBizResponse(businessResponse);
        return businessResult;
    }

    private <T> BusinessResult<T> onFailureSync(BusinessResult<T> businessResult, String str) {
        BusinessResponse businessResponse = new BusinessResponse();
        businessResponse.setErrorCode("106");
        businessResponse.setErrorMsg(oo000oooo.O000000o(TuyaSmartNetWork.getAppContext(), str));
        businessResult.setBizResponse(businessResponse);
        return businessResult;
    }

    private <T> BusinessResult<T> onFailureWithJSONExceptionSync(BusinessResult<T> businessResult, Response response, String str) {
        BusinessResponse businessResponse = new BusinessResponse();
        businessResponse.setErrorCode("102");
        businessResponse.setErrorMsg(oo000oooo.O000000o(TuyaSmartNetWork.getAppContext(), "json error"));
        businessResult.setBizResponse(businessResponse);
        return businessResult;
    }

    public <T> void asyncArrayList(TuyaApiParams tuyaApiParams, Class<T> cls, ResultListener<ArrayList<T>> resultListener) {
        asyncArrayList(tuyaApiParams, cls, (String) null, resultListener);
    }

    public <T> void asyncArrayList(TuyaApiParams tuyaApiParams, Class<T> cls, String str, ResultListener<ArrayList<T>> resultListener) {
        final Class<T> cls2 = cls;
        final String str2 = str;
        runRequestTask(new RequestTask<ArrayList<T>>(tuyaApiParams, resultListener) {
            public ArrayList<T> onParser(BusinessResponse businessResponse) {
                return ParseHelper.parse2ArrayList(businessResponse, cls2, str2);
            }
        });
    }

    public <T> void asyncArrayLists(TuyaApiParams tuyaApiParams, Class<T> cls, ResultListener<ArrayList<ArrayList<T>>> resultListener) {
        asyncArrayLists(tuyaApiParams, cls, (String) null, resultListener);
    }

    public <T> void asyncArrayLists(TuyaApiParams tuyaApiParams, Class<T> cls, String str, ResultListener<ArrayList<ArrayList<T>>> resultListener) {
        final Class<T> cls2 = cls;
        final String str2 = str;
        runRequestTask(new RequestTask<ArrayList<ArrayList<T>>>(tuyaApiParams, resultListener) {
            public ArrayList<ArrayList<T>> onParser(BusinessResponse businessResponse) {
                return ParseHelper.parse2ArrayLists(businessResponse, cls2, str2);
            }
        });
    }

    public <T> void asyncHashMap(TuyaApiParams tuyaApiParams, Class<T> cls, ResultListener<Map<String, T>> resultListener) {
        asyncHashMap(tuyaApiParams, cls, (String[]) null, resultListener);
    }

    public <T> void asyncHashMap(TuyaApiParams tuyaApiParams, Class<T> cls, String[] strArr, ResultListener<Map<String, T>> resultListener) {
        final Class<T> cls2 = cls;
        final String[] strArr2 = strArr;
        runRequestTask(new RequestTask<Map<String, T>>(tuyaApiParams, resultListener) {
            public Map<String, T> onParser(BusinessResponse businessResponse) {
                return ParseHelper.parse2HashMap(businessResponse, cls2, strArr2);
            }
        });
    }

    public <T> void asyncPageList(TuyaApiParams tuyaApiParams, Class<T> cls, ResultListener<PageList<T>> resultListener) {
        asyncPageList(tuyaApiParams, cls, (String) null, (String) null, resultListener);
    }

    public <T> void asyncPageList(TuyaApiParams tuyaApiParams, Class<T> cls, String str, ResultListener<PageList<T>> resultListener) {
        asyncPageList(tuyaApiParams, cls, str, (String) null, resultListener);
    }

    public <T> void asyncPageList(TuyaApiParams tuyaApiParams, Class<T> cls, String str, String str2, ResultListener<PageList<T>> resultListener) {
        final Class<T> cls2 = cls;
        final String str3 = str;
        final String str4 = str2;
        runRequestTask(new RequestTask<PageList<T>>(tuyaApiParams, resultListener) {
            public PageList<T> onParser(BusinessResponse businessResponse) {
                return ParseHelper.parse2PageList(businessResponse, cls2, str3, str4);
            }
        });
    }

    public void asyncRequest(TuyaApiParams tuyaApiParams) {
        runRequestTask(new RequestTask<JSONObject>(tuyaApiParams, (ResultListener) null) {
            public JSONObject onParser(BusinessResponse businessResponse) {
                return null;
            }
        });
    }

    public void asyncRequest(TuyaApiParams tuyaApiParams, ResultListener<JSONObject> resultListener) {
        asyncRequest(tuyaApiParams, JSONObject.class, resultListener);
    }

    public <T> void asyncRequest(TuyaApiParams tuyaApiParams, Class<T> cls, ResultListener<T> resultListener) {
        asyncRequest(tuyaApiParams, cls, (String) null, resultListener);
    }

    public <T> void asyncRequest(TuyaApiParams tuyaApiParams, Class<T> cls, String str, ResultListener<T> resultListener) {
        final Class<T> cls2 = cls;
        final String str2 = str;
        runRequestTask(new RequestTask<T>(tuyaApiParams, resultListener) {
            public T onParser(BusinessResponse businessResponse) {
                return ParseHelper.parser(businessResponse, cls2, str2);
            }
        });
    }

    public void asyncRequestBoolean(TuyaApiParams tuyaApiParams, ResultListener<Boolean> resultListener) {
        asyncRequest(tuyaApiParams, Boolean.class, resultListener);
    }

    public void cancelAll() {
        if (!TextUtils.isEmpty(this.tagRequest)) {
            for (Call next : TuyaSmartNetWork.getOkHttpClient().dispatcher().queuedCalls()) {
                Object tag = next.request().tag();
                if (tag != null && tag.equals(this.tagRequest)) {
                    next.cancel();
                }
            }
            for (Call next2 : TuyaSmartNetWork.getOkHttpClient().dispatcher().runningCalls()) {
                Object tag2 = next2.request().tag();
                if (tag2 != null && tag2.equals(this.tagRequest)) {
                    next2.cancel();
                }
            }
            this.isCanceled = true;
        }
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    public void onDestroy() {
        cancelAll();
    }

    public void runRequestTask(Runnable runnable) {
        executor.execute(runnable);
    }

    public <T> BusinessResult<T> syncRequest(TuyaApiParams tuyaApiParams, Class<T> cls) {
        T parser;
        Request newOKHttpRequest = OKHttpBusinessRequest.newOKHttpRequest(tuyaApiParams, TuyaSmartNetWork.getRequestHeaders(), this.tagRequest);
        BusinessResult<T> businessResult = new BusinessResult<>();
        businessResult.setApiName(tuyaApiParams.getApiName());
        try {
            Response execute = TuyaSmartNetWork.getOkHttpClient().newCall(newOKHttpRequest).execute();
            if (!execute.isSuccessful()) {
                return onFailureResponseSync(businessResult, execute);
            }
            try {
                String string = execute.body().string();
                L.logJson(TAG, string);
                BusinessResponse businessResponse = (BusinessResponse) JSON.parseObject(string, BusinessResponse.class);
                if (businessResponse.isSuccess() && (parser = ParseHelper.parser(businessResponse, cls, (String) null)) != null) {
                    businessResult.setBizResult(parser);
                }
                businessResult.setBizResponse(businessResponse);
                return businessResult;
            } catch (Exception e2) {
                return onFailureWithJSONExceptionSync(businessResult, execute, e2.getMessage());
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return onFailureSync(businessResult, e3.getMessage());
        }
    }
}
