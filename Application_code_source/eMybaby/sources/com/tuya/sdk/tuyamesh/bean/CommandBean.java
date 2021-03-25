package com.tuya.sdk.tuyamesh.bean;

import a.a.a.a.a;
import com.tuya.smart.common.o00oo0o00o;
import java.util.UUID;

public class CommandBean {
    public UUID characteristicUUID;
    public byte[] data;
    public int delay;
    public String macAddress;
    public UUID serviceUUID;
    public Object tag;
    public CommandType type;

    public enum CommandType {
        READ,
        WRITE,
        WRITE_NO_RESPONSE,
        ENABLE_NOTIFY,
        DISABLE_NOTIFY
    }

    public CommandBean() {
        this((UUID) null, (UUID) null, CommandType.WRITE);
    }

    public CommandBean(UUID uuid, UUID uuid2, CommandType commandType) {
        this(uuid, uuid2, commandType, (byte[]) null);
    }

    public CommandBean(UUID uuid, UUID uuid2, CommandType commandType, byte[] bArr) {
        this(uuid, uuid2, commandType, bArr, (Object) null);
    }

    public CommandBean(UUID uuid, UUID uuid2, CommandType commandType, byte[] bArr, Object obj) {
        this.serviceUUID = uuid;
        this.characteristicUUID = uuid2;
        this.type = commandType;
        this.data = bArr;
        this.tag = obj;
    }

    public static CommandBean newInstance() {
        return new CommandBean();
    }

    public void clear() {
        this.serviceUUID = null;
        this.characteristicUUID = null;
        this.data = null;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public String toString() {
        byte[] bArr = this.data;
        String O00000Oo = bArr != null ? o00oo0o00o.O00000Oo(bArr, ",") : "";
        StringBuilder n = a.n("{ tag : ");
        n.append(this.tag);
        n.append(", type : ");
        n.append(this.type);
        n.append(" characteristicUUID :");
        n.append(this.characteristicUUID.toString());
        n.append(" data: ");
        n.append(O00000Oo);
        n.append(" delay :");
        n.append(this.delay);
        n.append("}");
        return n.toString();
    }
}
