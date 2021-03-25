package com.tuya.smart.common;

import com.tuya.sdk.timer.bean.CategoryStatusBean;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.sdk.timer.bean.DpTimerListBean;
import com.tuya.sdk.timer.bean.GroupTimerBean;
import com.tuya.smart.sdk.bean.Timer;
import com.tuya.smart.sdk.bean.TimerTask;
import com.tuya.smart.sdk.bean.TimerTaskStatus;
import java.util.ArrayList;
import java.util.Iterator;

public class o00o0o00o0 {
    public static Timer O000000o(DpTimerBean dpTimerBean) {
        Timer timer = new Timer();
        timer.setTime(dpTimerBean.getTime());
        timer.setDate(dpTimerBean.getDate());
        timer.setStatus(dpTimerBean.getStatus());
        timer.setLoops(dpTimerBean.getLoops());
        timer.setDpId(dpTimerBean.getDpId());
        timer.setValue(dpTimerBean.getDps().toJSONString());
        return timer;
    }

    public static TimerTask O000000o(DpTimerListBean dpTimerListBean) {
        TimerTask timerTask = new TimerTask();
        if (dpTimerListBean != null) {
            timerTask.setTimerTaskStatus(O000000o(dpTimerListBean.getCategory()));
            ArrayList<GroupTimerBean> groups = dpTimerListBean.getGroups();
            if (groups != null && !groups.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<GroupTimerBean> it = groups.iterator();
                while (it.hasNext()) {
                    GroupTimerBean next = it.next();
                    ArrayList<DpTimerBean> timers = next.getTimers();
                    if (timers != null && !timers.isEmpty()) {
                        Iterator<DpTimerBean> it2 = timers.iterator();
                        while (it2.hasNext()) {
                            Timer O000000o = O000000o(it2.next());
                            O000000o.setTimerId(next.getId());
                            arrayList.add(O000000o);
                        }
                    }
                }
                timerTask.setTimerList(arrayList);
            }
        }
        return timerTask;
    }

    public static TimerTaskStatus O000000o(CategoryStatusBean categoryStatusBean) {
        TimerTaskStatus timerTaskStatus = new TimerTaskStatus();
        if (categoryStatusBean != null) {
            timerTaskStatus.setTimerName(categoryStatusBean.getCategory());
            timerTaskStatus.setIsOpen(categoryStatusBean.isOpen());
        }
        return timerTaskStatus;
    }

    public static ArrayList<TimerTaskStatus> O000000o(ArrayList<CategoryStatusBean> arrayList) {
        ArrayList<TimerTaskStatus> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<CategoryStatusBean> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(O000000o(it.next()));
            }
        }
        return arrayList2;
    }

    public static ArrayList<TimerTask> O00000Oo(ArrayList<DpTimerListBean> arrayList) {
        ArrayList<TimerTask> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<DpTimerListBean> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(O000000o(it.next()));
            }
        }
        return arrayList2;
    }
}
