package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.AsyncTask;
import com.tuya.sdk.home.bean.TuyaListDataBean;
import com.tuya.smart.android.base.ApiParams;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.android.network.bean.ApiBean;
import com.tuya.smart.android.network.bean.ApiResponeBean;
import com.tuya.smart.android.network.http.BusinessResponse;
import java.util.ArrayList;
import java.util.List;

public class o0o000o0o extends Business {
    public static final String O000000o = "tuya.m.my.group.device.list";
    public static final String O00000Oo = "tuya.m.my.group.device.group.list";
    public static final String O00000o = "tuya.m.device.sig.mesh.list";
    public static final String O00000o0 = "tuya.m.my.group.mesh.list";
    public static final String O00000oO = "tuya.m.my.group.device.relation.list";
    public static final String O00000oo = "tuya.m.device.ref.info.my.list";
    public static final String O0000O0o = "tuya.m.location.get";
    public static final String O0000OOo = "tuya.m.my.shared.device.list";
    public static final String O0000Oo = "tuya.m.my.group.device.sort.list";
    public static final String O0000Oo0 = "tuya.m.my.shared.device.group.list";

    private ApiBean O000000o() {
        return new ApiBean(a.E("tuya.m.my.shared.device.list", "1.0", true));
    }

    private ApiBean O000000o(String str) {
        ApiParams apiParams = new ApiParams(O0000Oo, "1.0");
        apiParams.putPostData(TuyaApiParams.KEY_GID, str);
        apiParams.setSessionRequire(true);
        return new ApiBean(apiParams);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: com.tuya.sdk.home.bean.HomeResponseBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v21, resolved type: java.util.Iterator<com.tuya.smart.sdk.bean.SigMeshBean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: java.util.Iterator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v22, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v23, resolved type: java.util.Iterator<com.tuya.smart.sdk.bean.ProductBean>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v33, resolved type: java.util.Iterator} */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r17v3 */
    /* JADX WARNING: type inference failed for: r17v19 */
    /* JADX WARNING: type inference failed for: r17v20 */
    /* JADX WARNING: type inference failed for: r17v21 */
    /* JADX WARNING: type inference failed for: r17v22 */
    /* JADX WARNING: type inference failed for: r17v23 */
    /* JADX WARNING: type inference failed for: r17v24 */
    /* JADX WARNING: type inference failed for: r17v25 */
    /* JADX WARNING: type inference failed for: r17v26 */
    /* JADX WARNING: type inference failed for: r17v27 */
    /* JADX WARNING: type inference failed for: r17v28 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01d7, code lost:
        r10 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02a7, code lost:
        r10 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02a9, code lost:
        r9 = r18;
        r14 = r19;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void O000000o(java.util.ArrayList<com.tuya.smart.android.network.bean.ApiResponeBean> r21, com.tuya.smart.common.o0o0oo000<com.tuya.sdk.home.bean.TuyaListDataBean> r22) {
        /*
            r20 = this;
            r1 = r22
            java.lang.Class<com.tuya.smart.interior.device.bean.DeviceRespBean> r2 = com.tuya.smart.interior.device.bean.DeviceRespBean.class
            java.lang.Class<com.tuya.smart.interior.device.bean.GroupRespBean> r3 = com.tuya.smart.interior.device.bean.GroupRespBean.class
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            com.tuya.sdk.home.bean.HomeResponseBean r9 = new com.tuya.sdk.home.bean.HomeResponseBean
            r9.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            com.tuya.sdk.home.bean.TuyaListDataBean r12 = new com.tuya.sdk.home.bean.TuyaListDataBean
            r12.<init>()
            java.util.Iterator r13 = r21.iterator()
            java.lang.String r14 = ""
            r15 = r11
            r21 = r14
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r0
        L_0x0049:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x02be
            java.lang.Object r0 = r13.next()
            com.tuya.smart.android.network.bean.ApiResponeBean r0 = (com.tuya.smart.android.network.bean.ApiResponeBean) r0
            r16 = r13
            java.lang.String r13 = r0.getApi()     // Catch:{ Exception -> 0x02ae }
            r17 = -1
            int r18 = r13.hashCode()     // Catch:{ Exception -> 0x02ae }
            switch(r18) {
                case -1772514931: goto L_0x00df;
                case -1740941900: goto L_0x00d2;
                case -1140782591: goto L_0x00c5;
                case -917769021: goto L_0x00b8;
                case -343457104: goto L_0x00ab;
                case -119104439: goto L_0x009e;
                case 176115427: goto L_0x0091;
                case 1138134443: goto L_0x0084;
                case 1583114776: goto L_0x0076;
                case 2012629498: goto L_0x0068;
                default: goto L_0x0064;
            }
        L_0x0064:
            r18 = r9
            goto L_0x00ef
        L_0x0068:
            r18 = r9
            java.lang.String r9 = "tuya.m.my.group.device.group.list"
            boolean r9 = r13.equals(r9)     // Catch:{ Exception -> 0x00ec }
            if (r9 == 0) goto L_0x00ef
            r17 = 0
            goto L_0x00ef
        L_0x0076:
            r18 = r9
            java.lang.String r9 = "tuya.m.my.shared.device.group.list"
            boolean r9 = r13.equals(r9)     // Catch:{ Exception -> 0x00ec }
            if (r9 == 0) goto L_0x00ef
            r17 = 1
            goto L_0x00ef
        L_0x0084:
            r18 = r9
            java.lang.String r9 = "tuya.m.my.group.device.list"
            boolean r9 = r13.equals(r9)     // Catch:{ Exception -> 0x00ec }
            if (r9 == 0) goto L_0x00ef
            r17 = 2
            goto L_0x00ef
        L_0x0091:
            r18 = r9
            java.lang.String r9 = "tuya.m.my.group.device.relation.list"
            boolean r9 = r13.equals(r9)     // Catch:{ Exception -> 0x00ec }
            if (r9 == 0) goto L_0x00ef
            r17 = 7
            goto L_0x00ef
        L_0x009e:
            r18 = r9
            java.lang.String r9 = "tuya.m.my.shared.device.list"
            boolean r9 = r13.equals(r9)     // Catch:{ Exception -> 0x00ec }
            if (r9 == 0) goto L_0x00ef
            r17 = 8
            goto L_0x00ef
        L_0x00ab:
            r18 = r9
            java.lang.String r9 = "tuya.m.device.sig.mesh.list"
            boolean r9 = r13.equals(r9)     // Catch:{ Exception -> 0x00ec }
            if (r9 == 0) goto L_0x00ef
            r17 = 5
            goto L_0x00ef
        L_0x00b8:
            r18 = r9
            java.lang.String r9 = "tuya.m.location.get"
            boolean r9 = r13.equals(r9)     // Catch:{ Exception -> 0x00ec }
            if (r9 == 0) goto L_0x00ef
            r17 = 3
            goto L_0x00ef
        L_0x00c5:
            r18 = r9
            java.lang.String r9 = "tuya.m.my.group.device.sort.list"
            boolean r9 = r13.equals(r9)     // Catch:{ Exception -> 0x00ec }
            if (r9 == 0) goto L_0x00ef
            r17 = 9
            goto L_0x00ef
        L_0x00d2:
            r18 = r9
            java.lang.String r9 = "tuya.m.my.group.mesh.list"
            boolean r9 = r13.equals(r9)     // Catch:{ Exception -> 0x00ec }
            if (r9 == 0) goto L_0x00ef
            r17 = 4
            goto L_0x00ef
        L_0x00df:
            r18 = r9
            java.lang.String r9 = "tuya.m.device.ref.info.my.list"
            boolean r9 = r13.equals(r9)     // Catch:{ Exception -> 0x00ec }
            if (r9 == 0) goto L_0x00ef
            r17 = 6
            goto L_0x00ef
        L_0x00ec:
            r0 = move-exception
            goto L_0x02b5
        L_0x00ef:
            switch(r17) {
                case 0: goto L_0x0257;
                case 1: goto L_0x022f;
                case 2: goto L_0x021d;
                case 3: goto L_0x01e2;
                case 4: goto L_0x01a9;
                case 5: goto L_0x0171;
                case 6: goto L_0x0120;
                case 7: goto L_0x0112;
                case 8: goto L_0x0104;
                case 9: goto L_0x00f8;
                default: goto L_0x00f2;
            }     // Catch:{ Exception -> 0x00ec }
        L_0x00f2:
            r17 = r10
            r19 = r14
            goto L_0x02a7
        L_0x00f8:
            java.lang.String r0 = r0.getResult()     // Catch:{ Exception -> 0x00ec }
            java.lang.Class<com.tuya.sdk.home.bean.DeviceSortResponseBean> r9 = com.tuya.sdk.home.bean.DeviceSortResponseBean.class
            java.util.List r9 = com.alibaba.fastjson.JSON.parseArray((java.lang.String) r0, r9)     // Catch:{ Exception -> 0x00ec }
            goto L_0x02ba
        L_0x0104:
            java.lang.String r0 = r0.getResult()     // Catch:{ Exception -> 0x00ec }
            java.util.List r11 = com.alibaba.fastjson.JSON.parseArray((java.lang.String) r0, r2)     // Catch:{ Exception -> 0x00ec }
            if (r11 != 0) goto L_0x02b8
            java.util.List r11 = java.util.Collections.EMPTY_LIST     // Catch:{ Exception -> 0x00ec }
            goto L_0x02b8
        L_0x0112:
            java.lang.String r14 = r0.getResult()     // Catch:{ Exception -> 0x00ec }
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x00ec }
            if (r0 == 0) goto L_0x02b8
            r14 = r21
            goto L_0x02b8
        L_0x0120:
            java.lang.String r9 = r0.getResult()     // Catch:{ Exception -> 0x016c }
            java.lang.Class<com.tuya.smart.sdk.bean.ProductBean> r13 = com.tuya.smart.sdk.bean.ProductBean.class
            java.util.List r6 = com.alibaba.fastjson.JSON.parseArray((java.lang.String) r9, r13)     // Catch:{ Exception -> 0x016c }
            if (r6 != 0) goto L_0x012e
            java.util.List r6 = java.util.Collections.EMPTY_LIST     // Catch:{ Exception -> 0x00ec }
        L_0x012e:
            java.util.Iterator r9 = r6.iterator()     // Catch:{ Exception -> 0x016c }
        L_0x0132:
            boolean r13 = r9.hasNext()     // Catch:{ Exception -> 0x016c }
            if (r13 == 0) goto L_0x014e
            java.lang.Object r13 = r9.next()     // Catch:{ Exception -> 0x016c }
            com.tuya.smart.sdk.bean.ProductBean r13 = (com.tuya.smart.sdk.bean.ProductBean) r13     // Catch:{ Exception -> 0x016c }
            r19 = r9
            r17 = r10
            long r9 = r0.getT()     // Catch:{ Exception -> 0x01a7 }
            r13.setResptime(r9)     // Catch:{ Exception -> 0x01a7 }
            r10 = r17
            r9 = r19
            goto L_0x0132
        L_0x014e:
            r17 = r10
            java.lang.String r0 = "Business"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a7 }
            r9.<init>()     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r10 = "product list: "
            r9.append(r10)     // Catch:{ Exception -> 0x01a7 }
            int r10 = r6.size()     // Catch:{ Exception -> 0x01a7 }
            r9.append(r10)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x01a7 }
            com.tuya.smart.android.common.utils.L.d(r0, r9)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x01d7
        L_0x016c:
            r0 = move-exception
            r17 = r10
            goto L_0x02b5
        L_0x0171:
            r17 = r10
            java.lang.String r9 = r0.getResult()     // Catch:{ Exception -> 0x01a7 }
            java.lang.Class<com.tuya.smart.sdk.bean.SigMeshBean> r10 = com.tuya.smart.sdk.bean.SigMeshBean.class
            java.util.List r8 = com.alibaba.fastjson.JSON.parseArray((java.lang.String) r9, r10)     // Catch:{ Exception -> 0x01a7 }
            if (r8 != 0) goto L_0x0181
            java.util.List r8 = java.util.Collections.EMPTY_LIST     // Catch:{ Exception -> 0x01a7 }
        L_0x0181:
            java.util.Iterator r9 = r8.iterator()     // Catch:{ Exception -> 0x01a4 }
        L_0x0185:
            boolean r10 = r9.hasNext()     // Catch:{ Exception -> 0x01a4 }
            if (r10 == 0) goto L_0x01a2
            java.lang.Object r10 = r9.next()     // Catch:{ Exception -> 0x01a4 }
            com.tuya.smart.sdk.bean.SigMeshBean r10 = (com.tuya.smart.sdk.bean.SigMeshBean) r10     // Catch:{ Exception -> 0x01a4 }
            r13 = r8
            r19 = r9
            long r8 = r0.getT()     // Catch:{ Exception -> 0x019f }
            r10.setResptime(r8)     // Catch:{ Exception -> 0x019f }
            r8 = r13
            r9 = r19
            goto L_0x0185
        L_0x019f:
            r0 = move-exception
            r8 = r13
            goto L_0x01de
        L_0x01a2:
            r13 = r8
            goto L_0x01d7
        L_0x01a4:
            r0 = move-exception
            r13 = r8
            goto L_0x01de
        L_0x01a7:
            r0 = move-exception
            goto L_0x01de
        L_0x01a9:
            r17 = r10
            java.lang.String r9 = r0.getResult()     // Catch:{ Exception -> 0x01db }
            java.lang.Class<com.tuya.smart.sdk.bean.BlueMeshBean> r10 = com.tuya.smart.sdk.bean.BlueMeshBean.class
            java.util.List r7 = com.alibaba.fastjson.JSON.parseArray((java.lang.String) r9, r10)     // Catch:{ Exception -> 0x01db }
            if (r7 != 0) goto L_0x01b9
            java.util.List r7 = java.util.Collections.EMPTY_LIST     // Catch:{ Exception -> 0x01a7 }
        L_0x01b9:
            java.util.Iterator r9 = r7.iterator()     // Catch:{ Exception -> 0x01db }
        L_0x01bd:
            boolean r10 = r9.hasNext()     // Catch:{ Exception -> 0x01db }
            if (r10 == 0) goto L_0x01d5
            java.lang.Object r10 = r9.next()     // Catch:{ Exception -> 0x01db }
            com.tuya.smart.sdk.bean.BlueMeshBean r10 = (com.tuya.smart.sdk.bean.BlueMeshBean) r10     // Catch:{ Exception -> 0x01db }
            r19 = r14
            long r13 = r0.getT()     // Catch:{ Exception -> 0x02a1 }
            r10.setResptime(r13)     // Catch:{ Exception -> 0x02a1 }
            r14 = r19
            goto L_0x01bd
        L_0x01d5:
            r19 = r14
        L_0x01d7:
            r10 = r17
            goto L_0x02b8
        L_0x01db:
            r0 = move-exception
            r19 = r14
        L_0x01de:
            r10 = r17
            goto L_0x02b5
        L_0x01e2:
            r17 = r10
            r19 = r14
            java.lang.String r9 = r0.getErrorCode()     // Catch:{ Exception -> 0x02a1 }
            java.lang.String r10 = "PERMISSION_DENIED"
            boolean r9 = android.text.TextUtils.equals(r9, r10)     // Catch:{ Exception -> 0x02a1 }
            if (r9 == 0) goto L_0x0200
            if (r1 == 0) goto L_0x01ff
            java.lang.String r9 = r0.getErrorCode()     // Catch:{ Exception -> 0x02a1 }
            java.lang.String r0 = r0.getErrorMsg()     // Catch:{ Exception -> 0x02a1 }
            r1.O000000o(r9, r0)     // Catch:{ Exception -> 0x02a1 }
        L_0x01ff:
            return
        L_0x0200:
            java.lang.String r0 = r0.getResult()     // Catch:{ Exception -> 0x02a1 }
            java.lang.Class<com.tuya.sdk.home.bean.HomeResponseBean> r9 = com.tuya.sdk.home.bean.HomeResponseBean.class
            java.lang.Object r0 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) r0, r9)     // Catch:{ Exception -> 0x02a1 }
            r9 = r0
            com.tuya.sdk.home.bean.HomeResponseBean r9 = (com.tuya.sdk.home.bean.HomeResponseBean) r9     // Catch:{ Exception -> 0x02a1 }
            if (r9 != 0) goto L_0x021a
            com.tuya.sdk.home.bean.HomeResponseBean r10 = new com.tuya.sdk.home.bean.HomeResponseBean     // Catch:{ Exception -> 0x0216 }
            r10.<init>()     // Catch:{ Exception -> 0x0216 }
            goto L_0x02a9
        L_0x0216:
            r0 = move-exception
            r10 = r9
            goto L_0x02a4
        L_0x021a:
            r10 = r9
            goto L_0x02a9
        L_0x021d:
            r17 = r10
            r19 = r14
            java.lang.String r0 = r0.getResult()     // Catch:{ Exception -> 0x02a1 }
            java.util.List r4 = com.alibaba.fastjson.JSON.parseArray((java.lang.String) r0, r2)     // Catch:{ Exception -> 0x02a1 }
            if (r4 != 0) goto L_0x02a7
            java.util.List r4 = java.util.Collections.EMPTY_LIST     // Catch:{ Exception -> 0x02a1 }
            goto L_0x02a7
        L_0x022f:
            r17 = r10
            r19 = r14
            java.lang.String r9 = r0.getResult()     // Catch:{ Exception -> 0x02a1 }
            java.util.List r15 = com.alibaba.fastjson.JSON.parseArray((java.lang.String) r9, r3)     // Catch:{ Exception -> 0x02a1 }
            if (r15 != 0) goto L_0x023f
            java.util.List r5 = java.util.Collections.EMPTY_LIST     // Catch:{ Exception -> 0x02a1 }
        L_0x023f:
            java.util.Iterator r9 = r15.iterator()     // Catch:{ Exception -> 0x02a1 }
        L_0x0243:
            boolean r10 = r9.hasNext()     // Catch:{ Exception -> 0x02a1 }
            if (r10 == 0) goto L_0x02a7
            java.lang.Object r10 = r9.next()     // Catch:{ Exception -> 0x02a1 }
            com.tuya.smart.interior.device.bean.GroupRespBean r10 = (com.tuya.smart.interior.device.bean.GroupRespBean) r10     // Catch:{ Exception -> 0x02a1 }
            long r13 = r0.getT()     // Catch:{ Exception -> 0x02a1 }
            r10.setResptime(r13)     // Catch:{ Exception -> 0x02a1 }
            goto L_0x0243
        L_0x0257:
            r17 = r10
            r19 = r14
            boolean r9 = r0.isSuccess()     // Catch:{ Exception -> 0x02a1 }
            if (r9 == 0) goto L_0x0285
            java.lang.String r9 = r0.getResult()     // Catch:{ Exception -> 0x02a1 }
            java.util.List r5 = com.alibaba.fastjson.JSON.parseArray((java.lang.String) r9, r3)     // Catch:{ Exception -> 0x02a1 }
            if (r5 != 0) goto L_0x026d
            java.util.List r5 = java.util.Collections.EMPTY_LIST     // Catch:{ Exception -> 0x02a1 }
        L_0x026d:
            java.util.Iterator r9 = r5.iterator()     // Catch:{ Exception -> 0x02a1 }
        L_0x0271:
            boolean r10 = r9.hasNext()     // Catch:{ Exception -> 0x02a1 }
            if (r10 == 0) goto L_0x02a7
            java.lang.Object r10 = r9.next()     // Catch:{ Exception -> 0x02a1 }
            com.tuya.smart.interior.device.bean.GroupRespBean r10 = (com.tuya.smart.interior.device.bean.GroupRespBean) r10     // Catch:{ Exception -> 0x02a1 }
            long r13 = r0.getT()     // Catch:{ Exception -> 0x02a1 }
            r10.setResptime(r13)     // Catch:{ Exception -> 0x02a1 }
            goto L_0x0271
        L_0x0285:
            java.lang.String r9 = r0.getErrorCode()     // Catch:{ Exception -> 0x02a1 }
            java.lang.String r10 = "USER_SESSION_INVALID"
            boolean r9 = android.text.TextUtils.equals(r9, r10)     // Catch:{ Exception -> 0x02a1 }
            if (r9 != 0) goto L_0x029d
            java.lang.String r0 = r0.getErrorCode()     // Catch:{ Exception -> 0x02a1 }
            java.lang.String r9 = "USER_SESSION_LOSS"
            boolean r0 = android.text.TextUtils.equals(r0, r9)     // Catch:{ Exception -> 0x02a1 }
            if (r0 == 0) goto L_0x02a7
        L_0x029d:
            com.tuya.smart.android.network.TuyaSmartNetWork.needLogin()     // Catch:{ Exception -> 0x02a1 }
            goto L_0x02a7
        L_0x02a1:
            r0 = move-exception
            r10 = r17
        L_0x02a4:
            r14 = r19
            goto L_0x02b5
        L_0x02a7:
            r10 = r17
        L_0x02a9:
            r9 = r18
            r14 = r19
            goto L_0x02ba
        L_0x02ae:
            r0 = move-exception
            r18 = r9
            r17 = r10
            r19 = r14
        L_0x02b5:
            r0.printStackTrace()
        L_0x02b8:
            r9 = r18
        L_0x02ba:
            r13 = r16
            goto L_0x0049
        L_0x02be:
            r18 = r9
            r17 = r10
            r19 = r14
            r12.setDeviceRespBeen(r4)
            r12.setGroupBeen(r5)
            r12.setMeshBeen(r7)
            r12.setSigMeshBeen(r8)
            r12.setProductBeen(r6)
            r12.setDeviceRespShareList(r11)
            r12.setGroupRespShareList(r15)
            r9 = r17
            r12.setHomeResponseBean(r9)
            r12.setRelation(r14)
            r8 = r18
            r12.setDeviceSortResponseBeans(r8)
            r1.O000000o(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o0o000o0o.O000000o(java.util.ArrayList, com.tuya.smart.common.o0o0oo000):void");
    }

    private ApiBean O00000Oo() {
        return new ApiBean(a.E("tuya.m.my.shared.device.group.list", "2.0", true));
    }

    private ApiBean O00000o() {
        return new ApiBean(a.E(O00000Oo, "2.0", true));
    }

    private ApiBean O00000o0() {
        return new ApiBean(a.E(O000000o, "1.0", true));
    }

    private ApiBean O00000oO() {
        return new ApiBean(a.E(O00000oO, "2.0", true));
    }

    private ApiBean O00000oo() {
        return new ApiBean(a.E("tuya.m.device.sig.mesh.list", "1.0", true));
    }

    private ApiBean O0000O0o() {
        return new ApiBean(a.E("tuya.m.my.group.mesh.list", "1.0", true));
    }

    private ApiBean O0000OOo() {
        ApiParams E = a.E(O00000oo, "4.0", true);
        E.putPostData("zigbeeGroup", Boolean.TRUE);
        return new ApiBean(E);
    }

    public ApiBean O000000o(long j) {
        ApiParams apiParams = new ApiParams("tuya.m.location.get", "2.0");
        apiParams.putPostData(TuyaApiParams.KEY_GID, Long.valueOf(j));
        return new ApiBean(apiParams);
    }

    public void O000000o(long j, final o0o0oo000<TuyaListDataBean> o0o0oo000) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(O00000o0());
        arrayList.add(O0000OOo());
        O000000o(j, (List<ApiBean>) arrayList, (Business.ResultListener<ArrayList<ApiResponeBean>>) new Business.ResultListener<ArrayList<ApiResponeBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<ApiResponeBean> arrayList, String str) {
                o0o0oo000 o0o0oo000 = o0o0oo000;
                if (o0o0oo000 != null) {
                    o0o0oo000.O000000o(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, final ArrayList<ApiResponeBean> arrayList, String str) {
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        o0o000o0o.this.O000000o((ArrayList<ApiResponeBean>) arrayList, (o0o0oo000<TuyaListDataBean>) o0o0oo000);
                    }
                });
            }
        });
    }

    public void O000000o(long j, List<ApiBean> list, Business.ResultListener<ArrayList<ApiResponeBean>> resultListener) {
        ApiParams apiParams = new ApiParams("tuya.m.api.batch.invoke", "1.0");
        apiParams.putPostData("apis", list);
        apiParams.setGid(j);
        apiParams.setSessionRequire(true);
        asyncArrayList(apiParams, ApiResponeBean.class, resultListener);
    }

    public void O00000Oo(long j, final o0o0oo000<TuyaListDataBean> o0o0oo000) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(O00000oO());
        arrayList.add(O000000o(j + ""));
        arrayList.add(O00000o0());
        arrayList.add(O0000O0o());
        arrayList.add(O00000oo());
        arrayList.add(O00000o());
        arrayList.add(O000000o(j));
        arrayList.add(O0000OOo());
        arrayList.add(O000000o());
        arrayList.add(O00000Oo());
        O000000o(j, (List<ApiBean>) arrayList, (Business.ResultListener<ArrayList<ApiResponeBean>>) new Business.ResultListener<ArrayList<ApiResponeBean>>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, ArrayList<ApiResponeBean> arrayList, String str) {
                o0o0oo000 o0o0oo000 = o0o0oo000;
                if (o0o0oo000 != null) {
                    o0o0oo000.O000000o(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, final ArrayList<ApiResponeBean> arrayList, String str) {
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        AnonymousClass2 r0 = AnonymousClass2.this;
                        o0o000o0o.this.O000000o((ArrayList<ApiResponeBean>) arrayList, (o0o0oo000<TuyaListDataBean>) o0o0oo000);
                    }
                });
            }
        });
    }
}
