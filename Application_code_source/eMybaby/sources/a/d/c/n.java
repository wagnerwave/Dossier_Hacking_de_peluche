package a.d.c;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public final float f2885a;

    /* renamed from: b  reason: collision with root package name */
    public final float f2886b;

    public n(float f, float f2) {
        this.f2885a = f;
        this.f2886b = f2;
    }

    public static float a(n nVar, n nVar2) {
        float f = nVar.f2885a - nVar2.f2885a;
        float f2 = nVar.f2886b - nVar2.f2886b;
        return (float) Math.sqrt((double) ((f2 * f2) + (f * f)));
    }

    public static void b(n[] nVarArr) {
        n nVar;
        n nVar2;
        n nVar3;
        float a2 = a(nVarArr[0], nVarArr[1]);
        float a3 = a(nVarArr[1], nVarArr[2]);
        float a4 = a(nVarArr[0], nVarArr[2]);
        if (a3 >= a2 && a3 >= a4) {
            nVar3 = nVarArr[0];
            nVar2 = nVarArr[1];
            nVar = nVarArr[2];
        } else if (a4 < a3 || a4 < a2) {
            nVar3 = nVarArr[2];
            nVar2 = nVarArr[0];
            nVar = nVarArr[1];
        } else {
            nVar3 = nVarArr[1];
            nVar2 = nVarArr[0];
            nVar = nVarArr[2];
        }
        float f = nVar3.f2885a;
        float f2 = nVar3.f2886b;
        if (((nVar2.f2886b - f2) * (nVar.f2885a - f)) - ((nVar2.f2885a - f) * (nVar.f2886b - f2)) < 0.0f) {
            n nVar4 = nVar;
            nVar = nVar2;
            nVar2 = nVar4;
        }
        nVarArr[0] = nVar2;
        nVarArr[1] = nVar3;
        nVarArr[2] = nVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f2885a == nVar.f2885a && this.f2886b == nVar.f2886b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f2886b) + (Float.floatToIntBits(this.f2885a) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append('(');
        sb.append(this.f2885a);
        sb.append(',');
        sb.append(this.f2886b);
        sb.append(')');
        return sb.toString();
    }
}
