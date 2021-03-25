package com.tuya.smart.android.device;

import com.tuya.smart.android.device.callback.LinkCloseCallback;
import com.tuya.smart.android.device.callback.PackageCallback;
import com.tuya.smart.android.device.callback.ReadResponseDataCallback;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.android.hardware.bean.TuyaFrame;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TuyaNetworkInterface {
    public HashMap<String, LinkCloseCallback> linkCloseCbMap;
    public List<PackageCallback> packageCallbackList;
    public HashMap<String, ReadResponseDataCallback> readResDataCbMap;

    public static class SingletonHolder {
        public static final TuyaNetworkInterface instance = new TuyaNetworkInterface();
    }

    public TuyaNetworkInterface() {
        this.readResDataCbMap = new HashMap<>();
        this.linkCloseCbMap = new HashMap<>();
        this.packageCallbackList = new LinkedList();
        TuyaNetworkApi.registerNativeCallback(this, new String[]{"getGWBean", "OnLinkCloseCallback", "OnResponseDataCallback"}, new String[]{"(Lcom/tuya/smart/android/hardware/bean/HgwBean;)V", "(Ljava/lang/String;)V", "(Ljava/lang/String;Lcom/tuya/smart/android/hardware/bean/TuyaFrame;)V"});
    }

    private void OnLinkCloseCallback(String str) {
        LinkCloseCallback linkCloseCallback = this.linkCloseCbMap.get(str);
        if (linkCloseCallback != null) {
            linkCloseCallback.OnLinkCloseCallback(str);
        }
    }

    private void OnResponseDataCallback(String str, TuyaFrame tuyaFrame) {
        if (this.readResDataCbMap.get(str) != null) {
            this.readResDataCbMap.get(str).OnResponseDataCallback(str, tuyaFrame);
        }
    }

    public static int SendBroadcast(byte[] bArr, int i, int i2, boolean z) {
        return TuyaNetworkApi.SendBroadcast(bArr, i, i2, z);
    }

    public static void closeAllConnection() {
        TuyaNetworkApi.closeAllConnection();
    }

    public static int connectDevice(String str) {
        return TuyaNetworkApi.connectDevice(str);
    }

    public static void enableDebug(boolean z) {
        TuyaNetworkApi.enableDebug(z);
    }

    private void getGWBean(HgwBean hgwBean) {
        for (PackageCallback gWBean : this.packageCallbackList) {
            gWBean.getGWBean(hgwBean);
        }
    }

    public static TuyaNetworkInterface getInstance() {
        return SingletonHolder.instance;
    }

    public static void listenUDP(int i) {
        TuyaNetworkApi.listenUDP(i);
    }

    public static int sendBytes(byte[] bArr, int i, int i2, String str) {
        return TuyaNetworkApi.sendBytes(bArr, i, i2, str);
    }

    public static void setSecurityContent(byte[] bArr) {
        TuyaNetworkApi.setSecurityContent(bArr);
    }

    public static void shutDownUDPListen() {
        TuyaNetworkApi.shutDownUDPListen();
    }

    public static void stopBroadcast() {
        TuyaNetworkApi.stopBroadcast();
    }

    public void addLinkCloseCallback(String str, LinkCloseCallback linkCloseCallback) {
        this.linkCloseCbMap.put(str, linkCloseCallback);
    }

    public void addPackageCallback(PackageCallback packageCallback) {
        this.packageCallbackList.add(packageCallback);
    }

    public void addReadResDataCallback(String str, ReadResponseDataCallback readResponseDataCallback) {
        this.readResDataCbMap.put(str, readResponseDataCallback);
    }

    public byte[] encryptAesDataForUDP(String str) {
        return TuyaNetworkApi.encryptAesDataForUDP(str);
    }

    public void removeLinkCloseCallback(String str) {
        this.linkCloseCbMap.remove(str);
    }

    public void removePackageCallback(PackageCallback packageCallback) {
        this.packageCallbackList.remove(packageCallback);
    }

    public void reomveReadResDataCallback(String str) {
        this.readResDataCbMap.remove(str);
    }
}
