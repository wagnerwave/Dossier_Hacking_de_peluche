package a.j.a;

import com.tuya.smart.common.ooO0Ooo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class a {
    public static final a f = new b().a();

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, UUID> f3697a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3698b;

    /* renamed from: c  reason: collision with root package name */
    public int f3699c;

    /* renamed from: d  reason: collision with root package name */
    public int f3700d;

    /* renamed from: e  reason: collision with root package name */
    public int f3701e;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f3702a = "telink";

        /* renamed from: b  reason: collision with root package name */
        public String f3703b = "1.0";

        /* renamed from: c  reason: collision with root package name */
        public String f3704c = "TELINK SEMICONDUCTOR (Shanghai) CO, LTD is a fabless IC design company";

        /* renamed from: d  reason: collision with root package name */
        public String f3705d = "telink_mesh1";

        /* renamed from: e  reason: collision with root package name */
        public String f3706e = ooO0Ooo.O00000o;
        public byte[] f = {-64, -63, -62, -61, -60, -59, -58, -57, -40, -39, -38, -37, -36, -35, -34, -33};
        public int g = 4354;
        public UUID h = c.TELINK_SERVICE.f3721a;
        public UUID i = c.TELINK_CHARACTERISTIC_PAIR.f3721a;
        public UUID j = c.TELINK_CHARACTERISTIC_COMMAND.f3721a;
        public UUID k = c.TELINK_CHARACTERISTIC_NOTIFY.f3721a;
        public UUID l = c.TELINK_CHARACTERISTIC_OTA.f3721a;
        public int m = 0;
        public int n = 128;

        public a a() {
            return new a(this.f3702a, this.f3703b, this.f3704c, this.f3705d, this.f3706e, this.f, this.g, this.m, this.n, this.h, this.i, this.j, this.k, this.l, (C0088a) null);
        }
    }

    public enum c {
        SERVICE("SERVICE_UUID"),
        PAIR("PAIR_UUID"),
        COMMAND("COMMAND_UUID"),
        OTA("OTA_UUID"),
        NOTIFY("NOTIFY_UUID");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f3711a;

        /* access modifiers changed from: public */
        c(String str) {
            this.f3711a = str;
        }
    }

    public a(String str, String str2, String str3, String str4, String str5, byte[] bArr, int i, int i2, int i3, UUID uuid, UUID uuid2, UUID uuid3, UUID uuid4, UUID uuid5, C0088a aVar) {
        this.f3698b = Arrays.copyOf(bArr, 16);
        this.f3699c = i;
        this.f3700d = i2;
        this.f3701e = i3;
        c(c.SERVICE.f3711a, uuid);
        c(c.PAIR.f3711a, uuid2);
        c(c.COMMAND.f3711a, uuid3);
        c(c.OTA.f3711a, uuid5);
        c(c.NOTIFY.f3711a, uuid4);
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            aVar = f;
        }
        return aVar;
    }

    public UUID b(c cVar) {
        UUID uuid;
        String str = cVar.f3711a;
        synchronized (this.f3697a) {
            uuid = this.f3697a.containsKey(str) ? this.f3697a.get(str) : null;
        }
        return uuid;
    }

    public void c(String str, UUID uuid) {
        synchronized (this.f3697a) {
            if (!this.f3697a.containsKey(str)) {
                this.f3697a.put(str, uuid);
            }
        }
    }
}
