package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class ActivityRecreator {
    public static final String LOG_TAG = "ActivityRecreator";
    public static final Class<?> activityThreadClass = getActivityThreadClass();
    public static final Handler mainHandler = new Handler(Looper.getMainLooper());
    public static final Field mainThreadField = getMainThreadField();
    public static final Method performStopActivity2ParamsMethod = getPerformStopActivity2Params(activityThreadClass);
    public static final Method performStopActivity3ParamsMethod = getPerformStopActivity3Params(activityThreadClass);
    public static final Method requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(activityThreadClass);
    public static final Field tokenField = getTokenField();

    public static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        public Object currentlyRecreatingToken;
        public Activity mActivity;
        public boolean mDestroyed = false;
        public boolean mStarted = false;
        public boolean mStopQueued = false;

        public LifecycleCheckCallbacks(@NonNull Activity activity) {
            this.mActivity = activity;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.mActivity == activity) {
                this.mActivity = null;
                this.mDestroyed = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.mDestroyed && !this.mStopQueued && !this.mStarted && ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, activity)) {
                this.mStopQueued = true;
                this.currentlyRecreatingToken = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.mActivity == activity) {
                this.mStarted = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static Class<?> getActivityThreadClass() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field getMainThreadField() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method getPerformStopActivity2Params(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method getPerformStopActivity3Params(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method getRequestRelaunchActivityMethod(Class<?> cls) {
        if (needsRelaunchCall() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Field getTokenField() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean needsRelaunchCall() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    public static boolean queueOnStopIfNecessary(Object obj, Activity activity) {
        try {
            final Object obj2 = tokenField.get(activity);
            if (obj2 != obj) {
                return false;
            }
            final Object obj3 = mainThreadField.get(activity);
            mainHandler.postAtFrontOfQueue(new Runnable() {
                public void run() {
                    try {
                        if (ActivityRecreator.performStopActivity3ParamsMethod != null) {
                            ActivityRecreator.performStopActivity3ParamsMethod.invoke(obj3, new Object[]{obj2, Boolean.FALSE, "AppCompat recreation"});
                            return;
                        }
                        ActivityRecreator.performStopActivity2ParamsMethod.invoke(obj3, new Object[]{obj2, Boolean.FALSE});
                    } catch (RuntimeException e2) {
                        if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                            throw e2;
                        }
                    } catch (Throwable th) {
                        Log.e(ActivityRecreator.LOG_TAG, "Exception while invoking performStopActivity", th);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            Log.e(LOG_TAG, "Exception while fetching field values", th);
            return false;
        }
    }

    public static boolean recreate(@NonNull Activity activity) {
        Object obj;
        final Application application;
        final LifecycleCheckCallbacks lifecycleCheckCallbacks;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (needsRelaunchCall() && requestRelaunchActivityMethod == null) {
            return false;
        } else {
            if (performStopActivity2ParamsMethod == null && performStopActivity3ParamsMethod == null) {
                return false;
            }
            try {
                final Object obj2 = tokenField.get(activity);
                if (obj2 == null || (obj = mainThreadField.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
                application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                mainHandler.post(new Runnable() {
                    public void run() {
                        LifecycleCheckCallbacks.this.currentlyRecreatingToken = obj2;
                    }
                });
                if (needsRelaunchCall()) {
                    requestRelaunchActivityMethod.invoke(obj, new Object[]{obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE});
                } else {
                    activity.recreate();
                }
                mainHandler.post(new Runnable() {
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
