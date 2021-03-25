package com.tuya.smart.common;

import a.e.a.a.a;
import a.e.a.a.o.j.c;
import a.e.a.a.o.j.d;
import a.e.a.a.o.j.e;
import a.e.a.a.o.j.h;
import a.e.a.a.o.j.i;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.sdk.tuyamesh.blemesh.action.BlueMeshAction$1;
import java.util.UUID;

public class o00o0o0o0o {

    public interface O000000o {
        void O000000o(String str, String str2);

        void O00000Oo();
    }

    private a O000000o() {
        return o00o0o0o00.O000000o().O00000Oo();
    }

    private void O000000o(String str, UUID uuid, UUID uuid2, d dVar) {
        O000000o().j(str, uuid, uuid2, dVar);
    }

    private void O000000o(String str, UUID uuid, UUID uuid2, e eVar) {
        O000000o().k(str, uuid, uuid2, eVar);
    }

    private void O000000o(String str, UUID uuid, UUID uuid2, h hVar) {
        O000000o().c(str, uuid, uuid2, hVar);
    }

    private void O000000o(String str, UUID uuid, UUID uuid2, byte[] bArr, i iVar) {
        O000000o().a(str, uuid, uuid2, bArr, iVar);
    }

    private void O00000Oo(String str, UUID uuid, UUID uuid2, byte[] bArr, i iVar) {
        O000000o().h(str, uuid, uuid2, bArr, iVar);
    }

    public void O000000o(CommandBean commandBean) {
        O000000o(commandBean.macAddress, commandBean.serviceUUID, commandBean.characteristicUUID, commandBean.data, new BlueMeshAction$1(this));
    }

    public void O000000o(CommandBean commandBean, d dVar) {
        O000000o(commandBean.macAddress, commandBean.serviceUUID, commandBean.characteristicUUID, dVar);
    }

    public void O000000o(CommandBean commandBean, e eVar) {
        O000000o().k(commandBean.macAddress, commandBean.serviceUUID, commandBean.characteristicUUID, eVar);
    }

    public void O000000o(CommandBean commandBean, h hVar) {
        O000000o(commandBean.macAddress, commandBean.serviceUUID, commandBean.characteristicUUID, hVar);
    }

    public void O000000o(CommandBean commandBean, i iVar) {
        O000000o(commandBean.macAddress, commandBean.serviceUUID, commandBean.characteristicUUID, commandBean.data, iVar);
    }

    public void O000000o(String str, int i, c cVar) {
        O000000o().e(str, i, cVar);
    }

    public void O00000Oo(CommandBean commandBean) {
        O00000Oo(commandBean.macAddress, commandBean.serviceUUID, commandBean.characteristicUUID, commandBean.data, (i) null);
    }

    public void O00000Oo(CommandBean commandBean, i iVar) {
        O00000Oo(commandBean.macAddress, commandBean.serviceUUID, commandBean.characteristicUUID, commandBean.data, iVar);
    }
}
