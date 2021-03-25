package generalplus.com.GPLib;

import a.a.a.a.a;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ComAirWrapper {
    public static String[] LogString = new String[65536];
    public static Thread PlayCommandThread;
    public static Thread ReceiveCommandThread = null;
    public static Thread TestComAirStatusThread;
    public static AudioTrack aduioTarck;
    public static AudioRecord audioRecord;
    public static boolean bFindRecorderResourceType = false;
    public static boolean bRecording = false;
    public static boolean bSaveLog = false;
    public static boolean bTestComAirStatus = false;
    public static DisplayCommandValueHelper displayCmdHelper;
    public static int i32LogIndex = 0;
    public static int i32RecorderResourceType = eReocrderResourceType.eReocrderResourceType_MIC.getVal();
    public static ArrayList<byte[]> listCommandData = new ArrayList<>();
    public static int m_i32CommnadCnt = 0;
    public int decodedCmdValue = -1;
    public IOnCommandReceived listener;

    public class ComAirCommand {
        public float f32Delay;
        public int i32command;

        public ComAirCommand(int i, float f) {
            this.i32command = i;
            this.f32Delay = f;
        }
    }

    public static abstract class DisplayCommandValueHelper {
        public abstract void getCommand(int i, int i2, int i3);
    }

    public interface IOnCommandReceived {
        void onCommandReceived(int i);
    }

    public class PlayCommandRunnable implements Runnable {
        public int audioEncoding = 2;
        public int channelConfiguration = 4;
        public byte[] cmddata;
        public int minbufferSize = AudioTrack.getMinBufferSize(44100, 4, 2);
        public int samplerate = 44100;

        public PlayCommandRunnable() {
            AudioTrack unused = ComAirWrapper.aduioTarck = new AudioTrack(3, this.samplerate, this.channelConfiguration, this.audioEncoding, this.minbufferSize, 1);
            ComAirWrapper.aduioTarck.setStereoVolume(1.0f, 1.0f);
            ComAirWrapper.aduioTarck.play();
        }

        public void run() {
            while (!ComAirWrapper.listCommandData.isEmpty()) {
                ComAirWrapper.this.AddLog(" =>           PlayCommand Data ...");
                this.cmddata = (byte[]) ComAirWrapper.listCommandData.get(0);
                ComAirWrapper.listCommandData.remove(0);
                AudioTrack access$600 = ComAirWrapper.aduioTarck;
                byte[] bArr = this.cmddata;
                access$600.write(bArr, 0, bArr.length);
                this.cmddata = null;
            }
            AudioTrack unused = ComAirWrapper.aduioTarck = null;
            ComAirWrapper.PlayCommandThread = null;
        }
    }

    public class ReceiveCommandRunnable implements Runnable {
        public int audioFormat = 2;
        public short[] buffer;
        public int bufferRead;
        public int bufferSize;
        public int channelConfig = 16;
        public int i32DecodeCommand;
        public int sampleRateInHz = 44100;

        public ReceiveCommandRunnable() {
            int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
            this.bufferSize = minBufferSize;
            this.buffer = new short[minBufferSize];
            AudioRecord unused = ComAirWrapper.audioRecord = new AudioRecord(ComAirWrapper.i32RecorderResourceType, this.sampleRateInHz, this.channelConfig, this.audioFormat, this.bufferSize * 10);
            ComAirWrapper.this.AddLog(" =>      ReceiveCommandRunnable ... audioRecord status: " + ComAirWrapper.audioRecord.getState() + ", Type: " + ComAirWrapper.i32RecorderResourceType);
            if (ComAirWrapper.audioRecord.getState() == 1) {
                boolean unused2 = ComAirWrapper.bRecording = true;
                return;
            }
            boolean unused3 = ComAirWrapper.bRecording = false;
            ComAirWrapper.this.CommandDecoded(eComAirStatus.eComAirStatus_RecorderInitializationFailed.getVal());
        }

        public void run() {
            if (ComAirWrapper.audioRecord.getState() == 1) {
                ComAirWrapper.audioRecord.startRecording();
            }
            while (ComAirWrapper.bRecording) {
                ComAirWrapper.this.AddLog("=>           Recording ...");
                int read = ComAirWrapper.audioRecord.read(this.buffer, 0, this.bufferSize);
                this.bufferRead = read;
                if (read > 0) {
                    short[] sArr = new short[read];
                    System.arraycopy(this.buffer, 0, sArr, 0, read);
                    this.i32DecodeCommand = ComAirWrapper.Decode(sArr);
                    ComAirWrapper.this.listener.onCommandReceived(this.i32DecodeCommand);
                }
            }
            ComAirWrapper.this.AddLog(" =>      Stop Recording ...");
            if (ComAirWrapper.audioRecord.getState() == 1) {
                ComAirWrapper.audioRecord.stop();
                ComAirWrapper.audioRecord.release();
            }
            AudioRecord unused = ComAirWrapper.audioRecord = null;
            Thread unused2 = ComAirWrapper.ReceiveCommandThread = null;
            ComAirWrapper.this.AddLog(" =>      ReceiveCommandThread = null ...");
        }
    }

    public class TestComAirStatusRunnable implements Runnable {
        public int i32TestCommand = 15;
        public int i32TestIndex = 0;

        public TestComAirStatusRunnable() {
        }

        public void run() {
            eComAirStatus ecomairstatus;
            int i;
            DisplayCommandValueHelper displayCommandValueHelper;
            this.i32TestIndex = 0;
            boolean unused = ComAirWrapper.bTestComAirStatus = true;
            boolean unused2 = ComAirWrapper.bFindRecorderResourceType = false;
            while (ComAirWrapper.bTestComAirStatus && this.i32TestIndex < eReocrderResourceType.values().length) {
                try {
                    if (this.i32TestIndex != 0) {
                        ComAirWrapper.this.CommandDecoded(eComAirStatus.eComAirStatus_CalibrationTypeFailed.getVal());
                    }
                    int unused3 = ComAirWrapper.i32RecorderResourceType = eReocrderResourceType.values()[this.i32TestIndex].getVal();
                    while (ComAirWrapper.ReceiveCommandThread != null) {
                        ComAirWrapper.this.AddLog(" => ReceiveCommandThread != null ...");
                        Thread.sleep(10);
                    }
                    if (ComAirWrapper.ReceiveCommandThread == null) {
                        ComAirWrapper.this.AddLog(" => Create ReceiveCommandThread ... Type: " + ComAirWrapper.i32RecorderResourceType);
                        Thread unused4 = ComAirWrapper.ReceiveCommandThread = new Thread(new ReceiveCommandRunnable());
                        ComAirWrapper.ReceiveCommandThread.start();
                    }
                    while (ComAirWrapper.audioRecord == null && ComAirWrapper.audioRecord.getRecordingState() != 3) {
                        ComAirWrapper.this.AddLog(" => audioRecord == null && audioRecord.getRecordingState() != AudioRecord.RECORDSTATE_RECORDING ...");
                        Thread.sleep(10);
                    }
                    Thread.sleep(10);
                    if (ComAirWrapper.audioRecord != null) {
                        ComAirWrapper.this.AddLog(" => PlayComAirCmd ... CMD: 0x" + Integer.toHexString(this.i32TestCommand));
                        ComAirWrapper.this.PlayComAirCmd(this.i32TestCommand, 1.0f);
                        while (ComAirWrapper.aduioTarck != null) {
                            ComAirWrapper.this.AddLog(" => aduioTarck != null ... ");
                            Thread.sleep(100);
                        }
                        Thread.sleep(500);
                    }
                    if (ComAirWrapper.ReceiveCommandThread != null) {
                        ComAirWrapper.this.AddLog(" => Release ReceiveCommandThread ... ");
                        boolean unused5 = ComAirWrapper.bRecording = false;
                    }
                    this.i32TestIndex++;
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            if (ComAirWrapper.displayCmdHelper != null) {
                if (ComAirWrapper.bFindRecorderResourceType) {
                    displayCommandValueHelper = ComAirWrapper.displayCmdHelper;
                    i = this.i32TestCommand;
                    ecomairstatus = eComAirStatus.eComAirStatus_CalibrationProcessSuccess;
                } else {
                    displayCommandValueHelper = ComAirWrapper.displayCmdHelper;
                    i = this.i32TestCommand;
                    ecomairstatus = eComAirStatus.eComAirStatus_CalibrationProcessFailed;
                }
                displayCommandValueHelper.getCommand(0, i, ecomairstatus.getVal());
            }
            ComAirWrapper.this.StopComAirDecodeProcess();
            ComAirWrapper.TestComAirStatusThread = null;
            ComAirWrapper.this.AddLog(" => TestComAirStatusThread = null ...");
            if (ComAirWrapper.bSaveLog) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
                String str = Environment.getExternalStorageDirectory().getPath() + "/ComAir_" + simpleDateFormat.format(date) + "_WrapperLog.txt";
                String str2 = "";
                for (int i2 = 0; i2 < ComAirWrapper.i32LogIndex; i2++) {
                    StringBuilder n = a.n(str2);
                    n.append(ComAirWrapper.LogString[i2]);
                    str2 = n.toString();
                }
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                try {
                    FileWriter fileWriter = new FileWriter(str);
                    fileWriter.write(str2);
                    fileWriter.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public enum eAudioDecodeMode {
        eDecodeMode_1Sec(1),
        eDecodeMode_05Sec(2);
        
        public final int val;

        /* access modifiers changed from: public */
        eAudioDecodeMode(int i) {
            this.val = i;
        }

        public int getVal() {
            return this.val;
        }
    }

    public enum eAudioEncodeMode {
        eEncodeMode_1Sec(24),
        eEncodeMode_05Sec(48);
        
        public final int val;

        /* access modifiers changed from: public */
        eAudioEncodeMode(int i) {
            this.val = i;
        }

        public int getVal() {
            return this.val;
        }
    }

    public enum eComAirErrCode {
        COMAIR_NOERR,
        COMAIR_AUDIOUINTFAILED,
        COMAIR_ENABLEIORECFAILED,
        COMAIR_SETFORMATFAILED,
        COMAIR_SETRECCALLBACKFAILED,
        COMAIR_ALLOCBUFFAILED,
        COMAIR_AUDIONOTINIT,
        COMAIR_UNSUPPORTMODE,
        COMAIR_UNSUPPORTTHRESHOLD,
        COMAIR_SETREGCODEFAILED,
        COMAIR_PLAYCOMAIRSOUNDFAILED,
        COMAIR_PROPERTYNOTFOUND,
        COMAIR_PROPERTYOPERATIONFAILED
    }

    public enum eComAirProperty {
        eComAirProperty_RegCode,
        eComAirProperty_CentralFreq,
        eComAirProperty_iDfValue,
        eComAirProperty_Threshold,
        eComAirProperty_VolumeCtrl,
        eComAirProperty_WaveFormType
    }

    public enum eComAirPropertyTarget {
        eComAirPropertyTarget_Both,
        eComAirPropertyTarget_Encode,
        eComAirPropertyTarget_Decode
    }

    public enum eComAirStatus {
        eComAirStatus_DecodeCommand(65520),
        eComAirStatus_CalibrationTypeFailed(65521),
        eComAirStatus_CalibrationProcessFailed(65522),
        eComAirStatus_CalibrationProcessSuccess(65523),
        eComAirStatus_RecorderInitializationFailed(65524);
        
        public final int val;

        /* access modifiers changed from: public */
        eComAirStatus(int i) {
            this.val = i;
        }

        public int getVal() {
            return this.val;
        }
    }

    public enum eReocrderResourceType {
        eReocrderResourceType_Default(0),
        eReocrderResourceType_MIC(1),
        eReocrderResourceType_VOICE_RECOGNITION(6),
        eReocrderResourceType_CAMCORDER(5),
        eReocrderResourceType_VOICE_UPLINK(2),
        eReocrderResourceType_VOICE_DOWNLINK(3),
        eReocrderResourceType_VOICE_CALL(4);
        
        public final int val;

        /* access modifiers changed from: public */
        eReocrderResourceType(int i) {
            this.val = i;
        }

        public int getVal() {
            return this.val;
        }
    }

    static {
        try {
            Log.i("JNI", "Trying to load .so ...");
            System.loadLibrary("GPLibComAir");
        } catch (UnsatisfiedLinkError e2) {
            Log.e("JNI", "Cannot load .so ...");
            e2.printStackTrace();
        }
        return;
    }

    public static native int Decode(short[] sArr);

    public static native byte[] GenerateComAirCmdList(int i, ComAirCommand[] comAirCommandArr);

    public static native byte[] GenerateComAirCommand(int i);

    public static native int InitComAirAudio();

    public static native int StartComAirDecode();

    public static native int StopComAirDecode();

    public static native int UninitComAirAudio();

    public void AddLog(String str) {
        String[] strArr = LogString;
        int i = i32LogIndex;
        i32LogIndex = i + 1;
        strArr[i % 65536] = String.valueOf(System.currentTimeMillis()) + ": " + str + "\n";
    }

    public void CommandDecoded(int i) {
        DisplayCommandValueHelper displayCommandValueHelper;
        eComAirStatus ecomairstatus;
        int i2;
        this.decodedCmdValue = i;
        StringBuilder n = a.n(" =>      CommandDecoded ... CMD = 0x");
        n.append(Integer.toHexString(this.decodedCmdValue));
        AddLog(n.toString());
        if (bTestComAirStatus && eComAirStatus.eComAirStatus_RecorderInitializationFailed.getVal() != this.decodedCmdValue && eComAirStatus.eComAirStatus_CalibrationTypeFailed.getVal() != this.decodedCmdValue) {
            bFindRecorderResourceType = true;
            bTestComAirStatus = false;
        } else if (displayCmdHelper != null) {
            if (this.decodedCmdValue == eComAirStatus.eComAirStatus_RecorderInitializationFailed.getVal()) {
                displayCommandValueHelper = displayCmdHelper;
                i2 = this.decodedCmdValue;
                ecomairstatus = eComAirStatus.eComAirStatus_RecorderInitializationFailed;
            } else if (this.decodedCmdValue == eComAirStatus.eComAirStatus_CalibrationTypeFailed.getVal()) {
                displayCommandValueHelper = displayCmdHelper;
                i2 = this.decodedCmdValue;
                ecomairstatus = eComAirStatus.eComAirStatus_CalibrationTypeFailed;
            } else {
                displayCmdHelper.getCommand(m_i32CommnadCnt, this.decodedCmdValue, eComAirStatus.eComAirStatus_DecodeCommand.getVal());
                m_i32CommnadCnt++;
                return;
            }
            displayCommandValueHelper.getCommand(0, i2, ecomairstatus.getVal());
        }
    }

    public native int GetComAirDecodeMode();

    public native int GetComAirEncodeMode();

    public native int GetComAirProperty(int i, int i2);

    public int GetComAirRecorderResourceType() {
        return i32RecorderResourceType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = listCommandData;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean IsComAirCmdPlaying() {
        /*
            r2 = this;
            java.lang.Thread r0 = PlayCommandThread
            r1 = 0
            if (r0 == 0) goto L_0x0013
            java.util.ArrayList<byte[]> r0 = listCommandData
            if (r0 != 0) goto L_0x000a
            goto L_0x0013
        L_0x000a:
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0011
            return r1
        L_0x0011:
            r0 = 1
            return r0
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: generalplus.com.GPLib.ComAirWrapper.IsComAirCmdPlaying():boolean");
    }

    public boolean IsComAirReceiving() {
        return ReceiveCommandThread != null;
    }

    public void PlayComAirCmd(int i, float f) {
        byte[] GenerateComAirCommand = GenerateComAirCommand(i);
        if (GenerateComAirCommand.length == 1) {
            StringBuilder n = a.n(" err =");
            n.append(GenerateComAirCommand[0]);
            Log.d("Encode Error", n.toString());
            return;
        }
        synchronized (listCommandData) {
            listCommandData.add(GenerateComAirCommand);
        }
        if (PlayCommandThread == null) {
            AddLog(" =>      Create PlayCommandThread ...");
            Thread thread = new Thread(new PlayCommandRunnable());
            PlayCommandThread = thread;
            thread.start();
        }
    }

    public void PlayComAirCmdList(int i, ComAirCommand[] comAirCommandArr, float f) {
        byte[] GenerateComAirCmdList = GenerateComAirCmdList(i, comAirCommandArr);
        if (GenerateComAirCmdList.length == 1) {
            StringBuilder n = a.n(" err =");
            n.append(GenerateComAirCmdList[0]);
            Log.d("Encode Error", n.toString());
            return;
        }
        synchronized (listCommandData) {
            listCommandData.add(GenerateComAirCmdList);
        }
        if (PlayCommandThread == null) {
            Thread thread = new Thread(new PlayCommandRunnable());
            PlayCommandThread = thread;
            thread.start();
        }
    }

    public native int SetComAirDecodeMode(int i);

    public native int SetComAirEncodeMode(int i);

    public native int SetComAirProperty(int i, int i2, Object obj);

    public void SetDisplayCommandValueHelper(DisplayCommandValueHelper displayCommandValueHelper) {
        displayCmdHelper = displayCommandValueHelper;
    }

    public native int SetSaveRawData(boolean z);

    public int StartComAirDecodeProcess() {
        InitComAirAudio();
        int StartComAirDecode = StartComAirDecode();
        eComAirErrCode ecomairerrcode = eComAirErrCode.COMAIR_NOERR;
        if (StartComAirDecode == 0) {
            m_i32CommnadCnt = 0;
            if (ReceiveCommandThread == null) {
                Thread thread = new Thread(new ReceiveCommandRunnable());
                ReceiveCommandThread = thread;
                thread.start();
            }
        }
        return StartComAirDecode;
    }

    public int StopComAirDecodeProcess() {
        int StopComAirDecode = StopComAirDecode();
        eComAirErrCode ecomairerrcode = eComAirErrCode.COMAIR_NOERR;
        if (StopComAirDecode == 0) {
            if (ReceiveCommandThread != null) {
                bRecording = false;
            }
            UninitComAirAudio();
        }
        return StopComAirDecode;
    }

    public void TestComAirStatus(boolean z) {
        bSaveLog = z;
        i32LogIndex = 0;
        AddLog("TestComAirStatus...");
        i32RecorderResourceType = eReocrderResourceType.values()[0].getVal();
        InitComAirAudio();
        StartComAirDecode();
        if (TestComAirStatusThread == null) {
            AddLog("New TestComAirStatusThread ...");
            Thread thread = new Thread(new TestComAirStatusRunnable());
            TestComAirStatusThread = thread;
            thread.start();
        }
    }

    public void setListener(IOnCommandReceived iOnCommandReceived) {
        this.listener = iOnCommandReceived;
    }
}
