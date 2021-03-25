package com.tutk.IOTC;

import a.a.a.a.a;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class AVIOCTRLDEFs {
    public static final int AVIOCTRL_AUTO_PAN_LIMIT = 28;
    public static final int AVIOCTRL_AUTO_PAN_SPEED = 27;
    public static final int AVIOCTRL_AUTO_PAN_START = 29;
    public static final int AVIOCTRL_CLEAR_AUX = 34;
    public static final int AVIOCTRL_ENVIRONMENT_INDOOR_50HZ = 0;
    public static final int AVIOCTRL_ENVIRONMENT_INDOOR_60HZ = 1;
    public static final int AVIOCTRL_ENVIRONMENT_NIGHT = 3;
    public static final int AVIOCTRL_ENVIRONMENT_OUTDOOR = 2;
    public static final int AVIOCTRL_EVENT_ALL = 0;
    public static final int AVIOCTRL_EVENT_EXPT_REBOOT = 16;
    public static final int AVIOCTRL_EVENT_IOALARM = 3;
    public static final int AVIOCTRL_EVENT_IOALARMPASS = 6;
    public static final int AVIOCTRL_EVENT_MOTIONDECT = 1;
    public static final int AVIOCTRL_EVENT_MOTIONPASS = 4;
    public static final int AVIOCTRL_EVENT_SDFAULT = 17;
    public static final int AVIOCTRL_EVENT_VIDEOLOST = 2;
    public static final int AVIOCTRL_EVENT_VIDEORESUME = 5;
    public static final int AVIOCTRL_LENS_APERTURE_CLOSE = 22;
    public static final int AVIOCTRL_LENS_APERTURE_OPEN = 21;
    public static final int AVIOCTRL_LENS_FOCAL_FAR = 26;
    public static final int AVIOCTRL_LENS_FOCAL_NEAR = 25;
    public static final int AVIOCTRL_LENS_ZOOM_IN = 23;
    public static final int AVIOCTRL_LENS_ZOOM_OUT = 24;
    public static final int AVIOCTRL_MOTOR_RESET_POSITION = 35;
    public static final int AVIOCTRL_PATTERN_RUN = 32;
    public static final int AVIOCTRL_PATTERN_START = 30;
    public static final int AVIOCTRL_PATTERN_STOP = 31;
    public static final int AVIOCTRL_PTZ_AUTO = 9;
    public static final int AVIOCTRL_PTZ_CLEAR_POINT = 11;
    public static final int AVIOCTRL_PTZ_DOWN = 2;
    public static final int AVIOCTRL_PTZ_FLIP = 19;
    public static final int AVIOCTRL_PTZ_GOTO_POINT = 12;
    public static final int AVIOCTRL_PTZ_LEFT = 3;
    public static final int AVIOCTRL_PTZ_LEFT_DOWN = 5;
    public static final int AVIOCTRL_PTZ_LEFT_UP = 4;
    public static final int AVIOCTRL_PTZ_MENU_ENTER = 18;
    public static final int AVIOCTRL_PTZ_MENU_EXIT = 17;
    public static final int AVIOCTRL_PTZ_MENU_OPEN = 16;
    public static final int AVIOCTRL_PTZ_MODE_RUN = 15;
    public static final int AVIOCTRL_PTZ_RIGHT = 6;
    public static final int AVIOCTRL_PTZ_RIGHT_DOWN = 8;
    public static final int AVIOCTRL_PTZ_RIGHT_UP = 7;
    public static final int AVIOCTRL_PTZ_SET_MODE_START = 13;
    public static final int AVIOCTRL_PTZ_SET_MODE_STOP = 14;
    public static final int AVIOCTRL_PTZ_SET_POINT = 10;
    public static final int AVIOCTRL_PTZ_START = 20;
    public static final int AVIOCTRL_PTZ_STOP = 0;
    public static final int AVIOCTRL_PTZ_UP = 1;
    public static final int AVIOCTRL_QUALITY_HIGH = 2;
    public static final int AVIOCTRL_QUALITY_LOW = 4;
    public static final int AVIOCTRL_QUALITY_MAX = 1;
    public static final int AVIOCTRL_QUALITY_MIDDLE = 3;
    public static final int AVIOCTRL_QUALITY_MIN = 5;
    public static final int AVIOCTRL_QUALITY_UNKNOWN = 0;
    public static final int AVIOCTRL_RECORD_PLAY_BACKWARD = 5;
    public static final int AVIOCTRL_RECORD_PLAY_END = 7;
    public static final int AVIOCTRL_RECORD_PLAY_FORWARD = 4;
    public static final int AVIOCTRL_RECORD_PLAY_PAUSE = 0;
    public static final int AVIOCTRL_RECORD_PLAY_SEEKTIME = 6;
    public static final int AVIOCTRL_RECORD_PLAY_START = 16;
    public static final int AVIOCTRL_RECORD_PLAY_STEPBACKWARD = 3;
    public static final int AVIOCTRL_RECORD_PLAY_STEPFORWARD = 2;
    public static final int AVIOCTRL_RECORD_PLAY_STOP = 1;
    public static final int AVIOCTRL_SET_AUX = 33;
    public static final int AVIOCTRL_VIDEOMODE_FLIP = 1;
    public static final int AVIOCTRL_VIDEOMODE_FLIP_MIRROR = 3;
    public static final int AVIOCTRL_VIDEOMODE_MIRROR = 2;
    public static final int AVIOCTRL_VIDEOMODE_NORMAL = 0;
    public static final int AVIOTC_RECORDTYPE_ALAM = 2;
    public static final int AVIOTC_RECORDTYPE_FULLTIME = 1;
    public static final int AVIOTC_RECORDTYPE_MANUAL = 3;
    public static final int AVIOTC_RECORDTYPE_OFF = 0;
    public static final int AVIOTC_WIFIAPENC_INVALID = 0;
    public static final int AVIOTC_WIFIAPENC_NONE = 1;
    public static final int AVIOTC_WIFIAPENC_WEP = 2;
    public static final int AVIOTC_WIFIAPENC_WPA2_AES = 6;
    public static final int AVIOTC_WIFIAPENC_WPA2_TKIP = 5;
    public static final int AVIOTC_WIFIAPENC_WPA_AES = 4;
    public static final int AVIOTC_WIFIAPENC_WPA_TKIP = 3;
    public static final int AVIOTC_WIFIAPMODE_ADHOC = 0;
    public static final int AVIOTC_WIFIAPMODE_MANAGED = 1;
    public static final int IOTYPE_USER_IPCAM_AUDIOSTART = 768;
    public static final int IOTYPE_USER_IPCAM_AUDIOSTOP = 769;
    public static final int IOTYPE_USER_IPCAM_DEVINFO_REQ = 816;
    public static final int IOTYPE_USER_IPCAM_DEVINFO_RESP = 817;
    public static final int IOTYPE_USER_IPCAM_EVENT_REPORT = 8191;
    public static final int IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ = 896;
    public static final int IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_RESP = 897;
    public static final int IOTYPE_USER_IPCAM_GETAUDIOOUTFORMAT_REQ = 810;
    public static final int IOTYPE_USER_IPCAM_GETAUDIOOUTFORMAT_RESP = 811;
    public static final int IOTYPE_USER_IPCAM_GETMOTIONDETECT_REQ = 806;
    public static final int IOTYPE_USER_IPCAM_GETMOTIONDETECT_RESP = 807;
    public static final int IOTYPE_USER_IPCAM_GETRCD_DURATION_REQ = 790;
    public static final int IOTYPE_USER_IPCAM_GETRCD_DURATION_RESP = 791;
    public static final int IOTYPE_USER_IPCAM_GETRECORD_REQ = 786;
    public static final int IOTYPE_USER_IPCAM_GETRECORD_RESP = 787;
    public static final int IOTYPE_USER_IPCAM_GETSTREAMCTRL_REQ = 802;
    public static final int IOTYPE_USER_IPCAM_GETSTREAMCTRL_RESP = 803;
    public static final int IOTYPE_USER_IPCAM_GETSUPPORTSTREAM_REQ = 808;
    public static final int IOTYPE_USER_IPCAM_GETSUPPORTSTREAM_RESP = 809;
    public static final int IOTYPE_USER_IPCAM_GETWIFI_REQ = 836;
    public static final int IOTYPE_USER_IPCAM_GETWIFI_RESP = 837;
    public static final int IOTYPE_USER_IPCAM_GETWIFI_RESP_2 = 839;
    public static final int IOTYPE_USER_IPCAM_GET_ENVIRONMENT_REQ = 866;
    public static final int IOTYPE_USER_IPCAM_GET_ENVIRONMENT_RESP = 867;
    public static final int IOTYPE_USER_IPCAM_GET_EVENTCONFIG_REQ = 1024;
    public static final int IOTYPE_USER_IPCAM_GET_EVENTCONFIG_RESP = 1025;
    public static final int IOTYPE_USER_IPCAM_GET_VIDEOMODE_REQ = 882;
    public static final int IOTYPE_USER_IPCAM_GET_VIDEOMODE_RESP = 883;
    public static final int IOTYPE_USER_IPCAM_LISTEVENT_REQ = 792;
    public static final int IOTYPE_USER_IPCAM_LISTEVENT_RESP = 793;
    public static final int IOTYPE_USER_IPCAM_LISTWIFIAP_REQ = 832;
    public static final int IOTYPE_USER_IPCAM_LISTWIFIAP_RESP = 833;
    public static final int IOTYPE_USER_IPCAM_PTZ_COMMAND = 4097;
    public static final int IOTYPE_USER_IPCAM_RECORD_PLAYCONTROL = 794;
    public static final int IOTYPE_USER_IPCAM_RECORD_PLAYCONTROL_RESP = 795;
    public static final int IOTYPE_USER_IPCAM_SETMOTIONDETECT_REQ = 804;
    public static final int IOTYPE_USER_IPCAM_SETMOTIONDETECT_RESP = 805;
    public static final int IOTYPE_USER_IPCAM_SETPASSWORD_REQ = 818;
    public static final int IOTYPE_USER_IPCAM_SETPASSWORD_RESP = 819;
    public static final int IOTYPE_USER_IPCAM_SETRCD_DURATION_REQ = 788;
    public static final int IOTYPE_USER_IPCAM_SETRCD_DURATION_RESP = 789;
    public static final int IOTYPE_USER_IPCAM_SETRECORD_REQ = 784;
    public static final int IOTYPE_USER_IPCAM_SETRECORD_RESP = 785;
    public static final int IOTYPE_USER_IPCAM_SETSTREAMCTRL_REQ = 800;
    public static final int IOTYPE_USER_IPCAM_SETSTREAMCTRL_RESP = 801;
    public static final int IOTYPE_USER_IPCAM_SETWIFI_REQ = 834;
    public static final int IOTYPE_USER_IPCAM_SETWIFI_REQ_2 = 838;
    public static final int IOTYPE_USER_IPCAM_SETWIFI_RESP = 835;
    public static final int IOTYPE_USER_IPCAM_SET_ENVIRONMENT_REQ = 864;
    public static final int IOTYPE_USER_IPCAM_SET_ENVIRONMENT_RESP = 865;
    public static final int IOTYPE_USER_IPCAM_SET_EVENTCONFIG_REQ = 1026;
    public static final int IOTYPE_USER_IPCAM_SET_EVENTCONFIG_RESP = 1027;
    public static final int IOTYPE_USER_IPCAM_SET_VIDEOMODE_REQ = 880;
    public static final int IOTYPE_USER_IPCAM_SET_VIDEOMODE_RESP = 881;
    public static final int IOTYPE_USER_IPCAM_SPEAKERSTART = 848;
    public static final int IOTYPE_USER_IPCAM_SPEAKERSTOP = 849;
    public static final int IOTYPE_USER_IPCAM_START = 511;
    public static final int IOTYPE_USER_IPCAM_STOP = 767;

    public static class SAvEvent {
        public byte event;
        public byte[] reserved = new byte[2];
        public byte status;
        public byte[] utctime = new byte[8];

        public static int getTotalSize() {
            return 12;
        }
    }

    public static class SFrameInfo {
        public byte cam_index;
        public short codec_id;
        public byte flags;
        public byte onlineNum;
        public byte[] reserved = new byte[3];
        public int reserved2;
        public int timestamp;

        public static byte[] parseContent(short s, byte b2, byte b3, byte b4, int i) {
            byte[] bArr = new byte[16];
            System.arraycopy(Packet.shortToByteArray_Little(s), 0, bArr, 0, 2);
            bArr[2] = b2;
            bArr[3] = b3;
            bArr[4] = b4;
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 12, 4);
            return bArr;
        }
    }

    public static class SMsgAVIoctrlAVStream {
        public int channel = 0;
        public byte[] reserved = new byte[4];

        public static byte[] parseContent(int i) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            return bArr;
        }
    }

    public static class SMsgAVIoctrlDeviceInfoReq {
        public static byte[] reserved = new byte[4];

        public static byte[] parseContent() {
            return reserved;
        }
    }

    public class SMsgAVIoctrlDeviceInfoResp {
        public int channel;
        public int free;
        public byte[] model = new byte[16];
        public byte[] reserved = new byte[8];
        public int total;
        public byte[] vendor = new byte[16];
        public int version;

        public SMsgAVIoctrlDeviceInfoResp() {
        }
    }

    public class SMsgAVIoctrlEvent {
        public int channel;
        public int event;
        public byte[] reserved = new byte[4];
        public STimeDay stTime;

        public SMsgAVIoctrlEvent() {
        }
    }

    public class SMsgAVIoctrlEventConfig {
        public long channel;
        public byte ftp;
        public byte localIO;
        public byte mail;
        public byte p2pPushMsg;

        public SMsgAVIoctrlEventConfig() {
        }
    }

    public static class SMsgAVIoctrlFormatExtStorageReq {
        public byte[] reserved = new byte[4];
        public int storage;

        public static byte[] parseContent(int i) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            return bArr;
        }
    }

    public class SMsgAVIoctrlFormatExtStorageResp {
        public byte[] reserved = new byte[3];
        public byte result;
        public int storage;

        public SMsgAVIoctrlFormatExtStorageResp() {
        }
    }

    public static class SMsgAVIoctrlGetAudioOutFormatReq {
        public static byte[] parseContent() {
            return new byte[8];
        }
    }

    public class SMsgAVIoctrlGetAudioOutFormatResp {
        public int channel;
        public int format;

        public SMsgAVIoctrlGetAudioOutFormatResp() {
        }
    }

    public static class SMsgAVIoctrlGetEnvironmentReq {
        public int channel;
        public byte[] reserved = new byte[4];

        public static byte[] parseContent(int i) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            return bArr;
        }
    }

    public class SMsgAVIoctrlGetEnvironmentResp {
        public int channel;
        public byte mode;
        public byte[] reserved = new byte[3];

        public SMsgAVIoctrlGetEnvironmentResp() {
        }
    }

    public static class SMsgAVIoctrlGetMotionDetectReq {
        public int channel;
        public byte[] reserved = new byte[4];

        public static byte[] parseContent(int i) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            return bArr;
        }
    }

    public class SMsgAVIoctrlGetMotionDetectResp {
        public int channel;
        public int sensitivity;

        public SMsgAVIoctrlGetMotionDetectResp() {
        }
    }

    public class SMsgAVIoctrlGetRcdDurationReq {
        public int channel;
        public byte[] reserved = new byte[4];

        public SMsgAVIoctrlGetRcdDurationReq() {
        }
    }

    public class SMsgAVIoctrlGetRcdDurationResp {
        public int channel;
        public int durasecond;
        public int presecond;

        public SMsgAVIoctrlGetRcdDurationResp() {
        }
    }

    public static class SMsgAVIoctrlGetRecordReq {
        public int channel;
        public byte[] reserved = new byte[4];

        public static byte[] parseContent(int i) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            return bArr;
        }
    }

    public class SMsgAVIoctrlGetRecordResp {
        public int channel;
        public int recordType;

        public SMsgAVIoctrlGetRecordResp() {
        }
    }

    public static class SMsgAVIoctrlGetStreamCtrlReq {
        public int channel;
        public byte[] reserved = new byte[4];

        public static byte[] parseContent(int i) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            return bArr;
        }
    }

    public class SMsgAVIoctrlGetStreamCtrlResp {
        public int channel;
        public byte quality;
        public byte[] reserved = new byte[3];

        public SMsgAVIoctrlGetStreamCtrlResp() {
        }
    }

    public static class SMsgAVIoctrlGetSupportStreamReq {
        public static int getContentSize() {
            return 4;
        }

        public static byte[] parseContent() {
            return new byte[4];
        }
    }

    public class SMsgAVIoctrlGetSupportStreamResp {
        public SStreamDef[] mStreamDef;
        public long number;

        public SMsgAVIoctrlGetSupportStreamResp() {
        }
    }

    public static class SMsgAVIoctrlGetVideoModeReq {
        public int channel;
        public byte[] reserved = new byte[4];

        public static byte[] parseContent(int i) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            return bArr;
        }
    }

    public class SMsgAVIoctrlGetVideoModeResp {
        public int channel;
        public byte mode;
        public byte[] reserved = new byte[3];

        public SMsgAVIoctrlGetVideoModeResp() {
        }
    }

    public static class SMsgAVIoctrlGetWifiReq {
        public static byte[] reserved = new byte[4];

        public static byte[] parseContent() {
            return reserved;
        }
    }

    public class SMsgAVIoctrlGetWifiResp {
        public byte enctype;
        public byte mode;
        public byte[] password = new byte[32];
        public byte signal;
        public byte[] ssid = new byte[32];
        public byte status;

        public SMsgAVIoctrlGetWifiResp() {
        }
    }

    public static class SMsgAVIoctrlListEventReq {
        public int channel;
        public byte[] endutctime = new byte[8];
        public byte event;
        public byte[] reversed = new byte[2];
        public byte[] startutctime = new byte[8];
        public byte status;

        public static byte[] parseConent(int i, long j, long j2, byte b2, byte b3) {
            Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("gmt"));
            Calendar instance2 = Calendar.getInstance(TimeZone.getTimeZone("gmt"));
            instance.setTimeInMillis(j);
            instance2.setTimeInMillis(j2);
            PrintStream printStream = System.out;
            StringBuilder n = a.n("search from ");
            n.append(instance.get(1));
            n.append("/");
            n.append(instance.get(2));
            n.append("/");
            n.append(instance.get(5));
            n.append(" ");
            n.append(instance.get(11));
            n.append(":");
            n.append(instance.get(12));
            n.append(":");
            n.append(instance.get(13));
            printStream.println(n.toString());
            PrintStream printStream2 = System.out;
            StringBuilder n2 = a.n("       to   ");
            n2.append(instance2.get(1));
            n2.append("/");
            n2.append(instance2.get(2));
            n2.append("/");
            n2.append(instance2.get(5));
            n2.append(" ");
            n2.append(instance2.get(11));
            n2.append(":");
            n2.append(instance2.get(12));
            n2.append(":");
            n2.append(instance2.get(13));
            printStream2.println(n2.toString());
            byte[] bArr = new byte[24];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            System.arraycopy(STimeDay.parseContent(instance.get(1), instance.get(2) + 1, instance.get(5), instance.get(7), instance.get(11), instance.get(12), 0), 0, bArr, 4, 8);
            System.arraycopy(STimeDay.parseContent(instance2.get(1), instance2.get(2) + 1, instance2.get(5), instance2.get(7), instance2.get(11), instance2.get(12), 0), 0, bArr, 12, 8);
            bArr[20] = b2;
            bArr[21] = b3;
            return bArr;
        }
    }

    public class SMsgAVIoctrlListEventResp {
        public int channel;
        public byte count;
        public byte endflag;
        public byte index;
        public byte reserved;
        public SAvEvent stEvent;
        public int total;

        public SMsgAVIoctrlListEventResp() {
        }
    }

    public static class SMsgAVIoctrlListWifiApReq {
        public static byte[] reserved = new byte[4];

        public static byte[] parseContent() {
            return reserved;
        }
    }

    public class SMsgAVIoctrlListWifiApResp {
        public int number;
        public SWifiAp stWifiAp;

        public SMsgAVIoctrlListWifiApResp() {
        }
    }

    public static class SMsgAVIoctrlPlayRecord {
        public int Param;
        public int channel;
        public int command;
        public byte[] reserved = new byte[4];
        public byte[] stTimeDay = new byte[8];

        public static byte[] parseContent(int i, int i2, int i3, long j) {
            byte[] bArr = new byte[24];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            System.arraycopy(Packet.intToByteArray_Little(i2), 0, bArr, 4, 4);
            System.arraycopy(Packet.intToByteArray_Little(i3), 0, bArr, 8, 4);
            Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("gmt"));
            instance.setTimeInMillis(j);
            instance.add(5, -1);
            instance.add(5, 1);
            System.arraycopy(STimeDay.parseContent(instance.get(1), instance.get(2), instance.get(5), instance.get(7), instance.get(11), instance.get(12), instance.get(13)), 0, bArr, 12, 8);
            return bArr;
        }

        public static byte[] parseContent(int i, int i2, int i3, byte[] bArr) {
            byte[] bArr2 = new byte[24];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr2, 0, 4);
            System.arraycopy(Packet.intToByteArray_Little(i2), 0, bArr2, 4, 4);
            System.arraycopy(Packet.intToByteArray_Little(i3), 0, bArr2, 8, 4);
            System.arraycopy(bArr, 0, bArr2, 12, 8);
            return bArr2;
        }
    }

    public class SMsgAVIoctrlPlayRecordResp {
        public int channel;
        public byte[] reserved = new byte[4];
        public int result;

        public SMsgAVIoctrlPlayRecordResp() {
        }
    }

    public static class SMsgAVIoctrlPtzCmd {
        public byte aux;
        public byte channel;
        public byte control;
        public byte limit;
        public byte point;
        public byte[] reserved = new byte[2];
        public byte speed;

        public static byte[] parseContent(byte b2, byte b3, byte b4, byte b5, byte b6, byte b7) {
            byte[] bArr = new byte[8];
            bArr[0] = b2;
            bArr[1] = b3;
            bArr[2] = b4;
            bArr[3] = b5;
            bArr[4] = b6;
            bArr[5] = b7;
            return bArr;
        }
    }

    public static class SMsgAVIoctrlSetEnvironmentReq {
        public int channel;
        public byte mode;
        public byte[] reserved = new byte[3];

        public static byte[] parseContent(int i, byte b2) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            bArr[4] = b2;
            return bArr;
        }
    }

    public class SMsgAVIoctrlSetEnvironmentResp {
        public int channel;
        public byte[] reserved = new byte[3];
        public byte result;

        public SMsgAVIoctrlSetEnvironmentResp() {
        }
    }

    public static class SMsgAVIoctrlSetMotionDetectReq {
        public int channel;
        public int sensitivity;

        public static byte[] parseContent(int i, int i2) {
            byte[] bArr = new byte[8];
            byte[] intToByteArray_Little = Packet.intToByteArray_Little(i);
            byte[] intToByteArray_Little2 = Packet.intToByteArray_Little(i2);
            System.arraycopy(intToByteArray_Little, 0, bArr, 0, 4);
            System.arraycopy(intToByteArray_Little2, 0, bArr, 4, 4);
            return bArr;
        }
    }

    public class SMsgAVIoctrlSetMotionDetectResp {
        public byte[] reserved = new byte[3];
        public byte result;

        public SMsgAVIoctrlSetMotionDetectResp() {
        }
    }

    public static class SMsgAVIoctrlSetPasswdReq {
        public byte[] newPasswd = new byte[32];
        public byte[] oldPasswd = new byte[32];

        public static byte[] parseContent(String str, String str2) {
            byte[] bytes = str.getBytes();
            byte[] bytes2 = str2.getBytes();
            byte[] bArr = new byte[64];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            System.arraycopy(bytes2, 0, bArr, 32, bytes2.length);
            return bArr;
        }
    }

    public class SMsgAVIoctrlSetPasswdResp {
        public byte[] reserved = new byte[3];
        public byte result;

        public SMsgAVIoctrlSetPasswdResp() {
        }
    }

    public class SMsgAVIoctrlSetRcdDurationReq {
        public int channel;
        public int durasecond;
        public int presecond;

        public SMsgAVIoctrlSetRcdDurationReq() {
        }
    }

    public class SMsgAVIoctrlSetRcdDurationResp {
        public byte[] reserved = new byte[3];
        public byte result;

        public SMsgAVIoctrlSetRcdDurationResp() {
        }
    }

    public static class SMsgAVIoctrlSetRecordReq {
        public int channel;
        public int recordType;
        public byte[] reserved = new byte[4];

        public static byte[] parseContent(int i, int i2) {
            byte[] bArr = new byte[12];
            byte[] intToByteArray_Little = Packet.intToByteArray_Little(i);
            byte[] intToByteArray_Little2 = Packet.intToByteArray_Little(i2);
            System.arraycopy(intToByteArray_Little, 0, bArr, 0, 4);
            System.arraycopy(intToByteArray_Little2, 0, bArr, 4, 4);
            return bArr;
        }
    }

    public class SMsgAVIoctrlSetRecordResp {
        public byte[] reserved = new byte[3];
        public byte result;

        public SMsgAVIoctrlSetRecordResp() {
        }
    }

    public static class SMsgAVIoctrlSetStreamCtrlReq {
        public int channel;
        public byte quality;
        public byte[] reserved = new byte[3];

        public static byte[] parseContent(int i, byte b2) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            bArr[4] = b2;
            return bArr;
        }
    }

    public class SMsgAVIoctrlSetStreamCtrlResp {
        public byte[] reserved = new byte[4];
        public int result;

        public SMsgAVIoctrlSetStreamCtrlResp() {
        }
    }

    public static class SMsgAVIoctrlSetVideoModeReq {
        public int channel;
        public byte mode;
        public byte[] reserved = new byte[3];

        public static byte[] parseContent(int i, byte b2) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.intToByteArray_Little(i), 0, bArr, 0, 4);
            bArr[4] = b2;
            return bArr;
        }
    }

    public class SMsgAVIoctrlSetVideoModeResp {
        public int channel;
        public byte[] reserved = new byte[3];
        public byte result;

        public SMsgAVIoctrlSetVideoModeResp() {
        }
    }

    public static class SMsgAVIoctrlSetWifiReq {
        public byte enctype;
        public byte mode;
        public byte[] password = new byte[32];
        public byte[] reserved = new byte[10];
        public byte[] ssid = new byte[32];

        public static byte[] parseContent(byte[] bArr, byte[] bArr2, byte b2, byte b3) {
            byte[] bArr3 = new byte[76];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, 32, bArr2.length);
            bArr3[64] = b2;
            bArr3[65] = b3;
            return bArr3;
        }
    }

    public class SMsgAVIoctrlSetWifiResp {
        public byte[] reserved = new byte[3];
        public byte result;

        public SMsgAVIoctrlSetWifiResp() {
        }
    }

    public static class SStreamDef {
        public int channel;
        public int index;

        public SStreamDef(byte[] bArr) {
            this.index = Packet.byteArrayToShort_Little(bArr, 0);
            this.channel = Packet.byteArrayToShort_Little(bArr, 2);
        }

        public String toString() {
            StringBuilder n = a.n("CH");
            n.append(String.valueOf(this.index + 1));
            return n.toString();
        }
    }

    public static class STimeDay {
        public byte day;
        public byte hour;
        public byte[] mBuf;
        public byte minute;
        public byte month;
        public byte second;
        public byte wday;
        public short year;

        public STimeDay(byte[] bArr) {
            byte[] bArr2 = new byte[8];
            this.mBuf = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, 8);
            this.year = Packet.byteArrayToShort_Little(bArr, 0);
            this.month = bArr[2];
            this.day = bArr[3];
            this.wday = bArr[4];
            this.hour = bArr[5];
            this.minute = bArr[6];
            this.second = bArr[7];
        }

        public static byte[] parseContent(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            byte[] bArr = new byte[8];
            System.arraycopy(Packet.shortToByteArray_Little((short) i), 0, bArr, 0, 2);
            bArr[2] = (byte) i2;
            bArr[3] = (byte) i3;
            bArr[4] = (byte) i4;
            bArr[5] = (byte) i5;
            bArr[6] = (byte) i6;
            bArr[7] = (byte) i7;
            return bArr;
        }

        public String getLocalTime() {
            Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("gmt"));
            instance.setTimeInMillis(getTimeInMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat.format(instance.getTime());
        }

        public long getTimeInMillis() {
            Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("gmt"));
            instance.set(this.year, this.month - 1, this.day, this.hour, this.minute, this.second);
            return instance.getTimeInMillis();
        }

        public byte[] toByteArray() {
            return this.mBuf;
        }
    }

    public static class SWifiAp {
        public byte enctype;
        public byte mode;
        public byte signal;
        public byte[] ssid;
        public byte status;

        public SWifiAp(byte[] bArr) {
            byte[] bArr2 = new byte[32];
            this.ssid = bArr2;
            System.arraycopy(bArr, 1, bArr2, 0, bArr.length);
            this.mode = bArr[32];
            this.enctype = bArr[33];
            this.signal = bArr[34];
            this.status = bArr[35];
        }

        public SWifiAp(byte[] bArr, byte b2, byte b3, byte b4, byte b5) {
            byte[] bArr2 = new byte[32];
            this.ssid = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.mode = b2;
            this.enctype = b3;
            this.signal = b4;
            this.status = b5;
        }

        public static int getTotalSize() {
            return 36;
        }
    }
}
