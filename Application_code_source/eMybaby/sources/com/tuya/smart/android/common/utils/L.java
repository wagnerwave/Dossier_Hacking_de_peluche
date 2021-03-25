package com.tuya.smart.android.common.utils;

import a.a.a.a.a;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;

public final class L {
    public static String TUYA_TAG = "Tuya";
    public static boolean isLogOn = false;
    public static boolean isSendLogOn = false;
    public static ILogJsonProxy mILogJsonProxy;
    public static StringBuffer sLogData = new StringBuffer();
    public static String sLogPath;

    public interface ILogJsonProxy {
        void log(String str, String str2);
    }

    public static void d(String str, String str2) {
        if (str != null && str2 != null && isLogOn) {
            String str3 = TUYA_TAG;
            Log.d(str3, str + " " + str2);
        }
    }

    public static void e(String str, String str2) {
        if (str != null && str2 != null && isLogOn) {
            String str3 = TUYA_TAG;
            Log.e(str3, str + " " + str2);
        }
    }

    public static boolean getLogStatus() {
        return isLogOn;
    }

    public static boolean getSendLogStatus() {
        return isSendLogOn;
    }

    public static void i(String str, String str2) {
        if (str != null && str2 != null && isLogOn) {
            String str3 = TUYA_TAG;
            Log.i(str3, str + " " + str2);
        }
    }

    public static void init() {
    }

    public static void log2(String str, String str2) {
        if (str != null && str2 != null && isLogOn) {
            String m = a.m(new StringBuilder(), TUYA_TAG, "2");
            Log.d(m, str + " " + str2);
        }
    }

    public static void logInLocal(String str) {
        logInLocal("", str);
    }

    public static void logInLocal(String str, String str2) {
        if (isLogOn) {
            d(str, str2);
        }
    }

    public static void logJson(String str, String str2) {
        if (str != null && str2 != null && isLogOn) {
            ILogJsonProxy iLogJsonProxy = mILogJsonProxy;
            if (iLogJsonProxy != null) {
                iLogJsonProxy.log(str, str2);
            } else {
                d(str, str2);
            }
        }
    }

    public static void logServer(String str) {
        if (Environment.getExternalStorageState().equals("mounted") && !TextUtils.isEmpty(sLogPath)) {
            try {
                File file = new File(sLogPath);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                } else if (file.length() > 5242880) {
                    FileUtil.deleteFileSafely(file);
                }
                FileWriter fileWriter = new FileWriter(sLogPath, true);
                fileWriter.write(str + "\r\n");
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void logServer(String str, Object obj) {
        if (str != null && obj != null) {
            d(str, obj.toString());
        }
    }

    @Deprecated
    public static void logToServer(String str, String str2) {
        if (str != null && str2 != null) {
            d(str, str2);
        }
    }

    public static void mqtt(String str, String str2) {
        if (isLogOn) {
            d("mqtt: " + str, str2);
        }
    }

    public static void setJsonAdapter(ILogJsonProxy iLogJsonProxy) {
        mILogJsonProxy = iLogJsonProxy;
    }

    public static void setLogSwitcher(boolean z) {
        isLogOn = z;
    }

    public static void setSendLogOn(boolean z) {
        isSendLogOn = z;
    }

    public static void setsLogPath(String str) {
        sLogPath = str;
    }

    public static void v(String str, String str2) {
        if (str != null && str2 != null && isLogOn) {
            String str3 = TUYA_TAG;
            Log.v(str3, str + " " + str2);
        }
    }

    public static void w(String str, String str2) {
        if (str != null && str2 != null && isLogOn) {
            String str3 = TUYA_TAG;
            Log.w(str3, str + " " + str2);
        }
    }
}
