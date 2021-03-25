package com.tuya.smart.common;

import a.e.a.a.r.a;
import a.j.a.b;
import com.tuya.sdk.bluemesh.mesh.utils.BlueMeshCallback;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshGroup;
import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.android.blemesh.callback.ILocalQueryGroupDevCallback;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.sdk.api.IGroupListener;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.enums.TYDevicePublishModeEnum;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class O0OOO0 implements ITuyaBlueMeshGroup {
    public static final String O000000o = "TuyaBlueMeshLocalGroup";
    public O0OOO00 O00000Oo;
    public ITuyaBlueMesh O00000o;
    public final O0Oo0o0 O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public LinkedList<O0Oo00> O0000OOo = new LinkedList<>();

    public O0OOO0(String str, String str2, String str3) {
        this.O00000o = new O000OO00(str2);
        this.O00000Oo = new O0OOO00();
        this.O00000o0 = new O0Oo0o0();
        this.O00000oO = str;
        this.O00000oo = str2;
        this.O0000O0o = str3;
    }

    public void addDevice(String str, final IResultCallback iResultCallback) {
        final DeviceBean meshSubDevBean = this.O00000o.getMeshSubDevBean(str);
        if (meshSubDevBean != null) {
            String O000000o2 = OO00o00.O000000o(meshSubDevBean.getCategory());
            o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000oo);
            if (O00000Oo2 != null && meshSubDevBean.getIsLocalOnline().booleanValue()) {
                this.O00000Oo.O000000o(O00000Oo2, O000000o2, meshSubDevBean.getNodeId(), this.O00000oO, new IResultCallback() {
                    public void onError(String str, String str2) {
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onError(str, str2);
                        }
                    }

                    public void onSuccess() {
                        O0OOO0.this.O0000OOo.add(new BlueMeshCallback(meshSubDevBean.getNodeId(), BlueMeshCallback.CommandType.GROUP, new IResultCallback() {
                            public void onError(String str, String str2) {
                                iResultCallback.onError(str, str2);
                            }

                            public void onSuccess() {
                                iResultCallback.onSuccess();
                            }
                        }));
                    }
                });
            } else if (this.O00000o.isCloudOnline()) {
                this.O00000o.publishRawData(this.O00000Oo.O000000o(a.c(O000000o2), meshSubDevBean.getNodeId(), this.O00000oO), new IResultCallback() {
                    public void onError(String str, String str2) {
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onError(str, str2);
                        }
                    }

                    public void onSuccess() {
                        O0OOO0.this.O0000OOo.add(new BlueMeshCallback(meshSubDevBean.getNodeId(), BlueMeshCallback.CommandType.GROUP, new IResultCallback() {
                            public void onError(String str, String str2) {
                                iResultCallback.onError(str, str2);
                            }

                            public void onSuccess() {
                                iResultCallback.onSuccess();
                            }
                        }));
                    }
                });
            } else if (iResultCallback != null) {
                iResultCallback.onError("13006", "mesh_off_line");
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("11002", "device is remove");
        }
    }

    public void dismissGroup(final IResultCallback iResultCallback) {
        String O000000o2 = OO00o00.O000000o(this.O0000O0o);
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000oo);
        if (O00000Oo2 != null) {
            this.O00000Oo.O000000o(O00000Oo2, O000000o2, this.O00000oO, new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    iResultCallback.onSuccess();
                }
            });
        } else if (this.O00000o.isCloudOnline()) {
            this.O00000o.publishRawData(this.O00000Oo.O00000Oo(a.c(O000000o2), this.O00000oO), new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    iResultCallback.onSuccess();
                }
            });
        } else {
            iResultCallback.onError("13006", "mesh_off_line");
        }
    }

    public void onDestroy() {
        this.O00000o.onDestroy();
        Iterator it = this.O0000OOo.iterator();
        while (it.hasNext()) {
            O0Oo00 o0Oo00 = (O0Oo00) it.next();
            if (o0Oo00 != null) {
                o0Oo00.O000000o();
            }
        }
    }

    public void publishDps(String str, IResultCallback iResultCallback) {
    }

    public void publishDps(String str, TYDevicePublishModeEnum tYDevicePublishModeEnum, IResultCallback iResultCallback) {
    }

    public void queryDeviceInGroupByLocal(final ILocalQueryGroupDevCallback iLocalQueryGroupDevCallback) {
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000oo);
        DpsParseBean dpsParseBean = new DpsParseBean();
        dpsParseBean.setOpCode(b.BLE_GATT_OP_CTRL_E0.f());
        int parseInt = Integer.parseInt(this.O00000oO, 16);
        dpsParseBean.setParams(new byte[]{-1, -1, (byte) (parseInt & 255), (byte) ((parseInt & 65535) >> 8)});
        if (O00000Oo2 != null) {
            this.O00000o0.O000000o(O00000Oo2, this.O00000oO, "FFFF", dpsParseBean, new IResultCallback() {
                public void onError(String str, String str2) {
                    ILocalQueryGroupDevCallback iLocalQueryGroupDevCallback = iLocalQueryGroupDevCallback;
                    if (iLocalQueryGroupDevCallback != null) {
                        iLocalQueryGroupDevCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    O0OOO0.this.O0000OOo.add(new OO00OOO(O0OOO0.this.O00000oO, iLocalQueryGroupDevCallback));
                }
            });
        } else if (this.O00000o.isCloudOnline()) {
            this.O00000o.publishRawData(this.O00000o0.O000000o("FFFF", this.O00000oO, dpsParseBean), new IResultCallback() {
                public void onError(String str, String str2) {
                    ILocalQueryGroupDevCallback iLocalQueryGroupDevCallback = iLocalQueryGroupDevCallback;
                    if (iLocalQueryGroupDevCallback != null) {
                        iLocalQueryGroupDevCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    O0OOO0.this.O0000OOo.add(new OO00OOO(O0OOO0.this.O00000oO, iLocalQueryGroupDevCallback));
                }
            });
        } else if (iLocalQueryGroupDevCallback != null) {
            iLocalQueryGroupDevCallback.onError("13006", "mesh_off_line");
        }
    }

    public void queryGroupStatus(final IResultCallback iResultCallback) {
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000oo);
        if (O00000Oo2 != null) {
            this.O00000Oo.O00000Oo(O00000Oo2, this.O00000oO, iResultCallback);
        } else if (this.O00000o.isCloudOnline()) {
            this.O00000o.publishRawData(this.O00000Oo.O00000o0(a.c(this.O0000O0o), this.O00000oO), new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onSuccess();
                    }
                }
            });
        } else if (iResultCallback != null) {
            iResultCallback.onError("13006", "mesh_off_line");
        }
    }

    public void registerGroupListener(IGroupListener iGroupListener) {
    }

    public void removeDevice(String str, final IResultCallback iResultCallback) {
        final DeviceBean meshSubDevBean = this.O00000o.getMeshSubDevBean(str);
        if (meshSubDevBean != null) {
            String O000000o2 = OO00o00.O000000o(meshSubDevBean.getCategory());
            o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O00000oo);
            if (O00000Oo2 != null && meshSubDevBean.getIsLocalOnline().booleanValue()) {
                this.O00000Oo.O00000Oo(O00000Oo2, O000000o2, meshSubDevBean.getNodeId(), this.O00000oO, new IResultCallback() {
                    public void onError(String str, String str2) {
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onError(str, str2);
                        }
                    }

                    public void onSuccess() {
                        O0OOO0.this.O0000OOo.add(new BlueMeshCallback(meshSubDevBean.getNodeId(), BlueMeshCallback.CommandType.GROUP, new IResultCallback() {
                            public void onError(String str, String str2) {
                                iResultCallback.onError(str, str2);
                            }

                            public void onSuccess() {
                                iResultCallback.onSuccess();
                            }
                        }));
                    }
                });
            } else if (this.O00000o.isCloudOnline()) {
                this.O00000o.publishRawData(this.O00000Oo.O00000Oo(a.c(O000000o2), meshSubDevBean.getNodeId(), this.O00000oO), new IResultCallback() {
                    public void onError(String str, String str2) {
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onError(str, str2);
                        }
                    }

                    public void onSuccess() {
                        O0OOO0.this.O0000OOo.add(new BlueMeshCallback(meshSubDevBean.getNodeId(), BlueMeshCallback.CommandType.GROUP, new IResultCallback() {
                            public void onError(String str, String str2) {
                                iResultCallback.onError(str, str2);
                            }

                            public void onSuccess() {
                                iResultCallback.onSuccess();
                            }
                        }));
                    }
                });
            } else if (iResultCallback != null) {
                iResultCallback.onError("13006", "mesh_off_line");
            }
        } else if (iResultCallback != null) {
            iResultCallback.onError("11002", "device is remove");
        }
    }

    public void renameGroup(String str, IResultCallback iResultCallback) {
        L.e(O000000o, "not support rename");
        if (iResultCallback != null) {
            iResultCallback.onError("11005", "not support rename");
        }
    }

    public void unRegisterGroupListener() {
    }

    public void updateDeviceList(List<String> list, IResultCallback iResultCallback) {
        L.e(O000000o, "not support updateDeviceList");
        if (iResultCallback != null) {
            iResultCallback.onError("11005", "not support updateDeviceList");
        }
    }
}
