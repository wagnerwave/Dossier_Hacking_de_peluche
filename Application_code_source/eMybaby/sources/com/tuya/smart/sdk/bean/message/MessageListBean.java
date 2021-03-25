package com.tuya.smart.sdk.bean.message;

import a.a.a.a.a;
import java.util.List;

public class MessageListBean {
    public List<MessageBean> datas;
    public int totalCount;

    public List<MessageBean> getDatas() {
        return this.datas;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setDatas(List<MessageBean> list) {
        this.datas = list;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public String toString() {
        StringBuilder n = a.n("MessageStatusBean{datas size =");
        n.append(this.datas.size());
        n.append(", totalCount=");
        n.append(this.totalCount);
        n.append('}');
        return n.toString();
    }
}
