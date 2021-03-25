package com.tutk.IOTC;

import com.tutk.IOTC.Camera;

public class AVFrame {
    public static final int AUDIO_CHANNEL_MONO = 0;
    public static final int AUDIO_CHANNEL_STERO = 1;
    public static final int AUDIO_DATABITS_16 = 1;
    public static final int AUDIO_DATABITS_8 = 0;
    public static final int AUDIO_SAMPLE_11K = 1;
    public static final int AUDIO_SAMPLE_12K = 2;
    public static final int AUDIO_SAMPLE_16K = 3;
    public static final int AUDIO_SAMPLE_22K = 4;
    public static final int AUDIO_SAMPLE_24K = 5;
    public static final int AUDIO_SAMPLE_32K = 6;
    public static final int AUDIO_SAMPLE_44K = 7;
    public static final int AUDIO_SAMPLE_48K = 8;
    public static final int AUDIO_SAMPLE_8K = 0;
    public static final int FRAMEINFO_SIZE = 24;
    public static final byte FRM_STATE_COMPLETE = 0;
    public static final byte FRM_STATE_INCOMPLETE = 1;
    public static final byte FRM_STATE_LOSED = 2;
    public static final byte FRM_STATE_UNKOWN = -1;
    public static final int IPC_FRAME_FLAG_IFRAME = 1;
    public static final int IPC_FRAME_FLAG_IO = 3;
    public static final int IPC_FRAME_FLAG_MD = 2;
    public static final int IPC_FRAME_FLAG_PBFRAME = 0;
    public static final int MEDIA_CODEC_AUDIO_ADPCM = 139;
    public static final int MEDIA_CODEC_AUDIO_G726 = 143;
    public static final int MEDIA_CODEC_AUDIO_MP3 = 142;
    public static final int MEDIA_CODEC_AUDIO_PCM = 140;
    public static final int MEDIA_CODEC_AUDIO_SPEEX = 141;
    public static final int MEDIA_CODEC_UNKNOWN = 0;
    public static final int MEDIA_CODEC_VIDEO_H263 = 77;
    public static final int MEDIA_CODEC_VIDEO_H264 = 78;
    public static final int MEDIA_CODEC_VIDEO_MJPEG = 79;
    public static final int MEDIA_CODEC_VIDEO_MPEG4 = 76;
    public short codec_id = 0;
    public byte flags = -1;
    public byte[] frmData = null;
    public long frmNo = -1;
    public int frmSize = 0;
    public byte frmState = 0;
    public byte onlineNum = 0;
    public int timestamp = 0;
    public int videoHeight = 0;
    public int videoWidth = 0;

    public AVFrame(long j, byte b2, byte[] bArr, byte[] bArr2, int i) {
        int i2 = 0;
        this.codec_id = Packet.byteArrayToShort_Little(bArr, 0);
        this.frmState = b2;
        this.flags = bArr[2];
        this.onlineNum = bArr[4];
        this.timestamp = Packet.byteArrayToInt_Little(bArr, 12);
        this.videoWidth = bArr.length > 16 ? Packet.byteArrayToInt_Little(bArr, 16) : 0;
        this.videoHeight = bArr.length > 16 ? Packet.byteArrayToInt_Little(bArr, 20) : i2;
        this.frmSize = i;
        this.frmData = bArr2;
        this.frmNo = j;
    }

    public static int getSamplerate(byte b2) {
        switch (b2 >>> 2) {
            case 1:
                return 11025;
            case 2:
                return 12000;
            case 3:
                return 16000;
            case 4:
                return 22050;
            case 5:
                return 24000;
            case 6:
                return 32000;
            case 7:
                return 44100;
            case 8:
                return 48000;
            default:
                return Camera.ThreadSendAudio.SAMPLE_RATE_IN_HZ;
        }
    }

    public short getCodecId() {
        return this.codec_id;
    }

    public byte getFlags() {
        return this.flags;
    }

    public long getFrmNo() {
        return this.frmNo;
    }

    public int getFrmSize() {
        return this.frmSize;
    }

    public byte getFrmState() {
        return this.frmState;
    }

    public byte getOnlineNum() {
        return this.onlineNum;
    }

    public int getTimeStamp() {
        return this.timestamp;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public boolean isIFrame() {
        return (this.flags & 1) == 1;
    }
}
