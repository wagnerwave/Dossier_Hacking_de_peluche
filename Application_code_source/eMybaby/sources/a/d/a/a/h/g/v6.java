package a.d.a.a.h.g;

public final class v6 implements x7 {

    /* renamed from: b  reason: collision with root package name */
    public static final f7 f1987b = new y6();

    /* renamed from: a  reason: collision with root package name */
    public final f7 f1988a;

    public v6() {
        f7 f7Var;
        f7[] f7VarArr = new f7[2];
        f7VarArr[0] = z5.f2056a;
        try {
            f7Var = (f7) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            f7Var = f1987b;
        }
        f7VarArr[1] = f7Var;
        x6 x6Var = new x6(f7VarArr);
        a6.f(x6Var, "messageInfoFactory");
        this.f1988a = x6Var;
    }
}
