package a.h.a.n0;

import android.graphics.Bitmap;
import android.support.v4.media.session.PlaybackStateCompat;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.tutk.IOTC.Camera;
import com.tutk.IOTC.IRegisterIOTCListener;
import com.tutk.IOTC.Packet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class c extends Camera implements IRegisterIOTCListener {

    /* renamed from: a  reason: collision with root package name */
    public int f3530a;

    /* renamed from: b  reason: collision with root package name */
    public String f3531b;

    /* renamed from: c  reason: collision with root package name */
    public String f3532c;

    /* renamed from: d  reason: collision with root package name */
    public String f3533d;

    /* renamed from: e  reason: collision with root package name */
    public int f3534e = 0;
    public boolean f;
    public boolean g;
    public UUID h = UUID.randomUUID();
    public List<AVIOCTRLDEFs.SStreamDef> i = Collections.synchronizedList(new ArrayList());

    public c(String str, String str2, String str3, String str4) {
        this.f3531b = str2;
        this.f3532c = str3;
        this.f3533d = str4;
        registerIOTCListener(this);
    }

    public boolean a(int i2) {
        return (getChannelServiceType(i2) & 16) == 0;
    }

    public String b() {
        return this.h.toString();
    }

    public void c(int i2) {
        super.start(i2, this.f3532c, this.f3533d);
    }

    public void connect(String str, String str2) {
        super.connect(str, str2);
        this.f3531b = str;
    }

    public void disconnect() {
        super.disconnect();
        this.i.clear();
    }

    public void receiveChannelInfo(Camera camera, int i2, int i3) {
    }

    public void receiveFrameData(Camera camera, int i2, Bitmap bitmap) {
    }

    public void receiveFrameInfo(Camera camera, int i2, long j, int i3, int i4, int i5, int i6) {
    }

    public void receiveIOCtrlData(Camera camera, int i2, int i3, byte[] bArr) {
        boolean z = true;
        if (i3 == 809) {
            this.i.clear();
            int byteArrayToInt_Little = Packet.byteArrayToInt_Little(bArr, 0);
            if (i2 == 0) {
                if ((getChannelServiceType(0) & PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != 0) {
                    z = false;
                }
                if (z) {
                    for (int i4 = 0; i4 < byteArrayToInt_Little; i4++) {
                        byte[] bArr2 = new byte[8];
                        System.arraycopy(bArr, (i4 * 8) + 4, bArr2, 0, 8);
                        AVIOCTRLDEFs.SStreamDef sStreamDef = new AVIOCTRLDEFs.SStreamDef(bArr2);
                        this.i.add(sStreamDef);
                        camera.start(sStreamDef.channel, this.f3532c, this.f3533d);
                    }
                }
            }
        } else if (i3 == 8191) {
            int byteArrayToInt_Little2 = Packet.byteArrayToInt_Little(bArr, 12);
            if (byteArrayToInt_Little2 == 1) {
                if (!this.f) {
                    this.f3534e++;
                }
                this.f = true;
            } else if (byteArrayToInt_Little2 == 4) {
                this.f = false;
            } else if (byteArrayToInt_Little2 == 3) {
                if (!this.g) {
                    this.f3534e++;
                }
                this.g = true;
            } else if (byteArrayToInt_Little2 == 6) {
                this.g = false;
            }
        }
    }

    public void receiveSessionInfo(Camera camera, int i2) {
    }
}
