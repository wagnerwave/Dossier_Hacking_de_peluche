package com.tuya.smart.common;

import a.e.a.a.r.a;
import com.tuya.sdk.bluemesh.mesh.utils.BlueMeshCallback;
import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshGroup;
import com.tuya.smart.android.blemesh.callback.ILocalQueryGroupDevCallback;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.sdk.api.IGroupListener;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaGroup;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMesh;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.enums.TYDevicePublishModeEnum;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class O0OO0Oo implements ITuyaBlueMeshGroup {
    public static final String O000000o = "TuyaBlueMeshGroup";
    public ITuyaGroup O00000Oo;
    public O0OOO00 O00000o;
    public GroupBean O00000o0;
    public ITuyaBlueMesh O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public int O0000OOo;
    public LinkedList<BlueMeshCallback> O0000Oo0 = new LinkedList<>();

    public O0OO0Oo(long j) {
        Class cls = o0o00o00o0.class;
        GroupBean groupBean = ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getGroupBean(j);
        if (groupBean == null) {
            L.e(O000000o, j + "is not exist");
            return;
        }
        this.O00000Oo = ((o0o00o00o0) Oo0.O000000o(cls)).O000000o(groupBean.getId());
        this.O00000oO = new O000OO00(groupBean.getMeshId());
        this.O00000o = new O0OOO00();
        this.O00000oo = groupBean.getLocalId();
        this.O0000O0o = groupBean.getMeshId();
        this.O00000o0 = groupBean;
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O0000O0o);
        if (O00000Oo2 != null) {
            this.O0000OOo = O00000Oo2.O00000o0();
        }
    }

    public O0OO0Oo(String str, GroupBean groupBean) {
        this.O00000Oo = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O000000o(groupBean.getId());
        this.O00000oO = new O000OO00(str);
        this.O00000o = new O0OOO00();
        this.O00000oo = groupBean.getLocalId();
        this.O0000O0o = str;
        this.O00000o0 = groupBean;
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O0000O0o);
        if (O00000Oo2 != null) {
            this.O0000OOo = O00000Oo2.O00000o0();
        }
    }

    public void addDevice(final String str, final IResultCallback iResultCallback) {
        final DeviceBean meshSubDevBean = this.O00000oO.getMeshSubDevBean(str);
        if (meshSubDevBean != null) {
            String O000000o2 = OO00o00.O000000o(meshSubDevBean.getCategory());
            o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O0000O0o);
            if (O00000Oo2 != null && meshSubDevBean.getIsLocalOnline().booleanValue()) {
                this.O00000o.O000000o(O00000Oo2, O000000o2, meshSubDevBean.getNodeId(), this.O00000oo, new IResultCallback() {
                    public void onError(String str, String str2) {
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onError(str, str2);
                        }
                    }

                    public void onSuccess() {
                        O0OO0Oo.this.O0000Oo0.add(new BlueMeshCallback(meshSubDevBean.getNodeId(), BlueMeshCallback.CommandType.GROUP, new IResultCallback() {
                            public void onError(String str, String str2) {
                                iResultCallback.onError(str, str2);
                            }

                            public void onSuccess() {
                                L.d(O0OO0Oo.O000000o, "onSuccess add to cloud");
                                ITuyaGroup O000000o2 = O0OO0Oo.this.O00000Oo;
                                AnonymousClass4 r1 = AnonymousClass4.this;
                                O000000o2.addDevice(str, iResultCallback);
                            }
                        }));
                    }
                });
            } else if (this.O00000oO.isCloudOnline()) {
                this.O00000oO.publishRawData(this.O00000o.O000000o(a.c(O000000o2), meshSubDevBean.getNodeId(), this.O00000oo), new IResultCallback() {
                    public void onError(String str, String str2) {
                        IResultCallback iResultCallback = iResultCallback;
                        if (iResultCallback != null) {
                            iResultCallback.onError(str, str2);
                        }
                    }

                    public void onSuccess() {
                        O0OO0Oo.this.O0000Oo0.add(new BlueMeshCallback(meshSubDevBean.getNodeId(), BlueMeshCallback.CommandType.GROUP, new IResultCallback() {
                            public void onError(String str, String str2) {
                                iResultCallback.onError(str, str2);
                            }

                            public void onSuccess() {
                                ITuyaGroup O000000o2 = O0OO0Oo.this.O00000Oo;
                                AnonymousClass5 r1 = AnonymousClass5.this;
                                O000000o2.addDevice(str, iResultCallback);
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
        String O000000o2 = OO00o00.O000000o(this.O00000o0.getCategory());
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O0000O0o);
        final AnonymousClass1 r2 = new IResultCallback() {
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
        };
        if (O00000Oo2 != null) {
            this.O00000o.O000000o(O00000Oo2, O000000o2, this.O00000oo, new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    O0OO0Oo.this.O00000Oo.dismissGroup(r2);
                }
            });
        } else if (this.O00000oO.isCloudOnline()) {
            this.O00000oO.publishRawData(this.O00000o.O00000Oo(a.c(O000000o2), this.O00000oo), new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    O0OO0Oo.this.O00000Oo.dismissGroup(r2);
                }
            });
        } else {
            this.O00000Oo.dismissGroup(r2);
        }
    }

    public void onDestroy() {
        this.O00000Oo.onDestroy();
        this.O00000oO.onDestroy();
        Iterator it = this.O0000Oo0.iterator();
        while (it.hasNext()) {
            BlueMeshCallback blueMeshCallback = (BlueMeshCallback) it.next();
            if (blueMeshCallback != null) {
                blueMeshCallback.O000000o();
            }
        }
    }

    public void publishDps(String str, IResultCallback iResultCallback) {
    }

    public void publishDps(String str, TYDevicePublishModeEnum tYDevicePublishModeEnum, IResultCallback iResultCallback) {
    }

    public void queryDeviceInGroupByLocal(ILocalQueryGroupDevCallback iLocalQueryGroupDevCallback) {
    }

    public void queryGroupStatus(final IResultCallback iResultCallback) {
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O0000O0o);
        if (O00000Oo2 != null) {
            this.O00000o.O00000Oo(O00000Oo2, this.O00000oo, iResultCallback);
        } else if (this.O00000oO.isCloudOnline()) {
            this.O00000oO.publishRawData(this.O00000o.O00000o0(this.O0000OOo, this.O00000oo), new IResultCallback() {
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

    public void removeDevice(final String str, final IResultCallback iResultCallback) {
        final DeviceBean meshSubDevBean = this.O00000oO.getMeshSubDevBean(str);
        if (meshSubDevBean == null) {
            this.O00000Oo.removeDevice(str, iResultCallback);
            return;
        }
        String O000000o2 = OO00o00.O000000o(meshSubDevBean.getCategory());
        o00o0o00oo O00000Oo2 = O0O0o00.O000000o().O00000Oo(this.O0000O0o);
        if (O00000Oo2 != null && meshSubDevBean.getIsLocalOnline().booleanValue()) {
            this.O00000o.O00000Oo(O00000Oo2, O000000o2, meshSubDevBean.getNodeId(), this.O00000oo, new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    O0OO0Oo.this.O0000Oo0.add(new BlueMeshCallback(meshSubDevBean.getNodeId(), BlueMeshCallback.CommandType.GROUP, new IResultCallback() {
                        public void onError(String str, String str2) {
                            iResultCallback.onError(str, str2);
                        }

                        public void onSuccess() {
                            ITuyaGroup O000000o2 = O0OO0Oo.this.O00000Oo;
                            AnonymousClass6 r1 = AnonymousClass6.this;
                            O000000o2.removeDevice(str, iResultCallback);
                        }
                    }));
                }
            });
        } else if (this.O00000oO.isCloudOnline()) {
            this.O00000oO.publishRawData(this.O00000o.O00000Oo(a.c(O000000o2), meshSubDevBean.getNodeId(), this.O00000oo), new IResultCallback() {
                public void onError(String str, String str2) {
                    IResultCallback iResultCallback = iResultCallback;
                    if (iResultCallback != null) {
                        iResultCallback.onError(str, str2);
                    }
                }

                public void onSuccess() {
                    O0OO0Oo.this.O0000Oo0.add(new BlueMeshCallback(meshSubDevBean.getNodeId(), BlueMeshCallback.CommandType.GROUP, new IResultCallback() {
                        public void onError(String str, String str2) {
                            iResultCallback.onError(str, str2);
                        }

                        public void onSuccess() {
                            ITuyaGroup O000000o2 = O0OO0Oo.this.O00000Oo;
                            AnonymousClass7 r1 = AnonymousClass7.this;
                            O000000o2.removeDevice(str, iResultCallback);
                        }
                    }));
                }
            });
        } else if (iResultCallback != null) {
            iResultCallback.onError("13006", "mesh_off_line");
        }
    }

    public void renameGroup(String str, IResultCallback iResultCallback) {
        this.O00000Oo.renameGroup(str, iResultCallback);
    }

    public void unRegisterGroupListener() {
    }

    public void updateDeviceList(List<String> list, IResultCallback iResultCallback) {
    }
}
