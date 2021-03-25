package com.tutk.IOTC;

import a.a.a.a.a;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.drawerlayout.widget.DrawerLayout;
import com.decoder.util.DecADPCM;
import com.decoder.util.DecG726;
import com.decoder.util.DecMp3;
import com.decoder.util.DecSpeex;
import com.encoder.util.EncADPCM;
import com.encoder.util.EncG726;
import com.encoder.util.EncSpeex;
import com.tutk.IOTC.AVIOCTRLDEFs;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Camera {
    public static final int CONNECTION_STATE_CONNECTED = 2;
    public static final int CONNECTION_STATE_CONNECTING = 1;
    public static final int CONNECTION_STATE_CONNECT_FAILED = 8;
    public static final int CONNECTION_STATE_DISCONNECTED = 3;
    public static final int CONNECTION_STATE_NONE = 0;
    public static final int CONNECTION_STATE_TIMEOUT = 6;
    public static final int CONNECTION_STATE_UNKNOWN_DEVICE = 4;
    public static final int CONNECTION_STATE_UNSUPPORTED = 7;
    public static final int CONNECTION_STATE_WRONG_PASSWORD = 5;
    public static final int DEFAULT_AV_CHANNEL = 0;
    public static final String HEXES = "0123456789ABCDEF";
    public static volatile int mCameraCount = 0;
    public static int mDefaultMaxCameraLimit = 4;
    public List<AVChannel> mAVChannels = Collections.synchronizedList(new Vector());
    public AudioTrack mAudioTrack = null;
    public int mCamIndex = 0;
    public String mDevPwd = "";
    public String mDevUID = "";
    public List<IRegisterIOTCListener> mIOTCListeners = Collections.synchronizedList(new Vector());
    public boolean mInitAudio = false;
    public volatile int mSID = -1;
    public volatile int mSessionMode = -1;
    public ThreadCheckDevStatus mThreadChkDevStatus = null;
    public ThreadConnectDev mThreadConnectDev = null;
    public ThreadSendAudio mThreadSendAudio = null;
    public final Object mWaitObjectForConnected = new Object();

    public class AVChannel {
        public int AudioBPS;
        public AVFrameQueue AudioFrameQueue;
        public IOCtrlQueue IOCtrlQueue;
        public Bitmap LastFrame;
        public int VideoBPS;
        public int VideoFPS;
        public AVFrameQueue VideoFrameQueue;
        public volatile int mAVIndex = -1;
        public int mAudioCodec;
        public volatile int mChannel = -1;
        public long mServiceType = -1;
        public String mViewAcc;
        public String mViewPwd;
        public ThreadDecodeAudio threadDecAudio = null;
        public ThreadDecodeVideo2 threadDecVideo = null;
        public ThreadRecvAudio threadRecvAudio = null;
        public ThreadRecvIOCtrl threadRecvIOCtrl = null;
        public ThreadRecvVideo2 threadRecvVideo = null;
        public ThreadSendIOCtrl threadSendIOCtrl = null;
        public ThreadStartDev threadStartDev = null;

        public AVChannel(int i, String str, String str2) {
            this.mChannel = i;
            this.mViewAcc = str;
            this.mViewPwd = str2;
            this.mServiceType = -1;
            this.AudioBPS = 0;
            this.VideoBPS = 0;
            this.VideoFPS = 0;
            this.LastFrame = null;
            this.IOCtrlQueue = new IOCtrlQueue();
            this.VideoFrameQueue = new AVFrameQueue();
            this.AudioFrameQueue = new AVFrameQueue();
        }

        public synchronized int getAVIndex() {
            return this.mAVIndex;
        }

        public synchronized int getAudioCodec() {
            return this.mAudioCodec;
        }

        public int getChannel() {
            return this.mChannel;
        }

        public synchronized long getServiceType() {
            return this.mServiceType;
        }

        public String getViewAcc() {
            return this.mViewAcc;
        }

        public String getViewPwd() {
            return this.mViewPwd;
        }

        public synchronized void setAVIndex(int i) {
            this.mAVIndex = i;
        }

        public synchronized void setAudioCodec(int i) {
            this.mAudioCodec = i;
        }

        public synchronized void setServiceType(long j) {
            this.mServiceType = j;
            this.mAudioCodec = (j & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) == 0 ? AVFrame.MEDIA_CODEC_AUDIO_SPEEX : AVFrame.MEDIA_CODEC_AUDIO_ADPCM;
        }
    }

    public class IOCtrlQueue {
        public LinkedList<IOCtrlSet> listData;

        public class IOCtrlSet {
            public byte[] IOCtrlBuf;
            public int IOCtrlType;

            public IOCtrlSet(int i, int i2, byte[] bArr) {
                this.IOCtrlType = i2;
                this.IOCtrlBuf = bArr;
            }

            public IOCtrlSet(int i, byte[] bArr) {
                this.IOCtrlType = i;
                this.IOCtrlBuf = bArr;
            }
        }

        public IOCtrlQueue() {
            this.listData = new LinkedList<>();
        }

        public synchronized IOCtrlSet Dequeue() {
            return this.listData.isEmpty() ? null : this.listData.removeFirst();
        }

        public synchronized void Enqueue(int i, int i2, byte[] bArr) {
            this.listData.addLast(new IOCtrlSet(i, i2, bArr));
        }

        public synchronized void Enqueue(int i, byte[] bArr) {
            this.listData.addLast(new IOCtrlSet(i, bArr));
        }

        public synchronized boolean isEmpty() {
            return this.listData.isEmpty();
        }

        public synchronized void removeAll() {
            if (!this.listData.isEmpty()) {
                this.listData.clear();
            }
        }
    }

    public class ThreadCheckDevStatus extends Thread {
        public boolean m_bIsRunning;
        public Object m_waitObjForCheckDevStatus;

        public ThreadCheckDevStatus() {
            this.m_bIsRunning = false;
            this.m_waitObjForCheckDevStatus = new Object();
        }

        public void run() {
            super.run();
            this.m_bIsRunning = true;
            St_SInfo st_SInfo = new St_SInfo();
            while (this.m_bIsRunning && Camera.this.mSID < 0) {
                try {
                    synchronized (Camera.this.mWaitObjectForConnected) {
                        Camera.this.mWaitObjectForConnected.wait(1000);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            while (this.m_bIsRunning) {
                if (Camera.this.mSID >= 0) {
                    int IOTC_Session_Check = IOTCAPIs.IOTC_Session_Check(Camera.this.mSID, st_SInfo);
                    if (IOTC_Session_Check >= 0) {
                        int access$600 = Camera.this.mSessionMode;
                        byte b2 = st_SInfo.Mode;
                        if (access$600 != b2) {
                            int unused = Camera.this.mSessionMode = b2;
                        }
                    } else {
                        int i = 0;
                        if (IOTC_Session_Check == -23 || IOTC_Session_Check == -13) {
                            StringBuilder n = a.n("IOTC_Session_Check(");
                            n.append(Camera.this.mSID);
                            n.append(") timeout");
                            Log.i("IOTCamera", n.toString());
                            while (i < Camera.this.mIOTCListeners.size()) {
                                ((IRegisterIOTCListener) Camera.this.mIOTCListeners.get(i)).receiveSessionInfo(Camera.this, 6);
                                i++;
                            }
                        } else {
                            StringBuilder n2 = a.n("IOTC_Session_Check(");
                            n2.append(Camera.this.mSID);
                            n2.append(") Failed return ");
                            n2.append(IOTC_Session_Check);
                            Log.i("IOTCamera", n2.toString());
                            while (i < Camera.this.mIOTCListeners.size()) {
                                ((IRegisterIOTCListener) Camera.this.mIOTCListeners.get(i)).receiveSessionInfo(Camera.this, 8);
                                i++;
                            }
                        }
                    }
                }
                synchronized (this.m_waitObjForCheckDevStatus) {
                    try {
                        this.m_waitObjForCheckDevStatus.wait(5000);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            Log.i("IOTCamera", "===ThreadCheckDevStatus exit===");
        }

        public void stopThread() {
            this.m_bIsRunning = false;
            synchronized (this.m_waitObjForCheckDevStatus) {
                this.m_waitObjForCheckDevStatus.notify();
            }
        }
    }

    public class ThreadConnectDev extends Thread {
        public int mConnType = -1;
        public boolean mIsRunning = false;
        public Object m_waitForStopConnectThread = new Object();

        public ThreadConnectDev(int i) {
            this.mConnType = i;
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public void run() {
            /*
                r7 = this;
                r0 = 1
                r7.mIsRunning = r0
                r1 = 0
                r2 = 0
            L_0x0005:
                boolean r3 = r7.mIsRunning
                if (r3 == 0) goto L_0x01d0
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                int r3 = r3.mSID
                if (r3 >= 0) goto L_0x01d0
                r3 = 0
            L_0x0012:
                com.tutk.IOTC.Camera r4 = com.tutk.IOTC.Camera.this
                java.util.List r4 = r4.mIOTCListeners
                int r4 = r4.size()
                if (r3 >= r4) goto L_0x0032
                com.tutk.IOTC.Camera r4 = com.tutk.IOTC.Camera.this
                java.util.List r4 = r4.mIOTCListeners
                java.lang.Object r4 = r4.get(r3)
                com.tutk.IOTC.IRegisterIOTCListener r4 = (com.tutk.IOTC.IRegisterIOTCListener) r4
                com.tutk.IOTC.Camera r5 = com.tutk.IOTC.Camera.this
                r4.receiveSessionInfo(r5, r0)
                int r3 = r3 + 1
                goto L_0x0012
            L_0x0032:
                int r3 = r7.mConnType
                r4 = 2
                if (r3 != 0) goto L_0x006f
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                java.lang.String r5 = r3.mDevUID
                int r5 = com.tutk.IOTC.IOTCAPIs.IOTC_Connect_ByUID(r5)
                int unused = r3.mSID = r5
                java.lang.String r3 = "IOTCamera"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "IOTC_Connect_ByUID("
                r5.append(r6)
                com.tutk.IOTC.Camera r6 = com.tutk.IOTC.Camera.this
                java.lang.String r6 = r6.mDevUID
            L_0x0056:
                r5.append(r6)
                java.lang.String r6 = ") returns "
                r5.append(r6)
                com.tutk.IOTC.Camera r6 = com.tutk.IOTC.Camera.this
                int r6 = r6.mSID
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                android.util.Log.i(r3, r5)
                goto L_0x00a5
            L_0x006f:
                if (r3 != r0) goto L_0x01cf
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                java.lang.String r5 = r3.mDevUID
                com.tutk.IOTC.Camera r6 = com.tutk.IOTC.Camera.this
                java.lang.String r6 = r6.mDevPwd
                int r5 = com.tutk.IOTC.IOTCAPIs.IOTC_Connect_ByUID2(r5, r6, r4)
                int unused = r3.mSID = r5
                java.lang.String r3 = "IOTCamera"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "IOTC_Connect_ByUID2("
                r5.append(r6)
                com.tutk.IOTC.Camera r6 = com.tutk.IOTC.Camera.this
                java.lang.String r6 = r6.mDevUID
                r5.append(r6)
                java.lang.String r6 = ", "
                r5.append(r6)
                com.tutk.IOTC.Camera r6 = com.tutk.IOTC.Camera.this
                java.lang.String r6 = r6.mDevPwd
                goto L_0x0056
            L_0x00a5:
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                int r3 = r3.mSID
                if (r3 < 0) goto L_0x00e9
                com.tutk.IOTC.St_SInfo r3 = new com.tutk.IOTC.St_SInfo
                r3.<init>()
                r3 = 0
            L_0x00b3:
                com.tutk.IOTC.Camera r5 = com.tutk.IOTC.Camera.this
                java.util.List r5 = r5.mIOTCListeners
                int r5 = r5.size()
                if (r3 >= r5) goto L_0x00d3
                com.tutk.IOTC.Camera r5 = com.tutk.IOTC.Camera.this
                java.util.List r5 = r5.mIOTCListeners
                java.lang.Object r5 = r5.get(r3)
                com.tutk.IOTC.IRegisterIOTCListener r5 = (com.tutk.IOTC.IRegisterIOTCListener) r5
                com.tutk.IOTC.Camera r6 = com.tutk.IOTC.Camera.this
                r5.receiveSessionInfo(r6, r4)
                int r3 = r3 + 1
                goto L_0x00b3
            L_0x00d3:
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                java.lang.Object r3 = r3.mWaitObjectForConnected
                monitor-enter(r3)
                com.tutk.IOTC.Camera r4 = com.tutk.IOTC.Camera.this     // Catch:{ all -> 0x00e6 }
                java.lang.Object r4 = r4.mWaitObjectForConnected     // Catch:{ all -> 0x00e6 }
                r4.notify()     // Catch:{ all -> 0x00e6 }
                monitor-exit(r3)     // Catch:{ all -> 0x00e6 }
                goto L_0x0005
            L_0x00e6:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x00e6 }
                throw r0
            L_0x00e9:
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                int r3 = r3.mSID
                r4 = -20
                if (r3 != r4) goto L_0x0109
                java.lang.Object r3 = r7.m_waitForStopConnectThread     // Catch:{ InterruptedException -> 0x0103 }
                monitor-enter(r3)     // Catch:{ InterruptedException -> 0x0103 }
                java.lang.Object r4 = r7.m_waitForStopConnectThread     // Catch:{ all -> 0x0100 }
                r5 = 1000(0x3e8, double:4.94E-321)
                r4.wait(r5)     // Catch:{ all -> 0x0100 }
                monitor-exit(r3)     // Catch:{ all -> 0x0100 }
                goto L_0x0005
            L_0x0100:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0100 }
                throw r4     // Catch:{ InterruptedException -> 0x0103 }
            L_0x0103:
                r3 = move-exception
                r3.printStackTrace()
                goto L_0x0005
            L_0x0109:
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                int r3 = r3.mSID
                r4 = -15
                r5 = -13
                if (r3 == r4) goto L_0x018a
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                int r3 = r3.mSID
                r4 = -10
                if (r3 == r4) goto L_0x018a
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                int r3 = r3.mSID
                r4 = -19
                if (r3 == r4) goto L_0x018a
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                int r3 = r3.mSID
                if (r3 != r5) goto L_0x0132
                goto L_0x018a
            L_0x0132:
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                int r0 = r0.mSID
                r2 = -36
                if (r0 == r2) goto L_0x0169
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                int r0 = r0.mSID
                r2 = -37
                if (r0 != r2) goto L_0x0147
                goto L_0x0169
            L_0x0147:
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                java.util.List r0 = r0.mIOTCListeners
                int r0 = r0.size()
                if (r1 >= r0) goto L_0x01d0
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                java.util.List r0 = r0.mIOTCListeners
                java.lang.Object r0 = r0.get(r1)
                com.tutk.IOTC.IRegisterIOTCListener r0 = (com.tutk.IOTC.IRegisterIOTCListener) r0
                com.tutk.IOTC.Camera r2 = com.tutk.IOTC.Camera.this
                r3 = 8
                r0.receiveSessionInfo(r2, r3)
                int r1 = r1 + 1
                goto L_0x0147
            L_0x0169:
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                java.util.List r0 = r0.mIOTCListeners
                int r0 = r0.size()
                if (r1 >= r0) goto L_0x01d0
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                java.util.List r0 = r0.mIOTCListeners
                java.lang.Object r0 = r0.get(r1)
                com.tutk.IOTC.IRegisterIOTCListener r0 = (com.tutk.IOTC.IRegisterIOTCListener) r0
                com.tutk.IOTC.Camera r2 = com.tutk.IOTC.Camera.this
                r3 = 7
                r0.receiveSessionInfo(r2, r3)
                int r1 = r1 + 1
                goto L_0x0169
            L_0x018a:
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                int r3 = r3.mSID
                if (r3 == r5) goto L_0x01b4
                r3 = 0
            L_0x0193:
                com.tutk.IOTC.Camera r4 = com.tutk.IOTC.Camera.this
                java.util.List r4 = r4.mIOTCListeners
                int r4 = r4.size()
                if (r3 >= r4) goto L_0x01b4
                com.tutk.IOTC.Camera r4 = com.tutk.IOTC.Camera.this
                java.util.List r4 = r4.mIOTCListeners
                java.lang.Object r4 = r4.get(r3)
                com.tutk.IOTC.IRegisterIOTCListener r4 = (com.tutk.IOTC.IRegisterIOTCListener) r4
                com.tutk.IOTC.Camera r5 = com.tutk.IOTC.Camera.this
                r6 = 4
                r4.receiveSessionInfo(r5, r6)
                int r3 = r3 + 1
                goto L_0x0193
            L_0x01b4:
                int r2 = r2 + 1
                r3 = 60
                if (r2 <= r3) goto L_0x01be
                r3 = 60000(0xea60, double:2.9644E-319)
                goto L_0x01c1
            L_0x01be:
                int r3 = r2 * 1000
                long r3 = (long) r3
            L_0x01c1:
                java.lang.Object r5 = r7.m_waitForStopConnectThread     // Catch:{ InterruptedException -> 0x0103 }
                monitor-enter(r5)     // Catch:{ InterruptedException -> 0x0103 }
                java.lang.Object r6 = r7.m_waitForStopConnectThread     // Catch:{ all -> 0x01cc }
                r6.wait(r3)     // Catch:{ all -> 0x01cc }
                monitor-exit(r5)     // Catch:{ all -> 0x01cc }
                goto L_0x0005
            L_0x01cc:
                r3 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x01cc }
                throw r3     // Catch:{ InterruptedException -> 0x0103 }
            L_0x01cf:
                return
            L_0x01d0:
                java.lang.String r0 = "IOTCamera"
                java.lang.String r1 = "===ThreadConnectDev exit==="
                android.util.Log.i(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tutk.IOTC.Camera.ThreadConnectDev.run():void");
        }

        public void stopThread() {
            this.mIsRunning = false;
            if (Camera.this.mSID < 0) {
                IOTCAPIs.IOTC_Connect_Stop();
            }
            synchronized (this.m_waitForStopConnectThread) {
                this.m_waitForStopConnectThread.notify();
            }
        }
    }

    public class ThreadDecodeAudio extends Thread {
        public AVChannel mAVChannel;
        public boolean mStopedDecodeAudio = false;

        public ThreadDecodeAudio(AVChannel aVChannel) {
            this.mAVChannel = aVChannel;
        }

        public void run() {
            int i;
            short s;
            int i2;
            int frmSize;
            int i3;
            byte[] bArr = new byte[65535];
            short[] sArr = new short[DrawerLayout.PEEK_DELAY];
            byte[] bArr2 = new byte[640];
            byte[] bArr3 = new byte[2048];
            long[] jArr = new long[1];
            this.mStopedDecodeAudio = true;
            short s2 = -1;
            int i4 = -1;
            int i5 = -1;
            byte b2 = -1;
            boolean z = true;
            boolean z2 = false;
            int i6 = 0;
            while (this.mStopedDecodeAudio) {
                if (this.mAVChannel.AudioFrameQueue.getCount() > 0) {
                    AVFrame removeHead = this.mAVChannel.AudioFrameQueue.removeHead();
                    s2 = removeHead.getCodecId();
                    if (!z || Camera.this.mInitAudio || !(s2 == 142 || s2 == 141 || s2 == 139 || s2 == 140 || s2 == 143)) {
                        i = 2;
                    } else {
                        int samplerate = AVFrame.getSamplerate(removeHead.getFlags());
                        int i7 = (removeHead.getFlags() & 2) == 2 ? 1 : 0;
                        b2 = removeHead.getFlags() & 1;
                        z2 = Camera.this.audioDev_init(samplerate, b2, i7, s2);
                        if (!z2) {
                            break;
                        }
                        i5 = i7;
                        z = false;
                        i4 = samplerate;
                        i = 2;
                    }
                    int i8 = 16;
                    if (s2 == 141) {
                        DecSpeex.Decode(removeHead.frmData, removeHead.getFrmSize(), sArr);
                        Camera.this.mAudioTrack.write(sArr, 0, DrawerLayout.PEEK_DELAY);
                        if (b2 == 0) {
                            i = 1;
                        }
                        int i9 = i * i4;
                        if (i5 == 0) {
                            i8 = 8;
                        }
                        i3 = ((i9 * i8) / 8) / DrawerLayout.PEEK_DELAY;
                    } else {
                        if (s2 == 142) {
                            frmSize = DecMp3.Decode(removeHead.frmData, removeHead.getFrmSize(), bArr);
                            Camera.this.mAudioTrack.write(bArr, 0, frmSize);
                            if (b2 == 0) {
                                i = 1;
                            }
                            int i10 = i * i4;
                            if (i5 == 0) {
                                i8 = 8;
                            }
                            i2 = (i10 * i8) / 8;
                        } else if (s2 == 139) {
                            DecADPCM.Decode(removeHead.frmData, removeHead.getFrmSize(), bArr2);
                            Camera.this.mAudioTrack.write(bArr2, 0, 640);
                            if (b2 == 0) {
                                i = 1;
                            }
                            int i11 = i * i4;
                            if (i5 == 0) {
                                i8 = 8;
                            }
                            i3 = ((i11 * i8) / 8) / 640;
                        } else if (s2 == 140) {
                            Camera.this.mAudioTrack.write(removeHead.frmData, 0, removeHead.getFrmSize());
                            int i12 = (b2 == 0 ? 1 : 2) * i4;
                            if (i5 == 0) {
                                i8 = 8;
                            }
                            i2 = (i12 * i8) / 8;
                            frmSize = removeHead.getFrmSize();
                        } else {
                            if (s2 == 143) {
                                s = s2;
                                DecG726.g726_decode(removeHead.frmData, (long) removeHead.getFrmSize(), bArr3, jArr);
                                Log.i("IOTCamera", "G726 decode size:" + jArr[0]);
                                Camera.this.mAudioTrack.write(bArr3, 0, (int) jArr[0]);
                                int i13 = (b2 == 0 ? 1 : 2) * i4;
                                if (i5 == 0) {
                                    i8 = 8;
                                }
                                i6 = ((i13 * i8) / 8) / ((int) jArr[0]);
                                Thread.sleep((long) (1000 / i6));
                                s2 = s;
                            }
                            s = s2;
                            Thread.sleep((long) (1000 / i6));
                            s2 = s;
                        }
                        i3 = i2 / frmSize;
                    }
                    i6 = i3;
                    s = s2;
                    try {
                        Thread.sleep((long) (1000 / i6));
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    s2 = s;
                } else {
                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            if (z2) {
                Camera.this.audioDev_stop(s2);
            }
            Log.i("IOTCamera", "===ThreadDecodeAudio exit===");
        }

        public void stopThread() {
            this.mStopedDecodeAudio = false;
        }
    }

    public class ThreadDecodeVideo extends Thread {
        public static final int MAX_FRAMEBUF = 2764800;
        public AVChannel mAVChannel;
        public boolean m_bIsRunning = false;

        public ThreadDecodeVideo(AVChannel aVChannel) {
            this.mAVChannel = aVChannel;
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public void run() {
            /*
                r38 = this;
                r1 = r38
                java.lang.System.gc()
                r0 = 4
                int[] r2 = new int[r0]
                r0 = 2764800(0x2a3000, float:3.87431E-39)
                byte[] r9 = new byte[r0]
                r10 = 1
                int[] r11 = new int[r10]
                int[] r12 = new int[r10]
                int[] r13 = new int[r10]
                com.tutk.IOTC.Camera$AVChannel r0 = r1.mAVChannel
                r14 = 0
                r0.VideoFPS = r14
                r1.m_bIsRunning = r10
                java.lang.System.gc()
                r15 = 0
                r16 = 0
                r20 = r15
                r21 = r20
                r4 = r16
                r22 = r4
                r24 = r22
                r26 = r24
                r6 = 0
                r7 = 0
                r8 = 0
                r18 = 0
                r19 = 0
            L_0x0034:
                boolean r0 = r1.m_bIsRunning
                if (r0 == 0) goto L_0x0369
                com.tutk.IOTC.Camera$AVChannel r0 = r1.mAVChannel
                com.tutk.IOTC.AVFrameQueue r0 = r0.VideoFrameQueue
                int r0 = r0.getCount()
                if (r0 <= 0) goto L_0x032c
                com.tutk.IOTC.Camera$AVChannel r0 = r1.mAVChannel
                com.tutk.IOTC.AVFrameQueue r0 = r0.VideoFrameQueue
                com.tutk.IOTC.AVFrame r3 = r0.removeHead()
                if (r3 != 0) goto L_0x0066
            L_0x004c:
                r31 = r2
                r10 = r6
                r32 = r8
                r29 = r12
                r30 = r13
                r2 = r26
                r28 = 1
                r36 = r15
                r15 = r7
                r6 = r22
                r22 = r9
                r23 = r11
                r9 = r36
                goto L_0x034f
            L_0x0066:
                int r0 = r3.getFrmSize()
                boolean r28 = r3.isIFrame()
                if (r28 != 0) goto L_0x008d
                r10 = 30
                if (r8 < r10) goto L_0x008d
                r3.frmData = r15
                java.lang.String r0 = "IOTCamera"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r10 = "(avFrame != null && avFrame == pFrame && delayFrameCount = "
                r3.append(r10)
                r3.append(r8)
                java.lang.String r3 = r3.toString()
                android.util.Log.i(r0, r3)
                goto L_0x004c
            L_0x008d:
                if (r0 <= 0) goto L_0x02ff
                r13[r14] = r14
                r11[r14] = r14
                r12[r14] = r14
                short r10 = r3.getCodecId()
                r15 = 78
                if (r10 != r15) goto L_0x00be
                long r24 = java.lang.System.currentTimeMillis()
                if (r18 != 0) goto L_0x00b1
                com.decoder.util.DecH264.InitDecoder()
                r14 = r3
                r30 = r4
                r10 = r6
                r15 = r7
                r32 = r8
                r18 = 1
                goto L_0x0114
            L_0x00b1:
                byte[] r10 = r3.frmData
                com.decoder.util.DecH264.DecoderNal(r10, r0, r2, r9)
            L_0x00b6:
                r14 = r3
                r30 = r4
                r10 = r6
                r15 = r7
                r32 = r8
                goto L_0x0114
            L_0x00be:
                short r10 = r3.getCodecId()
                r14 = 76
                if (r10 != r14) goto L_0x00b6
                if (r19 != 0) goto L_0x0102
                byte[] r0 = r3.frmData
                r10 = 23
                byte r10 = r0[r10]
                r10 = r10 & 15
                int r10 = r10 << 9
                r14 = 24
                byte r14 = r0[r14]
                r14 = r14 & 255(0xff, float:3.57E-43)
                r19 = 1
                int r14 = r14 << 1
                r10 = r10 | r14
                r14 = 25
                byte r15 = r0[r14]
                r15 = r15 & 128(0x80, float:1.794E-43)
                int r15 = r15 >> 7
                r10 = r10 | r15
                byte r14 = r0[r14]
                r14 = r14 & 63
                int r14 = r14 << 7
                r15 = 26
                byte r0 = r0[r15]
                r0 = r0 & 254(0xfe, float:3.56E-43)
                r15 = 1
                int r0 = r0 >> r15
                r0 = r0 | r14
                com.decoder.util.DecMpeg4.InitDecoder(r10, r0)
                r14 = r3
                r30 = r4
                r10 = r6
                r15 = r7
                r32 = r8
                r19 = 1
                goto L_0x0114
            L_0x0102:
                byte[] r10 = r3.frmData
                r14 = r3
                r3 = r10
                r30 = r4
                r4 = r0
                r5 = r9
                r10 = r6
                r6 = r13
                r15 = r7
                r7 = r11
                r32 = r8
                r8 = r12
                com.decoder.util.DecMpeg4.Decode(r3, r4, r5, r6, r7, r8)
            L_0x0114:
                short r0 = r14.getCodecId()
                r3 = 2
                r4 = 78
                if (r0 != r4) goto L_0x0132
                r0 = r2[r3]
                r4 = 0
                r11[r4] = r0
                r0 = 3
                r0 = r2[r0]
                r12[r4] = r0
                r0 = r11[r4]
                r5 = r12[r4]
                int r0 = r0 * r5
                int r0 = r0 * 2
                r13[r4] = r0
                goto L_0x0133
            L_0x0132:
                r4 = 0
            L_0x0133:
                r0 = r13[r4]
                if (r0 <= 0) goto L_0x02e4
                r0 = r11[r4]
                if (r0 <= 0) goto L_0x02e4
                r0 = r12[r4]
                if (r0 <= 0) goto L_0x02e4
                r0 = r11[r4]
                if (r15 != r0) goto L_0x014f
                r0 = r12[r4]
                if (r10 == r0) goto L_0x0148
                goto L_0x014f
            L_0x0148:
                r6 = r10
                r7 = r15
                r5 = r20
                r8 = r21
                goto L_0x0160
            L_0x014f:
                r7 = r11[r4]
                r6 = r12[r4]
                r0 = r13[r4]
                byte[] r0 = new byte[r0]
                android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.RGB_565
                android.graphics.Bitmap r20 = android.graphics.Bitmap.createBitmap(r7, r6, r5)
                r8 = r0
                r5 = r20
            L_0x0160:
                if (r8 == 0) goto L_0x0170
                int r0 = r7 * r6
                int r0 = r0 * 2
                java.lang.System.arraycopy(r9, r4, r8, r4, r0)
                java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r9)
                r5.copyPixelsFromBuffer(r0)
            L_0x0170:
                com.tutk.IOTC.Camera$AVChannel r0 = r1.mAVChannel
                int r3 = r0.VideoFPS
                r28 = 1
                int r3 = r3 + 1
                r0.VideoFPS = r3
                r3 = r5
                r4 = r30
                int r0 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
                if (r0 == 0) goto L_0x025f
                r10 = r6
                r15 = r7
                r6 = r22
                int r0 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
                if (r0 == 0) goto L_0x024a
                r20 = r8
                r22 = r9
                long r8 = java.lang.System.currentTimeMillis()
                r21 = r10
                r23 = r11
                long r10 = r8 - r24
                int r0 = r14.getTimeStamp()
                r29 = r12
                r30 = r13
                long r12 = (long) r0
                long r12 = r12 - r4
                long r12 = r12 + r6
                long r12 = r12 - r8
                r31 = r2
                r33 = r3
                r2 = r26
                long r12 = r12 - r2
                java.lang.String r0 = "IOTCamera"
                r26 = r15
                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                r15.<init>()
                java.lang.String r1 = "decode time("
                r15.append(r1)
                r15.append(r10)
                java.lang.String r1 = "); sleep time ("
                r15.append(r1)
                r15.append(r12)
                java.lang.String r1 = ") = t0 ("
                r15.append(r1)
                r15.append(r6)
                java.lang.String r1 = ") + (Tn ("
                r15.append(r1)
                int r1 = r14.getTimeStamp()
                r15.append(r1)
                java.lang.String r1 = ") - T0 ("
                r15.append(r1)
                r15.append(r4)
                java.lang.String r1 = ") "
                r15.append(r1)
                int r1 = r14.getTimeStamp()
                long r10 = (long) r1
                long r10 = r10 - r4
                r15.append(r10)
                java.lang.String r1 = ") - tn' ("
                r15.append(r1)
                r15.append(r8)
                java.lang.String r1 = ") - Rt ("
                r15.append(r1)
                r15.append(r2)
                java.lang.String r1 = ")"
                r15.append(r1)
                java.lang.String r1 = r15.toString()
                android.util.Log.i(r0, r1)
                int r0 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
                if (r0 < 0) goto L_0x0229
                java.lang.Thread.sleep(r12)     // Catch:{ InterruptedException -> 0x0213 }
            L_0x0210:
                r1 = r38
                goto L_0x0219
            L_0x0213:
                r0 = move-exception
                r1 = r0
                r1.printStackTrace()
                goto L_0x0210
            L_0x0219:
                com.tutk.IOTC.Camera$AVChannel r0 = r1.mAVChannel
                com.tutk.IOTC.AVFrameQueue r0 = r0.VideoFrameQueue
                int r0 = r0.getCount()
                long r2 = (long) r0
                long r2 = r6 - r2
                r6 = r16
                r8 = 0
                goto L_0x027c
            L_0x0229:
                r1 = r38
                int r0 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
                if (r0 >= 0) goto L_0x023f
                r4 = -33
                int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x023f
                int r0 = r14.getTimeStamp()
                long r4 = (long) r0
                r6 = r2
                r2 = r8
                r8 = r32
                goto L_0x027c
            L_0x023f:
                int r0 = r14.getTimeStamp()
                long r4 = (long) r0
                int r0 = r32 + 1
                r6 = r2
                r2 = r8
                r8 = r0
                goto L_0x027c
            L_0x024a:
                r31 = r2
                r33 = r3
                r20 = r8
                r22 = r9
                r21 = r10
                r23 = r11
                r29 = r12
                r30 = r13
                r2 = r26
                r26 = r15
                goto L_0x0275
            L_0x025f:
                r31 = r2
                r33 = r3
                r21 = r6
                r20 = r8
                r29 = r12
                r30 = r13
                r2 = r26
                r26 = r7
                r6 = r22
                r22 = r9
                r23 = r11
            L_0x0275:
                r8 = r32
                r36 = r2
                r2 = r6
                r6 = r36
            L_0x027c:
                int r0 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
                if (r0 == 0) goto L_0x0284
                int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
                if (r0 != 0) goto L_0x028d
            L_0x0284:
                int r0 = r14.getTimeStamp()
                long r4 = (long) r0
                long r2 = java.lang.System.currentTimeMillis()
            L_0x028d:
                long r9 = java.lang.System.currentTimeMillis()
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                java.util.List r11 = r0.mIOTCListeners
                monitor-enter(r11)
                r0 = 0
            L_0x0299:
                com.tutk.IOTC.Camera r12 = com.tutk.IOTC.Camera.this     // Catch:{ all -> 0x02e1 }
                java.util.List r12 = r12.mIOTCListeners     // Catch:{ all -> 0x02e1 }
                int r12 = r12.size()     // Catch:{ all -> 0x02e1 }
                if (r0 >= r12) goto L_0x02c7
                com.tutk.IOTC.Camera r12 = com.tutk.IOTC.Camera.this     // Catch:{ all -> 0x02e1 }
                java.util.List r12 = r12.mIOTCListeners     // Catch:{ all -> 0x02e1 }
                java.lang.Object r12 = r12.get(r0)     // Catch:{ all -> 0x02e1 }
                com.tutk.IOTC.IRegisterIOTCListener r12 = (com.tutk.IOTC.IRegisterIOTCListener) r12     // Catch:{ all -> 0x02e1 }
                com.tutk.IOTC.Camera r13 = com.tutk.IOTC.Camera.this     // Catch:{ all -> 0x02e1 }
                com.tutk.IOTC.Camera$AVChannel r15 = r1.mAVChannel     // Catch:{ all -> 0x02e1 }
                int r15 = r15.getChannel()     // Catch:{ all -> 0x02e1 }
                r34 = r2
                r2 = r33
                r12.receiveFrameData(r13, r15, r2)     // Catch:{ all -> 0x02e1 }
                int r0 = r0 + 1
                r33 = r2
                r2 = r34
                goto L_0x0299
            L_0x02c7:
                r34 = r2
                r2 = r33
                monitor-exit(r11)     // Catch:{ all -> 0x02e1 }
                com.tutk.IOTC.Camera$AVChannel r0 = r1.mAVChannel
                r0.LastFrame = r2
                long r11 = java.lang.System.currentTimeMillis()
                long r11 = r11 - r9
                long r11 = r11 + r6
                r6 = r21
                r7 = r26
                r26 = r11
                r21 = r20
                r20 = r2
                goto L_0x0318
            L_0x02e1:
                r0 = move-exception
                monitor-exit(r11)     // Catch:{ all -> 0x02e1 }
                throw r0
            L_0x02e4:
                r29 = r12
                r6 = r22
                r4 = r30
                r28 = 1
                r31 = r2
                r22 = r9
                r23 = r11
                r30 = r13
                r2 = r26
                r26 = r2
                r34 = r6
                r6 = r10
                r7 = r15
                r8 = r32
                goto L_0x0318
            L_0x02ff:
                r31 = r2
                r14 = r3
                r10 = r6
                r15 = r7
                r32 = r8
                r29 = r12
                r30 = r13
                r6 = r22
                r2 = r26
                r28 = 1
                r22 = r9
                r23 = r11
                r34 = r6
                r6 = r10
                r7 = r15
            L_0x0318:
                r9 = 0
                r14.frmData = r9
                r15 = r9
                r9 = r22
                r11 = r23
                r12 = r29
                r13 = r30
                r2 = r31
                r22 = r34
                r10 = 1
                r14 = 0
                goto L_0x0034
            L_0x032c:
                r31 = r2
                r10 = r6
                r32 = r8
                r29 = r12
                r30 = r13
                r2 = r26
                r28 = 1
                r36 = r15
                r15 = r7
                r6 = r22
                r22 = r9
                r23 = r11
                r9 = r36
                r11 = 4
                java.lang.Thread.sleep(r11)     // Catch:{ InterruptedException -> 0x034a }
                goto L_0x034f
            L_0x034a:
                r0 = move-exception
                r8 = r0
                r8.printStackTrace()
            L_0x034f:
                r26 = r2
                r11 = r23
                r12 = r29
                r13 = r30
                r2 = r31
                r8 = r32
                r14 = 0
                r36 = r15
                r15 = r9
                r9 = r22
                r22 = r6
                r6 = r10
                r7 = r36
                r10 = 1
                goto L_0x0034
            L_0x0369:
                if (r18 == 0) goto L_0x036e
                com.decoder.util.DecH264.UninitDecoder()
            L_0x036e:
                if (r19 == 0) goto L_0x0373
                com.decoder.util.DecMpeg4.UninitDecoder()
            L_0x0373:
                if (r20 == 0) goto L_0x0378
                r20.recycle()
            L_0x0378:
                java.lang.System.gc()
                java.lang.String r0 = "IOTCamera"
                java.lang.String r2 = "===ThreadDecodeVideo exit==="
                android.util.Log.i(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tutk.IOTC.Camera.ThreadDecodeVideo.run():void");
        }

        public void stopThread() {
            this.m_bIsRunning = false;
        }
    }

    public class ThreadDecodeVideo2 extends Thread {
        public static final int MAX_FRAMEBUF = 2764800;
        public AVChannel mAVChannel;
        public boolean m_bIsRunning = false;

        public ThreadDecodeVideo2(AVChannel aVChannel) {
            this.mAVChannel = aVChannel;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x01e1: MOVE  (r9v10 int) = (r31v0 int)
            	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
            */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00f8  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x011d  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x01b9  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x01ce  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x01db  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x02c6  */
        public void run() {
            /*
                r34 = this;
                r1 = r34
                java.lang.System.gc()
                r0 = 4
                int[] r0 = new int[r0]
                r2 = 2764800(0x2a3000, float:3.87431E-39)
                byte[] r2 = new byte[r2]
                r3 = 1
                int[] r4 = new int[r3]
                int[] r5 = new int[r3]
                int[] r6 = new int[r3]
                com.tutk.IOTC.Camera$AVChannel r7 = r1.mAVChannel
                r8 = 0
                r7.VideoFPS = r8
                r1.m_bIsRunning = r3
                java.lang.System.gc()
                r9 = 0
                r3 = 0
                r7 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r3 = r2
                r7 = r6
                r11 = r9
                r15 = r11
                r17 = r15
                r21 = r13
                r22 = r14
                r8 = 0
                r19 = 0
                r20 = 0
                r23 = 0
                r2 = r0
                r6 = r5
                r13 = r17
                r5 = r4
                r4 = 0
            L_0x003d:
                boolean r0 = r1.m_bIsRunning
                if (r0 == 0) goto L_0x02ff
                com.tutk.IOTC.Camera$AVChannel r0 = r1.mAVChannel
                com.tutk.IOTC.AVFrameQueue r0 = r0.VideoFrameQueue
                int r0 = r0.getCount()
                if (r0 <= 0) goto L_0x02ef
                com.tutk.IOTC.Camera$AVChannel r0 = r1.mAVChannel
                com.tutk.IOTC.AVFrameQueue r0 = r0.VideoFrameQueue
                com.tutk.IOTC.AVFrame r0 = r0.removeHead()
                if (r0 != 0) goto L_0x0057
                goto L_0x02fb
            L_0x0057:
                int r24 = r0.getFrmSize()
                r25 = r20
                r26 = r21
                r27 = r22
                r21 = r15
                r15 = r9
                r9 = r19
                r10 = r3
                r19 = r13
                r3 = r2
                r13 = r7
                r14 = r8
                r2 = r1
                r1 = r23
                r32 = r11
                r11 = r5
                r12 = r6
                r5 = r24
                r23 = r17
                r17 = r32
            L_0x0079:
                com.tutk.IOTC.Camera$AVChannel r6 = r2.mAVChannel
                com.tutk.IOTC.AVFrameQueue r6 = r6.VideoFrameQueue
                int r6 = r6.getCount()
                r28 = 1000(0x3e8, double:4.94E-321)
                if (r6 <= 0) goto L_0x0144
                int r6 = (r15 > r28 ? 1 : (r15 == r28 ? 0 : -1))
                if (r6 <= 0) goto L_0x0144
                com.tutk.IOTC.Camera$AVChannel r6 = r2.mAVChannel
                com.tutk.IOTC.AVFrameQueue r6 = r6.VideoFrameQueue
                com.tutk.IOTC.AVFrame r6 = r6.removeHead()
                if (r6 != 0) goto L_0x0094
                goto L_0x0079
            L_0x0094:
                long r7 = (long) r1
                int r1 = r6.getTimeStamp()
                r30 = r2
                long r1 = (long) r1
                long r1 = r1 - r17
                long r1 = r1 + r7
                int r2 = (int) r1
                java.lang.String r1 = "IOTCamera"
                java.lang.String r7 = "low decode performance, drop "
                java.lang.StringBuilder r7 = a.a.a.a.a.n(r7)
                boolean r8 = r6.isIFrame()
                if (r8 == 0) goto L_0x00b3
                r28 = r0
                r0 = r30
                goto L_0x0115
            L_0x00b3:
                java.lang.String r8 = "P"
                r28 = r0
                r0 = r30
            L_0x00b9:
                r7.append(r8)
                java.lang.String r8 = " frame, skip time: "
                r7.append(r8)
                int r8 = r6.getTimeStamp()
                r29 = r3
                r30 = r4
                long r3 = (long) r8
                long r3 = r3 - r17
                r7.append(r3)
                java.lang.String r3 = ", total skip: "
                r7.append(r3)
                r7.append(r2)
                java.lang.String r3 = r7.toString()
                android.util.Log.i(r1, r3)
                int r1 = r6.getTimeStamp()
                long r3 = (long) r1
                com.tutk.IOTC.Camera$AVChannel r1 = r0.mAVChannel
                com.tutk.IOTC.AVFrameQueue r1 = r1.VideoFrameQueue
                boolean r1 = r1.isFirstIFrame()
                if (r1 != 0) goto L_0x011d
                com.tutk.IOTC.Camera$AVChannel r1 = r0.mAVChannel
                com.tutk.IOTC.AVFrameQueue r1 = r1.VideoFrameQueue
                com.tutk.IOTC.AVFrame r6 = r1.removeHead()
                if (r6 != 0) goto L_0x00f8
                goto L_0x011d
            L_0x00f8:
                long r1 = (long) r2
                int r7 = r6.getTimeStamp()
                long r7 = (long) r7
                long r7 = r7 - r3
                long r7 = r7 + r1
                int r2 = (int) r7
                java.lang.String r1 = "IOTCamera"
                java.lang.String r7 = "low decode performance, drop "
                java.lang.StringBuilder r7 = a.a.a.a.a.n(r7)
                boolean r8 = r6.isIFrame()
                r17 = r3
                r3 = r29
                r4 = r30
                if (r8 == 0) goto L_0x0118
            L_0x0115:
                java.lang.String r8 = "I"
                goto L_0x00b9
            L_0x0118:
                r30 = r0
                r0 = r28
                goto L_0x00b3
            L_0x011d:
                long r1 = (long) r2
                long r1 = r15 - r1
                java.lang.String r6 = "IOTCamera"
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = "delayTime: "
                r7.append(r8)
                r7.append(r1)
                java.lang.String r7 = r7.toString()
                android.util.Log.i(r6, r7)
                r6 = 0
                r15 = r1
                r17 = r3
                r3 = r29
                r4 = r30
                r1 = 0
                r2 = r0
                r0 = r28
                goto L_0x0079
            L_0x0144:
                r30 = r2
                if (r5 <= 0) goto L_0x02d0
                r1 = 0
                r13[r1] = r1
                r11[r1] = r1
                r12[r1] = r1
                short r1 = r0.getCodecId()
                r2 = 78
                if (r1 != r2) goto L_0x0167
                java.lang.System.currentTimeMillis()
                if (r25 != 0) goto L_0x0161
                com.decoder.util.DecH264.InitDecoder()
                r25 = 1
            L_0x0161:
                byte[] r1 = r0.frmData
                com.decoder.util.DecH264.DecoderNal(r1, r5, r3, r10)
                goto L_0x01b0
            L_0x0167:
                short r1 = r0.getCodecId()
                r6 = 76
                if (r1 != r6) goto L_0x01b0
                if (r4 != 0) goto L_0x01a2
                byte[] r1 = r0.frmData
                r4 = 23
                byte r4 = r1[r4]
                r4 = r4 & 15
                int r4 = r4 << 9
                r6 = 24
                byte r6 = r1[r6]
                r6 = r6 & 255(0xff, float:3.57E-43)
                int r6 = r6 << 1
                r4 = r4 | r6
                r6 = 25
                byte r7 = r1[r6]
                r7 = r7 & 128(0x80, float:1.794E-43)
                int r7 = r7 >> 7
                r4 = r4 | r7
                byte r6 = r1[r6]
                r6 = r6 & 63
                int r6 = r6 << 7
                r7 = 26
                byte r1 = r1[r7]
                r1 = r1 & 254(0xfe, float:3.56E-43)
                int r1 = r1 >> 1
                r1 = r1 | r6
                com.decoder.util.DecMpeg4.InitDecoder(r4, r1)
                r4 = 1
                r1 = 1
                goto L_0x01a3
            L_0x01a2:
                r1 = r4
            L_0x01a3:
                byte[] r4 = r0.frmData
                r6 = r10
                r7 = r13
                r8 = r11
                r31 = r9
                r9 = r12
                com.decoder.util.DecMpeg4.Decode(r4, r5, r6, r7, r8, r9)
                r4 = r1
                goto L_0x01b2
            L_0x01b0:
                r31 = r9
            L_0x01b2:
                short r1 = r0.getCodecId()
                r5 = 2
                if (r1 != r2) goto L_0x01ce
                r1 = r3[r5]
                r2 = 0
                r11[r2] = r1
                r1 = 3
                r1 = r3[r1]
                r12[r2] = r1
                r1 = r11[r2]
                r5 = r12[r2]
                int r1 = r1 * r5
                int r1 = r1 * 2
                r13[r2] = r1
                goto L_0x01cf
            L_0x01ce:
                r2 = 0
            L_0x01cf:
                r1 = r13[r2]
                if (r1 <= 0) goto L_0x02c6
                r1 = r11[r2]
                if (r1 <= 0) goto L_0x02c6
                r1 = r12[r2]
                if (r1 <= 0) goto L_0x02c6
                r1 = r11[r2]
                if (r14 != r1) goto L_0x01eb
                r1 = r12[r2]
                r9 = r31
                if (r9 == r1) goto L_0x01e6
                goto L_0x01eb
            L_0x01e6:
                r1 = r26
                r5 = r27
                goto L_0x01fc
            L_0x01eb:
                r14 = r11[r2]
                r9 = r12[r2]
                r1 = r13[r2]
                byte[] r1 = new byte[r1]
                android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.RGB_565
                android.graphics.Bitmap r26 = android.graphics.Bitmap.createBitmap(r14, r9, r5)
                r5 = r1
                r1 = r26
            L_0x01fc:
                if (r5 == 0) goto L_0x020c
                int r6 = r14 * r9
                int r6 = r6 * 2
                java.lang.System.arraycopy(r10, r2, r5, r2, r6)
                java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r10)
                r1.copyPixelsFromBuffer(r2)
            L_0x020c:
                int r2 = (r21 > r19 ? 1 : (r21 == r19 ? 0 : -1))
                if (r2 == 0) goto L_0x0267
                int r2 = (r23 > r19 ? 1 : (r23 == r19 ? 0 : -1))
                if (r2 == 0) goto L_0x0267
                long r6 = java.lang.System.currentTimeMillis()
                int r2 = r0.getTimeStamp()
                r8 = r3
                long r2 = (long) r2
                long r2 = r2 - r21
                long r2 = r2 + r23
                long r2 = r2 - r6
                r15 = -1
                long r15 = r15 * r2
                int r26 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
                r31 = r4
                if (r26 < 0) goto L_0x025d
                int r4 = r0.getTimeStamp()
                r26 = r5
                long r4 = (long) r4
                long r4 = r4 - r17
                int r17 = (r4 > r28 ? 1 : (r4 == r28 ? 0 : -1))
                if (r17 <= 0) goto L_0x0252
                int r4 = r0.getTimeStamp()
                long r4 = (long) r4
                r17 = r4
                java.lang.String r4 = "IOTCamera"
                java.lang.String r5 = "RESET base timestamp"
                android.util.Log.i(r4, r5)
                int r4 = (r2 > r28 ? 1 : (r2 == r28 ? 0 : -1))
                if (r4 <= 0) goto L_0x024e
                r2 = 33
            L_0x024e:
                r23 = r6
                r21 = r17
            L_0x0252:
                int r4 = (r2 > r28 ? 1 : (r2 == r28 ? 0 : -1))
                if (r4 <= 0) goto L_0x0257
                goto L_0x0259
            L_0x0257:
                r28 = r2
            L_0x0259:
                java.lang.Thread.sleep(r28)     // Catch:{ Exception -> 0x025f }
                goto L_0x025f
            L_0x025d:
                r26 = r5
            L_0x025f:
                int r2 = r0.getTimeStamp()
                long r2 = (long) r2
                r17 = r2
                goto L_0x026c
            L_0x0267:
                r8 = r3
                r31 = r4
                r26 = r5
            L_0x026c:
                int r2 = (r21 > r19 ? 1 : (r21 == r19 ? 0 : -1))
                if (r2 == 0) goto L_0x0274
                int r2 = (r23 > r19 ? 1 : (r23 == r19 ? 0 : -1))
                if (r2 != 0) goto L_0x0281
            L_0x0274:
                int r2 = r0.getTimeStamp()
                long r2 = (long) r2
                long r23 = java.lang.System.currentTimeMillis()
                r17 = r2
                r21 = r17
            L_0x0281:
                r2 = r30
                com.tutk.IOTC.Camera$AVChannel r3 = r2.mAVChannel
                int r4 = r3.VideoFPS
                int r4 = r4 + 1
                r3.VideoFPS = r4
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                java.util.List r3 = r3.mIOTCListeners
                monitor-enter(r3)
                r4 = 0
            L_0x0293:
                com.tutk.IOTC.Camera r5 = com.tutk.IOTC.Camera.this     // Catch:{ all -> 0x02c3 }
                java.util.List r5 = r5.mIOTCListeners     // Catch:{ all -> 0x02c3 }
                int r5 = r5.size()     // Catch:{ all -> 0x02c3 }
                if (r4 >= r5) goto L_0x02b9
                com.tutk.IOTC.Camera r5 = com.tutk.IOTC.Camera.this     // Catch:{ all -> 0x02c3 }
                java.util.List r5 = r5.mIOTCListeners     // Catch:{ all -> 0x02c3 }
                java.lang.Object r5 = r5.get(r4)     // Catch:{ all -> 0x02c3 }
                com.tutk.IOTC.IRegisterIOTCListener r5 = (com.tutk.IOTC.IRegisterIOTCListener) r5     // Catch:{ all -> 0x02c3 }
                com.tutk.IOTC.Camera r6 = com.tutk.IOTC.Camera.this     // Catch:{ all -> 0x02c3 }
                com.tutk.IOTC.Camera$AVChannel r7 = r2.mAVChannel     // Catch:{ all -> 0x02c3 }
                int r7 = r7.getChannel()     // Catch:{ all -> 0x02c3 }
                r5.receiveFrameData(r6, r7, r1)     // Catch:{ all -> 0x02c3 }
                int r4 = r4 + 1
                goto L_0x0293
            L_0x02b9:
                monitor-exit(r3)     // Catch:{ all -> 0x02c3 }
                com.tutk.IOTC.Camera$AVChannel r3 = r2.mAVChannel
                r3.LastFrame = r1
                r27 = r26
                r26 = r1
                goto L_0x02cd
            L_0x02c3:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x02c3 }
                throw r0
            L_0x02c6:
                r8 = r3
                r2 = r30
                r9 = r31
                r31 = r4
            L_0x02cd:
                r4 = r31
                goto L_0x02d3
            L_0x02d0:
                r8 = r3
                r2 = r30
            L_0x02d3:
                r1 = 0
                r0.frmData = r1
                r1 = r2
                r2 = r8
                r3 = r10
                r5 = r11
                r6 = r12
                r7 = r13
                r8 = r14
                r11 = r17
                r13 = r19
                r17 = r23
                r20 = r25
                r19 = r9
                r9 = r15
                r15 = r21
                r21 = r26
                r22 = r27
                goto L_0x02fb
            L_0x02ef:
                r23 = 32
                java.lang.Thread.sleep(r23)     // Catch:{ InterruptedException -> 0x02f5 }
                goto L_0x02fb
            L_0x02f5:
                r0 = move-exception
                r23 = r0
                r23.printStackTrace()
            L_0x02fb:
                r23 = 0
                goto L_0x003d
            L_0x02ff:
                if (r20 == 0) goto L_0x0304
                com.decoder.util.DecH264.UninitDecoder()
            L_0x0304:
                if (r4 == 0) goto L_0x0309
                com.decoder.util.DecMpeg4.UninitDecoder()
            L_0x0309:
                if (r21 == 0) goto L_0x030e
                r21.recycle()
            L_0x030e:
                java.lang.System.gc()
                java.lang.String r0 = "IOTCamera"
                java.lang.String r1 = "===ThreadDecodeVideo exit==="
                android.util.Log.i(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tutk.IOTC.Camera.ThreadDecodeVideo2.run():void");
        }

        public void stopThread() {
            this.m_bIsRunning = false;
        }
    }

    public class ThreadRecvAudio extends Thread {
        public final int MAX_BUF_SIZE = 1280;
        public boolean bIsRunning = false;
        public AVChannel mAVChannel;
        public int nReadSize = 0;

        public ThreadRecvAudio(AVChannel aVChannel) {
            this.mAVChannel = aVChannel;
        }

        public void run() {
            short s;
            byte[] bArr;
            byte[] bArr2;
            byte[] bArr3;
            int[] iArr;
            byte[] bArr4;
            String str;
            String str2;
            int i;
            this.bIsRunning = true;
            while (this.bIsRunning && (Camera.this.mSID < 0 || this.mAVChannel.getAVIndex() < 0)) {
                try {
                    synchronized (Camera.this.mWaitObjectForConnected) {
                        Camera.this.mWaitObjectForConnected.wait(100);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.mAVChannel.AudioBPS = 0;
            byte[] bArr5 = new byte[1280];
            byte[] bArr6 = new byte[24];
            int[] iArr2 = new int[1];
            byte[] bArr7 = new byte[65535];
            short[] sArr = new short[DrawerLayout.PEEK_DELAY];
            byte[] bArr8 = new byte[640];
            byte[] bArr9 = new byte[2048];
            long[] jArr = new long[1];
            if (this.bIsRunning && Camera.this.mSID >= 0 && this.mAVChannel.getAVIndex() >= 0) {
                AVChannel aVChannel = this.mAVChannel;
                aVChannel.IOCtrlQueue.Enqueue(aVChannel.getAVIndex(), AVIOCTRLDEFs.IOTYPE_USER_IPCAM_AUDIOSTART, Packet.intToByteArray_Little(Camera.this.mCamIndex));
            }
            int i2 = 0;
            short s2 = 0;
            int i3 = 44100;
            boolean z = true;
            int i4 = 0;
            int i5 = 1;
            byte b2 = 1;
            boolean z2 = false;
            while (true) {
                if (!this.bIsRunning) {
                    short s3 = s2;
                    break;
                }
                if (Camera.this.mSID < 0 || this.mAVChannel.getAVIndex() < 0) {
                    s = s2;
                    bArr4 = bArr9;
                    bArr = bArr8;
                    bArr2 = bArr7;
                    iArr = iArr2;
                    bArr3 = bArr6;
                } else {
                    s = s2;
                    bArr4 = bArr9;
                    int avRecvAudioData = AVAPIs.avRecvAudioData(this.mAVChannel.getAVIndex(), bArr5, 1280, bArr6, 24, iArr2);
                    this.nReadSize = avRecvAudioData;
                    if (avRecvAudioData < 0 && avRecvAudioData != -20012) {
                        Log.i("IOTCamera", "avRecvAudioData < 0");
                    }
                    int i6 = this.nReadSize;
                    if (i6 > 0) {
                        this.mAVChannel.AudioBPS += i6;
                        byte[] bArr10 = new byte[i6];
                        System.arraycopy(bArr5, i2, bArr10, i2, i6);
                        byte[] bArr11 = bArr8;
                        byte[] bArr12 = bArr7;
                        short[] sArr2 = sArr;
                        iArr = iArr2;
                        bArr3 = bArr6;
                        AVFrame aVFrame = new AVFrame((long) iArr2[i2], (byte) 0, bArr6, bArr10, this.nReadSize);
                        short codecId = aVFrame.getCodecId();
                        if (!z || Camera.this.mInitAudio || !(codecId == 142 || codecId == 141 || codecId == 139 || codecId == 140 || codecId == 143)) {
                            i = 640;
                        } else {
                            int samplerate = AVFrame.getSamplerate(aVFrame.getFlags());
                            int i7 = (aVFrame.getFlags() & 2) == 2 ? 1 : 0;
                            byte flags = aVFrame.getFlags() & 1;
                            if (codecId == 141) {
                                i4 = ((((flags == 0 ? 1 : 2) * samplerate) * (i7 == 0 ? 8 : 16)) / 8) / DrawerLayout.PEEK_DELAY;
                                i = 640;
                            } else if (codecId == 139) {
                                i = 640;
                                i4 = ((((flags == 0 ? 1 : 2) * samplerate) * (i7 == 0 ? 8 : 16)) / 8) / 640;
                            } else {
                                i = 640;
                                if (codecId == 140) {
                                    i4 = ((((flags == 0 ? 1 : 2) * samplerate) * (i7 == 0 ? 8 : 16)) / 8) / aVFrame.getFrmSize();
                                }
                            }
                            z2 = Camera.this.audioDev_init(samplerate, flags, i7, codecId);
                            if (!z2) {
                                s2 = codecId;
                                break;
                            }
                            z = false;
                            i3 = samplerate;
                            i5 = i7;
                            b2 = flags;
                        }
                        if (codecId == 141) {
                            sArr = sArr2;
                            DecSpeex.Decode(bArr5, this.nReadSize, sArr);
                            Camera.this.mAudioTrack.write(sArr, 0, DrawerLayout.PEEK_DELAY);
                            bArr2 = bArr12;
                        } else {
                            sArr = sArr2;
                            if (codecId == 142) {
                                bArr2 = bArr12;
                                int Decode = DecMp3.Decode(bArr5, this.nReadSize, bArr2);
                                Camera.this.mAudioTrack.write(bArr2, 0, Decode);
                                i4 = ((((b2 == 0 ? 1 : 2) * i3) * (i5 == 0 ? 8 : 16)) / 8) / Decode;
                            } else {
                                bArr2 = bArr12;
                                if (codecId == 139) {
                                    bArr = bArr11;
                                    DecADPCM.Decode(bArr5, this.nReadSize, bArr);
                                    Camera.this.mAudioTrack.write(bArr, 0, i);
                                } else {
                                    bArr = bArr11;
                                    if (codecId == 140) {
                                        Camera.this.mAudioTrack.write(bArr5, 0, this.nReadSize);
                                    } else if (codecId == 143) {
                                        DecG726.g726_decode(bArr5, (long) this.nReadSize, bArr4, jArr);
                                        Log.i("IOTCamera", "G726 decode size:" + jArr[0]);
                                        Camera.this.mAudioTrack.write(bArr4, 0, (int) jArr[0]);
                                        i4 = ((((b2 == 0 ? 1 : 2) * i3) * (i5 == 0 ? 8 : 16)) / 8) / ((int) jArr[0]);
                                    }
                                }
                                s = codecId;
                            }
                        }
                        bArr = bArr11;
                        s = codecId;
                    } else {
                        bArr = bArr8;
                        bArr2 = bArr7;
                        iArr = iArr2;
                        bArr3 = bArr6;
                        long j = 33;
                        if (i6 == -20012) {
                            if (i4 != 0) {
                                try {
                                    j = (long) (1000 / i4);
                                } catch (InterruptedException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            Thread.sleep(j);
                        } else {
                            if (i6 == -20014) {
                                str2 = "IOTCamera";
                                str = "avRecvAudioData returns AV_ER_LOSED_THIS_FRAME";
                            } else {
                                if (i4 != 0) {
                                    try {
                                        j = (long) (1000 / i4);
                                    } catch (InterruptedException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                Thread.sleep(j);
                                str2 = "IOTCamera";
                                StringBuilder n = a.n("avRecvAudioData returns ");
                                n.append(this.nReadSize);
                                str = n.toString();
                            }
                            Log.i(str2, str);
                        }
                    }
                }
                i2 = 0;
                iArr2 = iArr;
                bArr6 = bArr3;
                bArr7 = bArr2;
                bArr8 = bArr;
                bArr9 = bArr4;
                s2 = s;
            }
            if (z2) {
                Camera.this.audioDev_stop(s2);
            }
            AVChannel aVChannel2 = this.mAVChannel;
            aVChannel2.IOCtrlQueue.Enqueue(aVChannel2.getAVIndex(), AVIOCTRLDEFs.IOTYPE_USER_IPCAM_AUDIOSTOP, Packet.intToByteArray_Little(Camera.this.mCamIndex));
            Log.i("IOTCamera", "===ThreadRecvAudio exit===");
        }

        public void stopThread() {
            this.bIsRunning = false;
        }
    }

    public class ThreadRecvIOCtrl extends Thread {
        public final int TIME_OUT = 0;
        public boolean bIsRunning = false;
        public AVChannel mAVChannel;

        public ThreadRecvIOCtrl(AVChannel aVChannel) {
            this.mAVChannel = aVChannel;
        }

        public void run() {
            this.bIsRunning = true;
            while (this.bIsRunning && (Camera.this.mSID < 0 || this.mAVChannel.getAVIndex() < 0)) {
                try {
                    synchronized (Camera.this.mWaitObjectForConnected) {
                        Camera.this.mWaitObjectForConnected.wait(1000);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            while (this.bIsRunning) {
                if (Camera.this.mSID >= 0 && this.mAVChannel.getAVIndex() >= 0) {
                    int[] iArr = new int[1];
                    byte[] bArr = new byte[1024];
                    int avRecvIOCtrl = AVAPIs.avRecvIOCtrl(this.mAVChannel.getAVIndex(), iArr, bArr, 1024, 0);
                    if (avRecvIOCtrl >= 0) {
                        StringBuilder n = a.n("avRecvIOCtrl(");
                        n.append(this.mAVChannel.getAVIndex());
                        n.append(", 0x");
                        n.append(Integer.toHexString(iArr[0]));
                        n.append(", ");
                        n.append(Camera.getHex(bArr, avRecvIOCtrl));
                        n.append(")");
                        Log.i("IOTCamera", n.toString());
                        byte[] bArr2 = new byte[avRecvIOCtrl];
                        System.arraycopy(bArr, 0, bArr2, 0, avRecvIOCtrl);
                        if (iArr[0] == 811) {
                            int byteArrayToInt_Little = Packet.byteArrayToInt_Little(bArr2, 0);
                            int byteArrayToInt_Little2 = Packet.byteArrayToInt_Little(bArr2, 4);
                            Iterator it = Camera.this.mAVChannels.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                AVChannel aVChannel = (AVChannel) it.next();
                                if (aVChannel.getChannel() == byteArrayToInt_Little) {
                                    aVChannel.setAudioCodec(byteArrayToInt_Little2);
                                    break;
                                }
                            }
                        }
                        for (int i = 0; i < Camera.this.mIOTCListeners.size(); i++) {
                            ((IRegisterIOTCListener) Camera.this.mIOTCListeners.get(i)).receiveIOCtrlData(Camera.this, this.mAVChannel.getChannel(), iArr[0], bArr2);
                        }
                    } else {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            Log.i("IOTCamera", "===ThreadRecvIOCtrl exit===");
        }

        public void stopThread() {
            this.bIsRunning = false;
        }
    }

    public class ThreadRecvVideo extends Thread {
        public static final int MAX_BUF_SIZE = 2764800;
        public boolean bIsRunning = false;
        public AVChannel mAVChannel;

        public ThreadRecvVideo(AVChannel aVChannel) {
            this.mAVChannel = aVChannel;
        }

        public void run() {
            long j;
            byte[] bArr;
            int[] iArr;
            String str;
            String str2;
            String str3;
            String str4;
            System.gc();
            this.bIsRunning = true;
            while (this.bIsRunning && (Camera.this.mSID < 0 || this.mAVChannel.getAVIndex() < 0)) {
                try {
                    synchronized (Camera.this.mWaitObjectForConnected) {
                        Camera.this.mWaitObjectForConnected.wait(100);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.mAVChannel.VideoBPS = 0;
            byte[] bArr2 = new byte[2764800];
            byte[] bArr3 = new byte[24];
            int[] iArr2 = new int[1];
            long currentTimeMillis = System.currentTimeMillis();
            if (this.bIsRunning && Camera.this.mSID >= 0 && this.mAVChannel.getAVIndex() >= 0) {
                AVChannel aVChannel = this.mAVChannel;
                aVChannel.IOCtrlQueue.Enqueue(aVChannel.getAVIndex(), 511, Packet.intToByteArray_Little(Camera.this.mCamIndex));
            }
            long j2 = 268435455;
            int i = 0;
            byte b2 = 0;
            int i2 = 0;
            while (this.bIsRunning) {
                if (Camera.this.mSID < 0 || this.mAVChannel.getAVIndex() < 0) {
                    iArr2 = iArr2;
                    bArr3 = bArr3;
                } else {
                    if (System.currentTimeMillis() - currentTimeMillis > 1000) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        for (int i3 = 0; i3 < Camera.this.mIOTCListeners.size(); i3++) {
                            Camera camera = Camera.this;
                            int channel = this.mAVChannel.getChannel();
                            AVChannel aVChannel2 = this.mAVChannel;
                            ((IRegisterIOTCListener) Camera.this.mIOTCListeners.get(i3)).receiveFrameInfo(camera, channel, (long) (((aVChannel2.AudioBPS + aVChannel2.VideoBPS) * 8) / 1024), aVChannel2.VideoFPS, b2, i, i2);
                        }
                        AVChannel aVChannel3 = this.mAVChannel;
                        aVChannel3.AudioBPS = 0;
                        aVChannel3.VideoBPS = 0;
                        aVChannel3.VideoFPS = 0;
                        j = currentTimeMillis2;
                    } else {
                        j = currentTimeMillis;
                    }
                    int avRecvFrameData = AVAPIs.avRecvFrameData(this.mAVChannel.getAVIndex(), bArr2, 2764800, bArr3, 24, iArr2);
                    if (avRecvFrameData >= 0) {
                        this.mAVChannel.VideoBPS += avRecvFrameData;
                        int i4 = i + 1;
                        byte[] bArr4 = new byte[avRecvFrameData];
                        System.arraycopy(bArr2, 0, bArr4, 0, avRecvFrameData);
                        iArr = iArr2;
                        bArr = bArr3;
                        AVFrame aVFrame = new AVFrame((long) iArr2[0], (byte) 0, bArr3, bArr4, avRecvFrameData);
                        short codecId = aVFrame.getCodecId();
                        b2 = aVFrame.getOnlineNum();
                        if (aVFrame.isIFrame() || ((long) iArr[0]) == j2 + 1) {
                            long j3 = (long) iArr[0];
                            if (codecId == 78 || codecId == 76) {
                                this.mAVChannel.VideoFrameQueue.addLast(aVFrame);
                            } else if (codecId == 79) {
                                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr4, 0, avRecvFrameData);
                                if (decodeByteArray != null) {
                                    this.mAVChannel.VideoFPS++;
                                    for (int i5 = 0; i5 < Camera.this.mIOTCListeners.size(); i5++) {
                                        ((IRegisterIOTCListener) Camera.this.mIOTCListeners.get(i5)).receiveFrameData(Camera.this, this.mAVChannel.getChannel(), decodeByteArray);
                                    }
                                    this.mAVChannel.LastFrame = decodeByteArray;
                                }
                                try {
                                    Thread.sleep(33);
                                } catch (InterruptedException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            j2 = j3;
                        }
                        i = i4;
                    } else {
                        iArr = iArr2;
                        bArr = bArr3;
                        if (avRecvFrameData == -20015) {
                            str2 = "IOTCamera";
                            str = "AV_ER_SESSION_CLOSE_BY_REMOTE";
                        } else if (avRecvFrameData == -20016) {
                            str2 = "IOTCamera";
                            str = "AV_ER_REMOTE_TIMEOUT_DISCONNECT";
                        } else if (!(avRecvFrameData == -20012 || avRecvFrameData == -20001)) {
                            if (avRecvFrameData == -20003) {
                                i++;
                                i2++;
                                str2 = "IOTCamera";
                                str = "AV_ER_MEM_INSUFF";
                            } else {
                                if (avRecvFrameData == -20014) {
                                    str3 = "IOTCamera";
                                    str4 = "AV_ER_LOSED_THIS_FRAME";
                                } else if (avRecvFrameData == -20013) {
                                    str3 = "IOTCamera";
                                    str4 = "AV_ER_INCOMPLETE_FRAME";
                                }
                                Log.i(str3, str4);
                                i++;
                                i2++;
                            }
                        }
                        Log.i(str2, str);
                    }
                    iArr2 = iArr;
                    bArr3 = bArr;
                    currentTimeMillis = j;
                }
            }
            AVChannel aVChannel4 = this.mAVChannel;
            aVChannel4.IOCtrlQueue.Enqueue(aVChannel4.getAVIndex(), AVIOCTRLDEFs.IOTYPE_USER_IPCAM_STOP, Packet.intToByteArray_Little(Camera.this.mCamIndex));
            this.mAVChannel.VideoFrameQueue.removeAll();
            Log.i("IOTCamera", "===ThreadRecvVideo exit===");
        }

        public void stopThread() {
            this.bIsRunning = false;
        }
    }

    public class ThreadRecvVideo2 extends Thread {
        public static final int MAX_BUF_SIZE = 2764800;
        public boolean bIsRunning = false;
        public AVChannel mAVChannel;

        public ThreadRecvVideo2(AVChannel aVChannel) {
            this.mAVChannel = aVChannel;
        }

        public void run() {
            int[] iArr;
            long j;
            String str;
            String str2;
            long j2;
            int i;
            System.gc();
            this.bIsRunning = true;
            while (this.bIsRunning && (Camera.this.mSID < 0 || this.mAVChannel.getAVIndex() < 0)) {
                try {
                    synchronized (Camera.this.mWaitObjectForConnected) {
                        Camera.this.mWaitObjectForConnected.wait(100);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.mAVChannel.VideoBPS = 0;
            byte[] bArr = new byte[2764800];
            byte[] bArr2 = new byte[24];
            int[] iArr2 = new int[1];
            long currentTimeMillis = System.currentTimeMillis();
            int[] iArr3 = new int[1];
            int[] iArr4 = new int[1];
            int[] iArr5 = new int[1];
            if (this.bIsRunning && Camera.this.mSID >= 0 && this.mAVChannel.getAVIndex() >= 0) {
                AVChannel aVChannel = this.mAVChannel;
                aVChannel.IOCtrlQueue.Enqueue(aVChannel.getAVIndex(), 511, Packet.intToByteArray_Little(Camera.this.mCamIndex));
            }
            this.mAVChannel.AudioFrameQueue.removeAll();
            if (Camera.this.mSID >= 0 && this.mAVChannel.getAVIndex() >= 0) {
                AVAPIs.avClientCleanBuf(this.mAVChannel.getAVIndex());
            }
            long j3 = 268435455;
            int i2 = 0;
            int i3 = 0;
            byte b2 = 0;
            while (this.bIsRunning) {
                if (Camera.this.mSID < 0 || this.mAVChannel.getAVIndex() < 0) {
                    j = j3;
                    iArr = iArr4;
                } else {
                    if (System.currentTimeMillis() - currentTimeMillis > 1000) {
                        currentTimeMillis = System.currentTimeMillis();
                        for (int i4 = 0; i4 < Camera.this.mIOTCListeners.size(); i4++) {
                            Camera camera = Camera.this;
                            int channel = this.mAVChannel.getChannel();
                            AVChannel aVChannel2 = this.mAVChannel;
                            ((IRegisterIOTCListener) Camera.this.mIOTCListeners.get(i4)).receiveFrameInfo(camera, channel, (long) (((aVChannel2.AudioBPS + aVChannel2.VideoBPS) * 8) / 1024), aVChannel2.VideoFPS, b2, i2, i3);
                        }
                        AVChannel aVChannel3 = this.mAVChannel;
                        aVChannel3.AudioBPS = 0;
                        aVChannel3.VideoBPS = 0;
                        aVChannel3.VideoFPS = 0;
                    }
                    long j4 = currentTimeMillis;
                    long j5 = j3;
                    iArr = iArr4;
                    int avRecvFrameData2 = AVAPIs.avRecvFrameData2(this.mAVChannel.getAVIndex(), bArr, 2764800, iArr3, iArr4, bArr2, 24, iArr5, iArr2);
                    if (avRecvFrameData2 >= 0) {
                        this.mAVChannel.VideoBPS += iArr3[0];
                        i2++;
                        byte[] bArr3 = new byte[avRecvFrameData2];
                        System.arraycopy(bArr, 0, bArr3, 0, avRecvFrameData2);
                        AVFrame aVFrame = r3;
                        byte[] bArr4 = bArr3;
                        AVFrame aVFrame2 = new AVFrame((long) iArr2[0], (byte) 0, bArr2, bArr3, avRecvFrameData2);
                        short codecId = aVFrame.getCodecId();
                        byte onlineNum = aVFrame.getOnlineNum();
                        if (codecId == 78) {
                            if (!aVFrame.isIFrame()) {
                                j3 = j5;
                                if (((long) iArr2[0]) != 1 + j3) {
                                    StringBuilder n = a.n("Incorrect frame no(");
                                    n.append(iArr2[0]);
                                    n.append("), prev:");
                                    n.append(j3);
                                    n.append(" -> drop frame");
                                    Log.i("IOTCamera", n.toString());
                                    b2 = onlineNum;
                                }
                            }
                            i = iArr2[0];
                        } else {
                            j3 = j5;
                            if (codecId == 76) {
                                if (aVFrame.isIFrame() || ((long) iArr2[0]) == j3 + 1) {
                                    i = iArr2[0];
                                }
                            } else if (codecId == 79) {
                                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr4, 0, avRecvFrameData2);
                                if (decodeByteArray != null) {
                                    this.mAVChannel.VideoFPS++;
                                    for (int i5 = 0; i5 < Camera.this.mIOTCListeners.size(); i5++) {
                                        ((IRegisterIOTCListener) Camera.this.mIOTCListeners.get(i5)).receiveFrameData(Camera.this, this.mAVChannel.getChannel(), decodeByteArray);
                                    }
                                    this.mAVChannel.LastFrame = decodeByteArray;
                                }
                                try {
                                    Thread.sleep(32);
                                } catch (InterruptedException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            b2 = onlineNum;
                        }
                        long j6 = (long) i;
                        this.mAVChannel.VideoFrameQueue.addLast(aVFrame);
                        b2 = onlineNum;
                        j3 = j6;
                    } else {
                        j3 = j5;
                        if (avRecvFrameData2 == -20015) {
                            str2 = "IOTCamera";
                            str = "AV_ER_SESSION_CLOSE_BY_REMOTE";
                        } else if (avRecvFrameData2 == -20016) {
                            str2 = "IOTCamera";
                            str = "AV_ER_REMOTE_TIMEOUT_DISCONNECT";
                        } else {
                            if (avRecvFrameData2 == -20012) {
                                try {
                                    Thread.sleep(32);
                                } catch (InterruptedException e4) {
                                    e4.printStackTrace();
                                }
                            } else if (avRecvFrameData2 != -20001) {
                                if (avRecvFrameData2 == -20003) {
                                    i2++;
                                    i3++;
                                    Log.i("IOTCamera", "AV_ER_MEM_INSUFF");
                                } else if (avRecvFrameData2 == -20014) {
                                    Log.i("IOTCamera", "AV_ER_LOSED_THIS_FRAME");
                                    i2++;
                                    i3++;
                                } else if (avRecvFrameData2 == -20013) {
                                    i2++;
                                    this.mAVChannel.VideoBPS += iArr3[0];
                                    if (iArr5[0] != 0) {
                                        double d2 = (double) iArr[0];
                                        Double.isNaN(d2);
                                        if (d2 * 0.9d <= ((double) iArr3[0]) && bArr2[2] != 0) {
                                            byte[] bArr5 = new byte[iArr[0]];
                                            System.arraycopy(bArr, 0, bArr5, 0, iArr[0]);
                                            short byteArrayToShort_Little = Packet.byteArrayToShort_Little(bArr2, 0);
                                            if (byteArrayToShort_Little == 79) {
                                                i3++;
                                            } else {
                                                if (byteArrayToShort_Little == 76 || byteArrayToShort_Little == 78) {
                                                    j2 = j3;
                                                    AVFrame aVFrame3 = new AVFrame((long) iArr2[0], (byte) 0, bArr2, bArr5, iArr[0]);
                                                    if (aVFrame3.isIFrame() || ((long) iArr2[0]) == j2 + 1) {
                                                        this.mAVChannel.VideoFrameQueue.addLast(aVFrame3);
                                                        Log.i("IOTCamera", "AV_ER_INCOMPLETE_FRAME - H264 or MPEG4");
                                                        j3 = (long) iArr2[0];
                                                    } else {
                                                        i3++;
                                                        Log.i("IOTCamera", "AV_ER_INCOMPLETE_FRAME - H264 or MPEG4 - LOST");
                                                    }
                                                } else {
                                                    i3++;
                                                    j2 = j3;
                                                }
                                                j3 = j2;
                                            }
                                        }
                                    }
                                    j = j3;
                                    i3++;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(bArr2[2] == 0 ? "P" : "I");
                                    sb.append(" frame, outFrmSize(");
                                    sb.append(iArr[0]);
                                    sb.append(") * 0.9 = ");
                                    double d3 = (double) iArr[0];
                                    Double.isNaN(d3);
                                    sb.append(d3 * 0.9d);
                                    sb.append(" > outBufSize(");
                                    sb.append(iArr3[0]);
                                    sb.append(")");
                                    Log.i("IOTCamera", sb.toString());
                                    currentTimeMillis = j4;
                                }
                            }
                            j = j3;
                            currentTimeMillis = j4;
                        }
                        Log.i(str2, str);
                        j = j3;
                        currentTimeMillis = j4;
                    }
                    currentTimeMillis = j4;
                    iArr4 = iArr;
                }
                j3 = j;
                iArr4 = iArr;
            }
            this.mAVChannel.VideoFrameQueue.removeAll();
            if (Camera.this.mSID >= 0 && this.mAVChannel.getAVIndex() >= 0) {
                AVChannel aVChannel4 = this.mAVChannel;
                aVChannel4.IOCtrlQueue.Enqueue(aVChannel4.getAVIndex(), AVIOCTRLDEFs.IOTYPE_USER_IPCAM_STOP, Packet.intToByteArray_Little(Camera.this.mCamIndex));
                AVAPIs.avClientCleanBuf(this.mAVChannel.getAVIndex());
            }
            Log.i("IOTCamera", "===ThreadRecvVideo exit===");
        }

        public void stopThread() {
            this.bIsRunning = false;
        }
    }

    public class ThreadSendAudio extends Thread {
        public static final int SAMPLE_RATE_IN_HZ = 8000;
        public int avIndexForSendAudio = -1;
        public int chIndexForSendAudio = -1;
        public AVChannel mAVChannel = null;
        public boolean m_bIsRunning = false;

        public ThreadSendAudio(AVChannel aVChannel) {
            this.mAVChannel = aVChannel;
        }

        public void run() {
            String str;
            boolean z;
            int i;
            boolean z2;
            boolean z3;
            boolean z4;
            byte[] bArr;
            short[] sArr;
            byte[] bArr2;
            super.run();
            if (Camera.this.mSID < 0) {
                str = "=== ThreadSendAudio exit because SID < 0 ===";
            } else {
                this.m_bIsRunning = true;
                int IOTC_Session_Get_Free_Channel = IOTCAPIs.IOTC_Session_Get_Free_Channel(Camera.this.mSID);
                this.chIndexForSendAudio = IOTC_Session_Get_Free_Channel;
                if (IOTC_Session_Get_Free_Channel < 0) {
                    str = "=== ThreadSendAudio exit becuase no more channel for connection ===";
                } else {
                    Camera.this.sendIOCtrl(this.mAVChannel.mChannel, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_SPEAKERSTART, AVIOCTRLDEFs.SMsgAVIoctrlAVStream.parseContent(this.chIndexForSendAudio));
                    StringBuilder sb = new StringBuilder();
                    sb.append("start avServerStart(");
                    sb.append(Camera.this.mSID);
                    sb.append(", ");
                    sb.append(this.chIndexForSendAudio);
                    sb.append(")");
                    while (true) {
                        Log.i("IOTCamera", sb.toString());
                        if (!this.m_bIsRunning) {
                            break;
                        }
                        int avServStart = AVAPIs.avServStart(Camera.this.mSID, (byte[]) null, (byte[]) null, 60, 0, this.chIndexForSendAudio);
                        this.avIndexForSendAudio = avServStart;
                        if (avServStart >= 0) {
                            break;
                        }
                        sb = a.n("avServerStart(");
                        sb.append(Camera.this.mSID);
                        sb.append(", ");
                        sb.append(this.chIndexForSendAudio);
                        sb.append(") : ");
                        sb.append(this.avIndexForSendAudio);
                    }
                    StringBuilder n = a.n("avServerStart(");
                    n.append(Camera.this.mSID);
                    n.append(", ");
                    n.append(this.chIndexForSendAudio);
                    n.append(") : ");
                    n.append(this.avIndexForSendAudio);
                    Log.i("IOTCamera", n.toString());
                    boolean z5 = this.m_bIsRunning;
                    int i2 = AVFrame.MEDIA_CODEC_AUDIO_SPEEX;
                    byte b2 = 0;
                    if (!z5 || this.mAVChannel.getAudioCodec() != 141) {
                        i = 0;
                        z = false;
                    } else {
                        EncSpeex.InitEncoder(8);
                        i = AudioRecord.getMinBufferSize(SAMPLE_RATE_IN_HZ, 16, 2);
                        Log.i("IOTCamera", "Speex encoder init");
                        z = true;
                    }
                    if (!this.m_bIsRunning || this.mAVChannel.getAudioCodec() != 139) {
                        z2 = false;
                    } else {
                        EncADPCM.ResetEncoder();
                        i = AudioRecord.getMinBufferSize(SAMPLE_RATE_IN_HZ, 16, 2);
                        Log.i("IOTCamera", "ADPCM encoder init");
                        z2 = true;
                    }
                    if (!this.m_bIsRunning || this.mAVChannel.getAudioCodec() != 143) {
                        z3 = false;
                    } else {
                        EncG726.g726_enc_state_create((byte) 0, (byte) 2);
                        i = AudioRecord.getMinBufferSize(SAMPLE_RATE_IN_HZ, 16, 2);
                        Log.i("IOTCamera", "G726 encoder init");
                        z3 = true;
                    }
                    if (!this.m_bIsRunning || this.mAVChannel.getAudioCodec() != 140) {
                        z4 = false;
                    } else {
                        i = AudioRecord.getMinBufferSize(SAMPLE_RATE_IN_HZ, 16, 2);
                        z4 = true;
                    }
                    int i3 = i;
                    AudioRecord audioRecord = null;
                    if (this.m_bIsRunning && (z2 || z3 || z || z4)) {
                        audioRecord = new AudioRecord(1, SAMPLE_RATE_IN_HZ, 16, 2, i3);
                        audioRecord.startRecording();
                    }
                    short[] sArr2 = new short[DrawerLayout.PEEK_DELAY];
                    byte[] bArr3 = new byte[640];
                    byte[] bArr4 = new byte[MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP];
                    byte[] bArr5 = new byte[640];
                    byte[] bArr6 = new byte[38];
                    byte[] bArr7 = new byte[DrawerLayout.PEEK_DELAY];
                    byte[] bArr8 = new byte[2048];
                    long[] jArr = new long[1];
                    while (this.m_bIsRunning) {
                        if (this.mAVChannel.getAudioCodec() == i2) {
                            int read = audioRecord.read(sArr2, b2, DrawerLayout.PEEK_DELAY);
                            if (read > 0) {
                                AVAPIs.avSendAudioData(this.avIndexForSendAudio, bArr6, EncSpeex.Encode(sArr2, read, bArr6), AVIOCTRLDEFs.SFrameInfo.parseContent(141, (byte) 2, b2, b2, (int) System.currentTimeMillis()), 16);
                                i2 = AVFrame.MEDIA_CODEC_AUDIO_SPEEX;
                                b2 = 0;
                                bArr5 = bArr5;
                                sArr2 = sArr2;
                            } else {
                                sArr = sArr2;
                                bArr2 = bArr4;
                                bArr = bArr6;
                            }
                        } else {
                            sArr = sArr2;
                            byte[] bArr9 = bArr5;
                            if (this.mAVChannel.getAudioCodec() == 139) {
                                int read2 = audioRecord.read(bArr3, 0, 640);
                                if (read2 > 0) {
                                    EncADPCM.Encode(bArr3, read2, bArr7);
                                    AVAPIs.avSendAudioData(this.avIndexForSendAudio, bArr7, read2 / 4, AVIOCTRLDEFs.SFrameInfo.parseContent(139, (byte) 2, (byte) 0, (byte) 0, (int) System.currentTimeMillis()), 16);
                                } else {
                                    bArr2 = bArr4;
                                    bArr = bArr6;
                                    bArr5 = bArr9;
                                    b2 = 0;
                                }
                            } else {
                                if (this.mAVChannel.getAudioCodec() == 143) {
                                    int read3 = audioRecord.read(bArr4, 0, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
                                    if (read3 > 0) {
                                        EncG726.g726_encode(bArr4, (long) read3, bArr8, jArr);
                                        bArr2 = bArr4;
                                        bArr = bArr6;
                                        AVAPIs.avSendAudioData(this.avIndexForSendAudio, bArr8, (int) jArr[0], AVIOCTRLDEFs.SFrameInfo.parseContent(143, (byte) 2, (byte) 0, (byte) 0, (int) System.currentTimeMillis()), 16);
                                    }
                                } else {
                                    bArr2 = bArr4;
                                    bArr = bArr6;
                                    if (this.mAVChannel.getAudioCodec() == 140) {
                                        bArr5 = bArr9;
                                        b2 = 0;
                                        int read4 = audioRecord.read(bArr5, 0, 640);
                                        if (read4 > 0) {
                                            AVAPIs.avSendAudioData(this.avIndexForSendAudio, bArr5, read4, AVIOCTRLDEFs.SFrameInfo.parseContent(140, (byte) 2, (byte) 0, (byte) 0, (int) System.currentTimeMillis()), 16);
                                            i2 = AVFrame.MEDIA_CODEC_AUDIO_SPEEX;
                                            b2 = 0;
                                            bArr4 = bArr2;
                                            sArr2 = sArr;
                                            bArr6 = bArr;
                                        }
                                    }
                                }
                                bArr5 = bArr9;
                                b2 = 0;
                            }
                            bArr2 = bArr4;
                            bArr = bArr6;
                            b2 = 0;
                            bArr5 = bArr9;
                        }
                        i2 = AVFrame.MEDIA_CODEC_AUDIO_SPEEX;
                        bArr4 = bArr2;
                        sArr2 = sArr;
                        bArr6 = bArr;
                    }
                    if (z) {
                        EncSpeex.UninitEncoder();
                    }
                    if (z3) {
                        EncG726.g726_enc_state_destroy();
                    }
                    if (audioRecord != null) {
                        audioRecord.stop();
                        audioRecord.release();
                    }
                    int i4 = this.avIndexForSendAudio;
                    if (i4 >= 0) {
                        AVAPIs.avServStop(i4);
                    }
                    if (this.chIndexForSendAudio >= 0) {
                        IOTCAPIs.IOTC_Session_Channel_OFF(Camera.this.mSID, this.chIndexForSendAudio);
                    }
                    this.avIndexForSendAudio = -1;
                    this.chIndexForSendAudio = -1;
                    str = "===ThreadSendAudio exit===";
                }
            }
            Log.i("IOTCamera", str);
        }

        public void stopThread() {
            if (Camera.this.mSID >= 0 && this.chIndexForSendAudio >= 0) {
                AVAPIs.avServExit(Camera.this.mSID, this.chIndexForSendAudio);
                Camera.this.sendIOCtrl(this.mAVChannel.mChannel, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_SPEAKERSTOP, AVIOCTRLDEFs.SMsgAVIoctrlAVStream.parseContent(this.chIndexForSendAudio));
            }
            this.m_bIsRunning = false;
        }
    }

    public class ThreadSendIOCtrl extends Thread {
        public boolean bIsRunning = false;
        public AVChannel mAVChannel;

        public ThreadSendIOCtrl(AVChannel aVChannel) {
            this.mAVChannel = aVChannel;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x012c A[SYNTHETIC] */
        public void run() {
            /*
                r7 = this;
                r0 = 1
                r7.bIsRunning = r0
            L_0x0003:
                boolean r0 = r7.bIsRunning
                if (r0 == 0) goto L_0x0033
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                int r0 = r0.mSID
                if (r0 < 0) goto L_0x0017
                com.tutk.IOTC.Camera$AVChannel r0 = r7.mAVChannel
                int r0 = r0.getAVIndex()
                if (r0 >= 0) goto L_0x0033
            L_0x0017:
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this     // Catch:{ Exception -> 0x002e }
                java.lang.Object r0 = r0.mWaitObjectForConnected     // Catch:{ Exception -> 0x002e }
                monitor-enter(r0)     // Catch:{ Exception -> 0x002e }
                com.tutk.IOTC.Camera r1 = com.tutk.IOTC.Camera.this     // Catch:{ all -> 0x002b }
                java.lang.Object r1 = r1.mWaitObjectForConnected     // Catch:{ all -> 0x002b }
                r2 = 1000(0x3e8, double:4.94E-321)
                r1.wait(r2)     // Catch:{ all -> 0x002b }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                goto L_0x0003
            L_0x002b:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                throw r1     // Catch:{ Exception -> 0x002e }
            L_0x002e:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0003
            L_0x0033:
                boolean r0 = r7.bIsRunning
                if (r0 == 0) goto L_0x008a
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                int r0 = r0.mSID
                if (r0 < 0) goto L_0x008a
                com.tutk.IOTC.Camera$AVChannel r0 = r7.mAVChannel
                int r0 = r0.getAVIndex()
                if (r0 < 0) goto L_0x008a
                r0 = 0
                com.tutk.IOTC.Camera$AVChannel r1 = r7.mAVChannel
                int r1 = r1.getAVIndex()
                byte[] r2 = com.tutk.IOTC.Packet.intToByteArray_Little(r0)
                r3 = 255(0xff, float:3.57E-43)
                r4 = 4
                com.tutk.IOTC.AVAPIs.avSendIOCtrl(r1, r3, r2, r4)
                java.lang.String r1 = "IOTCamera"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "avSendIOCtrl("
                r2.append(r5)
                com.tutk.IOTC.Camera$AVChannel r5 = r7.mAVChannel
                int r5 = r5.getAVIndex()
                r2.append(r5)
                java.lang.String r5 = ", 0x"
                r2.append(r5)
                java.lang.String r3 = java.lang.Integer.toHexString(r3)
                r2.append(r3)
                java.lang.String r3 = ", "
                r2.append(r3)
                byte[] r0 = com.tutk.IOTC.Packet.intToByteArray_Little(r0)
                java.lang.String r0 = com.tutk.IOTC.Camera.getHex(r0, r4)
                r3 = r2
                r2 = r1
                r1 = r7
                goto L_0x00f6
            L_0x008a:
                r0 = r7
            L_0x008b:
                boolean r1 = r0.bIsRunning
                if (r1 == 0) goto L_0x012c
                com.tutk.IOTC.Camera r1 = com.tutk.IOTC.Camera.this
                int r1 = r1.mSID
                if (r1 < 0) goto L_0x011f
                com.tutk.IOTC.Camera$AVChannel r1 = r0.mAVChannel
                int r1 = r1.getAVIndex()
                if (r1 < 0) goto L_0x011f
                com.tutk.IOTC.Camera$AVChannel r1 = r0.mAVChannel
                com.tutk.IOTC.Camera$IOCtrlQueue r1 = r1.IOCtrlQueue
                boolean r1 = r1.isEmpty()
                if (r1 != 0) goto L_0x011f
                com.tutk.IOTC.Camera$AVChannel r1 = r0.mAVChannel
                com.tutk.IOTC.Camera$IOCtrlQueue r1 = r1.IOCtrlQueue
                com.tutk.IOTC.Camera$IOCtrlQueue$IOCtrlSet r1 = r1.Dequeue()
                boolean r2 = r0.bIsRunning
                if (r2 == 0) goto L_0x008b
                if (r1 == 0) goto L_0x008b
                com.tutk.IOTC.Camera$AVChannel r2 = r0.mAVChannel
                int r2 = r2.getAVIndex()
                int r3 = r1.IOCtrlType
                byte[] r4 = r1.IOCtrlBuf
                int r5 = r4.length
                int r2 = com.tutk.IOTC.AVAPIs.avSendIOCtrl(r2, r3, r4, r5)
                if (r2 < 0) goto L_0x0107
                java.lang.String r2 = "IOTCamera"
                java.lang.String r3 = "avSendIOCtrl("
                java.lang.StringBuilder r3 = a.a.a.a.a.n(r3)
                com.tutk.IOTC.Camera$AVChannel r4 = r0.mAVChannel
                int r4 = r4.getAVIndex()
                r3.append(r4)
                java.lang.String r4 = ", 0x"
                r3.append(r4)
                int r4 = r1.IOCtrlType
                java.lang.String r4 = java.lang.Integer.toHexString(r4)
                r3.append(r4)
                java.lang.String r4 = ", "
                r3.append(r4)
                byte[] r1 = r1.IOCtrlBuf
                int r4 = r1.length
                java.lang.String r1 = com.tutk.IOTC.Camera.getHex(r1, r4)
                r6 = r1
                r1 = r0
                r0 = r6
            L_0x00f6:
                r3.append(r0)
                java.lang.String r0 = ")"
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                android.util.Log.i(r2, r0)
                r0 = r1
                goto L_0x008b
            L_0x0107:
                java.lang.String r1 = "IOTCamera"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "avSendIOCtrl failed : "
                r3.append(r4)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                android.util.Log.i(r1, r2)
                goto L_0x008b
            L_0x011f:
                r1 = 50
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x0126 }
                goto L_0x008b
            L_0x0126:
                r1 = move-exception
                r1.printStackTrace()
                goto L_0x008b
            L_0x012c:
                java.lang.String r0 = "IOTCamera"
                java.lang.String r1 = "===ThreadSendIOCtrl exit==="
                android.util.Log.i(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tutk.IOTC.Camera.ThreadSendIOCtrl.run():void");
        }

        public void stopThread() {
            this.bIsRunning = false;
            if (this.mAVChannel.getAVIndex() >= 0) {
                StringBuilder n = a.n("avSendIOCtrlExit(");
                n.append(this.mAVChannel.getAVIndex());
                n.append(")");
                Log.i("IOTCamera", n.toString());
                AVAPIs.avSendIOCtrlExit(this.mAVChannel.getAVIndex());
            }
        }
    }

    public class ThreadStartDev extends Thread {
        public AVChannel mAVChannel;
        public boolean mIsRunning = false;
        public Object mWaitObject = new Object();

        public ThreadStartDev(AVChannel aVChannel) {
            this.mAVChannel = aVChannel;
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public void run() {
            /*
                r10 = this;
                r0 = 1
                r10.mIsRunning = r0
            L_0x0003:
                boolean r1 = r10.mIsRunning
                if (r1 == 0) goto L_0x011c
                com.tutk.IOTC.Camera r1 = com.tutk.IOTC.Camera.this
                int r1 = r1.mSID
                if (r1 >= 0) goto L_0x002b
                com.tutk.IOTC.Camera r1 = com.tutk.IOTC.Camera.this     // Catch:{ Exception -> 0x0026 }
                java.lang.Object r1 = r1.mWaitObjectForConnected     // Catch:{ Exception -> 0x0026 }
                monitor-enter(r1)     // Catch:{ Exception -> 0x0026 }
                com.tutk.IOTC.Camera r2 = com.tutk.IOTC.Camera.this     // Catch:{ all -> 0x0023 }
                java.lang.Object r2 = r2.mWaitObjectForConnected     // Catch:{ all -> 0x0023 }
                r3 = 100
                r2.wait(r3)     // Catch:{ all -> 0x0023 }
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                goto L_0x0003
            L_0x0023:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                throw r2     // Catch:{ Exception -> 0x0026 }
            L_0x0026:
                r1 = move-exception
                r1.printStackTrace()
                goto L_0x0003
            L_0x002b:
                r1 = 0
                r2 = 0
            L_0x002d:
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                java.util.List r3 = r3.mIOTCListeners
                int r3 = r3.size()
                if (r2 >= r3) goto L_0x0053
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                java.util.List r3 = r3.mIOTCListeners
                java.lang.Object r3 = r3.get(r2)
                com.tutk.IOTC.IRegisterIOTCListener r3 = (com.tutk.IOTC.IRegisterIOTCListener) r3
                com.tutk.IOTC.Camera r4 = com.tutk.IOTC.Camera.this
                com.tutk.IOTC.Camera$AVChannel r5 = r10.mAVChannel
                int r5 = r5.getChannel()
                r3.receiveChannelInfo(r4, r5, r0)
                int r2 = r2 + 1
                goto L_0x002d
            L_0x0053:
                int[] r2 = new int[r0]
                r3 = -1
                r2[r1] = r3
                int[] r9 = new int[r0]
                r9[r1] = r1
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                int r3 = r3.mSID
                com.tutk.IOTC.Camera$AVChannel r4 = r10.mAVChannel
                java.lang.String r4 = r4.getViewAcc()
                com.tutk.IOTC.Camera$AVChannel r5 = r10.mAVChannel
                java.lang.String r5 = r5.getViewPwd()
                r6 = 30
                com.tutk.IOTC.Camera$AVChannel r7 = r10.mAVChannel
                int r8 = r7.getChannel()
                r7 = r2
                int r3 = com.tutk.IOTC.AVAPIs.avClientStart2(r3, r4, r5, r6, r7, r8, r9)
                r2 = r2[r1]
                long r4 = (long) r2
                if (r3 < 0) goto L_0x00b1
                com.tutk.IOTC.Camera$AVChannel r0 = r10.mAVChannel
                r0.setAVIndex(r3)
                com.tutk.IOTC.Camera$AVChannel r0 = r10.mAVChannel
                r0.setServiceType(r4)
            L_0x008a:
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                java.util.List r0 = r0.mIOTCListeners
                int r0 = r0.size()
                if (r1 >= r0) goto L_0x011c
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                java.util.List r0 = r0.mIOTCListeners
                java.lang.Object r0 = r0.get(r1)
                com.tutk.IOTC.IRegisterIOTCListener r0 = (com.tutk.IOTC.IRegisterIOTCListener) r0
                com.tutk.IOTC.Camera r2 = com.tutk.IOTC.Camera.this
                com.tutk.IOTC.Camera$AVChannel r3 = r10.mAVChannel
                int r3 = r3.getChannel()
                r4 = 2
                r0.receiveChannelInfo(r2, r3, r4)
                int r1 = r1 + 1
                goto L_0x008a
            L_0x00b1:
                r2 = -20016(0xffffffffffffb1d0, float:NaN)
                if (r3 == r2) goto L_0x00f5
                r2 = -20011(0xffffffffffffb1d5, float:NaN)
                if (r3 != r2) goto L_0x00ba
                goto L_0x00f5
            L_0x00ba:
                r2 = -20009(0xffffffffffffb1d7, float:NaN)
                if (r3 != r2) goto L_0x00e5
            L_0x00be:
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                java.util.List r0 = r0.mIOTCListeners
                int r0 = r0.size()
                if (r1 >= r0) goto L_0x011c
                com.tutk.IOTC.Camera r0 = com.tutk.IOTC.Camera.this
                java.util.List r0 = r0.mIOTCListeners
                java.lang.Object r0 = r0.get(r1)
                com.tutk.IOTC.IRegisterIOTCListener r0 = (com.tutk.IOTC.IRegisterIOTCListener) r0
                com.tutk.IOTC.Camera r2 = com.tutk.IOTC.Camera.this
                com.tutk.IOTC.Camera$AVChannel r3 = r10.mAVChannel
                int r3 = r3.getChannel()
                r4 = 5
                r0.receiveChannelInfo(r2, r3, r4)
                int r1 = r1 + 1
                goto L_0x00be
            L_0x00e5:
                java.lang.Object r1 = r10.mWaitObject     // Catch:{ Exception -> 0x0026 }
                monitor-enter(r1)     // Catch:{ Exception -> 0x0026 }
                java.lang.Object r2 = r10.mWaitObject     // Catch:{ all -> 0x00f2 }
                r3 = 1000(0x3e8, double:4.94E-321)
                r2.wait(r3)     // Catch:{ all -> 0x00f2 }
                monitor-exit(r1)     // Catch:{ all -> 0x00f2 }
                goto L_0x0003
            L_0x00f2:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00f2 }
                throw r2     // Catch:{ Exception -> 0x0026 }
            L_0x00f5:
                com.tutk.IOTC.Camera r2 = com.tutk.IOTC.Camera.this
                java.util.List r2 = r2.mIOTCListeners
                int r2 = r2.size()
                if (r1 >= r2) goto L_0x0003
                com.tutk.IOTC.Camera r2 = com.tutk.IOTC.Camera.this
                java.util.List r2 = r2.mIOTCListeners
                java.lang.Object r2 = r2.get(r1)
                com.tutk.IOTC.IRegisterIOTCListener r2 = (com.tutk.IOTC.IRegisterIOTCListener) r2
                com.tutk.IOTC.Camera r3 = com.tutk.IOTC.Camera.this
                com.tutk.IOTC.Camera$AVChannel r4 = r10.mAVChannel
                int r4 = r4.getChannel()
                r5 = 6
                r2.receiveChannelInfo(r3, r4, r5)
                int r1 = r1 + 1
                goto L_0x00f5
            L_0x011c:
                java.lang.String r0 = "IOTCamera"
                java.lang.String r1 = "===ThreadStartDev exit==="
                android.util.Log.i(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tutk.IOTC.Camera.ThreadStartDev.run():void");
        }

        public void stopThread() {
            this.mIsRunning = false;
            if (Camera.this.mSID >= 0) {
                StringBuilder n = a.n("avClientExit(");
                n.append(Camera.this.mSID);
                n.append(", ");
                n.append(this.mAVChannel.getChannel());
                n.append(")");
                Log.i("IOTCamera", n.toString());
                AVAPIs.avClientExit(Camera.this.mSID, this.mAVChannel.getChannel());
            }
            synchronized (this.mWaitObject) {
                this.mWaitObject.notify();
            }
        }
    }

    public static synchronized St_LanSearchResp[] SearchLAN() {
        St_LanSearchResp[] SA;
        synchronized (Camera.class) {
            SA = IOTCAPIs.SA(new int[1], -41506276);
        }
        return SA;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a6, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean audioDev_init(int r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = r11.mInitAudio     // Catch:{ all -> 0x00a9 }
            r1 = 0
            if (r0 != 0) goto L_0x00a7
            r0 = 3
            r2 = 2
            r3 = 1
            if (r13 != r3) goto L_0x000d
            r7 = 3
            goto L_0x000e
        L_0x000d:
            r7 = 2
        L_0x000e:
            if (r14 != r3) goto L_0x0012
            r8 = 2
            goto L_0x0013
        L_0x0012:
            r8 = 3
        L_0x0013:
            int r9 = android.media.AudioTrack.getMinBufferSize(r12, r7, r8)     // Catch:{ all -> 0x00a9 }
            r0 = -2
            if (r9 == r0) goto L_0x00a5
            r0 = -1
            if (r9 != r0) goto L_0x001f
            goto L_0x00a5
        L_0x001f:
            android.media.AudioTrack r0 = new android.media.AudioTrack     // Catch:{ IllegalArgumentException -> 0x009f }
            r5 = 3
            r10 = 1
            r4 = r0
            r6 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ IllegalArgumentException -> 0x009f }
            r11.mAudioTrack = r0     // Catch:{ IllegalArgumentException -> 0x009f }
            java.lang.String r0 = "IOTCamera"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x009f }
            r4.<init>()     // Catch:{ IllegalArgumentException -> 0x009f }
            java.lang.String r5 = "init AudioTrack with SampleRate:"
            r4.append(r5)     // Catch:{ IllegalArgumentException -> 0x009f }
            r4.append(r12)     // Catch:{ IllegalArgumentException -> 0x009f }
            java.lang.String r5 = " "
            r4.append(r5)     // Catch:{ IllegalArgumentException -> 0x009f }
            r5 = 16
            r6 = 8
            if (r14 != r3) goto L_0x0049
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ IllegalArgumentException -> 0x009f }
            goto L_0x004d
        L_0x0049:
            java.lang.String r7 = java.lang.String.valueOf(r6)     // Catch:{ IllegalArgumentException -> 0x009f }
        L_0x004d:
            r4.append(r7)     // Catch:{ IllegalArgumentException -> 0x009f }
            java.lang.String r7 = "bit "
            r4.append(r7)     // Catch:{ IllegalArgumentException -> 0x009f }
            if (r13 != r3) goto L_0x005a
            java.lang.String r13 = "Stereo"
            goto L_0x005c
        L_0x005a:
            java.lang.String r13 = "Mono"
        L_0x005c:
            r4.append(r13)     // Catch:{ IllegalArgumentException -> 0x009f }
            java.lang.String r13 = r4.toString()     // Catch:{ IllegalArgumentException -> 0x009f }
            android.util.Log.i(r0, r13)     // Catch:{ IllegalArgumentException -> 0x009f }
            r13 = 141(0x8d, float:1.98E-43)
            if (r15 != r13) goto L_0x006e
            com.decoder.util.DecSpeex.InitDecoder(r12)     // Catch:{ all -> 0x00a9 }
            goto L_0x008f
        L_0x006e:
            r13 = 142(0x8e, float:1.99E-43)
            if (r15 != r13) goto L_0x007b
            if (r14 != r3) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r5 = 8
        L_0x0077:
            com.decoder.util.DecMp3.InitDecoder(r12, r5)     // Catch:{ all -> 0x00a9 }
            goto L_0x008f
        L_0x007b:
            r12 = 139(0x8b, float:1.95E-43)
            if (r15 == r12) goto L_0x008c
            r12 = 140(0x8c, float:1.96E-43)
            if (r15 != r12) goto L_0x0084
            goto L_0x008c
        L_0x0084:
            r12 = 143(0x8f, float:2.0E-43)
            if (r15 != r12) goto L_0x008f
            com.decoder.util.DecG726.g726_dec_state_create(r1, r2)     // Catch:{ all -> 0x00a9 }
            goto L_0x008f
        L_0x008c:
            com.decoder.util.DecADPCM.ResetDecoder()     // Catch:{ all -> 0x00a9 }
        L_0x008f:
            android.media.AudioTrack r12 = r11.mAudioTrack     // Catch:{ all -> 0x00a9 }
            r13 = 1065353216(0x3f800000, float:1.0)
            r12.setStereoVolume(r13, r13)     // Catch:{ all -> 0x00a9 }
            android.media.AudioTrack r12 = r11.mAudioTrack     // Catch:{ all -> 0x00a9 }
            r12.play()     // Catch:{ all -> 0x00a9 }
            r11.mInitAudio = r3     // Catch:{ all -> 0x00a9 }
            monitor-exit(r11)
            return r3
        L_0x009f:
            r12 = move-exception
            r12.printStackTrace()     // Catch:{ all -> 0x00a9 }
            monitor-exit(r11)
            return r1
        L_0x00a5:
            monitor-exit(r11)
            return r1
        L_0x00a7:
            monitor-exit(r11)
            return r1
        L_0x00a9:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tutk.IOTC.Camera.audioDev_init(int, int, int, int):boolean");
    }

    /* access modifiers changed from: private */
    public synchronized void audioDev_stop(int i) {
        if (this.mInitAudio) {
            if (this.mAudioTrack != null) {
                this.mAudioTrack.stop();
                this.mAudioTrack.release();
                this.mAudioTrack = null;
            }
            if (i == 141) {
                DecSpeex.UninitDecoder();
            } else if (i == 142) {
                DecMp3.UninitDecoder();
            } else if (i == 143) {
                DecG726.g726_dec_state_destroy();
            }
            this.mInitAudio = false;
        }
    }

    public static String getHex(byte[] bArr, int i) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i2 = 0;
        for (byte b2 : bArr) {
            sb.append(HEXES.charAt((b2 & 240) >> 4));
            sb.append(HEXES.charAt(b2 & 15));
            sb.append(" ");
            i2++;
            if (i2 >= i) {
                break;
            }
        }
        return sb.toString();
    }

    public static synchronized int init() {
        synchronized (Camera.class) {
            int i = 0;
            if (mCameraCount == 0) {
                int IOTC_Initialize2 = IOTCAPIs.IOTC_Initialize2((int) ((System.currentTimeMillis() % 10000) + 10000));
                Log.i("IOTCamera", "IOTC_Initialize2() returns " + IOTC_Initialize2);
                if (IOTC_Initialize2 < 0) {
                    return IOTC_Initialize2;
                }
                i = AVAPIs.avInitialize(mDefaultMaxCameraLimit * 16);
                Log.i("IOTCamera", "avInitialize() = " + i);
                if (i < 0) {
                    return i;
                }
            }
            mCameraCount++;
            return i;
        }
    }

    public static void setMaxCameraLimit(int i) {
        mDefaultMaxCameraLimit = i;
    }

    public static synchronized int uninit() {
        int i;
        synchronized (Camera.class) {
            i = 0;
            if (mCameraCount > 0) {
                mCameraCount--;
                if (mCameraCount == 0) {
                    Log.i("IOTCamera", "avDeInitialize() returns " + AVAPIs.avDeInitialize());
                    i = IOTCAPIs.IOTC_DeInitialize();
                    Log.i("IOTCamera", "IOTC_DeInitialize() returns " + i);
                }
            }
        }
        return i;
    }

    public Bitmap Snapshot(int i) {
        Bitmap bitmap;
        synchronized (this.mAVChannels) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.mAVChannels.size()) {
                    bitmap = null;
                    break;
                }
                AVChannel aVChannel = this.mAVChannels.get(i2);
                if (i == aVChannel.getChannel()) {
                    bitmap = aVChannel.LastFrame;
                    break;
                }
                i2++;
            }
        }
        return bitmap;
    }

    public void connect(String str) {
        this.mDevUID = str;
        if (this.mThreadConnectDev == null) {
            ThreadConnectDev threadConnectDev = new ThreadConnectDev(0);
            this.mThreadConnectDev = threadConnectDev;
            threadConnectDev.start();
        }
        if (this.mThreadChkDevStatus == null) {
            ThreadCheckDevStatus threadCheckDevStatus = new ThreadCheckDevStatus();
            this.mThreadChkDevStatus = threadCheckDevStatus;
            threadCheckDevStatus.start();
        }
    }

    public void connect(String str, String str2) {
        this.mDevUID = str;
        this.mDevPwd = str2;
        if (this.mThreadConnectDev == null) {
            ThreadConnectDev threadConnectDev = new ThreadConnectDev(1);
            this.mThreadConnectDev = threadConnectDev;
            threadConnectDev.start();
        }
        if (this.mThreadChkDevStatus == null) {
            ThreadCheckDevStatus threadCheckDevStatus = new ThreadCheckDevStatus();
            this.mThreadChkDevStatus = threadCheckDevStatus;
            threadCheckDevStatus.start();
        }
    }

    public void disconnect() {
        synchronized (this.mAVChannels) {
            for (AVChannel next : this.mAVChannels) {
                stopSpeaking(next.getChannel());
                if (next.threadStartDev != null) {
                    next.threadStartDev.stopThread();
                }
                if (next.threadDecAudio != null) {
                    next.threadDecAudio.stopThread();
                }
                if (next.threadDecVideo != null) {
                    next.threadDecVideo.stopThread();
                }
                if (next.threadRecvAudio != null) {
                    next.threadRecvAudio.stopThread();
                }
                if (next.threadRecvVideo != null) {
                    next.threadRecvVideo.stopThread();
                }
                if (next.threadRecvIOCtrl != null) {
                    next.threadRecvIOCtrl.stopThread();
                }
                if (next.threadSendIOCtrl != null) {
                    next.threadSendIOCtrl.stopThread();
                }
                if (next.threadRecvVideo != null) {
                    try {
                        next.threadRecvVideo.interrupt();
                        next.threadRecvVideo.join();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    next.threadRecvVideo = null;
                }
                if (next.threadRecvAudio != null) {
                    try {
                        next.threadRecvAudio.interrupt();
                        next.threadRecvAudio.join();
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                    next.threadRecvAudio = null;
                }
                if (next.threadDecAudio != null) {
                    try {
                        next.threadDecAudio.interrupt();
                        next.threadDecAudio.join();
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                    next.threadDecAudio = null;
                }
                if (next.threadDecVideo != null) {
                    try {
                        next.threadDecVideo.interrupt();
                        next.threadDecVideo.join();
                    } catch (InterruptedException e5) {
                        e5.printStackTrace();
                    }
                    next.threadDecVideo = null;
                }
                if (next.threadRecvIOCtrl != null) {
                    try {
                        next.threadRecvIOCtrl.interrupt();
                        next.threadRecvIOCtrl.join();
                    } catch (InterruptedException e6) {
                        e6.printStackTrace();
                    }
                    next.threadRecvIOCtrl = null;
                }
                if (next.threadSendIOCtrl != null) {
                    try {
                        next.threadSendIOCtrl.interrupt();
                        next.threadSendIOCtrl.join();
                    } catch (InterruptedException e7) {
                        e7.printStackTrace();
                    }
                    next.threadSendIOCtrl = null;
                }
                if (next.threadStartDev != null && next.threadStartDev.isAlive()) {
                    try {
                        next.threadStartDev.interrupt();
                        next.threadStartDev.join();
                    } catch (InterruptedException e8) {
                        e8.printStackTrace();
                    }
                }
                next.threadStartDev = null;
                next.AudioFrameQueue.removeAll();
                next.AudioFrameQueue = null;
                next.VideoFrameQueue.removeAll();
                next.VideoFrameQueue = null;
                next.IOCtrlQueue.removeAll();
                next.IOCtrlQueue = null;
                if (next.getAVIndex() >= 0) {
                    AVAPIs.avClientStop(next.getAVIndex());
                    Log.i("IOTCamera", "avClientStop(avIndex = " + next.getAVIndex() + ")");
                }
            }
        }
        this.mAVChannels.clear();
        synchronized (this.mWaitObjectForConnected) {
            this.mWaitObjectForConnected.notify();
        }
        ThreadCheckDevStatus threadCheckDevStatus = this.mThreadChkDevStatus;
        if (threadCheckDevStatus != null) {
            threadCheckDevStatus.stopThread();
        }
        ThreadConnectDev threadConnectDev = this.mThreadConnectDev;
        if (threadConnectDev != null) {
            threadConnectDev.stopThread();
        }
        ThreadCheckDevStatus threadCheckDevStatus2 = this.mThreadChkDevStatus;
        if (threadCheckDevStatus2 != null) {
            try {
                threadCheckDevStatus2.interrupt();
                this.mThreadChkDevStatus.join();
            } catch (InterruptedException e9) {
                e9.printStackTrace();
            }
            this.mThreadChkDevStatus = null;
        }
        ThreadConnectDev threadConnectDev2 = this.mThreadConnectDev;
        if (threadConnectDev2 != null && threadConnectDev2.isAlive()) {
            try {
                this.mThreadConnectDev.interrupt();
                this.mThreadConnectDev.join();
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
        this.mThreadConnectDev = null;
        if (this.mSID >= 0) {
            IOTCAPIs.IOTC_Session_Close(this.mSID);
            Log.i("IOTCamera", "IOTC_Session_Close(nSID = " + this.mSID + ")");
            this.mSID = -1;
        }
        this.mSessionMode = -1;
    }

    public long getChannelServiceType(int i) {
        long j;
        synchronized (this.mAVChannels) {
            Iterator<AVChannel> it = this.mAVChannels.iterator();
            while (true) {
                if (!it.hasNext()) {
                    j = 0;
                    break;
                }
                AVChannel next = it.next();
                if (next.getChannel() == i) {
                    j = next.getServiceType();
                    break;
                }
            }
        }
        return j;
    }

    public int getSessionMode() {
        return this.mSessionMode;
    }

    public boolean isChannelConnected(int i) {
        boolean z;
        synchronized (this.mAVChannels) {
            Iterator<AVChannel> it = this.mAVChannels.iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                }
                AVChannel next = it.next();
                if (i == next.getChannel()) {
                    if (this.mSID >= 0 && next.getAVIndex() >= 0) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public boolean isSessionConnected() {
        return this.mSID >= 0;
    }

    public boolean registerIOTCListener(IRegisterIOTCListener iRegisterIOTCListener) {
        if (this.mIOTCListeners.contains(iRegisterIOTCListener)) {
            return false;
        }
        Log.i("IOTCamera", "register IOTC listener");
        this.mIOTCListeners.add(iRegisterIOTCListener);
        return true;
    }

    public void sendIOCtrl(int i, int i2, byte[] bArr) {
        synchronized (this.mAVChannels) {
            for (AVChannel next : this.mAVChannels) {
                if (i == next.getChannel()) {
                    next.IOCtrlQueue.Enqueue(i2, bArr);
                }
            }
        }
    }

    public void start(int i, String str, String str2) {
        AVChannel aVChannel;
        ThreadSendIOCtrl threadSendIOCtrl;
        synchronized (this.mAVChannels) {
            Iterator<AVChannel> it = this.mAVChannels.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVChannel = null;
                    break;
                }
                aVChannel = it.next();
                if (aVChannel.getChannel() == i) {
                    break;
                }
            }
        }
        if (aVChannel == null) {
            AVChannel aVChannel2 = new AVChannel(i, str, str2);
            this.mAVChannels.add(aVChannel2);
            ThreadStartDev threadStartDev = new ThreadStartDev(aVChannel2);
            aVChannel2.threadStartDev = threadStartDev;
            threadStartDev.start();
            ThreadRecvIOCtrl threadRecvIOCtrl = new ThreadRecvIOCtrl(aVChannel2);
            aVChannel2.threadRecvIOCtrl = threadRecvIOCtrl;
            threadRecvIOCtrl.start();
            threadSendIOCtrl = new ThreadSendIOCtrl(aVChannel2);
            aVChannel2.threadSendIOCtrl = threadSendIOCtrl;
        } else {
            if (aVChannel.threadStartDev == null) {
                ThreadStartDev threadStartDev2 = new ThreadStartDev(aVChannel);
                aVChannel.threadStartDev = threadStartDev2;
                threadStartDev2.start();
            }
            if (aVChannel.threadRecvIOCtrl == null) {
                ThreadRecvIOCtrl threadRecvIOCtrl2 = new ThreadRecvIOCtrl(aVChannel);
                aVChannel.threadRecvIOCtrl = threadRecvIOCtrl2;
                threadRecvIOCtrl2.start();
            }
            if (aVChannel.threadSendIOCtrl == null) {
                threadSendIOCtrl = new ThreadSendIOCtrl(aVChannel);
                aVChannel.threadSendIOCtrl = threadSendIOCtrl;
            } else {
                return;
            }
        }
        threadSendIOCtrl.start();
    }

    public void startListening(int i) {
        synchronized (this.mAVChannels) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.mAVChannels.size()) {
                    break;
                }
                AVChannel aVChannel = this.mAVChannels.get(i2);
                if (i == aVChannel.getChannel()) {
                    aVChannel.AudioFrameQueue.removeAll();
                    if (aVChannel.threadRecvAudio == null) {
                        ThreadRecvAudio threadRecvAudio = new ThreadRecvAudio(aVChannel);
                        aVChannel.threadRecvAudio = threadRecvAudio;
                        threadRecvAudio.start();
                    }
                } else {
                    i2++;
                }
            }
        }
    }

    public void startShow(int i) {
        synchronized (this.mAVChannels) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.mAVChannels.size()) {
                    break;
                }
                AVChannel aVChannel = this.mAVChannels.get(i2);
                if (aVChannel.getChannel() == i) {
                    aVChannel.VideoFrameQueue.removeAll();
                    if (aVChannel.threadRecvVideo == null) {
                        ThreadRecvVideo2 threadRecvVideo2 = new ThreadRecvVideo2(aVChannel);
                        aVChannel.threadRecvVideo = threadRecvVideo2;
                        threadRecvVideo2.start();
                    }
                    if (aVChannel.threadDecVideo == null) {
                        ThreadDecodeVideo2 threadDecodeVideo2 = new ThreadDecodeVideo2(aVChannel);
                        aVChannel.threadDecVideo = threadDecodeVideo2;
                        threadDecodeVideo2.start();
                    }
                } else {
                    i2++;
                }
            }
        }
    }

    public void startSpeaking(int i) {
        synchronized (this.mAVChannels) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.mAVChannels.size()) {
                    break;
                }
                AVChannel aVChannel = this.mAVChannels.get(i2);
                if (aVChannel.getChannel() == i) {
                    aVChannel.AudioFrameQueue.removeAll();
                    if (this.mThreadSendAudio == null) {
                        ThreadSendAudio threadSendAudio = new ThreadSendAudio(aVChannel);
                        this.mThreadSendAudio = threadSendAudio;
                        threadSendAudio.start();
                    }
                } else {
                    i2++;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r3.threadStartDev.stopThread();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r3.threadDecAudio == null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r3.threadDecAudio.stopThread();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        if (r3.threadDecVideo == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        r3.threadDecVideo.stopThread();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r3.threadRecvAudio == null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        r3.threadRecvAudio.stopThread();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
        if (r3.threadRecvVideo == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
        r3.threadRecvVideo.stopThread();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r3.threadRecvIOCtrl == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r3.threadRecvIOCtrl.stopThread();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005a, code lost:
        if (r3.threadSendIOCtrl == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        r3.threadSendIOCtrl.stopThread();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0064, code lost:
        if (r3.threadRecvVideo == null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r3.threadRecvVideo.interrupt();
        r3.threadRecvVideo.join();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0071, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        stopSpeaking(r3.getChannel());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r3.threadStartDev == null) goto L_0x002b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0090 A[SYNTHETIC, Splitter:B:48:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a5 A[SYNTHETIC, Splitter:B:56:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ba A[SYNTHETIC, Splitter:B:64:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00cf A[SYNTHETIC, Splitter:B:72:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0118 A[Catch:{ InterruptedException -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0146 A[Catch:{ InterruptedException -> 0x0071 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stop(int r6) {
        /*
            r5 = this;
            java.util.List<com.tutk.IOTC.Camera$AVChannel> r0 = r5.mAVChannels
            monitor-enter(r0)
            r1 = -1
            r2 = 0
        L_0x0005:
            java.util.List<com.tutk.IOTC.Camera$AVChannel> r3 = r5.mAVChannels     // Catch:{ all -> 0x014d }
            int r3 = r3.size()     // Catch:{ all -> 0x014d }
            if (r2 >= r3) goto L_0x0144
            java.util.List<com.tutk.IOTC.Camera$AVChannel> r3 = r5.mAVChannels     // Catch:{ all -> 0x014d }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x014d }
            com.tutk.IOTC.Camera$AVChannel r3 = (com.tutk.IOTC.Camera.AVChannel) r3     // Catch:{ all -> 0x014d }
            int r4 = r3.getChannel()     // Catch:{ all -> 0x014d }
            if (r4 != r6) goto L_0x0140
            int r6 = r3.getChannel()     // Catch:{ all -> 0x014d }
            r5.stopSpeaking(r6)     // Catch:{ all -> 0x014d }
            com.tutk.IOTC.Camera$ThreadStartDev r6 = r3.threadStartDev     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x002b
            com.tutk.IOTC.Camera$ThreadStartDev r6 = r3.threadStartDev     // Catch:{ all -> 0x014d }
            r6.stopThread()     // Catch:{ all -> 0x014d }
        L_0x002b:
            com.tutk.IOTC.Camera$ThreadDecodeAudio r6 = r3.threadDecAudio     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x0034
            com.tutk.IOTC.Camera$ThreadDecodeAudio r6 = r3.threadDecAudio     // Catch:{ all -> 0x014d }
            r6.stopThread()     // Catch:{ all -> 0x014d }
        L_0x0034:
            com.tutk.IOTC.Camera$ThreadDecodeVideo2 r6 = r3.threadDecVideo     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x003d
            com.tutk.IOTC.Camera$ThreadDecodeVideo2 r6 = r3.threadDecVideo     // Catch:{ all -> 0x014d }
            r6.stopThread()     // Catch:{ all -> 0x014d }
        L_0x003d:
            com.tutk.IOTC.Camera$ThreadRecvAudio r6 = r3.threadRecvAudio     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x0046
            com.tutk.IOTC.Camera$ThreadRecvAudio r6 = r3.threadRecvAudio     // Catch:{ all -> 0x014d }
            r6.stopThread()     // Catch:{ all -> 0x014d }
        L_0x0046:
            com.tutk.IOTC.Camera$ThreadRecvVideo2 r6 = r3.threadRecvVideo     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x004f
            com.tutk.IOTC.Camera$ThreadRecvVideo2 r6 = r3.threadRecvVideo     // Catch:{ all -> 0x014d }
            r6.stopThread()     // Catch:{ all -> 0x014d }
        L_0x004f:
            com.tutk.IOTC.Camera$ThreadRecvIOCtrl r6 = r3.threadRecvIOCtrl     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x0058
            com.tutk.IOTC.Camera$ThreadRecvIOCtrl r6 = r3.threadRecvIOCtrl     // Catch:{ all -> 0x014d }
            r6.stopThread()     // Catch:{ all -> 0x014d }
        L_0x0058:
            com.tutk.IOTC.Camera$ThreadSendIOCtrl r6 = r3.threadSendIOCtrl     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x0061
            com.tutk.IOTC.Camera$ThreadSendIOCtrl r6 = r3.threadSendIOCtrl     // Catch:{ all -> 0x014d }
            r6.stopThread()     // Catch:{ all -> 0x014d }
        L_0x0061:
            com.tutk.IOTC.Camera$ThreadRecvVideo2 r6 = r3.threadRecvVideo     // Catch:{ all -> 0x014d }
            r1 = 0
            if (r6 == 0) goto L_0x0077
            com.tutk.IOTC.Camera$ThreadRecvVideo2 r6 = r3.threadRecvVideo     // Catch:{ InterruptedException -> 0x0071 }
            r6.interrupt()     // Catch:{ InterruptedException -> 0x0071 }
            com.tutk.IOTC.Camera$ThreadRecvVideo2 r6 = r3.threadRecvVideo     // Catch:{ InterruptedException -> 0x0071 }
            r6.join()     // Catch:{ InterruptedException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x014d }
        L_0x0075:
            r3.threadRecvVideo = r1     // Catch:{ all -> 0x014d }
        L_0x0077:
            com.tutk.IOTC.Camera$ThreadRecvAudio r6 = r3.threadRecvAudio     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x008c
            com.tutk.IOTC.Camera$ThreadRecvAudio r6 = r3.threadRecvAudio     // Catch:{ InterruptedException -> 0x0086 }
            r6.interrupt()     // Catch:{ InterruptedException -> 0x0086 }
            com.tutk.IOTC.Camera$ThreadRecvAudio r6 = r3.threadRecvAudio     // Catch:{ InterruptedException -> 0x0086 }
            r6.join()     // Catch:{ InterruptedException -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x014d }
        L_0x008a:
            r3.threadRecvAudio = r1     // Catch:{ all -> 0x014d }
        L_0x008c:
            com.tutk.IOTC.Camera$ThreadDecodeAudio r6 = r3.threadDecAudio     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x00a1
            com.tutk.IOTC.Camera$ThreadDecodeAudio r6 = r3.threadDecAudio     // Catch:{ InterruptedException -> 0x009b }
            r6.interrupt()     // Catch:{ InterruptedException -> 0x009b }
            com.tutk.IOTC.Camera$ThreadDecodeAudio r6 = r3.threadDecAudio     // Catch:{ InterruptedException -> 0x009b }
            r6.join()     // Catch:{ InterruptedException -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x014d }
        L_0x009f:
            r3.threadDecAudio = r1     // Catch:{ all -> 0x014d }
        L_0x00a1:
            com.tutk.IOTC.Camera$ThreadDecodeVideo2 r6 = r3.threadDecVideo     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x00b6
            com.tutk.IOTC.Camera$ThreadDecodeVideo2 r6 = r3.threadDecVideo     // Catch:{ InterruptedException -> 0x00b0 }
            r6.interrupt()     // Catch:{ InterruptedException -> 0x00b0 }
            com.tutk.IOTC.Camera$ThreadDecodeVideo2 r6 = r3.threadDecVideo     // Catch:{ InterruptedException -> 0x00b0 }
            r6.join()     // Catch:{ InterruptedException -> 0x00b0 }
            goto L_0x00b4
        L_0x00b0:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x014d }
        L_0x00b4:
            r3.threadDecVideo = r1     // Catch:{ all -> 0x014d }
        L_0x00b6:
            com.tutk.IOTC.Camera$ThreadRecvIOCtrl r6 = r3.threadRecvIOCtrl     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x00cb
            com.tutk.IOTC.Camera$ThreadRecvIOCtrl r6 = r3.threadRecvIOCtrl     // Catch:{ InterruptedException -> 0x00c5 }
            r6.interrupt()     // Catch:{ InterruptedException -> 0x00c5 }
            com.tutk.IOTC.Camera$ThreadRecvIOCtrl r6 = r3.threadRecvIOCtrl     // Catch:{ InterruptedException -> 0x00c5 }
            r6.join()     // Catch:{ InterruptedException -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x014d }
        L_0x00c9:
            r3.threadRecvIOCtrl = r1     // Catch:{ all -> 0x014d }
        L_0x00cb:
            com.tutk.IOTC.Camera$ThreadSendIOCtrl r6 = r3.threadSendIOCtrl     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x00e0
            com.tutk.IOTC.Camera$ThreadSendIOCtrl r6 = r3.threadSendIOCtrl     // Catch:{ InterruptedException -> 0x00da }
            r6.interrupt()     // Catch:{ InterruptedException -> 0x00da }
            com.tutk.IOTC.Camera$ThreadSendIOCtrl r6 = r3.threadSendIOCtrl     // Catch:{ InterruptedException -> 0x00da }
            r6.join()     // Catch:{ InterruptedException -> 0x00da }
            goto L_0x00de
        L_0x00da:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x014d }
        L_0x00de:
            r3.threadSendIOCtrl = r1     // Catch:{ all -> 0x014d }
        L_0x00e0:
            com.tutk.IOTC.Camera$ThreadStartDev r6 = r3.threadStartDev     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x00fb
            com.tutk.IOTC.Camera$ThreadStartDev r6 = r3.threadStartDev     // Catch:{ all -> 0x014d }
            boolean r6 = r6.isAlive()     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x00fb
            com.tutk.IOTC.Camera$ThreadStartDev r6 = r3.threadStartDev     // Catch:{ InterruptedException -> 0x00f7 }
            r6.interrupt()     // Catch:{ InterruptedException -> 0x00f7 }
            com.tutk.IOTC.Camera$ThreadStartDev r6 = r3.threadStartDev     // Catch:{ InterruptedException -> 0x00f7 }
            r6.join()     // Catch:{ InterruptedException -> 0x00f7 }
            goto L_0x00fb
        L_0x00f7:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x014d }
        L_0x00fb:
            r3.threadStartDev = r1     // Catch:{ all -> 0x014d }
            com.tutk.IOTC.AVFrameQueue r6 = r3.AudioFrameQueue     // Catch:{ all -> 0x014d }
            r6.removeAll()     // Catch:{ all -> 0x014d }
            r3.AudioFrameQueue = r1     // Catch:{ all -> 0x014d }
            com.tutk.IOTC.AVFrameQueue r6 = r3.VideoFrameQueue     // Catch:{ all -> 0x014d }
            r6.removeAll()     // Catch:{ all -> 0x014d }
            r3.VideoFrameQueue = r1     // Catch:{ all -> 0x014d }
            com.tutk.IOTC.Camera$IOCtrlQueue r6 = r3.IOCtrlQueue     // Catch:{ all -> 0x014d }
            r6.removeAll()     // Catch:{ all -> 0x014d }
            r3.IOCtrlQueue = r1     // Catch:{ all -> 0x014d }
            int r6 = r3.getAVIndex()     // Catch:{ all -> 0x014d }
            if (r6 < 0) goto L_0x013e
            int r6 = r3.getAVIndex()     // Catch:{ all -> 0x014d }
            com.tutk.IOTC.AVAPIs.avClientStop(r6)     // Catch:{ all -> 0x014d }
            java.lang.String r6 = "IOTCamera"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x014d }
            r1.<init>()     // Catch:{ all -> 0x014d }
            java.lang.String r4 = "avClientStop(avIndex = "
            r1.append(r4)     // Catch:{ all -> 0x014d }
            int r3 = r3.getAVIndex()     // Catch:{ all -> 0x014d }
            r1.append(r3)     // Catch:{ all -> 0x014d }
            java.lang.String r3 = ")"
            r1.append(r3)     // Catch:{ all -> 0x014d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x014d }
            android.util.Log.i(r6, r1)     // Catch:{ all -> 0x014d }
        L_0x013e:
            r1 = r2
            goto L_0x0144
        L_0x0140:
            int r2 = r2 + 1
            goto L_0x0005
        L_0x0144:
            if (r1 < 0) goto L_0x014b
            java.util.List<com.tutk.IOTC.Camera$AVChannel> r6 = r5.mAVChannels     // Catch:{ all -> 0x014d }
            r6.remove(r1)     // Catch:{ all -> 0x014d }
        L_0x014b:
            monitor-exit(r0)     // Catch:{ all -> 0x014d }
            return
        L_0x014d:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x014d }
            goto L_0x0151
        L_0x0150:
            throw r6
        L_0x0151:
            goto L_0x0150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tutk.IOTC.Camera.stop(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r2.threadRecvAudio.stopThread();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2.threadRecvAudio.interrupt();
        r2.threadRecvAudio.join();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r2.threadRecvAudio == null) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stopListening(int r5) {
        /*
            r4 = this;
            java.util.List<com.tutk.IOTC.Camera$AVChannel> r0 = r4.mAVChannels
            monitor-enter(r0)
            r1 = 0
        L_0x0004:
            java.util.List<com.tutk.IOTC.Camera$AVChannel> r2 = r4.mAVChannels     // Catch:{ all -> 0x005a }
            int r2 = r2.size()     // Catch:{ all -> 0x005a }
            if (r1 >= r2) goto L_0x0058
            java.util.List<com.tutk.IOTC.Camera$AVChannel> r2 = r4.mAVChannels     // Catch:{ all -> 0x005a }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x005a }
            com.tutk.IOTC.Camera$AVChannel r2 = (com.tutk.IOTC.Camera.AVChannel) r2     // Catch:{ all -> 0x005a }
            int r3 = r2.getChannel()     // Catch:{ all -> 0x005a }
            if (r5 != r3) goto L_0x0055
            com.tutk.IOTC.Camera$ThreadRecvAudio r5 = r2.threadRecvAudio     // Catch:{ all -> 0x005a }
            r1 = 0
            if (r5 == 0) goto L_0x0035
            com.tutk.IOTC.Camera$ThreadRecvAudio r5 = r2.threadRecvAudio     // Catch:{ all -> 0x005a }
            r5.stopThread()     // Catch:{ all -> 0x005a }
            com.tutk.IOTC.Camera$ThreadRecvAudio r5 = r2.threadRecvAudio     // Catch:{ InterruptedException -> 0x002f }
            r5.interrupt()     // Catch:{ InterruptedException -> 0x002f }
            com.tutk.IOTC.Camera$ThreadRecvAudio r5 = r2.threadRecvAudio     // Catch:{ InterruptedException -> 0x002f }
            r5.join()     // Catch:{ InterruptedException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x005a }
        L_0x0033:
            r2.threadRecvAudio = r1     // Catch:{ all -> 0x005a }
        L_0x0035:
            com.tutk.IOTC.Camera$ThreadDecodeAudio r5 = r2.threadDecAudio     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x004f
            com.tutk.IOTC.Camera$ThreadDecodeAudio r5 = r2.threadDecAudio     // Catch:{ all -> 0x005a }
            r5.stopThread()     // Catch:{ all -> 0x005a }
            com.tutk.IOTC.Camera$ThreadDecodeAudio r5 = r2.threadDecAudio     // Catch:{ InterruptedException -> 0x0049 }
            r5.interrupt()     // Catch:{ InterruptedException -> 0x0049 }
            com.tutk.IOTC.Camera$ThreadDecodeAudio r5 = r2.threadDecAudio     // Catch:{ InterruptedException -> 0x0049 }
            r5.join()     // Catch:{ InterruptedException -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x005a }
        L_0x004d:
            r2.threadDecAudio = r1     // Catch:{ all -> 0x005a }
        L_0x004f:
            com.tutk.IOTC.AVFrameQueue r5 = r2.AudioFrameQueue     // Catch:{ all -> 0x005a }
            r5.removeAll()     // Catch:{ all -> 0x005a }
            goto L_0x0058
        L_0x0055:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return
        L_0x005a:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            goto L_0x005e
        L_0x005d:
            throw r5
        L_0x005e:
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tutk.IOTC.Camera.stopListening(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r2.threadRecvVideo.stopThread();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2.threadRecvVideo.interrupt();
        r2.threadRecvVideo.join();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r2.threadRecvVideo == null) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stopShow(int r5) {
        /*
            r4 = this;
            java.util.List<com.tutk.IOTC.Camera$AVChannel> r0 = r4.mAVChannels
            monitor-enter(r0)
            r1 = 0
        L_0x0004:
            java.util.List<com.tutk.IOTC.Camera$AVChannel> r2 = r4.mAVChannels     // Catch:{ all -> 0x005a }
            int r2 = r2.size()     // Catch:{ all -> 0x005a }
            if (r1 >= r2) goto L_0x0058
            java.util.List<com.tutk.IOTC.Camera$AVChannel> r2 = r4.mAVChannels     // Catch:{ all -> 0x005a }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x005a }
            com.tutk.IOTC.Camera$AVChannel r2 = (com.tutk.IOTC.Camera.AVChannel) r2     // Catch:{ all -> 0x005a }
            int r3 = r2.getChannel()     // Catch:{ all -> 0x005a }
            if (r3 != r5) goto L_0x0055
            com.tutk.IOTC.Camera$ThreadRecvVideo2 r5 = r2.threadRecvVideo     // Catch:{ all -> 0x005a }
            r1 = 0
            if (r5 == 0) goto L_0x0035
            com.tutk.IOTC.Camera$ThreadRecvVideo2 r5 = r2.threadRecvVideo     // Catch:{ all -> 0x005a }
            r5.stopThread()     // Catch:{ all -> 0x005a }
            com.tutk.IOTC.Camera$ThreadRecvVideo2 r5 = r2.threadRecvVideo     // Catch:{ InterruptedException -> 0x002f }
            r5.interrupt()     // Catch:{ InterruptedException -> 0x002f }
            com.tutk.IOTC.Camera$ThreadRecvVideo2 r5 = r2.threadRecvVideo     // Catch:{ InterruptedException -> 0x002f }
            r5.join()     // Catch:{ InterruptedException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x005a }
        L_0x0033:
            r2.threadRecvVideo = r1     // Catch:{ all -> 0x005a }
        L_0x0035:
            com.tutk.IOTC.Camera$ThreadDecodeVideo2 r5 = r2.threadDecVideo     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x004f
            com.tutk.IOTC.Camera$ThreadDecodeVideo2 r5 = r2.threadDecVideo     // Catch:{ all -> 0x005a }
            r5.stopThread()     // Catch:{ all -> 0x005a }
            com.tutk.IOTC.Camera$ThreadDecodeVideo2 r5 = r2.threadDecVideo     // Catch:{ InterruptedException -> 0x0049 }
            r5.interrupt()     // Catch:{ InterruptedException -> 0x0049 }
            com.tutk.IOTC.Camera$ThreadDecodeVideo2 r5 = r2.threadDecVideo     // Catch:{ InterruptedException -> 0x0049 }
            r5.join()     // Catch:{ InterruptedException -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x005a }
        L_0x004d:
            r2.threadDecVideo = r1     // Catch:{ all -> 0x005a }
        L_0x004f:
            com.tutk.IOTC.AVFrameQueue r5 = r2.VideoFrameQueue     // Catch:{ all -> 0x005a }
            r5.removeAll()     // Catch:{ all -> 0x005a }
            goto L_0x0058
        L_0x0055:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return
        L_0x005a:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            goto L_0x005e
        L_0x005d:
            throw r5
        L_0x005e:
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tutk.IOTC.Camera.stopShow(int):void");
    }

    public void stopSpeaking(int i) {
        ThreadSendAudio threadSendAudio = this.mThreadSendAudio;
        if (threadSendAudio != null) {
            threadSendAudio.stopThread();
            try {
                this.mThreadSendAudio.interrupt();
                this.mThreadSendAudio.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.mThreadSendAudio = null;
        }
    }

    public boolean unregisterIOTCListener(IRegisterIOTCListener iRegisterIOTCListener) {
        if (!this.mIOTCListeners.contains(iRegisterIOTCListener)) {
            return false;
        }
        Log.i("IOTCamera", "unregister IOTC listener");
        this.mIOTCListeners.remove(iRegisterIOTCListener);
        return true;
    }
}
