package com.tuya.smart.common;

import a.e.a.a.o.j.i;
import com.tuya.sdk.sigmesh.action.SigMeshAction$1;
import com.tuya.sdk.sigmesh.action.SigMeshAction$2;
import com.tuya.sdk.sigmesh.action.SigMeshAction$3;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0o0o0o;

public class ooo0oo000 extends o00o0o0o0o {
    public CommandBean O000000o(String str, byte[] bArr, CommandBean.CommandType commandType) {
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.type = commandType;
        newInstance.serviceUUID = o00o00o000.O00000oO;
        newInstance.macAddress = str;
        newInstance.characteristicUUID = o00o00o000.O00000oo;
        newInstance.data = bArr;
        return newInstance;
    }

    public void O000000o(CommandBean commandBean, int i, o00o0o0o0o.O000000o o000000o) {
        commandBean.data = O000000o(i, commandBean.data);
        O000000o(commandBean, o000000o);
    }

    public void O000000o(CommandBean commandBean, o00o0o0o0o.O000000o o000000o) {
        SigMeshAction$1 sigMeshAction$1 = new SigMeshAction$1(this, o000000o);
        byte[] bArr = commandBean.data;
        int O00000Oo = oo0o0oooo.O000000o().O00000Oo();
        int length = ((O00000Oo - 1) + bArr.length) / O00000Oo;
        if (length > 1) {
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int min = Math.min(bArr.length - i, O00000Oo);
                byte[] bArr2 = new byte[min];
                System.arraycopy(bArr, i, bArr2, 0, min);
                i += min;
                CommandBean commandBean2 = new CommandBean();
                commandBean2.data = bArr2;
                commandBean2.characteristicUUID = commandBean.characteristicUUID;
                commandBean2.macAddress = commandBean.macAddress;
                commandBean2.serviceUUID = commandBean.serviceUUID;
                CommandBean.CommandType commandType = commandBean.type;
                commandBean2.type = commandType;
                if (commandType == CommandBean.CommandType.WRITE_NO_RESPONSE) {
                    O00000Oo(commandBean2, new SigMeshAction$2(this));
                } else {
                    O000000o(commandBean2, (i) new SigMeshAction$3(this));
                }
            }
            o000000o.O00000Oo();
        } else if (commandBean.type == CommandBean.CommandType.WRITE_NO_RESPONSE) {
            O00000Oo(commandBean, sigMeshAction$1);
        } else {
            O000000o(commandBean, (i) sigMeshAction$1);
        }
    }

    public byte[] O000000o(int i, byte[] bArr) {
        int i2;
        int i3 = i - 1;
        int length = (bArr.length + i3) / i;
        byte b2 = bArr[0];
        if (length <= 1) {
            return bArr;
        }
        byte[] bArr2 = new byte[((bArr.length + length) - 1)];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (i6 == 0) {
                i2 = Math.min(bArr.length - i4, i);
                System.arraycopy(bArr, i4, bArr2, i5, i2);
                bArr2[0] = (byte) (b2 | 64);
            } else {
                if (i6 == length - 1) {
                    i2 = Math.min(bArr.length - i4, i);
                    bArr2[i5] = (byte) (b2 | 192);
                } else {
                    i2 = Math.min(bArr.length - i4, i3);
                    bArr2[i5] = (byte) (b2 | 128);
                }
                System.arraycopy(bArr, i4, bArr2, i5 + 1, i2);
            }
            i4 += i2;
            i5 += i;
        }
        return bArr2;
    }

    public CommandBean O00000Oo(String str, byte[] bArr, CommandBean.CommandType commandType) {
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.type = commandType;
        newInstance.serviceUUID = o00o00o000.O0000OOo;
        newInstance.macAddress = str;
        newInstance.characteristicUUID = o00o00o000.O0000Oo0;
        newInstance.data = bArr;
        return newInstance;
    }
}
