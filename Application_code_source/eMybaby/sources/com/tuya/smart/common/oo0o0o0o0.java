package com.tuya.smart.common;

import com.alibaba.fastjson.JSON;
import com.tuya.sdk.scene.bean.LocalSceneResBean;
import com.tuya.smart.home.sdk.bean.scene.LocalSceneBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oo0o0o0o0 {
    public static LocalSceneBean O000000o(LocalSceneResBean localSceneResBean) {
        LocalSceneBean localSceneBean = (LocalSceneBean) JSON.parseObject(JSON.toJSONString(localSceneResBean), LocalSceneBean.class);
        localSceneBean.setBackground(localSceneResBean.getRuleBackground());
        localSceneBean.setId(localSceneResBean.getRuleId());
        localSceneBean.setName(localSceneResBean.getRuleName());
        return localSceneBean;
    }

    public static List<LocalSceneBean> O000000o(ArrayList<LocalSceneResBean> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<LocalSceneResBean> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(O000000o(it.next()));
        }
        return arrayList2;
    }
}
