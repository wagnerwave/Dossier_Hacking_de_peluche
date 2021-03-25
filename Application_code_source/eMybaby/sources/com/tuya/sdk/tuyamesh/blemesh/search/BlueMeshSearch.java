package com.tuya.sdk.tuyamesh.blemesh.search;

import a.a.a.a.a;
import android.content.Context;
import android.os.ParcelUuid;
import android.text.TextUtils;
import com.tuya.sdk.sigmesh.bean.ScanRecord;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.blescan.FilterTypeEnum;
import com.tuya.smart.blescan.ITuyaBleScanner;
import com.tuya.smart.blescan.LeScanResponse;
import com.tuya.smart.blescan.ScanFilter;
import com.tuya.smart.blescan.ScanLeBean;
import com.tuya.smart.blescan.ScanRequest;
import com.tuya.smart.blescan.TuyaBleScanner;
import com.tuya.smart.common.o00oo00o00;
import com.tuya.smart.common.o00oo00o0o;
import com.tuya.smart.common.o00oo00oo0;
import com.tuya.smart.common.o00oo0o000;
import com.tuya.smart.common.o00oo0oo00;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BlueMeshSearch implements LeScanResponse {
    public static final int MODE_AUTO_CONNECT_MESH = 1;
    public static final int MODE_AUTO_CONNECT_MESH_WITHOUT_MAC = 2;
    public static final int MODE_SCAN_MESH = 0;
    public static final String TAG = "BlueMeshSearch";
    public static final int WHAT_TIME_OUT = 1;
    public ITuyaBleScanner mBleScanner;
    public String mMac;
    public int mMeshAddress = -1;
    public String mMeshName;
    public ScanRequest mScanRequest;
    public o00oo00o00 mSearchRespone;
    public boolean mStop;
    public List<ParcelUuid> mUuids = new ArrayList();
    public int mode;

    public BlueMeshSearch(Context context) {
        this.mBleScanner = TuyaBleScanner.newInstance(context);
    }

    private boolean onLeScanFilter(SearchDeviceBean searchDeviceBean) {
        int i = this.mode;
        if (i == 0) {
            if (!TextUtils.isEmpty(this.mMeshName)) {
                return TextUtils.equals(this.mMeshName, searchDeviceBean.getMeshName()) || TextUtils.equals(o00oo0o000.O000000o, searchDeviceBean.getMeshName());
            }
            if (searchDeviceBean.getDevice() != null) {
                StringBuilder n = a.n("name:");
                n.append(searchDeviceBean.getDevice().getName());
                o00oo0oo00.O00000Oo(TAG, n.toString());
                ScanRecord parseFromBytes = ScanRecord.parseFromBytes(searchDeviceBean.getScanRecord());
                if (parseFromBytes == null || parseFromBytes.getServiceUuids() == null || !parseFromBytes.getServiceUuids().containsAll(this.mUuids)) {
                    return false;
                }
                if (searchDeviceBean instanceof SigMeshSearchDeviceBean) {
                    ((SigMeshSearchDeviceBean) searchDeviceBean).setScanRecordBean(parseFromBytes);
                }
                return true;
            }
        } else if (i == 1) {
            return TextUtils.equals(this.mMeshName, searchDeviceBean.getMeshName()) && TextUtils.equals(this.mMac, searchDeviceBean.getMacAdress());
        } else {
            if (i == 2 && (this.mMeshAddress == -1 || searchDeviceBean.getMeshAddress() == this.mMeshAddress)) {
                return TextUtils.equals(this.mMeshName, searchDeviceBean.getMeshName());
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onDeviceFounded(com.tuya.smart.blescan.ScanLeBean r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.mStop     // Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            com.tuya.smart.common.o00oo00o00 r0 = r1.mSearchRespone     // Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x0014
            com.tuya.smart.common.o00oo00o00 r0 = r1.mSearchRespone     // Catch:{ all -> 0x0016 }
            java.lang.Object r2 = r2.parseObject     // Catch:{ all -> 0x0016 }
            com.tuya.smart.android.blemesh.bean.SearchDeviceBean r2 = (com.tuya.smart.android.blemesh.bean.SearchDeviceBean) r2     // Catch:{ all -> 0x0016 }
            r0.O000000o(r2)     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r1)
            return
        L_0x0016:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.sdk.tuyamesh.blemesh.search.BlueMeshSearch.onDeviceFounded(com.tuya.smart.blescan.ScanLeBean):void");
    }

    public void onScanCancel() {
        o00oo0oo00.O00000Oo(TAG, "onSearchCanceled");
        o00oo00o00 o00oo00o00 = this.mSearchRespone;
        if (o00oo00o00 != null) {
            o00oo00o00.O000000o();
        }
    }

    public void onScanStart() {
    }

    public void onScanStop() {
        o00oo0oo00.O00000Oo(TAG, "onSearchStopped");
        o00oo00o00 o00oo00o00 = this.mSearchRespone;
        if (o00oo00o00 != null) {
            o00oo00o00.O00000Oo();
        }
    }

    public void searchDeviceConnected(String str, int i, long j, o00oo00o00 o00oo00o00) {
        this.mStop = false;
        this.mMeshName = str;
        this.mMeshAddress = i;
        this.mUuids.clear();
        this.mode = 2;
        ScanRequest.Builder scanFilter = new ScanRequest.Builder().setDuration(j).setType(FilterTypeEnum.ADD).setResponse(this).setScanFilter(new ScanFilter() {
            public boolean filter(ScanLeBean scanLeBean) {
                SearchDeviceBean O000000o = o00oo00o0o.O000000o(scanLeBean.device, scanLeBean.scanRecord, scanLeBean.rssi);
                scanLeBean.parseObject = O000000o;
                if (O000000o == null) {
                    return false;
                }
                if (BlueMeshSearch.this.mMeshAddress == -1 || O000000o.getMeshAddress() == BlueMeshSearch.this.mMeshAddress) {
                    return TextUtils.equals(BlueMeshSearch.this.mMeshName, O000000o.getMeshName());
                }
                return false;
            }

            public boolean filterOnly(ScanLeBean scanLeBean) {
                return false;
            }
        });
        this.mSearchRespone = o00oo00o00;
        ScanRequest build = scanFilter.build();
        this.mScanRequest = build;
        this.mBleScanner.addScanRequest(build);
    }

    public void searchDeviceConnected(String str, long j, String str2, o00oo00o00 o00oo00o00) {
        this.mStop = false;
        this.mMeshName = str;
        this.mMac = str2;
        this.mode = 1;
        this.mUuids.clear();
        ScanRequest.Builder scanFilter = new ScanRequest.Builder().setDuration(j).setType(FilterTypeEnum.ADD).setResponse(this).setScanFilter(new ScanFilter() {
            public boolean filter(ScanLeBean scanLeBean) {
                SearchDeviceBean O000000o = o00oo00o0o.O000000o(scanLeBean.device, scanLeBean.scanRecord, scanLeBean.rssi);
                if (O000000o == null) {
                    return false;
                }
                scanLeBean.parseObject = O000000o;
                return TextUtils.equals(BlueMeshSearch.this.mMeshName, O000000o.getMeshName()) && TextUtils.equals(BlueMeshSearch.this.mMac, O000000o.getMacAdress());
            }

            public boolean filterOnly(ScanLeBean scanLeBean) {
                return false;
            }
        });
        this.mSearchRespone = o00oo00o00;
        ScanRequest build = scanFilter.build();
        this.mScanRequest = build;
        this.mBleScanner.addScanRequest(build);
    }

    public void searchDeviceUnConnect(String str, long j, o00oo00o00 o00oo00o00) {
        this.mStop = false;
        this.mode = 0;
        this.mMeshName = str;
        this.mUuids.clear();
        ScanRequest.Builder scanFilter = new ScanRequest.Builder().setDuration(j).setType(FilterTypeEnum.ADD).setResponse(this).setScanFilter(new ScanFilter() {
            public boolean filter(ScanLeBean scanLeBean) {
                SearchDeviceBean O000000o = o00oo00o0o.O000000o(scanLeBean.device, scanLeBean.scanRecord, scanLeBean.rssi);
                if (O000000o == null) {
                    return false;
                }
                if (!TextUtils.equals(BlueMeshSearch.this.mMeshName, O000000o.getMeshName()) && !TextUtils.equals(o00oo0o000.O000000o, O000000o.getMeshName())) {
                    return false;
                }
                scanLeBean.parseObject = O000000o;
                return true;
            }

            public boolean filterOnly(ScanLeBean scanLeBean) {
                return false;
            }
        });
        this.mSearchRespone = o00oo00o00;
        ScanRequest build = scanFilter.build();
        this.mScanRequest = build;
        this.mBleScanner.addScanRequest(build);
    }

    public void searchDeviceUnConnect(String str, UUID[] uuidArr, long j, o00oo00o00 o00oo00o00) {
        if (!TextUtils.isEmpty(str)) {
            searchDeviceUnConnect(str, j, o00oo00o00);
        } else {
            searchDeviceUnConnect(uuidArr, j, o00oo00o00);
        }
    }

    public void searchDeviceUnConnect(UUID[] uuidArr, long j, o00oo00o00 o00oo00o00) {
        this.mStop = false;
        this.mode = 0;
        this.mUuids.clear();
        if (uuidArr != null) {
            for (UUID parcelUuid : uuidArr) {
                this.mUuids.add(new ParcelUuid(parcelUuid));
            }
        }
        ScanRequest.Builder scanFilter = new ScanRequest.Builder().setDuration(j).setType(FilterTypeEnum.ADD).setResponse(this).setScanFilter(new ScanFilter() {
            public boolean filter(ScanLeBean scanLeBean) {
                if (scanLeBean.device != null) {
                    StringBuilder n = a.n("name:");
                    n.append(scanLeBean.device.getName());
                    n.append(DpTimerBean.FILL);
                    n.append(scanLeBean.device.getAddress());
                    o00oo0oo00.O00000Oo(BlueMeshSearch.TAG, n.toString());
                    ScanRecord parseFromBytes = ScanRecord.parseFromBytes(scanLeBean.scanRecord);
                    if (!(parseFromBytes == null || parseFromBytes.getServiceUuids() == null || !parseFromBytes.getServiceUuids().containsAll(BlueMeshSearch.this.mUuids))) {
                        StringBuilder n2 = a.n("found name:");
                        n2.append(scanLeBean.device.getAddress());
                        o00oo0oo00.O00000Oo(BlueMeshSearch.TAG, n2.toString());
                        SearchDeviceBean O000000o = o00oo00oo0.O000000o(scanLeBean.device, scanLeBean.scanRecord, scanLeBean.rssi);
                        ((SigMeshSearchDeviceBean) O000000o).setScanRecordBean(parseFromBytes);
                        scanLeBean.parseObject = O000000o;
                        return true;
                    }
                }
                return false;
            }

            public boolean filterOnly(ScanLeBean scanLeBean) {
                return false;
            }
        });
        this.mSearchRespone = o00oo00o00;
        ScanRequest build = scanFilter.build();
        this.mScanRequest = build;
        this.mBleScanner.addScanRequest(build);
    }

    public void stopSearch() {
        o00oo0oo00.O00000Oo(TAG, "stopSearch");
        if (!this.mStop) {
            this.mStop = true;
            this.mBleScanner.removeScanRequest(this.mScanRequest);
        }
    }
}
